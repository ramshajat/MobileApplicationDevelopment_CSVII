package com.example.task01

import android.content.Intent
import android.content.IntentFilter
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuInflater
import android.view.MenuItem

class Home : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)
    }

    override fun onCreatePanelMenu(featureId: Int, menu: Menu): Boolean {
        var inflateMenu:MenuInflater =menuInflater;
        inflateMenu.inflate(R.menu.option_menu,menu)

        return super.onCreatePanelMenu(featureId, menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        var id = item.itemId

        if(id == R.id.logoutItem){
            var intent: Intent = Intent(this,MainActivity::class.java)
            intent.flags = Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK
            startActivity(intent)
        }
        return super.onOptionsItemSelected(item)
    }
}