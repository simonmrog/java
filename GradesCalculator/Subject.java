
public class Subject {

	String subjectName;
	int size, credits;
	String descriptions[];
	float percents[], grades[];
	
	public Subject (String name, int gradesNumber, int cred) {
		
		subjectName = new String(name);
		size = gradesNumber;
		credits = cred;
		descriptions = new String[size];
		percents = new float[size];
		grades = new float[size];
	}
	
	public void setDescription(int index, String desc) {
		descriptions[index] = desc;
	}
	
	public void setPercent(int index, float perc) {
		percents[index] = perc;
	}
	
	public void setGrade(int index, float grade) {
		grades[index] = grade;
	}
	
	public String getName() {
		return subjectName;
	}
	
	public String getDescription(int index) {
		return descriptions[index];
	}
	
	public float getPercent(int index) {
		return percents[index];
	}
	
	public float getGrade(int index) {
		return grades[index];
	}
	
	public int getCredits() {
		return credits;
	}
	
	public float getSubjectGrade() {
		
		float value = 0;
		for (int i=0; i<size; i++)
			value = value + percents[i]*grades[i];
		return value/100;	
	}
	
	public void showSubjectStatus() {
		for (int i=0; i<size; i++)
			System.out.println(descriptions[i] + " " + percents[i] + " " + grades[i]);
	}
}
