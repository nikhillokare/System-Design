class SingletonEagar {
  private static SingletonEagar biker = new SingletonEagar(); 
  
  private SingletonEagar(){}
  
  public static SingletonEagar getInstance() {
	System.out.println("Nikhil Lokare");
    return biker;
  }
}

class Singleton {
  private static Singleton biker; 
  
  private Singleton(){}
  
  public static Singleton getInstance() {
    if(biker == null) {
    	biker = new Singleton();
    }
    
    return biker;
  }
}

class SingletonSynchronizedMethod {
  private static SingletonSynchronizedMethod biker; 
  
  private SingletonSynchronizedMethod(){}
  
  public static synchronized SingletonSynchronizedMethod getInstance() {
    if(biker == null) {
    	biker = new SingletonSynchronizedMethod();
    }
    return biker;
  }
}

class SingletonSynchronized {
  private static SingletonSynchronized biker; 
  
  private SingletonSynchronized(){}
  
  public static SingletonSynchronized getInstance() {
    if(biker == null) {
      synchronized (SingletonSynchronized.class) {
        if(biker == null) {
        	biker = new SingletonSynchronized();
        }
      }
    }
    return biker;
  }
}

public class SingletonExample {

  public static void main(String[] args) {
	  SingletonEagar biker = SingletonEagar.getInstance();
      System.out.println(biker);
      
      Singleton biker1 = Singleton.getInstance();
      System.out.println(biker1);
    
  }
}