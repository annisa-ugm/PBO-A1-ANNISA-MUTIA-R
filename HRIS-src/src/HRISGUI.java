import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class HRISGUI extends JFrame {
    private JTextField nameField;
    private JTextField dobField;
    private ArrayList<Employee> employees;
    private DefaultTableModel tableModel;
    private JTable table;

    public HRISGUI() {
        employees = new ArrayList<>();
        showMainPanel();

        setSize(600, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }

    private void showMainPanel() {
        JPanel mainPanel = new JPanel();
        JButton addButton = new JButton("Add Data");
        JButton showAllButton = new JButton("Show Data");
        addButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                getContentPane().removeAll();
                getContentPane().add(showInputPanel());
                revalidate();
                repaint();
            }
        });

        showAllButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                getContentPane().removeAll();
                getContentPane().add(showAllDataPanel());
                revalidate();
                repaint();
            }
        });

        mainPanel.add(addButton);
        mainPanel.add(showAllButton);

        getContentPane().add(mainPanel);
    }

    private JPanel showAllDataPanel() {
        JPanel panel = new JPanel(new BorderLayout());

        tableModel = new DefaultTableModel();
        tableModel.addColumn("Name");
        tableModel.addColumn("Position");
        tableModel.addColumn("Department");
        tableModel.addColumn("Salary");
        tableModel.addColumn("ID");
        table = new JTable(tableModel);

        JScrollPane scrollPane = new JScrollPane(table);
        panel.add(scrollPane, BorderLayout.CENTER);

        for (Employee employee : employees) {
            Object[] rowData = {employee.getName(), employee.getPosition(), employee.getDepartment(), employee.getSalary(), employee.getID()};
            tableModel.addRow(rowData);
        }

        JButton backButton = new JButton("Back");
        backButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                getContentPane().removeAll();
                showMainPanel();
                revalidate();
                repaint();
            }
        });
        panel.add(backButton, BorderLayout.SOUTH);

        return panel;
    }

    private JPanel showInputPanel() {
        JPanel inputPanel = new JPanel(new GridLayout(6, 2));

        JLabel nameLabel = new JLabel("Name:");
        nameField = new JTextField(15);

        JLabel dobLabel = new JLabel("Date of Birth (DDMMYYYY):");
        dobField = new JTextField(15);

        JLabel departementLabel = new JLabel("Department:");
        String[] departments = {"Product", "HR"};
        JComboBox<String> departementComboBox = new JComboBox<>(departments);

        JLabel positionLabel = new JLabel("Position:");
        String[] positions = {"Manager", "Developer", "HR Staff"};
        JComboBox<String> positionComboBox = new JComboBox<>(positions);

        JButton addEmployeeButton = new JButton("Add Data");
        JButton backButton = new JButton("Back");

        inputPanel.add(nameLabel);
        inputPanel.add(nameField);
        inputPanel.add(dobLabel);
        inputPanel.add(dobField);
        inputPanel.add(departementLabel);
        inputPanel.add(departementComboBox);
        inputPanel.add(positionLabel);
        inputPanel.add(positionComboBox);
        inputPanel.add(addEmployeeButton);
        inputPanel.add(backButton);

        addEmployeeButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String name = nameField.getText();
                String dob = dobField.getText();
                String department = (String) departementComboBox.getSelectedItem();
                String position = (String) positionComboBox.getSelectedItem();
                addEmployee(name, dob, department, position);

                Object[] rowData = {name, position, department, getSalaryByPosition(position), generateEmployeeID(dob, department)};
                tableModel.addRow(rowData);

                JOptionPane.showMessageDialog(HRISGUI.this, "Employee added : " + name + ", " + department);
            }
        });

        backButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                getContentPane().removeAll();
                showMainPanel();
                revalidate();
                repaint();
            }
        });

        return inputPanel;
    }

    private void addEmployee(String name, String dateOfBirth, String department, String position) {
        Employee employee;
        switch (position) {
            case "Manager":
                employee = new Manager(name, dateOfBirth, department);
                break;
            case "Developer":
                employee = new Developer(name, dateOfBirth, department);
                break;
            default:
                employee = new HRStaff(name, dateOfBirth, department);
                break;
        }
        employees.add(employee);
    }

    private int getSalaryByPosition(String position) {
        switch (position) {
            case "Manager":
                return 20000000;
            case "Developer":
                return 10000000;
            default:
                return 5000000;
        }
    }

    private String generateEmployeeID(String dateOfBirth, String department) {
        String departmentCode = department.equals("Product") ? "PROD" : "HR";
        return "000" + departmentCode + dateOfBirth + generateRandomNumber();
    }

    private String generateRandomNumber() {
        return String.format("%03d", (int)(Math.random() * 1000));
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new HRISGUI();
            }
        });
    }
}