package com.stephanie.stockalerts.model;
import jakarta.persistence.*; //JPA(Java Persistence API): For managinng relational data through object-relational mapping (ORM). 

@Entity //Tells to MySQL to create a table for the following class
@Table(name = "stocks")
public class Stock {
    @Id //Primary Key
    @GeneratedValue(strategy =  GenerationType.IDENTITY) //Generates new ID numbers in each data in MySQL
    private Long id;

    private String symbol; //symbol will be the stock market ids/stock ticker symbols
    private Double currentPrice; //current price of the stock
    private Double alertThreshold; //The user's safety limit.
    
    public Stock(){}
    public Stock(String symbol, Double threshold){
        this.symbol = symbol;
        this.alertThreshold = threshold;
    }

    //Getters 
    public Long getId(){
        return id; 
    }
    public String getSymbol(){
        return symbol;
    }
    public Double getAlertThreshold(){
        return alertThreshold;
    }
    public Double getCurrentPrice(){
        return currentPrice;
    }

    //Setters
    public void setSymbol(String s){
       this.symbol = s;
    }
    public void setAlertThreshold(Double t){
        this.alertThreshold = t;
    }
    public void setCurrentPrice(Double price){
        this.currentPrice= price;
    }
}
