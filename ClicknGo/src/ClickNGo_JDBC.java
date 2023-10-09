import java.util.ArrayList;
import tables.*;
import java.sql.*;
import java.sql.Date;
import java.time.*;  
import java.text.DateFormat;  
import java.text.SimpleDateFormat;
// import java.sql.Date;
// import java.time.*;  
import java.util.*;
import useclasses.Triplet;
// import java.time.LocalDateTime;  
// import java.time.format.DateTimeFormatter;  
// import java.text.SimpleDateFormat;  

public class ClickNGo_JDBC implements ClicknGO {
	Connection dbConnection;
	public ClickNGo_JDBC(Connection dbconn){
		dbConnection = dbconn;
	}
	public void CreateCustomer(Customer cus)
	{
		PreparedStatement preparedStatement = null;
		String sql = "";
		sql="insert into Customers values(?,?,?,?,?)";
		try {
			preparedStatement = dbConnection.prepareStatement(sql);
			preparedStatement.setInt(1, cus.getCustomerID());
			preparedStatement.setString(2, cus.getCustomerName());
			preparedStatement.setString(3, cus.getAddress());
			preparedStatement.setInt(4, cus.getContact());
			preparedStatement.setString(5, cus.getEmail());
			preparedStatement.executeUpdate();
		}
		catch (SQLException e) {
			System.out.println(e.getMessage());
	   }
	   try
	   {
		   if (preparedStatement != null) 
		   {
			   preparedStatement.close();
		   }
	   } 
	   catch (SQLException e) 
	   {
		   System.out.println(e.getMessage());
	   }
	}
	public Customer CheckCustomer(int CustomerID)
	{
		PreparedStatement preparedStatement = null;
		String sql = "";
		sql="select * from Customers where CustomerID=?";
		Customer cus=null;
		try {
			preparedStatement = dbConnection.prepareStatement(sql);
			preparedStatement.setInt(1, CustomerID);
			ResultSet rs = preparedStatement.executeQuery();
			while(rs.next())
			{
				cus=new Customer(rs.getInt("CustomerID"),rs.getString("CustomerName"),rs.getString("Address"),rs.getInt("ContactNum"),rs.getString("email"));
			}	
		}
		catch (SQLException e) {
			System.out.println(e.getMessage());
	   }
	   try
	   {
		   if (preparedStatement != null) 
		   {
			   preparedStatement.close();
		   }
	   } 
	   catch (SQLException e) 
	   {
		   System.out.println(e.getMessage());
	   }
		return cus;
	}
	public Seller CheckSeller(int SellerID)
	{
		PreparedStatement preparedStatement = null;
		String sql = "";
		sql="select * from Sellers where SellerID=?";
		Seller sel=null;
		try {
			preparedStatement = dbConnection.prepareStatement(sql);
			preparedStatement.setInt(1, SellerID);
			ResultSet rs = preparedStatement.executeQuery();
			while(rs.next())
			{
				sel=new Seller(rs.getInt("SellerID"),rs.getString("SellerName"),rs.getString("Location"));
			}	
		}
		catch (SQLException e) {
			System.out.println(e.getMessage());
	   }
	   try
	   {
		   if (preparedStatement != null) 
		   {
			   preparedStatement.close();
		   }
	   } 
	   catch (SQLException e) 
	   {
		   System.out.println(e.getMessage());
	   }
		return sel;
	}
	public void CreateSeller(Seller sel)
	{
		PreparedStatement preparedStatement = null;
		String sql = "";
		sql="insert into Sellers values(?,?,?)";
		try {
			preparedStatement = dbConnection.prepareStatement(sql);
			preparedStatement.setInt(1,sel.getSellerID());
			preparedStatement.setString(2,sel.getSellerName());
			preparedStatement.setString(3,sel.getLocation());
			preparedStatement.executeUpdate();
		}
		catch (SQLException e) {
			System.out.println(e.getMessage());
	   }
	   try
	   {
		   if (preparedStatement != null) 
		   {
			   preparedStatement.close();
		   }
	   } 
	   catch (SQLException e) 
	   {
		   System.out.println(e.getMessage());
	   }
	}
	public DeliveryAgent CheckDeliveryAgent(int AgentID)
	{
		DeliveryAgent del=null;
		PreparedStatement preparedStatement = null;
		String sql = "";
		sql="select * from DeliveryAgents where AgentID=?";
		try {
			preparedStatement = dbConnection.prepareStatement(sql);
			preparedStatement.setInt(1, AgentID);
			ResultSet rs = preparedStatement.executeQuery();
			while(rs.next())
			{
				del=new DeliveryAgent(rs.getInt("AgentID"),rs.getString("AgentName"),rs.getInt("Rating"));
			}	
		}
		catch (SQLException e) {
			System.out.println(e.getMessage());
	   }
	   try
	   {
		   if (preparedStatement != null) 
		   {
			   preparedStatement.close();
		   }
	   } 
	   catch (SQLException e) 
	   {
		   System.out.println(e.getMessage());
	   }
		return del;
	}
	public void CreateDeliverAgent(DeliveryAgent del)
	{
		PreparedStatement preparedStatement = null;
		String sql = "";
		sql="insert into DeliveryAgents values(?,?,?)";
		try {
			preparedStatement = dbConnection.prepareStatement(sql);
			preparedStatement.setInt(1,del.getAgentID());
			preparedStatement.setString(2,del.getAgentName());
			preparedStatement.setInt(3,del.getRating());
			preparedStatement.executeUpdate();
		}
		catch (SQLException e) {
			System.out.println(e.getMessage());
	   }
	   try
	   {
		   if (preparedStatement != null) 
		   {
			   preparedStatement.close();
		   }
	   } 
	   catch (SQLException e) 
	   {
		   System.out.println(e.getMessage());
	   }
	}
	@Override
	public ArrayList<Category> printCategories()
	{
		ArrayList<Category> categories=new ArrayList<>();
		PreparedStatement preparedStatement = null;
		String sql = "";
		sql = "select * from Categories";
		try {
			preparedStatement = dbConnection.prepareStatement(sql);
			ResultSet rs = preparedStatement.executeQuery();
			{
				while(rs.next())
				{
					Category cat=new Category(rs.getInt("CategoryID"),rs.getString("CategoryName"));
					categories.add(cat);
				}
			}
		} 
		catch (SQLException e) {
			 System.out.println(e.getMessage());
		}
		try
		{
			if (preparedStatement != null) 
			{
				preparedStatement.close();
			}
		} 
		catch (SQLException e) 
		{
			System.out.println(e.getMessage());
		}
		return categories;
	}
	public ArrayList<Product> printProducts(Category cat)
	{
		ArrayList<Product> products=new ArrayList<>();
		PreparedStatement preparedStatement = null;
		String sql = "";
		sql = "select * from Products where CategoryID= ?";
		try {
			preparedStatement = dbConnection.prepareStatement(sql);
			preparedStatement.setInt(1, cat.getCategoryID());
			ResultSet rs = preparedStatement.executeQuery();
			while(rs.next())
				{
					// System.out.println(rs.getInt("ProductID")+" "+rs.getString("ProductName")+" "+rs.getInt("Price")+" "+rs.getInt("Quantity")+" "+rs.getInt("SellerID"));
					Product pr=new Product(rs.getInt("ProductID"),rs.getString("ProductName"),rs.getInt("CategoryID"),rs.getInt("Price"),rs.getInt("Quantity"),rs.getInt("SellerID"));
					products.add(pr);
				}	
		}
		catch (SQLException e) {
			System.out.println(e.getMessage());
	   }
	   try
	   {
		   if (preparedStatement != null) 
		   {
			   preparedStatement.close();
		   }
	   } 
	   catch (SQLException e) 
	   {
		   System.out.println(e.getMessage());
	   }
		return products;
	}
	@Override
	public Product getProduct(int ProductID,Category category)
	{
		Product pr=null;
		PreparedStatement preparedStatement = null;
		String sql = "";
		sql = "select * from Products where ProductID= ? and CategoryID=?";
		try {
			preparedStatement = dbConnection.prepareStatement(sql);
			preparedStatement.setInt(1, ProductID);
			preparedStatement.setInt(2, category.getCategoryID());
			ResultSet rs = preparedStatement.executeQuery();
			while(rs.next())
				{
					pr=new Product(rs.getInt("ProductID"),rs.getString("ProductName"),rs.getInt("CategoryID"),rs.getInt("Price"),rs.getInt("Quantity"),rs.getInt("SellerID"));
				}	
		}
		catch (SQLException e) {
			System.out.println(e.getMessage());
	   }
	   try
	   {
		   if (preparedStatement != null) 
		   {
			   preparedStatement.close();
		   }
	   } 
	   catch (SQLException e) 
	   {
		   System.out.println(e.getMessage());
	   }
	   return pr;
	}
	public ArrayList<Triplet> printallorders(Customer cus) {
		PreparedStatement preparedStatement = null;
		String sql;
		ResultSet rs=null;
		ArrayList<Triplet> trip=new ArrayList<>();
		sql = "select * from Orders o,Products p,Shipping s where p.ProductID=o.ProductID and o.OrderID=s.OrderID and o.CustomerID=?";
		preparedStatement=null;
		rs=null;
		try {
			preparedStatement = dbConnection.prepareStatement(sql);
			preparedStatement.setInt(1, cus.getCustomerID());
			rs = preparedStatement.executeQuery();
			while(rs.next())
			{
				Order o=new Order(rs.getInt("o.OrderID"),rs.getInt("o.CustomerID"),rs.getInt("o.ProductID"),rs.getInt("o.Quantity"),rs.getInt("o.SellerID"),rs.getDate("o.DateOfOrder"),rs.getString("o.CurrentStatus"));
				Product p=new Product(rs.getInt("p.ProductID"), rs.getString("p.ProductName"), rs.getInt("p.CategoryID"),rs.getInt("p.Price"), rs.getInt("p.Quantity"), rs.getInt("p.SellerID"));
				Shipping s=new Shipping(rs.getInt("s.ShippingID"),rs.getInt("s.OrderID"),rs.getInt("s.AgentID"),rs.getString("s.ModeOfPayment"),rs.getDate("s.DueDate"),rs.getString("s.Status"),rs.getString("s.Address"));
				// System.out.println(rs.getString("p.ProductName")+" "+rs.getString("o.Quantity")+" "+rs.getString("o.DateOfOrder")+" "+rs.getString("o.CurrentStatus")+" "+rs.getString("s.ModeOfPayment")+" "+rs.getString("s.DueDate"));
				Triplet t=new Triplet(o, p, s);
				trip.add(t);
			}
		} 
		catch (SQLException e) {
			 System.out.println(e.getMessage());
		}
		try
		{
			if (preparedStatement != null) 
			{
				preparedStatement.close();
			}
		} 
		catch (SQLException e) 
		{
			System.out.println(e.getMessage());
		}
		return trip;
	}

