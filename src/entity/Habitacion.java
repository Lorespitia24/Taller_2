package entity;

public class Habitacion {

    private int numeroHabitacion;
    private boolean estadoHabitacion;
    private Cliente cliente;
    
    public Habitacion(int numeroHabitacion, boolean estadoHabitacion) {
        this.numeroHabitacion = numeroHabitacion;
        this.estadoHabitacion = estadoHabitacion;
    }

    public int getNumeroHabitacion() {
        return numeroHabitacion;
    }

    public void setNumeroHabitacion(int numeroHabitacion) {
        this.numeroHabitacion = numeroHabitacion;
    }

    public boolean isEstadoHabitacion() {
        return estadoHabitacion;
    }

    public void setEstadoHabitacion(boolean estadoHabitacion) {
        this.estadoHabitacion = estadoHabitacion;
    }
  
    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    @Override
    public String toString() {
        return "Habitacion: " + numeroHabitacion + ", Estado: " + (estadoHabitacion != true ? "Disponible" : "Ocupada" )  + "\n";
    }


    
}
