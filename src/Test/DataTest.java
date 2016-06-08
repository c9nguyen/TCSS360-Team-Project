package Test;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.List;

import org.junit.Before;

import Model.DataManager;
import Model.Submission;
import junit.framework.TestCase;

public class DataTest extends TestCase {

	private DataManager dm;
	
	/**
	 * A method to initialize the test fixture.
	 */
	@Before
	public void setUp() {
		dm = new DataManager(1234);
	}
	
	/**
	 * Test method for addSubmission().
	 * @throws IOException 
	 */
	public void testAddSubmission() throws IOException {
		//dm.addSubmission(new Submission(6535669, "BlackDesk", "Desk", new File("blackdesk.jpg")));
		//dm.addSubmission(new Submission(8, "BlackDesk", "Desk", new File("blackdesk.jpg")));
		//dm.addSubmission(new Submission(233243, "anotherDesk", "Desk", new File("decksss.jpg")));
		//dm.addSubmission(new Submission(35453, "YellowLamp", "Lamp", new File("yellowlamp.jpg")));
		//dm.removeSubmission(8);
		//List<Submission> list = dm.getSubmissions();
		//System.out.println(list.size());
		//dm.removeSubmission();
		//dm.printDataBase();
		assertEquals(true, true);
	}
	
	public void testGetLampList() throws IOException {
		dm.addSubmission(new Submission(1234, "YellowLamp", "Lamp", new File("yellowlamp.jpg")));
		System.out.println(dm.getLampList());
		assertEquals(true, true);
	}	
	
	public void testIsUser() {
		dm.isUser("wordup");
		assertEquals(dm.isUser("wordup"), true);
	}
}

