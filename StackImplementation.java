import java.util.EmptyStackException;

import MyStack.StackNode;

class MyStack<T>{
    public static class StackNode<T>{
        private T data;
        private StackNode<T> precNode; //preceeding node

        public StackNode(T data){
            this.data = data;
        }
    }

    private StackNode<T> top;

    public void push(T data){
        StackNode<T> newNode = new StackNode<>(data);
        newNode.precNode = top;
        top = newNode;
    }

    public T pop(){
        if(top == null){
            throw new EmptyStackException();
        }
        T topData = top.data;
        top = top.precNode;
        return topData;
    }

    public T peek(){
        return top.data;
    }

    public boolean isEmpty(){
        return top == null;
    }
}

class StackImplementation{
    public static void main(String[] args){
        MyStack<String> stringStack = new MyStack<>();
        stringStack.push("Hello");
        stringStack.push("World!");
        System.out.println(stringStack.peek());
        System.out.println(stringStack.pop());
        System.out.println(stringStack.pop());
        MyStack<Integer> intStack = new MyStack<>();
        intStack.push(0);
        intStack.push(1);
        System.out.println(intStack.peek());
        System.out.println(intStack.pop());
        System.out.println(intStack.pop());
    }
}