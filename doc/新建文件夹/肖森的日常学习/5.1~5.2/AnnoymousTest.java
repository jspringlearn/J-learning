package fanxing_;

import fanxing_.Foo;


public class AnnoymousTest implements Foo{


    public void test(Object o) {
    System.out.println("chongxie fangfa ");

}
    public static void main(String[] args) {
        Foo<String> f=new Foo<String>() {
            @Override
            public void test(String s) {
                System.out.println("test方法的参数为：");
            }
        };
    }


    Foo<?>fo = new Foo<Object>() {
        @Override
        public void test(Object o) {
            System.out.println("重写内部类的");
        }
    };

}
