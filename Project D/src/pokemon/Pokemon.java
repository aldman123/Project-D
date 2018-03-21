package pokemon;

import java.util.Random;

import misc.*;

abstract class Pokemon {
	final private double STAB_MODIFIER = 1.5;
	
	
	final private int HP_IV, Def_IV, Atk_IV, SDef_IV, SAtk_IV, Speed_IV;
	final protected int HP_BASE, Def_BASE, Atk_BASE, SDef_BASE, SAtk_BASE, Speed_BASE;
	private int HP, def, atk, sDef, sAtk, speed, level;
	final private Type typeA, typeB;
	final private boolean twoTypes;
	private boolean knockedOut;
	
	
	
	public Pokemon(int HP_BASE, int Def_BASE, int Atk_BASE, int SDef_BASE, int SAtk_BASE, int Speed_BASE,
			int level, Type typeA, Type typeB) {
		twoTypes = (typeB != null && typeA != null) && (typeB == Type.NORMAL && typeA != Type.NORMAL);
		
		this.knockedOut = false;
		this.level = level;
		this.typeA = typeA;
		this.typeB = typeB;
		
		this.HP_BASE = HP_BASE;
		this.Def_BASE = Def_BASE;
		this.Atk_BASE = Atk_BASE;
		this.SDef_BASE = SDef_BASE;
		this.SAtk_BASE = SAtk_BASE;
		this.Speed_BASE = Speed_BASE;
		
		Random generator = new Random();
		this.HP_IV = generator.nextInt(16);
		this.Def_IV = generator.nextInt(16);
		this.Atk_IV = generator.nextInt(16);
		this.SDef_IV = generator.nextInt(16);
		this.SAtk_IV = generator.nextInt(16);
		this.Speed_IV = generator.nextInt(16);
		
		this.updateStats();
		
	}

	public void updateStats() {
		this.calculateStat(this.HP, this.HP_BASE, this.HP_IV, this.level, true);
		this.calculateStat(def, Def_BASE, Def_IV, level, false);
		this.calculateStat(atk, Atk_BASE, Atk_IV, level, false);
		this.calculateStat(def, Def_BASE, Def_IV, level, false);
		this.calculateStat(sAtk, SAtk_BASE, SAtk_IV, level, false);
		this.calculateStat(sDef, SDef_BASE, SDef_IV, level, false);
		this.calculateStat(speed, Speed_BASE, Speed_IV, level, false);
	}
	
	private void calculateStat(int stat, int base, int iv, int level, boolean isHP) {
		stat = 2*(base + iv) * level / 100 + level + 5;
		if (isHP) {
			stat += 5;
		}
		return;
	}
	
	public void doDamage(Pokemon opponent, int power, Type type) {
		double modifier = type.against(typeA);
		if (twoTypes) {
			modifier *= type.against(typeB);
		}
		
		Random generator = new Random();
		if (opponent.getSpeed()/2 >= generator.nextInt(256)) {
			modifier *= 2;
		}
		
		modifier *= opponent.getSTAB(type);
		
		int damage = (int) Math.round((((2*this.level)/5 + 2)/50 * power * opponent.atk * this.def + 2) * modifier);
		
		this.HP -= damage;
		if (this.HP < 0) {
			this.HP = 0;
			this.knockedOut = true;
		}
		return;
	}
	
	public int getHP() {
		return HP;
	}

	public boolean getKnockedOut() {
		return this.knockedOut;
	}
	
	public int getDef() {
		return def;
	}


	public int getAtk() {
		return atk;
	}
	
	public double getSTAB(Type type) {
		if ( (type == this.typeA && typeA != Type.NORMAL) || (typeB == type && typeB != Type.NORMAL) ) {
			return STAB_MODIFIER;
		} else {
			return 1;
		}
	}

	public int getsDef() {
		return sDef;
	}

	public int getsAtk() {
		return sAtk;
	}

	public int getSpeed() {
		return speed;
	}
	
}
