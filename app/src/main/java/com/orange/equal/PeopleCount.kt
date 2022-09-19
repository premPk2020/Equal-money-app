package com.orange.equal

import androidx.compose.foundation.border
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.Card
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material.Icon
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Delete
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.unit.dp

@OptIn(ExperimentalMaterialApi::class)
@Composable
fun PeopleCount(
    peopleCount: Int = 0,
    isDecrease: Boolean = false,
    updatePeopleCount: (Int) -> Unit
) {
    val addIcon: ImageVector = Icons.Default.Add
    val deleteIcon: ImageVector = Icons.Default.Delete
    Card(
        modifier = Modifier
            .padding(5.dp)
            .height(20.dp)
            .width(20.dp)
            .clip(
                CircleShape
            )
            .shadow(20.dp, CircleShape)
            .border(1.dp, Color.LightGray, CircleShape),
        elevation = 5.dp,
        onClick = {
            if (isDecrease) {
                if (peopleCount > 1) (
                    updatePeopleCount(peopleCount - 1)
                )
            } else {
                updatePeopleCount(peopleCount + 1)
            }
        }
    ) {
        Icon(
            imageVector = if (isDecrease) deleteIcon else addIcon,
            contentDescription = if (isDecrease) "Delete people" else "Add people",
        )
    }
}
