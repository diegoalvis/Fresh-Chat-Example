package com.diegoalvis.freshchattest

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.freshchat.consumer.sdk.ConversationOptions
import com.freshchat.consumer.sdk.Freshchat
import kotlinx.android.synthetic.main.activity_main.*


class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Get the user object for the current installation
        val freshchatUser = Freshchat.getInstance(applicationContext).user.apply {
            firstName = "Picker"
            lastName = "Test"
            email = "diego@pelican.com"
        }
        // Call setUser so that the user information is synced with Freshchat's servers
        Freshchat.getInstance(applicationContext).user = freshchatUser

        /* Set any custom metadata to give agents more context, and for segmentation for marketing or pro-active messaging */
        val userMeta: MutableMap<String, String> = HashMap()
        userMeta["Order Id"] = "-"
        userMeta["Order Status"] = "Testing"
        userMeta["Vendor Name"] = "Vendor Test"
        userMeta["URL test"] = "https://dev-management.shopper.deliveryhero.net"
        //Call setUserProperties to sync the user properties with Freshchat's servers
        Freshchat.getInstance(applicationContext).setUserProperties(userMeta)

//        // Create a map and set required properties like below
//        val eventName = "Current order info"
//        val properties: HashMap<String, Any> = HashMap()
//        properties["Order Id"] = 11111
//        properties["Order Status"] = "Testing"
//        // Call trackEvent by passing eventName and a map of properties
//        Freshchat.trackEvent(this, eventName, properties)


//        openChat()
        button.setOnClickListener { openChat() }
    }


    private fun openChat() {
        val options =
            ConversationOptions().filterByTags(listOf("pelican-testing"), "Pelican Testing")
        Freshchat.showConversations(this, options)
    }
}