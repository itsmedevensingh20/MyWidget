package com.alpha.mywidgets.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.alpha.mywidgets.R

class CategoryPage {


    @Composable
    fun FetchCategory(
        icon: Int = R.drawable.ic_user,
        heading: String = "Programming",
        subHeading: String = "Learn Diff language"
    ) {
        CategoryCard(icon, heading, subHeading)
    }


    @Composable
    fun CategoryCard(icon: Int, heading: String?, subHeading: String?) {
        Card(
            elevation = CardDefaults.cardElevation(defaultElevation = 4.dp),
            modifier = Modifier
                .padding(8.dp)
                .fillMaxWidth()
        ) {
            Row(
                verticalAlignment = Alignment.CenterVertically, modifier = Modifier.padding(8.dp)
            ) {
                Image(
                    painter = painterResource(icon),
                    contentDescription = "",
                    modifier = Modifier
                        .size(40.dp)
                        .padding(6.dp)
                        .weight(0.2f)
                )
                ItemDesc(heading, subHeading, modifier = Modifier.weight(0.8f))
            }
        }

    }

    @Composable
    private fun ItemDesc(heading: String?, subHeading: String?, modifier: Modifier) {
        Column(
            modifier = modifier
        ) {
            Text(
                text = heading.orEmpty(),
                fontSize = 20.sp,
                style = MaterialTheme.typography.labelLarge
            )
            Text(
                text = subHeading.orEmpty(),
                fontSize = 16.sp,
                style = MaterialTheme.typography.titleMedium
            )
        }
    }

}