package com.example.navbar.customer;

public class customer {
    private int id;
    private String customerName;
    private String customerPassword;
    private String customerEmail;

    public customer(int id, String customerName, String customerPassword, String customerEmail){
        this.id = id;
        this.customerName = customerName;
        this.customerPassword = customerPassword;
        this.customerEmail = customerEmail;
    }
    public customer(){

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public String getCustomerPassword() {
        return customerPassword;
    }

    public void setCustomerPassword(String customerPassword) {
        this.customerPassword = customerPassword;
    }

    public String getCustomerEmail() {
        return customerEmail;
    }

    public void setCustomerEmail(String customerEmail) {
        this.customerEmail = customerEmail;
    }

    @Override
    public String toString(){
        return "customer{" +
                "id=" + id +
                ", customerName='" + customerName +'\'' +
                ", customerPassword='" + customerPassword +'\'' +
                ", customerEmail='" + customerEmail +'\'' +
                '}';
    }
}
