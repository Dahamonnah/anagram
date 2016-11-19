
package anagram.List;

public class LinkedList<T> {
    
    Node head = null;
    Node tail = null;
    public int size = 0;
    //add, remove, get, toString, isEmpty, contains
    
    public LinkedList(){
        
    }
    
    public void add(T value){
        Node<T> node = new Node(value);
        
        if(isEmpty()){
            head = node;
            tail = node;
        }
        else{
            Node<T> temp = tail;
            tail = node;
            temp.next = node;
            temp = null;
        }
        
        size++;
    }
    
    public void remove(T value){
        Node<T> node = new Node(value);
        
        if(isEmpty() || !contains(value)){
            return;
        }
        else if(size == 1){
            head = null;
            tail = null;
        }
        else if(head.equals(node)){
            Node<T> temp = head;
            head = head.next;
            temp = null;
        }
        else if(tail.equals(node)){
            Node<T> temp = head;
            while(temp.next != tail){
                temp = temp.next;
            }
            temp.next = null;
            tail = temp;
            temp = null;
        }
        else{
            Node<T> temp = head;
            while(!temp.next.equals(node)){
                temp = temp.next;
            }
            Node<T> temp2 = temp.next;
            temp.next = temp2.next;
            temp = null;
            temp2 = null;
        }
        
        size--;
    }
    
    /*public T get(int index){
        
    }*/
    
    public boolean contains(T value){
        Node<T> temp = head;
        while(temp != null){
            if(temp.equals(new Node(value))){
                return true;
            }
            temp = temp.next;
        }
        return false;
    }
    
    public boolean isEmpty(){
        return size == 0;
    }
    
    public String toString(){
        
        if(isEmpty()){
            return "[]";
        }
        
        String output = "[";
        Node<T> temp = head;
        while(temp != null){
            output += temp + ", ";
            temp = temp.next;
        }
        
        return output.substring(0,output.length()-2) + "]";
    }
    
}
