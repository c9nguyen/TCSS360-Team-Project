package Model;

import java.util.HashSet;

/**
 * Class that manages all data flows in the program.
 *
 */
//I named it DataManager instead of Database so wont get confuse with real Database
// You guys can change if you dont like it.
public class DataManager {
	private HashSet<String> myCategory;
	
 	public DataManager() {
 		myCategory = new HashSet<String>();
 		
// 		myCategory.add(Category.CHAIR.getName());
// 		myCategory.add(Category.TABLE.getName());
// 		myCategory.add(Category.LAMP.getName());
 	
 		
 	}
}
