package com.example.instagram.ui.profile

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.GridLayoutManager
import com.example.instagram.R
import com.example.instagram.databinding.UserPostsFragmentBinding
import com.example.instagram.model.local.HightlightDataModel

class UserPostFragment : Fragment() {
    private lateinit var bindngUserPostFragment: UserPostsFragmentBinding
    val sampleData = ArrayList<HightlightDataModel>()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View {
        bindngUserPostFragment = UserPostsFragmentBinding.inflate(inflater, container, false)

        // Add some items to the sample data
        sampleData.add(HightlightDataModel(R.drawable.img, "HighLightImage1"))
        sampleData.add(HightlightDataModel(R.drawable.img, "HighLightImage1"))
        sampleData.add(HightlightDataModel(R.drawable.img, "HighLightImage1"))
        sampleData.add(HightlightDataModel(R.drawable.img, "HighLightImage1"))
        sampleData.add(HightlightDataModel(R.drawable.img, "HighLightImage1"))
        sampleData.add(HightlightDataModel(R.drawable.img, "HighLightImage1"))
        sampleData.add(HightlightDataModel(R.drawable.img, "HighLightImage1"))


        return bindngUserPostFragment.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

    }
}
