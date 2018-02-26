package junit;

public class TestFinal {
	private final String userName;
	
	private TestFinal(String userName) {
		this.userName = userName;
	}

	public String getUserName() {
		return userName;
	}

	public static void main(String[] args) {
		TestFinal test = new TestFinal("jerrik");
		TestFinal test1 = new TestFinal("Smith");
		
		System.out.println(test.getUserName());
		System.out.println(test1.getUserName());
	}

}
