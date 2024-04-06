package uvg.edu.gt;
import java.util.Vector;

public class VectorHeap<E extends Comparable<E>> implements PriorityQueue<E>{
    private Vector<E> data; 

    public VectorHeap() {
        data = new Vector<E>();
    }

    protected int parent(int i) { return (i-1)/2; }
    protected int left(int i) { return 2*i + 1; }
    protected int right(int i) { return (2*i) + 2; }
    
    protected void percolateUp(int leaf) {
        int parent = parent(leaf);
        E value = data.get(leaf);
        while (leaf > 0 && (value.compareTo(data.get(parent)) < 0)) {
            data.set(leaf, data.get(parent));
            leaf = parent;
            parent = parent(leaf);
        }
        data.set(leaf, value);
    }
    
    protected void pushDownRoot(int root) {
        int heapSize = data.size();
        E value = data.get(root);
        while (root < heapSize) {
            int childpos = left(root);
            if (childpos < heapSize) {
                if ((right(root) < heapSize) && ((data.get(childpos+1)).compareTo(data.get(childpos)) < 0)) {
                    childpos++;
                }
                if ((data.get(childpos)).compareTo(value) < 0) {
                    data.set(root, data.get(childpos));
                    root = childpos;
                } else {
                    data.set(root, value);
                    return;
                }
            } else {
                data.set(root, value);
                return;
            }
        }
    }
    
    public void add(E value) {
        data.add(value);
        percolateUp(data.size() - 1);
    }
    
    public E remove() {
        E minVal = data.get(0);
        data.set(0, data.get(data.size() - 1));
        data.setSize(data.size() - 1);
        if (data.size() > 1) pushDownRoot(0);
        return minVal;
    }
    
    public int size() { return data.size(); }
    public boolean isEmpty() { return size() == 0; }    
}
