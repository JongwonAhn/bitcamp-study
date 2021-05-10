package com.eomcs.mybatis01.ex14;

import java.util.List;

public interface BoardDao {
  List<Board> selectList();
  int insert(Board board);
}









