package com.edsondev26.androidapp.bmicalculator

import android.content.Intent
import android.content.res.ColorStateList
import android.icu.text.DecimalFormat
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.cardview.widget.CardView
import androidx.core.content.ContextCompat
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.edsondev26.androidapp.R
import com.google.android.material.floatingactionbutton.FloatingActionButton
import com.google.android.material.slider.RangeSlider

class mbiCalculatorActivity : AppCompatActivity() {
    private var isMaleSelected: Boolean = true
    private var isFemaleSelected: Boolean = false
    private var currentHeight: Int = 120
    private var currentWeight: Int = 50
    private var currentAge: Int = 20

    private lateinit var viewMale: CardView
    private lateinit var viewFemale: CardView
    private lateinit var tvHeight:TextView
    private lateinit var rsHeight:RangeSlider
    private lateinit var btnPlusWeight:FloatingActionButton
    private lateinit var btnSubtractWeight:FloatingActionButton
    private lateinit var tvWeight:TextView
    private lateinit var btnPlusAge:FloatingActionButton
    private lateinit var btnSubtractAge:FloatingActionButton
    private lateinit var tvAge:TextView
    private lateinit var btnCalculate:Button

    companion object{
        const val BMI_KEY = "BMI_RESULT"
    }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_mbi_calculator)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        initComponents()
        initListeners()
        initUI();
    }

    private fun initComponents() {
        viewMale = findViewById(R.id.viewMale)
        viewFemale = findViewById(R.id.viewFemale)
        tvHeight = findViewById(R.id.tvHeight)
        rsHeight = findViewById(R.id.rsHeight)
        btnPlusWeight = findViewById(R.id.btnPlusWeight)
        btnSubtractWeight = findViewById(R.id.btnSubtractWeight)
        tvWeight = findViewById(R.id.tvWeight)
        btnPlusAge = findViewById(R.id.btnPlusAge)
        btnSubtractAge = findViewById(R.id.btnSubtractAge)
        tvAge = findViewById(R.id.tvAge)
        btnCalculate = findViewById(R.id.btnCalculate)
    }

    private fun initListeners() {
        viewMale.setOnClickListener { handleGenderClick(viewMale) }
        viewFemale.setOnClickListener { handleGenderClick(viewFemale) }
        rsHeight.addOnChangeListener { _, value, _ ->
            val df = DecimalFormat("#.##");
            currentHeight = df.format(value).toInt()
            tvHeight.text = "$currentHeight cm"
        }
        btnPlusWeight.setOnClickListener {
            currentWeight += 1
            setWeight()
        }
        btnSubtractWeight.setOnClickListener {
            currentWeight -= 1
            setWeight()
        }
        btnPlusAge.setOnClickListener {
            currentAge +=1;
            setAge();
        }
        btnSubtractAge.setOnClickListener {
            currentAge -=1;
            setAge();
        }
        btnCalculate.setOnClickListener{
            val result = calculateBMI()
            navigateToResult(result)
        }
    }

    private fun navigateToResult(result: Double) {
        val intent = Intent(this, ResultBMIActivity::class.java)
        intent.putExtra(BMI_KEY, result)
        startActivity(intent)
    }

    private fun calculateBMI(): Double {
        val df = DecimalFormat("#.##");
        val heightSquared = currentHeight.toDouble()/100 * currentHeight.toDouble()/100
        val bmi = if (heightSquared > 0) currentWeight / heightSquared else 0.0
        return df.format(bmi).toDouble()
    }

    private fun setAge() {
        tvAge.text = currentAge.toString()
    }

    private fun setWeight() {
        tvWeight.text = currentWeight.toString()
    }

    fun handleGenderClick(cardView: CardView) {
        val selectedColor = ContextCompat.getColor(this, R.color.background_component_selected)

        val colorStateList: ColorStateList = cardView.cardBackgroundColor
        val color: Int = colorStateList.defaultColor
        if (color != selectedColor) {
            changeGender()
            setGenderColor()
        }
    }

    private fun changeGender() {
        isMaleSelected = !isMaleSelected
        isFemaleSelected = !isFemaleSelected
    }

    private fun setGenderColor() {
        viewMale.setCardBackgroundColor(getBackgroundColor(isMaleSelected))
        viewFemale.setCardBackgroundColor(getBackgroundColor(isFemaleSelected))
    }

    private fun getBackgroundColor(isSelectedComponent: Boolean): Int {
        val colorReference = if (isSelectedComponent) {
            R.color.background_component_selected
        } else {
            R.color.background_component
        }
        return ContextCompat.getColor(this, colorReference)
    }

    private fun initUI() {
        setGenderColor()
        setWeight()
        setAge()
    }
}