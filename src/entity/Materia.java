package entity;

public class Materia {

        private int id;
		private String nombreMateria;
		private double calificacion;
        private static int ID_GENERIC = 1;
        

        public Materia(String nombreMateria, double calificacion) {
            this.id = ID_GENERIC++;
            this.nombreMateria = nombreMateria;
            this.calificacion = calificacion;
        }
        

        public int getId() {
            return id;
        }
        public void setId(int id) {
            this.id = id;
        }
        public String getNombreMateria() {
            return nombreMateria;
        }
        public void setNombreMateria(String nombreMateria) {
            this.nombreMateria = nombreMateria;
        }
        public double getCalificacion() {
            return calificacion;
        }
        public void setCalificacion(double calificacion) {
            this.calificacion = calificacion;
        }


        @Override
        public String toString() {
            return "\n " + nombreMateria + " Nota: " + calificacion;
        }

}

