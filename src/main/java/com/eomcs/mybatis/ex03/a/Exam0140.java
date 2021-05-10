// SQL 문에 삽입할 파라미터 전달하기 - CDATA 섹션을 사용할때 [!CDATA[ SQL 문 []]
package com.eomcs.mybatis.ex03.a;

import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import com.eomcs.mybatis.vo.Board;

public class Exam0140 {

  public static void main(String[] args) throws Exception {


    SqlSession sqlSession = new SqlSessionFactoryBuilder().build(Resources.getResourceAsStream(//
        "com/eomcs/mybatis/ex03/b/mybatis-config.xml")).openSession();

    List<Board> boards = sqlSession.selectList("BoardMapper.selectBoard4",10);

    //CDATA 섹션
    // -XML 파서(parser)에게 해당 블록의 내용물이 단순 텍스트임을 알려주는 명령이다.
    // -문법
    //     <![CDATA[ 내용물 ]]>
    // - 내용물 안에 XML 파서가 혼동을 일으킬 수 있는 문자가 많을 때 사용하기 적잡하다.
    //
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
    System.out.println("실행 완료");
  }

}


