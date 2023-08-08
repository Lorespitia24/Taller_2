package entity;

import java.util.ArrayList;
/*
  1. Registro de Alumnos:
Crea una clase Alumno con propiedades como nombre, edad y calificaciones. Luego, crea
una clase SistemaAlumnos que permite agregar alumnos,asignar calificaciones , calcular el
promedio de sus calificaciones y mostrar la información de cada alumno.
 */
public class Alumno {
    
		private int id;
		private String nombre;
		private int edad;
		private ArrayList<Materia> listaNotas;
        private static int ID_GENERIC = 1;

        public Alumno(String nombre, int edad) {
            this.id = ID_GENERIC++;
            this.nombre = nombre;
            this.edad = edad;
            this.listaNotas = new ArrayList<>();
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
        public int getEdad() {
            return edad;
        }
        public void setEdad(int edad) {
            this.edad = edad;
        }
        public ArrayList<Materia> getListaNotas() {
            return listaNotas;
        }
        public void setListaNotas(ArrayList<Materia> listaNotas) {
            this.listaNotas = listaNotas;
        }

        
        
        @Override
        public String toString() {
            return "Alumnno "+ id+ " - " + nombre  ;
        } 

      



        
        
        
        
}

