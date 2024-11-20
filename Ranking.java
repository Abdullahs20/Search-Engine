public class Ranking {
    static String Query;
    static InvertedindexBST InvertedBST;
    static Index Index;
    static LinkedList<Integer> AllDocInQuery;
    static LinkedList<DocRank> AllDocRank;
    public Ranking (InvertedindexBST inverted , Index index ,String query){
        InvertedBST = inverted;
        Index =index;
        Query=query;
        AllDocInQuery = new LinkedList<Integer>();
        AllDocRank = new LinkedList<DocRank> () ;
    }
    public static void displayRanking() {
        if (AllDocRank.empty()) {
            System.out.println("empty rank");
            return;
        }
        System.out.printf("%-8s%-8s\n", "DocID", "Score");
        AllDocRank.findFirst();
        while (!AllDocRank.last()) {
            AllDocRank.retrieve().display();
            AllDocRank.findNext();
        }
        AllDocRank.retrieve().display();
    }
    public static Document GetDocByID(int id){
        return Index.GetDocByID(id);
    }
public static int getScore(Document d, String Query) {
    LinkedList<String> terms = d.Word;
    if (Query.length() == 0 || terms.empty())
        return 0;
    int score = 0;
    String[] T = Query.split(" ");
    int i = 0;
    while (i < T.length) {
        String term = T[i].trim().toLowerCase();
        int repeat = 0;
        terms.findFirst();
        while (!terms.last()) {
            if (terms.retrieve().equalsIgnoreCase(term))
                repeat++;
            terms.findNext();
        }
        if (terms.retrieve().equalsIgnoreCase(term))
            repeat++;
        score += repeat;
        i++;
    }
    return score;
}


    public static boolean IsExistsInResult(LinkedList<Integer>result, Integer id){
        if(result.empty()) return false;
        result.findFirst();
        while (!result.last()){
            if (result.retrieve().equals(id)){
                return true;
            }
            result.findNext();
        }

        if (result.retrieve().equals(id)){
            return true;
        }
        return false;
    }

}