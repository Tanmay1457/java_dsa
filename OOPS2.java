
public class OOPS2 {
    public static void main(String[] args) {
       //Student s1 = new Student("tanmay"); //1st time if we remove student() constructor below it will by default it consider as constructor
       // System.out.println(s1.name);

//        Student s1 = new Student(); //o/p = Constructor called...
//        Student s2 = new Student("tanmay");
//        Student s3 = new Student(123);

        //copy constructor..........
          Student s1 = new Student();

          s1.name = "tanmay";
          s1.roll = 123;
          s1.password = "tan12";
          s1.marks[0] = 100;
          s1.marks[1] = 90;
          s1.marks[2] = 97;

          Student s2 = new Student(s1); //copy all property of s1 to s2

          //Change s1 mark after copying all this due to reason below
          s1.marks[2] = 100;
          s2.password = "XYZ";

          for (int i=0; i<3; i++){
              System.out.println(s2.marks[i]); //print same marks as s1
          }

//inheritance........................................................
//         Fish shark = new Fish();
//         shark.eat(); //access in the animal or parent class

        //Multilevel inheritance...........
//        Dog tom = new Dog();
//        tom.eat();
//        tom.legs = 4;
//        System.out.println(tom.legs);

        //Hierarchical inheritance.........
          Bird eagle = new Bird();
          eagle.eat();


    }
}

//Constructor........................................................................................

class Student {
    String name;
    int roll;
    String password;
    int marks[];


    Student() { //Non parameterized constructor......1]
        marks = new int[3];
        System.out.println("Constructor called...");
    } //2nd time below constructor are created if we remove now it will give an error
    //Bcoz java will create constructor when we not created another constructor
    //so we have to delete all another constructor this phenomenon called "constructor overloading"

    Student(String name) { //Constructor........  //Parameterized Constructor......2]
        marks = new int[3];
        this.name = name;
    }

    Student(int roll) {
        marks = new int[3];
        this.roll = roll;
    }

//Copy Constructor......................................................................................
//Shallow Copy constructor
    //marks are changed...
//    Student(Student s1){ //passing s1 as parameter
//        marks = new  int[3];
//        this.name = s1.name;
//        this.roll = s1.roll;
//        this.marks = s1.marks;
//        //Reason : here all array not copy only its reference copy
//    }

    //Deep copy constructor
    Student(Student s1) {
        marks = new int[3];
        this.name = s1.name;
        this.roll = s1.roll;
        for (int i = 0; i < marks.length; i++) {
            this.marks[i] = s1.marks[i]; //Marks are not changed....
        }
    }

}

//Inheritance............................................................................................

class Animal { //Parent class...................👬
    String color;

    void eat() {
        System.out.println("eats");
    }

    void breathe() {
        System.out.println("breaths");
    }
}

//class Fish extends Animal{ //Child class.................👶
//    int fins;
//    void swim(){
//        System.out.println("Swim in water");
//    }
//}

//Multilevel inheritance..............................................

/*
class Mammal extends Animal{
    int legs;
}

class Dog extends Mammal{
    String breed;
}*/

//Hierarchical inheritance..............................................

class Mammal extends Animal{ //.................1
    void walk(){
        System.out.println("walks");
    }
}
class Fish extends Animal{ //...................2
    void swim(){
        System.out.println("swim");
    }
}
class Bird extends Animal{ //...................3
    void fly(){
        System.out.println("fly");
    }
}