package modelo;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.table.DefaultTableModel;

public class Cliente extends Persona {
    private String nit;
    private int id;
    
    conexion cn;
    
    public Cliente(String nit, int id, String nombres, String apellidos, String direccion, String telefono, String fe_nac) {
        super(nombres, apellidos, direccion, telefono, fe_nac);
        this.nit = nit;
        this.id = id;
    }

    public Cliente(){}

    public String getNit() {
        return nit;
    }

    public void setNit(String nit) {
        this.nit = nit;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
    

    @Override
    public DefaultTableModel leer(){
        DefaultTableModel tabla = new DefaultTableModel();
        try{
            
            cn = new conexion();
            cn.abrir_cn();
            String query="";
            query = "select id_clientes as id,nit,nombres,apellidos, direccion, telefono,fecha_nacimiento from clientes";
            ResultSet consulta = cn.cnbd.createStatement().executeQuery(query);
            String encabezado[]=
            {"id","Nit","Nombres","Apellidos","Direccion","Telefono","Nacimiento"};
            tabla.setColumnIdentifiers(encabezado);
            String datos[]=new String[7];
            while(consulta.next()){
                datos[0] = consulta.getString("id");
                datos[1] = consulta.getString("nit");
                datos[2] = consulta.getString("nombres");
                datos[3] = consulta.getString("apellidos");
                datos[4] = consulta.getString("direccion");
                datos[5] = consulta.getString("telefono");
                datos[6] = consulta.getString("fecha_nacimiento");
                tabla.addRow(datos);
            }
            cn.cerrar_cn();
            
        }catch(SQLException ex){
            System.out.println("Error: " + ex.getMessage());
        }
        
        return tabla;
    }
    
    @Override
    public void crear(){
        try{
            PreparedStatement parametro;
            cn = new conexion();
            cn.abrir_cn();
            String query;
            query = "insert into clientes (nit,nombres,apellidos,direccion,telefono,fecha_nacimiento) values (?,?,?,?,?,?);";
            parametro = (PreparedStatement) cn.cnbd.prepareStatement(query);
            parametro.setString(1, getNit());
            parametro.setString(2, getNombres());
            parametro.setString(3, getApellidos());
            parametro.setString(4, getDireccion());
            parametro.setString(5, getTelefono());
            parametro.setString(6, getFe_nac());
            int executar = parametro.executeUpdate();
            
            System.out.println("Se insertó: " + Integer.toString(executar) + " Registro");
            cn.cerrar_cn();
        
        }catch(SQLException ex){
        System.out.println("ERROR: " + ex.getMessage());
        
        }
    
    }
    
    @Override
    public void actualizar(){
    try{
            PreparedStatement parametro;
            cn = new conexion();
            cn.abrir_cn();
            String query;
            query = "update clientes set nit=?,nombres=?,apellidos=?, direccion=?, telefono=?,fecha_nacimiento=? where id_clientes=?;";
            parametro = (PreparedStatement) cn.cnbd.prepareStatement(query);
            parametro.setString(1, this.getNit());
            parametro.setString(2, this.getNombres());
            parametro.setString(3, this.getApellidos());
            parametro.setString(4, this.getDireccion());
            parametro.setString(5, this.getTelefono());
            parametro.setString(6, this.getFe_nac());
            parametro.setInt(7, getId());
            int executar = parametro.executeUpdate();
            
            System.out.println("Se insertó: " + Integer.toString(executar) + "Registro");
            cn.cerrar_cn();
        
        }catch(SQLException ex){
        System.out.println("ERROR: " + ex.getMessage());
        
        }
    }
    
    public void eliminar(){
    try{
            PreparedStatement parametro;
            cn = new conexion();
            cn.abrir_cn();
            String query;
            query = "delete from clientes where id_clientes=?;";
            parametro = (PreparedStatement) cn.cnbd.prepareStatement(query);
            parametro.setInt(1, getId());
            int executar = parametro.executeUpdate();
            System.out.println("Se eliminó: " + Integer.toString(executar) + "Registro");
            cn.cerrar_cn();
        }catch(SQLException ex){
        System.out.println("ERROR: " + ex.getMessage());
        
        }
    }
    
}
