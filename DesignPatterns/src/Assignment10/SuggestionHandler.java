package Assignment10;

public class SuggestionHandler extends FeedbackHandler {
    @Override
    public void handle(FeedbackMessage message) {
        if (message.getType() == MessageType.DEVELOPMENT_SUGGESTION) {
            System.out.println("[Suggestion] recieved: \"" + message.getContent() + "\". ");
        } else {
            super.handle(message);
        }
    }
}