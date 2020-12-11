package sample;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;

public class Number {
    IntegerProperty myNum = new SimpleIntegerProperty();

    public int getMyNum() {
        return myNum.get();
    }

    public IntegerProperty myNumProperty() {
        return myNum;
    }

    public void setMyNum(int myNum) {
        this.myNum.set(myNum);
    }
}
