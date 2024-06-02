package com.cwk.activityfragmentlifecycleapp.ui.composables

import android.view.ViewGroup
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.viewinterop.AndroidView
import androidx.fragment.app.FragmentContainerView
import com.cwk.activityfragmentlifecycleapp.ui.constants.ViewIds

@Composable
fun MainScreen(
    button1Text: String,
    button2Text: String,
    button3Text: String,
    button4Text: String,
    button5Text: String,
    onButton1Click: () -> Unit,
    onButton2Click: () -> Unit,
    onButton3Click: () -> Unit,
    onButton4Click: () -> Unit,
    onButton5Click: () -> Unit
) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
    ) {
        Button(
            onClick = onButton1Click,
            modifier = Modifier.fillMaxWidth()
        ) {
            Text(text = button1Text)
        }

        Spacer(modifier = Modifier.height(5.dp))

        Button(
            onClick = onButton2Click,
            modifier = Modifier.fillMaxWidth()
        ) {
            Text(text = button2Text)
        }

        Spacer(modifier = Modifier.height(5.dp))

        Button(
            onClick = onButton3Click,
            modifier = Modifier.fillMaxWidth()
        ) {
            Text(text = button3Text)
        }

        Spacer(modifier = Modifier.height(5.dp))

        Button(
            onClick = onButton4Click,
            modifier = Modifier.fillMaxWidth()
        ) {
            Text(text = button4Text)
        }

        Spacer(modifier = Modifier.height(5.dp))

        Button(
            onClick = onButton5Click,
            modifier = Modifier.fillMaxWidth()
        ) {
            Text(text = button5Text)
        }

        Spacer(modifier = Modifier.height(5.dp))

        FragmentContainer(modifier = Modifier.fillMaxSize())
    }
}

@Composable
fun FragmentContainer(modifier: Modifier = Modifier) {
    AndroidView(
        factory = { ctx ->
            FragmentContainerView(ctx).apply {
                id = ViewIds.FRAGMENT_CONTAINER
                layoutParams = ViewGroup.LayoutParams(
                    ViewGroup.LayoutParams.MATCH_PARENT,
                    ViewGroup.LayoutParams.MATCH_PARENT
                )
            }
        },
        modifier = modifier
    )
}

@Preview(showBackground = true)
@Composable
fun MainScreenPreview() {
    MainScreen(
        button1Text = "Add Fragment A",
        button2Text = "Add Fragment B with BackStack",
        button3Text = "Replace Fragment C",
        button4Text = "Replace Fragment D with BackStack",
        button5Text = "Open Second Activity",
        onButton1Click = {},
        onButton2Click = {},
        onButton3Click = {},
        onButton4Click = {},
        onButton5Click = {}
    )
}