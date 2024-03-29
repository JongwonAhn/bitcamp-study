// SQL 문에 삽입할 파라미터 전달하기 - XML Entity를 사용할때
package com.eomcs.mybatis.ex03.a;

import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import com.eomcs.mybatis.vo.Board;

public class Exam0130 {

  public static void main(String[] args) throws Exception {


    SqlSession sqlSession = new SqlSessionFactoryBuilder().build(Resources.getResourceAsStream(//
        "com/eomcs/mybatis/ex03/a/mybatis-config.xml")).openSession();

    // XML 파서가 혼동을 일으킬수 있는(XML 파싱 오류 발생) 문자를 사용할때
    // -그 문자 대신 XML Entity를 대신 사용하라.
    //  " => &quot;
    //  ' => &apos;
    //  & => &amp;
    //  < => &lt;
    //  > => &gt;
    List<Board> boards = sqlSession.selectList("BoardMapper.selectBoard3",10);

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


