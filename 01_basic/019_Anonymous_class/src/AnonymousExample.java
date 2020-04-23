//https://cornswrold.tistory.com/239
//https://cornswrold.tistory.com/238
//https://imasoftwareengineer.tistory.com/99

interface RemoteControl {
    public void turnOn();
    public void turnOff();
}

class Anonymous {
    // 필드 초기값으로 대입
    RemoteControl field = new RemoteControl() {
        @Override
        public void turnOn() {
            System.out.println("TV를 켭니다.");
        }

        @Override
        public void turnOff() {
            System.out.println("TV를 끕니다.");
        }
    };

    void method1(){
        RemoteControl localVar = new RemoteControl() {
            @Override
            public void turnOn() {
                System.out.println("Audio를 켭니다.");
            }

            @Override
            public void turnOff() {
                System.out.println("Audio를 끕니다.");
            }
        };
        // 로컬변수 사용
        localVar.turnOn();
    }

    void method2(RemoteControl rc){
        rc.turnOn();
    }
} 

class Polygon {
	   public void display() {
	      System.out.println("Inside the Polygon class");
	   }
	}

class AnonymousDemo {
   public void createClass() {

      // creation of anonymous class extending class Polygon
      Polygon p1 = new Polygon() {
         public void display() {
            System.out.println("class inside an anonymous class.");
         }
      };
      p1.display();
   }
}
	
interface Polygoni {
	   public void display();
	}

class AnonymousDemo2 {
   public void createClass() {

      // anonymous class implementing interface
      Polygoni p1 = new Polygoni() {
         public void display() {
            System.out.println("interface inside an anonymous class.");
         }
      };
      p1.display();
   }
}

public class AnonymousExample {
	public static void main(String[] args) {
		Anonymous anony = new Anonymous();
		// 익명 객체 필드 사용
		anony.field.turnOn();
		// 익명 객체 변수 사용
		anony.method1();
		// 익명 객체 매개값 사용
		anony.method2(new RemoteControl() {
		    @Override
		    public void turnOn() {
		        System.out.println("smart TV를 켭니다.");
		    }
		
		    @Override
		    public void turnOff() {
		        System.out.println("smart TV를 끕니다.");
		    }
		});
	        
//	     https://www.programiz.com/java-programming/anonymous-class
//		1. anonymous class implementing class
		AnonymousDemo a = new AnonymousDemo();
	    a.createClass();
	    
//	    2. anonymous class implementing interface
	    AnonymousDemo2 b = new AnonymousDemo2();
	      b.createClass();
	    }
}
