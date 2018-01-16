import java.util.ArrayList;

public class SimpleQueue<T>{
  private ArrayList<T> queue = new ArrayList<T>();

  public T remove(){
    return this.queue.remove(0);
  }

  public void add(T elementToAdd){
    this.queue.add(elementToAdd);
    //System.out.println(queue.get(0));
  }

  public boolean hasNext(){
    return !this.queue.isEmpty();
  }
}
