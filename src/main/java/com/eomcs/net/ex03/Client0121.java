// 서버와 입출력 테스트 - byte stream : 바이트 배열 보내고 받기
package com.eomcs.net.ex03;

import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.util.Scanner;

public class Client0121 {
  public static void main(String[] args) {
    Scanner keyScan = new Scanner(System.in);

    try (Socket socket = new Socket("localhost", 8888);
        OutputStream out = socket.getOutputStream();
        InputStream in = socket.getInputStream()) {

      System.out.println("서버와 연결되었음!");

      // 서버에 데이터를 보내기 전에 잠깐 멈춤!
      System.out.print(">");
      keyScan.nextLine();

      // 서버에 보낼 바이트 배열을 준비한다.
      // => 0 ~ 99 의 값을 가진 배열이다.
      byte[] bytes = new byte[100];
      for (int i = 0; i < 100; i++) {
        bytes[i] = (byte) i;
      }

      // 서버에 바이트 배열을 전송한다.
      out.write(bytes);
      // out.flush();
      // byte stream 을 사용할 때는 바로 출력한다.
      // 따라서 flush()를 호출하지 않아도 된다.
      System.out.println("서버에 데이터를 보냈음!");

      // 서버에서 바이트 배열을 읽는다.
      byte[] buf = new byte[100];
      int size = in.read(buf);
      System.out.printf("바이트 배열의 크기: %d\n", size);

      for (int i = 0; i < size; i++) {
        if (i > 0 && (i % 20) == 0) {
          System.out.println(); // 20바이트 출력한 후 줄 바꾼다.
        }
        System.out.printf("%x ", buf[i]);
      }

    } catch (Exception e) {
      e.printStackTrace();
    }

    keyScan.close();
  }
}


