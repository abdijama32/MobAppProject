package com.example.mobappproject

import androidx.compose.ui.res.painterResource
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.mobappproject.ui.theme.MobAppProjectTheme
import androidx.compose.foundation.Image
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.unit.sp
import com.example.mobappproject.R


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MobAppProjectTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    WeatherAppContent()
                }
            }
        }
    }
}

@Composable
fun WeatherAppContent() {
    Column(Modifier.fillMaxSize()) {
        WeatherAppTitle()
        SecondaryTitle()
        WeatherInfo()
        WeatherDetails("65","80", "100%", "1023 hPa")
    }
}

@Composable
fun WeatherAppTitle() {
    val context = LocalContext.current
    val tealColor = colorResource(id = R.color.purple_200)
    Surface(modifier = Modifier.fillMaxWidth(), color = tealColor) {
        Text(
            text = stringResource(id = R.string.app_name),
            modifier = Modifier.padding(3.dp)
        )
    }

}

@Composable
fun SecondaryTitle() {
    Box(
        modifier = Modifier.fillMaxWidth(),
        contentAlignment = Alignment.TopCenter
    ) {
        Text(
            text = stringResource(id = R.string.secondary_title),
        )
    }
}

@Composable
fun WeatherDetails(low_temp: String, high_temp: String, humidity: String, pressure: String){
    Column(Modifier.fillMaxWidth().padding(start = 16.dp)) {
        Row(Modifier.fillMaxWidth()){
            Text(
                text = stringResource(R.string.low_temp),
                style = MaterialTheme.typography.bodyLarge,
                modifier = Modifier.weight(1f)
            )
            Text(
                text = "\u00B0",
                style = MaterialTheme.typography.bodyLarge,
                modifier = Modifier.weight(5f)
            )

        }
        Row(Modifier.fillMaxWidth()) {
            Text(
                text = stringResource(R.string.high_temp),
                style = MaterialTheme.typography.bodyLarge,
                modifier = Modifier.weight(1f)
            )
            Text(
                text = "\u00B0",
                style = MaterialTheme.typography.bodyLarge,
                modifier = Modifier.weight(5f)
            )


        }
        Row(Modifier.fillMaxWidth()) {
            Text(
                text = stringResource(R.string.humidity),
                style = MaterialTheme.typography.bodyLarge,
                modifier = Modifier.weight(1f)
            )

        }
            Row(Modifier.fillMaxWidth()){
                Text(
                    text = stringResource(R.string.pressure),
                    style = MaterialTheme.typography.bodyLarge,
                    modifier = Modifier.weight(1f)
                )
            }
        }
    }

@Composable
fun WeatherInfo() {
    val context = LocalContext.current
    val tempText = stringResource(R.string.temp, context)
    val feelsLike = stringResource(R.string.feels_like, context)


    Row(Modifier.fillMaxWidth(), verticalAlignment = Alignment.CenterVertically) {
        Column(Modifier.weight(1f)) {
            Text(
//                modifier = Modifier.padding(start = 16.dp),
                text = buildAnnotatedString {
                    append(tempText)
                    withStyle(style = SpanStyle(fontSize = 75.sp)) {
                        append(" \u00B0")
                    } },
                modifier = Modifier.padding(start = 16.dp),
            fontSize = 75.sp
            )
            Text(
                text = feelsLike,
                modifier = Modifier.size(200.dp ,60.dp).padding(16.dp),
                fontSize = 14.sp
            )

        }
        Image(
            painter = painterResource(id = R.drawable.webappimage),
            contentDescription = null,
            modifier = Modifier
                .size(100.dp)
                .padding(end = 0.dp)
                .align(Alignment.CenterVertically),
        )
    }
}


@Preview(showBackground = true)
@Composable
fun PreviewWeatherAppTitle() {
    MobAppProjectTheme {
        WeatherAppContent()
    }
}
