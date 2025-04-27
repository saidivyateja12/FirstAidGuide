package saidivyatejas3466626.developed.firstaidapp

import android.app.Activity
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.MaterialTheme
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
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

class SearchGuidelinesActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            SearchGuidelinesScreen()
        }
    }
}

@Preview(showBackground = true)
@Composable
fun SearchGuidelinesScreenP() {
    SearchGuidelinesScreen()
}

@Composable
fun SearchGuidelinesScreen() {
    val context = LocalContext.current as Activity
    var symptoms by remember { mutableStateOf("") }

    var age by remember { mutableStateOf("") }
    var gender by remember { mutableStateOf("") }
    var duration by remember { mutableStateOf("") }
    var painLevel by remember { mutableStateOf("") }
    var allergies by remember { mutableStateOf("") }


    Column(
        modifier = Modifier.fillMaxSize()
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
                text = "Search Guidelines",
                style = MaterialTheme.typography.headlineSmall.copy(
                    color = Color.Black,
                    fontWeight = FontWeight.Bold
                )
            )


        }

        Column(
            modifier = Modifier.padding(horizontal = 12.dp)
        ) {


            BasicTextField(
                value = symptoms,
                onValueChange = { symptoms = it },
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(vertical = 8.dp)
                    .height(50.dp),
                singleLine = true,
                decorationBox = { innerTextField ->
                    Row(
                        verticalAlignment = Alignment.CenterVertically,
                        modifier = Modifier
                            .background(Color.LightGray, MaterialTheme.shapes.medium)
                            .padding(horizontal = 16.dp)
                            .fillMaxSize()
                    ) {
                        Box(modifier = Modifier.weight(1f)) {
                            if (symptoms.isEmpty()) {
                                Text(text = "Symptoms", color = Color.Gray)
                            }
                            innerTextField()
                        }

                    }
                }
            )

            Row {
                BasicTextField(
                    value = age,
                    onValueChange = { age = it },
                    modifier = Modifier
                        .weight(1f)
                        .padding(vertical = 8.dp)
                        .height(50.dp),
                    singleLine = true,
                    decorationBox = { innerTextField ->
                        Row(
                            verticalAlignment = Alignment.CenterVertically,
                            modifier = Modifier
                                .background(Color.LightGray, MaterialTheme.shapes.medium)
                                .padding(horizontal = 16.dp)
                                .fillMaxSize()
                        ) {
                            Box(modifier = Modifier.weight(1f)) {
                                if (symptoms.isEmpty()) {
                                    Text(text = "Age", color = Color.Gray)
                                }
                                innerTextField()
                            }

                        }
                    }
                )

                Spacer(modifier = Modifier.width(12.dp))

                BasicTextField(
                    value =gender ,
                    onValueChange = { gender = it },
                    modifier = Modifier
                        .weight(1f)
                        .padding(vertical = 8.dp)
                        .height(50.dp),
                    singleLine = true,
                    decorationBox = { innerTextField ->
                        Row(
                            verticalAlignment = Alignment.CenterVertically,
                            modifier = Modifier
                                .background(Color.LightGray, MaterialTheme.shapes.medium)
                                .padding(horizontal = 16.dp)
                                .fillMaxSize()
                        ) {
                            Box(modifier = Modifier.weight(1f)) {
                                if (symptoms.isEmpty()) {
                                    Text(text = "Gender", color = Color.Gray)
                                }
                                innerTextField()
                            }

                        }
                    }
                )
            }

            BasicTextField(
                value = duration,
                onValueChange = { duration = it },
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(vertical = 8.dp)
                    .height(50.dp),
                singleLine = true,
                decorationBox = { innerTextField ->
                    Row(
                        verticalAlignment = Alignment.CenterVertically,
                        modifier = Modifier
                            .background(Color.LightGray, MaterialTheme.shapes.medium)
                            .padding(horizontal = 16.dp)
                            .fillMaxSize()
                    ) {
                        Box(modifier = Modifier.weight(1f)) {
                            if (symptoms.isEmpty()) {
                                Text(text = "Duration of symptoms", color = Color.Gray)
                            }
                            innerTextField()
                        }

                    }
                }
            )

            BasicTextField(
                value = painLevel,
                onValueChange = { painLevel = it },
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(vertical = 8.dp)
                    .height(50.dp),
                singleLine = true,
                decorationBox = { innerTextField ->
                    Row(
                        verticalAlignment = Alignment.CenterVertically,
                        modifier = Modifier
                            .background(Color.LightGray, MaterialTheme.shapes.medium)
                            .padding(horizontal = 16.dp)
                            .fillMaxSize()
                    ) {
                        Box(modifier = Modifier.weight(1f)) {
                            if (symptoms.isEmpty()) {
                                Text(text = "Pain Level", color = Color.Gray)
                            }
                            innerTextField()
                        }

                    }
                }
            )

            BasicTextField(
                value = allergies,
                onValueChange = { allergies = it },
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(vertical = 8.dp)
                    .height(50.dp),
                singleLine = true,
                decorationBox = { innerTextField ->
                    Row(
                        verticalAlignment = Alignment.CenterVertically,
                        modifier = Modifier
                            .background(Color.LightGray, MaterialTheme.shapes.medium)
                            .padding(horizontal = 16.dp)
                            .fillMaxSize()
                    ) {
                        Box(modifier = Modifier.weight(1f)) {
                            if (symptoms.isEmpty()) {
                                Text(text = "Allergies", color = Color.Gray)
                            }
                            innerTextField()
                        }

                    }
                }
            )

            Spacer(modifier = Modifier.height(24.dp))

            Button(
                onClick = {

                },
                modifier = Modifier
                    .fillMaxWidth()
                    .height(50.dp),
                shape = MaterialTheme.shapes.medium,
                colors = ButtonDefaults.buttonColors(Color(0xFF5D3FD3))
            ) {
                Text(
                    text = "Search", color = Color.White,
                    fontWeight = FontWeight.Bold
                )
            }

        }
    }
}