package com.cwk.activityfragmentlifecycleapp.ui.composables

import android.view.ViewGroup
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.viewinterop.AndroidView
import androidx.fragment.app.FragmentContainerView
import com.cwk.activityfragmentlifecycleapp.ui.constants.ViewIds

@Composable
fun LifecycleScreen(
    button1Text: String,
    button2Text: String,
    button3Text: String,
    button4Text: String,
    button5Text: String,
    button6Text: String,
    button7Text: String,
    button8Text: String,
    button9Text: String,
    onButton1Click: () -> Unit,
    onButton2Click: () -> Unit,
    onButton3Click: () -> Unit,
    onButton4Click: () -> Unit,
    onButton5Click: () -> Unit,
    onButton6Click: () -> Unit,
    onButton7Click: () -> Unit,
    onButton8Click: () -> Unit,
    onButton9Click: () -> Unit
) {
    LazyColumn(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.spacedBy(2.dp)
    ) {
        item {
            ActionButton(
                text = button1Text,
                onClick = onButton1Click
            )
        }

        item {
            ActionButton(
                text = button2Text,
                onClick = onButton2Click
            )
        }

        item {
            ActionButton(
                text = button3Text,
                onClick = onButton3Click
            )
        }

        item {
            ActionButton(
                text = button4Text,
                onClick = onButton4Click
            )
        }

        item {
            ActionButton(
                text = button5Text,
                onClick = onButton5Click
            )
        }

        item {
            ActionButton(
                text = button6Text,
                onClick = onButton6Click
            )
        }

        item {
            ActionButton(
                text = button7Text,
                onClick = onButton7Click
            )
        }

        item {
            ActionButton(
                text = button8Text,
                onClick = onButton8Click
            )
        }

        item {
            ActionButton(
                text = button9Text,
                onClick = onButton9Click
            )
        }

        item {
            FragmentContainer(modifier = Modifier
                .fillMaxSize()
                .height(400.dp))
        }
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
fun SecondScreenPreview() {
    LifecycleScreen(
        button1Text = "Add Fragment A",
        button2Text = "Add Fragment A with BackStack",
        button3Text = "Add Fragment B",
        button4Text = "Add Fragment B with BackStack",
        button5Text = "Replace Fragment C",
        button6Text = "Replace Fragment C with BackStack",
        button7Text = "Replace Fragment D",
        button8Text = "Replace Fragment D with BackStack",
        button9Text = "Open Second Activity",
        onButton1Click = {},
        onButton2Click = {},
        onButton3Click = {},
        onButton4Click = {},
        onButton5Click = {},
        onButton6Click = {},
        onButton7Click = {},
        onButton8Click = {},
        onButton9Click = {}
    )
}