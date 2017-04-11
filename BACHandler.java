/**
 * 
 * @author Tyler Beachnau
 * @since 4/11/2017
 * @version 0.1
 * 
 * CPS 410 - Group 1 project - Health Keeper
 * Subprogram: Blood Alcohol Calculator program
 * 
 * The BACHandler class is the front-end class interacting with the GUI.
 * It serves as a mediator between the GUI and the BACCalculator.
 * 
 * Features:
 * 1. Error checking (ensuring drinks are correct, weight, removing drinks are valid, etc)
 * 2. Sending data to BACCalculator program (including Drink objects).
 * 3. Calling BACCalculator methods and serving as a source for data for the GUI.
 *
 */

package healthkeeper;

public class BACHandler {

	private BACCalculator BACCalculator;
	private int drinkTotal;
	private float weight;
	private boolean sex;
	private float hoursElapsed;
	
	public BACHandler(){
		BACCalculator = new BACCalculator();
		drinkTotal = 0;
		weight = 68.03f;
		sex = true;
		hoursElapsed = 0.0f;
	}
	
	public void setWeight(float weight){
		this.weight = weight;
	}
	
	public void setSex(boolean sex){
		this.sex = sex;
	}
	
	/**
	 * Adds a new drink to our calculator
	 * @param size
	 * @param percentage
	 */
	public void addDrink(float size, float percentage){
		//TO-DO: IMPLEMENT ERROR CHECKING
		
		Drink newDrink = new Drink(size, percentage);
		BACCalculator.addDrink(newDrink);
		
		drinkTotal++;
	}
	
	public void removeDrink(int index){
		//TO-DO: IMPLEMENT MORE ROBUST ERROR CHECKING, ACCORDING TO GUI DESIGN
		if(index < 0 || index > drinkTotal-1){
			//do not remove, no more drinks to remove or bad index
		} else {
			BACCalculator.removeDrink(index);
			drinkTotal--;
		}
	}
	
	public float calculateBAC(){
		//TO-DO: Change, allow error checking???
		BACCalculator.calculateBAC(weight, sex, hoursElapsed);
		return BACCalculator.getBAC();
	}
	
	public void clearDrinks(){
		if(drinkTotal != 0)
			BACCalculator.clearDrinks();
	}
}
