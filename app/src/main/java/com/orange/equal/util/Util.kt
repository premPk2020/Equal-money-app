package com.orange.equal.util

fun calculatedTotalTip(totalBill: Double, tipPercentage: Int): Double {
    return if (totalBill.toString().isNotEmpty()) {
        (totalBill * tipPercentage) / 100
    } else {
        0.0
    }

}

fun calculateTotalPerson(totalBill: Double, splitBy: Int, tipPercentage: Int):Double{
    val bill = calculatedTotalTip(totalBill, tipPercentage) + totalBill
    return (bill/splitBy)
}