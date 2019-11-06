package org.ieselcaminas.victor.minesweeper2019


import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.FrameLayout
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.navigation.findNavController
import org.ieselcaminas.victor.minesweeper2019.databinding.FragmentGameBinding

/**
 * A simple [Fragment] subclass.
 */
class GameFragment : Fragment() {

    lateinit var binding: FragmentGameBinding
    lateinit var board: Array<Array<MineButton>>
    lateinit var bombMatrix: BombMatrix
    var numRows: Int = 0
    var numCols: Int = 0

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
        numRows = args.numRows
        numCols = args.numCols
        bombMatrix = BombMatrix(numRows, numCols, (numRows * numCols) / 6)
        Toast.makeText(context, "Rows = $numRows Cols = $numCols",
            Toast.LENGTH_LONG).show()

        createButtons()

        for (i in -1 .. 5) {
            println(i)
        }

        return binding.root
    }


    private fun createButtons() {
        board = Array(numCols) { col ->
            Array(numRows) { row ->
                MineButton(context!!, row, col)
            }
        }
        binding.gridLayout.columnCount = numCols
        binding.gridLayout.rowCount = numRows
        for (col in 0..numCols-1) {
            for (row in 0..numRows-1) {
                var frameLayout = FrameLayout(context!!)
                val backgroundImageView = ImageView(context!!)
                backgroundImageView.setImageResource(R.drawable.back)
                setSizeBackView(backgroundImageView)
                frameLayout.addView(backgroundImageView)
                frameLayout.addView(board[row][col])
                binding.gridLayout.addView(frameLayout)
                board[row][col].setOnClickListener() {
                    val button = it as MineButton
                    if (button.state == StateType.CLOSED) {
                        println("row: ${button.row} col: ${button.col}")
                        button.visibility = View.INVISIBLE
                    }

                }
            }
        }
        /* for (line in board) {
            for (button in line) {
                binding.gridLayout.addView(button)
                button.setOnClickListener() {
                    println("row: ${button.row} col: ${button.col}")
                }
            }
        } */


    }

    private fun setSizeBackView(backgroundImageView: ImageView) {
        var layoutParams = LinearLayout.LayoutParams(SIZE, SIZE)
        backgroundImageView.setPadding(0, 0, 0, 0)
        backgroundImageView.scaleType = ImageView.ScaleType.CENTER
        backgroundImageView.adjustViewBounds = true
        backgroundImageView.layoutParams = layoutParams
    }


}
