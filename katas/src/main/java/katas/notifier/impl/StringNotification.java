package katas.notifier.impl;

import katas.notifier.Channel;
import katas.notifier.Notification;
import katas.notifier.Response;

public abstract class StringNotification implements Notification {

    private Channel channel;

    public StringNotification(Channel channel) {
        this.channel = channel;
    }

    @Override
    public Response sendNotification() {
        return channel.sendNotification(getMessage());
    }

    protected abstract String getMessage();

}
