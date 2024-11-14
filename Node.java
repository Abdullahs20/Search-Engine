
public class Node<T> {
    public T Data;
    public Node<T> Next;
    public Node() {
		data = null;
		next = null;
	}
    public Node (T val) {
        Data=val;
        Next=null;
    }
}
