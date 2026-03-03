package Assignment10;

public class ContactHandler extends FeedbackHandler {
    @Override
    public void handle(FeedbackMessage message) {
        if (message.getType() == MessageType.CONTACT_REQUEST) {
            System.out.println("[Contact] received " + message.getSenderEmail() + ". ");
        } else {
            super.handle(message);
        }
    }
}