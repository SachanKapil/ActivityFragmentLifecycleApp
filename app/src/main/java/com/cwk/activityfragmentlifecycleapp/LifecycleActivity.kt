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
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import com.cwk.activityfragmentlifecycleapp.ui.base.BaseActivity
import com.cwk.activityfragmentlifecycleapp.ui.composables.LifecycleScreen
import com.cwk.activityfragmentlifecycleapp.ui.constants.ViewIds
import com.cwk.activityfragmentlifecycleapp.ui.fragments.FourFragment
import com.cwk.activityfragmentlifecycleapp.ui.fragments.OneFragment
import com.cwk.activityfragmentlifecycleapp.ui.fragments.ThreeFragment
import com.cwk.activityfragmentlifecycleapp.ui.fragments.TwoFragment
import com.cwk.activityfragmentlifecycleapp.ui.theme.ActivityFragmentLifecycleAppTheme

class LifecycleActivity : BaseActivity() {

    override val subTag: String = "LifecycleActivity"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            ActivityFragmentLifecycleAppTheme {
                LifecycleActivityContent()
            }
        }
    }

    private fun openBlankActivity() {
        startActivity(Intent(this, BlankActivity::class.java))
    }

    @OptIn(ExperimentalMaterial3Api::class)
    @Composable
    private fun LifecycleActivityContent() {
        Scaffold(
            modifier = Modifier.fillMaxSize(),
            topBar = {
                TopAppBar(title = { Text(stringResource(R.string.txt_activity_lifecycle)) })
            },
            content = { innerPadding ->
                Column(
                    modifier = Modifier
                        .fillMaxSize()
                        .padding(innerPadding)
                ) {
                    LifecycleScreen(
                        button1Text = stringResource(R.string.txt_add_fragment_one),
                        button2Text = stringResource(R.string.txt_add_fragment_one_with_backstack),
                        button3Text = stringResource(R.string.txt_add_fragment_two),
                        button4Text = stringResource(R.string.txt_add_fragment_two_with_backstack),
                        button5Text = stringResource(R.string.txt_replace_fragment_three),
                        button6Text = stringResource(R.string.txt_replace_fragment_three_with_backstack),
                        button7Text = stringResource(R.string.txt_replace_fragment_four),
                        button8Text = stringResource(R.string.txt_replace_fragment_four_with_backstack),
                        button9Text = stringResource(R.string.txt_open_blank_activity),
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
                                fragment = OneFragment.newInstance(),
                                addToBackStack = true,
                                fragmentTag = OneFragment.TAG
                            )
                        },
                        onButton3Click = {
                            addFragment(
                                containerId = ViewIds.FRAGMENT_CONTAINER,
                                fragment = TwoFragment.newInstance(),
                                addToBackStack = false,
                                fragmentTag = OneFragment.TAG
                            )
                        },
                        onButton4Click = {
                            addFragment(
                                containerId = ViewIds.FRAGMENT_CONTAINER,
                                fragment = TwoFragment.newInstance(),
                                addToBackStack = true,
                                fragmentTag = OneFragment.TAG
                            )
                        },
                        onButton5Click = {
                            replaceFragment(
                                containerId = ViewIds.FRAGMENT_CONTAINER,
                                fragment = ThreeFragment.newInstance(),
                                addToBackStack = false,
                                fragmentTag = ThreeFragment.TAG
                            )
                        },
                        onButton6Click = {
                            replaceFragment(
                                containerId = ViewIds.FRAGMENT_CONTAINER,
                                fragment = ThreeFragment.newInstance(),
                                addToBackStack = true,
                                fragmentTag = ThreeFragment.TAG
                            )
                        },
                        onButton7Click = {
                            replaceFragment(
                                containerId = ViewIds.FRAGMENT_CONTAINER,
                                fragment = FourFragment.newInstance(),
                                addToBackStack = false,
                                fragmentTag = FourFragment.TAG
                            )
                        },
                        onButton8Click = {
                            replaceFragment(
                                containerId = ViewIds.FRAGMENT_CONTAINER,
                                fragment = FourFragment.newInstance(),
                                addToBackStack = true,
                                fragmentTag = FourFragment.TAG
                            )
                        },
                        onButton9Click = {
                            openBlankActivity()
                        }
                    )
                }
            })
    }

    @Preview(showBackground = true)
    @Composable
    fun LifecycleActivityPreview() {
        LifecycleActivityContent()
    }

}
