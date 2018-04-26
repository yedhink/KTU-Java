package classExamples.overR.DMD;
import CHARSEQ.*; // well, well..look what we have imported here.

class A{
	void show(){
		System.out.println("Inside class A");
	}
}
class B extends A{
	int valueB = 5;
	void show(){
		System.out.println("Inside class B");
	
	}
}
			
class C extends B{
	void show(){
		System.out.println("Inside class C");
	}
}

class overriding{
	public static void main(String args[]){
		A objA = new A();
		B objB = new B();
		C objC = new C();
		objA.show();
		objB.show();
		objC.show();
		csb stud = new csb();
		System.out.println("\nYay! We called the function revName() from another program\nReversed name : "+stud.revName("Yedhin")+"\n");
		
		// Dynamic Method Dispatch 
		System.out.println("Dynamic method dispatch works");
		A overA = objB;
		A overC = objB;
		overA.show();
		overC.show();
	}
}
