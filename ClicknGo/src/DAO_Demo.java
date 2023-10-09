//STEP 1. Import required packages
import java.util.*;
import tables.*;
import useclasses.*;
// import java.text.SimpleDateFormat;  

public class DAO_Demo {
	public static DAO_Factory daoFactory;
	public static void main(String[] args) {
		try{
			int a=0;
			while(a!=4){
				daoFactory = new DAO_Factory();
				String leftAlignFormat = "| %-28s | %-5d |%n";
				System.out.format("+-------------------------+-------+%n");
				System.out.format("| Welcome to ClickNGo     | Input | %n");
				System.out.format("+-------------------------+-------+%n");
				System.out.format(leftAlignFormat, "\u001B[32mLogin as Customer",1);
				System.out.format(leftAlignFormat, "\u001B[33mLogin as Seller",2);
				System.out.format(leftAlignFormat, "\u001B[34mLogin as DeliveryAgent",3);
				System.out.format(leftAlignFormat, "\u001B[35mExit",4);
				System.out.format("\u001B[37m+-------------------------+-------+%n");
				Scanner sc=new Scanner(System.in);
				try{
					System.out.print("Awaiting Input... ");
					a=sc.nextInt();
				}
				catch(Exception e){
					System.out.println("Invalid Input.");
					break;
				}
				if (a==1)
				{
					int t=0;
					while(t!=3){
						leftAlignFormat = "| %-28s | %-5d |%n";
						System.out.format("+-------------------------+-------+%n");
						System.out.format("| Customer Portal         | Input | %n");
						System.out.format("+-------------------------+-------+%n");
						System.out.format(leftAlignFormat, "\u001B[32mLogin as Customer",1);
						System.out.format(leftAlignFormat, "\u001B[33mRegister new Customer",2);
						System.out.format(leftAlignFormat, "\u001B[34mBack to menu",3);
						System.out.format("\u001B[37m+-------------------------+-------+%n");
						try{
							System.out.print("Awaiting Input... ");
							t=sc.nextInt();
						}
						catch(Exception e){
							System.out.println("Invalid Input.");
						}
						if(t==1){
							System.out.println("Enter CustomerID:");
							int cid;
							try{
								cid=sc.nextInt();
							}
							catch(Exception e){
								System.out.println("Invalid Input.");
								break;
							}
							Customer cust=usecase_checkcustomer(cid);
							if(cust==null){
								System.out.println("Sorry, Customer deos not Exist!");
							}
							else{
								int s=0;
								while(s!=3){
									String name=cust.getCustomerName();
									leftAlignFormat = "| %-28s | %-5d |%n";
									System.out.format("+-------------------------+-------+%n");
									System.out.format("| Welcome "+name+",      | Input | %n");
									System.out.format("+-------------------------+-------+%n");
									System.out.format(leftAlignFormat, "\u001B[32mOrders",1);
									System.out.format(leftAlignFormat, "\u001B[33mPlace an order",2);
									System.out.format(leftAlignFormat, "\u001B[34mLogout",3);
									System.out.format("\u001B[37m+-------------------------+-------+%n");
									try{
										System.out.print("Awaiting Input... ");
										s=sc.nextInt();
									}
									catch(Exception e){
										System.out.println("Invalid Input.");
										break;
									}
									if(s==1){
										ArrayList<Triplet> orders=new ArrayList<>();
										orders=usecase_printAllOrders(cust);
										if (orders.size()>0){
											leftAlignFormat = "|%-10d | %-17s | %-9d |%-11tD |%-11s |%-9tD |%n";
											System.out.format("+-----------+-------------------+-----------+------------+------------+----------+%n");
											System.out.format("| OrderID   | ProductName       | Quantity  | Placed On  | Status     | DueDate  | %n");
											System.out.format("+-----------+-------------------+-----------+------------+------------+----------+%n");
											for (int i=0;i <orders.size();i++){
												Order o = orders.get(i).getO();
												Shipping sp = orders.get(i).getS();
												Product p= orders.get(i).getP();
												System.out.format(leftAlignFormat,o.getOrderID(),p.getProductName(),o.getQuantity(),o.getDateOfOrder(),o.getStatus(),sp.getDueDate());
											}
											System.out.format("+-----------+-------------------+-----------+------------+------------+----------+%n");
										}
										else{
											System.out.println("There are no orders to show.");
										}
									}
									if(s==2){
										ArrayList<Category> cats=usecase_printCategories();
										if(cats.size()>0){
											leftAlignFormat = "| %-23s | %-5d |%n";
											System.out.format("+-------------------------+-------+%n");
											System.out.format("| Categories              | ID    | %n");
											System.out.format("+-------------------------+-------+%n");
											for (int i=0;i<cats.size();i++){
												Category c=cats.get(i);
												System.out.format(leftAlignFormat, c.getCategoryName(),c.getCategoryID());
											}
											System.out.format("+-------------------------+-------+%n");
											System.out.println("Choose a Category..");
											int c=0;
											try{
												System.out.print("Awaiting Input... ");
												c=sc.nextInt();
											}
											catch(Exception e){
												System.out.println("Invalid Input.");
												break;
											}
											Category cat=usecase_getCategory(c);
											ArrayList<Product> prod=usecase_getProucts(cat);
											if(prod.size()>0){
												leftAlignFormat = "|%-10d | %-17s | %-9d |%-11d |%-11d |%n";
												System.out.format("+-----------+-------------------+-----------+------------+------------+%n");
												System.out.format("|ProductID  | ProductName       | Price     | Quantity   | SellerID   |%n");
												System.out.format("+-----------+-------------------+-----------+------------+------------+%n");
												for(int i=0;i<prod.size();i++){
													Product p=prod.get(i);
													System.out.format(leftAlignFormat,p.getProductID(),p.getProductName(),p.getPrice(),p.getQuantity(),p.getSellerID());
												}
												System.out.format("+-----------+-------------------+-----------+------------+------------+%n");
												System.out.println("Choose a product (ID)");
												int pp;
												try{
													System.out.print("Awaiting Input... ");
													pp=sc.nextInt();
												}
												catch(Exception e){
													System.out.println("Invalid Input.");
													break;
												}
												Product pro=usecase_getProduct(pp,cat);
												if(pro==null){
													System.out.println("Product does not exist.");
													break;
												}
												int q=pro.getQuantity();
												System.out.println("How much do you want to buy?");
												int qq;
												try{
													System.out.print("Awaiting Input... ");
													qq=sc.nextInt();
												}
												catch(Exception e){
													System.out.println("Invalid Input.");
													break;
												}
												if(qq > q){
													System.out.println("Please reduce the quantity!!!");
												}
												else if (qq == 0){
													System.out.println("Please enter a non-zero quantity");
												}
												else{
													pro.setQuantity(qq);
													String mod="";
													System.out.println("How would you like to pay? (MOD)");
													try{
														System.out.print("Awaiting Input... ");
														mod=sc.next();
													}
													catch(Exception e){
														System.out.println("Invalid Input.");
														break;
													}
													DeliveryAgent dev=null;
													dev=usecase_placeorder(pro, cust, mod);
													System.out.println("Order sucessfully placed!!");
													System.out.println("---------------------------");
													System.out.println("Order Summary");
													leftAlignFormat = "|%-10d | %-17s | %-9d |%-11d |%-11d |%-10s|%n";
													System.out.format("+-----------+-------------------+-----------+------------+------------+----------+%n");
													System.out.format("|ProductID  | ProductName       | Agent     | Quantity   | SellerID   |Agent Name|%n");
													System.out.format("+-----------+-------------------+-----------+------------+------------+----------+%n");
													System.out.format(leftAlignFormat,pro.getProductID(),pro.getProductName(),dev.getAgentID(),pro.getQuantity(),pro.getSellerID(),dev.getAgentName());
													System.out.format("+-----------+-------------------+-----------+------------+------------+----------+%n");

												}

											}
											else{
												System.out.println("There are no products to show.");
											}
										}
										else{
											System.out.println("No categories to show.");
										}
									}
									if(s==3){
										System.out.println("Bye!");
										break;
									}
								}
							}
						}
						if(t==2){
							int cid=0,contact=0;
							Customer cust=new Customer();
							String name="",email="",address="";
							try{
								cid=usecase_getCustomerID();
								System.out.println("The Customer ID is "+cid);
								System.out.println("Enter your name:");
								name=sc.next();
								System.out.print("Enter your Address:");
								address=sc.next();
								System.out.println("Enter your Contact:");
								contact=sc.nextInt();
								System.out.println("Enter your Email:");
								email=sc.next();
							}
							catch(Exception e){
								System.out.println("Invalid Input.");
								break;
							}
							cust.setCustomerID(cid);
							cust.setAddress(address);
							cust.setContact(contact);
							cust.setCustomerName(name);
							cust.setEmail(email);
							usecase_createcustomer(cust);
							System.out.println("New Customer Registered!!!");
						}
						if(t==3){
							break;
						}
					}
				}
				if (a==2)
				{
					int x=0;
					while(x!=3){
						leftAlignFormat = "| %-28s | %-5d |%n";
						System.out.format("+-------------------------+-------+%n");
						System.out.format("| Seller Portal           | Input | %n");
						System.out.format("+-------------------------+-------+%n");
						System.out.format(leftAlignFormat, "\u001B[32mLogin as Seller",1);
						System.out.format(leftAlignFormat, "\u001B[33mRegister new Seller",2);
						System.out.format(leftAlignFormat, "\u001B[34mBack to menu",3);
						System.out.format("\u001B[37m+-------------------------+-------+%n");
						try{
							System.out.print("Awaiting Input... ");
							x=sc.nextInt();
						}
						catch(Exception e){
							System.out.println("Invalid Input.");
						}
						if(x==1){
							System.out.println("Enter SellerID:");
							int sid;
							try{
								sid=sc.nextInt();
							}
							catch(Exception e){
								System.out.println("Invalid Input.");
								break;
							}
							Seller sell=usecase_checkseller(sid);
							if(sell==null){
								System.out.println("Sorry, Seller does not Exist!");
							}
							else{
								int s=0;
								while(s!=3){
									String name=sell.getSellerName();
									leftAlignFormat = "| %-28s | %-5d |%n";
									System.out.format("+-------------------------+-------+%n");
									System.out.format("| Welcome "+name+",       | Input | %n");
									System.out.format("+-------------------------+-------+%n");
									System.out.format(leftAlignFormat, "\u001B[32mPending Orders",1);
									System.out.format(leftAlignFormat, "\u001B[33mTotal Revenue",2);
									System.out.format(leftAlignFormat, "\u001B[34mLogout",3);
									System.out.format("\u001B[37m+-------------------------+-------+%n");
									try{
										System.out.print("Awaiting Input... ");
										s=sc.nextInt();
									}
									catch(Exception e){
										System.out.println("Invalid Input.");
										break;
									}
									if(s==1){
										ArrayList<Triplet> pending=new ArrayList<>();;
										pending=usecase_mypendingorders(sell);
										if (pending.size()>0){
											leftAlignFormat = "|%-10d | %-17s | %-9d |%-11tD |%-11s |%-9tD |%n";
											System.out.format("+-----------+-------------------+-----------+------------+------------+----------+%n");
											System.out.format("| OrderID   | ProductName       | Quantity  | Placed On  | Status     | DueDate  | %n");
											System.out.format("+-----------+-------------------+-----------+------------+------------+----------+%n");
											for (int i=0;i <pending.size();i++){
												Order o = pending.get(i).getO();
												Shipping sp = pending.get(i).getS();
												Product p= pending.get(i).getP();
												System.out.format(leftAlignFormat,o.getOrderID(),p.getProductName(),o.getQuantity(),o.getDateOfOrder(),o.getStatus(),sp.getDueDate());
											}
											System.out.format("+-----------+-------------------+-----------+------------+------------+----------+%n");
										}
										else{
											System.out.println("There are no orders to show.");
										}
									}
									if(s==2){
										System.out.println("Enter start date (yyyy-mm-dd): ");
    									String sDate1=sc.next();  	
										int revenue= usecase_sellinghistory(sell, sDate1);
										leftAlignFormat = "| %-9s | %-10s | %-7d |%n";
										System.out.format("+-----------+------------+---------+%n");
										System.out.format("| Seller    | Start Date | Revenue |%n");
										System.out.format("+-----------+------------+---------+%n");
										System.out.format(leftAlignFormat, sell.getSellerName(),sDate1,revenue);										
										System.out.format("+-----------+------------+---------+%n");
									}
									if(s==3){
										break;
									}
								}
							}
						}
						if(x==2){
							int sid=0;
							Seller sell=new Seller();
							String name="",address="";
							try{
								sid=usecase_getSellerID();
								System.out.print("Enter SellerID:");
								// sid=sc.nextInt();
								System.out.print("Enter your name:");
								name=sc.next();
								System.out.print("Enter your location:");
								address=sc.next();
							}
							catch(Exception e){
								System.out.println("Invalid Input.");
								break;
							}
							sell.setSellerID(sid);
							sell.setSellerName(name);
							sell.setLocation(address);
							usecase_createseller(sell);
							System.out.println("New Seller Registered!!!");
						}
						if(x==3){
							break;
						}
						else{
							System.out.println("Invalid Input.");
						}
					}
				}
				if (a==3)
				{
					int tt=0;
					while(tt!=3){
						leftAlignFormat = "| %-28s | %-5d |%n";
						System.out.format("+-------------------------+-------+%n");
						System.out.format("| DeliveryAgent Portal    | Input | %n");
						System.out.format("+-------------------------+-------+%n");
						System.out.format(leftAlignFormat, "\u001B[32mLogin as Agent",1);
						System.out.format(leftAlignFormat, "\u001B[33mRegister new Agent",2);
						System.out.format(leftAlignFormat, "\u001B[34mBack to menu",3);
						System.out.format("\u001B[37m+-------------------------+-------+%n");
						try{
							System.out.print("Awaiting Input... ");
							tt=sc.nextInt();
						}
						catch(Exception e){
							System.out.println("Invalid Input.");
							break;
						}
						if(tt==1){
							System.out.println("Enter AgentID:");
							int aid;
							try{
								aid=sc.nextInt();
							}
							catch(Exception e){
								System.out.println("Invalid Input.");
								break;
							}
							DeliveryAgent deli=usecase_checkagent(aid);
							if(deli==null){
								System.out.println("Sorry, Agent deos not Exist!");
							}
							else{
								int s=0;
								while(s!=3){
									String name=deli.getAgentName();
									leftAlignFormat = "| %-28s | %-5d |%n";
									System.out.format("+-------------------------+-------+%n");
									System.out.format("| Welcome "+name+",         | Input | %n");
									System.out.format("+-------------------------+-------+%n");
									System.out.format(leftAlignFormat, "\u001B[32mMy Deliveries",1);
									System.out.format(leftAlignFormat, "\u001B[33mUpdate Status",2);
									System.out.format(leftAlignFormat, "\u001B[34mLogout",3);
									System.out.format("\u001B[37m+-------------------------+-------+%n");
									try{
										System.out.print("Awaiting Input... ");
										s=sc.nextInt();
									}
									catch(Exception e){
										System.out.println("Invalid Input.");
										break;
									}
									if(s==1){
										ArrayList <Shipping> ship= new ArrayList<>();
										ship=usecase_mydeliveries(deli);
										if (ship.size()>0){
											leftAlignFormat = "|%-10d | %-17s | %-9tD |%-11s |%-13s |%n";
											System.out.format("+-----------+-------------------+-----------+------------+--------------+%n");
											System.out.format("| OrderID   |Payment Mode       | DueDate   | Status     | Address      | %n");
											System.out.format("+-----------+-------------------+-----------+------------+--------------+%n");
											for (int i=0;i <ship.size();i++){
												Shipping sp= ship.get(i);
												System.out.format(leftAlignFormat,sp.getOrderID(),sp.getModeOfPayment(),sp.getDueDate(),sp.getStatus(),sp.getAddress());
											}
											System.out.format("+-----------+-------------------+-----------+------------+--------------+%n");
										}
										else{
											System.out.println("There are no orders to show.");
										}
										
									}
									if(s==2){
										System.out.println("Enter OrderID :");
										int oid=0;
										String stat="";
										try{
											oid=sc.nextInt();
										}
										catch (Exception e){
											System.out.println("Invalid Input.");
											break;
										}
										Order order= usecase_getOrder(oid,deli);
										if(order==null)
										{
											System.out.println("Order does not exist");
										}
										System.out.println("Enter new status :");
										try{
											stat=sc.next();
										}
										catch (Exception e){
											System.out.println("Invalid Input.");
											break;
										}
										String str = usecase_updatestatus(order, deli, stat);
										System.out.println(str);
									}
									if(s==3){
										break;
									}
								}
							}
						}
						if(tt==2){
							int aid=0;
							int rating=5;
							DeliveryAgent deli=new DeliveryAgent();
							String name="";
							try{
								aid=usecase_getAgentID();
								System.out.print("The AgentID is "+aid);
								aid=sc.nextInt();
								System.out.print("Enter your name:");
								name=sc.next();
							}
							catch(Exception e){
								System.out.println("Invalid Input.");
								break;
							}
							deli.setAgentID(aid);
							deli.setAgentName(name);
							deli.setRating(rating);
							usecase_createAgent(deli);
							System.out.println("New Agent Registered!!!");
						}
						if(tt==3){
							break;
						}
					}
				}
				if (a==4)
				{
					System.out.println("Bye!");
					break;
				}
			}
		}
		catch(Exception e){
			e.printStackTrace();
		}
	}
	public static ArrayList<Triplet> usecase_printAllOrders(Customer Customer)
	{
		ArrayList<Triplet> trip=null;
		try{
			daoFactory.activateConnection();
			ClicknGO sdao = daoFactory.getStudentDAO();
			trip=sdao.printallorders(Customer);
			daoFactory.deactivateConnection( DAO_Factory.TXN_STATUS.COMMIT );
		}catch(Exception e){	
				daoFactory.deactivateConnection( DAO_Factory.TXN_STATUS.ROLLBACK );
				e.printStackTrace();
		}
		return trip;
	}
	public static ArrayList<Triplet> usecase_mypendingorders(Seller sel)
	{
		ArrayList<Triplet> trip=null;
		try{
			daoFactory.activateConnection();
			ClicknGO sdao = daoFactory.getStudentDAO();
			trip=sdao.pendingorders(sel);
			daoFactory.deactivateConnection( DAO_Factory.TXN_STATUS.COMMIT );
		}catch(Exception e){
				daoFactory.deactivateConnection( DAO_Factory.TXN_STATUS.ROLLBACK );
				e.printStackTrace();
		}
		return trip;
	}
	
