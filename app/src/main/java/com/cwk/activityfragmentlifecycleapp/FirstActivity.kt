package com.cwk.activityfragmentlifecycleapp

import android.content.Intent
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
import com.cwk.activityfragmentlifecycleapp.ui.composables.MainScreen
import com.cwk.activityfragmentlifecycleapp.ui.constants.ViewIds
import com.cwk.activityfragmentlifecycleapp.ui.fragments.FourFragment
import com.cwk.activityfragmentlifecycleapp.ui.fragments.OneFragment
import com.cwk.activityfragmentlifecycleapp.ui.fragments.ThreeFragment
import com.cwk.activityfragmentlifecycleapp.ui.fragments.TwoFragment
import com.cwk.activityfragmentlifecycleapp.ui.theme.ActivityFragmentLifecycleAppTheme

class FirstActivity : BaseActivity() {

    override val subTag: String = "FirstActivity"

    @OptIn(ExperimentalMaterial3Api::class)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            ActivityFragmentLifecycleAppTheme {
                Scaffold(
                    modifier = Modifier.fillMaxSize(),
                    topBar = {
                        TopAppBar(title = { Text(stringResource(R.string.txt_activity_first)) })
                    },
                    content = { innerPadding ->
                        Column(
                            modifier = Modifier
                                .fillMaxSize()
                                .padding(innerPadding)
                        ) {
                            MainScreen(
                                button1Text = "Add Fragment One",
                                button2Text = "Add Fragment Two with Back Stack",
                                button3Text = "Replace Fragment Three",
                                button4Text = "Replace Fragment Four with Back Stack",
                                button5Text = "Open Second Activity",
                                onButton1Click = {
                                    addFragment(
                                        containerId = ViewIds.FRAGMENT_CONTAINER,
                                        fragment = OneFragment.newInstance(),
                                        addToBackStack = false,
                                        fragmentTag = OneFragment.TAG
                                    )
                                },
                                onButton2Click = {
                                    addFragment(
                                        containerId = ViewIds.FRAGMENT_CONTAINER,
                                        fragment = TwoFragment.newInstance(),
                                        addToBackStack = true,
                                        fragmentTag = TwoFragment.TAG
                                    )
                                },
                                onButton3Click = {
                                    replaceFragment(
                                        containerId = ViewIds.FRAGMENT_CONTAINER,
                                        fragment = ThreeFragment.newInstance(),
                                        addToBackStack = false,
                                        fragmentTag = ThreeFragment.TAG
                                    )
                                },
                                onButton4Click = {
                                    replaceFragment(
                                        containerId = ViewIds.FRAGMENT_CONTAINER,
                                        fragment = FourFragment.newInstance(),
                                        addToBackStack = true,
                                        fragmentTag = FourFragment.TAG
                                    )
                                },
                                onButton5Click = {
                                    openSecondActivity()
                                }
                            )
                        }
                    })
            }
        }
    }

    private fun openSecondActivity() {
        startActivity(Intent(this, SecondActivity::class.java))
    }
}