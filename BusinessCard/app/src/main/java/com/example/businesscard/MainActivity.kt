package com.example.businesscard

import android.graphics.drawable.Icon
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Call
import androidx.compose.material.icons.rounded.Call
import androidx.compose.material.icons.rounded.Email
import androidx.compose.material.icons.rounded.Share
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.VerticalAlignmentLine
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.businesscard.ui.theme.BusinessCardTheme
import org.intellij.lang.annotations.JdkConstants.HorizontalAlignment

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            BusinessCardTheme {
                // A surface container using the 'background' color from the theme
                Column(
                    horizontalAlignment = Alignment.Start,
                ) {
                    Surface(
                        modifier = Modifier.fillMaxSize(),
                        color = MaterialTheme.colorScheme.background
                    ) {

                        Profile(
                            image = R.drawable.profile,
                            name = "Nishant Shingate",
                            title = "Software Developer",
                            modifier = Modifier
                                .fillMaxSize()
                                .padding(2.dp)
                        )
                        Contacts(
                            contactNo = "+91 8329060009",
                            linkedin = "linkedin/nishant0073",
                            email = "nishantks121@gmail.com",
                            modifier = Modifier
                                .fillMaxSize()
                                .padding(2.dp)
                        )
                    }
                }
            }
        }
    }
}

@Composable()
fun Profile(image:Int,name:String,title:String, modifier: Modifier = Modifier)
{
    Column(
        modifier = modifier,
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {
        Image(painter = painterResource(id = image), contentDescription = "Profile Pic",modifier = Modifier.padding(horizontal = 2.dp, vertical = 1.dp))
        Text(text = name,modifier=Modifier.padding(horizontal = 2.dp, vertical = 1.dp,), fontSize = 24.sp)
        Text(text = title,modifier=Modifier.padding(horizontal = 2.dp, vertical = 1.dp), fontSize = 12.sp)
    }
}
@Composable
fun Contacts(contactNo: String,linkedin:String,email:String,modifier: Modifier){
    Column(
        modifier = modifier,
        verticalArrangement = Arrangement.Bottom,
        horizontalAlignment = Alignment.CenterHorizontally ,
    ) {
        Row(
            horizontalArrangement = Arrangement.Center,
            modifier = Modifier.padding(2.dp),
        )
        {
            Icon(
                Icons.Rounded.Call,
                contentDescription = "Contact number",
                modifier = Modifier.padding(vertical = 2.dp, horizontal = 5.dp)
            )
            Text(text = contactNo, fontSize = 18.sp)
        }
        Row(
            horizontalArrangement = Arrangement.Center,
        )
        {
            Icon(
                Icons.Rounded.Share,
                contentDescription = "Social media",
                modifier = Modifier.padding(vertical = 2.dp, horizontal = 5.dp)
            )
            Text(text = linkedin, fontSize = 18.sp)
        }
        Row(
            horizontalArrangement = Arrangement.Center,
        )
        {
            Icon(
                Icons.Rounded.Email,
                contentDescription = "Email id",
                modifier = Modifier.padding(vertical = 2.dp, horizontal = 5.dp)
            )
            Text(text = email, fontSize = 18.sp)
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
    BusinessCardTheme {
        Profile(image = R.drawable.profile, name = "Nishant Shingate",title="Software Developer", modifier = Modifier.fillMaxSize())
        Contacts(contactNo = "+91 8329060009", linkedin = "linkedin/nishant0073", email = "nishantks121@gmail.com" , modifier = Modifier
            .fillMaxSize()
            .padding(2.dp))
    }
}