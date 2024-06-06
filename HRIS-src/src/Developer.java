public class Developer extends Employee {
    public Developer(String name, String dateOfBirth, String department) {
        super(name, dateOfBirth, "Developer", department);
    }

    public int getSalary() {
        return 10000000;
    }

    public int getAllowance() {
        return 0;
    }
}
