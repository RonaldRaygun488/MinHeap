import java.lang.Comparable;
import java.util.Stack;

public class MinHeap<T extends Comparable<T>>{
    private HeapNode rootNode;

    public MinHeap(){
        this.rootNode = null;
    }

    public void add(T value){
        if(this.rootNode == null){
            this.rootNode = new HeapNode(value);
            return;
        }

        SimpleQueue<HeapNode> bfsQ = new SimpleQueue<>();

        bfsQ.add(this.rootNode);

        while(bfsQ.hasNext()){
            HeapNode currentNode = bfsQ.remove();

            if(currentNode.leftChild == null){
                this.bubble(currentNode.leftChild = new HeapNode(value, currentNode));
                return;
            }
            if(currentNode.rightChild == null){
                this.bubble(currentNode.rightChild = new HeapNode(value, currentNode));
                return;
            }

            bfsQ.add(currentNode.leftChild);
            bfsQ.add(currentNode.rightChild);
        }
    }

    private void bubble(HeapNode nodeToBubble){
        while(nodeToBubble.parent != null && nodeToBubble.value.compareTo(nodeToBubble.parent.value) < 0){
            T temp = nodeToBubble.value;
            nodeToBubble.value = nodeToBubble.parent.value;
            nodeToBubble.parent.value = temp;
            nodeToBubble = nodeToBubble.parent;
        }
    }

    private class HeapNode{
        public T value;
        public HeapNode leftChild, rightChild, parent;

        public HeapNode(){

        }

        public HeapNode(T value){
            this.value = value;
            this.parent = null;
        }

        public HeapNode(T value, HeapNode parent){
            this.value = value;
            this.parent = parent;
        }
    }
}