package saidivyatejas3466626.developed.firstaidapp

import android.app.Activity
import android.content.Intent
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
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.systemBars
import androidx.compose.foundation.layout.width
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
import androidx.compose.ui.unit.dp
import com.google.android.gms.maps.model.CameraPosition
import com.google.android.gms.maps.model.LatLng
import com.google.maps.android.compose.GoogleMap
import com.google.maps.android.compose.Marker
import com.google.maps.android.compose.rememberCameraPositionState
import com.google.maps.android.compose.rememberMarkerState
import kotlin.jvm.java

class ViewHospitalsLocationActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            HospitalLocationScreen()
        }

    }
}


@Composable
fun HospitalLocationScreen() {
    val context = LocalContext.current as Activity

    val cameraPositionState = rememberCameraPositionState {
        position =
            CameraPosition.fromLatLngZoom(LatLng(54.5511477,-1.2151151), 8f)
    }

    Column(
        modifier = Modifier.fillMaxSize()
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
                text = "Locate Hospitals",
                style = MaterialTheme.typography.headlineSmall.copy(
                    color = Color.Black,
                    fontWeight = FontWeight.Bold
                )
            )


        }

        GoogleMap(
            modifier = Modifier.fillMaxSize(),
            cameraPositionState = cameraPositionState
        ) {

            Marker(
                state = rememberMarkerState(position = LatLng(54.5511477,-1.2151151)),
                title = "The James Cook University Hospital",
                onClick = {
                    SelectedHospital.hospital = getHospitals()[0]
                    context.startActivity(Intent(context, HospitalDetailsActivity::class.java))
                   true
                }
            )

            Marker(
                state = rememberMarkerState(position = LatLng(54.5464531,-1.2493261)),
                title = "Tees Valley Hospital",
                onClick = {
                    SelectedHospital.hospital = getHospitals()[1]
                    context.startActivity(Intent(context, HospitalDetailsActivity::class.java))
                    true
                }
            )

            Marker(
                state = rememberMarkerState(position = LatLng(54.5619444,-1.7440012)),
                title = "South Tees Hospitals NHS Foundation Trust",
                onClick = {
                    SelectedHospital.hospital = getHospitals()[2]
                    context.startActivity(Intent(context, HospitalDetailsActivity::class.java))
                    true
                }
            )

            Marker(
                state = rememberMarkerState(position = LatLng(54.555291,-1.3507663)),
                title = "Carter Bequest Primary Care Hospital",
                onClick = {
                    SelectedHospital.hospital = getHospitals()[3]
                    context.startActivity(Intent(context, HospitalDetailsActivity::class.java))
                    true
                }
            )


        }
    }
}

data class Hospital(
    val name: String,
    val description: String,
    val specialties: List<String>,
    val address: String,
    val contactInfo: Map<String, String>,
    val website: String?,
    val locationUrl: String,
    val image: Int=0,
    val locationCoordinates: String,
)

fun getHospitals(): List<Hospital> {
    return listOf(
        Hospital(
            name = "The James Cook University Hospital",
            description = "A leading tertiary referral center and major trauma facility in northern England, operated by the South Tees Hospitals NHS Foundation Trust.",
            specialties = listOf(
                "Cancer treatment",
                "Cardiothoracic surgery",
                "Neurosciences",
                "Spinal injuries",
                "Renal medicine",
                "Vascular surgery",
                "Gynecology",
                "Neonatal intensive care",
                "Reproductive medicine (including IVF)"
            ),
            address = "Marton Road, Middlesbrough, TS4 3BW",
            contactInfo = mapOf(
                "Main Switchboard" to "01642 850850"
            ),
            website = "https://www.southtees.nhs.uk/hospitals/james-cook/",
            locationUrl = "https://maps.app.goo.gl/qDz6zkhHfpv693KX7",
            image = R.drawable.james_cook_hospital,
            locationCoordinates = "54.5511477,-1.2151151"

        ),
        Hospital(
            name = "Tees Valley Hospital",
            description = "A modern private healthcare facility located in Acklam, Middlesbrough, offering surgical, medical, and diagnostic services.",
            specialties = listOf(
                "Orthopaedics",
                "General Surgery",
                "Cosmetic and Plastic Surgery",
                "Gynaecology",
                "Dermatology",
                "Endoscopy",
                "Oral & Maxillofacial Surgery",
                "Podiatric Surgery",
                "Urology"
            ),
            address = "Church Lane, Acklam, Middlesbrough, TS5 7DX",
            contactInfo = mapOf("Phone" to "01642 929 409"),
            website = "https://www.ramsayhealth.co.uk/hospitals/tees-valley-hospital",
            locationUrl = "https://maps.app.goo.gl/eaaJMXAnHr1tU4cQ8",
            image = R.drawable.tees_valley_hospital,
            locationCoordinates = "54.5464531,-1.2493261"
        ),
        Hospital(
            name = "South Tees Hospitals NHS Foundation Trust",
            description = "A major healthcare provider serving over 1.5 million people in the Tees Valley and North Yorkshire, managing multiple hospitals including James Cook and Friarage.",
            specialties = listOf(
                "Cancer care",
                "Cardiothoracic surgery",
                "Spinal surgery",
                "Cochlear implants",
                "Neurosciences",
                "Gynecology",
                "Vascular surgery",
                "Urology"
            ),
            address = "Based in Middlesbrough and North Allerton",
            contactInfo = mapOf("Phone" to "+441642850850"),
            website = "https://www.southtees.nhs.uk",
            locationUrl = "https://maps.app.goo.gl/Q6jVaTD6Hj777w3A7",
            image = R.drawable.south_tees_hospitals,
            locationCoordinates = "54.5537035,-1.3666113"
        ),
        Hospital(
            name = "Carter Bequest Primary Care Hospital",
            description = "A historic healthcare facility established in 1926 through a bequest, known for its dermatology clinics and maternity services before transitioning under the NHS.",
            specialties = listOf(
                "Maternity (historically)",
                "Dermatology",
                "Minor surgical and outpatient services"
            ),
            address = "Cambridge Road, Middlesbrough, England",
            contactInfo = mapOf("Phone" to "+441642850911"),
            website = null,
            locationUrl = "https://maps.app.goo.gl/YyxMvioJq39ESe3G9",
            image = R.drawable.carter_bequest_hospital,
            locationCoordinates = "54.5537035,-1.3666113"
        )
    )
}

object SelectedHospital{lateinit var hospital: Hospital }
