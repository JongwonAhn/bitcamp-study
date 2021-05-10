// 애노테이션 중복 사용
package com.eomcs.annotation.ex7;

// @@Employee은 애노테잉션에 @Employee를 반복하였다.
// 
@Employee("홍길동")
@Employee("임꺽정")// 중복 사용 불가!
public class MyClass2 {

  @Employee("홍길동")
  @Employee("임꺽정")// 중복 사용 불가!  
  public void m(int p) {}

  @Employee("홍길동")
  @Employee("임꺽정") // 중복 사용 불가!
  public void m2(int p) {}
}
