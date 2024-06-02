package com.cwk.activityfragmentlifecycleapp.ui.composables

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Composable
fun MainScreen(
    buttonText: String,
    onButtonClick: () -> Unit
) {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .padding(horizontal = 16.dp),
        contentAlignment = Alignment.Center
    ) {
        ActionButton(
            text = buttonText,
            onClick = onButtonClick
        )
    }
}

@Preview(showBackground = true)
@Composable
fun FirstScreenPreview() {
    MainScreen(
        buttonText = "Open Second Activity",
        onButtonClick = {}
    )
}