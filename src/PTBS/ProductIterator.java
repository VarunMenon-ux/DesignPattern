package PTBS;

import java.util.Iterator;

public class ProductIterator implements Iterator<Product> {
    ClassProductList productlist;
    int currentNum = -1;

    public ProductIterator(ClassProductList productlist) {
    }
    public boolean hasNext() {
        if (currentNum >= productlist.size()-1)
            return false;
        else
            return true;
    }
    public Product next() {
        if(hasNext()){
            currentNum+=1;
            return productlist.get(currentNum);
        }
        else{
            return null;
        }
    }

    public void remove(){
        if(currentNum == -1)
            currentNum += 1;
        productlist.remove(currentNum);
    }
    public void MoveToHead() {

    }
    public void Remove() {

    }

    public Product next(String strProdName) {
        return null;
    }
}
