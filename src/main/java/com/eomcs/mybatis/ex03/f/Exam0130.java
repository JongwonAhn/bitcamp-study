// #{} 과 ${} 차이점 => ${}의 활용
package com.eomcs.mybatis.ex03.f;

import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import com.eomcs.mybatis.vo.Board;

public class Exam0130 {

  public static void main(String[] args) throws Exception {


    SqlSession sqlSession = new SqlSessionFactoryBuilder().build(Resources.getResourceAsStream(//
        "com/eomcs/mybatis/ex03/f/mybatis-config.xml")).openSession();


    // 정렬 방식을 파라미터로 넘기기
    // => #{} 문법은 오직 값만 삽입할 수 있다.
    // => SQL 코드를 삽입할 수 없다.
    List<Board> boards = sqlSession.selectList("BoardMapper.selectBoard3", "created_date desc, title asc");

    //컬럼명과 자바 객체의 프로퍼티 명이 일치한다면 다음과 같이 정상적으로 데이터를 꺼내올수 있다.
    for(Board b : boards) {
      System.out.printf("%d,%s,%s,%s,%d\n",
          b.getNo(),
          b.getTitle(),
          b.getContent(),
          b.getRegisteredDate(),
          b.getViewCount());
    }

    sqlSession.close();
  }

}


