import java.security.Timestamp;
import java.util.HashMap;

public class CarParking {

	public enum VehicalType{
		car,truck,van, electric,motobike
	}
	
	public enum parkingSpotType{
		handicapped,compact,large,electirc
	}
	public abstract class Account{
		private String username;
		private String password;
	}
	public class Admin extends Account{
		public boolean addParkingFloor(ParkingLot p,ParkingFloor floor) {
			p.addParkingFloor(floor);
		}
		public boolean addParkingSpotParking(ParkingFloor floor, ParkingSpot spot) {
			
		}
		public boolean addParkingDisplayBoard(ParkingFloor floor,ParkingDisplayBoard displayborad) {
			
		}
		
		public boolean addEntrancePanel(ParkingFloor floor,EntrancePanel entrance) {
			
		}
        public boolean addExitPanel(ParkingFloor floor,ExitPanel exit) {
			
		} 
	}
	public class ParkingAttendent extends Account{
		public boolean processTicket(ParkingTicket p) {
			return;
		}
	}
	public class ParkingLot{
		private String name;
		private HashMap<String,EntrancePanel> entrance;
		private HashMap<String,ExitPanel> exit;
		private HashMap<String,ParkingFloor> parkingfloor;
		private ParkingDisplayBoard globaldisplayborad;
		private static ParkingLot parkinglot = null;
		
		private ParkingLot(HashMap<String, EntrancePanel> entrance, HashMap<String, ExitPanel> exit,
				HashMap<String, ParkingFloor> parkingfloor, ParkingDisplayBoard globaldisplayborad) {

			this.entrance = entrance;
			this.exit = exit;
			this.parkingfloor = parkingfloor;
			this.displayborad = globaldisplayborad;
		}
		
		private static ParkingLot getInstance() {
			if(parkinglot==null) {
				parkinglot = new ParkingLot();
			}
			return parkinglot;
		} 
		public boolean addEntrancePanel(EntrancePanel entrance) {
			entrance.setParkingDisplayBoard(globaldisplayborad);
			entrance[entrance.getId()] = entrance;
			return true;
		}
        public boolean addExitPanel(addExitPanel exit) {
			exit[exit.getId()]{};
		}
        public boolean addParkingFloor(ParkingFloor floor) {
        	floor[floor.getId()]{};
		}
	}
	
	public class ParkingTicket{
		private String numberpalte;
		private Timestamp issuetime;
		
		public ParkingTicket(String number) {
			this.numberpalte = number;
			this.issuetime = Time();
		}
	}
	
	public abstract class Vehicle{
		private String number;
		final VehicalType type;
		
		private ParkingTicket ticket;
		
		public Vehicle(VehicalType type) {
			this.type = type;
		}
		public void assignticket(ParkingTicket ticket) {
			this.ticket = ticket;
		}
		public String getNumber() {
			return number;
		}
	}
	public class Car extends Vehicle{
		public Car() {
			super(VehicalType.car);
		}
	}
	public class Truck extends Vehicle{
		public Truck() {
			super(VehicalType.truck);
		}
	}
	public class Motobike extends Vehicle{
		public Motobike() {
			super(VehicalType.motobike);
		}
	}
	public class Van extends Vehicle{
		public Van() {
			super(VehicalType.van);
		}
	}
	public class EntrancePanel{
		private String Id;
		private ParkingDisplayBoard displayborad;
		
		public void issueparkingticket(Vehicle v) {
			if(checkspotforavailibility(v)) {
				v.assignticket(new ParkingTicket(v.getNumber()));
			}
			else {
				System.out.println("There is no availibility");
			}
		}
		public void setGlobalparkingdisplayboard(ParkingDisplayBoard displayborad) {
			this.displayborad = displayborad;
		}
	}
	public class ExitPanel{
		private String Id;
		public void acceptpayment(ParkingTicket p){};		
	}
	public class ParkingFloor{
		private String Id;
		private HashMap<String,ParkingSpot> parkingspot;
		private ParkingDisplayBoard parkingboard;
		private ParkingDisplayBoard global;
		public ParkingFloor(HashMap<String, ParkingSpot> parkingspot, ParkingDisplayBoard parking,
				ParkingDisplayBoard global) {
			super();
			this.parkingspot = parkingspot;
			this.parking = parking;
			this.global = global;
		}
		public void addparkingSpot(ParkingSpot spot) {
			parkingspot[spot.getId()] = spot;
		}
		public ParkingDisplayBoard getParkingboard() {
			return this. parkingboard;
		}
		public ParkingDisplayBoard getGlobal() {
			return this.global;
		}
	}
	public abstract class ParkingSpot{
		private String id;
		private boolean isFree;
		private Vehicle vehicle;
		
		private ParkingSpot type;
		private ParkingFloor floor;
		public ParkingSpot(CarParking.ParkingSpot type, CarParking.ParkingFloor floor) {
			this.type = type;
			this.floor = floor;
		}
	   public void assignVehicle(Vehicle v) {
		   this.vehicle = v;
		   this.isFree = false;
		   this.floor.getParkingboard().changecount(type,-1);
		   this.floor.getGlobal().changecount(type,-1);
	   }
	   public void freeParkingSpot(Vehicle v) {
		   this.isFree = false;
		   vehicle = null;
		   this.floor.getParkingboard().changecount(type,1);
		   this.floor.getGlobal().changecount(type,1);
	}
	 
  }
  public class HandicappedSpot extends ParkingSpot{
	  HandicappedSpot(ParkingFloor floor){
		  super(parkingSpotType.handicapped,floor);
	  }  
  }
  public class electric extends ParkingSpot{
	  electric(ParkingFloor floor){
		  super(parkingSpotType.electirc,floor);
	  };
	  public void acceptpayment(){};
  }
  public class ParkingDisplayBoard{
	  private String id;
	  private hashMap<ParkingSpotType,Integer> countofparkingsports;
	  
	  public ParkingDisplayBoard(hashMap<ParkingSpotType,Integer> countofparkingsports) {
		  this.countofparkingsports = countofparkingsports;
	  };
	  public void changeCount(parkingSpotType type, Integer change) {
		  countofparkingsports[type] += change;
	  }
  }
}
