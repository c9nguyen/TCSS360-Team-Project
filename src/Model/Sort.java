package Model;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * Sorts submissions by categories
 * Name, Age, Category
 * @author dhruv
 *
 */
public class Sort {

	Submission currentSubmission;
	
	ArrayList<Submission> tableList;
	
	ArrayList<Submission> lampList;
	
	ArrayList<Submission> ageList;
	
	ArrayList<Submission> chairList;
	
	
	/**
	 * Constructor. 
	 * @param initialList the list given the first time the class is used. 
	 */
	public Sort(ArrayList<Submission> initialList) {
		setup(initialList);		
	}
	/**
	 * Sets up the class items.
	 */
	private void setup(ArrayList<Submission> list) {
		lampList = list;
		ageList = list;
		chairList = list;
		tableList = list;
	}
	/**
	 * Sorts the list by age
	 * @param theSwitch whether or not to sort the unsorted list or the ageSort list
	 * valid states: 1 OR 0
	 */
	public void sortByAge() {
		int initAge;
		int pos = 0;
		Submission temp;
		for (int i = 0; i < ageList.size(); i++) {

			initAge = ageList.get(i).getAge();
			//Starting at i, and until the end of the list..
			for(int j = i+1; j < ageList.size(); j++) {

				int tempAge = ageList.get(j).getAge();

				if(tempAge < initAge) {
					//Remember the Position of the submission
					//and make tempAge the new initAge.
					pos = j;
					initAge = tempAge;
					//Set the Submission at i to the submission we found with the smaller
					//age. 
					temp = ageList.get(i);
					ageList.set(i, ageList.get(pos));
					ageList.set(pos, temp);
					//Repeat until the end of the list. 
				}
			}

		}
	}
	/**
	 * Sorts the list by a certain category
	 * @param theCategory the category to sort by
	 */
	public void sortByCategory(String theCategory) {
		if (theCategory.equalsIgnoreCase("chair")) {
			int pos = 0, listPos = 0;
			Submission temp;
			for (int i = 0; i < chairList.size(); i++) {
				for(int j = i; j < chairList.size(); j++) {
					String tempString = chairList.get(j).getCategory();
					if(!(listPos == j) && tempString.equalsIgnoreCase(theCategory)) {
						//Remember the Position of the submission
						pos = j;
						//Set the Submission at i to the submission we found with the same category
						temp = chairList.get(i);
						chairList.set(i, chairList.get(pos));
						chairList.set(pos, temp);
						listPos++;
						//Repeat until the end of the list. 
					}
				}
				
			}
		} else if (theCategory.equalsIgnoreCase("table")) {
			String table;
			int pos = 0, listPos = 0;
			Submission temp;
			for (int i = 0; i < tableList.size(); i++) {
				for(int j = i; j < tableList.size(); j++) {
					String tempString = tableList.get(j).getCategory();
					if(!(listPos == j) && tempString.equalsIgnoreCase(theCategory)) {
						//Remember the Position of the submission
						pos = j;
						//Set the Submission at i to the submission we found with the same category
						temp = tableList.get(i);
						tableList.set(i, tableList.get(pos));
						tableList.set(pos, temp);
						listPos++;
						//Repeat until the end of the list. 
					}
				}
				
			}
		} else if (theCategory.equalsIgnoreCase("lamp")) {
			String lamp;
			int pos = 0, listPos = 0;
			Submission temp;
			for (int i = 0; i < lampList.size(); i++) {
				for(int j = i; j < lampList.size(); j++) {
					String tempString = lampList.get(j).getCategory();
					if(!(listPos == j) && tempString.equalsIgnoreCase(theCategory)) {
						//Remember the Position of the submission
						pos = j;
						//Set the Submission at i to the submission we found with the same category
						temp = lampList.get(i);
						lampList.set(i, lampList.get(pos));
						lampList.set(pos, temp);
						listPos++;
						//Repeat until the end of the list. 
					}
				}
				
			}
		} 
	}
	
	private ArrayList<Submission> sortThisList(ArrayList<Submission> list) {
	
		
		return list;
	}
}
