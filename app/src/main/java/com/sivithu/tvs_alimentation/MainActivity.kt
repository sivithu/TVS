package com.sivithu.tvs_alimentation

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.InputType
import android.view.MotionEvent
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.ImageView
import android.widget.TextView

class MainActivity : AppCompatActivity() {

    lateinit var logo : ImageView
    lateinit var identifiantTextView : TextView
    lateinit var identifiantEditText: EditText
    lateinit var passwordTextView: TextView
    lateinit var passwordEditText: EditText
    lateinit var connectButton: Button
    lateinit var inscriptionButton: Button

    private var inputTypePassword : Int = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Liaison entre le design et le code
        logo = findViewById(R.id.logo_iv)
        identifiantTextView = findViewById(R.id.identifiant_tv)
        identifiantEditText = findViewById(R.id.identifiant_et)
        passwordTextView = findViewById(R.id.password_tv)
        passwordEditText = findViewById(R.id.password_et)
        connectButton = findViewById(R.id.connect_btn)
        inscriptionButton = findViewById(R.id.inscription_btn)

        // Action pour afficher/cacher le mot de passe
        inputTypePassword = passwordEditText.inputType

        passwordEditText.setOnTouchListener(object : View.OnTouchListener {
            override fun onTouch(v: View?, event: MotionEvent?): Boolean {
                val DRAWABLE_RIGHT = 2;

                if (event?.action == MotionEvent.ACTION_UP) {
                    if (event.rawX >= (passwordEditText.right - passwordEditText.compoundDrawables[DRAWABLE_RIGHT].bounds.width())) {
                        if (passwordEditText.inputType == inputTypePassword) passwordEditText.inputType = InputType.TYPE_TEXT_VARIATION_VISIBLE_PASSWORD
                        else passwordEditText.inputType = inputTypePassword
                        return true
                    }
                }
                return false
            }
        })

        // Aller a la page d'inscription
        inscriptionButton.setOnClickListener {
            val intent = Intent(this@MainActivity, InscripitionActivity::class.java)
            startActivity(intent)
        }

        // Aller à la page d'accueil
        connectButton.setOnClickListener {
            val intent = Intent(this@MainActivity, HomeActivity::class.java)
            startActivity(intent)
        }
    }
}