package com.example.carbon_free_notifications

import android.graphics.Bitmap
import android.graphics.BitmapFactory
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.StaggeredGridLayoutManager
import com.example.carbon_free_notifications.adapter.CarbonFreeAdapter
import com.example.carbon_free_notifications.databinding.FragmentSecondBinding
import com.example.carbon_free_notifications.model.CarbonFree
import com.example.carbon_free_notifications.viewmodel.MyViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class SecondFragment : Fragment(), CarbonFreeAdapter.ClickListener {

    private lateinit var _binding: FragmentSecondBinding
    private val binding get() = _binding!!

    private val myViewModel: MyViewModel by viewModels()
    private lateinit var carbonFreeList: MutableList<CarbonFree>

    private val carbonFreeAdapter by lazy { CarbonFreeAdapter(this) }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        _binding = FragmentSecondBinding.inflate(inflater, container, false)


        val myList = mutableListOf<CarbonFree>(
            CarbonFree(1, "Recycle", R.raw.recycle_icon_animation),
            CarbonFree(2, "Save Water", R.raw.water_bottle),
            CarbonFree(3, "Grow Trees", R.raw.growing_plant),

            CarbonFree(4, "Clean Energy", R.raw.save_energy),
            CarbonFree(5, "Low Carbon Vehicles", R.raw.electric_car),

            CarbonFree(6, "Organic Foods", R.raw.gardenernergy),
            CarbonFree(7, "Eco-Friendly Products", R.raw.sustainable_consume),
            CarbonFree(8, "Minimize Food Waste", R.raw.food_animation),
            CarbonFree(9, "Cut Out Plastic", R.raw.vp_greenify_the_earth),
            CarbonFree(10, "Safe Air Travel", R.raw.no_place_like_home_flight)

        )
        carbonFreeList = myList

        setUpRecyclerView()

        carbonFreeAdapter.differ.submitList(carbonFreeList)

        return binding.root
    }


    private fun setUpRecyclerView() {
        binding.recyclerView.apply {
            layoutManager = StaggeredGridLayoutManager(2, StaggeredGridLayoutManager.VERTICAL)
            adapter = carbonFreeAdapter
            setHasFixedSize(true)
        }
    }

    override fun onMyItemClick(carbonFree: CarbonFree) {

        val bitmap = BitmapFactory.decodeResource(resources, R.drawable.aaa)

        myViewModel.showSimpleNotificationRecycler(
            carbonFree.carbonFreeName,
            carbonFree.carbonFreeLottie.toString(),
            bitmap
        )

        val myBundle = Bundle()
        myBundle.putParcelable("first_fragment_bundle", carbonFree)


//        val secondFragment = SecondFragment()
//        secondFragment.arguments = myBundle
//
//
//
//        fragmentManager?.beginTransaction()
//            ?.replace(R.id.navHost, secondFragment)
//            ?.commit()

        //val action = SecondFragmentDirections.actionSecondFragmentToThirdFragment(carbonFree)
        //findNavController().navigate(action)

        Toast.makeText(requireContext(), "${carbonFree.id}", Toast.LENGTH_SHORT).show()
    }


    override fun onDestroyView() {
        super.onDestroyView()
        _binding.root
    }
}