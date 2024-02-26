package com.example.greetingcard

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.greetingcard.ui.theme.BirthdayCardTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            BirthdayCardTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                     GreetingImage(
                        message = getString(R.string.happy_birthday_text),
                        from = getString(R.string.signature_text),
                        modifier = Modifier
                            .fillMaxSize()
                            .padding(8.dp),
                        );
                }
            }
        }
    }
}

@Composable
fun GreetingText(message: String, from: String, modifier : Modifier = Modifier)
{
    Column(
        verticalArrangement = Arrangement.Center,
        modifier = modifier,
    ) {
        Text(
            text = message,
            fontSize = 80.sp,
            lineHeight = 100.sp,
            textAlign = TextAlign.Center,
        )
        Text(
            text = from,
            fontSize = 20.sp,
            lineHeight = 30.sp,
            modifier = Modifier
                .padding(16.dp)
                .align(alignment = Alignment.CenterHorizontally),
        )
    }
}

@Composable
fun GreetingImage(message: String,from: String,modifier: Modifier = Modifier){
    val image = painterResource(id = R.drawable.androidparty)
    Box(
        modifier,
        contentAlignment = Alignment.Center,
        ) {

        Image(
            painter = image,
            contentDescription = null,
            contentScale = ContentScale.Crop,
            alpha = 0.6F,
            )
        GreetingText(
                message = message,
                from = from,
                modifier = modifier,
        )
    }
}

@Preview(showBackground = true)
@Composable
fun BirthdayCardPreview() {
    BirthdayCardTheme {
        GreetingImage(message = "Happy Birthday Sam!",from = "Nishant Shingate",modifier =  Modifier.padding(8.dp))
    }
}