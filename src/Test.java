import java.util.Comparator;

public class Test implements Comparable<Test> {
	
	int x;
	
	public Test(int x) {
		super();
		this.x = x;
	}


	@Override
	public int compareTo(Test o) {
		if(o.x<x) return 1;
		return -1;
	}

}
