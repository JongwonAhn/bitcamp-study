// Mybatis 설정 파일 - 도메인 클래스의 별명을 설정하는 방법과 사용법
package com.eomcs.mybatis.ex01.d;

import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

public class Exam0110 {

  public static void main(String[] args) throws Exception {


    SqlSession sqlSession = new SqlSessionFactoryBuilder().build(Resources.getResourceAsStream(//
        "com/eomcs/mybatis/ex01/d/mybatis-config.xml")).openSession();

    List<Board> boards = sqlSession.selectList("BoardMapper.selectBoard");

    System.out.println(boards.size());

    sqlSession.close();
  }

}


