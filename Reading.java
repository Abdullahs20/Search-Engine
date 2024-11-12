import java.io.File;
//import java.io.FileNotFoundException;
import java.util.Scanner;
public class Reading {
public static void Load(String filename) { //String filename the path of file
    String line =null; //Read the line
    try{
        File files = new File(filename);
        Scanner input=new Scanner(files);
        input.nextLine(); //Skip first line
    while(input.hasNextLine()){
        line=input.nextLine();
        if(line.trim().length()<3){
            System.out.println("Line is empty , Skip it = "+line);
            break;
        }
        System.out.println(line);
        String sub=line.substring(0,line.indexOf(','));
        int ID=Integer.parseInt(sub.trim());
        String Content=line.substring(line.indexOf(',')+1).trim();
    }
    }catch (Exception e) {
        System.out.println("End");
    }
}}