abstract class Employee {
    private String name;
    private String dateOfBirth;
    private String position;
    private String department;
    private String employeeID;
    public Employee(String name, String dateOfBirth, String position, String department) {
        this.name = name;
        this.dateOfBirth = dateOfBirth;
        this.position = position;
        this.department = department;
        this.employeeID = generateEmployeeID();
    }
    public static String[] getDepartment() {
        return new String[]{"Product", "Human Resources"};
    }
    public abstract int getSalary();
    public abstract int getAllowance();

    public String getName() {
        return name;
    }

    public String getPosition() {
        return position;
    }
    public String getID() {
        return employeeID;
    }
    private String generateEmployeeID() {
        String departmentCode = department.equals("Product") ? "PROD" : "HR";
        return "000" + departmentCode + dateOfBirth + generateRandomNumber();
    }
    private String generateRandomNumber() {
        return String.format("%03d", (int)(Math.random() * 1000));
    }
}
