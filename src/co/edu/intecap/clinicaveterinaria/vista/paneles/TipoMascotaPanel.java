/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.intecap.clinicaveterinaria.vista.paneles;

import co.edu.intecap.clinicaveterinaria.control.TipoMascotaDelegado;
import co.edu.intecap.clinicaveterinaria.modelo.vo.TipoMascotaVo;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author capacitaciones
 */
public class TipoMascotaPanel extends javax.swing.JPanel {

    private DefaultTableModel modelo;
    private final TipoMascotaVo tipoMascotaVo;

    /**
     * Creates new form TipoMascotaPanel
     */
    public TipoMascotaPanel() {
        initComponents();
        confirgurarTabla();
        llenarTabla(new TipoMascotaDelegado(this).consultarTipoMascota(), modelo);
        this.tipoMascotaVo = new TipoMascotaVo();
    }

    //metodo para obtener valores del GUI y resgistar un nuevo tipo mascota
    private void registarTipoMascota() {
        //asiganar nombre del tipo de mascota
        tipoMascotaVo.setNombre(txtNombre.getText());
        tipoMascotaVo.setEstado(cbxEstado.isSelected());
        new TipoMascotaDelegado(this).insertarTipoMascota(tipoMascotaVo);
        //mnesaje de confirmacion de registro 
        JOptionPane.showMessageDialog(this, "Tipo de mascota Registrado", "Registro de datos", JOptionPane.INFORMATION_MESSAGE);
        refrescarTabla();
        limpiarCampos();
        
    }

    /**
     * permite establecer los parametros inciiales de una tabla.
     */
    private void confirgurarTabla() {
        modelo = new DefaultTableModel();
        modelo.addColumn("Id Mascota");
        modelo.addColumn("Nombre");
        modelo.addColumn("Estado");
        tblTipoMascota.setModel(modelo);
        tblTipoMascota.getSelectionModel().addListSelectionListener(tableListener);
    }

    /**
     * Carga una lista de tipo de mascotas desde la base de datos a la tabla de
     * la interfaz grafica de usuario
     *
     * @param listaTipoMascota lista de tipos de mascotas de la base de datos
     * @param modelo modelo de la tabla con la estructura de los datos a cargar
     */
    private void llenarTabla(List<TipoMascotaVo> listaTipoMascota, DefaultTableModel modelo) {
        for (TipoMascotaVo tipoMascotaVo : listaTipoMascota) {
            Object[] fila = new Object[3];
            fila[0] = tipoMascotaVo.getIdTipoMascota();
            fila[1] = tipoMascotaVo.getNombre();
            fila[2] = tipoMascotaVo.isEstado();
            modelo.addRow(fila);

        }
        tblTipoMascota.updateUI();
    }

    /**
     * Uctualioza la informacion de la tabla que se realiza un registro
     *
     */
    private void refrescarTabla() {
        modelo.setRowCount(0);
        List<TipoMascotaVo> listaMascotas = new TipoMascotaDelegado(this).consultarTipoMascota();
        llenarTabla(listaMascotas, modelo);
    }

    private void limpiarCampos() {
        txtNombre.setText("");
        cbxEstado.setSelected(false);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        cbxEstado = new javax.swing.JCheckBox();
        txtNombre = new javax.swing.JTextField();
        btnGuardar = new javax.swing.JButton();
        jSeparator1 = new javax.swing.JSeparator();
        jScrollPane2 = new javax.swing.JScrollPane();
        tblTipoMascota = new javax.swing.JTable();

        jLabel1.setText("Nombre:");

        jLabel2.setText("Estado:");

        cbxEstado.setText("Activo");

        btnGuardar.setText("Guardar");
        btnGuardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGuardarActionPerformed(evt);
            }
        });

        tblTipoMascota.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane2.setViewportView(tblTipoMascota);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jSeparator1)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel1)
                                .addGap(18, 18, 18)
                                .addComponent(txtNombre, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(38, 38, 38)
                                .addComponent(btnGuardar))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel2)
                                .addGap(18, 18, 18)
                                .addComponent(cbxEstado)))
                        .addGap(0, 122, Short.MAX_VALUE))
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(17, 17, 17)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(txtNombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnGuardar))
                .addGap(19, 19, 19)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(cbxEstado))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 85, Short.MAX_VALUE)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 121, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btnGuardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGuardarActionPerformed
        this.registarTipoMascota();
    }//GEN-LAST:event_btnGuardarActionPerformed
    ListSelectionListener tableListener = new ListSelectionListener() {

        @Override
        public void valueChanged(ListSelectionEvent e) {
            if (tblTipoMascota.getSelectedRow() > -1) {
                //se obtiene el id de la fila seleccionada en la tabla 
                int id =(int) tblTipoMascota.getValueAt(tblTipoMascota.getSelectedRow(), 0);
                //consultar en la base de datos por ese id seleccionado y guardar el 
                //resultado de la consulta enun nuevo object de TipoMascotaVo
                TipoMascotaVo tMvo = new TipoMascotaDelegado(TipoMascotaPanel.this).consultarTipoMascotaVo(id);
                //Asiganar los valores obtenidos de la consulta a la constante 
                tipoMascotaVo.setIdTipoMascota(tMvo.getIdTipoMascota());
                tipoMascotaVo.setNombre(tMvo.getNombre());
                tipoMascotaVo.setEstado(tMvo.isEstado());
            }
        }
    };
    
        private void llenarCampos(){
            txtNombre.setText(tipoMascotaVo.getNombre());
            cbxEstado.setSelected(tipoMascotaVo.isEstado());
            
                    
        }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnGuardar;
    private javax.swing.JCheckBox cbxEstado;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JTable tblTipoMascota;
    private javax.swing.JTextField txtNombre;
    // End of variables declaration//GEN-END:variables
}
