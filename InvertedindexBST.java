public class InvertedindexBST {
    BST<Word> Inverted_Index;
    public InvertedindexBST() {
        Inverted_Index = new BST<Word>();
    }
    public boolean SearchWordInInverted(String w) {
        return Inverted_Index.FindKey(w);
    }
    public void Add(InvertedIndex inverted){
        if(inverted.inverted_index.empty())
            return;
        inverted.inverted_index.findFirst();
        while (!inverted.inverted_index.last()){
            Inverted_Index.Insert(inverted.inverted_index.retrieve().Text,inverted.inverted_index.retrieve());
                    inverted.inverted_index.findNext();
        }
        Inverted_Index.Insert(inverted.inverted_index.retrieve().Text,inverted.inverted_index.retrieve());
    }
    public void add(String text, int id) {
        if (!SearchWordInInverted(text)) {
            Word w = new Word(text);
            w.DOC_ID.insert(id);
            Inverted_Index.Insert(text, w);
        } else {
            Word existing_word = Inverted_Index.Retrieve();
            existing_word.Add_ID(id);
        }
    }

    public void DisplayInvertedIndex() {
        if (Inverted_Index == null) {
            System.out.println("null invertedindexBST");
            return;
        } else if (Inverted_Index.Empty()) {
            System.out.println("empty invertedindexBST");
            return;
        }
        Inverted_Index.InOrder();
    }
}