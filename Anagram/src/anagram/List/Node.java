
package anagram.List;

public class Node<T> {
    //int id;
    T value;
    Node next;
    
    public Node(T value){
        this.value = value;
        next = null;
    }
    
    public boolean equals(Node node){
        return value == node.value;
    }
    
    public String toString(){
        return value.toString();
    }
}
