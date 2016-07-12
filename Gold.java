package items;

import interfaces.Droppable;
import heroes.*;

public class Gold implements Droppable{

	protected int ammount;
	
	
	Gold(int ammount){
		this.ammount = ammount;
	}
	
	public int getAmmount(){
		return this.ammount;
	}
	
	public void setAmmount(int ammount){
		if(ammount > 0)
			this.ammount = ammount;
	}
	
	
	@Override
	public void drop() {
		Gold gold = new Gold(5);
		
	}

	
}
