package com.cwk.activityfragmentlifecycleapp.ui.base

import android.os.Bundle
import android.util.Log
import androidx.annotation.IdRes
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentTransaction
import com.cwk.activityfragmentlifecycleapp.ui.constants.Constants

abstract class BaseActivity : AppCompatActivity() {

    abstract val subTag: String

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Log.d(Constants.TAG_LOG, "$subTag -> onCreate called")
    }

    override fun onStart() {
        super.onStart()
        Log.d(Constants.TAG_LOG, "$subTag -> onStart called")
    }

    override fun onResume() {
        super.onResume()
        Log.d(Constants.TAG_LOG, "$subTag -> onResume called")
    }

    override fun onPause() {
        super.onPause()
        Log.d(Constants.TAG_LOG, "$subTag -> onPause called")
    }

    override fun onStop() {
        super.onStop()
        Log.d(Constants.TAG_LOG, "$subTag -> onStop called")
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.d(Constants.TAG_LOG, "$subTag -> onDestroy called")
    }

    override fun onRestart() {
        super.onRestart()
        Log.d(Constants.TAG_LOG, "$subTag -> onRestart called")
    }

    protected fun addFragment(
        @IdRes containerId: Int,
        fragment: Fragment,
        addToBackStack: Boolean = false,
        fragmentTag: String? = null,
    ) {
        getFragmentTransaction().add(
            containerId,
            fragment,
            fragmentTag
        ).apply {
            if (addToBackStack) {
                addToBackStack(fragmentTag)
            }
        }.commitFragmentTransaction()
    }

    protected fun replaceFragment(
        @IdRes containerId: Int,
        fragment: Fragment,
        addToBackStack: Boolean = false,
        fragmentTag: String? = null,
    ) {
        getFragmentTransaction().replace(
            containerId,
            fragment,
            fragmentTag
        ).apply {
            if (addToBackStack) {
                addToBackStack(fragmentTag)
            }
        }.commitFragmentTransaction()
    }

    private fun getFragmentTransaction() = supportFragmentManager.beginTransaction()

    private fun FragmentTransaction.commitFragmentTransaction() {
        if (supportFragmentManager.isStateSaved) {
            commitAllowingStateLoss()
        } else {
            commit()
        }
    }
}
