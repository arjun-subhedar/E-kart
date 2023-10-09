package tables;
import java.sql.Date;

public class Shipping {
    int ShippingID;
    int OrderID;
    int AgentID;
    Date DueDate;
    String ModeOfPayment;
    String status;
    String Address;
    public Shipping(int ShippingID,int OrderID, int AgentID,String ModeOfPayment, Date DueDate, String status, String Address){
        this.ShippingID=ShippingID;
        this.DueDate=DueDate;
        this.ModeOfPayment=ModeOfPayment;
        this.OrderID=OrderID;
        this.AgentID=AgentID;
        this.status=status;
        this.Address=Address;
    }
    public int getShippingID() {
        return ShippingID;
    }
    public void setShippingID(int shippingID) {
        ShippingID = shippingID;
    }
    public int getOrderID() {
        return OrderID;
    }
    public void setOrderID(int orderID) {
        OrderID = orderID;
    }
    public int getAgentID() {
        return AgentID;
    }
    public void setAgentID(int agentID) {
        AgentID = agentID;
    }
    public Date getDueDate() {
        return DueDate;
    }
    public void setDueDate(Date dueDate) {
        DueDate = dueDate;
    }
    public String getModeOfPayment() {
        return ModeOfPayment;
    }
    public void setModeOfPayment(String modeOfPayment) {
        ModeOfPayment = modeOfPayment;
    }
    public String getStatus() {
        return status;
    }
    public void setStatus(String status) {
        this.status = status;
    }
    public String getAddress() {
        return Address;
    }
    public void setAddress(String address) {
        Address = address;
    }
}
