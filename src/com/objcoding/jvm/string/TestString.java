package com.objcoding.jvm.string;

/**
 * @author zhangchenghui.dev@gmail.com
 * @since 2018/9/18
 * JDK: Java 8
 */
public class TestString {

    public static void main(String[] args) {

        String myStr = "aa";
        String h = new String("aa");

        // false
        // new String 只会在堆中创建新对象，不会将字符值缓存到常量池中，即不会检查字符串常量池，也就是 new String 只创建一个对象
        System.out.println(myStr == h);

        // true
        // intern方法将字符缓存到常量池中。并把其引用返回
        System.out.println(myStr == h.intern());

        // true
        // 对比值
        System.out.println(myStr.equals(h));

        String myStr2 = "aa" + "bb"; // 这个要看编译器，编译器最好的结果就是将其优化成了 "aabb"
        String hh = "aabb";

        // true
        // 编译器将 myStr2 的值优化成 "aabb"
        System.out.println(myStr2 == hh);

//
//        String s1 = new String("StringTest");
//        System.out.println(s1.intern() == s1);
//        String s2 = new StringBuilder().append("String").append("Test").toString();
//        System.out.println(s2.intern() == s2);
//        String s3 = new StringBuilder("StringTest").toString();
//        System.out.println(s3.intern() == s3);

    }
}
