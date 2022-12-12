package com.example.rotationtoogle

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.ImageView
import kotlin.concurrent.thread

class MainActivity : AppCompatActivity() {
    var isRotating: Boolean = false
    lateinit var image: ImageView
    var rotationAngle: Int = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        image = findViewById(R.id.imgForRotate)
        image.setImageResource(R.drawable.androidimage)

        val thread = Thread(Runnable {
            while (true){
                rotationAngle+=10;
                if(isRotating){
                    image.rotation = rotationAngle.toFloat()
                    if(rotationAngle==100){
                        rotationAngle=0
                    }
                }
            }
            Thread.sleep(3000)
        })
        thread.start()
    }

    fun doRotate(view: View){
        if(isRotating){
            isRotating = false
        }
        else{
            isRotating = true
        }
    }
}