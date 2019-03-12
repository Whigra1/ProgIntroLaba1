import java.io.*;
import java.util.ArrayList;
import java.util.Comparator;


public class CSVParser {
    private ArrayList<Student> students = new ArrayList<>();
    private int people_count;

    public void read(String path) throws Exception {
        BufferedReader br = new BufferedReader(new FileReader(path));
        this.people_count = Integer.parseInt(br.readLine());
        String line = "";
        while((line = br.readLine()) != null){
            String [] row = line.split(",");
            if (row[6].equals("FALSE"))
                students.add(new Student(row[0],avarage(row),false));
            else if (row[6].equals("TRUE"))
                students.add(new Student(row[0],avarage(row),true));
        }

    }
	public void write(String path) throws Exception{
        BufferedWriter bw = new BufferedWriter(new FileWriter(path));
        double percent = this.people_count * 0.4;
        students.sort(Comparator.comparing(Student::getAverage).reversed());
        int count = 1;
        for(int student = 0;;student++){
            Student s = students.get(student);
            if (count > percent){
                s = students.get(student - 1);
                bw.write("Last mark for budget: " + s.getAverage());
                break;
            }
            if (!s.isContact()) {
                bw.write(s.getSurname() + " " + s.getAverage() + "\n");
                count++;
            }
        }

        bw.close();
    }
    private double avarage(String [] line){
        double temp = 0;
        for(int i = 1; i < 6 ;i++){
            temp += Integer.parseInt(line[i]);
        }
        return temp/5;
    }

}

class Student{
    private String surname;
    private double average;
    private boolean contact;
    public Student(String surname , double average, boolean contact){
        this.surname = surname;
        this.average = average;
        this.contact = contact;
    }
}
