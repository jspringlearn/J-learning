package fanxing_;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List <Circle> circleList=new ArrayList<>();
        Canvas c=new Canvas();
        //不可以将List<Cirle>当作 List<Shape>的子类来用。
        c.drawall(circleList);


    }
}
