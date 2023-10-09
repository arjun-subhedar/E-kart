package tables;
public class Seller {
    int SellerID;
    String SellerName;
    String Location;
    public Seller(){}
    public Seller(int SellerID,String SellerName,String Location){
        this.SellerID=SellerID;
        this.SellerName=SellerName;
        this.Location=Location;
    }

    public int getSellerID() {
        return this.SellerID;
    }


    public String getSellerName() {
        return this.SellerName;
    }


    public String getLocation() {
        return this.Location;
    }

    public void setSellerID(int sellerID) {
        SellerID = sellerID;
    }

    public void setSellerName(String sellerName) {
        SellerName = sellerName;
    }

    public void setLocation(String location) {
        Location = location;
    }


}
