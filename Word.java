public class Word {
    String Text;
    LinkedList<Integer> DOC_ID; //Document id
    public Word(String x) {
        Text=x;
        DOC_ID=new LinkedList<Integer>(); // new LL to add anything
    }
    public boolean IsExists_DOC_ID(Integer id) { // use it to check ehether the given id already exists or not
        if(DOC_ID.empty())
            return false;
        while(!DOC_ID.last()) {
            if(DOC_ID.retrieve().equals(id)) { //retrieve will bring the same data of the LL (Integer)
                return true;
            }
            DOC_ID.findNext();
        }
        if(DOC_ID.retrieve().equals(id)) { //this check for last element in the LL
            return true;}
        return false;
    }
    public void Add_ID(int id) { //this method add the id if does not exists
        if(!IsExists_DOC_ID(id)) //IsExists to search in LL
            DOC_ID.insert(id);}
    public void display() { //this method display the word and it is ids
        System.out.println(" the word: " + Text);
        System.out.print(" ( ");
        DOC_ID.display();
        System.out.print(" )");
        System.out.println("\n----------------------------------");

    }
}
