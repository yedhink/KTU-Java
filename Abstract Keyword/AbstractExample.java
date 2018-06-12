// a abstract class
abstract class H {
    int x;

    /* abstract */ int y; // variables cannot be abstract

    /* abstract */ H () {x=1;} // constructor cannot be abstract

    void triple  (int n) {x=x*3;}; // a normal method

    static int triple2 (int n) {return n*3;}; // a static method in abstract class is ok.
    abstract void triple3 (); // abstract method. Note: no definition.

    // static abstract void triple3 (int n); // abstract static cannot be combined
    int returnMe () {return x;}
}

// H1 extends (inherits) H. When a class extends a abstract class,
// it is said to “implement” the abstract class.
class H1 extends H {
    void triple3 () {x=x*3+1;} // must be defined, else compiler makes a complaint.
    //Also, all return type and parameter must agree with the parent class.
}

public class AbstractExample {
    public static void main(String[] args) {
        // H xx = new H(); // abstract class cannot be instantiated
        H1 myO = new H1(); // abstract class cannot be instantiated
        myO.triple3();
        System.out.println(myO.returnMe());
    }
}
