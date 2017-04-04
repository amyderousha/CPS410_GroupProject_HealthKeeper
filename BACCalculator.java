import java.util.LinkedList;

/**
 * @author Tyler Beachnau
 * @since 2/26/2017
 * @version 0.1
 * 
 * CPS 410 - Group 1 project - Health Keeper
 * Subprogram: Blood Alcohol Calculator program
 * 
 * The BACCalculator class represents the calculation functions for the BAC program.
 * The handler passes data and calls methods to this class.
 * 
 * Features:
 * 1. Drink list, holding a list of ALL the alcoholic drinks the user has added
 * 2. Addition and Removal of drinks (including clearing of drink list).
 * 3. Calculation of BAC via all drinks in it's list.
 */


public class BACCalculator {

	private LinkedList<Drink> drinks = new LinkedList<Drink>();
	private float bac = 0.0f;
		
	/**
	 * Add a new drink to the end of the drink list.
	 * @param drink, an object of the Drink class, representing an alcoholic drink.
	 */
	public void addDrink(Drink drink){
		drinks.add(drink);
	}
	
	/**
	 * Clear the drinks in the drink list.
	 */
	public void clearDrinks(){
		drinks.clear();
	}
	
	/**
	 * Remove drink based on index (1 = first drink, 2 = second drink, n = last drink) 
	 * @param index
	 */
	public void removeDrink(int index){
		drinks.remove(index - 1);
	}
	
	/**
	 * Return BAC based on the formula: %BAC = (A x 5.14 / W x r) - .015 x H
	 * A = alcohol content sum
	 * W = Weight of the user
	 * r = sex constant (.66 for female, .73 for male)
	 * H = hours elapsed, i.e. 1 hour means H = 1.0, 1 hour and fifteen minutes means H = 1.25, etc
	 * 
	 * @param weight The weight of the "user" given in grams.
	 * @param sex The biological sex of the person (female = true, male = false)
	 * @return The BAC of the user, based on sex, weight, and drinks consumed
	 */
	public float calculateBAC(float weight, boolean sex, float hoursElapsed){
		
		//begin with gender constant tied to male
		double sexConstant = .73;
		
		//if female (true), change sex constant to appropriate value
		if(sex){
			sexConstant = .66;
		}
		
		double bacSum = 0.0;
		for(Drink d: drinks){
			bacSum += d.getAlcoholContent();
		}
		
		this.bac = (float)((bacSum * 5.14 / weight * sexConstant) - .015 * hoursElapsed);
		
		if(this.bac < 0.0)
			this.bac = 0.0f;
		
		return this.bac;
	}
	
	/**
	 * 
	 * @return Return BAC stored in the BACCalculator
	 */
	public float getBAC(){
		return bac;
	}
}
