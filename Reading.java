import java.io.File;
//import java.io.FileNotFoundException;
import java.util.Scanner;
public class Reading {
public static void Load(String filename) { //String filename the path of file
    String line =null; //Read the line
    try{
        File file = new File(filename); //New file with file name (dataset.csv) the Excel
        Scanner input=new Scanner(file); //put file in Scanner
        input.nextLine(); //Skip first line
    while(input.hasNextLine()){ //(Change <-->) hasNextLine means is there a new line to read it
        line=input.nextLine(); //Read from file and save it in line
        if(line.trim().length()<3){ // this helps us to ignore last sentence
            System.out.println("Line is empty , Skip it = "+line);
            break;
        }
        //we don't use (split),because he will read from the first comma to the second comma only and will not continue if there is a continued , will be useful if we don't have second comma
        System.out.println(line); //print result
        String sub=line.substring(0,line.indexOf(','));
        int ID=Integer.parseInt(sub); //(before ,)(.trim()) ,, read it String and convert it into integer
        String Content=line.substring(line.indexOf(',')+1).trim(); //start after the comma to the end
    }
    }catch (Exception e) {
        System.out.println("The End of File");
    }
}
public static void main(String[] args) {
    Load("dataset.csv");
}
}