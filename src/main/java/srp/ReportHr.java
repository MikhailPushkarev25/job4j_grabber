package srp;

import java.util.List;
import java.util.function.Predicate;

public class ReportHr implements Report {

    private Store store;

    public ReportHr(Store store) {
        this.store = store;
    }

    @Override
    public String generate(Predicate<Employee> filter) {
        StringBuilder text = new StringBuilder();
        List<Employee> sort = store.findBy(filter);
        sort.sort((t1, t2) -> (int) (t2.getSalary() - t1.getSalary()));
        text.append("Name; Salary;");
        for (Employee employee : sort) {
            text.append(System.lineSeparator())
                    .append(employee.getName()).append(";")
                    .append(employee.getSalary()).append(";")
                    .append(System.lineSeparator());
        }
        return text.toString();
    }
}
