package actividad;

public class Tarea extends Actividad {
    private boolean enviada;

    public Tarea(String descripcion, String objetivo, int nivelDificultad, int duracionEsperada) {
        super(descripcion, objetivo, nivelDificultad, duracionEsperada);
        this.enviada = false;
    }

    public void enviarTarea() {
        this.enviada = true;
        System.out.println("Tarea enviada.");
    }

    @Override
    public void completarActividad() {
        if (enviada) {
            super.completarActividad();
            System.out.println("Tarea completada y evaluada.");
        } else {
            System.out.println("La tarea debe ser enviada antes de ser marcada como completada.");
        }
    }
}
