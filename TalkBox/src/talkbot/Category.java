package talkbot;

import java.util.ArrayList;

public class Category {
	
	private ArrayList<Buttons> myButtons = new ArrayList<Buttons>();
	private String name;
	/** A Preset Is an arrayList of buttons. 
	 * It contains the buttons, the number of buttons, as well as the ability to remove buttons and add buttons.
	 * 
	 * This Preset Constructor requires an ArrayList of buttons of at least size one, as well as a name to properly construct. 
	 */
	public Category(String inName, ArrayList<Buttons> input)
	{
		name = inName;
		for(Buttons B : input)
		{
			myButtons.add(B);
		}
	}
	/**
	 * A Preset Is an arrayList of buttons. 
	 * It contains the buttons, the number of buttons, as well as the ability to remove buttons and add buttons.
	 * 
	 * This Constructor does not require any ArrayList, but does require a name to work Properly
	 */
	public Category(String inName) 
	{
		name = inName;
	}
	public ArrayList<Buttons> GetButtons()
	{
		return myButtons;
		
	}
	public int GetButtonNum()
	{
		return myButtons.size();
	}
	/**
	 * adds a button to the list at the specified location. 
	 * If no location is specified, places button at the end of the list
	 * @param location
	 * @param button
	 */
	public void AddButton(int location, Buttons button)
	{
		myButtons.add(location, button);		
	}
	public void AddButton(Buttons button)
	{
		myButtons.add(button);
	}
	
	/**
	 * Removes button based on their location in the array
	 * @param location
	 */
	public void RemoveButton(int location)
	{
		myButtons.remove(location);
	}
	/**
	 * Removes buttons based on the button selected
	 * @param button
	 */
	public void RemoveButton(Buttons button)
	{
		myButtons.remove(button);
	}
	/** returns the name of the preset
	 * 
	 * @return name
	 */
	public String GetName()
	{
		return name;
	}
	/** sets the name of the preset to the input string
	 * 
	 * @param inName
	 */
	public void SetName(String inName)
	{
		name = inName;
	}

}
