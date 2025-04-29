package saidivyatejas3466626.developed.firstaidapp

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.asPaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.systemBars
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

class FirstAidDashActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            FirstAidDashboard()
        }
    }
}


@Preview(showBackground = true)
@Composable
fun FirstAidDashboardP() {
    FirstAidDashboard()
}

@Composable
fun FirstAidDashboard() {

    val context = LocalContext.current as Activity

    Column(
        modifier = Modifier
            .fillMaxSize()
            .verticalScroll(rememberScrollState())
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
                    .size(36.dp),
                painter = painterResource(id = R.drawable.first_aid),
                contentDescription = "First Aid"
            )

            Spacer(modifier = Modifier.width(12.dp))

            Text(
                modifier = Modifier
                    .padding(12.dp),
                text = "First Aid Guide",
                style = MaterialTheme.typography.headlineSmall.copy(
                    color = Color.Black,
                    fontWeight = FontWeight.Bold
                )
            )

            Spacer(modifier = Modifier.weight(1f))

            Image(
                modifier = Modifier
                    .clickable {
                        context.startActivity(
                            Intent(
                                context,
                                PatientProfileActivity::class.java
                            )
                        )
                    }
                    .size(36.dp),
                painter = painterResource(id = R.drawable.baseline_account_box_36),
                contentDescription = "Account"
            )

        }

        Spacer(modifier = Modifier.height(12.dp))

        FirstAidHomeItem(
            "Symptom\nChecker",
            R.drawable.first_aid,
            "Search possible illness by the symptoms",
            "Check Now"
        )


        FirstAidHomeItem(
            "First Aid\nGuide",
            R.drawable.first_aid,
            "See the guidelines for various emergencies",
            "View Guidelines"
        )

        FirstAidHomeItem(
            "Emergency\nContacts",
            R.drawable.first_aid,
            "See the list of contacts for emergencies",
            "View Contacts"
        )


        FirstAidHomeItem(
            "Locate\nHospitals",
            R.drawable.first_aid,
            "See nearby hospital  on the maps",
            "View Hospitals"
        )

        FirstAidHomeItem(
            "Having\nqueries?",
            R.drawable.first_aid,
            "Get in touch with us in case of queries",
            "Contact Us"
        )

    }
}

@Composable
fun FirstAidHomeItem(title: String, imageRes: Int, caption: String, buttonText: String) {
    val context = LocalContext.current

    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 12.dp, vertical = 8.dp)
            .background(
                color = colorResource(id = R.color.c1_bg),
                shape = RoundedCornerShape(6.dp)
            )
            .border(
                width = 1.dp,
                color = colorResource(id = R.color.c1_bg),
                shape = RoundedCornerShape(6.dp)
            )
            .padding(8.dp)
    ) {

        Spacer(modifier = Modifier.width(20.dp))

        Column {

            Text(
                modifier = Modifier,
                text = title,
                textAlign = TextAlign.Center,
                style = MaterialTheme.typography.titleLarge.copy(
                    color = Color.Black,
                    fontWeight = FontWeight.Bold
                )
            )

            Image(
                modifier = Modifier
                    .size(64.dp),
                painter = painterResource(id = imageRes),
                contentDescription = "Guide"
            )

        }

        Spacer(modifier = Modifier.width(40.dp))

        Column(
            modifier = Modifier.fillMaxWidth()
        ) {


            Spacer(modifier = Modifier.height(4.dp))

            Text(
                text = caption,
                style = MaterialTheme.typography.titleSmall.copy(
                    color = Color.Black,
                    fontWeight = FontWeight.Bold
                )
            )

            Spacer(modifier = Modifier.height(14.dp))


            Text(
                modifier = Modifier
                    .align(Alignment.End)
                    .clickable {
                        when (buttonText) {

                            "Check Now" -> {
                                context.startActivity(
                                    Intent(
                                        context,
                                        SymptomCheckerActivity::class.java
                                    )
                                )
                            }

                            "Search Guidelines" -> {
                                context.startActivity(
                                    Intent(
                                        context,
                                        SearchGuidelinesActivity::class.java
                                    )
                                )
                            }

                            "View Guidelines" -> {

                                context.startActivity(
                                    Intent(
                                        context,
                                        FirstAidGuidelinesActivity::class.java
                                    )
                                )

                            }

                            "View Contacts" -> {
                                context.startActivity(
                                    Intent(
                                        context,
                                        EmergenciesContactsActivity::class.java
                                    )
                                )
                            }

                            "View Info" -> {

                                context.startActivity(
                                    Intent(
                                        context,
                                        ViewHospitalsLocationActivity::class.java
                                    )
                                )

                            }

                            "Contact Us" -> {
                                context.startActivity(
                                    Intent(
                                        context,
                                        ContactUsActivity::class.java
                                    )
                                )
                            }

                            "View Hospitals" -> {
                                context.startActivity(
                                    Intent(
                                        context,
                                        ViewHospitalsLocationActivity::class.java
                                    )
                                )
                            }
                        }
                    }
                    .background(
                        color = colorResource(id = R.color.white),
                        shape = RoundedCornerShape(12.dp)
                    )
                    .border(
                        width = 1.dp,
                        color = colorResource(id = R.color.white),
                        shape = RoundedCornerShape(12.dp)
                    )
                    .padding(horizontal = 12.dp, vertical = 4.dp),
                text = buttonText,
                textAlign = TextAlign.Center,
                color = colorResource(id = R.color.c1_bg),
                fontSize = 14.sp,
                fontWeight = FontWeight.Bold
            )
        }
    }

}