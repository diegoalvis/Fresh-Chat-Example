package com.diegoalvis.freshchattest

import android.app.Application
import com.freshchat.consumer.sdk.Freshchat

import com.freshchat.consumer.sdk.FreshchatConfig


class FreshChatApp : Application() {

    override fun onCreate() {
        super.onCreate()

        val config = FreshchatConfig(BuildConfig.freshChatAppId, BuildConfig.freshChatAppKey)
        config.isCameraCaptureEnabled = true
        config.isGallerySelectionEnabled = true
        config.isResponseExpectationEnabled = true
        Freshchat.getInstance(applicationContext).init(config)
    }
}