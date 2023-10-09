package tables;
public class Category {
    int CategoryID;
    String CategoryName;
    public Category(){}
    public Category(int CategoryID,String CategoryName){
        this.CategoryID=CategoryID;
        this.CategoryName=CategoryName;
    }

    public int getCategoryID() {
        return this.CategoryID;
    }

    public String getCategoryName() {
        return this.CategoryName;
    }


}
