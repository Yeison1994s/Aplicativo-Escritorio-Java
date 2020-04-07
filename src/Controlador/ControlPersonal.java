package Controlador;

import conexion.Conexion;
import java.util.ArrayList;
import Model.Personal;

/**
 *
 * @author Darwin Durand
 */
public class ControlPersonal {

    public ArrayList<Personal> getPersonal() {
        return Conexion.getPersonal(Personal.SELECT_ALL_NO_FOTO);
    }

    public int insertPersonal(Personal cl) {
        return Conexion.grabarPersonal(cl);
    }

    public int actualzarPersonal(Personal cl) {
        return Conexion.actualizarPersonal(cl);
    }

    public int eliminarPersonal(Integer pk) {
        return Conexion.eliminarPersonal(pk);
    }
}
