
import java.io.*;



public class CSVParser {

    private int count = 0;

    public String [] read(String path) throws Exception {
        BufferedReader br = new BufferedReader(new FileReader(path));
        int l  = Integer.parseInt(br.readLine());
        String line = "";
        String res = "";
        double average_rate;
        count = 0;
        while((line = br.readLine()) != null){
            String [] row = line.split(",");
            if (row[6].equals("FALSE")) {
                average_rate = avarage(row);
                if (average_rate != -1){
                    count++;
                    res += row[0] + "," + average_rate + "\n";
                }
            }
        }
        String[] data = res.split("\n");
        for(int i = 0; i < data.length-1; i++){
            for(int j = 0; j < data.length-1; j++){
                double mark = Double.valueOf(data[j].split(",")[1]);
                Double mark_to_compare = Double.valueOf(data[j + 1].split(",")[1]);
                if (mark < mark_to_compare){
                    String t = data[j];
                    data[j] = data[j+1];
                    data[j+1] = t;
                }
            }
        }
        return data;
    }
    public void write(String path, String [] rates) throws Exception{
        BufferedWriter bw = new BufferedWriter(new FileWriter(path));
        double percent = this.count * 0.4;
        for(int i = 0;i<percent;i++){
            bw.write(rates[i] + "\n");
        }
        bw.close();
    }
    private double avarage(String[] line){
        double temp = 0;
        for(int i = 1; i < 6 ;i++) {
            if (Integer.valueOf(line[i]) < 60)
                return -1;
            temp += Integer.valueOf(line[i]);
        }
        return temp/5;
    }
}

class Student {
    private String surname;
    private double average;
    private boolean contact;

    public Student(String surname, double average, boolean contact) {
        this.surname = surname;
        this.average = average;
        this.contact = contact;
    }

    public double getAverage() {
        return average;
    }

    public String getSurname() {
        return surname;
    }

    public boolean isContact() {
        return this.contact;
    }
}