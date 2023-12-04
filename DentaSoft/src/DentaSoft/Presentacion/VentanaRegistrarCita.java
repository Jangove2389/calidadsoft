/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JDialog.java to edit this template
 */
package DentaSoft.Presentacion;

import DentaSoft.Aplicacion.RegistrarCitaServicio;
import DentaSoft.Dominio.Cita;
import DentaSoft.Dominio.Dentista;
import DentaSoft.Dominio.Paciente;
import DentaSoft.Dominio.HorarioAtencion;
import java.awt.HeadlessException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author estdi
 */
public class VentanaRegistrarCita extends javax.swing.JDialog {

    private Cita cita;
    private RegistrarCitaServicio registrarCitaServicio;

    DefaultTableModel tableModel;
    List<HorarioAtencion> listaHorario;

    public VentanaRegistrarCita(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        inicializarNuevaCita();
        setLocationRelativeTo(null);
    }

    private void inicializarNuevaCita() {
        registrarCitaServicio = new RegistrarCitaServicio();
        cita = new Cita();
        txtDetallecita.requestFocus();
        txtDetallecita.setText("");
        txtPrecioCita.setText("");
        cbxTipoServicio.getSelectedItem();
        txtPrecioTotal.setText("");
        txtDniDent.setText("");
        txtNombreDent.setText("");
        txtDniPaciente.setText("");
        txtNombrePaciente.setText("");
        txtIdhorario.setText("");
        txtHorainicio.setText("");
        txtEstado.setText("");
        txtFecha.setText(LocalDate.now().toString());
        btnGuardar.setEnabled(false);
        evaluarPrecioPorTipoServicio();
        jPanel3.setVisible(false);
        inicializarTableModel();
    }

    private void inicializarTableModel() {
        String[] cabecera = {"ID", "TURNO", "ESTADO"};
        tableModel = new DefaultTableModel();
        tableModel.setColumnIdentifiers(cabecera);
        tbHorario.setModel(tableModel);
        listaHorario = new ArrayList<>();
        mostrarDatosDentista(null);
    }

