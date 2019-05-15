package java_gather;

import java.util.*;

public class CollectionTest
{
    public static void main(String[] args) {
        Collection c=new ArrayList();
//        c.add("孙悟空");
//        c.add(6);
//
//        c.remove(6);
//        //c.containsAll(c);
//        Collection books=new HashSet();
//        books.add("轻量级开发JAVA");
//        books.add("java讲义");
//        books.add("aaaa");
//        //System.out.println(books);
//        //集合的遍历操作
////        books.forEach(
////                obj-> System.out.println(obj)
////        );
//
//
////        Iterator it=books.iterator();
////        while(it.hasNext())
////        {
////            String book=(String)it.next();
////            System.out.println(book);
////        }
//        IteraAtor it=books.iterator();
//        it.forEachRemaining(obj-> System.out.println(obj));
//
        HashSet hs=new HashSet();
        Set ts=new TreeSet();
        ts.add("2");
        ts.add("1");
        ts.add("4");
        ts.add("3");
        ts.forEach(o -> System.out.println(o));
//        Iterator it=ts.iterator();
//        while(it.hasNext()){
//
//        }
//        List books=new ArrayList();
//        ArrayList b=new ArrayList();
//        b.add("ldskd");
//        b.add("laaaaa");
//        b.forEach(obj-> System.out.println(obj));
//        for (Object obj:b
//             ) {
//            System.out.println((String)obj);
//
//        }
//            // System.out.println(b);
//        books.add(new String ("轻量级开发"));
//        books.add(new String("疯狂讲义"));
//          HashMap map=new HashMap();
//          map.put("疯狂将以","1");
//          map.put("杀杀杀","22");
//          map.put("das","222");
//        System.out.println(map);
          List list=new ArrayList();





    }
}
