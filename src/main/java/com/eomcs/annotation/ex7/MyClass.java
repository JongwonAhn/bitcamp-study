// 애노테이션 중복 사용
package com.eomcs.annotation.ex7;

// @MyAnnotation은 타입(인터페이스와 클래스)에만 붙일 수 있다.
@Company("비트캠프")
//@Company("비트캠프")// 중복 사용 불가!
public class MyClass {

  @Company("비트캠프")
  //  @Company("비트캠프")// 중복 사용 불가!  
  public void m(int p) {}

  @Company("비트캠프")
  //  @Company("비트캠프") // 중복 사용 불가!
  public void m2(int p) {}
}
