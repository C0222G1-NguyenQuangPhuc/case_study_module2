package services.libs_of_impl;

import models.person.Employee;
import services.libs_of_interface.EmployeeService;
import utils.ReadAndWrite;
import utils.RegexData;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class EmployeeServiceImpl extends ServiceAbstract implements EmployeeService {
    private static final String EMPLOYEE_LIST = "src\\data\\employee.csv";
    private static List<Employee> employeeList = getEmployeeList();

    private static Scanner sc = new Scanner(System.in);

    @Override
    public void display(){
        employeeList = getEmployeeList();
        for (Employee employee : employeeList) {
            System.out.println(employee.toString());
        }
    }

    public static List<Employee> getEmployeeList() {
        List<Employee> listFileEmployee = new ArrayList<>();
        List<String[]> listStr = ReadAndWrite.readList(EMPLOYEE_LIST);
        for (String[] element : listStr) {
            Employee employee = new Employee(Integer.parseInt(element[0]),
                    element[1],
                    element[2],
                    element[3],
                    Boolean.getBoolean(element[4]),
                    Integer.parseInt(element[5]),
                    Integer.parseInt(element[6]),
                    element[7],
                    element[8],
                    element[9],
                    Double.parseDouble(element[10]));
                    listFileEmployee.add(employee);
        }
        return listFileEmployee;
    }

    @Override
    public void addNew() throws IOException {
//        try {
//            System.out.println("Enter id: ");
//            int inputId = Integer.parseInt(sc.nextLine());
//            System.out.println("Enter name: ");
//            String inputName = sc.nextLine();
//            System.out.println("Enter age: ");
//            String inputDateOfBirth = sc.nextLine();
//            System.out.println("Enter address: ");
//            String inputAddress = sc.nextLine();
//            System.out.println("Choose gender: 1.Male / 2.Female ");
//            int chooseGender = Integer.parseInt(sc.nextLine());
//            boolean comfirmGender = false;
//            if (chooseGender == 1) {
//                comfirmGender = true;
//            } else {
//                comfirmGender = false;
//            }
//            System.out.println("Enter IdCard: ");
//            int inputIdCard = Integer.parseInt(sc.nextLine());
//            System.out.println("Enter phone number: ");
//            int inputNumPhone = Integer.parseInt(sc.nextLine());
//            System.out.println("Enter email: ");
//            String inputEmail = sc.nextLine();
//            System.out.println("Enter level: ");
//            String inputLevel = sc.nextLine();
//            System.out.println("Enter position: ");
//            String inputPosition = sc.nextLine();
//            System.out.println("Enter salary: ");
//            double inputSalary = Double.parseDouble(sc.nextLine());
//            employeeList.add(new Employee(inputId,
//                    inputName,
//                    inputDateOfBirth,
//                    inputAddress,
//                    comfirmGender,
//                    inputIdCard,
//                    inputNumPhone,
//                    inputEmail,
//                    inputLevel,
//                    inputPosition,
//                    inputSalary));
//            String line = inputId + "," +
//                    inputName + "," +
//                    inputDateOfBirth + "," +
//                    inputAddress + "," +
//                    comfirmGender + "," +
//                    inputIdCard + "," +
//                    inputNumPhone + "," +
//                    inputEmail + "," +
//                    inputLevel + "," +
//                    inputPosition + "," +
//                    inputSalary;
//            ReadAndWrite.writeList(EMPLOYEE_LIST,line);
//            System.out.println("Add new successful");
//        }catch (NumberFormatException e){
//            e.printStackTrace();
//        }
        RegexData regexData = new RegexData();
        System.out.println("Nhập id nhân viên:");
        int id = regexData.inputIntNumber();
        System.out.println("Nhập tên nhân viên:");
        String name = sc.nextLine();
        System.out.println("Nhập ngày sinh:");
        String dateOfBirth = regexData.inputDateOfBirth();
        System.out.println("Nhập địa chỉ:");
        String address = sc.nextLine();
        System.out.println("Chọn giới tính: 1.Nam / 2.Nữ");
        boolean gender = regexData.comfirmGender(regexData.inputIntNumber());
        System.out.println("Nhập số CMND:");
        int idCard = regexData.inputIntNumber();
        System.out.println("Nhập số điện thoại:");
        int phoneNumber = regexData.inputIntNumber();
        System.out.println("Nhập email:");
    }

    //Edit by name
    @Override
    public void edit() {
        boolean result = false;
        System.out.println("Enter name employee want to edit");
        String findName = sc.nextLine();
        for (Employee employee : employeeList) {
            if (employee.getName().contains(findName)) {
                boolean check = true;
                while (check) {
                    System.out.println("1.Edit Id.");
                    System.out.println("2.Edit Name.");
                    System.out.println("3.Edit Age.");
                    System.out.println("4.Edit Address.");
                    System.out.println("5.Edit Gender.");
                    System.out.println("6.Edit IdCard.");
                    System.out.println("7.Edit PhoneNumber.");
                    System.out.println("8.Edit Email.");
                    System.out.println("9.Edit Level.");
                    System.out.println("10.Edit Position.");
                    System.out.println("11.Edit Salary.");
                    System.out.println("0. Return Main menu");
                    System.out.println("Choose your option");
                    int choose = Integer.parseInt(sc.nextLine());
                    switch (choose) {
                        case 1: {
                            System.out.println("Enter new Id: ");
                            employee.setId(Integer.parseInt(sc.nextLine()));
                            break;
                        }
                        case 2: {
                            System.out.println("Enter new Name: ");
                            employee.setName(sc.nextLine());
                            break;
                        }
                        case 3: {
                            System.out.println("Enter new Age: ");
                            employee.setAge(Integer.parseInt(sc.nextLine()));
                            break;
                        }
                        case 4: {
                            System.out.println("Enter new Address: ");
                            employee.setAddress(sc.nextLine());
                            break;
                        }

                        case 5: {
                            System.out.println("1. Male / 2.Female");
                            if (Integer.parseInt(sc.nextLine()) == 1) {
                                employee.setGender(true);
                            } else {
                                employee.setGender(false);
                            }
                            break;
                        }
                        case 6: {
                            System.out.println("Enter new IdCard: ");
                            employee.setIdCard(Integer.parseInt(sc.nextLine()));
                            break;
                        }
                        case 7: {
                            System.out.println("Enter new Phone Number: ");
                            employee.setPhoneNumber(Integer.parseInt(sc.nextLine()));
                            break;
                        }
                        case 8: {
                            System.out.println("Enter new Email: ");
                            employee.setEmail(sc.nextLine());
                            break;
                        }
                        case 9:
                            System.out.println("Enter new Level: ");
                            employee.setLevel(sc.nextLine());
                            break;
                        case 10: {
                            System.out.println("Enter new Position: ");
                            employee.setPosition(sc.nextLine());
                            break;
                        }
                        case 11: {
                            System.out.println("Enter new Salary: ");
                            employee.setSalary(Double.parseDouble(sc.nextLine()));
                            break;
                        }
                        case 0:
                            check = false;
                            break;
                        default:
                            System.out.println("Retry");
                            break;
                    }
                }
                System.out.println("Update successful");
                result = true;
                break;
            }
        }
        if (!result){
            System.out.println("Not Founded");
        }
    }

    //Delete by name
    @Override
    public void delete(){
        boolean check = false;
        System.out.println("Enter name of Employee want to delete: ");
        String nameDelete = sc.nextLine();
        for (Employee employee : employeeList) {
            if (employee.getName().toLowerCase().contains(nameDelete)){
                employeeList.remove(employee);
                System.out.println("Delete successful");
                display();
                check = true;
                break;
            }
        }
        if (!check){
            System.out.println("Not Founded");
        }
    }

    @Override
    public void findByName() {
        System.out.println("Enter name: ");
        String findName = sc.nextLine();
        boolean check = false;
        for (Employee employee : employeeList) {
            if (employee.getName().toLowerCase().contains(findName)) {
                System.out.println(employee.toString());
                check = true;
                break;
            }
        }
        if (!check){
            System.out.println("Not Founded");
        }
    }


}
