package com.example.composequadrant

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.composequadrant.ui.theme.ComposeQuadrantTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ComposeQuadrantTheme {
                Surface(modifier = Modifier.fillMaxSize()
                        , color = MaterialTheme.colors.background
                ) {
                    ComposeQuadrantApp()
                }
            }
        }
    }
}

@Composable
fun ComposeQuadrantApp() {

    Column() {
        Row(modifier = Modifier.weight(1F, false)) {
            ComposableInfoCard(title = stringResource(id = R.string.first_title)
                , description = stringResource(id = R.string.first_description)
                , backgroundColor = Color.Green, modifier = Modifier.weight(1F))
            ComposableInfoCard(title = stringResource(id = R.string.second_title)
                , description = stringResource(id = R.string.second_description)
                , backgroundColor = Color.Yellow, modifier = Modifier.weight(1F))
//            Box(modifier = Modifier
//                .fillMaxSize()
//                .background(Color.Green)
//                .weight(1F)
//                .padding(16.dp)) {
//
//
//
//            }
//            Box(modifier = Modifier
//                .fillMaxSize()
//                .background(Color.Yellow)
//                .weight(1F, true)
//                .padding(16.dp)) {
//
//            }
        }
        Row(modifier = Modifier.weight(1F, true)) {
            ComposableInfoCard(title = stringResource(id = R.string.third_title)
                , description = stringResource(id = R.string.third_description)
                , backgroundColor = Color.Cyan, modifier = Modifier.weight(1F))
            ComposableInfoCard(title = stringResource(id = R.string.fourth_title)
                , description = stringResource(id = R.string.fourth_description)
                , backgroundColor = Color.LightGray, modifier = Modifier.weight(1F))
        }
    }
}

@Composable
private fun ComposableInfoCard(
    title: String,
    description: String,
    backgroundColor: Color,
    modifier: Modifier = Modifier
) {
    Column(modifier =
        modifier
            .fillMaxSize()
            .background(backgroundColor)
            .padding(16.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center) {

        Text(text = title
            , fontWeight = FontWeight.Bold
            , textAlign = TextAlign.Center)

        Text(text = description
            , textAlign = TextAlign.Justify
        )
    }
}


@Preview(showBackground = true)
@Composable
fun ComposeQuadrantPreview() {
    ComposeQuadrantTheme {
        ComposeQuadrantApp()
    }
}