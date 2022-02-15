
public class Grade {

	private int classNum;
	private int capacity;

	public Grade() {
	}

	public Grade(int classNum, int capacity) {
		setClassNume(classNum);
		setCapacity(capacity);
	}

	public int getClassNume() {
		return classNum;
	}

	public void setClassNume(int classNume) {
		this.classNum = classNume;
	}

	public int getCapacity() {
		return capacity;
	}

	public void setCapacity(int capacity) {
		this.capacity = capacity;
	}

	@Override
	public boolean equals(Object obj) {
		if (!(obj instanceof Grade)) {
			return false;
		}
		Grade tempClass = (Grade) obj;
		if (tempClass.getClassNume() == classNum) {
			return true;
		}
		return false;
	}

	@Override
	public String toString() {
		
		return "The Class number is: "+ classNum +"\n The capacity is :" + capacity+"\n";
	}

}