package com.lynchee.aikeyboard

import android.inputmethodservice.InputMethodService
import android.view.LayoutInflater
import android.view.View
import android.widget.Button
import android.widget.TextView
import com.lynchee.aikeyboard.R

class AIKeyboardService : InputMethodService() {

    private lateinit var chatWindow: TextView
    private lateinit var submitButton: Button

    override fun onCreateInputView(): View {
        val inputView = LayoutInflater.from(this).inflate(R.layout.keyboard_chat_window, null)

        chatWindow = inputView.findViewById(R.id.chat_window)
        submitButton = inputView.findViewById(R.id.submit_button)

        submitButton.setOnClickListener {
            val ic = currentInputConnection
            val message = ic.getTextBeforeCursor(1000, 0).toString()
            if (message.isNotEmpty()) {
                chatWindow.append("\n$message")
                ic.commitText("", 1)
            }
        }

        return inputView
    }
}
