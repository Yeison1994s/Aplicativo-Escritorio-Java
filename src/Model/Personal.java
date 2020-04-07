package Model;

import java.io.FileInputStream;
public class Personal {

    public static String SELECT_ALL = "SELECT * FROM tbl_usuario";
    public static String SELECT_ALL_NO_FOTO = "SELECT id, cedula , nombre_com,fecha_naci,email,nombre_usu,pasword,imagen FROM tbl_usuario";
    public static String UPDATE_CON_FOTO = "UPDATE Personal SET " + "id = ? ," + "cedula = ?, " + "nombre_com = ?, "+"telefono=? ,"+"fecha_naci=?,"+"nombre_usu=?,"+"password=?," + "imagen = ? WHERE Codigo = ?";
    public static String UPDATE_SIN_FOTO = "UPDATE  Personal SET" + "id = ? ," + "cedula = ?, " + "nombre_com = ?, "+"telefono=? ,"+"fecha_naci=?,"+"nombre_usu=?,"+"password=?," + "imagen = ? WHERE Codigo = ?"; 
    public static String INSERT_CON_FOTO = "INSERT INTO Personal" + "(nombre, id, cedula,nombre_com,telefono,fecha_naci,nombre_usu,password,imagen) VALUES(?, ?, ?, ?)";
    public static String INSERT_SIN_FOTO = "INSERT INTO Personal" + "(nombre, id, cedula,nombre_com,telefono,fecha_naci,nombre_usu,password,imagen) VALUES(?, ?, ?)";
    public static String DELETE = "DELETE FROM tbl_usuario where Codigo = ?";
    private Integer primaryKey;
    private String cedula;
    private String nombre_com;
    private String telefono;
    private String fecha_nac;
    private String email;
    private String nombre_usu;
    private FileInputStream imagen;

    public Personal(Integer primaryKey, String cedula, String nombre_com, String telefono, String fecha_nac, String email, String nombre_usu, FileInputStream imagen) {
        this.primaryKey = primaryKey;
        this.cedula = cedula;
        this.nombre_com = nombre_com;
        this.telefono = telefono;
        this.fecha_nac = fecha_nac;
        this.email = email;
        this.nombre_usu = nombre_usu;
        this.imagen = imagen;
    }

    public static String getSELECT_ALL() {
        return SELECT_ALL;
    }

    public static void setSELECT_ALL(String SELECT_ALL) {
        Personal.SELECT_ALL = SELECT_ALL;
    }

    public static String getSELECT_ALL_NO_FOTO() {
        return SELECT_ALL_NO_FOTO;
    }

    public static void setSELECT_ALL_NO_FOTO(String SELECT_ALL_NO_FOTO) {
        Personal.SELECT_ALL_NO_FOTO = SELECT_ALL_NO_FOTO;
    }

    public static String getUPDATE_CON_FOTO() {
        return UPDATE_CON_FOTO;
    }

    public static void setUPDATE_CON_FOTO(String UPDATE_CON_FOTO) {
        Personal.UPDATE_CON_FOTO = UPDATE_CON_FOTO;
    }

    public static String getUPDATE_SIN_FOTO() {
        return UPDATE_SIN_FOTO;
    }

    public static void setUPDATE_SIN_FOTO(String UPDATE_SIN_FOTO) {
        Personal.UPDATE_SIN_FOTO = UPDATE_SIN_FOTO;
    }

    public static String getINSERT_CON_FOTO() {
        return INSERT_CON_FOTO;
    }

    public static void setINSERT_CON_FOTO(String INSERT_CON_FOTO) {
        Personal.INSERT_CON_FOTO = INSERT_CON_FOTO;
    }

    public static String getINSERT_SIN_FOTO() {
        return INSERT_SIN_FOTO;
    }

    public static void setINSERT_SIN_FOTO(String INSERT_SIN_FOTO) {
        Personal.INSERT_SIN_FOTO = INSERT_SIN_FOTO;
    }

    public static String getDELETE() {
        return DELETE;
    }

    public static void setDELETE(String DELETE) {
        Personal.DELETE = DELETE;
    }

    public Personal() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public Integer getPrimaryKey() {
        return primaryKey;
    }

    public void setPrimaryKey(Integer primaryKey) {
        this.primaryKey = primaryKey;
    }

    public String getCedula() {
        return cedula;
    }

    public void setCedula(String cedula) {
        this.cedula = cedula;
    }

    public String getNombre_com() {
        return nombre_com;
    }

    public void setNombre_com(String nombre_com) {
        this.nombre_com = nombre_com;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getFecha_nac() {
        return fecha_nac;
    }

    public void setFecha_nac(String fecha_nac) {
        this.fecha_nac = fecha_nac;
    }

    public String getNombre_usu() {
        return nombre_usu;
    }

    public void setNombre_usu(String nombre_usu) {
        this.nombre_usu = nombre_usu;
    }

    public FileInputStream getImagen() {
        return imagen;
    }

    public void setImagen(FileInputStream imagen) {
        this.imagen = imagen;
    }
    public void setEmail(String email) {
        this.email = email;
    }

    public FileInputStream getFoto() {
        return imagen;
    }

    public void setFoto(FileInputStream foto) {
        this.imagen= foto;
    }

    @Override
    public String toString() {
        return  nombre_usu + nombre_com;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 67 * hash + (this.primaryKey != null ? this.primaryKey.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Personal other = (Personal) obj;
        if (this.primaryKey != other.primaryKey && (this.primaryKey == null || !this.primaryKey.equals(other.primaryKey))) {
            return false;
        }
        return true;
    }
}
