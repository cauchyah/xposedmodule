package com.en.xposedmodule

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import com.en.xposedmodule.databinding.ActivityMainBinding
import org.greenrobot.eventbus.EventBus
import org.greenrobot.eventbus.Subscribe

class MainActivity : AppCompatActivity() {
    private lateinit var   binding:ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
         EventBus.getDefault().register(this)
         binding=ActivityMainBinding.inflate(LayoutInflater.from(this))

    }

    @Subscribe
    public fun onEvent(event: Event){
        binding.ivMark.setImageBitmap(BitmapCache.watermarkBitmap?:return)
        binding.ivOrigin.setImageBitmap(BitmapCache.originBitmap?:return)
    }

    override fun onDestroy() {
        super.onDestroy()
        EventBus.getDefault().unregister(this)
    }


}