/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;

/**
 *
 * @author Francisco
 */
public class Encomienda {
    private Integer id;
    private String destinatario;
    private String direccion;
    private String tipo;
    private boolean entregaDomicilio;
    private String tamano;
    private String remitente;

    public Encomienda() {
    }

    public Encomienda(int id, String destinatario, String direccion, String tipo, boolean entregaDomicilio, String tamano, String remitente) {
        this.id = id;
        this.destinatario = destinatario;
        this.direccion = direccion;
        this.tipo = tipo;
        this.entregaDomicilio = entregaDomicilio;
        this.tamano = tamano;
        this.remitente = remitente;
    }

    public Integer getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDestinatario() {
        return destinatario;
    }

    public void setDestinatario(String destinatario) {
        this.destinatario = destinatario;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public boolean isEntregaDomicilio() {
        return entregaDomicilio;
    }

    public void setEntregaDomicilio(boolean entregaDomicilio) {
        this.entregaDomicilio = entregaDomicilio;
    }

    public String getTamano() {
        return tamano;
    }

    public void setTamano(String tamano) {
        this.tamano = tamano;
    }

    public String getRemitente() {
        return remitente;
    }

    public void setRemitente(String remitente) {
        this.remitente = remitente;
    }

    @Override
    public String toString() {
        return "Encomienda{" + "id=" + id + ", destinatario=" + destinatario + ", direccion=" + direccion + ", tipo=" + tipo + ", entregaDomicilio=" + entregaDomicilio + ", tamano=" + tamano + ", remitente=" + remitente + '}';
    }
    
    public static String validarEncomienda(Encomienda enc){
        String validationMsg = "";
        if(enc.getId() == null) validationMsg += "Id requerido\n";
        if(enc.getDestinatario().isBlank()) validationMsg += "Destinatario requerido\n";
        if(enc.getDireccion().isBlank()) validationMsg += "Dirección requerida \n";
        if(enc.getRemitente().isBlank()) validationMsg += "Remitente requerido \n";
        if(enc.getTamano().isBlank()) validationMsg += "Tamaño requerido \n";
        return validationMsg;
    }
}
