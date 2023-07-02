class Engine{
	public void startEngine(){
		System.out.println("Car Engine Started.");
		}
	public void stopEngine(){
		System.out.println("Car Engine Stopped.");
	}
}
class Car1{
	private String color;
	private int max_Speed;
	public void carDetails(){
		System.out.println("Color = "+color +" Max Speed = "+ max_Speed);
		}
	public void setColor(String color){
		this.color = color;
		}
	public void setMaxSpeed(int max_Speed){
		this.max_Speed = max_Speed;
		}
	}
class Civic extends Car1{
	public void CivicStart(){
		Engine engine = new Engine(); 
		engine.startEngine();
		}
	}
    public class Main{
		public static void main(String[] args){
			Civic civic = new Civic();
			civic.setColor("Silver");
			civic.setMaxSpeed(180);
			civic.carDetails();
			civic.CivicStart();
			}
		}

	

