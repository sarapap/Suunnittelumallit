package Composite;

import java.util.ArrayList;
import java.util.List;

public class Department extends Organization {
    private List<Organization> organizations = new ArrayList<>();

    public Department(String name) {
        super(name);
    }

    @Override
    public double getSalary() {
        return organizations.stream().mapToDouble(Organization::getSalary).sum();
    }

    @Override
    public void add(Organization organization) {
        organizations.add(organization);
    }

    @Override
    public void remove(Organization organization) {
        organizations.remove(organization);
    }

    @Override
    public void print(StringBuilder stringBuilder) {
        stringBuilder.append("<Department name=\"").append(name).append("\">\n");
        organizations.forEach(organization -> organization.print(stringBuilder));
        stringBuilder.append("</Department>\n");
    }
}
