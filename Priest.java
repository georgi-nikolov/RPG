package heroes;

public class Priest extends Hero{

	int mana = (int)(this.getIntelligence()*MANA_MODIFIER);
	
	
	Priest(String name, int intelligence, int vitality, int strength, int dexterity){
		setName(name);
		setIntelligence(intelligence);
		setVitality(vitality);
		setStrength(strength);
		setDexterity(dexterity);
		setAttackSpeed();
		setDmg();
	}
	
	
	
	private void setDmg(){
		this.dmg = (int)(this.getIntelligence()*1.5);
	}
	
	private void setAttackSpeed(){
		this.attackSpeed = (int)(this.getIntelligence()*ATTACK_SPEED_MODIFIER);
	}
}
