package com.cwk.activityfragmentlifecycleapp.ui.base

import android.content.Context
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.viewbinding.ViewBinding
import com.cwk.activityfragmentlifecycleapp.ui.constants.Constants

abstract class BaseFragment<T : ViewBinding> : Fragment() {

    abstract val subTag: String

    abstract val bindingInflater: (LayoutInflater, ViewGroup?, Boolean) -> T

    private var _binding: T? = null

    val binding: T get() = _binding!!

    override fun onAttach(context: Context) {
        super.onAttach(context)
        Log.d(Constants.APP_TAG, "$subTag -> onAttach called")
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Log.d(Constants.APP_TAG, "$subTag -> onCreate called")
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        bindingInflater.invoke(inflater, container, false).also {
            _binding = it
        }
        return binding.root.also {
            Log.d(Constants.APP_TAG, "$subTag -> onCreateView called")
        }
    }

    override fun onStart() {
        super.onStart()
        Log.d(Constants.APP_TAG, "$subTag -> onStart called")
    }

    override fun onResume() {
        super.onResume()
        Log.d(Constants.APP_TAG, "$subTag -> onResume called")
    }

    override fun onPause() {
        super.onPause()
        Log.d(Constants.APP_TAG, "$subTag -> onPause called")
    }

    override fun onStop() {
        super.onStop()
        Log.d(Constants.APP_TAG, "$subTag -> onStop called")
    }

    override fun onDestroyView() {
        super.onDestroyView()
        Log.d(Constants.APP_TAG, "$subTag -> onDestroyView called")
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.d(Constants.APP_TAG, "$subTag -> onDestroy called")
    }

    override fun onDetach() {
        super.onDetach()
        Log.d(subTag, "$subTag -> onDetach called")
    }
}
