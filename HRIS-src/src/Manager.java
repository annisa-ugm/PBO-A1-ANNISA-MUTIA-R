public class Manager extends Employee {
    public Manager(String name, String dateOfBirth, String department) {
        super(name, dateOfBirth, "Manager", department);
    }

    public int getSalary() {
        return 20000000;
    }

    public int getAllowance() {
        return 0;
    }
}
