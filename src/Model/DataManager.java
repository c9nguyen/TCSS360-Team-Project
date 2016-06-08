package Model;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Class that manages all data flows in the program.
 *
 */
public class DataManager {

	private int myID;
	
	private String myPassword;
	
	
	/**
	 * Constructs an object to manipulate submissions in database.
	 */
 	public DataManager() {
 		myID = 0;
 		myPassword = null;
 	}
 	
	/**
	 * Adds the given submissions to the database.
	 * @param theSubmission Takes a submission and adds it to the database.
	 * @throws IOException 
	 */
	public void addSubmission(Submission theSubmission) throws IOException {
		int ID = theSubmission.getID();
		if (this.containsSubmission()) return;
		String name = theSubmission.getName();
		String category = theSubmission.getCategory();
		int age = theSubmission.getAge();
		File file = theSubmission.getImage();
		String image = file.getName();
		String info = ID + " " + name + " " + age + " " + category + " " + image;
		try {
		    Files.write(Paths.get("submissions.txt"), (info + "\n").getBytes(), StandardOpenOption.APPEND);
		}catch (IOException e) {
		    throw new FileNotFoundException();
		}
	}
 	
	/**
	 * Uses submission ID to remove a submission.
	 * @param theID The submission ID 
	 * @throws IOException
	 */
 	public void removeSubmission() throws IOException {
 		File inputFile = new File("submissions.txt");
 		File tempFile = new File("myTempFile.txt");
 		BufferedReader reader = new BufferedReader(new FileReader(inputFile));
 		BufferedWriter writer = new BufferedWriter(new FileWriter(tempFile));
 		
 		String ID = myID + "";
 		String currentLine;
 		
 		while ((currentLine = reader.readLine()) != null) {
 			String[] parts = currentLine.split(" ");
 			String currentID = parts[0].trim();
 			if (currentID.equals(ID)) {
 				System.out.println("ID Match: CurrentID: " + currentID + " ID: " + ID);
 			} else {
 				writer.write(currentLine + System.getProperty("line.separator"));
 			}
 		}
 		writer.close();
 		reader.close();
 		List<String> list = new ArrayList<String>();
 		Scanner sc = new Scanner(tempFile);
 		while (sc.hasNextLine()) {
 			list.add(sc.nextLine());
 		}
 		PrintWriter pw = new PrintWriter(new FileWriter("submissions.txt"), true);
 		for (int i = 0; i < list.size(); i++) {
 			pw.println(list.get(i));
 		}
 		writer.close();
 	}
 	
 	/**
 	 * Checks to see if the stored ID has a submission associated with it.
 	 * @param theID
 	 * @return
 	 * @throws FileNotFoundException
 	 */
 	public boolean containsSubmission() throws FileNotFoundException {
 		Scanner sc = new Scanner(new File("submissions.txt"));
 		while (sc.hasNextLine()) {
 			String line = sc.nextLine();
 			String[] parts = line.split(" ");
 			String currentID = parts[0];
 			if ((myID + "").equals(currentID)) {
 				return true;
 			}
 		}
 		sc.close();
 		return false;
 	}
 	
 	
 	/**
 	 * Returns all submissions stored in the database.
 	 * @return List of all submissions.
 	 * @throws FileNotFoundException 
 	 */
 	public List<Submission> getSubmissions() throws FileNotFoundException {
 		List<Submission> list = new ArrayList<Submission>();
 		Scanner sc = new Scanner(new File("submissions.txt"));
 		while (sc.hasNextLine()) {
 			String line = sc.nextLine();
 			//System.out.println(line);
 			String[] parts = line.split(" ");
 			String ID = parts[0];
 			String name = parts[1];
 			String age = parts[2];
 			String category = parts[3];
 			String image = parts[4];
 			File file = new File(image);
 			Submission s = new Submission(Integer.parseInt(ID), name, category, file);
 			s.setAge(Integer.parseInt(age));
 			list.add(s);
 		}
 		sc.close();
 		return list;
 	}
 	
