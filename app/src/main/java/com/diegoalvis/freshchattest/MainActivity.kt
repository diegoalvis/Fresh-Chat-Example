package com.diegoalvis.freshchattest

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.freshchat.consumer.sdk.Freshchat
import kotlinx.android.synthetic.main.activity_main.*


class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Get the user object for the current installation
        val freshchatUser = Freshchat.getInstance(applicationContext).user.apply {
            firstName = "Pelican"
            lastName = "Test"
            email = "diego@pelican.com"
        }
        // Call setUser so that the user information is synced with Freshchat's servers
        Freshchat.getInstance(applicationContext).user = freshchatUser

        button.setOnClickListener { Freshchat.showConversations(applicationContext) }

    }
}