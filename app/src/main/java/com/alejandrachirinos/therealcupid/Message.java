package com.alejandrachirinos.therealcupid;

public class Message {
    private String mensaje;
    private String name;
    private String fotoPerfil;
    private String typeMessage;
    private String hora;

    public Message() {
    }

    public Message(String mensaje, String name, String fotoPerfil, String typeMessage, String hora) {
        this.mensaje = mensaje;
        this.name = name;
        this.fotoPerfil = fotoPerfil;
        this.typeMessage = typeMessage;
        this.hora = hora;
    }

    public String getMensaje() {
        return mensaje;
    }

    public void setMensaje(String mensaje) {
        this.mensaje = mensaje;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getFotoPerfil() {
        return fotoPerfil;
    }

    public void setFotoPerfil(String fotoPerfil) {
        this.fotoPerfil = fotoPerfil;
    }

    public String getTypeMessage() {
        return typeMessage;
    }

    public void setTypeMessage(String typeMessage) {
        this.typeMessage = typeMessage;
    }

    public String getHora() {
        return hora;
    }

    public void setHora(String hora) {
        this.hora = hora;
    }
}