	@Override
	public ArrayList<Triplet> pendingorders(Seller sel) {
		ArrayList<Triplet> pend=new ArrayList<>();
		PreparedStatement preparedStatement = null;
		String sql;
		ResultSet rs=null;
		sql = "select * from Orders o,Products p,Shipping s where p.ProductID=o.ProductID and o.OrderID=s.OrderID and o.SellerID=? and o.CurrentStatus = 'shipped'";
		preparedStatement=null;
		rs=null;
		try 
		{
			preparedStatement = dbConnection.prepareStatement(sql);
			preparedStatement.setInt(1, sel.getSellerID());
			rs=preparedStatement.executeQuery();
			while(rs.next())
			{
				Order o=new Order(rs.getInt("o.OrderID"),rs.getInt("o.CustomerID"),rs.getInt("o.ProductID"),rs.getInt("o.Quantity"),rs.getInt("o.SellerID"),rs.getDate("o.DateOfOrder"),rs.getString("o.CurrentStatus"));
				Product p=new Product(rs.getInt("p.ProductID"), rs.getString("p.ProductName"), rs.getInt("p.CategoryID"),rs.getInt("p.Price"), rs.getInt("p.Quantity"), rs.getInt("p.SellerID"));
				Shipping s=new Shipping(rs.getInt("s.ShippingID"),rs.getInt("s.OrderID"),rs.getInt("s.AgentID"),rs.getString("s.ModeOfPayment"),rs.getDate("s.DueDate"),rs.getString("s.Status"),rs.getString("s.Address"));
				Triplet t=new Triplet(o, p, s);
				pend.add(t);
			}
		} 
		catch (SQLException e) {
			 System.out.println(e.getMessage());
		}
		try
		{
			if (preparedStatement != null) 
			{
				preparedStatement.close();
			}
		} 
		catch (SQLException e) 
		{
			System.out.println(e.getMessage());
		}
		return pend;
	}

	
	@Override
	public int sellinghistory(Seller seller, String date) {
		PreparedStatement preparedStatement = null;
		String sql;
		ResultSet rs=null;
		int value=0;
		sql = "select sum(o.Quantity*p.Price) as 'Total Sell Value' from Orders o, Products p where o.SellerID = p.SellerID and o.SellerID = ? and o.DateOfOrder >= ? and o.ProductID=p.ProductID";
		try {
			preparedStatement = dbConnection.prepareStatement(sql);
			preparedStatement.setInt(1, seller.getSellerID());
			preparedStatement.setString(2, date);
			
			rs=preparedStatement.executeQuery();
			while(rs.next())
			{
				value=rs.getInt("Total Sell Value");
			}
		} 
		catch (SQLException e) {
			 System.out.println(e.getMessage());
		}
		try
		{
			if (preparedStatement != null) 
			{
				preparedStatement.close();
			}
		} 
		catch (SQLException e) 
		{
			System.out.println(e.getMessage());
		}
		return value;
	}
	@Override
	public DeliveryAgent placeorder(Product product,Customer cus, String ModeofPayment) {
		PreparedStatement preparedstatement1 = null;
		String sql1;
		try{
			sql1 = "update Products set Quantity = Quantity - ? where ProductId = ?";
			preparedstatement1 = dbConnection.prepareStatement(sql1);
			preparedstatement1.setInt(1, product.getQuantity());
			preparedstatement1.setInt(2, product.getProductID());
			preparedstatement1.executeUpdate();
		} 
		catch (SQLException e) {
			 System.out.println(e.getMessage());
		}
		try
		{
			if (preparedstatement1 != null) 
			{
				preparedstatement1.close();
			}
		} 
		catch (SQLException e) 
		{
			System.out.println(e.getMessage());
		}
		int OrderID=1000,ShippingID=6000,AgentID=7000;
		PreparedStatement preparedstatement2 = null;
		String sql2;
		try{
			ResultSet rs1=null;
			sql2="select max(OrderID) as 'max'  from Orders";
			preparedstatement2 = dbConnection.prepareStatement(sql2);
			rs1=preparedstatement2.executeQuery();
			while(rs1.next())
			{
				OrderID=rs1.getInt("max");
				// System.out.println(OrderID);
			}
		} 
		catch (SQLException e) {
			 System.out.println(e.getMessage());
		}
		try
		{
			if (preparedstatement2 != null) 
			{
				preparedstatement2.close();
			}
		} 
		catch (SQLException e) 
		{
			System.out.println(e.getMessage());
		}
		preparedstatement2 = null;
		try{
			ResultSet rs1=null;
			sql2="select max(ShippingID) as 'max' from Shipping";
			preparedstatement2 = dbConnection.prepareStatement(sql2);
			rs1=preparedstatement2.executeQuery();
			while(rs1.next())
			{
				ShippingID=rs1.getInt("max");
				// System.out.println(ShippingID);
			}
		} 
		catch (SQLException e) {
			 System.out.println(e.getMessage());
		}
		try
		{
			if (preparedstatement2 != null) 
			{
				preparedstatement2.close();
			}
		} 
		catch (SQLException e) 
		{
			System.out.println(e.getMessage());
		}
		OrderID++;
		ShippingID++;
		ResultSet rs1 = null;
		AgentID=-1;
		PreparedStatement ps2 = null;
		try{
			ArrayList<Integer> AgentIds = new ArrayList<>();
			String sql3 = null;
			sql3 = "select AgentID from DeliveryAgents";
			ps2 = dbConnection.prepareStatement(sql3);
			rs1 = ps2.executeQuery();
			while(rs1.next())
			{
				AgentIds.add(rs1.getInt("AgentID"));
			}
			Random rn = new Random();
			int answer = rn.nextInt(AgentIds.size());
			AgentID = AgentIds.get(answer);
		}
		catch (SQLException e) 
		{
			System.out.println(e.getMessage());
		}
		try
		{
			if (ps2 != null) 
			{
				ps2.close();
			}
		} 
		catch (SQLException e) 
		{
			System.out.println(e.getMessage());
		}
		LocalDate lt = LocalDate.now();
		Date date_today = java.sql.Date.valueOf(lt);
		// DateFormat dateFormat = new SimpleDateFormat("yyyy-mm-dd");  
		// String date = dateFormat.format(date_today); 
		PreparedStatement preparedStatement3 = null;
		String sql3;
		try{
			sql3="insert into Orders values(?,?,?,?,?,?,?)";
			preparedStatement3 = dbConnection.prepareStatement(sql3);
			preparedStatement3.setInt(1, OrderID);
			preparedStatement3.setInt(2, cus.getCustomerID());
			preparedStatement3.setInt(3, product.getProductID());
			preparedStatement3.setInt(4, product.getQuantity());
			preparedStatement3.setInt(5, product.getSellerID());
			preparedStatement3.setDate(6, (Date)date_today);
			preparedStatement3.setString(7, "Shipped");
			preparedStatement3.executeUpdate();
		} 
		catch (SQLException e) {
			 System.out.println(e.getMessage());
		}
		try
		{
			if (preparedStatement3 != null) 
			{
				preparedStatement3.close();
			}
		} 
		catch (SQLException e) 
		{
			System.out.println(e.getMessage());
		}
		PreparedStatement preparedStatement4 = null;
		String sql4;

		Calendar c = Calendar.getInstance();
		c.add(Calendar.DATE, 10);
		LocalDate due_date = LocalDate.now().plusDays(10);
		Date DueDate = java.sql.Date.valueOf(due_date);
		try{
			sql4="insert into shipping values(?,?,?,?,?,?,?)";
			preparedStatement4 = dbConnection.prepareStatement(sql4);
			preparedStatement4.setInt(1, ShippingID);
			preparedStatement4.setInt(2, OrderID);
			preparedStatement4.setInt(3, AgentID);
			preparedStatement4.setString(4, ModeofPayment);
			preparedStatement4.setDate(5, DueDate);
			preparedStatement4.setString(6, "Shipped");
			preparedStatement4.setString(7, cus.getAddress());
			preparedStatement4.executeUpdate();
		} 
		catch (SQLException e) {
			 System.out.println(e.getMessage());
		}
		try
		{
			if (preparedStatement4 != null) 
			{
				preparedStatement4.close();
			}
		} 
		catch (SQLException e) 
		{
			System.out.println(e.getMessage());
		}
		PreparedStatement preparedStatement5 = null;
		String sql5;
		rs1=null;
		DeliveryAgent agent=null;
		try{
			sql5="select * from DeliveryAgents where AgentID=?";
			preparedStatement5 = dbConnection.prepareStatement(sql5);
			preparedStatement5.setInt(1, AgentID);
			rs1=preparedStatement5.executeQuery();
			while(rs1.next())
			{
				agent=new DeliveryAgent(rs1.getInt("AgentID"),rs1.getString("AgentName"),rs1.getInt("Rating"));
			}
		} 
		catch (SQLException e) {
			 System.out.println(e.getMessage());
		}
		try
		{
			if (preparedStatement5 != null) 
			{
				preparedStatement5.close();
			}
		} 
		catch (SQLException e) 
		{
			System.out.println(e.getMessage());
		}
		return agent;
	}

