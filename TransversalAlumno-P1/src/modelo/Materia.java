package modelo;

public class Materia {
    private int id_materia;
    private String nombreMateria;

    public Materia(int id_materia, String nombreMateria) {
        this.id_materia = id_materia;
        this.nombreMateria = nombreMateria;
    }

    public Materia(String nombreMateria) {
        this.nombreMateria= nombreMateria;
    }

    public Materia() {
    }
    
    
    //getter y setter

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
        return "Materia{" + "id_materia=" + id_materia + ", nombreMateria=" + nombreMateria + '}';
    }
    
    
    
    
    
}
