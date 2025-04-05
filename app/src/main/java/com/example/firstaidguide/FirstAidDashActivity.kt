package com.example.firstaidguide

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
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
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

class FirstAidDashActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            FirstAidDashScreen()
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