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
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
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
import androidx.compose.ui.unit.sp

class ContactUsActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ContactUsActivityScreen()
        }
    }
}

@Composable
fun ContactUsActivityScreen() {
    val context = LocalContext.current as Activity

    Column(
        modifier = Modifier
            .fillMaxSize()
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
                text = "Contact Us",
                style = MaterialTheme.typography.headlineSmall.copy(
                    color = Color.Black,
                    fontWeight = FontWeight.Bold
                )
            )


        }

        Column(modifier = Modifier.fillMaxSize().padding(12.dp)) {

            Text(
                text = "Contact Details",
                fontSize = 18.sp,
                color = Color.Black,
                fontWeight = FontWeight.Bold
            )

            Text(
                text = "Teja\n" +
                        "Email: saidivyateja6@gmail.com\n" +
                        "Student ID: S3466626\n",
                fontSize = 16.sp,
                color = Color.Black
            )

            Text(
                text = "About Us",
                fontSize = 18.sp,
                color = Color.Black,
                fontWeight = FontWeight.Bold
            )

            Text(
                text = "Welcome to the First Aid Guide App – your go-to resource in times of need.\n" +
                        "Created by Teja, this mobile app is designed to provide quick, reliable, and easy-to-understand first aid information right at your fingertips. Whether it's a minor injury or a critical situation, knowing what to do in those first few moments can make all the difference.\n" +
                        "Thank you for choosing us to be a part of your safety toolkit.\n",
                fontSize = 16.sp,
                color = Color.Black
            )
        }
    }
}