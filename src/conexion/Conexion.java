package conexion;

import Clases.CustomImageIcon;
import Model.Personal;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.InputStream;
import java.sql.*;
import java.util.ArrayList;
import javax.imageio.ImageIO;
import javax.swing.JOptionPane;

public class Conexion {

    
    private static Connection conex = null;
    private static Statement state = null;
    private static PreparedStatement pState = null;
    private static ResultSet reSet = null;
    private final String URL = "jdbc:mysql://localhost/equiposfutboles";
    private final String pasword = "";
    private final String Driver = "com.mysql.jdbc.Driver";//aqui es donde pcambio para otro servidor
    protected Connection conn = null;//los atributos obejecto de la clase conn  para heredar lainterrelacion base de ddatos
    private static String servidor = "localhost";
    private static String nombreBD = "equiposfutboles";
    private static String usuario = "root";
    private static String clave = "admin";
    
      public static String getNombreBD() {
        return nombreBD;
    }

    public static void setNombreBD(String nombreBD) {
        Conexion.nombreBD = nombreBD;
    }

    public static String getUsuario() {
        return usuario;
    }

    public static void setUsuario(String usuario) {
        Conexion.usuario = usuario;
    }

    public static String getClave() {
        return clave;
    }

    public static void setClave(String clave) {
        Conexion.clave = clave;
    }
    
    
 
public static boolean conectar() {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            String url = "jdbc:mysql://" + servidor + ":3306/" + nombreBD;
            conex = DriverManager.getConnection(url, usuario, clave);

        } catch (ClassNotFoundException ex) {
            ex.printStackTrace();
        } catch (SQLException ex) {
            String msg = "";
            if (ex.getErrorCode() == 1049) {
                msg = "La base de datos: " + nombreBD + " no existe.";
            } else if (ex.getErrorCode() == 1044) {
                msg = "El usuario: " + usuario + " no existe.";
            } else if (ex.getErrorCode() == 1045) {
                msg = "Contraseña incorrecta.";
            } else if (ex.getErrorCode() == 0) {
                msg = "La conexión con la base de datos no se puede realizar.\n Parece que el servidor de base de datos no esta activo.";
            }
            JOptionPane.showMessageDialog(null, msg, ex.getMessage(), JOptionPane.ERROR_MESSAGE);
            return false;
        }
        if (conex != null) {
            System.out.println("Conexión Exitosa.");
            return true;
        }
        return false;

    }
  
        
          public void getErrorSQL(SQLException error){
               
              System.out.print("error de mensaje" + error.getMessage());
              System.out.print("codigo" + error.getErrorCode());
              System.out.print("estado" + error.getSQLState());
             
          }      
          
  public static ArrayList<Personal> getPersonal(String consulta) {
        ArrayList<Personal> Personal = new ArrayList<Personal>();
        Personal cl = null;
        if (conex == null) {
            conectar();
        }
        try {
            state = conex.createStatement();
            reSet = state.executeQuery(consulta);
            while (reSet.next()) {
                cl = new Personal();
                cl.setPrimaryKey(reSet.getInt(1));
                cl.setNombre_com(reSet.getString(2));
                cl.setNombre_usu(reSet.getString(3));
                cl.setEmail(reSet.getString(4));
                Personal.add(cl);
            }
            state.close();
            reSet.close();
        } catch (SQLException ex) {
        }

        return Personal;
    }

    public static int grabarPersonal(Personal cl) {
        int rsu = 0;
        String sql = Personal.INSERT_CON_FOTO;
        if (cl.getFoto() == null) {
            sql = Personal.INSERT_SIN_FOTO;
        }
        if (conex == null) {
            conectar();
        }
        try {
            pState = conex.prepareStatement(sql);
            pState.setString(1, cl.getNombre_usu());
            pState.setString(2, cl.getNombre_com());
            pState.setString(3, cl.getFecha_nac());
            if (cl.getFoto() != null) {
                pState.setBinaryStream(4, cl.getFoto());
            }
            rsu = pState.executeUpdate();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        System.out.println(sql);
        return rsu;

    }

    public static int actualizarPersonal(Personal cl) {
        int rsu = 0;
        String sql = Personal.UPDATE_CON_FOTO;
        if (cl.getFoto() == null) {
            sql = Personal.UPDATE_SIN_FOTO;
        }
        if (conex == null) {
            conectar();
        }
        try {
            pState = conex.prepareStatement(sql);
            pState.setString(1, cl.getNombre_usu());
            pState.setString(2, cl.getNombre_com());
            pState.setString(3, cl.getFecha_nac());
            if (cl.getFoto() != null) {
                pState.setBinaryStream(4, cl.getFoto());
                pState.setInt(5, cl.getPrimaryKey());
            } else {
                pState.setInt(4, cl.getPrimaryKey());
            }
            rsu = pState.executeUpdate();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        System.out.println(sql);
        return rsu;

    }

    public static int eliminarPersonal(Integer pk) {
        int rsu = 0;
        String sql = Personal.DELETE;

        if (conex == null) {
            conectar();
        }
        try {
            pState = conex.prepareStatement(sql);
            pState.setInt(1, pk);
            rsu = pState.executeUpdate();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        System.out.println(sql);
        return rsu;

    }

    public static CustomImageIcon getFoto(int id) {
        String sql = "select foto from Personal where codigo = " + id;
        CustomImageIcon ii = null;
        InputStream is = null;
        if (conex == null) {
            conectar();
        }
        try {

            state = conex.createStatement();
            reSet = state.executeQuery(sql);
            if (reSet.next()) {
                is = reSet.getBinaryStream(1);
                if (is != null) {

                    BufferedImage bi = ImageIO.read(is);
                    ii = new CustomImageIcon(bi);
                }

            }

        } catch (SQLException ex) {
            ex.printStackTrace();
        } catch (IOException ex) {
            ex.printStackTrace();
        }

        return ii;
    }

    public static boolean existeEmail(String email) {
        String sql = "select email from Personal where email like ? ";
        boolean emailEncontrado = false;
        if (conex == null) {
            conectar();
        }
        try {
            pState = conex.prepareStatement(sql);
            pState.setString(1, email);
            reSet = pState.executeQuery();
            if (reSet.next()) {
                emailEncontrado = true;
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        System.out.println(sql);
        return emailEncontrado;

    }
}