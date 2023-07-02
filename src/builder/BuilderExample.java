package builder;

class Vehicle{
	
	private String engine;
	private int wheel;
	private int airbags;
	
	public String getEngine() {
		return engine;
	}
	public int getWheel() {
		return wheel;
	}
	public int getAirbags() {
		return airbags;
	}
	public Vehicle(VehicleBuilder builder) {
		super();
		this.engine = builder.engine;
		this.wheel = builder.wheel;
		this.airbags = builder.airbags;
	}
	
	public static class VehicleBuilder{
		public String engine;
		public int wheel;
		
		public int airbags;

		public VehicleBuilder(String engine, int wheel) {
			this.engine = engine;
			this.wheel = wheel;
		}
		
		public VehicleBuilder setAirbags(int airbags) {
			this.airbags = airbags;
			return this;
		}
		
		public Vehicle build() {
			return new Vehicle(this);
		}
	}
	
}
public class BuilderExample {

	public static void main(String[] args) {
		
		Vehicle car = new Vehicle.VehicleBuilder("1500cc",4).setAirbags(6).build();
		Vehicle bike = new Vehicle.VehicleBuilder("500cc",2).build();
		
		System.out.println(car.getEngine()); 
		System.out.println(car.getWheel()); 
		System.out.println(car.getAirbags()); 
		
		System.out.println(bike.getEngine()); 
		System.out.println(bike.getWheel()); 
		System.out.println(bike.getAirbags());
		
		
	}

}
