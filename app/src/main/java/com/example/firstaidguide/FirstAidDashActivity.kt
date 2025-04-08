package com.example.firstaidguide

import android.content.Intent
import android.os.Bundle
import android.widget.Space
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
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
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
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

class FirstAidDashActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            FirstAidDashboard()
        }
    }
}

@Composable
fun FirstAidDashScreen() {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Top
    ) {
        Spacer(modifier = Modifier.height(6.dp))
        Text(
            text = "Welcome to First Aid Guide",
            style = MaterialTheme.typography.headlineSmall,
            color = Color(0xFF5D3FD3),
            fontWeight = FontWeight.Bold,
            modifier = Modifier
                .align(Alignment.Start)
                .padding(horizontal = 12.dp)
        )
        Text(
            text = "Hi, User !",
            style = MaterialTheme.typography.headlineMedium,
            color = Color(0xFF5D3FD3),
            fontWeight = FontWeight.Bold,
            modifier = Modifier
                .align(Alignment.Start)
                .padding(horizontal = 12.dp)
        )

        Spacer(modifier = Modifier.height(16.dp))

        // First row of cards
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceEvenly
        ) {
            CardWithImageAndText(imageRes = R.drawable.first_aid, title = "Guideline", 1)
            CardWithImageAndText(
                imageRes = R.drawable.first_aid,
                title = "Emergency Contacts",
                2
            )
        }

        Spacer(modifier = Modifier.height(16.dp))

        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceEvenly
        ) {
            CardWithImageAndText(imageRes = R.drawable.first_aid, title = "Manage Medical Info", 3)
            CardWithImageAndText(
                imageRes = R.drawable.first_aid,
                title = "Delete Info",
                4
            )
        }

        Spacer(modifier = Modifier.height(16.dp))


        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceEvenly
        ) {
            CardWithImageAndText(
                imageRes = R.drawable.first_aid,
                title = "Summary",
                6
            )
            CardWithImageAndText(imageRes = R.drawable.first_aid, title = "Logout", 5)
        }
    }
}


@Composable
fun CardWithImageAndText(
    imageRes: Int,
    title: String,
    cardId: Int
) {

    Card(
        modifier = Modifier
            .width(150.dp)
            .height(150.dp)
            .clickable {
            },
        shape = RoundedCornerShape(16.dp)
    )

    {
        Spacer(modifier = Modifier.height(16.dp))

        Column(
            modifier = Modifier.fillMaxSize(),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Image(
                painter = painterResource(id = imageRes),
                contentDescription = null,
                contentScale = ContentScale.Crop,
                modifier = Modifier
                    .height(64.dp)
                    .width(64.dp)
            )
            Spacer(modifier = Modifier.height(8.dp))

            Text(
                text = title,
                style = MaterialTheme.typography.bodyLarge,
                fontSize = 16.sp,
                fontWeight = FontWeight.Bold,
                textAlign = TextAlign.Center
            )
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


        }
        
        Spacer(modifier = Modifier.height(12.dp))


        FirstAidHomeItem("Search\nGuideline",R.drawable.first_aid,"Search guidelines for different symptoms","Search Guidelines")

        FirstAidHomeItem("First Aid\nGuide",R.drawable.first_aid,"See the guidelines for various emergencies","View Guidelines")

        FirstAidHomeItem("Emergency\nContacts",R.drawable.first_aid,"See the guidelines for various emergencies","View Contacts")

        FirstAidHomeItem("Saved\nGuidelines",R.drawable.first_aid,"See the guidelines for various emergencies","View Bookamarks")

        FirstAidHomeItem("My Medical\nInfo",R.drawable.first_aid,"See the guidelines for various emergencies","View Info")

    }
}

@Composable
fun FirstAidHomeItem(title: String,imageRes: Int,caption: String,buttonText: String)
{
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
                        when(imageRes)
                        {
                            R.drawable.first_aid -> {
                                context.startActivity(Intent(context, SearchGuidelinesActivity::class.java))
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