package saidivyatejas3466626.developed.firstaidapp

import android.app.Activity
import android.os.Bundle
import android.widget.Toast
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
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Slider
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
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
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

class SymptomCheckerActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            SymptomCheckerScreen()
        }
    }
}

@Composable
fun SymptomCheckerScreen() {
    val context = LocalContext.current as Activity

    var age by remember { mutableStateOf("") }
    var gender by remember { mutableStateOf("") }
    var selectedSymptoms by remember { mutableStateOf(listOf<String>()) }
    var symptomQuery by remember { mutableStateOf("") }
    var duration by remember { mutableStateOf("") }
    var painLevel by remember { mutableStateOf(0f) }
    var allergies by remember { mutableStateOf("") }

    var showResult by remember { mutableStateOf(false) }
    var diagnosis by remember { mutableStateOf("") }
    var firstAid by remember { mutableStateOf("") }

    val allSymptoms = listOf(
        "Fever", "Cough", "Headache", "Nausea", "Vomiting",
        "Fatigue", "Shortness of breath", "Sore throat", "Dizziness", "Chest pain"
    )

    val genders = listOf("Male", "Female", "Other")

    if (!showResult) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .background(Color.White)
        ) {

            // AppBar
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
                    text = "Symptom Checker",
                    style = MaterialTheme.typography.headlineSmall.copy(
                        fontWeight = FontWeight.Bold,
                        color = Color.Black
                    )
                )
            }

            // Scrollable Form
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(16.dp)
                    .verticalScroll(rememberScrollState())
            ) {

                // AGE
                OutlinedTextField(
                    value = age,
                    onValueChange = { age = it },
                    label = { Text("Age") },
                    keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
                    modifier = Modifier.fillMaxWidth()
                )

                Spacer(modifier = Modifier.height(16.dp))

                // GENDER
                Text("Gender", fontSize = 18.sp, modifier = Modifier.padding(bottom = 8.dp))
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceEvenly
                ) {
                    genders.forEach { gen ->
                        Button(
                            onClick = { gender = gen },
                            colors = ButtonDefaults.buttonColors(
                                containerColor = if (gender == gen) Color(0xFF4CAF50) else Color.LightGray
                            ),
                            shape = MaterialTheme.shapes.small
                        ) {
                            Text(text = gen)
                        }
                    }
                }

                Spacer(modifier = Modifier.height(20.dp))

                // SYMPTOMS SEARCH
                OutlinedTextField(
                    value = symptomQuery,
                    onValueChange = { symptomQuery = it },
                    label = { Text("Search Symptoms") },
                    modifier = Modifier.fillMaxWidth()
                )

                Spacer(modifier = Modifier.height(8.dp))

                // Symptom list with "Select" button
                val filteredSymptoms = allSymptoms.filter {
                    it.contains(symptomQuery, ignoreCase = true) && it !in selectedSymptoms
                }

                filteredSymptoms.forEach { symptom ->
                    Row(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(vertical = 4.dp)
                            .background(Color(0xFFF1F1F1)),
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Text(
                            text = symptom,
                            modifier = Modifier
                                .padding(12.dp)
                                .weight(1f),
                            color = Color.Black
                        )

                        Button(
                            onClick = {
                                selectedSymptoms = selectedSymptoms + symptom
                                symptomQuery = ""
                            },
                            shape = MaterialTheme.shapes.small,
                            colors = ButtonDefaults.buttonColors(
                                containerColor = Color(0xFF2196F3),
                                contentColor = Color.White
                            ),
                            modifier = Modifier.padding(end = 8.dp)
                        ) {
                            Text(text = "Select")
                        }
                    }
                }

                Spacer(modifier = Modifier.height(16.dp))

                // Selected Symptoms
                if (selectedSymptoms.isNotEmpty()) {
                    Text(
                        "Selected Symptoms:",
                        fontSize = 18.sp,
                        modifier = Modifier.padding(bottom = 8.dp)
                    )
                    selectedSymptoms.forEach { symptom ->
                        Text("- $symptom", color = Color.Black)
                    }
                }

                Spacer(modifier = Modifier.height(20.dp))

                // Duration
                OutlinedTextField(
                    value = duration,
                    onValueChange = { duration = it },
                    label = { Text("Duration of Symptoms (e.g., 2 days)") },
                    modifier = Modifier.fillMaxWidth()
                )

                Spacer(modifier = Modifier.height(20.dp))

                // Pain Level
                Text(
                    "Pain Level: ${
                        when (painLevel.toInt()) {
                            in 0..3 -> "Mild"
                            in 4..7 -> "Moderate"
                            else -> "Severe"
                        }
                    }", fontSize = 18.sp
                )

                Slider(
                    value = painLevel,
                    onValueChange = { painLevel = it },
                    valueRange = 0f..10f,
                    steps = 9,
                    modifier = Modifier.fillMaxWidth()
                )

                Spacer(modifier = Modifier.height(20.dp))

                // Allergies
                OutlinedTextField(
                    value = allergies,
                    onValueChange = { allergies = it },
                    label = { Text("Allergies (if any)") },
                    modifier = Modifier.fillMaxWidth()
                )

                Spacer(modifier = Modifier.height(32.dp))

                // Submit Button
                Button(
                    onClick = {
                        if (age.isNotEmpty() && gender.isNotEmpty() && selectedSymptoms.isNotEmpty() && duration.isNotEmpty()) {
                            val result = diagnose(selectedSymptoms)
                            diagnosis = result.first
                            firstAid = result.second
                            showResult = true
                        } else {
                            Toast.makeText(
                                context,
                                "Please fill all required fields",
                                Toast.LENGTH_SHORT
                            ).show()
                        }
                    },
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(50.dp),
                    colors = ButtonDefaults.buttonColors(
                        containerColor = Color(0xFF4CAF50)
                    )
                ) {
                    Text(text = "Submit", fontSize = 18.sp)
                }
            }
        }
    } else {
        DiagnosisResultScreen(
            diagnosis = diagnosis,
            firstAid = firstAid,
            onBack = { showResult = false }
        )
    }
}


