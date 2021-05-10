// 인터페이스 구현체를 만드는 다양한 방법
package com.eomcs.oop.ex12;

public class Exam0810 {

  interface Factory {
    Object create();
  }

  static class Car {}

  public static void main(String[] args) {
    // 1) 로컬 클래스로 인터페이스 구현체를 만든다.
    class CarFactory implements Factory {
      @Override
      public Object create() {
        return new Car();
      }
    }

    Factory f1 = new CarFactory();
    Car car = (Car) f1.create();

    // 2) 익명 클래스로 인터페이스 구현체를 만든다.
    Factory f2 = new Factory() {
      @Override
      public Object create() {
        return new Car();
      }
    };

    //    1.람다 메소드 껍데기를 꺼낸다.
    //    2. 메소드 이름까지 지운후 ->를 붙힌다
    //    3. 만약에 중간에 문장이 하나인경우, 중괄호도 생략가능하며, 대신 세미콜론을 붙힌다.
    //    4. 그리고 리턴까지 지운다.
    //    5. 추상메서드가 하나인경우 유효하다.
    Car car2 = (Car) f2.create();

    // 3) 람다로 인터페이스 구현체를 만든다.
    Factory f3 = () -> new Car();
    Car car3 = (Car) f3.create();


    // 4) 기존에 존재하는 메서드로 인터페이스 구현체를 만든다.
    Factory f4 = Exam0810::createCar;
    Car car4 = (Car) f4.create();

    // 5) 기존 클래스의 생성자로 인터페이스 구현체로 사용한다.
    Factory f5 = Car::new;
    Car car5 = (Car) f5.create();

    System.out.println("완료!");
  }

  public static Car createCar() {
    return new Car();
  }

}


