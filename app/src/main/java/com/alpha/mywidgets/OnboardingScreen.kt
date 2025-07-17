package com.alpha.mywidgets

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController

class OnboardingScreen {



    @Composable
    fun OnboardingPage(navController: NavHostController) {
        Surface(
            modifier = Modifier.fillMaxSize()
        ) {
            Column(
                modifier = Modifier.fillMaxWidth()
            ) {
                Image(
                    modifier = Modifier
                        .fillMaxWidth()
                        .size(200.dp)
                        .weight(0.4f),
                    painter = painterResource(id = R.drawable.ic_office_material),
                    contentDescription = "Onboarding BG"
                )
                Spacer(modifier = Modifier.size(20.dp))

                Column(
                    horizontalAlignment = Alignment.CenterHorizontally,
                    verticalArrangement = Arrangement.Top,
                    modifier = Modifier
                        .fillMaxWidth()
                        .weight(0.6f)
                ) {
                    Text(
                        modifier = Modifier.fillMaxWidth(),
                        maxLines = 2,
                        textAlign = TextAlign.Center,
                        fontSize = 20.sp,
                        overflow = TextOverflow.Ellipsis,
                        style = MaterialTheme.typography.titleMedium,
                        text = "Welcome to My catalog",
                    )

                    Spacer(modifier = Modifier.size(20.dp))

                    Button(
                        onClick = { navController.navigate("login") },
                    ) {
                        Text(text = "Get Started")
                    }
                }
            }
        }
    }
}