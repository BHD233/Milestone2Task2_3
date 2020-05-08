package com.example.milestone2task2_3

import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity
import me.grantland.widget.AutofitTextView

class AutoFitTextViewSample: AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.auto_fit_text_view_sample)

        var editText = findViewById<EditText>(R.id.auto_fit_text_view_edit_text)

        var textView = findViewById<AutofitTextView>(R.id.auto_fit_text_view_text_view)

        editText.addTextChangedListener(object : TextWatcher {
            override fun afterTextChanged(s: Editable?) {
            }

            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {

            }

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
                textView.text = editText.text
            }

        })
    }
}