    private void mostrarDatosDentista(Dentista dentista) {
        try {
            tableModel.setRowCount(0);
            if (dentista == null) {
                return;
            }
            LocalDate fecha = getFechaSeleccionada();
            listaHorario = registrarCitaServicio.listasHorario(dentista.getDni(), fecha);
            Object[] fila = new Object[tableModel.getColumnCount()];

            for (HorarioAtencion turno : listaHorario) {
                fila[0] = turno.getIdhorario();
                fila[1] = turno.getHoraInicioFinFormato();
                fila[2] = turno.getEstado();
                tableModel.addRow(fila);
            }
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this, "ERROR AL LISTAR TURNOS", "Advertencia", JOptionPane.WARNING_MESSAGE);
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jPanel4 = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        btnBuscarHorario = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        txtIdhorario = new javax.swing.JTextField();
        txtHorainicio = new javax.swing.JTextField();
        jLabel15 = new javax.swing.JLabel();
        txtEstado = new javax.swing.JTextField();
        btnBuscarDentista = new javax.swing.JButton();
        jLabel10 = new javax.swing.JLabel();
        txtDniDent = new javax.swing.JTextField();
        txtNombreDent = new javax.swing.JTextField();
        jLabel11 = new javax.swing.JLabel();
        jPanel5 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tbHorario = new javax.swing.JTable();
        jPanel6 = new javax.swing.JPanel();
        btnBuscarPaciente = new javax.swing.JButton();
        jLabel12 = new javax.swing.JLabel();
        txtDniPaciente = new javax.swing.JTextField();
        jLabel13 = new javax.swing.JLabel();
        txtNombrePaciente = new javax.swing.JTextField();
        jPanel7 = new javax.swing.JPanel();
        btnGuardar = new javax.swing.JButton();
        btnLimpiar = new javax.swing.JButton();
        jPanel8 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        txtDetallecita = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        txtPrecioCita = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        cbxTipoServicio = new javax.swing.JComboBox<>();
        lblPrecioTipoCita = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        txtFecha = new javax.swing.JTextField();
        jPanel2 = new javax.swing.JPanel();
        btnCalcularPrecio = new javax.swing.JButton();
        jLabel7 = new javax.swing.JLabel();
        txtPrecioTotal = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(102, 153, 255));
        jPanel1.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabel1.setFont(new java.awt.Font("Dialog", 1, 26)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("REGISTRO DE CITA");

        jPanel4.setBorder(javax.swing.BorderFactory.createEtchedBorder(new java.awt.Color(204, 204, 204), null));
        jPanel4.setOpaque(false);

        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "TURNOS", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Times New Roman", 1, 16))); // NOI18N
        jPanel3.setForeground(new java.awt.Color(102, 102, 255));

        btnBuscarHorario.setFont(new java.awt.Font("Sylfaen", 1, 18)); // NOI18N
        btnBuscarHorario.setText("BUSCAR TURNO");
        btnBuscarHorario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBuscarHorarioActionPerformed(evt);
            }
        });

        jLabel4.setFont(new java.awt.Font("Times New Roman", 3, 16)); // NOI18N
        jLabel4.setText("ID TURNO:");

        jLabel9.setFont(new java.awt.Font("Times New Roman", 3, 16)); // NOI18N
        jLabel9.setText("TURNO:");

        txtIdhorario.setFont(new java.awt.Font("Times New Roman", 2, 14)); // NOI18N

        txtHorainicio.setEditable(false);
        txtHorainicio.setFont(new java.awt.Font("Times New Roman", 2, 14)); // NOI18N

        jLabel15.setFont(new java.awt.Font("Times New Roman", 3, 16)); // NOI18N
        jLabel15.setText("ESTADO :");

        txtEstado.setEditable(false);
        txtEstado.setFont(new java.awt.Font("Times New Roman", 2, 14)); // NOI18N

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel9)
                    .addComponent(jLabel4)
                    .addComponent(jLabel15))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnBuscarHorario)
                    .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(txtHorainicio, javax.swing.GroupLayout.DEFAULT_SIZE, 147, Short.MAX_VALUE)
                        .addComponent(txtIdhorario, javax.swing.GroupLayout.PREFERRED_SIZE, 145, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(txtEstado))))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addComponent(btnBuscarHorario)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(txtIdhorario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(19, 19, 19)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel9)
                    .addComponent(txtHorainicio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel15)
                    .addComponent(txtEstado, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        btnBuscarDentista.setFont(new java.awt.Font("Sylfaen", 1, 18)); // NOI18N
        btnBuscarDentista.setText("BUSCAR DENTISTA");
        btnBuscarDentista.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBuscarDentistaActionPerformed(evt);
            }
        });

        jLabel10.setFont(new java.awt.Font("Times New Roman", 3, 16)); // NOI18N
        jLabel10.setText("DNI DENTISTA :");

        txtDniDent.setFont(new java.awt.Font("Times New Roman", 2, 16)); // NOI18N
        txtDniDent.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtDniDentKeyTyped(evt);
            }
        });

        txtNombreDent.setFont(new java.awt.Font("Times New Roman", 2, 16)); // NOI18N

        jLabel11.setFont(new java.awt.Font("Times New Roman", 3, 16)); // NOI18N
        jLabel11.setText("NOMBRE DENTISTA :");

        jPanel5.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "TURNOS", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI", 1, 14))); // NOI18N
        jPanel5.setOpaque(false);

        tbHorario.setModel(new javax.swing.table.DefaultTableModel(
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
        tbHorario.setRowHeight(24);
        tbHorario.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbHorarioMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tbHorario);

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 391, Short.MAX_VALUE)
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel11, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 164, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtNombreDent)
                            .addGroup(jPanel4Layout.createSequentialGroup()
                                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(btnBuscarDentista, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(txtDniDent))
                                .addGap(0, 0, Short.MAX_VALUE))))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addComponent(btnBuscarDentista, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtDniDent, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtNombreDent, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(7, Short.MAX_VALUE))
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        jPanel6.setBorder(javax.swing.BorderFactory.createEtchedBorder(new java.awt.Color(204, 204, 204), null));
        jPanel6.setOpaque(false);

        btnBuscarPaciente.setFont(new java.awt.Font("Sylfaen", 1, 18)); // NOI18N
        btnBuscarPaciente.setText("BUSCAR PACIENTE");
        btnBuscarPaciente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBuscarPacienteActionPerformed(evt);
            }
        });

        jLabel12.setFont(new java.awt.Font("Times New Roman", 3, 16)); // NOI18N
        jLabel12.setText("DNI PACIENTE :");

        txtDniPaciente.setFont(new java.awt.Font("Times New Roman", 2, 16)); // NOI18N
        txtDniPaciente.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtDniPacienteKeyTyped(evt);
            }
        });

        jLabel13.setFont(new java.awt.Font("Times New Roman", 3, 16)); // NOI18N
        jLabel13.setText("NOMBRE PACIENTE :");

        txtNombrePaciente.setEditable(false);
        txtNombrePaciente.setBackground(new java.awt.Color(255, 255, 255));
        txtNombrePaciente.setFont(new java.awt.Font("Times New Roman", 2, 16)); // NOI18N

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addComponent(jLabel13)
                        .addGap(18, 18, 18)
                        .addComponent(txtNombrePaciente, javax.swing.GroupLayout.PREFERRED_SIZE, 487, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addComponent(jLabel12)
                        .addGap(57, 57, 57)
                        .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(btnBuscarPaciente, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(txtDniPaciente))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addComponent(btnBuscarPaciente, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel12, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtDniPaciente, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel13, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtNombrePaciente, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(16, Short.MAX_VALUE))
        );

        btnGuardar.setFont(new java.awt.Font("Sylfaen", 3, 30)); // NOI18N
        btnGuardar.setText("GUARDAR");
        btnGuardar.setHorizontalTextPosition(javax.swing.SwingConstants.LEADING);
        btnGuardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGuardarActionPerformed(evt);
            }
        });

        btnLimpiar.setFont(new java.awt.Font("Sylfaen", 3, 30)); // NOI18N
        btnLimpiar.setText("LIMPIAR");
        btnLimpiar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLimpiarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addGap(340, 340, 340)
                .addComponent(btnGuardar)
                .addGap(56, 56, 56)
                .addComponent(btnLimpiar)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnGuardar)
                    .addComponent(btnLimpiar))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel8.setBorder(javax.swing.BorderFactory.createEtchedBorder(new java.awt.Color(204, 204, 204), null));
        jPanel8.setOpaque(false);

        jLabel3.setFont(new java.awt.Font("Times New Roman", 3, 16)); // NOI18N
        jLabel3.setText("DETALLE CITA :");

        txtDetallecita.setFont(new java.awt.Font("Times New Roman", 2, 16)); // NOI18N
        txtDetallecita.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtDetallecitaKeyTyped(evt);
            }
        });

        jLabel8.setFont(new java.awt.Font("Times New Roman", 3, 16)); // NOI18N
        jLabel8.setText("PRECIO CITA :");

        txtPrecioCita.setFont(new java.awt.Font("Times New Roman", 2, 16)); // NOI18N

        jLabel6.setFont(new java.awt.Font("Times New Roman", 3, 16)); // NOI18N
        jLabel6.setText("TIPO DE CITA :");

        cbxTipoServicio.setFont(new java.awt.Font("Sylfaen", 2, 16)); // NOI18N
        cbxTipoServicio.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "ONDODONCIA", "LIMPIEZA DENTAL", "EXTRACCION DENTAL", "RESINA FOTOCURABLE", "PROTESIS TOTAL" }));
        cbxTipoServicio.setBorder(null);
        cbxTipoServicio.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbxTipoServicioActionPerformed(evt);
            }
        });

        lblPrecioTipoCita.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lblPrecioTipoCita.setText("0.0");

        jLabel16.setFont(new java.awt.Font("Times New Roman", 3, 16)); // NOI18N
        jLabel16.setText("FECHA(yyyy-mm-dd):");

        txtFecha.setFont(new java.awt.Font("Times New Roman", 2, 14)); // NOI18N

        jPanel2.setBackground(new java.awt.Color(0, 102, 255));
        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "PRECIO TOTAL", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Times New Roman", 1, 18))); // NOI18N

        btnCalcularPrecio.setFont(new java.awt.Font("Times New Roman", 3, 18)); // NOI18N
        btnCalcularPrecio.setText("CALCULAR");
        btnCalcularPrecio.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCalcularPrecioActionPerformed(evt);
            }
        });

        jLabel7.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        jLabel7.setText("PAGO TOTAL A PAGAR :");

        txtPrecioTotal.setEditable(false);
        txtPrecioTotal.setFont(new java.awt.Font("Times New Roman", 2, 30)); // NOI18N

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnCalcularPrecio)
                .addGap(70, 70, 70))
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(67, 67, 67)
                        .addComponent(jLabel7))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(txtPrecioTotal, javax.swing.GroupLayout.PREFERRED_SIZE, 279, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(12, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel7)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtPrecioTotal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnCalcularPrecio, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel8Layout = new javax.swing.GroupLayout(jPanel8);
        jPanel8.setLayout(jPanel8Layout);
        jPanel8Layout.setHorizontalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel8Layout.createSequentialGroup()
                        .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(txtDetallecita, javax.swing.GroupLayout.PREFERRED_SIZE, 507, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel8Layout.createSequentialGroup()
                        .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel16, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(cbxTipoServicio, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(txtFecha, javax.swing.GroupLayout.PREFERRED_SIZE, 211, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addComponent(lblPrecioTipoCita, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel8Layout.createSequentialGroup()
                        .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(txtPrecioCita, javax.swing.GroupLayout.PREFERRED_SIZE, 507, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 90, Short.MAX_VALUE)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel8Layout.setVerticalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtDetallecita, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtPrecioCita, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel8Layout.createSequentialGroup()
                        .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(cbxTipoServicio, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(10, 10, 10))
                    .addGroup(jPanel8Layout.createSequentialGroup()
                        .addComponent(lblPrecioTipoCita, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)))
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtFecha, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel16, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel8Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jPanel7, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jPanel8, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jPanel4, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jPanel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addContainerGap())))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jPanel8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnLimpiarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLimpiarActionPerformed
        inicializarNuevaCita();
    }//GEN-LAST:event_btnLimpiarActionPerformed

    private void btnBuscarPacienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuscarPacienteActionPerformed
        String dnipacient = txtDniPaciente.getText().trim();
        try {
            validarDNI(txtDniPaciente);
            Paciente paciente = registrarCitaServicio.buscarPaciente(Integer.parseInt(dnipacient));
            cita.setPaciente(paciente);
            txtNombrePaciente.setText(paciente.getNombres());
            activarBotonGuardar();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, e.getMessage(), "Advertencia", JOptionPane.WARNING_MESSAGE);
            txtNombrePaciente.setText("");
            txtDniPaciente.requestFocus();
        }
    }//GEN-LAST:event_btnBuscarPacienteActionPerformed

    private void btnBuscarDentistaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuscarDentistaActionPerformed
        mostrarDatosDentista(null);
        String dni = txtDniDent.getText().trim();
        try {
            validarDNI(txtDniDent);
            Dentista dentista = registrarCitaServicio.buscarDentista(Integer.parseInt(dni));
            cita.setDentista(dentista);
            txtNombreDent.setText(dentista.getNombres());
            mostrarDatosDentista(dentista);
            activarBotonGuardar();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, e.getMessage(), "Advertencia", JOptionPane.WARNING_MESSAGE);
            txtNombreDent.setText("");
            txtDniDent.requestFocus();
        }
    }//GEN-LAST:event_btnBuscarDentistaActionPerformed

    private void validarDouble(JTextField txt) throws java.lang.Exception {
        try {
            Double.valueOf(txt.getText());
        } catch (NumberFormatException e) {
            txt.requestFocus();
            txt.selectAll();
            throw new Exception("Ingrese monto válido.");
        }
    }

    private void validarDatosCita() throws java.lang.Exception {
        if (txtDetallecita.getText().length() > 30) {
            throw new Exception("El campo Detalle solo permite 30 caracteres.");
        }
        validarDouble(txtPrecioCita);
        validarDouble(txtPrecioTotal);
    }


    private void btnGuardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGuardarActionPerformed
        try {
            validarDatosCita();
            capturarDatosDeCita();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "ERROR AL INGRESAR DATOS: " + e.getMessage(), "Advertencia", JOptionPane.WARNING_MESSAGE);
            return;
        }
        try {
            guardarCita();
            inicializarNuevaCita();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, e.getMessage(), "Advertencia", JOptionPane.WARNING_MESSAGE);
        }
    }//GEN-LAST:event_btnGuardarActionPerformed

    private double getPrecioTipoCita() throws java.lang.Exception {
        try {

            String opcion = String.valueOf(cbxTipoServicio.getSelectedItem());

            if (opcion.equals("ONDODONCIA")) {
                return 250;
            }

            if (opcion.equals("LIMPIEZA DENTAL")) {
                return 30;
            }

            if (opcion.equals("EXTRACCION DENTAL")) {
                return 50;
            }

            if (opcion.equals("RESINA FOTOCURABLE")) {
                return 60;
            }

            if (opcion.equals("PROTESIS TOTAL")) {
                return 2500;
            }
            throw new Exception("TIPO INVÁLIDO");
        } catch (NumberFormatException e) {
            throw e;
        }
    }

    private Double calcularPrecioTotalBase() throws java.lang.Exception {
        try {

            double dat1, PT;
            dat1 = Double.parseDouble(txtPrecioCita.getText());
            double precioTipoCita = getPrecioTipoCita();

            PT = dat1 + precioTipoCita;

            return PT;
        } catch (Exception e) {
            throw e;
        }
    }

    private void calcularPrecioTotal() {
        try {
            validarDouble(txtPrecioCita);
            txtPrecioTotal.setText("");
            if (txtPrecioCita.getText().isEmpty()) {
                txtPrecioCita.requestFocus();
                throw new Exception("INGRESE PRECIO DE CITA");
            }

            if (cita.getPaciente() == null) {
                txtDniPaciente.requestFocus();
                throw new Exception("INGRESE PACIENTE");
            }

            Double precioBase = calcularPrecioTotalBase();
            Double descuentoPorEdad = cita.calcularDescuentoPorEdad(precioBase);
            int cantidadCitas = registrarCitaServicio.consultarTotalDeCitas(cita.getPaciente());

            Double descuentoPorFrecuenciaCitas = cita.calcularDescuentoPorFrecuenciaDeCitas(precioBase, cantidadCitas);
            double descuentoTotal = descuentoPorEdad + descuentoPorFrecuenciaCitas;
            double precioFinal = precioBase - descuentoTotal;

            cita.setDescuentototal(descuentoTotal);
            txtPrecioTotal.setText(precioFinal + "");
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this, "NO SE PUDO CALCULAR TOTAL: " + ex.getMessage(), "Advertencia", JOptionPane.WARNING_MESSAGE);
        }

    }


    private void btnCalcularPrecioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCalcularPrecioActionPerformed
        calcularPrecioTotal();
