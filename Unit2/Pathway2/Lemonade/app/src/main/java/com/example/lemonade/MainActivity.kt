package com.example.lemonade

import android.os.Bundle
import android.widget.ImageButton
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.lemonade.ui.theme.LemonadeTheme
import kotlin.properties.Delegates

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            LemonadeTheme {
                MakeLemonadeApp()
            }
        }
    }
}

@Composable
fun MakeLemonadeApp() {
    MakeLemonadeTextAndImage(modifier =
    Modifier
        .fillMaxSize()
        .wrapContentSize(Alignment.Center))
}

@Preview(showBackground = true)
@Composable
fun MakeLemonadeTextAndImage(modifier: Modifier = Modifier) {
    var result by remember { mutableStateOf(1)}

    var imageResource by Delegates.notNull<Int>()
    var stringContent by Delegates.notNull<String>()
    var stringDescription by Delegates.notNull<String>()
    when(result) {
        1 -> {
            imageResource = R.drawable.lemon_tree
            stringContent = stringResource(id = R.string.tap_lemon_tree_to_select)
            stringDescription = stringResource(id = R.string.lemon_tree)
        }
        2 -> {
            imageResource = R.drawable.lemon_squeeze
            stringContent = stringResource(id = R.string.tap_lemon_tree_to_squeeze_lemon)
            stringDescription = stringResource(id = R.string.lemon)
        }
        3 -> {
            imageResource = R.drawable.lemon_drink
            stringContent = stringResource(id = R.string.tap_lemon_tree_to_drink)
            stringDescription = stringResource(id = R.string.glass_of_lemonade)
        }
        4 -> {
            imageResource = R.drawable.lemon_restart
            stringContent = stringResource(id = R.string.tap_empty_glass_to_start)
            stringDescription = stringResource(id = R.string.empty_glass)
        }
    }
    Column(modifier = modifier,
            horizontalAlignment = Alignment.CenterHorizontally) {
        Text(text = stringContent, fontSize = 18.sp)
        Image(painter = painterResource(id = imageResource), contentDescription = stringDescription,
            modifier = Modifier
                .clickable { result = if (result == 4) 1 else result + 1 }
                .padding(top = 16.dp)
                .border(1.dp, color = colorResource(id = R.color.sky), shape = RoundedCornerShape(15.dp)))

//        Button(onClick = { result = if (result == 4) 1 else result + 1 }) {
//            Icon(painter = painterResource(id = imageResource), contentDescription = stringDescription)
////            Image(painter = painterResource(id = imageResource), contentDescription = stringDescription)
//        }
    }
}