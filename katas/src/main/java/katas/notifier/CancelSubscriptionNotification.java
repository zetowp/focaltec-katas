package katas.notifier;

import katas.notifier.impl.StringNotification;


public class CancelSubscriptionNotification extends StringNotification {

    public CancelSubscriptionNotification(Channel channel) {
        super(channel);
    }

    @Override
    protected String getMessage() {
        return "Begone scum";
    }

}
