package Assignment06;

public class XMLPrinter extends PrinterDecorator {

    public XMLPrinter(Printer printer) {
        super(printer);
    }

    @Override
    public void print(String message) {
        super.print("<xml>" + message + "</xml>");
    }

}
