package com.example.screentest

import android.content.Intent
import android.graphics.Point
import android.os.Build
import android.os.Bundle
import android.util.DisplayMetrics
import android.util.Log
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
/* val display = activity!!.windowManaver.defaultDisplay */ // in case of Fragment
        val size = Point()
        display.getRealSize(size) // or getSize(size)
        val widthx = size.x
        val heighty = size.y
        val name = Build.MODEL
        val dm = DisplayMetrics()
        windowManager.defaultDisplay.getMetrics(dm)
//        val width = dm.widthPixels.coerceAtMost(dm.heightPixels) 원래코드
        val width = widthx.coerceAtMost(heighty)
        val swWidth = dm.widthPixels.coerceAtMost(dm.heightPixels)
        //인치 구하기
        val x = Math.pow((dm.widthPixels / dm.xdpi).toDouble(), 2.0)
        val y = Math.pow((dm.heightPixels / dm.ydpi).toDouble(), 2.0)
        val screenInches = sqrt(x + y)

        val displayMetrics = this.resources.displayMetrics
        val dpHeight = displayMetrics.heightPixels / displayMetrics.density
        val dpWidth = displayMetrics.widthPixels / displayMetrics.density
        Log.e("dpHeight-----", dpHeight.toString())
        Log.e("dpWidth------", dpWidth.toString())
        Log.e("ddddddd---", displayMetrics.density.toString())
        Log.e("ddddsssddd---", displayMetrics.heightPixels.toString())
        Log.e("dddddddasdasdasddddd---", displayMetrics.widthPixels.toString())


        binding.apply {
            tvName.text = "모델명: $name"
            tvInch.text = "인치: ${String.format("%.1f", screenInches)} inch"
            tvX.text = "가로: $widthx px (${String.format("%.1f",dpWidth)} dp)"
            tvY.text = "높이: $heighty px (${String.format("%.1f",dpHeight)} dp)"
            tvRealY.text = "실제 사용 높이: ${dm.heightPixels}"
            tvDpi.text = "DPI: ${dm.densityDpi} dpi"
            tvSw.text = "smallest Width: $swWidth"
            tvSwResult.text =
                "Smallest Width DP: ${String.format("%.1f", width / (dm.densityDpi / 160.0))}"
        }
        binding.tvName.setOnClickListener {
            val intent = Intent(this,MainActivity2::class.java)
            startActivity(intent)
        }

    }
}