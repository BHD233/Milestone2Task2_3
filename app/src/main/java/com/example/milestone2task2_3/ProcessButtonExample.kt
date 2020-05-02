package com.example.milestone2task2_3

import android.app.Activity
import android.content.Context
import android.os.Bundle
import android.view.View
import android.view.inputmethod.EditorInfo
import android.view.inputmethod.InputMethodManager
import android.widget.TextView
import com.dd.processbutton.iml.SubmitProcessButton


class ProcessButtonExample : Activity(), ProgressGenerator.OnCompleteListener {
    public override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.process_button_example)

        val user = findViewById<TextView>(R.id.process_button_example_user)
        val pass = findViewById<TextView>(R.id.process_button_example_pass)

        val progressGenerator = ProgressGenerator(this)
        val btnSignIn = findViewById<View>(R.id.process_button) as SubmitProcessButton

        btnSignIn.setOnClickListener {
            if (user.text != "" && pass.text != "") {
                progressGenerator.start(btnSignIn)

                btnSignIn.isEnabled = false

                val imm: InputMethodManager =
                    getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
                imm.hideSoftInputFromWindow(user.getWindowToken(), 0)

                pass.clearFocus()
                user.clearFocus()
            }
        }
    }

    override fun onComplete() {
    }
}