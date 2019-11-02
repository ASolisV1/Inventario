package Conexion;
import Modelo.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
public class Conexion {
    // Generar constantes de conexion
//    private final String base="llfgmzng";
//    private final String user="llfgmzng";
//    private final String password="gek4eeSRtK8u_dpsD4dlT276hhhTTlyH";
//    private final String url="jdbc:postgresql://raja.db.elephantsql.com/"+base;

    private final String base="pinguentory";
    private final String user="postgres";
    private final String password="123456";
    private final String url="jdbc:postgresql://localhost:5434/"+base;



    // Variable para la conexion
    private Connection con = null;
    // Metodo de tipo Connection llamado getConexion 
    public Connection getConexion() {
         
        try {
            Class.forName("org.postgresql.Driver");
            con = DriverManager.getConnection(this.url,this.user,this.password);
            
            if(con!=null){
                System.out.println("Conectado a la Base de Datos de ServiSoft");
                
            }
        } catch (SQLException ex) {
            System.out.println("error en conexion: "+ex);
            
       } catch (ClassNotFoundException ex) {
            Logger.getLogger(Conexion.class.getName()).log(Level.SEVERE, null, ex);
            
        }
        return con;        
    }    
}
