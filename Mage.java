package heroes;

public class Mage extends Hero{

	
	int mana = (int)(getIntelligence()*MANA_MODIFIER);
	
	
	Mage(String name, int intelligence, int vitality, int strength, int dexterity){
		setName(name);
		setIntelligence(intelligence);
		setVitality(vitality);
		setStrength(strength);
		setDexterity(dexterity);
		setAttackSpeed();
		setDmg();
	}
	
	
	
	
	private void setAttackSpeed(){
		this.attackSpeed = (int)(this.getIntelligence()*ATTACK_SPEED_MODIFIER);
	}
	
	private void setDmg(){
		this.dmg = (int)(this.getIntelligence()*1.5);
	}
	
}
