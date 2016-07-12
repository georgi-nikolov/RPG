package monsters;

import java.util.Random;

import heroes.*;
import items.*;


public abstract class Monster {

	static final int BASE_DMG = 1;
	static final int HP_MODIFIER = 12;//*vitality
	static final int MANA_MODIFIER = 12;//*intelligence
	static final double ATTACK_SPEED_MODIFIER = 2.5;//*dexterity or *intelligence
	static final int BLOCK_MODIFIER = 2;
	static final int DODGE_MODIFIER = 3;
	static final double BLOCK_DMG_MODIFIER = 0.5;
	static final double REDUCE_DMG_FOR_ARMOR_COEFF = 0.75;
	
	private String name;
	
	private int strength;
	private int intelligence;
	private int vitality;
	private int dexterity;
	private int level;
	private int hp = this.vitality*HP_MODIFIER;
	protected int dmg;
	protected int attackSpeed;
	private int xp;
	private Gold gold;
	private Hero enemy;	
	
	
	
	private boolean getChance(int modifier){
		Random r = new Random();
		int rand = r.nextInt(modifier);
		return rand == 1;
	}
	
	public void hit(){
		if(this.enemy != null){
			if(enemy.block()){
				enemy.takeHit((int)(this.dmg*BLOCK_DMG_MODIFIER));
				System.out.println(this.getMonsterName() + " hits " + enemy.getName() + " for " + this.dmg + " dmg");
				System.out.println(enemy.getName() + " blocks the hit");
				System.out.println(enemy.getName() + "s HP is " + enemy.getHp());
				System.out.println("----------------");
			}
			else if(enemy.dodge()){
				System.out.println(this.getMonsterName() + " tries to hit " + enemy.getName() + " for " + this.dmg + " dmg");
				System.out.println(enemy.getName() + " dodges the hit!");
				System.out.println(enemy.getName() + "s HP is " + enemy.getHp());
				System.out.println("----------------");
				
			}
			else{
				enemy.takeHit(this.dmg);
				System.out.println(this.getMonsterName() + " hits " + enemy.getName() + " for " + this.dmg + " dmg");
				System.out.println(enemy.getName() + "s HP is " + enemy.getHp());
				System.out.println("----------------");
			}
		}
	}
	
	
	
	
	public boolean MonsterDodge(){
		return getChance(DODGE_MODIFIER);
	}
	
	public boolean Monsterblock(){
		return getChance(BLOCK_MODIFIER);
	}
	
	public void giveXpToHero(){
		enemy.setXp(this.xp);
	}
	//public void Hit(){
			//check if dodge
			//check if block
			// if armor > 0 reduce dmg by 33%
			// reduce hp by given dmg (modified if armor > 0)
			// reduce all item durability by 2
			// if durability <=0 takeoff(item)
		//}

	public int getMonsterHp() {
		return hp;
	}

	public void setMonsterHp(int hp) {
		if(hp > 0)
		this.hp = hp;
	}

	public String getMonsterName() {
		return name;
	}

	public void setName(String name) {
		if(name != null && !name.isEmpty())
		this.name = name;
	}

	public void monsterTakeHit(int dmg) {
		this.setMonsterHp(this.getMonsterHp() - dmg);
		
	}

	
}
