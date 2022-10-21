package PTBS;

import java.io.File;
import java.util.ArrayList;
import java.util.Scanner;

public class ClassProductList extends ArrayList<Product> {
    Product getFromDB(String filename){
        Scanner read;
        try{
            String strProductName = null;
            File list = new File(filename);
            read = new Scanner(list);
            while(read.hasNextLine()) {
                strProductName = read.nextLine();
                Product product;
                product = new Product(strProductName, 0);
                add(product);
            }
            read.close();
        } catch (Exception xy){
    }

    Product FindProductByName(String ProuctName){
        int nProductCount = size();
        for(int i = 0; i<nProductCount; i++){
            Product product;
            product = (Product) get(i);
            if(product.ProductName.compareTo(ProductName) == 0)
                return product;
        }
        return null;
    }


}
