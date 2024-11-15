package com.androidteam.presentacion.view

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.androidteam.presentacion.viewModel.LDillonViewModel
import com.androidteam.ui.theme.SampleArchTheme
import dagger.hilt.android.AndroidEntryPoint
import dagger.hilt.android.HiltAndroidApp
import dagger.hilt.android.lifecycle.HiltViewModel
import java.net.HttpURLConnection
import java.net.URL

@AndroidEntryPoint
class LDillonScreen : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            SampleArchTheme {
                vistaPrincipal()
            }
        }
    }
}

@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    Text(
        text = "Hello $name!",
        modifier = modifier
    )
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    SampleArchTheme {
        Greeting("Android")
    }
}

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun vistaPrincipal(){
    /*
    val viewModel = hiltViewModel<LDillonViewModel>()
    val context = LocalContext.current
    val intentProcessor = viewModel::onIntent
    val state by viewModel.state.collectAsState()
    */
    Scaffold(
        modifier = Modifier.fillMaxSize()
            .background(Color.White)
            .padding(top = 32.dp)
    ) {
        Column ( modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
            verticalArrangement = Arrangement.spacedBy(12.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ){
            Text(
                text = "Text every 10th chars:",
                color = Color.Black,
                fontWeight = FontWeight.Bold
            )
            Box ( modifier = Modifier
                .fillMaxWidth()
                .background(Color.Yellow)
                .padding(16.dp)
            ) {
            }
            Text(
                text = "Count unique words",
                color = Color.Black,
                fontWeight = FontWeight.Bold
            )
            Box ( modifier = Modifier
                .fillMaxWidth()
                .background(Color.Cyan)
                .padding(16.dp)
            ) {
            }
            Row ( modifier = Modifier
                .fillMaxSize(),
                horizontalArrangement = Arrangement.Center
            ) {
                Row (
                    horizontalArrangement = Arrangement.spacedBy(16.dp)
                ) {
                    Button(
                        onClick = { },
                        colors = ButtonDefaults.buttonColors( Color(0xFF8A74D6))
                    ) {
                        Text("Process Info")
                    }
                    Button(
                        onClick = { },
                        colors = ButtonDefaults.buttonColors( Color(0xFF8A74D6))
                    ) {
                        Text("Clear Data")
                    }
                }
            }
        }
    }
}


}


fun downloadPageContent(url: String): String? {
    return try {
        val connection = URL(url).openConnection() as HttpURLConnection
        connection.requestMethod = "GET"
        connection.inputStream.bufferedReader().use { it.readText() }
    } catch (e: Exception) {
        println("Error descargando la página: ${e.message}")
        null
    }
}

fun main() {
    val url = "https://www.compass.com/about/"
    val content = downloadPageContent(url)
    println(content)  // Aquí muestra el contenido de la página descargada
}