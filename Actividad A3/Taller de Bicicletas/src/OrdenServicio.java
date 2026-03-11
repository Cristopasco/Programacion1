import java.util.ArrayList;

public class OrdenServicio {

    public Bicicleta bicicleta;
    public Mecanico mecanico;
    public String descripcion;
    public String fechaIngreso;
    public EstadoOrden estado;

    public ArrayList<Tarea> tareas = new ArrayList<>();
    public ArrayList<Repuesto> repuestos = new ArrayList<>();

    public OrdenServicio(Bicicleta bicicleta, String descripcion, String fechaIngreso) {

        this.bicicleta = bicicleta;
        this.descripcion = descripcion;
        this.fechaIngreso = fechaIngreso;
        this.estado = EstadoOrden.RECIBIDA;
    }

    public void asignarMecanico(Mecanico m) {
        mecanico = m;
    }

    public void agregarTarea(Tarea t) {
        tareas.add(t);
    }

    public void agregarRepuesto(Repuesto r) {
        repuestos.add(r);
    }

    public void cambiarEstado(EstadoOrden e) {
        estado = e;
    }

    public double calcularCostoTotal() {

        double total = 0;

        for (Tarea t : tareas)
            total += t.costo;

        for (Repuesto r : repuestos)
            total += r.cantidad * r.costoUnitario;

        return total;
    }
}