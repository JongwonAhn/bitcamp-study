// auto commit - commit
package com.eomcs.mybatis.ex03.d;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import com.eomcs.mybatis.vo.Board;

public class Exam0130 {

  public static void main(String[] args) throws Exception {


    // openSession(auto commit 여부)
    // - true : 데이터 변경 후 즉시 커밋한다.
    // - false : 데이터 변경 후 commit()을 호출할 때 까지
    //   실제 테이블에 변경 사항을 반영하지 않는다.
    //
    //  openSession()
    // - 기본이 수동 커밋이다.
    // - openSession(false) 와 같다.

    SqlSession sqlSession = new SqlSessionFactoryBuilder().build(Resources.getResourceAsStream(//
        "com/eomcs/mybatis/ex03/d/mybatis-config.xml")).openSession();


    Board board = new Board();
    board.setTitle("제목입니다zzz");
    board.setContent("내용입니다zzz");

    // insert 문을 실행할 때는 insert() 메서드를 호출한다.
    // - 리턴 값은 executeUpdate()의 실행 결과이다.
    // 즉 insert된 데이터의 개수이다.
    int count = sqlSession.insert("BoardMapper.insert",board);
    System.out.printf("%d 개의 데이터를 입력했읍!\n", count);

    // 수동 커밋 상태일 떄는
    // -데이터 변경후 commit() 을 명시적으로 호출해 줘야 한다.
    // - 그래야 실제 테이블에 변경 사항이 반영된다.
    sqlSession.commit();

    sqlSession.close();

    System.out.println("실행 완료");
  }

}


