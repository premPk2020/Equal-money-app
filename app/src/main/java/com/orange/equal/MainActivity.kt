package com.orange.equal

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.ExperimentalComposeUiApi
import com.orange.equal.ui.theme.EqualTheme

@ExperimentalComposeUiApi
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            EqualApp {

                MainContent()
            }

        }
    }
}


@Composable
fun EqualApp(content: @Composable () -> Unit) {
    EqualTheme {

        Surface(
            color = MaterialTheme.colors.background
        ) {
            content()
        }
    }
}


@ExperimentalComposeUiApi
@Composable
fun MainContent() {
    BillForm()
}




