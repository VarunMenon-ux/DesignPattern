package PTBS;

import java.util.Date;

public class Trading {
    String tradingName;
    Date dueTime = new Date();

    public String timeout(){
       Date date;
       date = new Date();
       if(date.after(this.dueTime)){
           return "Late";
       }
       else{
           return "On time";
       }
    }

    public Offering addOffering(Offering offering) {
        Offering newOffering = new Offering();
        return newOffering;
    }
    public void accept(NodeVisitor visitor) {
        visitor.visitTrading(this);
    }
}