import java.lang.Comparable;
import java.util.List;
import java.util.ArrayList;
import java.util.function.Consumer;

public class TreeNode<T extends Comparable<T>>{
  private T value;
  private TreeNode<T> leftChild;
  private TreeNode<T> rightChild;

  TreeNode(T value){
    this.value = value;
  }

  public T getValue(){
    return this.value;
  }

  public void setLeftChild(TreeNode<T> leftNode){
    this.leftChild = leftNode;
  }

  public void setRightChild(TreeNode<T> rightNode){
    this.rightChild = rightNode;
  }

  public TreeNode getLeftChild(){
    return this.leftChild;
  }

  public TreeNode getRightChild(){
    return this.rightChild;
  }

  public boolean find(T value){
    int cmp = this.value.compareTo(value);

    if(cmp == 0)
      return true;
    if(cmp < 0 && this.leftChild != null)
      return this.leftChild.find(value);
    if(cmp > 0 && this.rightChild != null)
      return this.rightChild.find(value);

    return false;
  }

  public boolean add(T value){
    return false;
  }

  /*public void enumerate(Consumer<T> callback)
  {
    if(this.leftChild != null)
      leftChild.enumerate(callback);

    callback.accept(this.value);

    if(this.rightChild != null)
      rightChild.enumerate(callback);
  }

  public List<T> toList() {
    List<T> list = new ArrayList<T>();
    enumerate(x -> list.add(x));

    return list;
  }*/
}
