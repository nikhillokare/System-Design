import java.sql.Time;
import java.util.HashMap;

public class CarParkingPlace {
   
	public enum VehicleType{
		car,truck,van,electric,motorbike;
	}
	
	public enum parkingSpotType{
		handicapped,compact,large,motorbike,electric;
	}
	
	public abstract class Account{
		private String userName;
		private String password;
	}
	
	public class Admin extends Account{
		public boolean addParkingFloor(ParkingFloor floor);
		public boolean addParkingSpot(String ParkingFloor,ParkingSpot spot);
		public boolean addParkingDisplayBoard(String floorName, ParkingDisplayBoard displayborad);
		public boolean addEntrancePanel(EntrancePanel entrance);
		public boolean addExitpanel(Exitpanel exitpanel);
		
	}
	
	public class ParkingAttendent extends Account{
		public boolean processTicket(ParkingTicket p);
	}
	
	public class ParkingLot{
		private String name;
		private HashMap<String,Entrance> entrance;
		private HashMap<String,Exit> exit;
		private HashMap<String,Parkingfloor> parkingfloors;
		private ParkingDisplayBorad displayboard;
		private static ParkingLot parkinglot = null;
		
		private ParkingLot(HashMap<String,Entrance> entrance,HashMap<String,Exit> exit,HashMap<String,Parkingfloor> parkingfloors) {
			private static getInstance() {
				if(ParkingLot == null) {
					ParkingLot =  new ParkingLot();
				}
				return ParkingLot;
			}
			
			public boolean addEntrance(EntrancePanel, entrancepanel) {
				entrancepanel.setParkingDisplayBorad(this.displayboard);
				entrancepanel[entrancepanel.getId()] = entrancepanel;
			}
			public boolean addExitPanel(ExitPanel,exitpanel) {
				public boolean addFloor(ParkingFloor floor);
			}
		}
	}
	public class ParkingTicket{
		private String numberplate;
		public TimeStamp issutime;
		
		public ParkingTicket(String number) {
			this.numberplate = number;
			this.issutime = Time.now();
		}
	}
	
}
