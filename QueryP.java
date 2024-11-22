public class QueryP {
    static InvertedIndex Inverted_Index;
    public QueryP(InvertedIndex Inverted) {
        this.Inverted_Index = Inverted;
    }
    public static LinkedList<Integer>AndQuery(String Query) { //7
        LinkedList<Integer> X = new LinkedList<>();//Two LL to Work With it
        LinkedList<Integer> Y = new LinkedList<>();
        String[] T = Query.split("AND");//use split in array
        if (T.length == 0)
            return X;
        boolean Found = Inverted_Index.search_inverted_word_(T[0].trim().toLowerCase()); //search_inverted_word_ you find it in class InvertedIndex , also when we split the new LL will be empty
        if (Found) {
            X = Inverted_Index.WordList.retrieve().DOC_ID;
        }
        for (int i = 1; i < T.length; i++) {
            Found = Inverted_Index.search_inverted_word_(T[i].trim().toLowerCase());
            if (Found)
                Y = Inverted_Index.WordList.retrieve().DOC_ID;
            X = AndQuery(X, Y);
        }
        return X;
    }
    private static LinkedList<Integer> AndQuery(LinkedList<Integer> A, LinkedList<Integer> B){ //use LL to make split
        LinkedList<Integer> Result = new LinkedList<>();
        if (A.empty() || B.empty())
            return Result;
        A.findFirst();
        while (true) {
            boolean Found = ExistInRes(Result, A.retrieve()); //if you didn't find it you will use the code in 35 to 47 line
            if (!Found) {
                B.findFirst();
                while (true) {
                    if (B.retrieve().equals(A.retrieve())) {
                        Result.insert(A.retrieve());
                        break;
                    }
                    if (!B.last())
                        B.findNext();
                    else
                        break;
                }
            }
            if (!A.last())
                A.findNext();
            else
                break;
        }
        return Result;
    }
    public static LinkedList<Integer> ORQuery(String Query) {
        LinkedList<Integer> A = new LinkedList<Integer>();
        LinkedList<Integer> B = new LinkedList<Integer>();
        String [] T = Query.split("OR");
        if (T.length == 0) return A;
        boolean Found = Inverted_Index.search_inverted_word_(T[0].trim().toLowerCase());
        if (Found) {
            A = Inverted_Index.WordList.retrieve().DOC_ID;
        }
        for (int i = 1; i < T.length; i++) {
            Found = Inverted_Index.search_inverted_word_(T[i].trim().toLowerCase());
            if (Found) {
                B = Inverted_Index.WordList.retrieve().DOC_ID;
            }
            A = ORQuery(A, B);
        }
        return A;
    }
    private static LinkedList<Integer> ORQuery(LinkedList<Integer> A, LinkedList<Integer> B) {
        LinkedList<Integer> Result = new LinkedList<Integer>();
        if (A.empty() && B.empty())
            return Result;
        A.findFirst();
        while (!A.empty()) { //we be false when it's empty
            boolean Found = ExistInRes(Result, A.retrieve());
            if (!Found) {
                Result.insert(A.retrieve());
            }
            if (!A.last())
                A.findNext();
            else
                break;
        }
        B.findFirst();
        while (!B.empty()) {
            boolean Found = ExistInRes(Result, B.retrieve());
            if (!Found) {
                Result.insert(B.retrieve());
            }
            if (!B.last())
                B.findNext();
            else
                break;
        }
        return Result;
    }
    public static LinkedList<Integer>MixedQuery(String Query) {
        LinkedList<Integer>A=new LinkedList<Integer>();
        LinkedList<Integer>B=new LinkedList<Integer>();
        if(Query.length()==0)
            return A;
        String []M= Query.split("OR");
        A=AndQuery(M[0]);
        for (int i = 1; i < M.length; i++) {
            B=AndQuery(M[i]);
            A=ORQuery(A, B);
        }
        return A;
    }

    public static boolean ExistInRes(LinkedList<Integer> Result , Integer ID) {
        if(Result.empty())
            return false;
        Result.findFirst();
        while (!Result.last()){
            if(Result.retrieve().equals(ID)){
                return true;
            }
            Result.findNext();
        }
        if(Result.retrieve().equals(ID)){
            return true;}

        return false;
    }
}







