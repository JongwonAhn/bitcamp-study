// Dynamic SQL - choose/when/otherwise 태그 사용법
package com.eomcs.mybatis.ex04.b;

import java.util.HashMap;
import java.util.List;
import java.util.Scanner;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import com.eomcs.mybatis.vo.Board;

public class Exam0210 {

  public static void main(String[] args) throws Exception {
    Scanner keyboard = new Scanner(System.in);

    System.out.print("검색 항목:\n  1. 제목\n  2. 내용\n검색 항목? ");
    int menuNo = Integer.parseInt(keyboard.nextLine());

    //    if (!(menuNo == 1 || menuNo == 2)) {
    //      System.out.println("검색 항목 번호가 옳지 않습니다.");
    //      keyboard.close();
    //      return;
    //    }

    System.out.print("검색어? ");
    String keyword = keyboard.nextLine();

    keyboard.close();

    SqlSession sqlSession = new SqlSessionFactoryBuilder().build(Resources.getResourceAsStream(
        "com/eomcs/mybatis/ex04/b/mybatis-config.xml")).openSession();


    // 조건이 여러개 일때는 if 태그 보다 choose 태그를 사용하는 것이 더 편리하다.
    // SQL을 다루기가 더 편하다.
    //
    //
    HashMap<String,Object> params = new HashMap<>();
    params.put("menuNo", menuNo);
    params.put("keyword", keyword);

    // Dynamic SQL을 사용하면 여러 개의 SQL 문을 만들 필요가 없다 

    List<Board> boards = sqlSession.selectList("BoardMapper.select4", params);

    for (Board b : boards) {
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


