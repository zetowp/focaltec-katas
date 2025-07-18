package katas.notifier.impl;

import katas.notifier.Channel;
import katas.notifier.Response;


public class SnsChannel implements Channel {

    @Override
    public Response sendNotification(String notification) {
        System.out.println("Sending SNS notification: " + notification);
        return new Response(notification, "SNS");
    }

}
