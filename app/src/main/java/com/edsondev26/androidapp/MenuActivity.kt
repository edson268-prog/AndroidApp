package com.edsondev26.androidapp

import android.content.Intent
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.AppCompatButton
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.edsondev26.androidapp.bmicalculator.mbiCalculatorActivity
import com.edsondev26.androidapp.firstapp.FirstAppActivity
import com.edsondev26.androidapp.settings.SettingsActivity
import com.edsondev26.androidapp.superheroapp.SuperHeroListActivity
import com.edsondev26.androidapp.todoapp.TodoAppActivity

class MenuActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_menu)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val btnFirstApp = findViewById<AppCompatButton>(R.id.btnFirstApp)
        val btnBMIApp = findViewById<AppCompatButton>(R.id.btnBMIApp)
        val btnTODOApp = findViewById<AppCompatButton>(R.id.btnTODOApp)
        val btnSuperHero = findViewById<AppCompatButton>(R.id.btnSuperHero)
        val btnSettings = findViewById<AppCompatButton>(R.id.btnSettings)
        btnFirstApp.setOnClickListener { navigateToFirstApp() }
        btnBMIApp.setOnClickListener { navigateToBMIApp() }
        btnTODOApp.setOnClickListener { navigateToTODOApp() }
        btnSuperHero.setOnClickListener { navigateToSuperHeroApp() }
        btnSettings.setOnClickListener { navigateToSettings() }
    }

    private fun navigateToSuperHeroApp() {
        val intent = Intent(this, SuperHeroListActivity::class.java)
        startActivity(intent)
    }

    private fun navigateToBMIApp() {
        val intent = Intent(this, mbiCalculatorActivity::class.java)
        startActivity(intent)
    }

    private fun navigateToFirstApp() {
        val intent = Intent(this, FirstAppActivity::class.java)
        startActivity(intent)
    }

    private fun navigateToTODOApp() {
        val intent = Intent(this, TodoAppActivity::class.java)
        startActivity(intent)
    }

    private fun navigateToSettings() {
        val intent = Intent(this, SettingsActivity::class.java)
        startActivity(intent)
    }
}