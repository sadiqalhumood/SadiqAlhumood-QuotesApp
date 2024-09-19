package com.example.app

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.app.ui.theme.AppTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            AppTheme() {
                Surface(
                    modifier = Modifier.fillMaxSize()
                ) {
                    Column(
                        verticalArrangement = Arrangement.Center,
                        horizontalAlignment = Alignment.CenterHorizontally
                    ) {

                        Quote()
                    }
                }
            }
        }
    }
}

@Composable
fun Quote() {
    val quoteList = listOf("Be yourself; everyone else is already taken.",
        "Two things are infinite: the universe and human stupidity; and I'm not sure about the universe.",
        "You only live once, but if you do it right, once is enough.",
        "Be the change that you wish to see in the world.",
        "In three words I can sum up everything I've learned about life: it goes on.",
        "If you tell the truth, you don't have to remember anything.",
        "A friend is someone who knows all about you and still loves you.",
        "Always forgive your enemies; nothing annoys them so much.",
        "It is better to be hated for what you are than to be loved for what you are not.",
        "Insanity is doing the same thing, over and over again, but expecting different results.")

//    if(i > 9){
//        val v = i - 10
//    }
//    else {
//        val v = i
//    }

    var quote by remember { mutableStateOf("A problem is a chance for you to do your best.") }
    Column(
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Text("Quote of The Day")

        Text(
            text = " \" " + quote + " \" ",
            textAlign = TextAlign.Center,
            fontSize = 30.sp,
            modifier = Modifier.padding(16.dp),
            color = Color(0xFF003366)

        )
        Button(
            onClick = {
                val randomIndex = (quoteList.indices).random()
                quote = quoteList[randomIndex]
            },
            colors = ButtonDefaults.buttonColors(
                containerColor = Color(0xFF880808),
                contentColor = Color(0xFFFFFFFF)
            ),
            modifier = Modifier.padding(top = 16.dp)
        ) {
            Text("Change Quote")
        }
    }
}