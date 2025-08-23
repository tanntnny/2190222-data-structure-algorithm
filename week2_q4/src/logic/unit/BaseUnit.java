package logic.unit;

import java.util.ArrayList;

public class BaseUnit {
	private int row, column;
	private boolean isWhite;
	private String name;
	protected int hp, power;
	protected boolean isFlying;
	
	public BaseUnit(int startColumn, int startRow, boolean isWhite, String name) {
		setPower(1);
		setFlying(false);
		setHp(2);
		setColumn(startColumn);
		setRow(startRow);
		setWhite(isWhite);
		setName(name);
	}
	
	public boolean move(int direction) {
		if (direction < 0 || direction > 3) return false;
		if (direction == 0) return setRow(getRow() + 1);
		else if (direction == 1) return setColumn(getColumn() + 1);
		else if (direction == 2) return setRow(getRow() - 1);
		else return setColumn(getColumn() - 1);
	}
	
	public void attack(ArrayList<BaseUnit> targetPieces) {
		for (BaseUnit target : targetPieces) {
			if (target.getRow() == getRow() && target.getColumn() == getColumn() && !target.isFlying()) {
				System.out.println(getName() + " attacks " + target.getName());
				target.setHp(target.getHp() - getPower());
			}
		}
	}

	public int getRow() {
		return row;
	}

	public boolean setRow(int row) {
		if (row < 0) {
			this.row = 0;
			return false;
		}
		else if (row > 4) {
			this.row = 4;
			return false;
		}
		else {
			this.row = row;
			return true;
		}
	}

	public int getColumn() {
		return column;
	}

	public boolean setColumn(int column) {
		if (column < 0) {
			this.column = 0;
			return false;
		}
		else if (column > 4) {
			this.column = 4;
			return false;
		}
		else {
			this.column = column;
			return true;
		}
	}

	public boolean isWhite() {
		return isWhite;
	}

	public void setWhite(boolean isWhite) {
		this.isWhite = isWhite;
	}

	public String getName() {
		return name;
	}

	public void setName(String nanme) {
		this.name = nanme;
	}

	public int getHp() {
		return hp;
	}

	public void setHp(int hp) {
		this.hp = hp;
	}

	public int getPower() {
		return power;
	}

	public void setPower(int power) {
		this.power = power;
	}

	public boolean isFlying() {
		return isFlying;
	}

	public void setFlying(boolean isFlying) {
		this.isFlying = isFlying;
	}
}
