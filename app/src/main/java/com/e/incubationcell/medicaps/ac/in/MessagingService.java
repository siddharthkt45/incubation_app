package com.e.incubationcell.medicaps.ac.in;

import android.app.PendingIntent;
import android.content.Intent;

import androidx.annotation.NonNull;
import androidx.core.app.NotificationCompat;
import androidx.core.app.NotificationManagerCompat;

import com.google.firebase.messaging.FirebaseMessagingService;
import com.google.firebase.messaging.RemoteMessage;

public class MessagingService extends FirebaseMessagingService {

    @Override
    public void onMessageReceived(@NonNull RemoteMessage remoteMessage) {
            showNotification(remoteMessage.getNotification().getTitle(),remoteMessage.getNotification().getBody());
    }

    public void showNotification(String title , String message){
        PendingIntent pendingIntent = PendingIntent.getActivity(this, 0, new Intent(this, Home.class), 0);
        NotificationCompat.Builder builder = new NotificationCompat.Builder(this,"mychannel");
        builder.setContentTitle(title)
                .setContentText(message)
                .setAutoCancel(true)
                .setSmallIcon(R.drawable.incubationcircless);

        NotificationManagerCompat notificationManagerCompat = NotificationManagerCompat.from(MessagingService.this);
        notificationManagerCompat.notify(0,builder.build());
    }
}
