public class Main {
    public static void main(String[] args){
        CSVParser file = new CSVParser();
        String [] data = file.read("src\\oop2\\students.csv");
        file.write("src\\oop2\\results.csv",data);
    }
}