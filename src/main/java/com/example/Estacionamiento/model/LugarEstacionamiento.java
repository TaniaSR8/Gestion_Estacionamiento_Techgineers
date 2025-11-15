package com.example.Estacionamiento.model;

    //Esta clase LugarEstacionamiento, representa un lugar dentro del estacionamiento
public class LugarEstacionamiento {

    private int id;
    private String numero;
    private boolean ocupado;
    private int idCarro;

    //Este método es para ocupar el lugar con un carro
    public void ocupar(int idCarro){
        this.ocupado = true;
        this.idCarro = idCarro;

    }

    //Método para liberar el lugar
    public void liberar(){
        this.ocupado = false;
        this.idCarro = 0;
    }

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public String getNumero() {
            return numero;
        }

        public void setNumero(String numero) {
            this.numero = numero;
        }

        public boolean esOcupado() {
            return ocupado;
        }

        public void setOcupado(boolean ocupado) {
            this.ocupado = ocupado;
        }

        public int getIdCarro() {
            return idCarro;
        }

        public void setIdCarro(int idCarro) {
            this.idCarro = idCarro;
        }

        @Override
        public String toString() {
            return "Lugar{id=" + id +
                    ", numero='" + numero + '\'' +
                    ", ocupado=" + ocupado +
                    ", idCarro=" + idCarro +
                    '}';
        }


    }
