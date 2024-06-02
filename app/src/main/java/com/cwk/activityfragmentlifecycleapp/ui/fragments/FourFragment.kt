package com.cwk.activityfragmentlifecycleapp.ui.fragments

import android.view.LayoutInflater
import android.view.ViewGroup
import com.cwk.activityfragmentlifecycleapp.databinding.LayoutFragmentFourBinding
import com.cwk.activityfragmentlifecycleapp.ui.base.BaseFragment

class FourFragment private constructor() : BaseFragment<LayoutFragmentFourBinding>() {

    override val subTag: String = "FourFragment"

    override val bindingInflater: (LayoutInflater, ViewGroup?, Boolean) -> LayoutFragmentFourBinding = LayoutFragmentFourBinding::inflate

    companion object {
        fun newInstance() = FourFragment()

        const val TAG = "FourFragment"
    }
}