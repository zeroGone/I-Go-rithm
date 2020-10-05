package Study.CallByValue;

import java.util.*;

/*
* Java는 참조하는 변수의 값을 전달해주는 Call by value 이다.
* 즉, 메소드 파라미터는 할당된 변수의 주소를 값으로 받고 있는 것.
* */
public class Main {

    public static void main(String[] args) {
        Person p = new Person("홍준성");

        assignNewPerson(p);
        System.out.println(p);

        setNewName(p);
        System.out.println(p);
    }

    static void assignNewPerson(Person p){
        p = new Person("홍성주");
    }

    /*
    assignNewPerson 흐름
    1.
    main's p -------------> Person [ 홍준성 ]
                              ↑
    method's p ----------------

    2.
    main's p -------------> Person [ 홍준성 ]

    method's p -----------> Person [ 홍성주 ]
     */

    static void setNewName(Person p){
        p.setName("홍성주");
    }

    /*
    setNewName 흐름
    1.
    main's p -------------> Person [ 홍준성 ]
                              ↑
    method's p ----------------

    2.
    main's p -------------> Person [ 홍준성 ]
                              ↑
    method's p ----------------
    준성이의 setName이 실행
     */

    static class Person{
        private String name;
        public Person(String name){
            this.name = name;
        }

        public void setName(String name){
            this.name= name;
        }

        @Override
        public String toString() {
            return this.name;
        }
    }
}
