package saidivyatejas3466626.developed.firstaidapp

import android.app.Activity
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.asPaddingValues
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.systemBars
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
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
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

class ViewGuidelinesActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            FirstAidHomeScreen()
        }
    }
}


@Composable
fun FirstAidHomeScreen() {
    var searchQuery by remember { mutableStateOf("") }

    val context = LocalContext.current as Activity

    val categories = listOf("Bleeding", "Breathing Issues", "Fractures")
    val emergencyConditions = listOf(
        "Cardiac Arrest", "Choking", "Stroke", "Heart Attack",
        "Severe Bleeding", "Shock", "Seizure", "Drowning",
        "Anaphylaxis", "Unconsciousness / Fainting"
    )

    val precautionaryTips = listOf(
        "Ensure Scene Safety First",
        "Use PPE",
        "Call Emergency Services Early",
        "Stay Calm and Focused",
        "Avoid Performing Untrained Medical Procedures"
    )

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(WindowInsets.systemBars.asPaddingValues())
    ) {

        Row(
            modifier = Modifier
                .fillMaxWidth()
                .background(color = colorResource(id = R.color.app_bar_color))
                .padding(horizontal = 12.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {

            Image(
                modifier = Modifier
                    .clickable {
                        context.finish()
                    }
                    .size(36.dp),
                painter = painterResource(id = R.drawable.back),
                contentDescription = "Back"
            )

            Spacer(modifier = Modifier.width(12.dp))

            Text(
                modifier = Modifier
                    .padding(12.dp),
                text = "View Guidelines",
                style = MaterialTheme.typography.headlineSmall.copy(
                    color = Color.Black,
                    fontWeight = FontWeight.Bold
                )
            )


        }

        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(12.dp)
        ) {


            Text("First Aid Assistant", fontSize = 24.sp, fontWeight = FontWeight.Bold)

            Spacer(modifier = Modifier.height(16.dp))

            OutlinedTextField(
                value = searchQuery,
                onValueChange = { searchQuery = it },
                label = { Text("Search Conditions") },
                modifier = Modifier.fillMaxWidth()
            )

            Spacer(modifier = Modifier.height(12.dp))

            Button(
                onClick = { /* Emergency Call */ },
                colors = ButtonDefaults.buttonColors(containerColor = Color.Red),
                modifier = Modifier.fillMaxWidth()
            ) {
                Text("Emergency Call", color = Color.White)
            }

            Spacer(modifier = Modifier.height(24.dp))

            Text("Categories", fontSize = 20.sp, fontWeight = FontWeight.SemiBold)

            LazyColumn(modifier = Modifier.fillMaxHeight(0.3f)) {
                items(categories) { category ->
                    Text(
                        text = category,
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(vertical = 8.dp)
                            .clickable { /* Navigate to category details */ },
                        fontSize = 18.sp
                    )
                }
            }

            Spacer(modifier = Modifier.height(16.dp))

            Text("Life-Threatening Conditions", fontSize = 18.sp, fontWeight = FontWeight.SemiBold)

            LazyColumn(modifier = Modifier.fillMaxHeight(0.3f)) {
                items(emergencyConditions.filter {
                    it.contains(searchQuery, ignoreCase = true) || searchQuery.isEmpty()
                }) { condition ->
                    Text(
                        text = condition,
                        modifier = Modifier.padding(vertical = 4.dp),
                        fontSize = 16.sp
                    )
                }
            }

            Spacer(modifier = Modifier.height(12.dp))

            Text("Precautionary Measures", fontSize = 18.sp, fontWeight = FontWeight.SemiBold)

            precautionaryTips.forEach {
                Text("\u2022 $it", fontSize = 14.sp, modifier = Modifier.padding(vertical = 2.dp))
            }

        }
    }
}
