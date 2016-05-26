package Model;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.nio.charset.StandardCharsets;
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

	/**
	 * Constructs an object to manipulate submissions in database.
	 */
 	public DataManager() {

 	}
 	
	/**
	 * Adds the given submissions to the database.
	 * @param theSubmission Takes a submission and adds it to the database.
	 * @throws IOException 
	 */
	public void addSubmission(Submission theSubmission) throws IOException {
		int ID = theSubmission.getID();
		if (this.containsSubmission(ID +"")) return;
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
 	public void removeSubmission(int theID) throws IOException {
 		File inputFile = new File("submissions.txt");
 		File tempFile = new File("myTempFile.txt");
 		BufferedReader reader = new BufferedReader(new FileReader(inputFile));
 		BufferedWriter writer = new BufferedWriter(new FileWriter(tempFile));
 		
 		String ID = theID + "";
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
 	
 	public boolean containsSubmission(String theID) throws FileNotFoundException {
 		Scanner sc = new Scanner(new File("submissions.txt"));
 		while (sc.hasNextLine()) {
 			String line = sc.nextLine();
 			String[] parts = line.split(" ");
 			String currentID = parts[0];
 			if (theID.equals(currentID)) {
 				return true;
 			}
 		}
 		return false;
 	}
 	
 	/**
 	 * Returns all submissions stored in the database
 	 * @return Submission ArrayList of all submissions.
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
}
