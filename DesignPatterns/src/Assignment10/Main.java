package Assignment10;

public class Main {
    public static void main(String[] args) {

        FeedbackHandler compensation = new CompensationHandler();
        FeedbackHandler contact = new ContactHandler();
        FeedbackHandler suggestion = new SuggestionHandler();
        FeedbackHandler general = new GeneralHandler();

        compensation.setNext(contact);
        contact.setNext(suggestion);
        suggestion.setNext(general);

        FeedbackMessage[] messages = {
            new FeedbackMessage(MessageType.COMPENSATION_CLAIM, "My package is lost! ", "alice@example.com"),
            new FeedbackMessage(MessageType.DEVELOPMENT_SUGGESTION, "Add a dark mode. ", "bob@example.com"),
            new FeedbackMessage(MessageType.CONTACT_REQUEST, "Interested in cooperation. ", "carol@example.com"),
            new FeedbackMessage(MessageType.GENERAL_FEEDBACK, "APP looks good. ", "dave@example.com")
        };

        for (FeedbackMessage msg : messages) {
            System.out.println("Processing new messages...");
            compensation.handle(msg);
        }
    }
}
