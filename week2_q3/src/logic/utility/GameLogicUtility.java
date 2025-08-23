package logic.utility;

import logic.game.*;
import logic.card.*;

public class GameLogicUtility {
	public static boolean drawRule() {
		for (BaseCard card : GameLogic.getInstance().getHand()) {
			if (card.ruleCheck()) return false;
		}
		return true;
	}
}
