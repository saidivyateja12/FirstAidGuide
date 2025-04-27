package saidivyatejas3466626.developed.firstaidapp

import android.app.Activity
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateMapOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp


class FirstAidGuidelinesActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            FirstAidGuideHomeScreen()
        }
    }
}


@Composable
fun FirstAidGuideHomeScreen() {
    val context = LocalContext.current as Activity

    var searchQuery by remember { mutableStateOf("") }
    var expandedCategory by remember { mutableStateOf<String?>(null) }
    val expandedPrecautions = remember { mutableStateMapOf<String, Boolean>() }

    val allData = sampleData()

    val filteredData = if (searchQuery.isEmpty()) {
        allData
    } else {
        allData.mapNotNull { category ->
            val filteredSubcategories = category.subcategories.filter {
                it.title.contains(searchQuery, ignoreCase = true)
            }
            if (filteredSubcategories.isNotEmpty()) {
                category.copy(subcategories = filteredSubcategories)
            } else null
        }
    }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.White)
            .verticalScroll(rememberScrollState())

    ) {


        Row(
            modifier = Modifier
                .fillMaxWidth()
                .background(color = colorResource(id = R.color.app_bar_color))
                .padding(horizontal = 12.dp, vertical = 8.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Image(
                painter = painterResource(id = R.drawable.back),
                contentDescription = "Back",
                modifier = Modifier
                    .size(36.dp)
                    .clickable { context.finish() }
            )

            Spacer(modifier = Modifier.width(12.dp))

            Text(
                text = "First Aid Assistance",
                style = MaterialTheme.typography.headlineSmall.copy(
                    fontWeight = FontWeight.Bold,
                    color = Color.Black
                )
            )
        }

        Spacer(modifier = Modifier.height(16.dp))

        OutlinedTextField(
            value = searchQuery,
            onValueChange = { searchQuery = it },
            label = { Text("Search Conditions") },
            modifier = Modifier.fillMaxWidth().padding(horizontal = 12.dp)
        )

        Spacer(modifier = Modifier.height(16.dp))

        filteredData.forEach { category ->
            CategoryCard(
                category = category,
                isExpanded = expandedCategory == category.title,
                expandedPrecautions = expandedPrecautions,
                onExpandToggle = {
                    expandedCategory = if (expandedCategory == category.title) null else category.title
                }
            )
            Spacer(modifier = Modifier.height(12.dp))
        }
    }
}

@Composable
fun CategoryCard(
    category: FirstAidCategory,
    isExpanded: Boolean,
    expandedPrecautions: MutableMap<String, Boolean>,
    onExpandToggle: () -> Unit
) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 12.dp)
            .clickable { onExpandToggle() },
        shape = RoundedCornerShape(12.dp),
        colors = CardDefaults.cardColors(
            containerColor = Color(0xFFF5F5F5)
        ),
        elevation = CardDefaults.cardElevation(defaultElevation = 4.dp)
    ) {
        Column(modifier = Modifier.padding(16.dp)) {
            Text(
                category.title,
                style = MaterialTheme.typography.titleMedium.copy(fontWeight = FontWeight.Bold),
                color = Color(0xFF1B5E20)
            )
            if (isExpanded) {
                Spacer(modifier = Modifier.height(8.dp))
                category.subcategories.forEach { subcategory ->
                    SubcategoryItem(
                        subcategory = subcategory,
                        expandedPrecautions = expandedPrecautions
                    )
                }
            }
        }
    }
}

@Composable
fun SubcategoryItem(
    subcategory: Subcategory,
    expandedPrecautions: MutableMap<String, Boolean>
) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(start = 8.dp, top = 8.dp, bottom = 8.dp)
    ) {
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Text(
                "• ${subcategory.title}",
                style = MaterialTheme.typography.bodyMedium,
                color = Color.Black,
                maxLines = 2,
                overflow = TextOverflow.Ellipsis,
                modifier = Modifier.weight(1f)
            )
            Spacer(modifier = Modifier.width(8.dp))
            TextButton(
                onClick = {
                    expandedPrecautions[subcategory.title] =
                        !(expandedPrecautions[subcategory.title] ?: false)
                }
            ) {
                Text(
                    if (expandedPrecautions[subcategory.title] == true) "Hide" else "See Precautions",
                    style = MaterialTheme.typography.labelMedium
                )
            }
        }

        if (expandedPrecautions[subcategory.title] == true) {
            Spacer(modifier = Modifier.height(6.dp))
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .background(Color(0xFFE8F5E9), RoundedCornerShape(8.dp))
                    .padding(12.dp)
            ) {
                subcategory.precautions.forEach { precaution ->
                    Text(
                        "• $precaution",
                        style = MaterialTheme.typography.bodySmall,
                        color = Color.DarkGray,
                        modifier = Modifier.padding(bottom = 4.dp)
                    )
                }
            }
        }
    }
}

data class FirstAidCategory(
    val title: String,
    val subcategories: List<Subcategory>
)

data class Subcategory(
    val title: String,
    val precautions: List<String>
)

