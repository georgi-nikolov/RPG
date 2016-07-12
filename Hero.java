package heroes;

import java.util.Random;

import items.*;
import monsters.*;;

public abstract class Hero {
	
	static final int BASE_DMG = 1;
	static final int HP_MODIFIER = 12;//*vitality
	static final int MANA_MODIFIER = 12;//*intelligence
	static final double ATTACK_SPEED_MODIFIER = 2.5;//*dexterity or *intelligence
	static final int BLOCK_MODIFIER = 2;
	static final int DODGE_MODIFIER = 3;
	static final double BLOCK_DMG_MODIFIER = 0.5;
	static final double REDUCE_DMG_FOR_ARMOR_COEFF = 0.75;
	
	String name;
	
	private int strength;
	private int intelligence;
	private int vitality;
	private int dexterity;
	private int level = 1;
	private int hp = this.vitality*HP_MODIFIER;
	private int armor = 0;
	protected int dmg;
	protected int attackSpeed;
	private int xp;
	private Gold gold;
	private Monster enemy;
	
	public Item[] itemsInBag;
	public Item[] itemsEquipped;
	
	void setName(String name){
		if(!(name.isEmpty()) && name != null && this.name == null){
			this.name = name;
		}
	}
	void setIntelligence(int intelligence){
		if(intelligence > 0)
			this.intelligence = intelligence;
	}
	
	public String getName() {
		return name;
	}
	public int getStrength() {
		return strength;
	}
	public int getVitality() {
		return vitality;
	}
	public int getDexterity() {
		return dexterity;
	}
	public int getLevel() {
		return level;
	}
	public int getHp() {
		return hp;
	}
	public int getArmor() {
		return armor;
	}
	public int getDmg() {
		return dmg;
	}
	public int getAttackSpeed() {
		return attackSpeed;
	}
	public int getXp() {
		return xp;
	}
	public void setXp(int xp) {
		this.xp += xp;
	}
	public int getGold() {
		return gold.getAmmount();
	}
	public void setGold(Gold gold){
		gold.setAmmount(gold.getAmmount() + this.gold.getAmmount());
	}
	public Monster getEnemy() {
		return enemy;
	}
	void setEnemy(Monster enemy){
		if(enemy != null)
			this.enemy = enemy;
	}
	
	void setDexterity(int dexterity){
		if (dexterity > 0)
			this.dexterity = dexterity;
	}
	void setStrength(int strength){
		if(strength > 0)
			this.strength = strength;
	}
	
	void setVitality(int vitality){
		if(vitality > 0)
			this.vitality = vitality;
	}
	public void attack(){
		//attack
		// use certain skill and multiply dmg by SKILL_DMG_MODIFIER
	}
	
	
	private boolean getChance(int modifier){
		Random r = new Random();
		int rand = r.nextInt(modifier);
		return rand == 1;
	}
	
	public void hit(){
		if(this.enemy != null){
			if(enemy.Monsterblock()){
				enemy.monsterTakeHit((int)(this.dmg*BLOCK_DMG_MODIFIER));
				System.out.println(this.name + " hits " + enemy.getMonsterName() + " for " + this.dmg + " dmg");
				System.out.println(enemy.getMonsterName() + " blocks the hit");
				System.out.println(enemy.getMonsterName() + "s HP is " + enemy.getMonsterHp());
				System.out.println("----------------");
			}
			else if(enemy.MonsterDodge()){
				System.out.println(this.name + " tries to hit " + enemy.getMonsterName() + " for " + this.dmg + " dmg");
				System.out.println(enemy.getMonsterName() + " dodges the hit!");
				System.out.println(enemy.getMonsterName() + "s HP is " + enemy.getMonsterHp());
				System.out.println("----------------");
				
			}
			else{
				enemy.monsterTakeHit(this.dmg);
				System.out.println(this.name + " hits " + enemy.getMonsterName() + " for " + this.dmg + " dmg");
				System.out.println(enemy.getMonsterName() + "s HP is " + enemy.getMonsterHp());
				System.out.println("----------------");
			}
		}
	}
	
	
	public void takeHit(int dmg){
		if(this.armor>0){
			dmg -= (int)(dmg*(REDUCE_DMG_FOR_ARMOR_COEFF));
			reduceDurability(this);
		}
		this.hp -= dmg;
	}
	
	public boolean dodge(){
		return getChance(DODGE_MODIFIER);
	}
	
	public boolean block(){
		return getChance(BLOCK_MODIFIER);
	}
	
	public boolean isHeroDead(){
		return this.hp <=0;
	}
	
	public boolean isMonsterDead(){
		return ((Monster) this.enemy).getMonsterHp() <=0;
	}
	
	
	
	//public void dodge(){
		//override with chance based on hero class
		//higher for assassin, lower for mage,priest, lowest for warrior
	//}
	
	//public void block(){
		//override for warrior with change cuz of shield
		//override for all other classes not to block
	//}
	
	void lvlUp(){
		if(this.xp >= 1000){
			this.level++;
			this.xp = 0;
		}
	}
	
	
	public int getIntelligence() {
		return intelligence;
	}
	public void setAttackSpeed(int attackSpeed) {
		this.attackSpeed = attackSpeed;
	}
	public void reduceArmor(int armorValue) {
		this.armor -= armorValue;
	}
	public void reduceDurability(Hero hero){
		// recude all items durability upon taking a hit
		// if an item is with 0 durability remove its armor value from total hero armor value
		for (int i = 0; i < hero.itemsEquipped.length; i++) {
			if(hero.itemsEquipped[i] != null){
				hero.itemsEquipped[i].setDurability(hero.itemsEquipped[i].getDurability()-1);
				if(hero.itemsEquipped[i].getDurability() <= 0)
					hero.reduceArmor(hero.itemsEquipped[i].getArmorValue());
			}
			else
				continue;
		}
	}
	
}
