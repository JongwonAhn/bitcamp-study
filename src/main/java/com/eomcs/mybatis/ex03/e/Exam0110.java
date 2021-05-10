// 트랜잭션 다루기 - 트랜잭션 적용전 -> auto commit 상태일때
package com.eomcs.mybatis.ex03.e;

import java.util.HashMap;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import com.eomcs.mybatis.vo.Board;

public class Exam0110 {

  public static void main(String[] args) throws Exception {


    SqlSession sqlSession = new SqlSessionFactoryBuilder().build(Resources.getResourceAsStream(//
        "com/eomcs/mybatis/ex03/e/mybatis-config.xml")).openSession(true);


    Board board = new Board();
    board.setTitle("게시글1");
    board.setContent("내용1");

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

    // auto commit 일 때,
    // - 데이터 변경 SQL 문을 실행하면 즉시 테이블에 적용한다.
    // - 따라서 세번째 첨부 파일을 입력하다가 오류가 발생하더라도
    // - 이전에 수행했던 데이터 변경 작업은 완료된 상태다.

    fileInfo.put("boardNo", board.getNo());
    count = sqlSession.insert("BoardMapper.insertFile",board);
    System.out.printf("%d 개의 게시글을 입력했음!\n", count);









    // commit() 을 호출하지 않아도 즉시 테이블에 변경 사항을 반영한다.

    // 현재 SqlSession 객체가 수동 commit 상태이기 때문에
    // 데이터 변경을 수행한 후 commit을 반드시 실행해야 한다.

    sqlSession.close();
    System.out.println("실행 완료");
  }

}


