package com.example.carbon_free_notifications.viewmodel

import android.app.NotificationManager
import android.graphics.Bitmap
import androidx.core.app.NotificationBuilderWithBuilderAccessor
import androidx.core.app.NotificationCompat
import androidx.core.app.NotificationManagerCompat
import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class MyViewModel @Inject constructor(
    private val notificationBuilder: NotificationCompat.Builder,
    private val notificationManager: NotificationManagerCompat
) : ViewModel() {


    fun showSimpleNotification(){
        notificationManager.notify(1, notificationBuilder.build())
    }

    fun showSimpleNotificationRecycler(contentTitle: String, contentText: String, bitmap: Bitmap){
        notificationManager.notify(1, notificationBuilder
            .setContentTitle(contentTitle)
            .setContentText(contentText)
            .setLargeIcon(bitmap)
            .setAutoCancel(true)
            .build())
    }
}