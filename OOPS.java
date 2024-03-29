public class OOPS {
    public static void main(String[] args) {
        /*
        //Object Creation
        Pen p1 = new Pen(); //Created a pen object called p1 and pen() is a constructor
        p1.setColor("Blue");//call function
        System.out.println(p1.color); //access property
        p1.setTip(5);
        System.out.println(p1.tip);
        p1.color="yellow"; //directly set color
        System.out.println(p1.color);

        //Access modifier
        BankAccount myAcc = new BankAccount();
        myAcc.username = "Tanmay";
        //myAcc.password = "tanm1234"; // error due to private
        myAcc.setPassword("tanm1234"); //we only change it not access or display
        System.out.println(myAcc.username); //it display uname
       */

        //By using  setter and getter..............
        Pen p1 = new Pen();
        p1.setColor("Blue");
        System.out.println(p1.getColor()); //by using get
        p1.setTip(5);
        System.out.println(p1.getTip());
    }
}

//Class and Object.......................................................................................................
class Pen {
    //String color;
    //int tip;

    private String color;
    private int tip;

    String getColor(){ //getter..........
        return this.color; //this keyword replace by called object
    }
    int getTip(){ //getter..............
        return this.tip;
    }

    void setColor(String newcolor){ //setter........
        color = newcolor;
    }
    void setTip(int newTip){ //setter...........
        tip = newTip;
    }
}



//Access Modifier........................................................................................
class BankAccount{
    public String username; //visible to everyone
    private String password; //Not accessable to anyone outside the class
    public void setPassword(String pwd){
        password =pwd; //setting password
    }
}

