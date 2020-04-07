package Clases;

import java.util.ArrayList;
import javax.swing.table.AbstractTableModel;
import Model.Personal;

/**
 *
 * @author Darwin Durand
 */
public class ModelTablePersonal extends AbstractTableModel {

    private String[] nombreColumnas = {"usuario", "Nombre_usu", "cedula", "Email","fecha_naci","nombre_co","telefono"};
    private ArrayList<Personal> cls;

    public ModelTablePersonal(ArrayList<Personal> cls) {
        this.cls = cls;
    }

    public ModelTablePersonal() {
    }

    public void setPersonal(ArrayList<Personal> cls) {
        this.cls = cls;
    }

    @Override
    public int getRowCount() {
        return cls.size();
    }

    @Override
    public int getColumnCount() {
        return nombreColumnas.length;
    }

    @Override
    public String getColumnName(int column) {
        return nombreColumnas[column];
    }

    public Personal getFila(int index) {
        return cls.get(index);
    }

    @Override
   public Object getValueAt(int rowIndex, int columnIndex) {
        switch (columnIndex) {
            case 0:
                return cls.get(rowIndex).getPrimaryKey();
            case 1:
                return cls.get(rowIndex).getNombre_usu();
            case 2:
                return cls.get(rowIndex).getNombre_com();
            case 3:
                return cls.get(rowIndex).getFecha_nac();
            case 4:
                return cls.get(rowIndex).getCedula();
            case 5:
                return cls.get(rowIndex).getTelefono(); 
            default:
                return null;

        }
    }
}
