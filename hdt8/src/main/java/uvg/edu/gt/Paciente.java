package uvg.edu.gt;

/**
 * Clase Paciente
 * Fernando Rueda - 23748
 * Representa a un paciente que necesita ser atendido en una cola de prioridad según su código de emergencia.
 */
public class Paciente implements Comparable<Paciente>{
    private String nombre;
    private String sintoma;
    private char codigoEmergencia;
    
    /**
     * Constructor que crea un nuevo paciente.
     * 
     * @param nombre Nombre del paciente.
     * @param sintoma Síntoma por el cual necesita atención.
     * @param codigoEmergencia Código que representa la prioridad de atención requerida.
     */
    public Paciente(String nombre, String sintoma, char codigoEmergencia) {
        this.nombre = nombre;
        this.sintoma = sintoma;
        this.codigoEmergencia = codigoEmergencia;
    }

    public String getNombre() { return nombre; }
    public String getSintoma() { return sintoma; }
    public char getCodigoEmergencia() { return codigoEmergencia; }

    @Override
    public int compareTo(Paciente o) {
        return this.codigoEmergencia - o.codigoEmergencia;
    }

    @Override
    public String toString() {
        return nombre + ", " + sintoma + ", " + codigoEmergencia;
    }
}
