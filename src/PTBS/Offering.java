package PTBS;

import java.util.Date;

public class Offering {
    Date offeringDate = new Date();
    String offerer;
    int offerPrice;

    public String toString(){
        String string;
        string = offerer + " " + offerPrice;
        return string;
    }
    int getOfferPrice(){
        return offerPrice;
    }

}