 	/**
 	 * Prints the submissions in the DataBase.
 	 */
 	public void printDataBase() {
 		List<Submission> list = null;
 		try {
			list = this.getSubmissions();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
 		for (int i = 0; i < list.size(); i++) {
 			System.out.println(list.get(i).toString());
 		}
 	}
 	
 	/**
 	 * Sets a new ID to be stored.
 	 * @param ID ID will be stored in DataManager.
 	 */
 	public void setID(int ID) {
 		this.myID = ID;
 	}
 	
 	/**
 	 * Returns the stored ID.
 	 * @return Returns the stored ID.
 	 */
 	public int getID() {
 		return myID;
 	}
 	
 	/**
 	 * Takes the new submission and replaces the old submission for 
 	 * the user with the new submission. Will not work unless the ID
 	 * on the new submission matches the stored ID.
 	 * @param theSub
 	 * @throws IOException
 	 */
 	public void resubmit(Submission theSub) throws IOException {
 		this.removeSubmission();
 		this.addSubmission(theSub);
 	}
 	
 	/**
 	 * Returns the submission associated with the stored ID.
 	 * If no submission has been added for the given ID than
 	 * a null submission will be returned.
 	 * @return Returns a submission for the stored ID.
 	 */
 	public Submission getSubmission() {
 		List<Submission> list = new ArrayList<Submission>();
 		Submission sub = null;
 		for (int i = 0; i < list.size(); i++) {
 			if (list.get(i).getID() == myID) {
 				return list.get(i);
 			}
 		}
 		return sub;
 	}
 	
 	// isUser : boolean
 	public boolean isUser(String password) {
 		return contains("users.txt", password);
 	}
 	
 	// isAdmin : boolean
 	public boolean isAdmin(String password) {
 		return contains("admins.txt", password);
 	}
 	
 	private boolean contains(String fileName, String password) {
 		Scanner input;
 		boolean contains = false;
		try {
			input = new Scanner(new File(fileName));
	
	 		while (input.hasNextLine()) {
	 			String line = input.nextLine();
	 			String[] parts = line.split(" ");
	 			if (Integer.parseInt(parts[0]) == myID && parts[1].equals(password)) {
	 				contains = true;
	 			}
	 		}
	 		input.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

 		return contains;
 	}
 	
 	/**
 	 * Returns a sorted list of submissions by age.
 	 * @return
 	 * @throws FileNotFoundException
 	 */
 	public List<Submission> getAgeLists() throws FileNotFoundException {
 		@SuppressWarnings({ "unchecked", "rawtypes" })
		Sort sort = new Sort((ArrayList) getSubmissions());
 		sort.sortByAge();
 		return sort.ageList;
 	}
 	
 	/**
 	 * Returns a sorted list of submissions by category lamp.
 	 * @return Returns a sorted list of submissions by category lamp.
 	 * @throws FileNotFoundException
 	 */
 	public List<Submission> getLampList() throws FileNotFoundException {
 		@SuppressWarnings({ "unchecked", "rawtypes" })
		Sort sort = new Sort((ArrayList) getSubmissions());
 		sort.sortByCategory("lamp");
 		return sort.lampList;
 	}
 	
 	/**
 	 * Returns a sorted list of submissions by category chair.
 	 * @return Returns a sorted list of submissions by category chair.
 	 * @throws FileNotFoundException
 	 */
 	public List<Submission> getChairList() throws FileNotFoundException {
 		@SuppressWarnings({ "unchecked", "rawtypes" })
 		Sort sort = new Sort((ArrayList) getSubmissions());
 		sort.sortByCategory("chair");
 		return sort.chairList;
 	}
 	
 	/**
 	 * Returns a sorted list of submissions by category table.
 	 * @return Returns a sorted list of submissions by category table.
 	 * @throws FileNotFoundException
 	 */
 	public List<Submission> getTableList() throws FileNotFoundException {
 		@SuppressWarnings({ "unchecked", "rawtypes" })
 		Sort sort = new Sort((ArrayList) getSubmissions());
 		sort.sortByCategory("table");
 		return sort.tableList;
 		
 	}
 	 	
 	public void resetPassword() {
 		myPassword = null;
 	}
}
