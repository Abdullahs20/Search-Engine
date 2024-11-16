import java.io.File;
import java.io.IOException;
import java.util.Scanner;
public class Main {
    LinkedList <String> StopWord;
    Index Index; //LL and Doc
    InvertedIndex Inverted; //LL of word
    InvertedindexBST InvertedBST;
    public Main(){
        StopWord = new LinkedList<>();
        Index= new Index() ;
        Inverted =new InvertedIndex() ;
        InvertedBST =new InvertedindexBST();
    }
    public void LoadStopWords (String fileName){ //Load the stop words to read it
        try {
            File f=new File (fileName);
            Scanner s=new Scanner (f);
            while (s.hasNextLine()) {
                String line=s.nextLine();
                StopWord.insert(line);
            }
        }catch(IOException e) {
            e.printStackTrace();
        }
    }
    public void LoadAllDoc (String fileName) {//Load the Doc to read it
        String line = null;
        try {
            File f = new File(fileName);
            Scanner s = new Scanner(f);
            s.nextLine(); //Skip first line in Excel
            while (s.hasNextLine()) {
                line = s.nextLine();
                if (line.trim().length() < 3) {
                    System.out.println("Empty line Found");
                    break;
                }
                String x = line.substring(0, line.indexOf(","));
                int ID = Integer.parseInt(x.trim());
                String Content = line.substring(line.indexOf(",") + 1);
                LinkedList<String> WordInDoc = LLOfWordInIndexOfInvertedIndex(Content, ID);
                Index.Add_Doc(new Document(ID, WordInDoc,Content)); //All word and with their Doc
            }
        } catch(Exception e) {
            System.out.println(e);
        }
    }
    public LinkedList<String> LLOfWordInIndexOfInvertedIndex (String Content, int ID){
        LinkedList<String> WordsInDoc = new LinkedList<String>() ;
        IndexOfInvertedIndex(Content, WordsInDoc, ID) ; //line 52
        return WordsInDoc;
    }
    public void IndexOfInvertedIndex (String Content, LinkedList<String>WordsInDoc, int ID) {
        Content = Content.toLowerCase().replaceAll("[^a-zA-Z0-9 ]", ""); // make all letter lowercases
        String[] Token = Content.split ("\\s+");
        for (String W : Token) {
            if (!IsExistInStopWord(W)) { //Search !!!!
                WordsInDoc.insert(W);
                Inverted.add(W, ID);
                InvertedBST.add(W, ID);
            }
        }
    }
    public boolean IsExistInStopWord (String Word) { //Search if the word Exist or not
        if (StopWord==null || StopWord.empty())
            return false;
        StopWord.findFirst();
        while (!StopWord.last()) {
            if (StopWord.retrieve().equals(Word)) {
                return true;
            }
            StopWord.findNext();
        }
        if(StopWord.retrieve().equals(Word))
            return true;

        return false;
    }
    public void LoadFiles (String StopFile,String DocumentFile) { //Load the stop words and the doc file
        LoadStopWords(StopFile); //Focus stop word text should be before the Doc file
        LoadAllDoc(DocumentFile);
    }
    public void DisplayDocWithID(LinkedList<Integer> Id){
        if(Id.empty()){
            System.out.println("No Document Found");
            return;
        }
        Id.findFirst();
        while (!Id.last()) {
            Document D=Index.GetDocByID(Id.retrieve());
            if(D!=null){
                System.out.println("\nDocument "+D.ID +": "+D.Content);
//                System.out.println("\n");
            }
            Id.findNext();
        }
        Document D=Index.GetDocByID(Id.retrieve());
        if(D!=null){
            System.out.println("\nDocument "+D.ID +": "+D.Content);
//            System.out.println("\n");
        }
        System.out.println("===================");

    }
    public static void main (String [] args) {
        Main d = new Main();
        d.LoadFiles("stop.txt", "dataset.csv");
//            d.Index.DisplayDoc();
        System.out.println("\n======================");
//          d.Inverted.display_inverted_index(); //from class InvertedIndex*
        System.out.println("\n======================");
//        d.InvertedBST.DisplayInvertedIndex();
//         d.Inverted.display_inverted_index();

         QueryP q=new QueryP(d.Inverted);
        LinkedList l=QueryP.ORQuery("businessORworld");
        d.DisplayDocWithID(l);


    }
}