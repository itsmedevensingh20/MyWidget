package com.alpha.mywidgets

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.tooling.preview.Preview

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
//        enableEdgeToEdge()
        super.onCreate(savedInstanceState)
        setContent {
//            Category()
        }
    }
}

@Preview(showSystemUi = true)
@Composable
fun LoginName() {
    val state = remember { mutableStateOf("") }
    TextField(value = state.value, onValueChange = {
        state.value = it
    }, label = {
        Text(text = "Enter name")
    })
}

@Composable
fun ListItem() {

}

