package uvg.edu.gt;
import java.util.Vector;

/**
 * Clase VectorHeap
 * Fernando Rueda - 23748
 * Implementación de una cola de prioridad usando un montículo (heap).
 * 
 * @param <E> El tipo de elementos que la cola de prioridad va a manejar. Debe ser una clase que implemente la interfaz Comparable.
 */
public class VectorHeap<E extends Comparable<E>> implements PriorityQueue<E>{
    private Vector<E> data; 

    /**
     * Constructor que inicializa el vector que almacena los datos.
     */    
    public VectorHeap() {
        data = new Vector<E>();
    }

    /**
     * Calcula el índice del padre de un nodo dado.
     * 
     * @param i Índice del nodo.
     * @return Índice del padre del nodo.
     */    
    protected int parent(int i) { return (i-1)/2; }

    /**
     * Calcula el índice del hijo izquierdo de un nodo dado.
     * 
     * @param i Índice del nodo.
     * @return Índice del hijo izquierdo del nodo.
     */
    protected int left(int i) { return 2*i + 1; }

    /**
     * Calcula el índice del hijo derecho de un nodo dado.
     * 
     * @param i Índice del nodo.
     * @return Índice del hijo derecho del nodo.
     */
    protected int right(int i) { return (2*i) + 2; }
    
    /**
     * Mueve un nodo hacia arriba en el montículo hasta que se restablezca la propiedad del montículo.
     * 
     * @param leaf Índice del nodo a percolar hacia arriba.
     */
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
    
    /**
     * Mueve el nodo raíz hacia abajo en el montículo hasta que se restablezca la propiedad del montículo.
     * 
     * @param root Índice del nodo raíz a percolar hacia abajo.
     */
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
    
    @Override
    public void add(E value) {
        data.add(value);
        percolateUp(data.size() - 1);
    }
    
    @Override
    public E remove() {
        E minVal = data.get(0);
        data.set(0, data.get(data.size() - 1));
        data.setSize(data.size() - 1);
        if (data.size() > 1) pushDownRoot(0);
        return minVal;
    }
    
    @Override
    public int size() { return data.size(); }

    @Override
    public boolean isEmpty() { return size() == 0; }    
}
