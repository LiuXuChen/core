package com.jetco.core.structural.flyweight;

/**
 * <p>
 * String中intern()方法享元模式运用
 * </p>
 *
 * @author lhw
 * @version 1.0
 * @since 2021-04-19
 */
public class StringTest {

    public static void main(String[] args) {
        String s1 = "abc";
        String s2 = "abc";
        String s3 = new String("abc");
        String s4 = new String("abc");

        // true
        System.out.println(s1 == s2);
        // false
        System.out.println(s1 == s3);
        // false
        System.out.println(s3 == s4);
        // true
        System.out.println(s3.intern() == s2);
        // true`
        System.out.println(s3.intern() == s4.intern());

    }

}
