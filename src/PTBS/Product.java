package PTBS;

import java.io.File;
import java.util.ArrayList;

public class Product {
    public Product ProductName;
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
