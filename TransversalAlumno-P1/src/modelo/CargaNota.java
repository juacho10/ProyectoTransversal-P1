
package modelo;

public class CargaNota {
    private int id;
    private int idInscripcion;
    private double nota;

    public CargaNota(int id, int idInscripcion, double nota) {
        this.id = id;
        this.idInscripcion = idInscripcion;
        this.nota = nota;
    }

    // Getters y Setters

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getIdInscripcion() {
        return idInscripcion;
    }

    public void setIdInscripcion(int idInscripcion) {
        this.idInscripcion = idInscripcion;
    }

    public double getNota() {
        return nota;
    }

    public void setNota(double nota) {
        this.nota = nota;
    }
}

