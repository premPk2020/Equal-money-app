package com.orange.equal

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.*
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.orange.equal.ui.theme.EqualTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            EqualTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    EqualApp()
                }
            }
        }
    }
}

@Composable
fun EqualApp() {
    Column(Modifier.padding(20.dp)) {
        AmountDisplay()
        Spacer(modifier = Modifier.height(20.dp))
        InputAmount()
    }

}


@Preview(showBackground = true)
@Composable
fun EqualAppPreview() {
    EqualTheme {
        EqualApp()
    }
}