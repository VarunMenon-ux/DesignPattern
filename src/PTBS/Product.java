package PTBS;

import java.util.ArrayList;

public class Product {
    String productName;
    int prodNum;
    int prodType;
    public ArrayList<Trading> tradinglist = new ArrayList<Trading>();

    public Product(int prodType, String strProd){
        this.productName = strProd;
        this.prodNum = 0;
        this.prodType = prodType;
    }

    public void addTrading(Trading newTrade){
        tradinglist.add(newTrade);

    }
    public String toString(){
        return productName;
    }

}
