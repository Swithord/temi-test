package com.example.temitest

import android.os.Bundle
import android.widget.Button
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.temitest.ui.theme.TemitestTheme
import com.robotemi.sdk.Robot
import com.robotemi.sdk.TtsRequest
import com.robotemi.sdk.Robot.Companion.getInstance
import com.robotemi.sdk.TtsRequest.Companion.create

class MainActivity : ComponentActivity(), Robot.TtsListener {
    private lateinit var robot: Robot
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        robot = getInstance()

        val speechButton: Button = findViewById(R.id.speechButton)

        speechButton.setOnClickListener {
            // Code to execute when the button is clicked
            speak()
        }
    }

    override fun onStart() {
        super.onStart()
        robot.addTtsListener(this)
    }

    override fun onStop() {
        robot.removeTtsListener(this)
        super.onStop()
    }

    override fun onTtsStatusChanged(ttsRequest: TtsRequest) {
        TODO("Not yet implemented")
    }

    private fun speak() {
        robot.speak(create("NEC is a suite of contracts that are designed to be used in the construction industry for various types of projects."))
    }
}
