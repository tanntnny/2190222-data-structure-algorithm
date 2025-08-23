package logic.unit;

public class FlyingUnit extends BaseUnit {
	public FlyingUnit(int startColumn,int startRow, boolean isWhite, String name) {
		super(startColumn, startRow, isWhite, name);
		setHp(2);
		setFlying(true);
	}
	
	@Override
	public boolean move(int direction) {
		if (direction < 0 || direction > 3) return false;
		if (direction == 0) return setRow(getRow() + 2);
		else if (direction == 1) return setColumn(getColumn() + 2);
		else if (direction == 2) return setRow(getRow() - 2);
		else return setColumn(getColumn() - 2);
	}
}
