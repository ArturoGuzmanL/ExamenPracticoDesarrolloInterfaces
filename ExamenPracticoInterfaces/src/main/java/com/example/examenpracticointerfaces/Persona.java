package com.example.examenpracticointerfaces;

public class Persona {

    String nombre;
    String sexo;
    int edad;
    int peso;
    int altura;
    String actividad;
    double GER;
    double GET;

    public Persona(String nombre, String sexo, int edad, int peso, int altura, String actividad, double ger, double get) {
        this.nombre = nombre;
        this.sexo = sexo;
        this.edad = edad;
        this.peso = peso;
        this.altura = altura;
        this.actividad = actividad;
        this.GER = ger;
        this.GET = get;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getSexo() {
        return sexo;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public int getPeso() {
        return peso;
    }

    public void setPeso(int peso) {
        this.peso = peso;
    }

    public int getAltura() {
        return altura;
    }

    public void setAltura(int altura) {
        this.altura = altura;
    }

    public String getActividad() {
        return actividad;
    }

    public void setActividad(String actividad) {
        this.actividad = actividad;
    }

    public double getGER() {
        return GER;
    }

    public void setGER(double GER) {
        this.GER = GER;
    }

    public double getGET() {
        return GET;
    }

    public void setGET(double GET) {
        this.GET = GET;
    }
}
