import java.util.*;

public class EmployeeManagementSystem {
    static ArrayList<Employee> empList = new ArrayList<>();
    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        while (true) {
            System.out.println("\n=== Employee Management System ===");
            System.out.println("1. Add Employee");
            System.out.println("2. View All Employees");
            System.out.println("3. Search Employee by ID");
            System.out.println("4. Update Employee");
            System.out.println("5. Delete Employee");
            System.out.println("6. Exit");
            System.out.print("Enter your choice: ");

            int choice = sc.nextInt();

            switch (choice) {
                case 1: addEmployee(); break;
                case 2: viewEmployees(); break;
                case 3: searchEmployee(); break;
                case 4: updateEmployee(); break;
                case 5: deleteEmployee(); break;
                case 6:
                    System.out.println("Exiting system...");
                    System.exit(0);
                default:
                    System.out.println("Invalid choice. Try again!");
            }
        }
    }

    public static void addEmployee() {
        System.out.print("Enter ID: ");
        int id = sc.nextInt(); sc.nextLine();

        System.out.print("Enter Name: ");
        String name = sc.nextLine();

        System.out.print("Enter Department: ");
        String dept = sc.nextLine();

        System.out.print("Enter Designation: ");
        String designation = sc.nextLine();

        System.out.print("Enter Salary: ");
        double salary = sc.nextDouble();

        empList.add(new Employee(id, name, dept, designation, salary));
        System.out.println("Employee added successfully!");
    }

    public static void viewEmployees() {
        if (empList.isEmpty()) {
            System.out.println("No employees found.");
        } else {
            for (Employee emp : empList) {
                System.out.println(emp);
            }
        }
    }

    public static void searchEmployee() {
        System.out.print("Enter ID to search: ");
        int id = sc.nextInt();
        boolean found = false;

        for (Employee emp : empList) {
            if (emp.getId() == id) {
                System.out.println(emp);
                found = true;
                break;
            }
        }

        if (!found) {
            System.out.println("Employee not found.");
        }
    }

    public static void updateEmployee() {
        System.out.print("Enter ID to update: ");
        int id = sc.nextInt(); sc.nextLine();
        boolean found = false;

        for (Employee emp : empList) {
            if (emp.getId() == id) {
                System.out.print("Enter new Name: ");
                emp.setName(sc.nextLine());

                System.out.print("Enter new Department: ");
                emp.setDepartment(sc.nextLine());

                System.out.print("Enter new Designation: ");
                emp.setDesignation(sc.nextLine());

                System.out.print("Enter new Salary: ");
                emp.setSalary(sc.nextDouble());

                System.out.println("Employee updated successfully!");
                found = true;
                break;
            }
        }

        if (!found) {
            System.out.println("Employee not found.");
        }
    }

    public static void deleteEmployee() {
        System.out.print("Enter ID to delete: ");
        int id = sc.nextInt();
        Iterator<Employee> it = empList.iterator();
        boolean found = false;

        while (it.hasNext()) {
            Employee emp = it.next();
            if (emp.getId() == id) {
                it.remove();
                System.out.println("Employee deleted successfully.");
                found = true;
                break;
            }
        }

        if (!found) {
            System.out.println("Employee not found.");
        }
    }
}
