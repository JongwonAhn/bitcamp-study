// 애노테이션 중복 사용 - 중복해서 사용할 애노테이션을 지정한다.
package com.eomcs.annotation.ex7;

//애노테이션을 중복해서 사용할 수 있게 하려면
// @Repeatable 로 표시해 줘야 한다.
// 이때 반복에 대한 정보를 따로 정의한 애노테이션을 지정해야 한다.

public @interface Employees {
  Employee[] value();
}