	public static int usecase_sellinghistory(Seller seller, String date)
	{
		int value=0;
		try{
			daoFactory.activateConnection();
			ClicknGO sdao = daoFactory.getStudentDAO();
			value=sdao.sellinghistory(seller, date);
			daoFactory.deactivateConnection( DAO_Factory.TXN_STATUS.COMMIT );
		}catch(Exception e){
				daoFactory.deactivateConnection( DAO_Factory.TXN_STATUS.ROLLBACK );
				e.printStackTrace();
		}
		return value;
	}
	public static ArrayList<Category> usecase_printCategories()
	{
		ArrayList<Category> categories=new ArrayList<>();
		try{
			daoFactory.activateConnection();
			ClicknGO sdao = daoFactory.getStudentDAO();
			categories=sdao.printCategories();
			daoFactory.deactivateConnection( DAO_Factory.TXN_STATUS.COMMIT );
		}catch(Exception e){
				daoFactory.deactivateConnection( DAO_Factory.TXN_STATUS.ROLLBACK );
				e.printStackTrace();
		}
		return categories;
	}
	public static Category usecase_getCategory(int CategoryID)
	{
		Category cat=null;
		try{
			daoFactory.activateConnection();
			ClicknGO sdao = daoFactory.getStudentDAO();
			cat=sdao.getCategory(CategoryID);
			daoFactory.deactivateConnection( DAO_Factory.TXN_STATUS.COMMIT );
		}catch(Exception e){
				daoFactory.deactivateConnection( DAO_Factory.TXN_STATUS.ROLLBACK );
				e.printStackTrace();
		}
		return cat;
	}
	public static DeliveryAgent usecase_placeorder(Product pr,Customer cus, String ModeOfPayment)
	{
		DeliveryAgent dev=null;
		try{
			daoFactory.activateConnection();
			ClicknGO sdao = daoFactory.getStudentDAO();
			dev=sdao.placeorder(pr,cus, ModeOfPayment);
			daoFactory.deactivateConnection( DAO_Factory.TXN_STATUS.COMMIT );
		}catch(Exception e){
				daoFactory.deactivateConnection( DAO_Factory.TXN_STATUS.ROLLBACK );
				e.printStackTrace();
		}
		return dev;
	}
	public static ArrayList<Shipping> usecase_mydeliveries(DeliveryAgent deliveryagent)
	{
		ArrayList<Shipping> deliveries=new ArrayList<>();
		try{
			daoFactory.activateConnection();
			ClicknGO sdao = daoFactory.getStudentDAO();
			deliveries=sdao.mydeliveries(deliveryagent);
			daoFactory.deactivateConnection( DAO_Factory.TXN_STATUS.COMMIT );
		}catch(Exception e){
				daoFactory.deactivateConnection( DAO_Factory.TXN_STATUS.ROLLBACK );
				e.printStackTrace();
		}
		return deliveries;
	}
	public static String usecase_updatestatus(Order order, DeliveryAgent agent, String status)
	{
		String str = "";
		try{
			daoFactory.activateConnection();
			ClicknGO sdao = daoFactory.getStudentDAO();
			str = sdao.updatestatus(order, agent, status);
			daoFactory.deactivateConnection( DAO_Factory.TXN_STATUS.COMMIT );
		}catch(Exception e){
				daoFactory.deactivateConnection( DAO_Factory.TXN_STATUS.ROLLBACK );
				e.printStackTrace();
		}
		return str;
	}
	public static Order usecase_getOrder(int OrderID,DeliveryAgent agent)
	{
		Order o=null;
		try{
			daoFactory.activateConnection();
			ClicknGO sdao = daoFactory.getStudentDAO();
			o=sdao.getOrder(OrderID,agent);
			daoFactory.deactivateConnection( DAO_Factory.TXN_STATUS.COMMIT );
		}catch(Exception e){
				daoFactory.deactivateConnection( DAO_Factory.TXN_STATUS.ROLLBACK );
				e.printStackTrace();
		}
		return o;
	}
	public static Customer usecase_checkcustomer(int CustomerID)
	{
		Customer cus=null;
		try{
			daoFactory.activateConnection();
			ClicknGO sdao = daoFactory.getStudentDAO();
			cus=sdao.CheckCustomer(CustomerID);
			daoFactory.deactivateConnection( DAO_Factory.TXN_STATUS.COMMIT );
		}catch(Exception e){
				daoFactory.deactivateConnection( DAO_Factory.TXN_STATUS.ROLLBACK );
				e.printStackTrace();
		}
		return cus;
	}
	public static void usecase_createcustomer(Customer Customer)
	{
		try{
			daoFactory.activateConnection();
			ClicknGO sdao = daoFactory.getStudentDAO();
			sdao.CreateCustomer(Customer);
			daoFactory.deactivateConnection( DAO_Factory.TXN_STATUS.COMMIT );
		}catch(Exception e){
				daoFactory.deactivateConnection( DAO_Factory.TXN_STATUS.ROLLBACK );
				e.printStackTrace();
		}
	}
	public static Seller usecase_checkseller(int SellerID)
	{
		Seller sell=null;
		try{
			daoFactory.activateConnection();
			ClicknGO sdao = daoFactory.getStudentDAO();
			sell=sdao.CheckSeller(SellerID);
			daoFactory.deactivateConnection( DAO_Factory.TXN_STATUS.COMMIT );
		}catch(Exception e){
				daoFactory.deactivateConnection( DAO_Factory.TXN_STATUS.ROLLBACK );
				e.printStackTrace();
		}
		return sell;
	}
	public static void usecase_createseller(Seller seller)
	{
		try{
			daoFactory.activateConnection();
			ClicknGO sdao = daoFactory.getStudentDAO();
			sdao.CreateSeller(seller);
			daoFactory.deactivateConnection( DAO_Factory.TXN_STATUS.COMMIT );
		}catch(Exception e){
				daoFactory.deactivateConnection( DAO_Factory.TXN_STATUS.ROLLBACK );
				e.printStackTrace();
		}
	}
	public static DeliveryAgent usecase_checkagent(int AgentID)
	{
		DeliveryAgent deli=null;
		try{
			daoFactory.activateConnection();
			ClicknGO sdao = daoFactory.getStudentDAO();
			deli=sdao.CheckDeliveryAgent(AgentID);
			daoFactory.deactivateConnection( DAO_Factory.TXN_STATUS.COMMIT );
		}catch(Exception e){
				daoFactory.deactivateConnection( DAO_Factory.TXN_STATUS.ROLLBACK );
				e.printStackTrace();
		}
		return deli;
	}
	public static void usecase_createAgent(DeliveryAgent Agent)
	{
		try{
			daoFactory.activateConnection();
			ClicknGO sdao = daoFactory.getStudentDAO();
			sdao.CreateDeliverAgent(Agent);
			daoFactory.deactivateConnection( DAO_Factory.TXN_STATUS.COMMIT );
		}catch(Exception e){
				daoFactory.deactivateConnection( DAO_Factory.TXN_STATUS.ROLLBACK );
				e.printStackTrace();
		}
	}
	public static ArrayList<Product> usecase_getProucts(Category cat)
	{
		ArrayList<Product> products=new ArrayList<>(); 
		try{
			daoFactory.activateConnection();
			ClicknGO sdao = daoFactory.getStudentDAO();
			products=sdao.printProducts(cat);
			daoFactory.deactivateConnection( DAO_Factory.TXN_STATUS.COMMIT );
		}catch(Exception e){
				daoFactory.deactivateConnection( DAO_Factory.TXN_STATUS.ROLLBACK );
				e.printStackTrace();
		}
		return products;
	}
	public static Product usecase_getProduct(int ProductID,Category cat)
	{
		Product product=null; 
		try{
			daoFactory.activateConnection();
			ClicknGO sdao = daoFactory.getStudentDAO();
			product=sdao.getProduct(ProductID,cat);
			daoFactory.deactivateConnection( DAO_Factory.TXN_STATUS.COMMIT );
		}catch(Exception e){
				daoFactory.deactivateConnection( DAO_Factory.TXN_STATUS.ROLLBACK );
				e.printStackTrace();
		}
		return product;
	}
	public static int usecase_getCustomerID()
	{
		int CustomerID=0;
		try{
			daoFactory.activateConnection();
			ClicknGO sdao = daoFactory.getStudentDAO();
			CustomerID=sdao.getCustomerID();
			daoFactory.deactivateConnection( DAO_Factory.TXN_STATUS.COMMIT );
		}catch(Exception e){
				daoFactory.deactivateConnection( DAO_Factory.TXN_STATUS.ROLLBACK );
				e.printStackTrace();
		}
		return CustomerID;
	}
	public static int usecase_getSellerID()
	{
		int SellerID=0;
		try{
			daoFactory.activateConnection();
			ClicknGO sdao = daoFactory.getStudentDAO();
			SellerID=sdao.getSellerID();
			daoFactory.deactivateConnection( DAO_Factory.TXN_STATUS.COMMIT );
		}catch(Exception e){
				daoFactory.deactivateConnection( DAO_Factory.TXN_STATUS.ROLLBACK );
				e.printStackTrace();
		}
		return SellerID;
	}
	public static int usecase_getAgentID()
	{
		int AgentID=0;
		try{
			daoFactory.activateConnection();
			ClicknGO sdao = daoFactory.getStudentDAO();
			AgentID=sdao.getAgentID();
			daoFactory.deactivateConnection( DAO_Factory.TXN_STATUS.COMMIT );
		}catch(Exception e){
				daoFactory.deactivateConnection( DAO_Factory.TXN_STATUS.ROLLBACK );
				e.printStackTrace();
		}
		return AgentID;
	}
}
