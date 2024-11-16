public class Document { //we have id and Linked list String to save the words without stop words
    LinkedList<String>Word=new LinkedList<String>();
    int ID;
    String Content;
    public Document(int id,LinkedList<String>Words,String Contents) {
        ID=id;
        Word=Words;
        Content=Contents;
    }
//    all doc.retrive().words or id
} //retrive will give you an object from document