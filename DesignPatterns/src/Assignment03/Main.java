package Assignment03;

import java.util.ArrayList;
import java.util.List;

// the component
abstract class OrganizationComponent {
    protected String name;

    public OrganizationComponent(String name) {
        this.name = name;
    }

    public abstract double getSalary();
    public abstract void printXML(int indent);

    // default implementations for composite methods
    public void add(OrganizationComponent component) {
        throw new UnsupportedOperationException("Cannot add to a leaf node.");
    }

    public void remove(OrganizationComponent component) {
        throw new UnsupportedOperationException("Cannot remove from a leaf node.");
    }

    protected String getIndent(int level) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < level; i++) {
            sb.append("  ");
        }
        return sb.toString();
    }
}

// leaf
class Employee extends OrganizationComponent {
    private double salary;

    public Employee(String name, double salary) {
        super(name);
        this.salary = salary;
    }

    @Override
    public double getSalary() {
        return salary;
    }

    @Override
    public void printXML(int indent) {
        System.out.println(getIndent(indent) + "<Employee name=\"" + name + "\" salary=\"" + salary + "\" />");
    }
}

// composite
class Department extends OrganizationComponent {
    private List<OrganizationComponent> children = new ArrayList<>();

    public Department(String name) {
        super(name);
    }

    @Override
    public void add(OrganizationComponent component) {
        children.add(component);
    }

    @Override
    public void remove(OrganizationComponent component) {
        children.remove(component);
    }

    @Override
    public double getSalary() {
        double total = 0;
        for (OrganizationComponent child : children) {
            total += child.getSalary();
        }
        return total;
    }

    @Override
    public void printXML(int indent) {
        System.out.println(getIndent(indent) + "<Department name=\"" + name + "\">");
        for (OrganizationComponent child : children) {
            child.printXML(indent + 1);
        }
        System.out.println(getIndent(indent) + "</Department>");
    }
}


public class Main {
    public static void main(String[] args) {
        // build the structure
        Department techCorp = new Department("TechCorp Solutions");

        Department devDept = new Department("Software Development");
        devDept.add(new Employee("Alice", 120000));
        devDept.add(new Employee("Sarah", 115000));

        Department designDept = new Department("UX Design");
        designDept.add(new Employee("Luna", 95000));
        designDept.add(new Employee("Bella", 98000));

        // nesting departments
        techCorp.add(devDept);
        techCorp.add(designDept);
        techCorp.add(new Employee("Diana", 200000)); // The CEO

        // output total salary and XML structure
        System.out.println("Total Organization Salary: $" + techCorp.getSalary());
        System.out.println("\n--- XML Structure ---");
        techCorp.printXML(0);
    }
}
