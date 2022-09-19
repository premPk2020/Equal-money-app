package com.orange.equal

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Delete
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Composable
fun InputAmount() {
    val amount = remember {
        mutableStateOf("")
    }
    val peopleCount = remember {
        mutableStateOf(1)
    }
    val tip = remember {
        mutableStateOf(0)
    }
    val tipPercentage = remember {
        mutableStateOf(0)
    }
    Card(
        modifier = Modifier
            .fillMaxWidth(),
        border = BorderStroke(1.dp, Color.LightGray),

        ) {
        Column(
            modifier = Modifier.padding(10.dp),

            ) {


            OutlinedTextField(
                modifier = Modifier.fillMaxWidth(),
                value = amount.value, onValueChange = {
                    amount.value = it
                },
                label = { Text(text = "Enter Bill") },
                leadingIcon = {
                    Icon(
                        painter = painterResource(id = R.drawable.ic_money),
                        contentDescription = "Dollars"
                    )
                }
            )
            if (amount.value.isNotEmpty()) {
                Row(
                    modifier = Modifier
                        .padding(top = 10.dp, bottom = 10.dp)
                        .fillMaxWidth(),
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.SpaceBetween
                ) {
                    Text(text = "Split")
                    Row(
                        verticalAlignment = Alignment.CenterVertically,
                        modifier = Modifier.padding(end = 30.dp)
                    ) {
                        PeopleCount(peopleCount = peopleCount.value, true) {
                            peopleCount.value = it
                        }
                        Text(text = peopleCount.value.toString())
                        PeopleCount(peopleCount = peopleCount.value, false) {
                            peopleCount.value = it
                        }
                    }
                }
                Row(
                    modifier = Modifier
                        .padding(top = 10.dp, bottom = 10.dp)
                        .fillMaxWidth(),
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.SpaceBetween
                ) {
                    Text(text = "Tip")
                    Text(text = "$${tip.value}", Modifier.padding(end = 30.dp))
                }
                Row(
                    modifier = Modifier
                        .padding(top = 10.dp, bottom = 10.dp)
                        .fillMaxWidth(),
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.Center
                ) {
                    Text(text = "${tipPercentage.value}%")
                }
                Slider(
                    value = tipPercentage.value.toFloat(), onValueChange = {
                        tipPercentage.value = it.toInt()
                    },
                    enabled = true,
                    valueRange = 0f..100f,
                    steps = 0
                )
            }
        }
    }
}


@Preview(showBackground = true)
@Composable
fun InputAmountPreview() {
    InputAmount()
}