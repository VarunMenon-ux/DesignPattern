package PTBS;

import java.util.Iterator;

abstract public class Person {
    private ClassProductList productList;
    ProductMenu theProductMenu;
    int type = 0;
    String UserName;
    Product currentProduct;
    Trading currentTrading;

    /**
     *
     */
    public void showAddButton() {
        theProductMenu.ShowAddButton();

    }

    /**
     *
     */
    public void showViewButton() {
        theProductMenu.ShowViewButton();

    }

    /**
     *
     */
    public void showRadioButton() {
        theProductMenu.ShowRadioButton();

    }

    /**
     *
     */
    public void showLabels() {
        theProductMenu.ShowLabels();

    }

    public boolean showMenu(){
        Iterator<Trading> iter = product.tradinglist.iterator();
        theProductMenu.product = currentProduct;
        Trading trading;
        while (iter.hasNext()){
            trading = (Trading) iter.next();
            theProductMenu.
        }
        return false;
    }

    public ClassProductList getProductList(){
        return productList;
    }


}
