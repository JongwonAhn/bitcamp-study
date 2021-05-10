package com.eomcs.exception.ex93;

import java.util.ArrayList;

public class z {
  public static void main(String[] args) {

    ArrayList<String> arrayList = new ArrayList<>();

    arrayList.add("홍길동");
    arrayList.add("임꺽정");

    try {

      System.out.println(arrayList.get(0)); 
      System.out.println(arrayList.get(1)); 
      System.out.println(arrayList.get(2)); 

    }catch(Exception e) {
      e.getStackTrace();
      System.out.println("해당인덱스x");

      //    }finally {
      //      System.out.println("ddddddddddddddddddddddddddddddddd");
    }


  }

}
