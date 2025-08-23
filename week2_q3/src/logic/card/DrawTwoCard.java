package logic.card;

import logic.game.*;

public class DrawTwoCard extends BaseCard {
	public DrawTwoCard(CardColor color) {
		super(color);
		setSymbol(CardSymbol.DRAW);
	}
	
	@Override
	public void play() {
		GameLogic.getInstance().setTopCard(this);
		GameLogic.getInstance().draw(2);
	}
	
	@Override
	public boolean ruleCheck() {
		return GameLogic.getInstance().getTopCard().getColor() == this.getColor();
	}
}
