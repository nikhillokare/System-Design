abstract class Vehical{
	
	public abstract int getWheel();
	
	public String toString() {
		return "Wheel :" + this.getWheel();
	}
}

class Car extends Vehical{
	int wheel;
	
	Car(int wheel){
		this.wheel = wheel;
	}

	@Override
	public int getWheel() {
		return this.wheel;
	}
}

class Bike extends Vehical{
	int wheel;
	
	Bike(int wheel){
		this.wheel = wheel;
	}

	@Override
	public int getWheel() {
		return this.wheel;
	}
}

class Airplane extends Vehical{
	int wheel;
	
	Airplane(int wheel){
		this.wheel = wheel;
	}

	@Override
	public int getWheel() {
		return this.wheel;
	}
}

class Factory {
	public static Vehical getInstance(String type,int wheel) {
		if(type=="car") {
			return new Car(wheel);
		}
		else if(type=="bike") {
			return new Bike(wheel);
		}
		else if(type=="airplane") {
			return new Airplane(wheel);
		}
		return null;
	}
}
public class FactoryExample {

	public static void main(String[] args) {
          
		Vehical car = Factory.getInstance("car",4);
		System.out.println(car);
		
		Vehical bike = Factory.getInstance("bike",2);
		System.out.println(bike);
		
		Vehical airplane = Factory.getInstance("airplane",2);
		System.out.println(airplane);

	}

}
