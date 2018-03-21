package moves;

import misc.Type;

public abstract class Move {
	final int damage;
	final String name;
	final Type type;
	public Move(int damage, String name, Type type) {
		this.damage = damage;
		this.name = name;
		this.type = type;
	}
	
	public Type getType() {
		return type;
	}
	
	public String toString() {
		return name;
	}
	
	public int getDamage() {
		return damage;
	}
	
}
