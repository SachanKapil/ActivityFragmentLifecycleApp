package com.cwk.activityfragmentlifecycleapp

import android.os.Bundle
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import com.cwk.activityfragmentlifecycleapp.ui.base.BaseActivity
import com.cwk.activityfragmentlifecycleapp.ui.theme.ActivityFragmentLifecycleAppTheme

class SecondActivity : BaseActivity() {

    override val subTag: String = "SecondActivity"

    @OptIn(ExperimentalMaterial3Api::class)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            ActivityFragmentLifecycleAppTheme {
                Scaffold(
                    modifier = Modifier.fillMaxSize(),
                    topBar = {
                        TopAppBar(title = { Text(stringResource(R.string.txt_activity_second)) })
                    },
                    content = { innerPadding ->
                        Column(
                            modifier = Modifier
                                .fillMaxSize()
                                .padding(innerPadding)
                        ) {
                            Text(stringResource(R.string.txt_activity_second))
                        }
                    })
            }
        }
    }
}