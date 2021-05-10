// SqlSession 사용법 - 결과가 한개일때 -> selectOne();
package com.eomcs.mybatis.ex02.f;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import com.eomcs.mybatis.vo.Board;


public class Exam1111 {

  public static void main(String[] args) throws Exception {


    SqlSession sqlSession = new SqlSessionFactoryBuilder().build(Resources.getResourceAsStream(//
        "com/eomcs/mybatis/ex02/f/mybatis-config.xml")).openSession();

    Board b = sqlSession.selectOne("BoardMapper.selectBoard1");

    //컬럼명과 자바 객체의 프로퍼티 명이 일치한다면 다음과 같이 정상적으로 데이터를 꺼내올수 있다.
    System.out.printf("%d,%s,%s,%s,%d\n",
        b.getNo(),
        b.getTitle(),
        b.getContent(),
        b.getRegisteredDate(),
        b.getViewCount());

    sqlSession.close();
  }

}


