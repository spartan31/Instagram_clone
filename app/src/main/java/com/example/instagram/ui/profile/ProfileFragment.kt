package com.example.instagram.ui.profile

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.instagram.R
import com.example.instagram.databinding.ProfileFragmentBinding
import com.example.instagram.model.local.HightlightDataModel
import com.google.android.material.tabs.TabLayoutMediator
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class ProfileFragment : Fragment() {

    private lateinit var binding: ProfileFragmentBinding
    lateinit var hightLightImgArray: ArrayList<HightlightDataModel>
    lateinit var viewPagerAdapter: ViewPagerAdapter
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View {
        binding = ProfileFragmentBinding.inflate(inflater, container, false)
        viewPagerAdapter = ViewPagerAdapter(this)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        hightLightImgArray = ArrayList()
        binding.viewPager.adapter = viewPagerAdapter


        hightLightImgArray.add(HightlightDataModel(R.drawable.baseline_add_24, "AddMoreImage"))
        hightLightImgArray.add(HightlightDataModel(R.drawable.img, "HighLightImage1"))
        hightLightImgArray.add(HightlightDataModel(R.drawable.img2, "HighLightImage2"))
        hightLightImgArray.add(HightlightDataModel(R.drawable.img3, "HighLightImage3"))


    }
}