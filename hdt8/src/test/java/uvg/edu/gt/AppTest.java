package uvg.edu.gt;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

/**
 * Unit test for simple App.
 */
public class AppTest 
{
    @Test
    public void addAndRemoveElements() {
        VectorHeap<Paciente> heap = new VectorHeap<>();
        heap.add(new Paciente("Juan Perez", "Fractura de pierna", 'C'));
        heap.add(new Paciente("Maria Ramirez", "Apendicitis", 'A'));
        heap.add(new Paciente("Carlos Lopez", "Dolor de cabeza", 'E'));

        // Verificar que se remueve el de mayor prioridad primero (Apendicitis)
        assertEquals('A', heap.remove().getCodigoEmergencia());
        // Luego el de siguiente prioridad (Fractura de pierna)
        assertEquals('C', heap.remove().getCodigoEmergencia());
        // Y finalmente el de menor prioridad (Dolor de cabeza)
        assertEquals('E', heap.remove().getCodigoEmergencia());
    }

    @Test
    public void isEmptyAfterRemovals() {
        VectorHeap<Paciente> heap = new VectorHeap<>();
        heap.add(new Paciente("Juan Perez", "Fractura de pierna", 'C'));
        heap.add(new Paciente("Maria Ramirez", "Apendicitis", 'A'));

        assertFalse(heap.isEmpty());
        heap.remove(); // Remueve Maria Ramirez
        heap.remove(); // Remueve Juan Perez
        assertTrue(heap.isEmpty());
    }

    @Test
    public void sizeTest() {
        VectorHeap<Paciente> heap = new VectorHeap<>();
        assertEquals(0, heap.size());

        heap.add(new Paciente("Juan Perez", "Fractura de pierna", 'C'));
        assertEquals(1, heap.size());

        heap.add(new Paciente("Maria Ramirez", "Apendicitis", 'A'));
        assertEquals(2, heap.size());

        heap.remove(); // Asume que se remueve el de mayor prioridad
        assertEquals(1, heap.size());
    }
}
