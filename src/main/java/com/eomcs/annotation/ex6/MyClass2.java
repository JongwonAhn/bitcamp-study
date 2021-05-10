// 애노테이션 프로퍼티 타입
package com.eomcs.annotation.ex6;

// @MyAnnotation은 필드 에만 붙일 수 있다.
//@MyAnnotation2 // OK!
public class MyClass2 {

  @MyAnnotation2 int i; 
  @MyAnnotation2 static int i2; 

  //    @MyAnnotation2
  public void m() {} 

  //  @MyAnnotation int a; //오류
}
