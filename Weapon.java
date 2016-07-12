package items;

import heroes.Hero;
import interfaces.Wearable;

public abstract class Weapon extends Item implements Wearable{

	protected int intelligenceValue;
	protected int strengthValue;
	protected int vitalityValue;
	protected int dexterityValue;
	
	public int getIntelligenceValue() {
		return intelligenceValue;
	}

	public void setIntelligenceValue(int intelligenceValue) {
		if(intelligenceValue > 0)
		this.intelligenceValue = intelligenceValue;
	}

	public int getStrengthValue() {
		return strengthValue;
	}

	public void setStrengthValue(int strengthValue) {
		if(strengthValue > 0)
		this.strengthValue = strengthValue;
	}

	public int getVitalityValue() {
		return vitalityValue;
	}

	public void setVitalityValue(int vitalityValue) {
		if(vitalityValue > 0)
		this.vitalityValue = vitalityValue;
	}

	public int getDexterityValue() {
		return dexterityValue;
	}

	public void setDexterityValue(int dexterityValue) {
		if(dexterityValue > 0)
		this.dexterityValue = dexterityValue;
	}


	public void unEquipItem(Hero hero){
		for (int i = 0; i < hero.itemsEquipped.length; i++) {
			if(hero.itemsEquipped[i] != null){
				if(hero.itemsEquipped[i] == this){
					hero.itemsEquipped[i] = null;
					break;
				}	
			}
			else
				continue;
		}
	}
	
	public void equipItem(Hero hero) {
		if (this.minIntelligence > hero.getIntelligence() || this.minLevel > hero.getLevel()
				|| this.minStrength > hero.getStrength()) {
			System.out.println("The hero does not fullfil the requirements to wear this item.");
		} else {
			for (int i = 0; i < hero.itemsEquipped.length; i++) {
				if (hero.itemsEquipped[i] == null)
					hero.itemsEquipped[i] = this;
			}
		}
	}
}
