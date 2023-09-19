
package modelo;

import javax.swing.table.DefaultTableModel;

abstract class Persona {
    private String nombres, apellidos, direccion, telefono, fe_nac;

    public Persona(String nombres, String apellidos, String direccion, String telefono, String fe_nac) {
        this.nombres = nombres;
        this.apellidos = apellidos;
        this.direccion = direccion;
        this.telefono = telefono;
        this.fe_nac = fe_nac;
    }
    
    public Persona(){};

    public String getNombres() {
        return nombres;
    }

    public void setNombres(String nombres) {
        this.nombres = nombres;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getFe_nac() {
        return fe_nac;
    }

    public void setFe_nac(String fe_nac) {
        this.fe_nac = fe_nac;
    }
    
    protected void crear(){}
    protected DefaultTableModel leer(){return null;}
    protected void actualizar(){}
    protected void borrar(){}
}
