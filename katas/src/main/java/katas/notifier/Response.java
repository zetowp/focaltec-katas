package katas.notifier;

public class Response {

    private String message;

    private String channel;

    public Response(String message, String channel) {
        this.message = message;
        this.channel = channel;
    }

    public String getMessage() {
        return message;
    }

    public String getChannel() {
        return channel;
    }
}