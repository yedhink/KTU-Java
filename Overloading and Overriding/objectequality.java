class demo {
    int a=1,b=1;
}

class objectequality {
    public static void main(String args[]) {
        demo obj1 = new demo();
        demo obj2 = new demo();
        System.out.println((obj1.a).equals(obj2.a));
        System.out.println((obj1==obj2));
    }
}
