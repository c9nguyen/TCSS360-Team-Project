package Test;

import java.util.ArrayList;

import org.junit.Before;

import Model.DataManager;
import Model.Sort;
import Model.Submission;
import junit.framework.TestCase;

public class SortTest extends TestCase {
	ArrayList<Submission> L = new ArrayList<Submission>();
	Sort s;
	
	@Before
	public void setUp() {
		s = new Sort(L);
		L.add(new Submission (123, "Name", "Lamp", null));
		L.add(new Submission (234, "Name2", "Chair", null));
		L.add(new Submission (211, "Name3", "Chair", null));
		L.add(new Submission (334, "Name4", "Table", null));
	}
	
	
}
