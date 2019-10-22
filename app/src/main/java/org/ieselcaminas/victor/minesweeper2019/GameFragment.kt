package org.ieselcaminas.victor.minesweeper2019


import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.navigation.findNavController
import org.ieselcaminas.victor.minesweeper2019.databinding.FragmentGameBinding

/**
 * A simple [Fragment] subclass.
 */
class GameFragment : Fragment() {

    lateinit var binding: FragmentGameBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = DataBindingUtil.inflate(
            inflater, R.layout.fragment_game, container,
            false)

        binding.buttonWin.setOnClickListener() {
            it.findNavController().navigate(GameFragmentDirections.actionGameFragmentToWonFragment())
        }

        binding.buttonLose.setOnClickListener() {
            it.findNavController().navigate(GameFragmentDirections.actionGameFragmentToLoseFragment())
        }

        var args = GameFragmentArgs.fromBundle(arguments!!)
        Toast.makeText(context, "numRows ${args.numRows} numCols ${args.numCols}", Toast.LENGTH_LONG).show()

        return binding.root
    }


}