//        Cita cita = new Cita();          
//        double CosServ = cbxTipoServicio.getSelectedIndex();
//        double Pcita = Double.parseDouble(txtPrecioCita.getText());        
//        double PTotal;              
//        PTotal = Pcita + CosServ;
//        txtPrecioTotal.setText(Double.toString(PTotal));

    }//GEN-LAST:event_btnCalcularPrecioActionPerformed

    LocalDate getFechaSeleccionada() {
        try {
            LocalDate fecha = LocalDate.parse(txtFecha.getText());
            return fecha;
        } catch (Exception e) {
            return null;
        }

    }

    private void btnBuscarHorarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuscarHorarioActionPerformed
        String idhorario = txtIdhorario.getText().trim();
        try {
            if (cita.getDentista() == null) {
                txtDniPaciente.requestFocus();
                throw new Exception("INGRESE DENTISTA");
            }

            cita.setHorarioatencion(null);
            LocalDate fecha = getFechaSeleccionada();
            HorarioAtencion horario = registrarCitaServicio.buscarHorario(idhorario, fecha, cita.getDentista().getIddentista());
            if (horario == null) {
                throw new Exception("NO EXISTE EL HORARIO");
            }

            cita.setHorarioatencion(horario);
            txtHorainicio.setText(String.format("%s - %s", horario.getHoraInicio().toString(), horario.getHoraFin().toString()));
            txtEstado.setText(horario.getEstado());
            activarBotonGuardar();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, e.getMessage(), "Advertencia", JOptionPane.WARNING_MESSAGE);
            txtHorainicio.setText("");
            txtEstado.setText("");
            txtIdhorario.requestFocus();
            activarBotonGuardar();
        }
    }//GEN-LAST:event_btnBuscarHorarioActionPerformed

    private void txtDetallecitaKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtDetallecitaKeyTyped
        validarLongitud(txtDetallecita, 30, evt);
    }//GEN-LAST:event_txtDetallecitaKeyTyped

    private void txtDniDentKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtDniDentKeyTyped
        validarLongitud(txtDniDent, 8, evt);
    }//GEN-LAST:event_txtDniDentKeyTyped

    private void txtDniPacienteKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtDniPacienteKeyTyped
        validarLongitud(txtDniPaciente, 8, evt);
    }//GEN-LAST:event_txtDniPacienteKeyTyped

    private void cbxTipoServicioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbxTipoServicioActionPerformed
        evaluarPrecioPorTipoServicio();
    }//GEN-LAST:event_cbxTipoServicioActionPerformed

    private void tbHorarioMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbHorarioMouseClicked
        activarBotonGuardar();
    }//GEN-LAST:event_tbHorarioMouseClicked

    private void evaluarPrecioPorTipoServicio() {
        try {
            double precioTipoCita = getPrecioTipoCita();
            lblPrecioTipoCita.setText(precioTipoCita + "");
        } catch (java.lang.Exception ex) {
            JOptionPane.showMessageDialog(this, ex.getMessage(), "Información", JOptionPane.INFORMATION_MESSAGE);
        }
    }

    private void guardarCita() throws Exception, HeadlessException {
        registrarCitaServicio.guardarCita(cita);
        JOptionPane.showMessageDialog(this, "SE GUARDO LA CITA EXITOSAMENTE", "Información", JOptionPane.INFORMATION_MESSAGE);
    }

    private void validarLongitud(JTextField txt, int max, java.awt.event.KeyEvent evt) {
        if (txt.getText().length() >= max) {
            evt.consume();
        }
    }

    private void validarDNI(JTextField txt) throws java.lang.Exception {
        if (txt.getText().length() != 8) {
            txt.requestFocus();
            txt.selectAll();
            throw new Exception("El campo DNI tiene que tener una longitud de 8 caracteres numéricos.");
        }

        try {
            if (Integer.parseInt(txt.getText()) <= 0) {
                throw new Exception("El campo DNI tiene que tener números enteros positivos.");
            }
        } catch (Exception e) {
            txt.requestFocus();
            txt.selectAll();
            throw new Exception("El campo DNI ingresado solo permite número enteros.");
        }
    }

    private void capturarDatosDeCita() throws Exception {
        cita.setDetallecita(txtDetallecita.getText().trim());
        cita.setPreciocita(Double.parseDouble(txtPrecioCita.getText().trim()));
        cita.setPagototal(Double.parseDouble(txtPrecioTotal.getText().trim()));
        LocalDate fecha = getFechaSeleccionada();
        if (fecha == null) {
            throw new Exception("Ingrese fecha en formato correcto(YYY-MM-DD).");
        }
        cita.setFecha(fecha);
        cita.setTipocita(cbxTipoServicio.getSelectedItem().toString());
    }

    private void evaluarSeleccionarTurno() {
        cita.setHorarioatencion(null);
        int idx = tbHorario.getSelectedRow();
        if (idx < 0) {
            return;
        }
        cita.setHorarioatencion(listaHorario.get(idx));
    }

    private void activarBotonGuardar() {
        evaluarSeleccionarTurno();
        btnGuardar.setEnabled(false);
        if (cita.getDentista() == null) {
            return;
        }

        if (cita.getPaciente() == null) {
            return;
        }

        if (cita.getHorarioatencion() == null) {
            return;
        }

        btnGuardar.setEnabled(true);
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(VentanaRegistrarCita.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(VentanaRegistrarCita.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(VentanaRegistrarCita.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(VentanaRegistrarCita.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                VentanaRegistrarCita dialog = new VentanaRegistrarCita(new javax.swing.JFrame(), true);
                dialog.addWindowListener(new java.awt.event.WindowAdapter() {
                    @Override
                    public void windowClosing(java.awt.event.WindowEvent e) {
                        System.exit(0);
                    }
                });
                dialog.setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnBuscarDentista;
    private javax.swing.JButton btnBuscarHorario;
    private javax.swing.JButton btnBuscarPaciente;
    private javax.swing.JButton btnCalcularPrecio;
    private javax.swing.JButton btnGuardar;
    private javax.swing.JButton btnLimpiar;
    private javax.swing.JComboBox<String> cbxTipoServicio;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblPrecioTipoCita;
    private javax.swing.JTable tbHorario;
    private javax.swing.JTextField txtDetallecita;
    private javax.swing.JTextField txtDniDent;
    private javax.swing.JTextField txtDniPaciente;
    private javax.swing.JTextField txtEstado;
    private javax.swing.JTextField txtFecha;
    private javax.swing.JTextField txtHorainicio;
    private javax.swing.JTextField txtIdhorario;
    private javax.swing.JTextField txtNombreDent;
    private javax.swing.JTextField txtNombrePaciente;
    private javax.swing.JTextField txtPrecioCita;
    private javax.swing.JTextField txtPrecioTotal;
    // End of variables declaration//GEN-END:variables

    private Exception Exception(String ingrese_fecha_en_formato_correcto) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
}
