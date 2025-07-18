package katas.notifier;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import katas.notifier.impl.EmailChannel;
import katas.notifier.impl.SignUpNotification;
import katas.notifier.impl.SnsChannel;

public class NotifySenderTest {

    @Test
    public void testNotifySender() {
        EmailChannel email = new EmailChannel();
        Channel sns = new SnsChannel();
        assertEquals("Hi new overlord", new SignUpNotification(sns).sendNotification().getMessage());
        assertEquals("SNS", new SignUpNotification(sns).sendNotification().getChannel());
        assertEquals("EMAIL", new SignUpNotification(email).sendNotification().getChannel());
        assertEquals("Begone scum", new CancelSubscriptionNotification(sns).sendNotification().getMessage());
        assertEquals("SNS", new CancelSubscriptionNotification(sns).sendNotification().getChannel());
        assertEquals("EMAIL", new CancelSubscriptionNotification(email).sendNotification().getChannel());
    }

}
