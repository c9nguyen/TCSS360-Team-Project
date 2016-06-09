package Model;

import java.util.Iterator;
import java.util.TreeSet;

public class MainDriver {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		TreeSet<String> myCategory = new TreeSet<String>();
		
		myCategory.add("Table");
		myCategory.add("Chair");
 		myCategory.add("Lamp");
 		
 		
 		Iterator<String> it = myCategory.iterator();
 		
 		while (it.hasNext()) {
 			System.out.println(it.next());
 		}
	}

}
