package services.libs_of_impl;

import models.person.Customer;
import models.person.Employee;
import services.libs_of_interface.CustomerService;

import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class CustomerServiceImpl extends ServiceAbstract implements CustomerService {
    private static List<Customer> customerList = new LinkedList<>();
    public static Scanner sc = new Scanner(System.in);


    @Override
    public void display() {
        for (Customer customer : customerList) {
            System.out.println(customer.toString());
        }
    }

    @Override
    public void addNew() {
        System.out.println("Enter id: ");
        int inputId = Integer.parseInt(sc.nextLine());
        System.out.println("Enter name: ");
        String inputName = sc.nextLine();
        System.out.println("Enter age: ");
        int inputAge = Integer.parseInt(sc.nextLine());
        System.out.println("Enter address: ");
        String inputAddress = sc.nextLine();
        System.out.println("Choose gender: 1.Male / 2.Female ");
        int chooseGender = Integer.parseInt(sc.nextLine());
        boolean comfirmGender = false;
        if (chooseGender == 1) {
            comfirmGender = true;
        } else {
            comfirmGender = false;
        }
        System.out.println("Enter IdCard: ");
        int inputIdCard = Integer.parseInt(sc.nextLine());
        System.out.println("Enter phone number: ");
        int inputNumPhone = Integer.parseInt(sc.nextLine());
        System.out.println("Enter email: ");
        String inputEmail = sc.nextLine();
        System.out.println("Enter type customer: ");
        String inputType = sc.nextLine();
        customerList.add(new Customer(inputId,
                                    inputName,
                                    inputAge,
                                    inputAddress,
                                    comfirmGender,
                                    inputIdCard,
                                    inputNumPhone,
                                    inputEmail,
                                    inputType));
        System.out.println("Add new successful");
    }

    @Override
    public void edit() {
        boolean result = false;
        System.out.println("Enter name employee want to edit");
        String findName = sc.nextLine();
        for (Customer customer : customerList) {
            if (customer.getName().contains(findName)) {
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
                    System.out.println("9.Edit Type.");
                    System.out.println("0. Return Main menu");
                    System.out.println("Choose your option");
                    int choose = Integer.parseInt(sc.nextLine());
                    switch (choose) {
                        case 1: {
                            System.out.println("Enter new Id: ");
                            customer.setId(Integer.parseInt(sc.nextLine()));
                            break;
                        }
                        case 2: {
                            System.out.println("Enter new Name: ");
                            customer.setName(sc.nextLine());
                            break;
                        }
                        case 3: {
                            System.out.println("Enter new Age: ");
                            customer.setAge(Integer.parseInt(sc.nextLine()));
                            break;
                        }
                        case 4: {
                            System.out.println("Enter new Address: ");
                            customer.setAddress(sc.nextLine());
                            break;
                        }

                        case 5: {
                            System.out.println("1. Male / 2.Female");
                            if (Integer.parseInt(sc.nextLine()) == 1) {
                                customer.setGender(true);
                            } else {
                                customer.setGender(false);
                            }
                            break;
                        }
                        case 6: {
                            System.out.println("Enter new IdCard: ");
                            customer.setIdCard(Integer.parseInt(sc.nextLine()));
                            break;
                        }
                        case 7: {
                            System.out.println("Enter new Phone Number: ");
                            customer.setPhoneNumber(Integer.parseInt(sc.nextLine()));
                            break;
                        }
                        case 8: {
                            System.out.println("Enter new Email: ");
                            customer.setEmail(sc.nextLine());
                            break;
                        }
                        case 9:
                            System.out.println("Enter new Level: ");
                            customer.setTypeCustomer(sc.nextLine());
                            break;

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

    @Override
    public void delete() {
        boolean check = false;
        System.out.println("Enter name of Employee want to delete: ");
        String nameDelete = sc.nextLine();
        for (Customer customer : customerList) {
            if (customer.getName().toLowerCase().contains(nameDelete)){
                customerList.remove(customer);
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
        for (Customer customer : customerList) {
            if (customer.getName().toLowerCase().contains(findName)) {
                System.out.println(customer.toString());
                check = true;
                break;
            }
        }
        if (!check){
            System.out.println("Not Founded");
        }
    }


}
