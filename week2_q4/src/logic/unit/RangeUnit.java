package logic.unit;

import java.util.ArrayList;

public class RangeUnit extends BaseUnit {
	public RangeUnit(int startColumn,int startRow, boolean isWhite, String name) {
		super(startColumn, startRow, isWhite, name);
		setHp(2);
	}
	
	@Override
	public void attack(ArrayList<BaseUnit> targetPieces) {
		for (BaseUnit target : targetPieces) {
			if (this.isWhite() && target.getRow() - getRow() == 1 && target.getColumn() == getColumn()) {
				System.out.println(getName() + " attacks " + target.getName());
				target.setHp(target.getHp() - getPower());
			}
			else if (!this.isWhite() && target.getRow() - getRow() == -1 && target.getColumn() == getColumn()) {
				System.out.println(getName() + " attacks " + target.getName());
				target.setHp(target.getHp() - getPower());
			}
		}
	}
}
