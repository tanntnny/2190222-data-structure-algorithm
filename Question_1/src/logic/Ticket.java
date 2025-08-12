package logic;

public class Ticket {
	private int type;
	private int priceperstation;
	
	private Station start;
	private Station end;
	
	public Ticket(int type,Station start,Station end) {
		setType(type);
		setStation(start,end);
	}
	
	public int getType() {
		return type;
	}
	
	public int getPricePerStation() {
		return priceperstation;
	}
	
	public Station getStart() {
		return start;
	}
	
	public Station getEnd() {
		return end;
	}
	
	public void setType(int type) {
		if (type < 0 || type > 2) this.type = 1;
		else this.type = type;
		int rates[] = {30, 30, 25};
		this.priceperstation = rates[this.type];
	}
	
	public void setStation(Station start,Station end) {
		this.start = start;
		this.end = end;
	}
	
	public double calculatePrice() {
		if ( !this.isStationValid(this.start, this.end) ) return -1;
		int distance = this.getStationDistance(this.start, this.end);
		double basePrice = this.priceperstation * distance; 
		if ( this.type == 0 && distance > 4 ) return 0.8 * basePrice;
		else if ( this.type == 2 ) return 0.6 * basePrice;
		else return basePrice;
	}
	
	public String getDescription() {
		String typename;
		
		switch(type) {
		
		case 0:
			typename = "Student";
			break;
		case 1:
			typename = "Adult";
			break;
		case 2:
			if ( this.getStationDistance(this.start, this.end) <= 6 ) typename = "Elderly";
			else typename = "Invalid";
			break;
		default:
			typename = "Invalid";
		}
		
		return typename+" Ticket, from "+this.start.getName()+" to "+this.end.getName();
	}
	
	public boolean isStationValid(Station start,Station end) {
		if (type == 2 && this.getStationDistance(start, end) > 6) {
			return false;
		}

		if (start == end || start.getName().equals(end.getName())) {
			return false;
		}
		return true;
	}
	
	public int getStationDistance(Station start,Station end) {
		return Math.abs(start.getNumber()-end.getNumber());
	}
	
}
