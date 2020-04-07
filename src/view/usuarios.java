
package view;
import Clases.CustomImageIcon;
import Clases.ModelTablePersonal;
import conexion.Conexion;
import Controlador.ControlPersonal;
import java.awt.Image;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import Model.Personal;
import javax.swing.JOptionPane;

public class usuarios extends javax.swing.JInternalFrame {
    public String codigo;
    private FileInputStream fisfoto;
    private int longitudBytes;
    private ControlPersonal conPers;
    private Personal pers;

    public usuarios() {
        initComponents();
        conPers = new ControlPersonal();
       this.setLocationRelativeTo(null);
        jTablePersonal.setModel(new ModelTablePersonal(conPers.getPersonal()));
        jTablePersonal.getSelectionModel().addListSelectionListener(new ListSelectionListener() {
            @Override
            public void valueChanged(ListSelectionEvent e) {
                if (jTablePersonal.getSelectedRow() != -1) {
                    int fila = jTablePersonal.getSelectedRow();
                    pers = ((ModelTablePersonal) jTablePersonal.getModel()).getFila(fila);
                    codigo = jTablePersonal.getValueAt(fila, 0).toString();
                    txtNombres.setText(pers.getNombre_usu());
                    txnombreEmpresa1.setText(pers.getNombre_com());
                    
                    CustomImageIcon foto = Conexion.getFoto(Integer.parseInt(codigo));
                    if (foto != null) {
                        lblImgFoto.setIcon(foto);
                    } else {
                        lblImgFoto.setIcon(new CustomImageIcon(getClass().getResource("/resource/SinFoto.png")));
                    }
                    lblImgFoto.updateUI();
                }
            }
        });      
        
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        Usuario = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        txtNombres = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        txCedula = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        txEmail = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        txTelefono = new javax.swing.JTextField();
        lblImgFoto = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        txFechaNacimiento1 = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        txnombreEmpresa1 = new javax.swing.JTextField();
        jPanel3 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTablePersonal = new javax.swing.JTable();
        bntNuevo = new javax.swing.JButton();
        bntGrabar = new javax.swing.JButton();
        bntActualizar = new javax.swing.JButton();
        bntEliminar = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();

        setClosable(true);
        setIconifiable(true);
        setMaximizable(true);
        setResizable(true);
        setTitle("USUARIO");

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 255), 5, true), "USUARIO", javax.swing.border.TitledBorder.LEFT, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Adobe Arabic", 3, 18), new java.awt.Color(0, 0, 255))); // NOI18N
        jPanel1.setForeground(new java.awt.Color(0, 153, 204));

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 255), 5, true), "Registros", javax.swing.border.TitledBorder.LEFT, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Agency FB", 3, 18), new java.awt.Color(255, 0, 0))); // NOI18N
        jPanel2.setForeground(new java.awt.Color(255, 255, 255));

        jLabel2.setFont(new java.awt.Font("Tahoma", 3, 18)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 0, 0));
        jLabel2.setText("Usuario :");

        jLabel4.setFont(new java.awt.Font("Tahoma", 3, 18)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 0, 0));
        jLabel4.setText("Nombre Completo :");

        jLabel3.setFont(new java.awt.Font("Tahoma", 3, 18)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 0, 0));
        jLabel3.setText("Cedula :");

        jLabel6.setFont(new java.awt.Font("Tahoma", 3, 18)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 0, 0));
        jLabel6.setText("Nombre Empresa :");

        jLabel5.setFont(new java.awt.Font("Tahoma", 3, 18)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 0, 0));
        jLabel5.setText("fecha Nacimiento :");

        lblImgFoto.setBackground(new java.awt.Color(255, 255, 255));
        lblImgFoto.setIcon(new CustomImageIcon(getClass().getResource("/resource/SinFoto.png")));
        lblImgFoto.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        lblImgFoto.setPreferredSize(new java.awt.Dimension(100, 80));
        lblImgFoto.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblImgFotoMouseClicked(evt);
            }
        });

        jLabel7.setFont(new java.awt.Font("Tahoma", 3, 18)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(255, 0, 0));
        jLabel7.setText("Email:");

        jLabel8.setFont(new java.awt.Font("Tahoma", 3, 18)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(255, 0, 0));
        jLabel8.setText("Telefono :");

        txnombreEmpresa1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txnombreEmpresa1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel4, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel3, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel7, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel5, javax.swing.GroupLayout.Alignment.TRAILING)))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(48, 48, 48)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel6)
                            .addComponent(jLabel8))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(Usuario, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtNombres, javax.swing.GroupLayout.PREFERRED_SIZE, 161, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txCedula, javax.swing.GroupLayout.PREFERRED_SIZE, 161, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txEmail, javax.swing.GroupLayout.PREFERRED_SIZE, 161, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txTelefono, javax.swing.GroupLayout.PREFERRED_SIZE, 161, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txFechaNacimiento1, javax.swing.GroupLayout.PREFERRED_SIZE, 161, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 99, Short.MAX_VALUE)
                        .addComponent(lblImgFoto, javax.swing.GroupLayout.PREFERRED_SIZE, 232, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(71, 71, 71))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(txnombreEmpresa1, javax.swing.GroupLayout.PREFERRED_SIZE, 161, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblImgFoto, javax.swing.GroupLayout.PREFERRED_SIZE, 168, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(Usuario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel2, javax.swing.GroupLayout.Alignment.TRAILING))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel4)
                            .addComponent(txtNombres, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel3)
                            .addComponent(txCedula, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txEmail, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel7))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txFechaNacimiento1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel5))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel6)
                            .addComponent(txnombreEmpresa1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8)
                    .addComponent(txTelefono, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(35, Short.MAX_VALUE))
        );

        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 255), 4, true)));

        jTablePersonal.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null}
            },
            new String [] {
                "Usuarios", "Nombre", "Cedula", "Email", "FechaNacimiento", "NombreEmpresa", "telefono"
            }
        ));
        jScrollPane1.setViewportView(jTablePersonal);

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 836, Short.MAX_VALUE)
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 200, Short.MAX_VALUE)
        );

        bntNuevo.setFont(new java.awt.Font("Tahoma", 3, 18)); // NOI18N
        bntNuevo.setForeground(new java.awt.Color(0, 102, 102));
        bntNuevo.setText("Nuevo");
        bntNuevo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bntNuevoActionPerformed(evt);
            }
        });

        bntGrabar.setFont(new java.awt.Font("Tahoma", 3, 18)); // NOI18N
        bntGrabar.setForeground(new java.awt.Color(0, 102, 102));
        bntGrabar.setText("Grabar");
        bntGrabar.setEnabled(false);
        bntGrabar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bntGrabarActionPerformed(evt);
            }
        });

        bntActualizar.setFont(new java.awt.Font("Tahoma", 3, 18)); // NOI18N
        bntActualizar.setForeground(new java.awt.Color(0, 102, 102));
        bntActualizar.setText("Actualizar");
        bntActualizar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bntActualizarActionPerformed(evt);
            }
        });

        bntEliminar.setFont(new java.awt.Font("Tahoma", 3, 18)); // NOI18N
        bntEliminar.setForeground(new java.awt.Color(0, 102, 102));
        bntEliminar.setText("Eliminar");
        bntEliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bntEliminarActionPerformed(evt);
            }
        });

        jButton1.setFont(new java.awt.Font("Tahoma", 3, 18)); // NOI18N
        jButton1.setForeground(new java.awt.Color(0, 102, 102));
        jButton1.setText("Cancelar");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setFont(new java.awt.Font("Tahoma", 3, 18)); // NOI18N
        jButton2.setForeground(new java.awt.Color(0, 102, 51));
        jButton2.setText("Imprimir");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(28, 28, 28)
                .addComponent(bntNuevo, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(bntGrabar, javax.swing.GroupLayout.PREFERRED_SIZE, 97, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(bntActualizar)
                .addGap(18, 18, 18)
                .addComponent(bntEliminar, javax.swing.GroupLayout.PREFERRED_SIZE, 171, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jButton1)
                .addGap(31, 31, 31)
                .addComponent(jButton2)
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addContainerGap())
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(30, 30, 30))))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 6, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(bntEliminar)
                            .addComponent(bntActualizar)
                            .addComponent(bntGrabar)
                            .addComponent(bntNuevo)
                            .addComponent(jButton1)))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton2)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 20, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 15, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void bntActualizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bntActualizarActionPerformed
        if (pers != null) {
            pers.setNombre_usu(txtNombres.getText());       
            pers.setNombre_com(txnombreEmpresa1.getText());
            pers.setEmail(txEmail.getText());
            pers.setTelefono(txTelefono.getText());
            pers.setFoto(fisfoto);
            int opcion = conPers.actualzarPersonal(pers);
            if (opcion != 0) {
                JOptionPane.showMessageDialog(this, "Personal Actualizado");
                jTablePersonal.setModel(new ModelTablePersonal(conPers.getPersonal()));
                if (fisfoto != null) {
                    try {
                        fisfoto.close();
                    } catch (IOException ex) {
                        Logger.getLogger(usuarios.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
                fisfoto = null;
            }
        } else {
            JOptionPane.showMessageDialog(this, "Primero seleccione un Personal");
        }
    }//GEN-LAST:event_bntActualizarActionPerformed

    private void bntGrabarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bntGrabarActionPerformed
        if (this.txtNombres.getText().isEmpty()
                
            || this.txCedula.getText().isEmpty()
            || this.txEmail.getText().isEmpty()) {
            JOptionPane.showMessageDialog(this, "Todos los campos son "
                + "obligatorios, exepto la foto");
            return;
        }

        boolean emailEncontrado = Conexion.existeEmail(this.txEmail.getText());
        if (emailEncontrado) {
            JOptionPane.showMessageDialog(this, "el email " + this.txEmail.getText()
                + " ya existe ingrese otro email");
            return;
        }
        Personal cl = new Personal();
        cl.setNombre_usu(txtNombres.getText());
        cl.setNombre_com(txnombreEmpresa1.getText());
        cl.setEmail(txEmail.getText());
        
        cl.setFoto(fisfoto);
        int opcion = conPers.insertPersonal(cl);

        if (opcion != 0) {
            try {
                JOptionPane.showMessageDialog(this, "Personal " + cl + " agregado");
                jTablePersonal.setModel(new ModelTablePersonal(conPers.getPersonal()));
                this.bntGrabar.setEnabled(false);
                bntNuevo.setEnabled(true);
                this.bntActualizar.setEnabled(true);
                this.bntEliminar.setEnabled(true);
                if (fisfoto != null) {
                    fisfoto.close();
                }
                fisfoto = null;
            } catch (IOException ex) {
                Logger.getLogger(usuarios.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }//GEN-LAST:event_bntGrabarActionPerformed

    private void bntNuevoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bntNuevoActionPerformed
        this.txtNombres.setText("");
        this.txCedula.setText("");
        this.txEmail.setText("");
        this.txTelefono.setText("");
        lblImgFoto.setIcon(new CustomImageIcon(getClass().getResource("/resource/SinFoto.png")));
        this.fisfoto = null;
        this.longitudBytes = 0;
        this.bntGrabar.setEnabled(true);
        bntNuevo.setEnabled(false);
        this.bntActualizar.setEnabled(false);
        this.bntEliminar.setEnabled(false);
        pers = null;
        this.jTablePersonal.clearSelection();
    }//GEN-LAST:event_bntNuevoActionPerformed

    private void lblImgFotoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblImgFotoMouseClicked
        JFileChooser se = new JFileChooser();
        se.setFileSelectionMode(JFileChooser.FILES_ONLY);
        int estado = se.showOpenDialog(null);
        if (estado == JFileChooser.APPROVE_OPTION) {
            try {

                fisfoto = new FileInputStream(se.getSelectedFile());
                this.longitudBytes = (int) se.getSelectedFile().length();

                Image icono = ImageIO.read(se.getSelectedFile()).getScaledInstance(lblImgFoto.getWidth(), lblImgFoto.getHeight(), Image.SCALE_DEFAULT);
                lblImgFoto.setIcon(new ImageIcon(icono));
                lblImgFoto.updateUI();

            } catch (FileNotFoundException ex) {
                ex.printStackTrace();
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        }
    }//GEN-LAST:event_lblImgFotoMouseClicked

    private void bntEliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bntEliminarActionPerformed
        if (pers != null) {
            int eliminarCliente = conPers.eliminarPersonal(pers.getPrimaryKey());
            if (eliminarCliente != 0) {
                JOptionPane.showMessageDialog(this, "Personal Eliminado");
                jTablePersonal.setModel(new ModelTablePersonal(conPers.getPersonal()));
            }
        } else {
            JOptionPane.showMessageDialog(this, "Primero seleccione un Personal");
        }
    }//GEN-LAST:event_bntEliminarActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        this.txtNombres.setText("");
        this.txCedula.setText("");
        this.txEmail.setText("");
        this.txTelefono.setText("");
        lblImgFoto.setIcon(new CustomImageIcon(getClass().getResource("/imagenes/Imagenes/limpiar.png.png")));
        this.fisfoto = null;
        this.longitudBytes = 0;
        pers = null;
        this.bntGrabar.setEnabled(false);
        bntNuevo.setEnabled(true);
        this.jTablePersonal.clearSelection();
        this.bntActualizar.setEnabled(true);
        this.bntEliminar.setEnabled(true);
    }//GEN-LAST:event_jButton1ActionPerformed

    private void txnombreEmpresa1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txnombreEmpresa1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txnombreEmpresa1ActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    public javax.swing.JTextField Usuario;
    private javax.swing.JButton bntActualizar;
    private javax.swing.JButton bntEliminar;
    private javax.swing.JButton bntGrabar;
    private javax.swing.JButton bntNuevo;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTablePersonal;
    private javax.swing.JLabel lblImgFoto;
    public javax.swing.JTextField txCedula;
    public javax.swing.JTextField txEmail;
    private javax.swing.JTextField txFechaNacimiento1;
    private javax.swing.JTextField txTelefono;
    private javax.swing.JTextField txnombreEmpresa1;
    public javax.swing.JTextField txtNombres;
    // End of variables declaration//GEN-END:variables

    private void setLocationRelativeTo(Object object) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

  
    
}
