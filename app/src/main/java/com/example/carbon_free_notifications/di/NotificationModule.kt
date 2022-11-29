package com.example.carbon_free_notifications.di

import android.app.Application
import android.app.NotificationChannel
import android.app.NotificationManager
import android.content.Context
import android.content.res.Resources
import android.graphics.BitmapFactory
import android.os.Build
import android.os.Bundle
import androidx.annotation.RequiresApi
import androidx.core.app.NotificationCompat
import androidx.core.app.NotificationCompat.VISIBILITY_PUBLIC
import androidx.core.app.NotificationManagerCompat
import androidx.core.os.bundleOf
import androidx.lifecycle.SavedStateHandle
import androidx.navigation.NavArgs
import androidx.navigation.NavDeepLink
import androidx.navigation.NavDeepLinkBuilder
import androidx.navigation.NavDirections
import com.example.carbon_free_notifications.MainActivity
import com.example.carbon_free_notifications.R
import com.example.carbon_free_notifications.model.CarbonFree
import dagger.Module
import dagger.Provides
import dagger.assisted.Assisted
import dagger.assisted.AssistedInject
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Inject
import javax.inject.Singleton


@Module
@InstallIn(SingletonComponent::class)
object NotificationModule {


    @RequiresApi(Build.VERSION_CODES.O)
    @Singleton
    @Provides
    fun provideNotificationBuilder(@ApplicationContext context: Context): NotificationCompat.Builder {

//
//        val args = Bundle().getParcelable("carbonFree")

//        val args = Bundle().deepCopy().getParcelable<CarbonFree>("carbonFree")

        val args = Bundle()
        args.putString("myCarbonFree", "Recycle")

        val intentPending = NavDeepLinkBuilder(context)
            .setComponentName(MainActivity::class.java)
            .setArguments(args)
            .setGraph(R.navigation.nav_graph)
            .setDestination(R.id.thirdFragment)


            .createPendingIntent()

        return NotificationCompat.Builder(
            context, "MAIN CHANNEL ID"
        )
            .setContentTitle("Welcome")
            .setContentText("Youtube Channel Stedvza-San")
            .setSmallIcon(R.drawable.ic_launcher_foreground)

            .setPriority(NotificationCompat.PRIORITY_DEFAULT)
            .setVisibility(VISIBILITY_PUBLIC)
            .setContentIntent(intentPending)




    }

    @Singleton
    @Provides
    fun provideNotificationManager(@ApplicationContext context: Context): NotificationManagerCompat {
        val notificationManager = NotificationManagerCompat.from(context)

         if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
             val channel =   NotificationChannel(
                "MAIN CHANNEL ID",
                "My Main Channel",
                NotificationManager.IMPORTANCE_DEFAULT
            )

             notificationManager.createNotificationChannel(channel)

        }
        return notificationManager
    }
}