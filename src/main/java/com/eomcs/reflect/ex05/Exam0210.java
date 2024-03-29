// 일반 타입과 배열 타입
package com.eomcs.reflect.ex05;

import java.sql.Date;
import java.util.ArrayList;

//reflection API - 배열 항목의 타입 알아내기
public class Exam0210{

  public static void main(String[] args) throws Exception {
    System.out.println(byte.class.getName()); // byte타입
    System.out.println(byte[].class.getName()); //byte배열 타입
    System.out.println("------------------------------------");

    System.out.println(short.class.getName());
    System.out.println(short[].class.getName());
    System.out.println("------------------------------------");

    System.out.println(int.class.getName());
    System.out.println(int[].class.getName());
    System.out.println("------------------------------------");

    System.out.println(long.class.getName());
    System.out.println(long[].class.getName());
    System.out.println("------------------------------------");

    System.out.println(float.class.getName());
    System.out.println(float[].class.getName());
    System.out.println("------------------------------------");

    System.out.println(double.class.getName());
    System.out.println(double[].class.getName());
    System.out.println("------------------------------------");

    System.out.println(boolean.class.getName());
    System.out.println(boolean[].class.getName());
    System.out.println("------------------------------------");

    System.out.println(char.class.getName());
    System.out.println(char[].class.getName());
    System.out.println("------------------------------------");

    System.out.println(String.class.getName());
    System.out.println(String[].class.getName());
    System.out.println("------------------------------------");

    System.out.println(Date.class.getName());
    System.out.println(Date[].class.getName());
    System.out.println("------------------------------------");

    System.out.println(ArrayList.class.getName());
    System.out.println(ArrayList[].class.getName());
    System.out.println("------------------------------------");




  }

}





