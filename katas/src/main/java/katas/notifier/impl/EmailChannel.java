package katas.notifier.impl;

import katas.notifier.Channel;
import katas.notifier.Response;

public class EmailChannel implements Channel {

    @Override
    public Response sendNotification(String notification) {
        System.out.println("Sending email notification: " + notification);
        return new Response(notification, "EMAIL");
    }

}
