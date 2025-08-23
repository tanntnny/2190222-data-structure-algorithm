package logic;

public class CardCounter {
	private UnitCard card;
	private int count;
	
	public CardCounter( UnitCard card, int count ) {
		setCard( card );
		setCount( count );
	}
	
	public String toString() {
		return  this.getCard() + " x " + this.getCount();
	}
	
	public UnitCard getCard() {
		return this.card;
	}
	
	public int getCount() {
		return this.count;
	}
	
	public void setCard( UnitCard card ) {
		this.card = card;
	}
	
	public void setCount( int count ) {
		if ( count < 0 ) this.count = 0;
		else this.count = count;
	}
}
