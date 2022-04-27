package controllers;

import services.libs_of_impl.*;

import java.io.IOException;
import java.util.Scanner;

public class FuramaController {
    public static Scanner sc = new Scanner(System.in);
    static FacilityServiceImpl facilityService = new FacilityServiceImpl();
    static EmployeeServiceImpl employeeService = new EmployeeServiceImpl();
    static CustomerServiceImpl customerService = new CustomerServiceImpl();
    static BookingServiceImpl bookingService = new BookingServiceImpl();
    static ContractServiceImpl contractService = new ContractServiceImpl();
    public static void main(String[] args) throws IOException {
        displayMainMenu();
    }

    public static void displayMainMenu() throws IOException {
        boolean check = true;
        while (check) {
            System.out.println("1. Employee Management.");
            System.out.println("2. Customer Management.");
            System.out.println("3. Facility Management.");
            System.out.println("4. Booking Management.");
            System.out.println("5. Promotion Management.");
            System.out.println("6. Exit.");
            System.out.println("Choose your option: ");
            try {
                switch (Integer.parseInt(sc.nextLine())) {
                    case 1:
                        displayEmployeeMenu();
                        break;
                    case 2:
                        displayCustomerMenu();
                        break;
                    case 3:
                        displayFacilityMenu();
                        break;
                    case 4:
                        displayBookingMenu();
                        break;
                    case 5:
                        displayPromotionMenu();
                        break;
                    case 6:
                        System.exit(0);
                        break;
                }
            }catch (NumberFormatException e){
                System.out.println("Retry");
            }
        }
    }

    public static void displayEmployeeMenu() throws IOException {

        boolean check = true;
        while (check) {
            System.out.println("1. Display list employees.");
            System.out.println("2. Add new employees.");
            System.out.println("3. Edit employee.");
            System.out.println("4. Delete employee.");
            System.out.println("5. Find employee.");
            System.out.println("0. Return main menu.");
            try {
                switch (Integer.parseInt(sc.nextLine())) {
                    case 1: {
                        employeeService.display();
                        break;
                    }
                    case 2: {
                        employeeService.addNew();
                        break;
                    }
                    case 3: {
                        employeeService.edit();
                        break;
                    }
                    case 4: {
                        employeeService.delete();
                        break;
                    }
                    case 5:{
                        employeeService.findByName();
                        break;
                    }
                    case 0: {
                        check = false;
                        break;
                    }
                    default: {
                        System.out.println("Retry");
                        break;
                    }
                }
            }catch (NumberFormatException e){
                System.out.println("Please enter number");
            }
        }
    }

    public static void displayCustomerMenu() {

        boolean check = true;
        while (check) {
            System.out.println("1. Display list customers.");
            System.out.println("2. Add new customer.");
            System.out.println("3. Edit customer.");
            System.out.println("4. Delete customer.");
            System.out.println("5. Find customer.");
            System.out.println("0. Return main menu");
            try {
                switch (Integer.parseInt(sc.nextLine())) {
                    case 1: {
                        customerService.display();
                        break;
                    }
                    case 2: {
                        customerService.addNew();
                        break;
                    }
                    case 3: {
                        customerService.edit();
                        break;
                    }
                    case 4: {
                        customerService.delete();
                        break;
                    }
                    case 5: {
                        customerService.findByName();
                        break;
                    }
                    case 0: {
                        check = false;
                        break;
                    }
                    default: {
                        System.out.println("Retry");
                        break;
                    }
                }
            }catch (NumberFormatException e){
                System.out.println("Please enter number");
            }
        }
    }

    public static void displayBookingMenu() {
        boolean check = true;
        while (check) {
            System.out.println("1.Add new booking.");
            System.out.println("2.Display list booking.");
            System.out.println("3.Create new contracts.");
            System.out.println("4.Display list contracts.");
            System.out.println("5.Edit contracts.");
            System.out.println("0.Return main menu.");
            try {
                switch (Integer.parseInt(sc.nextLine())) {
                    case 1: {
                        bookingService.addBooking();
                        break;
                    }
                    case 2:{
                        bookingService.displayListBooking();
                        break;
                    }
                    case 3:{
                        contractService.createNewContract();
                        break;
                    }
                    case 4:{
                        contractService.displayListContract();
                        break;
                    }
                    case 5:{

                    }
                    case 0:{
                        check = false;
                        break;
                    }
                    default:{
                        System.out.println("Retry");
                        break;
                    }
                }
            }catch (NumberFormatException e){
                System.out.println("Please enter number");
            }
        }
    }

    public static void displayFacilityMenu() {
        boolean check = true;
        while (check) {
            System.out.println("1. Display list facility");
            System.out.println("2. Add new facility");
            System.out.println("3. Display list facility maintenance");
            System.out.println("0. Return main menu");
            try {
                switch (Integer.parseInt(sc.nextLine())) {
                    case 1: {
                        facilityService.display();
                        break;
                    }
                    case 2: {
                        addNewFacilityMenu();
                        break;
                    }
                    case 3:{
                        facilityService.addFacilityMaintain();
                        break;
                    }
                    case 0:
                        check = false;
                        break;
                    default:
                        System.out.println("Retry");
                        break;
                }
            }catch (NumberFormatException e){
                System.out.println("Please enter number");
            }
        }
    }

    public static void addNewFacilityMenu() {
        boolean check = true;
        while (check) {
            System.out.println("1. Add new Villa.");
            System.out.println("2. Add new House.");
            System.out.println("3. Add new Room.");
            System.out.println("0. Return main menu");
            try {
                switch (Integer.parseInt(sc.nextLine())) {
                    case 1: {
                        facilityService.addNewVilla();
                        displayFacilityMenu();
                        break;
                    }
                    case 2: {
                        facilityService.addNewHouse();
                        displayFacilityMenu();
                        break;
                    }
                    case 3:
                        facilityService.addNewRoom();
                        displayFacilityMenu();
                        break;
                    case 0:
                        check = false;
                        break;
                    default:
                        System.out.println("Retry");
                        break;
                }
            }catch (NumberFormatException e){
                System.out.println("Please enter number");
            }
        }
    }

    public static void displayPromotionMenu() {
        boolean check = true;
        while (check) {
            System.out.println("Display list customers use service");
            System.out.println("Display list customers get voucher");
            System.out.println("Return main menu");
            switch (Integer.parseInt(sc.nextLine())) {
                case 1: {
                    break;
                }

            }
        }
    }

}
