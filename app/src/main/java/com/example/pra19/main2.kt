package com.example.pra19

import android.annotation.SuppressLint
import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.EditText
import androidx.core.content.edit
import com.google.android.material.snackbar.Snackbar

class main2 : AppCompatActivity() {

    companion object {
        const val CORRECT_LOGIN = "ects"
        const val CORRECT_PASSWORD = "ects2024"
    }

    private lateinit var editTextLogin: EditText
    private lateinit var editTextPassword: EditText
    private val sharedPref by lazy {
        getSharedPreferences("user_prefs", Context.MODE_PRIVATE)
    }

    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main2)

        editTextLogin = findViewById(R.id.editTextLogin)
        editTextPassword = findViewById(R.id.editTextPassword)

        // Автозаполнение сохраненных данных
        loadSavedCredentials()
    }

    private fun loadSavedCredentials() {
        val savedLogin = sharedPref.getString("login", "") ?: ""
        val savedPassword = sharedPref.getString("password", "") ?: ""

        editTextLogin.setText(savedLogin)
        editTextPassword.setText(savedPassword)
    }

    fun per(view: View) {
        val login = editTextLogin.text.toString().trim()
        val password = editTextPassword.text.toString().trim()

        when {
            // Проверка на пустые поля
            login.isEmpty() || password.isEmpty() -> {
                showSnackbar("Введите логин и пароль")
            }
            // Проверка корректности данных
            login == CORRECT_LOGIN && password == CORRECT_PASSWORD -> {
                saveCredentials(login, password)
                navigateToSecondScreen()
            }
            // Проверка сохраненных данных
            login == sharedPref.getString("login", null) &&
                    password == sharedPref.getString("password", null) -> {
                navigateToSecondScreen()
            }
            else -> {
                showSnackbar("Неверный логин или пароль")
            }
        }
    }

    private fun saveCredentials(login: String, password: String) {
        sharedPref.edit {
            putString("login", login)
            putString("password", password)
        }
    }

    private fun navigateToSecondScreen() {
        startActivity(Intent(this, Second::class.java))
    }

    private fun showSnackbar(message: String) {
        Snackbar.make(
            findViewById(android.R.id.content),
            message,
            Snackbar.LENGTH_LONG
        ).setAction("OK") {}.show()
    }
}