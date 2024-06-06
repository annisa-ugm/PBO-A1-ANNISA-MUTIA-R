public class HRStaff extends Employee {
    public HRStaff(String name, String dateOfBirth, String department) {
        super(name, dateOfBirth, "HR Staff", department);
    }

    public int getSalary() {
        return 5000000;
    }

    public int getAllowance() {
        return 0;
    }
}
