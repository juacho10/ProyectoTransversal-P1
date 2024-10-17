
package modelo;

public class Inscripcion {
    
    private int id_inscripcion;
    private int id_materia;
    private int id_alumno;
    private boolean bajaAlta = true;

    public Inscripcion(int id_inscripcion, int id_materia, int id_alumno, boolean bajaAlta) {
        this.id_inscripcion = id_inscripcion;
        this.id_materia = id_materia;
        this.id_alumno = id_alumno;
        this.bajaAlta = bajaAlta;
    }

    public Inscripcion(int id_materia, int id_alumno, boolean bajaAlta) {
        this.id_materia = id_materia;
        this.id_alumno = id_alumno;
        this.bajaAlta = bajaAlta;
    }

    public Inscripcion() {
    }

    public Inscripcion(int id_materia, int id_alumno) {
        this.id_materia = id_materia;
        this.id_alumno = id_alumno;
    }

    

    public int getId_inscripcion() {
        return id_inscripcion;
    }

    public void setId_inscripcion(int id_inscripcion) {
        this.id_inscripcion = id_inscripcion;
    }

    public int getId_materia() {
        return id_materia;
    }

    public void setId_materia(int id_materia) {
        this.id_materia = id_materia;
    }

    public int getId_alumno() {
        return id_alumno;
    }

    public void setId_alumno(int id_alumno) {
        this.id_alumno = id_alumno;
    }

    public boolean isBajaAlta() {
        return bajaAlta;
    }

    public void setBajaAlta(boolean bajaAlta) {
        this.bajaAlta = bajaAlta;
    }

    @Override
    public String toString() {
        return "Inscripcion{" + "id_inscripcion=" + id_inscripcion + ", id_materia=" + id_materia + ", id_alumno=" + id_alumno + ", bajaAlta=" + bajaAlta + '}';
    }


    
}
