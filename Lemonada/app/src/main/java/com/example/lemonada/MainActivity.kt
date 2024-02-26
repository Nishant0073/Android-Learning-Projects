package com.example.lemonada

import android.annotation.SuppressLint
import android.graphics.ColorSpace.Rgb
import android.os.Bundle
import android.view.RoundedCorner
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.lemonada.R.drawable
import com.example.lemonada.ui.theme.LemonadaTheme
import com.google.firebase.crashlytics.buildtools.reloc.javax.annotation.meta.When

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            LemonadaTheme {
                // A surface container using the 'background' color from the theme
                DefaultPreview()
            }
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun Lemonade(){
    var cstep by remember { mutableIntStateOf(0) }
    val cimage = when(cstep){
        0 -> painterResource(id = R.drawable.lemon_tree)
        1 -> painterResource(id = R.drawable.lemon_squeeze)
        2 -> painterResource(id = R.drawable.lemon_drink )
        else -> painterResource(id = R.drawable.lemon_restart)
    }
    val ctext = when(cstep){
        0 -> stringResource(id = R.string.tap_lemon_tree)
        1 -> stringResource(id = R.string.lemon_squeeze)
        2 -> stringResource(id = R.string.tap_lemonade)
        else -> stringResource(id = R.string.tap_glass)
    }

    Scaffold(
        topBar = {
            CenterAlignedTopAppBar(
                title = {
                    Text(
                        text = "Lemonade",
                        fontWeight = FontWeight.Bold
                    )
                },
                colors = TopAppBarDefaults.smallTopAppBarColors(
                    containerColor = MaterialTheme.colorScheme.primaryContainer,
                    titleContentColor = MaterialTheme.colorScheme.onPrimaryContainer,
                    navigationIconContentColor = MaterialTheme.colorScheme.onPrimaryContainer,
                    actionIconContentColor = MaterialTheme.colorScheme.onPrimaryContainer
                )
            )
        }
    ){
           Surface(
            modifier = Modifier.fillMaxSize(),
            color = MaterialTheme.colorScheme.background
        ) {
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .wrapContentSize(Alignment.Center),
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Button(
                    onClick = {
                        cstep = (cstep + 1) % 4
                    },
                    shape = RoundedCornerShape(dimensionResource(R.dimen.button_corner_radius)),
                    colors = ButtonDefaults.buttonColors(containerColor = MaterialTheme.colorScheme.tertiaryContainer)
                )
                {
                    Image(
                        painter = cimage,
                        contentDescription = ctext,
                        modifier = Modifier
                            .width(dimensionResource(R.dimen.button_image_width))
                            .height(dimensionResource(R.dimen.button_image_height))
                            .padding(dimensionResource(R.dimen.button_interior_padding))
                    )
                }
                Spacer(modifier = Modifier.height(16.dp))
                Text(text = ctext, fontSize = 14.sp)

            }
        }
    }
}


@Composable
@Preview
fun DefaultPreview(){
    LemonadaTheme {
        Lemonade()
    }
}