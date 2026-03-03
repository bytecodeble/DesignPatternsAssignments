package Assignment10;

public class CompensationHandler extends FeedbackHandler {
    @Override
    public void handle(FeedbackMessage message) {
        if (message.getType() == MessageType.COMPENSATION_CLAIM) {
            System.out.println("[Compensation] received " + message.getSenderEmail() + ". ");
        } else {
            super.handle(message);
        }
    }
}