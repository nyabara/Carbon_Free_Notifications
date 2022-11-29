package com.example.carbon_free_notifications

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.navArgs
import com.example.carbon_free_notifications.databinding.FragmentThirdBinding
import com.example.carbon_free_notifications.viewmodel.MyViewModel
import dagger.hilt.android.AndroidEntryPoint


@AndroidEntryPoint
class ThirdFragment : Fragment() {

    private lateinit var _binding: FragmentThirdBinding
    private val binding get() = _binding!!

    private val myViewModel: MyViewModel by viewModels()
    private val args: ThirdFragmentArgs by navArgs()
    val myCarbonFree by lazy { args.myCarbonFree }
    val argument by lazy { arguments?.getString("myCarbonFree") }
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        _binding = FragmentThirdBinding.inflate(inflater, container, false)

        binding.textView.text = argument

       // binding.lottieAnim.setAnimation(args.myCarbonFree.carbonFreeLottie)
        //binding.lottieAnim.playAnimation()

        return binding.root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding.root
    }
}