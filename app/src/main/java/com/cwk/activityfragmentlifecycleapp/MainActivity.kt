package com.cwk.activityfragmentlifecycleapp

import android.content.Intent
import android.os.Bundle
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import com.cwk.activityfragmentlifecycleapp.ui.base.BaseActivity
import com.cwk.activityfragmentlifecycleapp.ui.composables.MainScreen
import com.cwk.activityfragmentlifecycleapp.ui.theme.ActivityFragmentLifecycleAppTheme

class MainActivity : BaseActivity() {

    override val subTag: String = "MainActivity"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            ActivityFragmentLifecycleAppTheme {
                MainActivityContent()
            }
        }
    }

    private fun openLifecycleActivity() {
        startActivity(Intent(this, LifecycleActivity::class.java))
    }

    @OptIn(ExperimentalMaterial3Api::class)
    @Composable
    private fun MainActivityContent() {
        Scaffold(
            modifier = Modifier.fillMaxSize(),
            topBar = {
                TopAppBar(title = { Text(stringResource(R.string.txt_activity_main)) })
            },
            content = { innerPadding ->
                Box(
                    modifier = Modifier
                        .fillMaxSize()
                        .padding(innerPadding)
                ) {
                    MainScreen(buttonText = stringResource(R.string.txt_open_lifecycle_activity),
                        onButtonClick = {
                            openLifecycleActivity()
                        })
                }
            })
    }

    @Preview(showBackground = true)
    @Composable
    fun FirstActivityPreview() {
        MainActivityContent()
    }
}