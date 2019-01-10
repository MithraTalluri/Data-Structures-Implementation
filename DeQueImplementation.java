import java.util.NoSuchElementException;

class MyDeque<T>{
    public static class DequeNode<T>{
        private T data;
        private DequeNode<T> prev;
        private DequeNode<T> next;

        public DequeNode(T data){
            this.data = data;
            this.prev = null;
            this.next = null;
        }
    }

    private DequeNode<T> head;
    private DequeNode<T> tail;

    public void push_back(T data){
        DequeNode<T> newNode = new DequeNode<>(data);
        if(tail != null){
            newNode.prev = tail;
            tail.next = newNode;
        }
        tail = newNode;
        if(head == null){
            head = tail;
        }
    }

    public void push_front(T data){
        DequeNode<T> newNode = new DequeNode<>(data);
        if(head != null){
            newNode.next = head;
            head.prev = newNode;
        }
        head = newNode;
        if(tail == null){
            tail = head;
        }
    }

    public T pop_front(){
        if(head == null){
            throw new NoSuchElementException();
        }
        T headData = head.data;

        head = head.next;
        if(head != null){
            head.prev.next = null;
            head.prev = null;
        }

        if(head == null){
            tail = null;
        }
        return headData;
    }

    public T pop_back(){
        if(tail == null){
            throw new NoSuchElementException();
        }
        T tailData = tail.data;

        tail = tail.prev;
        if(tail != null){
            tail.next.prev = null;
            tail.next = null;
        }

        if(tail == null){
            head = null;
        }
        return tailData;
    }

    public T peek(){
        if(head == null){
            throw new NoSuchElementException();
        }
        return head.data;
    }

    public boolean isEmpty(){
        return head == null;
    }
}

public class DeQueImplementation{
    public static void main(String[] args){
        MyDeque<Integer> myDeque = new MyDeque<>();
        myDeque.push_back(1);
        myDeque.push_front(2);
        System.out.println(myDeque.pop_back());
        System.out.println(myDeque.pop_front());
        myDeque.push_front(3);
        System.out.println(myDeque.pop_back());
        myDeque.push_back(4);
        System.out.println(myDeque.pop_front());
        try{
            System.out.println(myDeque.pop_front());
        }
        catch(NoSuchElementException e){
            System.out.println("Empty");
        }
    }
}