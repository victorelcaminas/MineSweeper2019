package org.ieselcaminas.victor.minesweeper2019


import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.navigation.Navigation
import androidx.navigation.findNavController
import org.ieselcaminas.victor.minesweeper2019.databinding.FragmentConfigBinding

/**
 * A simple [Fragment] subclass.
 */
class ConfigFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment

        val binding: FragmentConfigBinding = DataBindingUtil.inflate(inflater,
            R.layout.fragment_config,
            container, false)
        binding.buttonPlay.setOnClickListener() {
            //Navigation.findNavController(it).navigate(R.id.action_configFragment_to_gameFragment)
            it.findNavController().navigate(R.id.action_configFragment_to_gameFragment)
        }
        return binding.root
    }


}
