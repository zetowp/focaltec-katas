package katas.notifier.impl;

import katas.notifier.Channel;

public class SignUpNotification extends StringNotification {

    public SignUpNotification(Channel channel) {
        super(channel);
    }

    @Override
    protected String getMessage() {
        return "Hi new overlord";
    }



}
