// 제네릭(Generic) 문법 정리 - 제네릭 파라미터 wildcard(?)
package com.eomcs.generic.ex02;

import java.util.ArrayList;

public class Exam0225 {

  static class A {}
  static class B1 extends A {}
  static class B2 extends A {}
  static class C extends B1 {}
  /*
   *   Object
   *     |
   *     A
   *    / \
   *   B1 B2
   *   |
   *   C
   */

  public static void main(String[] args) {
    // m1(ArrayList<? super B1>)
    // => A 타입 및 그 상위 타입에 대해서 ArrayList 객체를 파라미터로 넘길 수 있다.
    //
    m1(new ArrayList<Object>()); 
    m1(new ArrayList<A>()); 
    m1(new ArrayList<B1>()); 
    //    m1(new ArrayList<B2>()); // 컴파일 오류!
    //    m1(new ArrayList<C>()); // 컴파일 오류! 
  }

  static void m1(ArrayList<? super B1> list) {
    // 파라미터로 받은 ArrayList가 구체적으로 어떤 타입의 값을 다루는 것인지 
    // 결정되지 않았기 때문에 컴파일러는 다음 코드가 옳은지 검사할 수 없다.
    // 그래서 컴파일 오류가 발생한다.
    //    
    //  ? 를 사용하여 정확한 타입을 결정하지 않으
    //  타입이 결정되지 않은 상태에서도 유효한 코드라면 컴파일 해준다.
    // 타입이 결정되지 않아 유효한지 아닌지 결정할 수 없는 상태라면 컴파일 오류이다

    //list.add(new B1()); // 컴파일 오류!
    list.add(new C());

    Object obj1 = list.get(0);
    //    어오는 ArrayList의 항목타입이 B1일수도 있고,
    //     그 상위 일수도 있다. 컴파일오류!
    //    B1 obj2 = list.get(0); 
    //    C obj3 = list.get(0); 
  }
}








