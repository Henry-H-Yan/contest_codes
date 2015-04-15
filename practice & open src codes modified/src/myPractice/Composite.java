package myPractice;

class Animal{  

	private void beat(){  

		System.out.println("beating ");  
	}  
	public  void breath(){  

		beat();  
		System.out.println("breathing freely");  
	}  

}  
class Wolf extends Animal{  

	private Animal one;  


	public Wolf(Animal one){  

		this.one=one;  
	}  

	public void breath(){  

		one.breath();  
	}  

	public void run(){  
		System.out.println("runing...");  
	}  

}  
class Bird{  

	private Animal one;  

	public Bird(Animal one){  
		this.one=one;  
	}  
	public void breath(){  
		one.breath();  
	}  
	public void fly(){  
		System.out.println("Fly...");  
	}  

}  

public class Composite{  

	public static void main(String[] args){  


		Animal my=new Animal();  

		Wolf nima=new Wolf(my);  
		nima.run();  
		nima.breath();  


		Bird nimei=new Bird(my);  
		nimei.fly();  
		nimei.breath();  
	}  
}



