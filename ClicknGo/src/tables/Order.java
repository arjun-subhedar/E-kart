package tables;
import java.sql.Date;

public class Order {
    int OrderID;
    Date DateOfOrder;
    String status;
    int CustomerID;
    int ProductID;
    int Quantity;
    int SellerID;

    public Order(int OrderID,int CustomerID, int ProductID, int Quantity, int SellerID, Date DateOfOrder,String status){
        this.OrderID=OrderID;
        this.SellerID=SellerID;
        this.ProductID=ProductID;
        this.CustomerID=CustomerID;
        this.DateOfOrder=DateOfOrder;
        this.status=status;
        this.Quantity=Quantity;
    }

    public int getOrderID() {
        return OrderID;
    }

    public void setOrderID(int orderID) {
        OrderID = orderID;
    }

    public Date getDateOfOrder() {
        return DateOfOrder;
    }

    public void setDateOfOrder(Date dateOfOrder) {
        DateOfOrder = dateOfOrder;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public int getCustomerID() {
        return CustomerID;
    }

    public void setCustomerID(int customerID) {
        CustomerID = customerID;
    }

    public int getProductID() {
        return ProductID;
    }

    public void setProductID(int productID) {
        ProductID = productID;
    }

    public int getQuantity() {
        return Quantity;
    }

    public void setQuantity(int quantity) {
        Quantity = quantity;
    }

    public int getSellerID() {
        return SellerID;
    }

    public void setSellerID(int sellerID) {
        SellerID = sellerID;
    }


}
