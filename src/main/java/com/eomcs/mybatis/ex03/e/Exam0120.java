// 트랜잭션 다루기 - 트랜잭션 적용전 -> auto commit 상태일때
package com.eomcs.mybatis.ex03.e;

import java.util.HashMap;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import com.eomcs.mybatis.vo.Board;

public class Exam0120 {

  public static void main(String[] args) throws Exception {

    // 수동 커밋 상태로 동작하는 SqlSession 객체를 얻는다.
    SqlSession sqlSession = new SqlSessionFactoryBuilder().build(Resources.getResourceAsStream(//
        "com/eomcs/mybatis/ex03/e/mybatis-config.xml")).openSession();


    Board board = new Board();
    board.setTitle("게시글2");
    board.setContent("내용2");

    // insert 문을 실행할 때는 insert() 메서드를 호출한다.
    // - 리턴 값은 executeUpdate()의 실행 결과이다.
    // 즉 insert된 데이터의 개수이다.
    int count = sqlSession.insert("BoardMapper.insertBoard",board);
    System.out.printf("%d 개의 게시글을 입력했음!\n", count);

    HashMap<String, Object> fileInfo = new HashMap<>();


    fileInfo.put("filePath", "aaa.gif");
    fileInfo.put("boardNo", board.getNo());
    count = sqlSession.insert("BoardMapper.insertFile",fileInfo);
    System.out.printf("%d 개의 게시글을 입력했음!\n", count);

    fileInfo.put("filePath", "bbb.gif");
    fileInfo.put("boardNo", board.getNo());
    count = sqlSession.insert("BoardMapper.insertFile",fileInfo);
    System.out.printf("%d 개의 게시글을 입력했음!\n", count);

    fileInfo.put("filePath", "aaddddddddddddddddddddddddddddddddddddddddddddddda"
        + "aaddddddddddddddddddddddddddddddddddddddddddddddda"
        + "aaddddddddddddddddddddddddddddddddddddddddddddddda"
        + "aaddddddddddddddddddddddddddddddddddddddddddddddda"
        + "aaddddddddddddddddddddddddddddddddddddddddddddddda"
        + "aaddddddddddddddddddddddddddddddddddddddddddddddda"
        + "aaddddddddddddddddddddddddddddddddddddddddddddddda.gif");
    fileInfo.put("boardNo", board.getNo());
    count = sqlSession.insert("BoardMapper.insertFile",fileInfo);
    System.out.printf("%d 개의 게시글을 입력했음!\n", count);

    // 수동 commit 일 때,
    // - 작업을 완료한 후 반드시 commit()을 호출해야만 실제 테이블에 변경사항을 적용한다.
    // - commit()을 호출하지 않고 SqlSession 객체를 close() 하면 자동 rollback 이다.
    // - SqlSession 객체를 재사용 하는 방식이면, 
    // - 오류가 발생했을때 개발자가 명시적으로 rollback()을 호출해 줘야 한다.

    sqlSession.commit();

    sqlSession.close();
    System.out.println("실행 완료");
  }

}


