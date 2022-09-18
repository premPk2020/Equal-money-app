package com.orange.equal

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.orange.equal.ui.theme.Purple

@Composable
fun AmountDisplay(
    modifier: Modifier = Modifier,
    amount: Int = 0
) {
    Card(
        modifier = modifier.fillMaxWidth(),
        shape = RoundedCornerShape(10.dp),
        backgroundColor = Purple
    ) {
        Column(
            modifier = modifier.padding(20.dp),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(
                text = "Total Per Person",
                fontWeight = FontWeight.Black,
                fontSize = MaterialTheme.typography.h5.fontSize
            )
            Text(
                text = "$$amount",
                fontWeight = FontWeight.Bold,
                fontSize = MaterialTheme.typography.h4.fontSize
            )
        }
    }
}

@Preview
@Composable
fun AmountDisplayPreview() {
    AmountDisplay()
}