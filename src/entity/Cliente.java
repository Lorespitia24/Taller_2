package entity;

public class Cliente {

    private int id;
    private int cedula;
	private String nombre;
    private String empresa;
    private static int ID_GENERIC = 1;

    public Cliente(String nombre,int cedula, String empresa) {
        this.id = ID_GENERIC;
        this.nombre = nombre;
        this.cedula = cedula;
        this.empresa = empresa;
    }

    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public String getNombre() {
        return nombre;
    }
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    public String getEmpresa() {
        return empresa;
    }
    public void setEmpresa(String empresa) {
        this.empresa = empresa;
    }

    public int getCedula() {
        return cedula;
    }

    public void setCedula(int cedula) {
        this.cedula = cedula;
    }

    @Override
    public String toString() {
        return "Cliente cedula: " + cedula + ", nombre: " + nombre + ", empresa: " + empresa;
    }

    
    
    
}
