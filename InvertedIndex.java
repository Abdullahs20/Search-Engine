public class InvertedIndex {
    public List<Word> inverted_index;
    LinkedList<Word> WordList;

    public InvertedIndex(){
        WordList=new LinkedList<Word>();
    }
    public boolean search_inverted_word_(String text){
        if ( WordList== null || WordList.empty())
            return false;

        WordList.findFirst();
        while(!WordList.last()){
            if (WordList.retrieve().Text.equals(text)){
                return true;
            }
            WordList.findNext();
        }
        if(WordList.retrieve().equals(text)){
            return true;
        }
        return false;

    }
    public void add (String text, int id){
        if (!search_inverted_word_(text)){
            Word w = new Word(text);
            w.DOC_ID.insert(id);
            WordList.insert(w);
        }
        else {
            Word Repword= WordList.retrieve();
            Repword.Add_ID(id);
        }
    }

    public void display_inverted_index(){
        if(WordList.empty()){
            System.out.println("empty");
            return;
        }

        else if (WordList == null){
            System.out.println("null");
            return;
        }

        WordList.findFirst();
        while(!WordList.last()){
            Word w = WordList.retrieve();
            w.display();
            WordList.findNext();

        }
        Word w = WordList.retrieve();
        System.out.println("\n----------------------------------");
        w.display();
    }

}