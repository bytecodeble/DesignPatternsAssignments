package Assignment10;

public abstract class FeedbackHandler {
    protected FeedbackHandler nextHandler;

    public void setNext(FeedbackHandler nextHandler) {
        this.nextHandler = nextHandler;
    }

    public void handle(FeedbackMessage message) {
        if (nextHandler != null) {
            nextHandler.handle(message);
        }
    }
}
