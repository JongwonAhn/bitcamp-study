// SqlSession 사용법 - Select 실행하기 : 목록출력
package com.eomcs.mybatis.ex02.b;

import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import com.eomcs.mybatis.vo.Board;

public class Exam0110 {

  public static void main(String[] args) throws Exception {


    SqlSession sqlSession = new SqlSessionFactoryBuilder().build(Resources.getResourceAsStream(//
        "com/eomcs/mybatis/ex02/b/mybatis-config.xml")).openSession();

    // selectList()
    // select 문의 결과가 여러개 일때 사용한다.
    // 결과가 없으면 size가 0인 List 객체를 리턴한다.

    List<Board> boards = sqlSession.selectList("BoardMapper.selectBoard");

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


