package fanxing_;

import java.util.ArrayList;
import java.util.List;

public class Order<T> {
    private String ordername;
    private int orderId;
    private T t;
    List<T> list=new ArrayList<>();
    public void add(){
        list.add(t);
    }

    public String getOrdername() {
        return ordername;
    }

    public void setOrdername(String ordername) {
        this.ordername = ordername;
    }

    public int getOrderId() {
        return orderId;
    }

    public void setOrderId(int orderId) {
        this.orderId = orderId;
    }



    public T getT() {
        return t;
    }

    public void setT(T t) {
        this.t = t;
    }


}
