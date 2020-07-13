package com.example.uberjava;

import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.os.Build;

import com.example.uberjava.Model.DrierInfoModel;
import com.example.uberjava.Services.MyFirebaseMessagingService;

public class Common {

    public static final String DRIVER_INFO_REFERENCE = "DriverInfo";
    public static final String DRIVERS_LOCATION_REFERENCES = "DriversLocation";
    public static final String TOKEN_REFERENCE = "Token";
    public static final String NOTI_TITLE = "title";
    public static final String NOTI_CONTENT = "body";
    public static DrierInfoModel currentUser;

    public static String buildWelcomeMessage() {
     if (Common.currentUser != null)
     {
         return new StringBuilder("Welcome ")
                 .append(Common.currentUser.getFirstName())
                 .append("")
                 .append(Common.currentUser.getLastName()).toString();
     }
     else
         return "";
    }

    public static void showNotification(Context context, int id, String title, String body, Intent intent) {
        PendingIntent pendingIntent = null;
        if (intent != null)
            pendingIntent = PendingIntent.getActivity(context,id,intent,PendingIntent.FLAG_UPDATE_CURRENT);
        String NOTIFICATION_CHANNEL_ID = "saim_hassan_car_booking";
        NotificationManager notificationManager = (NotificationManager)context.getSystemService(Context.NOTIFICATION_SERVICE);
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O)
        {
            NotificationChannel notificationChannel = new NotificationChannel(NOTIFICATION_CHANNEL_ID,
                    "Car Booking",NotificationManager.IMPORTANCE_HIGH);
            notificationChannel.setDescription("Car Booking");
            notificationChannel.enableLights(true);
            notificationChannel.setLightColor(Color.RED);
            notificationChannel.setVibrationPattern(new long[]{0,1000,500,1000});
        }

    }
}
