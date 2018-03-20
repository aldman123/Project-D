package pokemon;

import java.util.Random;

abstract class Pokemon {
	final private int HP_IV, Def_IV, Atk_IV, SDef_IV, SAtk_IV, Speed_IV;
	final protected int HP_BASE, Def_BASE, Atk_BASE, SDef_BASE, SAtk_BASE, Speed_BASE;
	private int HP, def, atk, sDef, sAtk, speed, level;
	
	public Pokemon(int HP_BASE, int Def_BASE, int Atk_BASE, int SDef_BASE, int SAtk_BASE, int Speed_BASE, int level) {
		this.level = level;
		
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
	
	public int getHP() {
		return HP;
	}


	public void setHP(int hP) {
		HP = hP;
	}


	public int getDef() {
		return def;
	}


	public void setDef(int def) {
		this.def = def;
	}


	public int getAtk() {
		return atk;
	}


	public void setAtk(int atk) {
		this.atk = atk;
	}


	public int getsDef() {
		return sDef;
	}


	public void setsDef(int sDef) {
		this.sDef = sDef;
	}


	public int getsAtk() {
		return sAtk;
	}


	public void setsAtk(int sAtk) {
		this.sAtk = sAtk;
	}


	public int getSpeed() {
		return speed;
	}


	public void setSpeed(int speed) {
		this.speed = speed;
	}
	
}
