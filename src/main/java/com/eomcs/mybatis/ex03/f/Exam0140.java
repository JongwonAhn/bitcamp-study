// #{} 과 ${} 차이점 => ${}의 활용
package com.eomcs.mybatis.ex03.f;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

public class Exam0140 {

  public static void main(String[] args) throws Exception {


    SqlSession sqlSession = new SqlSessionFactoryBuilder().build(Resources.getResourceAsStream(//
        "com/eomcs/mybatis/ex03/f/mybatis-config.xml")).openSession();


    // 정렬 방식을 파라미터로 넘기기
    // => #{} 문법은 오직 값만 삽입할 수 있다.
    // => SQL 코드를 삽입할 수 없다.
    int count = sqlSession.selectOne("BoardMapper.countRecords", "x_board");

    //컬럼명과 자바 객체의 프로퍼티 명이 일치한다면 다음과 같이 정상적으로 데이터를 꺼내올수 있다.
    System.out.println(count);

    sqlSession.close();
  }

}


