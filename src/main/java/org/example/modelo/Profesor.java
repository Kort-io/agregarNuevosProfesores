package org.example.modelo;

public class Profesor extends PersonaUt {
    private int numEmpleado;
    private String puesto;
    private double sueldo;

    public Profesor() {}

    public Profesor(String nombre, String curp, int numEmpleado, String puesto, double sueldo) {
        super(nombre, curp);
        setNumEmpleado(numEmpleado);
        setPuesto(puesto);
        setSueldo(sueldo);
    }

    public int getNumEmpleado() {
        return numEmpleado;
    }

    public void setNumEmpleado(int numEmpleado) {
        this.numEmpleado = numEmpleado;
    }

    public String getPuesto() {
        return puesto;
    }

    public void setPuesto(String puesto) {
        this.puesto = puesto;
    }

    public double getSueldo() {
        return sueldo;
    }

    public void setSueldo(double sueldo) {
        this.sueldo = sueldo;
    }

    @Override
    public String toString() {
        return "Número de Empleado: " + getNumEmpleado() + "\n" +
                super.toString() + "\n" +
                "Puesto: " + getPuesto() + "\n" +
                "Sueldo: " + getSueldo() + "\n" +
                "=====================================";
    }
}
