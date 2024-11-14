public class Word {
    String Text;
    LinkedList<Integer> DOC_ID; //Document id
    public Word(String x) {
        Text=x;
        DOC_ID=new LinkedList<Integer>(); // new LL to add anything
    }
    public boolean IsExists_DOC_ID(Integer id) {
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
    public void Add_ID(int id) {
        if(!IsExists_DOC_ID(id)) //IsExists to search in LL
            DOC_ID.insert(id);}}
//we can add without use IsExists because the ID is unique but we take careful