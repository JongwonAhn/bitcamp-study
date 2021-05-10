// 애노테이션 프로퍼티 타입
package com.eomcs.annotation.ex6;

// @MyAnnotatio3은 메서드 에만 붙일 수 있다.
//@MyAnnotation3 // OK!
public class MyClass3 {

  //  @MyAnnotation3 int i; 
  //  @MyAnnotation3 static int i2; 

  @MyAnnotation3
  public void m() {} 

  //    @MyAnnotation3 int a; 
}
