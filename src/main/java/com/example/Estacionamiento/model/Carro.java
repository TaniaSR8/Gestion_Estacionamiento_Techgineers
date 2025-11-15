package com.example.Estacionamiento.model;

public class Carro {

    //Atributos de la clase Carro
    private int id;
    private String placa;
    private String marca;
    private String color;
    private String horaEntrada; //Guarda la hora de entrada como texto(primera version, se puede cambiar)
    private String horaSalida; //Guarda la hora de salida  como texto(primera version, se puede cambiar)

    //Este método indica si el carro sigue estacionado:
    //Devuelve true si tiene hora de entrada pero aun no tiene hora de salida
    public boolean estaEstacionado(){
        return horaEntrada != null && horaSalida == null;
    }

    //Métodos getter y setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getPlaca() {
        return placa;
    }

    public void setPlaca(String placa) {
        this.placa = placa;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getHoraEntrada() {
        return horaEntrada;
    }

    public void setHoraEntrada(String horaEntrada) {
        this.horaEntrada = horaEntrada;
    }

    public String getHoraSalida() {
        return horaSalida;
    }

    public void setHoraSalida(String horaSalida) {
        this.horaSalida = horaSalida;
    }

    @Override
    public String toString() {
        return "Carro{id=" + id +
                ", placa='" + placa + '\'' +
                ", marca='" + marca + '\'' +
                ", color='" + color + '\'' +
                ", horaEntrada='" + horaEntrada + '\'' +
                ", horaSalida='" + horaSalida + '\'' +
                '}';
    }


}
