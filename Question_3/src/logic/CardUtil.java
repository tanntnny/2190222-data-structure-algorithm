package logic;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;

public class CardUtil {

	public static boolean isExistsInList(UnitCard card, ArrayList<UnitCard> list) {
		for ( UnitCard listCard : list ) {
			if ( listCard.equals( card ) ) return true;
		}
		return false;

	}
	
	public static boolean isExistsInList(UnitDeck deck, ArrayList<UnitDeck> list) {
		for ( UnitDeck listDeck : list ) {
			if ( listDeck.equals( deck ) ) return true;
		}
		return false;

	}
	
	public static boolean cardExistsInDeckList(ArrayList<UnitDeck> deckList, UnitCard cardToTest) {
		for ( UnitDeck deck : deckList ) {
			for ( CardCounter counter : deck.getCardsInDeck() ) {
				if ( counter.getCard().equals( cardToTest ) ) return true;
			}
		}
		return false;
	}
	
	public static ArrayList<UnitCard> getCardsFromFile(String filename){
		try {
			File fileToRead = new File(filename);
			ArrayList<UnitCard> cardsFromFile = new ArrayList<UnitCard>();
			Scanner reader = new Scanner(filename);
			while ( reader.hasNextLine() ) {
				String line = reader.nextLine();
				String splitedLine[] = line.split(",");
				try {
					UnitCard card = new UnitCard(
							splitedLine[0],
							Integer.parseInt(splitedLine[1]),
							Integer.parseInt(splitedLine[2]),
							Integer.parseInt(splitedLine[3]),
							splitedLine[4]
					);
					cardsFromFile.add( card );
				} catch ( Exception e ) {
					reader.close();
					return null;
				}
			}
			reader.close();
			return cardsFromFile;
		} catch ( Exception e ) {
			return null;
		}
	}

	public static void printCardList(ArrayList<UnitCard> cardList, boolean verbose) {
		
		for(int i = 0; i < cardList.size(); i++) {
			System.out.println(i + ") " + cardList.get(i));
			if(verbose) {
				System.out.println("Blood Cost: " + cardList.get(i).getBloodCost());
				System.out.println(cardList.get(i).getFlavorText());
				if(i < cardList.size()-1) System.out.println("-----");
			}
		}
	}
	
	public static void printDeck(UnitDeck ud) {
		
		if(ud.getCardsInDeck().size() == 0) {
			System.out.println("EMPTY DECK");
		}else {
			for(CardCounter cc : ud.getCardsInDeck()) {
				System.out.println(cc);
			}
		}
		
		System.out.println("Total Cards: " + ud.cardCount());
	}
	
	public static void printDeckList(ArrayList<UnitDeck> deckList) {
		
		
		for(int i = 0; i < deckList.size(); i++) {
			System.out.println(i + ") " + deckList.get(i).getDeckName());
			printDeck(deckList.get(i));
			if(i < deckList.size()-1) System.out.println("-----");
		}
	}
}
