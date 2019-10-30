package org.ieselcaminas.victor.minesweeper2019

import android.content.Context
import android.widget.Button
import android.widget.LinearLayout
import androidx.core.content.ContextCompat.getDrawable


class MineButton(context: Context, var row: Int, var col: Int): Button(context) {

    //var row: Int = row
    //var col: Int = col
    val SIZE = 50
    public var state: StateType = StateType.CLOSED

    init {
        layoutParams = LinearLayout.LayoutParams(SIZE, SIZE)
        setBackground(getDrawable(context, R.drawable.boton))
    }

}