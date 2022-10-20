package PTBS;

public class Buyer extends Person{
    @Override
    public boolean showMenu() {
        super.showMenu();
        showViewButton();
        showRadioButton();

    }

    public ProductMenu createProductMenu(int type, Product product){
        if (type == 0){
            theProductMenu = new MeatProductMenu();
        }
        else{
            theProductMenu = new ProduceProductMenu();
        }
        return theProductMenu;
    }

}
