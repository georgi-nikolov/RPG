package items;

import heroes.*;
import interfaces.Droppable;


public abstract class Item implements Droppable{
	// requirements to equip
	protected int minLevel;
	protected int minStrength;
	protected int minIntelligence;
	protected int durability;
	protected int armorValue;
	protected String name;
	
	public int getArmorValue(){
		return this.armorValue;
	}
	
	public int getDurability(){
		return this.durability;
	}
	
	public void setDurability(int durability){
		if(durability > 0)
		this.durability = durability;
	}
	
	void setName(String name){
		if(name != null && !(name.isEmpty()))
			this.name = name;
	}
	
	void setMinLevel(int minLevel){
		if(minLevel > 0)
			this.minLevel = minLevel;
	}
	
	void setMinStrength(int minStrength){
		if(minStrength > 0)
			this.minStrength = minStrength;
	}
	
	void setMinIntelligence(int minIntelligence){
		if(minIntelligence > 0)
			this.minIntelligence = minIntelligence;
	}
	
	
	public void putItemInBag(Hero hero){
		for (int i = 0; i < hero.itemsInBag.length; i++) {
			if(hero.itemsInBag[i] == null){
				hero.itemsInBag[i] = this;
				break;
			}
		}
	}
	
	
}