fun sampleData() = listOf(
    FirstAidCategory(
        title = "Bleeding & Wound Care",
        subcategories = listOf(
            Subcategory("Minor Bleeding (Cuts & Grazes)", listOf("Clean the wound gently.", "Apply sterile dressing.", "Watch for infection signs.")),
            Subcategory("Severe Bleeding", listOf("Apply firm pressure above the wound.", "Call emergency services immediately.", "Do not remove embedded objects.")),
            Subcategory("Nosebleeds", listOf("Lean forward, pinch the soft part of the nose.", "Avoid tilting head back.")),
            Subcategory("Internal Bleeding (Signs Only)", listOf("Look for signs like bruising, swelling, weakness.", "Seek immediate medical help.")),
            Subcategory("Bleeding with Embedded Object", listOf("Do not remove the object.", "Apply padding around it and control bleeding gently.")),
            Subcategory("Bleeding After Tooth Loss", listOf("Bite on clean gauze.", "Apply pressure and visit dentist promptly."))
        )
    ),
    FirstAidCategory(
        title = "Breathing Issues",
        subcategories = listOf(
            Subcategory("Asthma Attack", listOf("Assist with inhaler use.", "Call emergency services if unresponsive.")),
            Subcategory("Hyperventilation (Panic Breathing)", listOf("Help the person breathe slowly into a paper bag if advised.", "Stay calm and reassure.")),
            Subcategory("Choking (Airway Blockage)", listOf("Perform back blows and abdominal thrusts.", "Different method for infants.")),
            Subcategory("Anaphylaxis (Severe Allergic Reaction)", listOf("Use EpiPen immediately.", "Call emergency help immediately.")),
            Subcategory("Breathing Stopped (Start CPR)", listOf("Begin CPR with rescue breaths.", "Use AED if available.")),
            Subcategory("Smoke Inhalation", listOf("Move the person to fresh air.", "Call for medical assistance immediately.")),
            Subcategory("Shortness of Breath (Non-Emergency Causes)", listOf("Rest, breathe deeply.", "Seek medical advice if persists.")),
            Subcategory("Chest Pain with Breathing Difficulty", listOf("Suspect heart attack.", "Call emergency services immediately.")),
            Subcategory("Collapsed Lung / Punctured Chest (Info Only)", listOf("Recognize symptoms like chest pain and breathing issues.", "Immediate medical emergency."))
        )
    ),
    FirstAidCategory(
        title = "Fractures",
        subcategories = listOf(
            Subcategory("Closed (Simple) Fracture", listOf("Immobilize the injured area.", "Apply cold pack wrapped in cloth.")),
            Subcategory("Open (Compound) Fracture", listOf("Do not push the bone inside.", "Control bleeding around wound.")),
            Subcategory("Dislocation (Joint Out of Place)", listOf("Do not reposition.", "Immobilize and seek medical help.")),
            Subcategory("Suspected Spinal/Neck Fracture", listOf("Do not move person.", "Support head and call emergency services.")),
            Subcategory("Greenstick Fracture (Common in Children)", listOf("Immobilize gently.", "Seek pediatric evaluation.")),
            Subcategory("Skull Fracture (Info Only)", listOf("Look for signs: unconsciousness, clear fluid from nose/ears.", "Call emergency immediately.")),
            Subcategory("Stress Fracture (Overuse Injury)", listOf("Rest and avoid pressure.", "Seek medical advice."))
        )
    ),
    // 🔥 NEW: Life-Threatening Emergencies
    FirstAidCategory(
        title = "Life-Threatening Emergencies",
        subcategories = listOf(
            Subcategory("Cardiac Arrest", listOf("Start CPR immediately.", "Use AED if available.", "Call emergency services.")),
            Subcategory("Stroke Symptoms", listOf("Use FAST test: Face drooping, Arm weakness, Speech difficulty, Time to call help.", "Call ambulance immediately.")),
            Subcategory("Severe Allergic Reaction (Anaphylaxis)", listOf("Use EpiPen immediately.", "Lay person flat.", "Call ambulance urgently.")),
            Subcategory("Major Trauma / Head Injury", listOf("Do not move unless in danger.", "Call emergency services immediately.", "Stop any bleeding without pressing on injury.")),
            Subcategory("Drowning", listOf("Remove from water safely.", "Start CPR immediately if unconscious.", "Call emergency services.")),
            Subcategory("Severe Burns", listOf("Cool burn under running water for 20 minutes.", "Cover with sterile dressing.", "Do not apply creams.")),
            Subcategory("Unconsciousness", listOf("Check breathing.", "Put in recovery position if breathing.", "Start CPR if not breathing.")),
            Subcategory("Severe Shock", listOf("Lay the person flat.", "Keep warm.", "Call emergency services.")),
            Subcategory("Poisoning", listOf("Identify poison if possible.", "Call poison control or emergency services.", "Do not induce vomiting unless told to."))
        )
    ),
    // 🔥 NEW: Mental Health First Aid
    FirstAidCategory(
        title = "Mental Health First Aid",
        subcategories = listOf(
            Subcategory("Panic Attack", listOf("Stay calm.", "Encourage slow breathing.", "Reassure the person they are safe.")),
            Subcategory("Suicidal Thoughts", listOf("Stay with the person.", "Listen without judgment.", "Seek immediate professional help.")),
            Subcategory("Severe Anxiety", listOf("Encourage grounding techniques.", "Help focus on breathing.", "Reassure and avoid crowding them.")),
            Subcategory("Depression Episode", listOf("Offer emotional support.", "Encourage professional help.", "Avoid giving simplistic advice.")),
            Subcategory("Psychotic Episode", listOf("Do not argue with delusions.", "Stay calm and non-threatening.", "Call emergency services if necessary.")),
            Subcategory("Substance Overdose", listOf("Call emergency services immediately.", "Do not leave them alone.", "If unconscious, check breathing and prepare for CPR.")),
            Subcategory("Aggressive Behavior (Mental Health Crisis)", listOf("Keep safe distance.", "Use calm voice.", "Call emergency services if needed."))
        )
    )
)


