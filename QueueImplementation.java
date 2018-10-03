import java.util.NoSuchElementException;

class MyQueue<T>{
    public static class QueueNode<T>{
        private T data;
        private QueueNode<T> next;

        public QueueNode(T data){
            this.data = data;
        }
    }

    private QueueNode<T> head;
    private QueueNode<T> tail;

    public void enqueue(T data){
        QueueNode<T> newNode = new QueueNode<>(data);
        if(tail != null){
            tail.next = newNode;
        }
        tail = newNode;
        if(head == null){
            head = tail;
        }
    }

    public T dequeue(){
        if(head == null){
            throw new NoSuchElementException();
        }
        T headData = head.data;
        head = head.next;
        if(head == null){
            tail = null;
        }
        return headData;
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

class MyReallyBadQueue<T>{
    //cost of insertion is O(N)
    public static class QueueNode<T>{
        private T data;
        private QueueNode<T> precNode;

        public QueueNode(T data){
            this.data = data;
        }
    }

    private QueueNode<T> head;

    public void enqueue(T data){
        if(head == null){
            head = new QueueNode<T>(data);
        }
        else{
            QueueNode<T> temp = head;
            while(temp.precNode != null){
                temp = temp.precNode;
            }
            temp.precNode = new QueueNode<T>(data);
        }
    }

    public T dequeue(){
        if(head == null){
            throw new NoSuchElementException();
        }
        T headData = head.data;
        head = head.precNode;
        return headData;
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

public class QueueImplementation{
    public static void main(String[] args){
        MyQueue<String> stringQueue = new MyQueue<>();
        stringQueue.enqueue("Hello");
        stringQueue.enqueue("World!");
        stringQueue.enqueue("I'm Mithra!");
        System.out.println(stringQueue.dequeue());
        System.out.println(stringQueue.dequeue());
        System.out.println(stringQueue.peek());
        System.out.println(stringQueue.isEmpty());
        System.out.println(stringQueue.dequeue());
    }
}