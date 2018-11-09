class TreeNode<T extends Comparable<? super T>>{
    private T data;
    public TreeNode<T> left;
    public TreeNode<T> right;

    public TreeNode(T data){
        this.data = data;
        this.left = null;
        this.right = null;
    }

    public T getData(){
        return data;
    }

    public TreeNode<T> getLeftChild(){
        return this.left;
    }

    public TreeNode<T> getRightChild(){
        return this.right;
    }

    public int compare(T anotherValue){
        return this.data.compareTo(anotherValue);
    }
}

class BST<T extends Comparable<? super T>>{
    private TreeNode<T> root;

    public BST(T data){
        this.root = new TreeNode<>(data);
    }

    public void addNode(T data){
        addNodeRecursive(root, data);
    }

    private void addNodeRecursive(TreeNode<T> root, T data){
        if(root == null){
            return;
        }
        if(root.compare(data) > 0){ //root is larger
            if(root.left == null){
                root.left = new TreeNode<>(data);
            }
            else{
                addNodeRecursive(root.left, data);
            }
        }
        else if(root.compare(data) < 0){ //root is smaller
            if(root.right == null){
                root.right = new TreeNode<>(data);
            }
            else{
                addNodeRecursive(root.right, data);
            }
        }
        else{ //node already exists
            return;
        }

    }
}


public class BSTImplementation{
    public static void main(String[] args){
        BST<Integer> myBST = new BST<>(4);
        myBST.addNode(2);
        myBST.addNode(5);
        myBST.addNode(6);
        myBST.addNode(1);
        myBST.addNode(1);
        //myBST.addNode(6);
    }
}