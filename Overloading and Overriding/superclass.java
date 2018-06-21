class superClass {
    int a=-1,b=-1;
    superClass(int a , int b){
        this.a = a;
        this.b = b;
    }
    int vol(){
        return a*b;
    }
}

class subClass {
    int a=-1,b=-1;
    subClass(int a , int b){
        this.a = a;
        this.b = b;
    }
    int vol(){
        return a*b;
    }
}
class superclass {
    public static void main(String args[]) {
        superClass s = new superClass(2,4);
        subClass sub = new subClass(3,6);
        s=sub;
        s.vol();
    }
}i
