public class Main {
    public static void main(String[] args){
        CSVParser file = new CSVParser();
        file.read("src\\laba1\\students.csv");
        file.write("src\\laba1\\results.csv");
    }
}