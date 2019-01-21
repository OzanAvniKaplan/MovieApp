package com.ozan.movieapp.ui.splash

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import com.ozan.movieapp.MainActivity
import com.ozan.movieapp.R
import com.ozan.movieapp.base.BaseActivity
import dagger.android.AndroidInjection

@Suppress("IMPLICIT_CAST_TO_ANY")
class SplashActivity : BaseActivity() {

    private var mDelayHandler: Handler? = null
    private val splashDelay: Long = 3000 //3 seconds

    override fun onCreate(savedInstanceState: Bundle?) {
        AndroidInjection.inject(this)
        super.onCreate(savedInstanceState)
        setContentView(R.layout.splash)

        //Initialize the Handler
        mDelayHandler = Handler()

        //Navigate with delay
        mDelayHandler!!.postDelayed(mRunnable, splashDelay)
    }

    private val mRunnable: Runnable = Runnable {
        if (!isFinishing) {

            val intent = Intent(applicationContext, MainActivity::class.java)
            startActivity(intent)
            finish()
        }
    }

    public override fun onDestroy() {

        if (mDelayHandler != null) {
            mDelayHandler!!.removeCallbacks(mRunnable)
        }

        super.onDestroy()
    }
}