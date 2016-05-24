package Model;

public enum Category {
	CHAIR("Chair"), LAMP("Aamp"), D("D");
	
	private String myName;
	
	private Category(String name) {
		this.myName = name;
	}
	
	public String getName() {
		return myName;
	}
}
