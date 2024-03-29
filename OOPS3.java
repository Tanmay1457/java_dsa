
import java.util.*; //package
public class OOPS3 {

    public static void main(String[] args) {

        //Method Overloading.......
//       Calculator calc = new Calculator();
//        System.out.println(calc.sum(1,2));
//        System.out.println(calc.sum((float) 1.5,(float)  2.5));
//        System.out.println(calc.sum(1,2,3));

        //Method overriding.......
//        Deer d = new Deer();
//        d.eat();

        //package in java ....................................................................................
//
        //Abstraction..........................................................................................
        //object creation
//        Horse h = new Horse();
//        h.eat();
//        h.walk();
//
//        Chicken c = new Chicken();
//        c.eat();
//        c.walk();
//
//        System.out.println(h.color); // o/p : brown
        //first parent constructor called before child

        //Mustang myHorse = new Mustang();
        //Animal -> Horse -> Mustang
        /*o/p :
        Animal Constructor called......
        Horse constructor is called......
        Mustang Constructor called......*/

        //interface..............
//        Queen q = new Queen();
//        q.moves();

        //Static keyword...........
//        student1 s1 = new student1();
//        s1.schoolName = "MES";
//
//        student1 s2 = new student1();
//        System.out.println(s2.schoolName); //o/p : MES
//
//        //change schhol name
//        student1 s3 = new student1();
//        s3.schoolName = "IIT";
//        System.out.println(s1.schoolName); //o/p : IIT
//        System.out.println(s2.schoolName); //o/p : IIT

        //super Keyword................
        Horse1 h = new Horse1();
        System.out.println(h.color);


    }
}

//Method Overloading.........................................................................................
class Calculator{
    int sum(int a, int b){

        return a+b; // o/p 3
    }
    float sum(float a, float b){

        return a+b; // o/p 4.0
    }
    int sum(int a, int b, int c){

        return a+b+c; // o/p 6
    }
}

//Method Overriding........................................................................................

class Animals {
    void eat(){
        System.out.println("eats anything");
    }
}

class Deer extends Animal{
    void eat(){
        System.out.println("eats grass");
    }
}

//Abstraction...............................................................................................

abstract class Animals1 {
    String color;
    Animals1(){ //Constructor.............
        //color = "brown";
        System.out.println("Animal Constructor called......");
    }
    void eat(){
        System.out.println("animal eats");
    }
    abstract void walk(); //abstract method bcoz it has no implementation
    //It will give an idea of walk() function but its work depend on different subclass
}

//subclass
class Horse extends Animals1{
    Horse(){
        System.out.println("Horse constructor is called......");
    }
    void changeColor(){
        color = "dark brown";
    }
    void walk(){
        System.out.println("walks on 4 legs "); //it has implementation
    }
}
class Mustang extends Horse{
    Mustang(){
        System.out.println("Mustang Constructor called......");
    }
}

class Chicken extends Animals1{
    void changeColor(){
        color = "white";
    }
    void walk(){
        System.out.println("walks on 2 legs "); //it has implementation
    }
}

//Interfaces........................................................................................................

interface ChessPlayer{ //Interface creation
    void moves(); //blueprint
}
class Queen implements ChessPlayer{
    public void moves(){
        System.out.println("up,down,left,right,diagonal(in all 4 dirction)");
    }
}
class Rook implements ChessPlayer{
    public void moves(){
        System.out.println("up,down,left,right");
    }
}
class King implements ChessPlayer{
    public void moves(){
        System.out.println("up,down,left,right,diagonal(by 1 step)");
    }
}

//Static Keyword.....................................................................................................
class student1 {
  String name;
  int roll;

  static String schoolName; //common to all and changes reflected

    void setName(String name){
        this.name = name;
    }
    String getName(){
      return this.name;
  }
}

//Super Keyword........................................................................................................
class Animal2 {
    String color;
    Animal2(){
        System.out.println("animal constructor is called......");
    }
}

class Horse1 extends Animal2{
    Horse1(){
        //super(); // Animal2 constructor called i.e immediate parent called
        super.color = "Brown";
        System.out.println("horse construtor called.........");
    }
}
