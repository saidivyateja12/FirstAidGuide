package saidivyatejas3466626.developed.firstaidapp

import android.app.Activity
import android.content.Intent
import android.net.Uri
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
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.systemBars
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

class HospitalDetailsActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ViewHospitalDetails()
        }
    }
}

@Composable
fun ViewHospitalDetails() {
    val context = LocalContext.current as Activity

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
                text = "Hospital Details",
                style = MaterialTheme.typography.headlineSmall.copy(
                    color = Color.Black,
                    fontWeight = FontWeight.Bold
                )
            )


        }


        Image(
            modifier = Modifier
                .fillMaxWidth()
                .height(200.dp),
            painter = painterResource(id = SelectedHospital.hospital.image),//SelectedHospital.hospital.image
            contentDescription = "Image",
            contentScale = ContentScale.FillBounds
        )

        Text(
            text = SelectedHospital.hospital.name,//SelectedHospital.hospital.name
            color = Color.Black,
            fontSize = 26.sp,
            fontWeight = FontWeight.Bold,
            modifier = Modifier.padding(start = 12.dp, top = 6.dp)

        )

        Spacer(modifier = Modifier.height(6.dp))

        Row() {

            Spacer(modifier = Modifier.width(12.dp))
            Image(
                modifier = Modifier
                    .size(22.dp),
                painter = painterResource(id = R.drawable.baseline_location_pin_24),
                contentDescription = "Location"

            )

//            Spacer(modifier = Modifier.width(4.dp))
            Text(
                text = SelectedHospital.hospital.address,//SelectedHospital.hospital.address
                color = Color.Gray,
                fontSize = 18.sp,


                )

        }

        Spacer(modifier = Modifier.height(6.dp))


        Text(
            text = "Description",
            color = Color.Black,
            fontSize = 18.sp,
            fontWeight = FontWeight.Bold,
            textAlign = TextAlign.Center,
            modifier = Modifier.padding(start = 12.dp, top = 12.dp)
        )

        Text(
            text = SelectedHospital.hospital.description,
            color = Color.Black,
            fontSize = 16.sp,
            modifier = Modifier.padding(start = 12.dp, top = 4.dp)
        )

        Text(
            text = "Contact Information",
            color = Color.Black,
            fontSize = 18.sp,
            fontWeight = FontWeight.Bold,
            textAlign = TextAlign.Center,
            modifier = Modifier.padding(start = 12.dp, top = 8.dp)
        )

        Spacer(modifier = Modifier.height(6.dp))
        Row(verticalAlignment = Alignment.CenterVertically) {

            Spacer(modifier = Modifier.width(12.dp))
            Image(
                modifier = Modifier
                    .size(20.dp),
                painter = painterResource(id = R.drawable.phone),
                contentDescription = "call image"

            )

            Spacer(modifier = Modifier.width(4.dp))
            Text(
                text = SelectedHospital.hospital.contactInfo.values.toString(),
                color = Color.Black,
                fontSize = 16.sp,
                textAlign = TextAlign.Center,
                modifier = Modifier

            )

        }

        Spacer(modifier = Modifier.height(6.dp))


        Text(
            text = "Specialties",
            color = Color.Black,
            fontSize = 18.sp,
            fontWeight = FontWeight.Bold,
            textAlign = TextAlign.Center,
            modifier = Modifier.padding(start = 12.dp, top = 8.dp)
        )

        Text(
            text = SelectedHospital.hospital.specialties.toString(),
            color = Color.Black,
            fontSize = 16.sp,
            modifier = Modifier.padding(start = 12.dp, top = 4.dp)
        )

        Spacer(modifier = Modifier.height(6.dp))

        Button(
            onClick = {

                val intent = Intent(Intent.ACTION_VIEW, Uri.parse(SelectedHospital.hospital.website))
                context.startActivity(intent)

            },
            modifier = Modifier
                .width(150.dp)
                .height(50.dp)
                .align(alignment = Alignment.CenterHorizontally),
            shape = MaterialTheme.shapes.medium,
            colors = ButtonDefaults.buttonColors(Color(0xFF5D3FD3))
        ) {
            Text(
                text = "View Website", color = Color.White,
                fontWeight = FontWeight.Bold
            )
        }


    }
}

@Preview(showBackground = true)
@Composable
fun FViewHospitalDetailsPreview() {
    ViewHospitalDetails()
}