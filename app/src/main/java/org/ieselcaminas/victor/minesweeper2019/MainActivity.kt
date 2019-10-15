package org.ieselcaminas.victor.minesweeper2019

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import org.ieselcaminas.victor.minesweeper2019.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //setContentView(R.layout.activity_main)
        binding = DataBindingUtil.setContentView(this,
            R.layout.activity_main)

        var s: String? = "Hello"
        println(s.myUppercase())
    }

}

fun String?.myUppercase(): String {
    if (this == null) {return "[NULL]" }
    return "[" + this.toUpperCase() + "]"
}
