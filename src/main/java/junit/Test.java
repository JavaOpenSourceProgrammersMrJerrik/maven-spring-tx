package junit;

import java.util.ArrayList;
import java.util.List;

public class Test {

	public static void main(String[] args) {
		show();
	}

	private static void show() {
		List<String> data = new ArrayList<String>();
		data.add("hello world");
		data.add("IBM");
		data.add("Google");
		data.add("Oracle");
		
		iterate(data);
	}

	private static void iterate(List<String> data) {
		for(String str : data){
			System.out.println(str);
		}
	}

}
