public class Index { // LL of LL
    LinkedList<Document> Documents; //LL of documents
    public Index() {
        Documents =new LinkedList<Document>();
    }
    public LinkedList<Integer> getDocumentTerm(String Term) {//Check if it's empty will be null or we can return LL
        LinkedList<Integer> Check=new LinkedList<>();
        if(Documents.empty()){
            System.out.println("Document is empty");
            return null;
        }
        Documents.findFirst();
        while(!Documents.last()){//move in all
            if(Documents.retrieve().Word.search(Term.toLowerCase().trim()))//we check the words if it's equal the word i search for it so will add his ID in the new LL
                Check.insert(Documents.retrieve().ID); //Adding the ID
            Documents.findNext();
        }
        if(Documents.retrieve().Word.search(Term.trim().toLowerCase()))
            Check.insert(Documents.retrieve().ID);
        return Check; //return the LL
    }
    public void Add_Doc(Document s) {
        Documents.insert(s); //normal add
    }
    public void DisplayDoc() { //to display all the document
        if(Documents ==null) {
            System.out.println("We don't have any Document");
            return;
        }
        else if(Documents.empty()) {
            System.out.println("The Document is empty");
            return;}
        Documents.findFirst(); //to start from beginning
        while(!Documents.last()) {
            Document D= Documents.retrieve(); //,, using retrieve will give you an obj of document
            System.out.println("\n--------------------------------------------------------------------------------");
            System.out.println("ID "+ D.ID);
            D.Word.display(); //display from class LL (19)
            Documents.findNext();
        }
        Document D= Documents.retrieve();
        System.out.println("\n--------------------------------------------------------------------------------");
        System.out.println("ID "+ D.ID);
        D.Word.display();
        //this is for last element
    }
    public Document GetDocByID(int id) {
        if(Documents.empty()) {
            System.out.println("no documents exist"); //ch
            return null;
        }
        Documents.findFirst();
        while(!Documents.last()) {
            if(Documents.retrieve().ID == id)
                return Documents.retrieve();
            Documents.findNext();
        }
        if(Documents.retrieve().ID == id)
            return Documents.retrieve();
        return null;
    }
}
