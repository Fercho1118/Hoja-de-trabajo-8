package uvg.edu.gt;

/**
 * Interfaz PriorityQueue
 * Fernando Rueda - 23748
 * Interfaz para definir los métodos de una cola de prioridad.
 * 
 * @param <E> El tipo de elementos que la cola de prioridad va a manejar. Debe ser una clase que implemente la interfaz Comparable.
 */
public interface PriorityQueue<E extends Comparable<E>> {

    /**
     * Agrega un elemento a la cola de prioridad.
     * 
     * @param value El elemento a agregar.
     */
    void add(E value);

    /**
     * Elimina y devuelve el elemento con mayor prioridad en la cola.
     * 
     * @return El elemento con mayor prioridad.
     */
    E remove();

    /**
     * Verifica si la cola de prioridad está vacía.
     * 
     * @return true si la cola está vacía, false en caso contrario.
     */
    boolean isEmpty();

    /**
     * Obtiene el tamaño de la cola de prioridad.
     * 
     * @return El número de elementos en la cola.
     */
    int size();
}
