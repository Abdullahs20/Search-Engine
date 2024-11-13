public class Document { //we have id and Linked list String to save the words without stop words
    LinkedList<String>Word=new LinkedList<String>();
    int ID;
    public Document(int id,LinkedList<String>Words) {
        ID=id;
        Word=Words;
    }
    //all doc.retrive().words or id
} //retrive will give you an object from document