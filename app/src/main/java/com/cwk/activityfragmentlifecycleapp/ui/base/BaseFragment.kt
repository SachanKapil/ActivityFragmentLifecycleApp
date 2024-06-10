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
        Log.d(Constants.TAG_LOG, "$subTag -> onAttach called")
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Log.d(Constants.TAG_LOG, "$subTag -> onCreate called")
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        bindingInflater.invoke(inflater, container, false).also {
            _binding = it
        }
        return binding.root.also {
            Log.d(Constants.TAG_LOG, "$subTag -> onCreateView called")
        }
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        Log.d(Constants.TAG_LOG, "$subTag -> onViewCreated called")
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

    override fun onDestroyView() {
        super.onDestroyView()
        Log.d(Constants.TAG_LOG, "$subTag -> onDestroyView called")
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.d(Constants.TAG_LOG, "$subTag -> onDestroy called")
    }

    override fun onDetach() {
        super.onDetach()
        Log.d(Constants.TAG_LOG, "$subTag -> onDetach called")
    }
}
