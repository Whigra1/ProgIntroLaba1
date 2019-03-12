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
    
}

