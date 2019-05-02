package fanxing_;

import sun.awt.SunHints;

import java.beans.IntrospectionException;
import java.util.*;

public class Test {
//
    public static void main(String[] args) {
        /*
        List<Integer> list=new ArrayList();
        list.add(29);
        list.add(21);
        list.add(21);
        list.add(21);
        Iterator it=list.iterator();
        while(it.hasNext())
        {
            Integer book= (Integer) it.next();
            System.out.println(book);
        }
        Iterator its=list.iterator();
        while(its.hasNext())
        {
            Integer ob= (Integer) it.next();
            System.out.println(ob);
        }
        */

        List<String> books=new ArrayList<>();
        books.add("疯狂见她");
        books.add("疯狂");
        books.add("见她");
        Map<String,List<String>> schoolsInfo =new HashMap<>();
        List<String>schools= new ArrayList<>();
        schools.add("上天把");
        schools.add("上");
        schools.add("把");
        schoolsInfo.put("1",schools);
        schoolsInfo.forEach((key,value)-> System.out.println(key+"-->"+value)
        );






    }





}
