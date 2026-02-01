// all UI elements
abstract class UIElement {
    protected String text;

    public void setText(String text) {
        this.text = text;
    }

    public abstract void display();
}

// abstract element classes
abstract class Button extends UIElement {}
abstract class TextField extends UIElement {}
abstract class Checkbox extends UIElement {}

// style a
class ButtonA extends Button {
    public void display() { System.out.println("[ " + text + " ]"); }
}

class TextFieldA extends TextField {
    public void display() { System.out.println("|--- " + text + " ---|"); }
}

class CheckboxA extends Checkbox {
    public void display() { System.out.println("[x] " + text); }
}

// style b
class ButtonB extends Button {
    public void display() { System.out.println("<-- " + text + " -->"); }
}

class TextFieldB extends TextField {
    public void display() { System.out.println("~~~ " + text + " ~~~"); }
}

class CheckboxB extends Checkbox {
    public void display() { System.out.println("( ) " + text); }
}

// abstract factory
abstract class UIFactory {
    public abstract Button createButton(String text);
    public abstract TextField createTextField(String text);
    public abstract Checkbox createCheckbox(String text);
}

// factory style a
class AFactory extends UIFactory {
    public Button createButton(String text) {
        Button b = new ButtonA();
        b.setText(text);
        return b;
    }
    public TextField createTextField(String text) {
        TextField t = new TextFieldA();
        t.setText(text);
        return t;
    }
    public Checkbox createCheckbox(String text) {
        Checkbox c = new CheckboxA();
        c.setText(text);
        return c;
    }
}

// factory style b
class BFactory extends UIFactory {
    public Button createButton(String text) {
        Button b = new ButtonB();
        b.setText(text);
        return b;
    }
    public TextField createTextField(String text) {
        TextField t = new TextFieldB();
        t.setText(text);
        return t;
    }
    public Checkbox createCheckbox(String text) {
        Checkbox c = new CheckboxB();
        c.setText(text);
        return c;
    }
}


public class Main {
    public static void main(String[] args) {
        // choose factory
        UIFactory factory = new AFactory(); 

        System.out.println("Welcome to ASCII UI");
        
        Button btn = factory.createButton("Submit");
        TextField field = factory.createTextField("Enter password");
        Checkbox box = factory.createCheckbox("Remember me");

        btn.display();
        field.display();
        box.display();

        System.out.println("\n--- Test ---");
        btn.setText("Sending...");
        btn.display();
    }
}