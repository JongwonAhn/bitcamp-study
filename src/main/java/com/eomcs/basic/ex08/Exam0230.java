// java.util.HashMap - key/value 한쌍으로 묶어 꺼내기
package com.eomcs.basic.ex08;

import java.util.HashMap;
import java.util.Map.Entry;
import java.util.Set;

public class Exam0230 {
  public static void main(String[] args) {

    HashMap<String,Member> map = new HashMap<>();
    map.put("s01", new Member("홍길동", 20));
    map.put("s02", new Member("임꺽정", 30));
    map.put("s03", new Member("유관순", 16));
    map.put("s04", new Member("안중근", 20));
    map.put("s05", new Member("윤봉길", 30));

    //맵에서 값을한번에 꺼내는 방법이 키 한쌍을 꺼내는 방법인데 map.entrySet()을 호출.
    //맵의 엔트리 셋을 호출하면 set이라는 집할을 리턴한다 Set set
    //. 그 집합에 entry객체가 들어가있고 <Entry>
    // 그안에 string타입,  값은 맴버가 들어가 있다. <Entry<String, Member>>
    Set<Entry<String,Member>> entrySet = map.entrySet();
    // key,value가 한쌍으로 묶여있는 객체들이 들어있다.

    for (Entry<String,Member> entry : entrySet) {
      System.out.printf("%s ===> %s\n",
          entry.getKey(),
          entry.getValue());
    }

  }

}







