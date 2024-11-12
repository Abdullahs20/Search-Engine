public class LinkedList<T> implements List<T> {
    private Node<T> Head;
    private Node<T> Current;
    public LinkedList() {
        Head=Current=null;
    }
    public void findFirst() {
        Current=Head;
    }
    public void findNext() {
        Current=Current.Next;
    }
    public T retrieve() {
        return Current.Data;
    }
    public void update(T Val) {
        Current.Data=Val;
    }
    public void insert(T Val) {
        Node<T> tmp;
        if(empty()) {
            Current=Head=new Node<T>(Val);
        }
        else {
            tmp=Current.Next;
            Current.Next=new Node<T>(Val);
            Current=Current.Next;
            Current.Next=tmp;
        }
    }
    public void remove() {
        if(Current==Head) {
            Head=Head.Next;
        }else {
            Node<T> tmp=Head;
            while(tmp.Next!=Current)
                tmp=tmp.Next;
            tmp.Next=Current.Next;
        }
        if(Current.Next==null)
            Current=Head;
        else
            Current=Current.Next;
    }
    public boolean full() {
        return false;
    }
    public boolean empty() {
        return Head==null;
    }
    public boolean last() {
        return Current.Next==null;
    }
    //Add size??
    public void display() { //By mos
        if(Head==null)
            System.out.println("List is Empty! ");
        Node<T> q=Head;
        while(q!=null) {
            System.out.println(q.Data+" ");
            q=q.Next;
        }
    }
    public static void main(String[] args) {
        List<String>L=new LinkedList<String>();
        L.insert("aa");
        L.insert("v");
        L.insert("f");
        L.display();
        L.findFirst();
        L.remove();
        L.display();
    }
}