/**
 * @author Tyler Beachnau
 * @since 2/26/2017
 * @version 0.1
 * CPS 410 - Group 1 project - Health Keeper
 * Subprogram: Blood Alcohol Calculator program
 * 
 * The Drink class represents an alcoholic drink. It is used to store a drink
 * and retrieve it's alcoholic content.
 * 
 * Key feature:
 * 1. Return the alcohol content of the drink.
 * 2. ANY TIME a change is made, updates the alcohol content (changing size/percentage yields recalculation of alcohol content)
 */


public class Drink {

	private float size;
	private float percentage;
	private float alcoholContent;
	
	/**
	 * Constructor
	 * @param size Size of the drink
	 * @param percentage Percentage of alcohol in the drink.
	 */
	public Drink(float size, float percentage){
		this.size = size;
		this.percentage = percentage;
		
		setAlcoholContent(size, percentage);
	}
	
	/**
	 * set method for size
	 * @param size (size of the drink in fluid ounces!)
	 */
	public void setSize(float size){
		this.size = size;
		setAlcoholContent(this.size, this.percentage);
	}
	
	/**
	 * set method for percentage
	 * @param percentage (percentage of alcohol for the drink, i.e. the proof / 2)
	 */
	public void setPercentage(float percentage){
		this.percentage = percentage;
		setAlcoholContent(this.size, this.percentage);
	}
	
	/**
	 * This method will set the alcohol content of this drink given parameters.
	 * @param size The size in fl oz of the drink
	 * @param percentage The percentage of alcohol per volume (abv)
	 * @return Return the alcohol content of the drink.
	 */
	public void setAlcoholContent(float size, float percentage){
		alcoholContent = size * percentage;
	}
	
	/**
	 * This method returns the alcohol content of this drink
	 * @return Return the alcohol content of this drink
	 */
	public float getAlcoholContent(){
		return alcoholContent;
	}

}
