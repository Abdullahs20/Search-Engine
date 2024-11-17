public class Index { // LL of LL
    LinkedList<Document> Document; //LL of documents
    public Index() {
        Document =new LinkedList<Document>();
    }
    public void Add_Doc(Document s) {
        Document.insert(s); //normal add
    }
    public void DisplayDoc() { //to display all the document
        if(Document ==null) {
            System.out.println("We don't have any Document");
            return;
        }
        else if(Document.empty()) {
            System.out.println("The Document is empty");
            return;}
        Document.findFirst(); //to start from beginning
        while(!Document.last()) {
            Document D= Document.retrieve(); //,, using retrieve will give you an obj of document
            System.out.println("\n--------------------------------------------------------------------------------");
            System.out.println("ID "+ D.ID);
            D.Word.display(); //display from class LL (19)
            Document.findNext();
        }
        Document D= Document.retrieve();
        System.out.println("\n--------------------------------------------------------------------------------");
        System.out.println("ID "+ D.ID);
        D.Word.display();
        //this is for last element
    }
    public Document GetDocByID(int id) {
        if(Document.empty()) {
            System.out.println("no documents exist");
            return null;
        }
        Document.findFirst();
        while(!Document.last()) {
            if(Document.retrieve().ID == id)
                return Document.retrieve();
            Document.findNext();
        }
        if(Document.retrieve().ID == id)
            return Document.retrieve();
        return null;
    }
}
