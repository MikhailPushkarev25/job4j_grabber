package srp;

import java.util.function.Predicate;

public class ReportXml implements Report {
    private Store store;

    public ReportXml(Store store) {
        this.store = store;
    }

    @Override
    public String generate(Predicate<Employee> filter) {
        StringBuilder text = new StringBuilder();
        text.append("\"<?xml version=\\\"1.1\\\" encoding=\\\"UTF-8\\\" ?>\" <Employees>");
        for (Employee employee : store.findBy(filter)) {
            text.append("<employee>")
                    .append("<name>").append(employee.getName()).append("</name>")
                    .append("<hired>").append(employee.getHired()).append("</hired>")
                    .append("<fired>").append(employee.getFired()).append("</fired>")
                    .append("<salary>").append(employee.getSalary()).append("</salary>")
                    .append("</employee");
        }
        text.append("</Employees");
        return text.toString();
    }
}
