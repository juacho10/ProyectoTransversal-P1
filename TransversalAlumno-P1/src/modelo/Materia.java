package modelo;

public class Materia {
    private int id_materia;
    private String nombreMateria;
    boolean estado;

    public Materia(int id_materia, String nombreMateria, boolean estado) {
        this.id_materia = id_materia;
        this.nombreMateria = nombreMateria;
        this.estado = estado;
    }

    public Materia(String nombreMateria, boolean estado) {
        this.nombreMateria= nombreMateria;
        this.estado = estado;
    }

    public Materia() {
    }
    
    public boolean isEstado() {    
        return estado;
    }

    //getter y setter
    public void setEstado(boolean estado) {    
        this.estado = estado;
    }

    public int getId_materia() {
        return id_materia;
    }

    public void setId_materia(int id_materia) {
        this.id_materia = id_materia;
    }

    public String getNombreMateria() {
        return nombreMateria;
    }

    public void setNombreMateria(String nombreMateria) {
        this.nombreMateria = nombreMateria;
    }

    @Override
    public String toString() {
        return id_materia + ", " + nombreMateria;
    }
    
    
}
