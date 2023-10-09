package tables;
public class Product {
    int ProductID;
    String ProductName;
    int CategoryID;
    int Price;
    int Quantity;
    int SellerID;
    public Product(int ProductID,String ProductName,int CategoryID,int Price,int Quantity,int SellerID){
        this.ProductID=ProductID;
        this.ProductName=ProductName;
        this.Price=Price;
        this.Quantity=Quantity;
        this.SellerID=SellerID;
        this.CategoryID=CategoryID;
    }
    public int getProductID() {
        return ProductID;
    }
    public void setProductID(int productID) {
        ProductID = productID;
    }
    public String getProductName() {
        return ProductName;
    }
    public void setProductName(String productName) {
        ProductName = productName;
    }
    public int getCategoryID() {
        return CategoryID;
    }
    public void setCategoryID(int categoryID) {
        CategoryID = categoryID;
    }
    public int getPrice() {
        return Price;
    }
    public void setPrice(int price) {
        Price = price;
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
