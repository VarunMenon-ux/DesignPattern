package PTBS;

import java.util.Iterator;

public class OfferingIterator implements Iterator<Offering> {
    private OfferingList offeringList;
    int currentOffering = -1;

    /**
     *
     */
    public boolean hasNext() {
        if (currentOffering >= offeringList.size() - 1)
            return false;
        else
            return true;
    }

    /**
     *
     */
    public Offering next() {
        if(hasNext() == true){
            currentOffering+=1;
            return offeringList.get(currentOffering);
        }
        else {
            return null;
        }

    }

    /**
     *
     */
    public void MoveToHead() {

    }

    /**
     *
     */
    public void Remove() {
        currentOffering+=1;
        offeringList.remove(currentOffering);

    }
}
