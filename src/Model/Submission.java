package Model;

// TCSS 360 - Team Project

import java.io.File;
import java.util.Random;

/**
 * Manages a single user entry submission.
 * @author tryHARD
 * @version 5/19/2016
 */
public class Submission {

	private static final int AGE_RANGE = 90;
	
	private static final int AGE_BUFFER = 4;
	
	private static final Random RAND = new Random();
	
	private int myID; // ID of user
	
	private String myName; // Submission name
	
	private String myCategory; // Submission category
	
	private int myAge; //  Submission age
	
	private File myImage; // Picture of submission
	
	// Constructs a submission with no information.
	public Submission() {
		this(0, "", "", null);
	}
	
	// Constructs a submission with name, category and image.
	public Submission(int theID, String theName, String theCategory, File theImage) {
		myID = theID;
		myName = theName;
		myCategory = theCategory;
		myImage = theImage;
		myAge = RAND.nextInt(AGE_RANGE) + AGE_BUFFER; 
	}
	
	// Sets the ID associated with the submission.
	public void setID(int theID) {
		myID = theID;
	}
	
	// Sets the name of the submission.
	public void setName(String theName) {
		myName = theName;
	}
	
	// Sets the category of the submission.
	public void setCategory(String theCategory) {
		myCategory = theCategory;
	}
	
	// Sets the image of the submission.
	public void setImage(File theImage) {
		myImage = theImage;
	}
	
	// Sets the age of the submission user
	public void setAge(int theAge) {
		myAge = theAge;
	}
	
	// Gets the ID associated with the submission.
	public int getID() {
		return myID;
	}
	
	// Gets the name of the submission.
	public String getName() {
		return myName;
	}
	
	// Gets the category of the submission.
	public String getCategory() {
		return myCategory;
	}
	
	// Gets the image of the submission.
	public File getImage() {
		return myImage;
	}
	
	// Gets the age of user.
	public int getAge() {
		return myAge;
	}
	
}
