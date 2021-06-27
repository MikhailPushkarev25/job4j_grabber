package srp;

import org.junit.Test;

import java.util.Calendar;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;
public class MemStoreTest {

    @Test
    public void whenOldGenerated() {
        MemStore store = new MemStore();
        Calendar now = Calendar.getInstance();
        Employee worker = new Employee("Ivan", now, now, 100);
        store.add(worker);
        Report engine = new ReportEngine(store);
        StringBuilder expect = new StringBuilder()
                .append("Name; Hired; Fired; Salary")
                .append(System.lineSeparator())
                .append(worker.getName()).append(";")
                .append(worker.getHired()).append(";")
                .append(worker.getFired()).append(";")
                .append(worker.getSalary()).append(";")
                .append(System.lineSeparator());
        assertThat(engine.generate(em -> true), is(expect.toString()));

    }

    @Test
    public void whenTestSalary() {
        MemStore store = new MemStore();
        Calendar now = Calendar.getInstance();
        Employee worker = new Employee("Mikhail", now, now, 100);
        store.add(worker);
        Report salary = new ReportSalary(store);
        StringBuilder expect = new StringBuilder()
                .append("Name; Hired; Fired; Salary")
                .append(System.lineSeparator())
                .append(worker.getName()).append(";")
                .append(worker.getHired()).append(";")
                .append(worker.getFired()).append(";")
                .append(worker.getSalary() / 75).append(";")
                .append(System.lineSeparator());
        assertThat(salary.generate(em -> true), is(expect.toString()));
    }

    @Test
    public void whenTestHr() {
        MemStore store = new MemStore();
        Calendar now = Calendar.getInstance();
        Employee worker = new Employee("Vasy", now, now, 100);
        store.add(worker);
        Report hr = new ReportHr(store);
        StringBuilder expect = new StringBuilder()
                .append("Name; Salary;")
                .append(System.lineSeparator())
                .append(worker.getName()).append(";")
                .append(worker.getSalary()).append(";")
                .append(System.lineSeparator());
        assertThat(hr.generate(em -> true), is(expect.toString()));
    }

    @Test
    public void whenTestProg() {
        MemStore store = new MemStore();
        Calendar now = Calendar.getInstance();
        Employee worker = new Employee("Vasy", now, now, 100);
        store.add(worker);
        Report prog = new ReportProg(store);
        StringBuilder expect = new StringBuilder();
        expect.append("<!DOCTYPE HTML>")
                .append("<html><head><meta charset=\"utf-8\"><title>Report</title></head><body><table>")
                .append("<tr>")
                .append("<th>Name<th>")
                .append("<th>Hired<th>")
                .append("<th>Fired<th>")
                .append("<th>Salary<th>")
                .append("<tr>")
                .append("<tr><td>").append(worker.getName()).append("</tr><td>")
                .append("<tr><td>").append(worker.getHired()).append("</tr><td>")
                .append("<tr><td>").append(worker.getFired()).append("</tr><td>")
                .append("<tr><td>").append(worker.getSalary()).append("</tr><td>")
                .append("</table></body></html>");
        assertThat(prog.generate(em -> true), is(expect.toString()));
    }

    @Test
    public void whenTestXml() {
        MemStore store = new MemStore();
        Calendar now = Calendar.getInstance();
        Employee worker = new Employee("Ivan", now, now, 100);
        store.add(worker);
        Report xml = new ReportXml(store);
        StringBuilder expect = new StringBuilder();
        expect.append("<Employees>")
                .append("<employee>")
                .append("<name>").append(worker.getName()).append("</name>")
                .append("<hired>").append(worker.getHired()).append("</hired>")
                .append("<fired>").append(worker.getFired()).append("</fired>")
                .append("<salary>").append(worker.getSalary()).append("</salary>")
                .append("</employee")
                .append("</Employees");

        assertThat(xml.generate(em -> true), is(expect.toString()));
    }

    @Test
    public void whenTestJSON() {
        MemStore store = new MemStore();
        Calendar now = Calendar.getInstance();
        Employee worker = new Employee("Ivan", now, now, 100);
        store.add(worker);
        Report json = new ReportJSON(store);
        StringBuilder expect = new StringBuilder();
        expect.append("{\n");
        expect.append("\"employee\":{\n");
        expect.append("\"name\":\"").append(worker.getName());
        expect.append("\",\n\"hired\":\"").append(worker.getHired());
        expect.append("\",\n\"fired\":\"").append(worker.getFired());
        expect.append("\",\n\"salary\":\"").append(worker.getSalary());
        expect.append("\"\n");
        expect.append("\n}");
        assertThat(json.generate(em -> true), is(expect.toString()));
    }
}