import java.util.*;
import tables.*;
import useclasses.*;
public interface ClicknGO {
	public Customer CheckCustomer(int CustomerID);
	public void CreateCustomer(Customer cus);
	public Seller CheckSeller(int SellerID);
	public void CreateSeller(Seller sel);
	public DeliveryAgent CheckDeliveryAgent(int AgentID);
	public void CreateDeliverAgent(DeliveryAgent del);
	public ArrayList<Category> printCategories();
	public ArrayList<Product> printProducts(Category cat);
	public ArrayList<Triplet> printallorders(Customer cus);
	public ArrayList<Triplet> pendingorders(Seller sel);
	public int sellinghistory(Seller seller, String date);
	public Product getProduct(int ProductID,Category category);
	public Order getOrder(int OrderID,DeliveryAgent agent);
	public Category getCategory(int CategoryID);
	public DeliveryAgent placeorder(Product product,Customer cus, String ModeofPayment);
	public ArrayList<Shipping> mydeliveries(DeliveryAgent deliveryagent);
	public String updatestatus(Order Order, DeliveryAgent agent, String status);
	public int getCustomerID();
	public int getSellerID();
	public int getAgentID();
}

