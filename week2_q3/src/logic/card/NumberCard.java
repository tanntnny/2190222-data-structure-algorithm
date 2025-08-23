package logic.card;

import logic.game.*;

public class NumberCard extends BaseCard {
	public NumberCard(CardColor color, CardSymbol symbol) {
		super(color);
		setSymbol(symbol);
	}
	
	@Override
	public void play() {
		GameLogic.getInstance().setTopCard(this);
	}
	
	@Override
	public boolean ruleCheck() {
		return GameLogic.getInstance().getTopCard().getColor() == getColor() ||  
			   GameLogic.getInstance().getTopCard().getSymbol() == getSymbol();
	}
}
