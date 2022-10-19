package PTBS;
import PTBS.UserInfoItem;

public class Facade {

    private int UserType;

    private Product theSelectedProduct;

    private int nProductCategory;

    private ClassProductList theProductList;

    private Person thePerson;

    private tradingMenu tradingmenu;

    public boolean login(UserInfoItem userinfoitem) {

        login user = new login();
        login.setModal(true);
        login.setVisible(true);
        userinfoitem.strUserName = login.getUserName();
        userinfoitem.strPassword = login.getPassword();
        userinfoitem.UserType = login.getUserType();
        return user.isExit();
    }

    public void addTrading(Trade trade) {
        tradingMenu tradingmenu; //////try making this private var
        if (thePerson.type == 0) {
            tradingmenu = new BuyerTradingMenu();
        }
        else {
            tradingmenu = new SellerTradingMenu();
        }
        Trading trading = new Trading();
        tradingmenu.showMenu(trading,thePerson);
        trade.addTrading(trading);


    }

    public void viewTrading(Trading trading) {
        tradingMenu tradingmenu;
        if (thePerson.type == 0) {
            tradingmenu = new BuyerTradingMenu();
        }
        else {
            tradingmenu = new SellerTradingMenu();
        }
        tradingmenu.showMenu(trading, thePerson)

    }

    /**
     *
     */
    public void viewOffering(Offering offering) {
        OfferingList offeringlist = new OfferingList();
        offeringlist.ShowMenu(offering);

    }

    /**
     *
     */
    public void markOffering() {

    }

    /**need to make iterator
     *
     */
    public void submitOffering(Trading trading,Offering offering) {
        trading.addOffering(offering);

    }

    /**
     *
     */
    public void remind() {
        RemindBox remindbox = new RemindBox();
        remindbox.showRemindBox(thePerson.GetProductList());
    }


    public void createUser(UserInfoItem userinfoitem) {
        if (userinfoitem.UserType == 0){
            thePerson = new Buyer();
        } else if (userinfoitem.UserType == 1) {
            thePerson = new Seller();
        }
        thePerson.UserName = userinfoitem.strUserName;

    }

    /**
     *
     */
    public void createProductList() {
        theProductList = new ClassProductList();
        theProductList.getFromDB("ProductInfo.txt"); //questionable

    }

    /**
     *
     */
    public void AttachProductToUser() {
        List list;
        Read read;

        prodlist = new ProdList("UserProduct.txt");
        read = new Read(list);
        String strUserName;
        String strProductName;
        String user;
        while(read.next()){
            user = read.nextInput();
            strProductName = getProductName(user);
            strUserName = getUserName(user);
            if(strUserName.compareTo(thePerson.UserName)==0){
                theSelectedProduct = findProductByName(strProductName);
                if (theSelectedProduct != null){
                    thePerson.addProduct(theSelectedProduct)
                }
            }
        }


    }

    public Product selectProduct() {
        return null;
    }

    /**
     *
     */
    public void productOperation() {

    }

    private String getUserName(String usr){
        int idx = usr.lastIndexOf(':');
        return usr.substring(0, idx);
    }
    private String getProductName(String prod){
        int idx = prod.lastIndexOf(':');
        return prod.substring(idx+1,prod.length());
    }

    private Product findProductByName(String strProdName){
        ProductIterator iterator = new ProductIterator(theProductList);
        return (Product) iterator.next(strProdName);
    }

}