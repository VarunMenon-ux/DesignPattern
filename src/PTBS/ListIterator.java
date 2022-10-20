package PTBS;

import java.util.ArrayList;
import java.util.Iterator;

public class ListIterator implements Iterator<Object> {
    ArrayList<Object> list;
    int currentIter = -1;

    public boolean hasNext(){
        if (currentIter >= list.size()-1) {
            return false;
        }
        else{
            return true;
        }
    }

    public Object next(){
        if(hasNext() == true){
            currentIter+=1;
            return list.get(currentIter);
        }
        else{
            return null;
        }
    }

    public void remove(){
        list.remove(currentIter);
    }

    public void moveToHead(){

    }


}
