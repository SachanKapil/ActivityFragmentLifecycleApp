package com.cwk.activityfragmentlifecycleapp.ui.fragments

import android.view.LayoutInflater
import android.view.ViewGroup
import com.cwk.activityfragmentlifecycleapp.databinding.LayoutFragmentTwoBinding
import com.cwk.activityfragmentlifecycleapp.ui.base.BaseFragment

class TwoFragment : BaseFragment<LayoutFragmentTwoBinding>() {

    override val subTag: String get() = "TwoFragment"

    override val bindingInflater: (LayoutInflater, ViewGroup?, Boolean) -> LayoutFragmentTwoBinding = LayoutFragmentTwoBinding::inflate

    companion object {
        fun newInstance() = TwoFragment()

        const val TAG = "TwoFragment"
    }
}