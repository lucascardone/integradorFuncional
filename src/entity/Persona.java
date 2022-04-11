/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package entity;


public class Persona {

    private String nombreApellido;
    private String mail;
    private String ciudad;
    private Integer monto;

    public Persona() {
    }

    public Persona(String nombreApellido, String mail, String ciudad, Integer monto) {
        this.nombreApellido = nombreApellido;
        this.mail = mail;
        this.ciudad = ciudad;
        this.monto = monto;
    }

    public String getNombreApellido() {
        return nombreApellido;
    }

    public void setNombreApellido(String nombreApellido) {
        this.nombreApellido = nombreApellido;
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public String getCiudad() {
        return ciudad;
    }

    public void setCiudad(String ciudad) {
        this.ciudad = ciudad;
    }

    public Integer getMonto() {
        return monto;
    }

    public void setMonto(Integer monto) {
        this.monto = monto;
    }

    @Override
    public String toString() {
        return "Persona{" + "nombre y apellido=" + nombreApellido + ", mail=" + mail + ", ciudad=" + ciudad + ", monto=" + monto + '}';
    }
    
    
}
