package com.cwk.activityfragmentlifecycleapp.ui.fragments

import android.view.LayoutInflater
import android.view.ViewGroup
import com.cwk.activityfragmentlifecycleapp.databinding.LayoutFragmentThreeBinding
import com.cwk.activityfragmentlifecycleapp.ui.base.BaseFragment

class ThreeFragment : BaseFragment<LayoutFragmentThreeBinding>() {

    override val subTag: String get() = "ThreeFragment"

    override val bindingInflater: (LayoutInflater, ViewGroup?, Boolean) -> LayoutFragmentThreeBinding = LayoutFragmentThreeBinding::inflate

    companion object {
        fun newInstance() = ThreeFragment()

        const val TAG = "ThreeFragment"
    }
}