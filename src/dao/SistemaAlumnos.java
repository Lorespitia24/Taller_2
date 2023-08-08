package dao;

import java.util.ArrayList;

import entity.Alumno;
import entity.Materia;

public class SistemaAlumnos {

	private ArrayList<Alumno> listaAlumnos;

	public SistemaAlumnos() {
		listaAlumnos = new ArrayList<>();
	}

    //crear lista alumnos
	public void agregarAlumno(String nombre, int edad) {
		listaAlumnos.add(new Alumno(nombre, edad));
	}

    public void agregarMaterias(Alumno alumno, String nombreMateria, double calificacion) {
        for (int i = 0; i < listaAlumnos.size(); i++) {
			if (listaAlumnos.get(i).getId() == alumno.getId()) {
                alumno.getListaNotas().add(new Materia(nombreMateria, calificacion));
				listaAlumnos.remove(i);
				listaAlumnos.add(i, alumno); 
				break;
			}
		}
	}

    public double calcularPromedio(Alumno alumno){
        double promedio = 0;
        for (Materia materia : alumno.getListaNotas()) {
            promedio += materia.getCalificacion();
        }
        promedio = promedio / alumno.getListaNotas().size();
        return promedio;
    }

        public ArrayList<Alumno> getListaAlumnos() {
            return listaAlumnos;
        }

}
