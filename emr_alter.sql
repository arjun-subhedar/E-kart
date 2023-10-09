alter table Products
    add constraint fk_CategoryID1 FOREIGN KEY (CategoryID) REFERENCES Categories(CategoryID);

alter table Products
    add constraint fk_SellerID1 FOREIGN KEY (SellerID) REFERENCES Sellers(SellerID);

alter table Orders
    add constraint fk_CustomerID1 FOREIGN KEY (CustomerID) REFERENCES Customers(CustomerID);

alter table Orders
    add constraint fk_ProductID1 FOREIGN KEY (ProductID) REFERENCES Products(ProductID);

alter table Orders
    add constraint fk_SellerID2 FOREIGN KEY (SellerID) REFERENCES Sellers(SellerID);

alter table Shipping
    add constraint fk_OrderID1 FOREIGN KEY (OrderID) REFERENCES Orders(OrderID);

alter table Shipping
    add constraint fk_AgentID1 FOREIGN KEY (AgentID) REFERENCES DeliveryAgents(AgentID);