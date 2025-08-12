package logic;

import java.util.ArrayList;

public class UnitDeck {
	private ArrayList<CardCounter> cardsInDeck;
	private String deckName;
	
	public UnitDeck( String deckName ) {
		setDeckName( deckName );
		setCardsInDeck( new ArrayList<CardCounter>() );
	}
	
	public void addCard( UnitCard newCard, int count ) {
		if ( count <= 0 ) return;
		for ( CardCounter cardCounter : this.cardsInDeck ) {
			if ( cardCounter.getCard().equals( newCard )) {
				cardCounter.setCount( cardCounter.getCount() + count );
				return;
			}
		}
		this.cardsInDeck.add( new CardCounter( newCard, count ) );
	}
	
	public void removeCard( UnitCard toRemove, int count ) {
		if ( count <= 0 ) return;
		for ( CardCounter cardCounter : this.cardsInDeck ) {
			if ( cardCounter.getCard().equals( toRemove )) {
				cardCounter.setCount( cardCounter.getCount() - count);
				if ( cardCounter.getCount() <= 0 ) this.cardsInDeck.remove( cardCounter );
				return;
			}
		}
	}
	
	public int cardCount() {
		int total = 0;
		for ( CardCounter cardCounter : cardsInDeck ) total += cardCounter.getCount();
		return total;
	}
	
	public boolean existsInDeck( UnitCard card ) {
		for ( CardCounter cardCounter : cardsInDeck ) {
			if ( cardCounter.getCard().equals( card ) && cardCounter.getCount() >= 1 ) return true;
		}
		return false;
	}
	
	public boolean equals( UnitDeck other ) {
		return this.getDeckName().equals( other.getDeckName() );
	}
	
	public String getDeckName() {
		return this.deckName;
	}
	
	public ArrayList<CardCounter> getCardsInDeck() {
		return this.cardsInDeck;
	}
	
	public void setDeckName( String deckName ) {
		if ( deckName.isBlank() ) this.deckName = "Untitled Deck";
		else this.deckName = deckName;
	}
	
	public void setCardsInDeck( ArrayList<CardCounter> newCardsInDeck ) {
		this.cardsInDeck = newCardsInDeck;
	}
}
