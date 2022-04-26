package models;

import models.person.Customer;

public class Contract {
    private String idContract;
    private Booking booking;
    private String prePayment;
    private String Expense;
    private Customer customer;

    public Contract() {
    }

    public Contract(String idContract, Booking booking, String prePayment, String expense, Customer customer) {
        this.idContract = idContract;
        this.booking = booking;
        this.prePayment = prePayment;
        Expense = expense;
        this.customer = customer;
    }

    public String getIdContract() {
        return idContract;
    }

    public void setIdContract(String idContract) {
        this.idContract = idContract;
    }

    public Booking getBooking() {
        return booking;
    }

    public void setBooking(Booking booking) {
        this.booking = booking;
    }

    public String getPrePayment() {
        return prePayment;
    }

    public void setPrePayment(String prePayment) {
        this.prePayment = prePayment;
    }

    public String getExpense() {
        return Expense;
    }

    public void setExpense(String expense) {
        Expense = expense;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    @Override
    public String toString() {
        return "Contract{" +
                "idContract='" + idContract + '\'' +
                ", booking=" + booking +
                ", prePayment='" + prePayment + '\'' +
                ", Expense='" + Expense + '\'' +
                ", customer=" + customer +
                '}';
    }
}
