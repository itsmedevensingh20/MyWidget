package com.alpha.mywidgets.screens.category

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import com.alpha.mywidgets.ApiResultState
import com.alpha.mywidgets.R


@Composable
fun CategoryScreen(
    icon: Int = R.drawable.ic_user,
    heading: String = "Programming",
    subHeading: String = "Learn Diff language"
) {

    val categoryViewmodel: CategoryViewmodel = hiltViewModel()
    FetchRepository(categoryViewmodel)
}

@Composable
fun FetchRepository(categoryViewmodel: CategoryViewmodel) {
    val state by categoryViewmodel.repository.collectAsState()
    LaunchedEffect(key1 = Unit) {
        categoryViewmodel.fetchGitRepository()
    }
    when (state) {
        is ApiResultState.Success -> {
            val response = (state as? ApiResultState.Success)?.data?.items
            LazyColumn {
                items(response ?: emptyList()) { category ->
                    CategoryCard(
                        icon = R.drawable.ic_user,
                        heading = category.name,
                        subHeading = category.description
                    )
                }
            }
        }

        is ApiResultState.Error -> {
            val message = (state as? ApiResultState.Error)?.message
            Text("Error: $message", modifier = Modifier.padding(16.dp))
        }

        is ApiResultState.Loading -> {
            CircularProgressIndicator(modifier = Modifier.padding(16.dp))
        }
    }
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
            text = heading.orEmpty(), fontSize = 20.sp, style = MaterialTheme.typography.labelLarge
        )
        Text(
            text = subHeading.orEmpty(),
            fontSize = 16.sp,
            style = MaterialTheme.typography.titleMedium
        )
    }
}