@Composable
fun DiagnosisResultScreen(diagnosis: String, firstAid: String, onBack: () -> Unit) {

    val context = LocalContext.current as Activity

    Column(
        modifier = Modifier
            .fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally
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
                text = "Result",
                style = MaterialTheme.typography.headlineSmall.copy(
                    fontWeight = FontWeight.Bold,
                    color = Color.Black
                )
            )
        }
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(12.dp)
        ) {


            Text(text = "Possible Illness:", fontSize = 22.sp, color = Color.Red)
            Spacer(modifier = Modifier.height(8.dp))
            Text(text = diagnosis, fontSize = 18.sp, color = Color.Black)

            Spacer(modifier = Modifier.height(24.dp))

            Text(text = "First Aid Suggestions:", fontSize = 22.sp, color = Color.Blue)
            Spacer(modifier = Modifier.height(8.dp))
            Text(text = firstAid, fontSize = 18.sp, color = Color.Black)

            Spacer(modifier = Modifier.height(32.dp))

            Button(onClick = { onBack() }) {
                Text("Back to Form")
            }
        }
    }
}

// Diagnosis Logic
fun diagnose(symptoms: List<String>): Pair<String, String> {
    return when {
        symptoms.containsAll(listOf("Fever", "Cough", "Fatigue")) -> {
            "Possible Flu or Viral Infection" to "Rest well, stay hydrated, take paracetamol if fever is high, consult doctor if worsens."
        }

        symptoms.containsAll(listOf("Chest pain", "Shortness of breath")) -> {
            "Possible Heart Issue" to "Call emergency services immediately. Keep patient calm and sitting upright."
        }

        symptoms.containsAll(listOf("Headache", "Dizziness")) -> {
            "Possible Migraine or Dehydration" to "Sit in dark quiet room, drink water, avoid stress, take prescribed medications."
        }

        symptoms.containsAll(listOf("Nausea", "Vomiting")) -> {
            "Possible Food Poisoning" to "Avoid solid food, sip water, oral rehydration, visit doctor if persists."
        }

        else -> {
            "General Illness" to "Monitor symptoms, drink fluids, take rest, consult doctor if no improvement."
        }
    }
}
