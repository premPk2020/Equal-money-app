package com.orange.equal


import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CornerSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.material.Slider
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Remove
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalSoftwareKeyboardController
import androidx.compose.ui.unit.dp
import com.orange.equal.components.InputField
import com.orange.equal.util.calculateTotalPerson
import com.orange.equal.util.calculatedTotalTip
import com.orange.equal.widgets.RoundIconButton

@ExperimentalComposeUiApi
@Composable
fun BillForm(modifier: Modifier = Modifier, onValChange: (String) -> Unit = {}) {
    val totalBillsState = remember {
        mutableStateOf("")
    }
    val validState = remember(totalBillsState.value) {
        totalBillsState.value.trim().isNotEmpty()
    }
    val keyBoardController = LocalSoftwareKeyboardController.current
    val sliderPosition = remember {
        mutableStateOf(0f)
    }
    val tipPercentage = (sliderPosition.value * 100).toInt()
    val splitByState = remember {
        mutableStateOf(1)
    }
    val tipAmountState = remember {
        mutableStateOf(0.0)
    }
    val totalPerPersonState = remember {
        mutableStateOf(0.0)
    }


    Column(modifier = modifier.padding(5.dp)) {
        TopHeader(totalPerPersonState.value)

        Surface(
            modifier = modifier
                .padding(2.dp)
                .fillMaxWidth(),
            shape = RoundedCornerShape(corner = CornerSize(8.dp)),
            border = BorderStroke(width = 1.dp, color = Color.LightGray)
        ) {
            Column(
                modifier = modifier.padding(6.dp),
                verticalArrangement = Arrangement.Top,
                horizontalAlignment = Alignment.Start
            ) {
                InputField(
                    valueState = totalBillsState,
                    labelId = "Enter Bill",
                    enabled = true,
                    isSingleLine = true,
                    onAction = KeyboardActions {
                        if (!validState) return@KeyboardActions
                        onValChange(totalBillsState.value.trim())
                        keyBoardController?.hide()
                    })
                if (validState) {
                    Row(
                        modifier = modifier.padding(3.dp),
                        horizontalArrangement = Arrangement.Start
                    ) {
                        Text(
                            text = "Split", modifier = modifier.align(
                                alignment = Alignment.CenterVertically
                            )
                        )

                        Spacer(modifier = modifier.width(120.dp))
                        Row(
                            modifier = modifier.padding(horizontal = 3.dp),
                            horizontalArrangement = Arrangement.End
                        ) {
                            RoundIconButton(imageVector = Icons.Default.Remove,
                                onClick = {
                                    splitByState.value =
                                        if (splitByState.value > 1) splitByState.value - 1 else 1
                                    totalPerPersonState.value = calculateTotalPerson(
                                        totalBillsState.value.toDouble(),
                                        splitByState.value,
                                        tipPercentage
                                    )
                                })
                            Text(
                                text = "${splitByState.value}",
                                modifier = modifier
                                    .align(Alignment.CenterVertically)
                                    .padding(start = 9.dp, end = 9.dp)
                            )
                            RoundIconButton(imageVector = Icons.Default.Add,
                                onClick = {
                                    splitByState.value = splitByState.value + 1
                                    totalPerPersonState.value = calculateTotalPerson(
                                        totalBillsState.value.toDouble(),
                                        splitByState.value,
                                        tipPercentage
                                    )
                                })
                        }
                    }
                    //Tip row
                    Row(modifier = modifier.padding(horizontal = 3.dp, vertical = 12.dp)) {
                        Text(text = "Tip", modifier = modifier.align(Alignment.CenterVertically))
                        Spacer(modifier = modifier.width(200.dp))
                        Text(text = "$ ${tipAmountState.value}")
                    }
                    Column(
                        verticalArrangement = Arrangement.Center,
                        horizontalAlignment = Alignment.CenterHorizontally
                    ) {
                        Text(text = "${tipPercentage}%")
                        Spacer(modifier = modifier.height(14.dp))
                        Slider(
                            value = sliderPosition.value,
                            onValueChange = { newVal ->
                                sliderPosition.value = newVal
                                tipAmountState.value =
                                    calculatedTotalTip(
                                        totalBillsState.value.toDouble(),
                                        tipPercentage
                                    )
                                totalPerPersonState.value = calculateTotalPerson(
                                    totalBillsState.value.toDouble(),
                                    splitByState.value,
                                    tipPercentage
                                )
                            },
                            modifier = modifier.padding(start = 16.dp, end = 16.dp),

                            )
                    }
                }
            }
        }
    }
}