package PTBS;

import java.io.File;
import java.util.ArrayList;
import java.util.Scanner;

public class ClassProductList extends ArrayList<Product> {
    void getFromDB(String filename){
        Scanner read;
        String strProductName = null;
        File list = new File(filename);
        read = new Scanner(list);
        while(read.hasNextLine()){
            strFilename = read.nextLine();
            Product product;
            product = new Product(strFilename, 0);
            add(product);

        }
        read.close();
    }

    Product FindProductByName(String Prod){
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
