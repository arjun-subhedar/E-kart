package tables;

public class Customer {
    int CustomerID;
    String CustomerName;
    String Address;
    int Contact;
    String Email;

    public Customer() {
    };

    public Customer(int CustomerID, String CustomerName, String Address, int Contact, String Email) {
        this.CustomerID = CustomerID;
        this.CustomerName = CustomerName;
        this.Address = Address;
        this.Contact = Contact;
        this.Email = Email;
    }

    public int getCustomerID() {
        return this.CustomerID;
    }

    public String getCustomerName() {
        return this.CustomerName;
    }

    public void setCustomerID(int customerID) {
        CustomerID = customerID;
    }

    public void setCustomerName(String customerName) {
        CustomerName = customerName;
    }

    public void setAddress(String address) {
        Address = address;
    }

    public void setContact(int contact) {
        Contact = contact;
    }

    public void setEmail(String email) {
        Email = email;
    }

    public String getAddress() {
        return this.Address;
    }

    public int getContact() {
        return this.Contact;
    }

    public String getEmail() {
        return this.Email;
    }
    
}
