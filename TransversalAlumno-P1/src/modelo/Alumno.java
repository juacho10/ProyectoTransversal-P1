package modelo;

import java.time.LocalDate;

public class Alumno {

    private int id_alumno;
    private String nombre;
    private String apellido;
    private String dni;
    private LocalDate fechaNacimiento;
    private boolean activo;

    public Alumno(int id_alumno, String nombre, String apellido, String dni, LocalDate fechaNacimiento, boolean activo) {
        this.id_alumno = id_alumno;
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

    public boolean isActivo() {
        return activo;
    }

    // Getters y setters
    public void setActivo(boolean activo) {
        this.activo = activo;
    }

    public int getId_alumno() {
        return id_alumno;
    }

    public void setId_alumno(int id_alumno) {
        this.id_alumno = id_alumno;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public LocalDate getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(LocalDate fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    @Override
    public String toString() {
        return apellido + ", " + nombre + " - DNI: " + dni; // Asegúrate de que estos sean los nombres de los campos
    }

}
