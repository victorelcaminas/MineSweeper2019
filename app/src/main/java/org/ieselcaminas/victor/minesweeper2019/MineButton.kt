package org.ieselcaminas.victor.minesweeper2019

import android.content.Context
import android.widget.Button
import android.widget.LinearLayout
import androidx.core.content.ContextCompat.getDrawable
import androidx.databinding.DataBindingUtil
import org.ieselcaminas.victor.minesweeper2019.databinding.FragmentGameBinding


class MineButton(context: Context, var row: Int, var col: Int): Button(context, null, android.R.attr.buttonStyleSmall) {

    //var row: Int = row
    //var col: Int = col
    val SIZE = 50
    public var state: StateType = StateType.CLOSED

    init {
        layoutParams = LinearLayout.LayoutParams(SIZE, SIZE)
        setBackground(getDrawable(context, R.drawable.boton))
    }

}