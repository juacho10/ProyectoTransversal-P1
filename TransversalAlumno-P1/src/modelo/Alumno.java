package modelo;

import java.time.LocalDate;

public class Alumno {
    private int id;
    private String nombre;
    private String apellido;
    private String dni;
    private LocalDate fechaNacimiento;
    private boolean activo;
    
    public Alumno(int id, String nombre, String apellido, String dni, LocalDate fechaNacimiento, boolean activo) {
        this.id = id;
        this.nombre = nombre;
        this.apellido = apellido;
        this.dni = dni;
        this.fechaNacimiento = fechaNacimiento;
        this.activo = activo;
    }

    
    
    public Alumno(String nombre, String apellido, String dni, LocalDate fechaNacimiento, boolean activo) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.dni = dni;
        this.fechaNacimiento = fechaNacimiento;
        this.activo = activo;
    }

    public Alumno() {
    }
    
    public boolean isActivo() { return activo; }    

    // Getters y setters
    public void setActivo(boolean activo) {
        this.activo = activo;
    }

    public int getId() {
        return id;
    }
    public void setId(int id) { this.id = id; }

    public String getNombre() { return nombre; }
    public void setNombre(String nombre) { this.nombre = nombre; }

    public String getApellido() { return apellido; }
    public void setApellido(String apellido) { this.apellido = apellido; }

    public String getDni() { return dni; }
    public void setDni(String dni) { this.dni = dni; }

    public LocalDate getFechaNacimiento() { return fechaNacimiento; }
    public void setFechaNacimiento(LocalDate fechaNacimiento) { this.fechaNacimiento = fechaNacimiento; }

    @Override
    public String toString() {
        return "Alumno{" + "id=" + id + ", nombre=" + nombre + ", apellido=" + apellido + ", dni=" + dni + ", fechaNacimiento=" + fechaNacimiento + '}';
    }
}
