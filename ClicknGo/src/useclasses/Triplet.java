package useclasses;
import tables.*;
public class Triplet {
    Order o;
    Product p;
    Shipping s;
    public Triplet(Order o, Product p, Shipping s) {
        this.o = o;
        this.p = p;
        this.s = s;
    }
    public Order getO() {
        return o;
    }
    public void setO(Order o) {
        this.o = o;
    }
    public Product getP() {
        return p;
    }
    public void setP(Product p) {
        this.p = p;
    }
    public Shipping getS() {
        return s;
    }
    public void setS(Shipping s) {
        this.s = s;
    }
    
}







// PreparedStatement ps = null;
// 		ResultSet rs = null;
// 		int sellerID = 5001;
// 		try{
// 			String st = "select * from Products where ProductID=?";
// 			ps = dbConnection.prepareStatement(st);
// 			ps.setInt(1, ProductId);
// 			rs = ps.executeQuery();
// 			while(rs.next())
// 			{
// 				sellerID = rs.getInt("SellerID");
// 			}
// 			System.out.println(sellerID);

// 		}
// 		catch (SQLException e) {
// 			System.out.println(e.getMessage());
// 	   }
// 	   	try
// 		{
// 			if (ps != null) 
// 			{
// 				ps.close();
// 			}
// 		} 
// 		catch (SQLException e) 
// 		{
// 			System.out.println(e.getMessage());
// 		}
// 		PreparedStatement preparedStatement2 = null;
// 		String sql2;
// 		try{
// 			LocalDate lt = LocalDate.now();
// 			Date date = java.sql.Date.valueOf(lt);
// 			sql2 = "insert into Orders (CustomerID, ProductID, Quantity, SellerID, DateOfOrder, CurrentStatus) values (?, ?, ?, ?, ?, ?)";
// 			preparedStatement2 = dbConnection.prepareStatement(sql2);
// 			preparedStatement2.setInt(1, customerID);
// 			preparedStatement2.setInt(2, ProductId);
// 			preparedStatement2.setInt(3, Qty);
// 			preparedStatement2.setInt(4, sellerID);
// 			preparedStatement2.setDate(5, date);
// 			preparedStatement2.setString(6, "Shipped");
// 			preparedStatement2.executeUpdate();
// 		} 
// 		catch (SQLException e) {
// 			 System.out.println(e.getMessage());
// 		}
// 		try
// 		{
// 			if (preparedStatement2 != null) 
// 			{
// 				preparedStatement2.close();
// 			}
// 		} 
// 		catch (SQLException e) 
// 		{
// 			System.out.println(e.getMessage());
// 		}
// 		ResultSet rs1 = null;
// 		int AgentID=-1;
// 		PreparedStatement ps2 = null;
// 		try{
// 			ArrayList<Integer> AgentIds = new ArrayList<>();
			
// 			String sql3 = null;
// 			sql3 = "select AgentID from DeliveryAgents";
// 			ps2 = dbConnection.prepareStatement(sql3);
// 			rs1 = ps2.executeQuery();
// 			while(rs1.next())
// 			{
// 				AgentIds.add(rs1.getInt("AgentID"));
// 			}
// 			Random rn = new Random();
// 			int answer = rn.nextInt(AgentIds.size());
// 			AgentID = AgentIds.get(answer);
// 		}
// 		catch (SQLException e) 
// 		{
// 			System.out.println(e.getMessage());
// 		}
// 		try
// 		{
// 			if (ps2 != null) 
// 			{
// 				ps2.close();
// 			}
// 		} 
// 		catch (SQLException e) 
// 		{
// 			System.out.println(e.getMessage());
// 		}
// 		ResultSet rs2=null; 
// 		PreparedStatement ps3=null;
// 		String Address="";
// 		try{
// 			String sql4="select Address from Customers where CustomerID=?";
// 			ps3 = dbConnection.prepareStatement(sql4);
// 			ps3.setInt(1, customerID);
// 			rs2 = ps3.executeQuery();

// 			while(rs2.next())
// 			{
// 				Address = rs2.getString("Address");
// 			}
// 			// System.out.println(Address);
// 		}
// 		catch (SQLException e) 
// 		{
// 			System.out.println(e.getMessage());
// 		}
// 		try
// 		{
// 			if (ps3 != null) 
// 			{
// 				ps3.close();
// 			}
// 		} 
// 		catch (SQLException e) 
// 		{
// 			System.out.println(e.getMessage());
// 		}
// 		ResultSet rs3=null;
// 		PreparedStatement ps4=null;
// 		int OrderID=-1;
// 		try{
// 			String sql4 = "select max(OrderID) CurrentOrderID from Orders";
// 			ps4 = dbConnection.prepareStatement(sql4);
// 			rs3 = ps4.executeQuery();
// 			while(rs3.next())
// 			{
// 				OrderID = rs3.getInt("CurrentOrderID");
// 			}
// 			// System.out.println(OrderID);
// 			//OrderID++;
// 		}
// 		catch (SQLException e) 
// 		{
// 			System.out.println(e.getMessage());
// 		}
// 		try
// 		{
// 			if (ps4 != null) 
// 			{
// 				ps4.close();
// 			}
// 		} 
// 		catch (SQLException e) 
// 		{
// 			System.out.println(e.getMessage());
// 		}
// 		PreparedStatement ps5=null;
		
// 		try{
// 			String sql5 = "insert into Shipping (OrderID, AgentID, ModeOfPayment, DueDate, Status, Address) values (?,?,?,?,?,?)";
// 			ps5 = dbConnection.prepareStatement(sql5);
// 			ps5.setInt(1, OrderID);
// 			ps5.setInt(2,AgentID);
// 			ps5.setString(3, ModeofPayment);
// 			ps5.setDate(4, null);
// 			ps5.setString(5, "shipped");
// 			ps5.setString(6, Address);
// 			ps5.executeUpdate();
// 		}
// 		catch (SQLException e) 
// 		{
// 			System.out.println(e.getMessage());
// 		}
// 		try
// 		{
// 			if (ps5 != null) 
// 			{
// 				ps5.close();
// 			}
// 		} 
// 		catch (SQLException e) 
// 		{
// 			System.out.println(e.getMessage());
// 		}
// 	}