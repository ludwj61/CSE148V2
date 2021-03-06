package p1TextFileGenerators;

import java.util.Arrays;

public class CourseNumberAndGradeBag {
	// same as normal course in my version of HW7
	private Course[] array;
	private int nElms;
	
	public CourseNumberAndGradeBag(int maxSize) {
		array = new Course[maxSize];
		nElms = 0;
	}
	
	public void insert(Course course) {
		array[nElms++] = course; 
	}
	
	public void display() {
		for(int i = 0; i < nElms; i++) {
			System.out.println(array[i]);
		}
		System.out.println();
	}

	public Course[] getArray() {
		return array;
	}

	public void setArray(Course[] array) {
		this.array = array;
	}

	public int getnElms() {
		return nElms;
	}

	public void setnElms(int nElms) {
		this.nElms = nElms;
	}

	@Override
	public String toString() {
		return "CourseNumberAndGradeBag [array=" + Arrays.toString(array) + ", nElms=" + nElms + "]";
	}
	
	
}
