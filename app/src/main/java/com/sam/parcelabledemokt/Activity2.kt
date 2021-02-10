package com.sam.parcelabledemokt

import android.os.Bundle
import android.view.MotionEvent
import android.view.View
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class Activity2 : AppCompatActivity() , View.OnTouchListener{
    val STEP = 200f
    var mRatio = 1.0f
    var mBaseDist = 0
    var mBaseRatio = 0f
    var fontsize = 13f
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_2)
        intent?.let {
           val user = intent.extras?.getParcelable<User>(MainActivity.USER)
            val txtViewData = findViewById<TextView>(R.id.txt_data)
            txtViewData.setTextSize(mRatio + 13)
            txtViewData.text = user.toString()
        }
    }

    override fun onTouchEvent(event: MotionEvent?): Boolean {
        val txtViewData = findViewById<TextView>(R.id.txt_data)
        if (event!!.pointerCount === 2) {
            val action = event!!.action
            val pureaction = action and  MotionEvent.ACTION_MASK
            if (pureaction == MotionEvent.ACTION_POINTER_DOWN) {
                mBaseDist = getDistance(event)
                mBaseRatio = mRatio
            } else {
                val delta: Float = (getDistance(event) - mBaseDist) / STEP
                val multi = Math.pow(2.0, delta.toDouble()).toFloat()
                mRatio = Math.min(1024.0f, Math.max(0.1f, mBaseRatio * multi))
                txtViewData?.setTextSize(mRatio + 13)
            }
        }
        return true
        return super.onTouchEvent(event)
    }
    fun getDistance(event: MotionEvent): Int {
        val dx = (event.getX(0) - event.getX(1)).toInt()
        val dy = (event.getY(0) - event.getY(1)).toInt()
        return Math.sqrt(dx * dx + dy * dy.toDouble()).toInt()
    }

    override fun onTouch(v: View?, event: MotionEvent?): Boolean {
        return false
    }

}