	@Override
	public ArrayList<Shipping> mydeliveries(DeliveryAgent deliveryagent)
	{
		ArrayList<Shipping> deliveries=new ArrayList<>();
		PreparedStatement preparedStatement = null;
		String sql;
		ResultSet rs=null;
		sql = "select * from Shipping where AgentID = ?";
		preparedStatement=null;
		rs=null;
		try {
			preparedStatement = dbConnection.prepareStatement(sql);
			preparedStatement.setInt(1, deliveryagent.getAgentID());
			rs=preparedStatement.executeQuery();
			while(rs.next())
			{
				// System.out.println(rs.getString("ShippingID")+ rs.getString("OrderID")+ rs.getString("ModeOfpayment")+rs.getString("DueDate"));
				Shipping sp=new Shipping(rs.getInt("ShippingID"), rs.getInt("OrderID"), rs.getInt("AgentID"), rs.getString("ModeOfPayment"), rs.getDate("DueDate"), rs.getString("Status"), rs.getString("Address"));
				deliveries.add(sp);
			}
		} 
		catch (SQLException e) {
			 System.out.println(e.getMessage());
		}
		try
		{
			if (preparedStatement != null) 
			{
				preparedStatement.close();
			}
		} 
		catch (SQLException e) 
		{
			System.out.println(e.getMessage());
		}
		return deliveries;
	}
	public Category getCategory(int CategoryID)
	{
		Category cat=null;
		ResultSet rs;
		PreparedStatement preparedStatement = null;
		Order o=null;
		String sql="";
		sql=" select * from Categories where CategoryID=?";
		try {
			preparedStatement = dbConnection.prepareStatement(sql);
			preparedStatement.setInt(1, CategoryID);
			rs = preparedStatement.executeQuery();
			while(rs.next()){
				cat=new Category(rs.getInt("CategoryID"),rs.getString("CategoryName"));
			}
			
		} 
		catch (SQLException e) {
			 System.out.println(e.getMessage());
		}
		try
		{
			if (preparedStatement != null) 
			{
				preparedStatement.close();
			}
		} 
		catch (SQLException e) 
		{
			System.out.println(e.getMessage());
		}
		return cat;

	}
	public Order getOrder(int OrderID,DeliveryAgent agent)
	{
		ResultSet rs;
		PreparedStatement preparedStatement = null;
		Order o=null;
		String sql="";
		sql=" select * from Orders where OrderID=?";
		try {
			preparedStatement = dbConnection.prepareStatement(sql);
			preparedStatement.setInt(1, OrderID);
			// preparedStatement.setInt(2, agent.getAgentID());
			rs = preparedStatement.executeQuery();
			while(rs.next()){
				o=new Order(rs.getInt("OrderID"),rs.getInt("CustomerID"),rs.getInt("ProductID"),rs.getInt("Quantity"),rs.getInt("SellerID"),rs.getDate("DateOfOrder"),rs.getString("CurrentStatus"));
			}
			
		} 
		catch (SQLException e) {
			 System.out.println(e.getMessage());
		}
		try
		{
			if (preparedStatement != null) 
			{
				preparedStatement.close();
			}
		} 
		catch (SQLException e) 
		{
			System.out.println(e.getMessage());
		}
		return o;

	}
	public String updatestatus(Order Order, DeliveryAgent agent, String status)
	{
		ArrayList<Shipping> orders = new ArrayList<Shipping>();
		int flag = 0;
		orders = mydeliveries(agent);
		for (int i = 0; i < orders.size(); i++)
		{
			if (orders.get(i).getOrderID() == Order.getOrderID())
			{
				flag = 1;
				break;
			}
		}
		if (flag == 0)
		{
			return "This is not your order.";
		}
		PreparedStatement preparedStatement = null;
		String sql1;
		sql1 = "update Orders set CurrentStatus = ? where OrderID = ?";
		preparedStatement=null;
		try {
			preparedStatement = dbConnection.prepareStatement(sql1);
			preparedStatement.setString(1, status);
			preparedStatement.setInt(2, Order.getOrderID());
			preparedStatement.executeUpdate();
		} 
		catch (SQLException e) {
			 System.out.println(e.getMessage());
		}
		try
		{
			if (preparedStatement != null) 
			{
				preparedStatement.close();
			}
		} 
		catch (SQLException e) 
		{
			System.out.println(e.getMessage());
		}

		PreparedStatement preparedStatement2 = null;
		String sql3;
		sql3 = "update Shipping set Status = ? where OrderID = ?";
		try {
			preparedStatement2 = dbConnection.prepareStatement(sql3);
			preparedStatement2.setString(1, status);
			preparedStatement2.setInt(2, Order.getOrderID());
			preparedStatement2.executeUpdate();
		} 
		catch (SQLException e) {
			 System.out.println(e.getMessage());
		}
		try
		{
			if (preparedStatement2 != null) 
			{
				preparedStatement2.close();
			}
		} 
		catch (SQLException e) 
		{
			System.out.println(e.getMessage());
		}
		return "Succesfully updated!";
	}
	public int getCustomerID()
	{
		int CustomerID=0;
		PreparedStatement preparedstatement2 = null;
		String sql2;
		try{
			ResultSet rs1=null;
			sql2="select max(CustomerID) as 'max'  from Customers";
			preparedstatement2 = dbConnection.prepareStatement(sql2);
			rs1=preparedstatement2.executeQuery();
			while(rs1.next())
			{
				CustomerID=rs1.getInt("max");
			}
		} 
		catch (SQLException e) {
			 System.out.println(e.getMessage());
		}
		try
		{
			if (preparedstatement2 != null) 
			{
				preparedstatement2.close();
			}
		} 
		catch (SQLException e) 
		{
			System.out.println(e.getMessage());
		}
		CustomerID++;
		return CustomerID;
	}
	public int getSellerID()
	{
		int SellerID=0;
		PreparedStatement preparedstatement2 = null;
		String sql2;
		try{
			ResultSet rs1=null;
			sql2="select max(SellerID) as 'max'  from Sellers";
			preparedstatement2 = dbConnection.prepareStatement(sql2);
			rs1=preparedstatement2.executeQuery();
			while(rs1.next())
			{
				SellerID=rs1.getInt("max");
			}
		} 
		catch (SQLException e) {
			 System.out.println(e.getMessage());
		}
		try
		{
			if (preparedstatement2 != null) 
			{
				preparedstatement2.close();
			}
		} 
		catch (SQLException e) 
		{
			System.out.println(e.getMessage());
		}
		SellerID++;
		return SellerID;
	}
	public int getAgentID()
	{
		int AgentID=0;
		PreparedStatement preparedstatement2 = null;
		String sql2;
		try{
			ResultSet rs1=null;
			sql2="select max(AgentID) as 'max'  from DeliveryAgents";
			preparedstatement2 = dbConnection.prepareStatement(sql2);
			rs1=preparedstatement2.executeQuery();
			while(rs1.next())
			{
				AgentID=rs1.getInt("max");
			}
		} 
		catch (SQLException e) {
			 System.out.println(e.getMessage());
		}
		try
		{
			if (preparedstatement2 != null) 
			{
				preparedstatement2.close();
			}
		} 
		catch (SQLException e) 
		{
			System.out.println(e.getMessage());
		}
		AgentID++;
		return AgentID;
	}
}

