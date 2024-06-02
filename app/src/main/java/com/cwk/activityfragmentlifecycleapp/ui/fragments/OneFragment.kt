package com.cwk.activityfragmentlifecycleapp.ui.fragments

import android.view.LayoutInflater
import android.view.ViewGroup
import com.cwk.activityfragmentlifecycleapp.databinding.LayoutFragmentOneBinding
import com.cwk.activityfragmentlifecycleapp.ui.base.BaseFragment

class OneFragment : BaseFragment<LayoutFragmentOneBinding>() {

    override val subTag: String get() = "OneFragment"

    override val bindingInflater: (LayoutInflater, ViewGroup?, Boolean) -> LayoutFragmentOneBinding = LayoutFragmentOneBinding::inflate

    companion object {
        fun newInstance() = OneFragment()

        const val TAG = "OneFragment"
    }
}