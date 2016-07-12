package heroes;

public class Assassin extends Hero{

	
	
	Assassin(String name, int intelligence, int vitality, int strength, int dexterity){
		setName(name);
		setVitality(vitality);
		setStrength(strength);
		setDexterity(dexterity);
		setAttackSpeed();
		setDmg();
	}
	
	private void setDmg(){
		this.dmg = (int)(this.getStrength()*1.5);
	}
	
	private void setAttackSpeed(){
		this.attackSpeed = (int)(this.getDexterity()*ATTACK_SPEED_MODIFIER);
	}
}
