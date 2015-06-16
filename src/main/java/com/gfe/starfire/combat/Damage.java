package com.gfe.starfire.combat;

public class Damage {
	private final Type type;
	private int amount;
	
	public Damage(final Type type, final int amount) {
		this.type = type;
		this.amount = amount;
	}
	
	public Type getType() {
		return type;
	}
	
	public int getAmount() {
		return amount;
	}
	
	public void setAmount(final int amount) {
		this.amount = amount;
	}
	
	public enum Type {
		NORMAL, LASER, ENERGY;
	}
}
