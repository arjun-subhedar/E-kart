create table Products(
    ProductID smallint UNIQUE NOT NULL,
    ProductName varchar(30) NOT NULL,
    CategoryID smallint NOT NULL,
    Price smallint NOT NULL,
    Quantity smallint,
    SellerID smallint NOT NULL,
    constraint pk_ProductID PRIMARY KEY (ProductID)
);

create table Orders(
    OrderID smallint UNIQUE NOT NULL AUTO_INCREMENT,
    CustomerID smallint NOT NULL,
    ProductID smallint NOT NULL,
    Quantity smallint,
    SellerID smallint NOT NULL,
    DateOfOrder date,
    CurrentStatus varchar(30),
    constraint pk_OrderID PRIMARY KEY (OrderID)
);

create table Customers(
    CustomerID smallint UNIQUE NOT NULL,
    CustomerName varchar(30) NOT NULL,
    Address varchar(30),
    ContactNum smallint,
    email varchar(30),
    constraint pk_CustomerID PRIMARY KEY (CustomerID)
);

create table Categories(
    CategoryID smallint UNIQUE NOT NULL,
    CategoryName varchar(30),
    constraint pk_CategoryID PRIMARY KEY (CategoryID)
);

create table Sellers(
    SellerID smallint UNIQUE NOT NULL,
    SellerName varchar(30),
    Location varchar(30),
    constraint pk_SellerID PRIMARY KEY (SellerID)
);

create table Shipping(
    ShippingID smallint UNIQUE NOT NULL AUTO_INCREMENT,
    OrderID smallint NOT NULL,
    AgentID smallint NOT NULL,
    ModeOfPayment varchar(30),
    DueDate date,
    Status varchar(20),
    Address varchar(20),
    constraint pk_ShippingID PRIMARY KEY (ShippingID)
);

create table DeliveryAgents(
    AgentID smallint UNIQUE NOT NULL,
    AgentName varchar(30),
    Rating smallint,
    constraint pk_AgentID PRIMARY KEY (AgentID)
);
