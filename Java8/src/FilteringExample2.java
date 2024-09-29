
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Set;
import java.util.stream.Collectors;

public class FilteringExample2 {

    public static void main(String... args) {

        Map<Department, List<Employee>> wellPaidEmployeesByDepartment
                = getEmployees().stream().collect(
                Collectors.groupingBy((Employee employee) -> employee.dept, Collectors
                        .filtering(e -> e.salary >= 2000,
                                Collectors.toList())));
        wellPaidEmployeesByDepartment.forEach((k, v) -> System.out.printf("%8s: %s%n", k.name, v));
    }

    private static List<Employee> getEmployees() {
        return Arrays.asList(
                new Employee("Sara", new Department("Admin"), 3000),
                new Employee("Joe", new Department("IT"), 1000),
                new Employee("Mike", new Department("Account"), 2000),
                new Employee("Tony", new Department("Account"), 1500),
                new Employee("Linda", new Department("IT"), 5000)
        );
    }

    private static class Employee {
        private String name;
        private Department dept;
        private int salary;

        public Employee(String name, Department dept, int salary) {
            this.name = name;
            this.dept = dept;
            this.salary = salary;
        }

        @Override
        public String toString() {
            return "Employee{" +
                    "name='" + name + '\'' +
                    ", dept=" + dept +
                    ", salary=" + salary +
                    '}';
        }
    }

    private static class Department {
        private String name;

        public Department(String name) {
            this.name = name;
        }

        @Override
        public String toString() {
            return "Department{" +
                    "name='" + name + '\'' +
                    '}';
        }

        @Override
        public boolean equals(Object o) {
            Department that = (Department) o;
            return Objects.equals(name, that.name);
        }

        @Override
        public int hashCode() {
            return Objects.hash(name);
        }
    }
}