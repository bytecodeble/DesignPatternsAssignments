package Assignment06;

public class EncryptedPrinter extends PrinterDecorator {

    public EncryptedPrinter(Printer printer) {
        super(printer);
    }

    @Override
    public void print(String message) {
        String encrypted = "";
        for (char c : message.toCharArray()) {
            encrypted += (char)(c + 1);
        }
        super.print(encrypted);
    }

}
