package com.example.screentest

import android.graphics.Point
import android.os.Build
import android.os.Bundle
import android.util.DisplayMetrics
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import com.example.screentest.databinding.ActivityMainBinding
import kotlin.math.sqrt


class MainActivity : AppCompatActivity() {

    lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)

        val display = windowManager.defaultDisplay // in case of Activity
        val size = Point()
        display.getRealSize(size) // or getSize(size)
        val width = size.x
        val height = size.y
        val name = Build.MODEL
        val dm = DisplayMetrics()
        windowManager.defaultDisplay.getMetrics(dm)

        //인치 구하기
        val x = Math.pow((dm.widthPixels / dm.xdpi).toDouble(), 2.0)
        val y = Math.pow((dm.heightPixels / dm.ydpi).toDouble(), 2.0)
        val screenInches = sqrt(x + y)

        binding.apply {
            tvName.text = "모델명: $name"
            tvInch.text = "인치: $screenInches"
            tvX.text = "가로: $width"
            tvY.text = "세로: $height"
            tvDpi.text = "DPI: ${dm.densityDpi}"
            tvSwResult.text = "sw dp: ${width / (dm.densityDpi / 160.0)}"
        }

    }
}