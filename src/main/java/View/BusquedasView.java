/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package View;

import Arbin.ArbinImpl;
import ColaDinamica.ColdiImpl;
import ColaDinamica.ColdiInterface;
import ColaDinamica.ColdiNodo;
import Model.Prueba;
import Utils.MyDates;
import Utils.MyReader;
import Utils.TextPrompt;
import java.awt.event.KeyEvent;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Jesus Joaquin
 */
public class BusquedasView extends javax.swing.JFrame {
       
    private ArbinImpl listaPruebas = new ArbinImpl();    
    private MyReader rd = new MyReader();
    static private ColdiInterface listaBusqueda = new ColdiImpl();    
    private ColdiInterface listaFiltrada = new ColdiImpl(); 
    
    public BusquedasView() {
        initComponents();        
        MyComponents();
        dtBusqueda.setEnabled(false);        
    }
    
    private void MyComponents(){
        //Asiganmos el icono al JFrame
        setIconImage(new ImageIcon(getClass().getResource("/img/busquedas32.png")).getImage());
        //Efecto placeholder en los cuadros de texto
        TextPrompt tp1 = new TextPrompt("A continuación, escriba su dato", txtBuscar);
        TextPrompt tp2 = new TextPrompt("Ingrese edad", txtEdad);
        TextPrompt tp3 = new TextPrompt("Ingrese sexo", txtSexo);
        TextPrompt tp4 = new TextPrompt("Ingrese departamento", txtDepartamento);
        TextPrompt tp5 = new TextPrompt("Ingrese provincia", txtProvincia);
        TextPrompt tp6 = new TextPrompt("Ingrese distrito", txtDistrito);
        TextPrompt tp7 = new TextPrompt("Ingrese de tipo muestra", txtTipoMuestra);
        TextPrompt tp8 = new TextPrompt("Ingrese resultado", txtResultado);
        DisableComponents();
        rd.ReaderCSV_Pruebas(listaPruebas); //LEER CSV
        listaPruebas.ImprimirInorden(); //IRD
    }
    
    //Metodo para iniciar Datos en la tabla
    public static void initDatos(Prueba p){
        //Instacia de Object para las filas de la tabla
        Object [] fila = new Object[tbPruebas.getColumnCount()];
        fila[0] = MyDates.getDateToString(p.getFecha_corte());
        fila[1] = p.getUUID();
        fila[2] = MyDates.getDateToString(p.getFecha_muestra());
        fila[3] = p.getEdad();
        fila[4] = p.getSexo();
        fila[5] = p.getInstitucion();
        fila[6] = p.getUbigeo();
        fila[7] = p.getDepartamento();
        fila[8] = p.getProvincia();
        fila[9] = p.getDistrito();
        fila[10] = p.getDep_muestra();
        fila[11] = p.getProv_muestra();
        fila[12] = p.getDist_muestra();
        fila[13] = p.getTipo_muestra();
        fila[14] = p.getResultado();
        //Agregamos la fila a la tabla
        ((DefaultTableModel)tbPruebas.getModel()).addRow(fila);
    }

    public static void initDatosBusqueda(Prueba p){       
        listaBusqueda.enqueue(new ColdiNodo(p));
    }      
    
    private void Busqueda(){
        if (cbxCampo.getSelectedIndex() == 0) {
            JOptionPane.showMessageDialog(null, "Seleccione una opción de busqueda");
        } else {
            if (listaBusqueda.getCabecera().getElemento() == null) {
                RealizarBusqueda();
            } else {
                listaBusqueda.vaciarCola(listaBusqueda);
                RealizarBusqueda();
            }
        }
    }
    
    private void RealizarBusqueda(){
        String Busqueda = txtBuscar.getText().trim().toUpperCase();
        int cbxopc = cbxCampo.getSelectedIndex();
        if (cbxopc != 0) {
            ((DefaultTableModel) tbPruebas.getModel()).setRowCount(0);
            listaPruebas.ImprimirBusqueda(cbxopc, listaPruebas.getInicial(), Busqueda);
            listaBusqueda.imprimirCola();
        }
    }
    
    private void Filtrado() {
        if (listaBusqueda.getCabecera().getElemento() != null) {
            if (!ckbEdad.isSelected() && !ckbSexo.isSelected()
                    && !ckbDepartamento.isSelected() && !ckbProvincia.isSelected()
                    && !ckbDistrito.isSelected() && !ckbTipoMuestra.isSelected()
                    && !ckbResultado.isSelected()) {
                JOptionPane.showMessageDialog(null, "Seleccione el checkbox del campo");
            } else {
                ((DefaultTableModel) tbPruebas.getModel()).setRowCount(0);
                listaFiltrada = FilterList(listaBusqueda);
                if (listaFiltrada.getCabecera().getElemento() != null) {
                    listaBusqueda = listaFiltrada;
                    listaBusqueda.imprimirCola();
                } else {
                    JOptionPane.showMessageDialog(null, "No se ha encontra dato alguno con el filtro ingresado");
                    listaBusqueda.imprimirCola();
                }
                DisableComponents();
            }
        } else{
            JOptionPane.showMessageDialog(null, "Antes de filtrar realice una busqueda", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }       
    
    private ColdiInterface FilterList(ColdiInterface lista){        
        ColdiInterface prueba = new ColdiImpl();
        if (ckbEdad.isSelected()) {
            if (!txtEdad.getText().isEmpty()) {
                int edad = Integer.parseInt(txtEdad.getText().trim());
                lista.FiltroEdad(prueba, edad);
                lista = prueba;
            } else {
                JOptionPane.showMessageDialog(null, "El campo edad se encuentra vacío", "Error", JOptionPane.ERROR_MESSAGE);
            }
        }
        
        if (ckbSexo.isSelected()) {
            if (!txtSexo.getText().isEmpty()) {
                String sexo = txtSexo.getText().toUpperCase().trim();
                lista.FiltroSexo(prueba, sexo);
                lista = prueba;
            } else {
                JOptionPane.showMessageDialog(null, "El campo sexo se encuentra vacío", "Error", JOptionPane.ERROR_MESSAGE);
            }
        }
        
        if (ckbDepartamento.isSelected()) {
            if (!txtDepartamento.getText().isEmpty()) {
                String departamento = txtDepartamento.getText().toUpperCase().trim();
                lista.FiltroDepartamento(prueba, departamento);
                lista = prueba;
            } else {
                JOptionPane.showMessageDialog(null, "El campo departamento se encuentra vacío", "Error", JOptionPane.ERROR_MESSAGE);
            }
        }
                
        if (ckbProvincia.isSelected()) {
            if (!txtProvincia.getText().isEmpty()) {
                String provincia = txtProvincia.getText().toUpperCase().trim();
                lista.FiltroProvincia(prueba, provincia);
                lista = prueba;
            } else {
                JOptionPane.showMessageDialog(null, "El campo provincia se encuentra vacío", "Error", JOptionPane.ERROR_MESSAGE);
            }
        }
        
        if (ckbDistrito.isSelected()) {
            if (!txtDistrito.getText().isEmpty()) {
                String distrito = txtDistrito.getText().toUpperCase().trim();
                lista.FiltroDistrito(prueba, distrito);
                lista = prueba;
            } else {
                JOptionPane.showMessageDialog(null, "El campo distrito se encuentra vacío", "Error", JOptionPane.ERROR_MESSAGE);
            }
        }
        
        if (ckbTipoMuestra.isSelected()) {
            if (!txtTipoMuestra.getText().isEmpty()) {
                String tipo = txtTipoMuestra.getText().toUpperCase().trim();
                lista.FiltroTipoMuestra(prueba, tipo);
                lista = prueba;
            } else {
                JOptionPane.showMessageDialog(null, "El campo tipo muestra se encuentra vacío", "Error", JOptionPane.ERROR_MESSAGE);
            }
        }
        
        if (ckbResultado.isSelected()) {
            if (!txtResultado.getText().isEmpty()) {
                String resultado = txtResultado.getText().toUpperCase().trim();
                lista.FiltroResultado(prueba, resultado);
                lista = prueba;
            } else {
                JOptionPane.showMessageDialog(null, "El campo resultado se encuentra vacío", "Error", JOptionPane.ERROR_MESSAGE);
            }
        }              
        return lista;
    }
    
    private void DisableComponents(){
        //JTEXTFIELDS EN BLANCO
        txtEdad.setText(""); txtSexo.setText(""); txtDepartamento.setText("");
        txtProvincia.setText(""); txtDistrito.setText(""); txtTipoMuestra.setText("");
        txtResultado.setText("");
        //JTEXTFIELDS DESACTIVADOS
        txtEdad.setEnabled(false); txtSexo.setEnabled(false); txtDepartamento.setEnabled(false);        
        txtProvincia.setEnabled(false); txtDistrito.setEnabled(false); txtTipoMuestra.setEnabled(false);                
        txtResultado.setEnabled(false);
        //CHECKBOX DESACTIVADOS
        ckbEdad.setSelected(false); ckbSexo.setSelected(false); ckbDepartamento.setSelected(false);                
        ckbProvincia.setSelected(false); ckbDistrito.setSelected(false); ckbTipoMuestra.setSelected(false);                
        ckbResultado.setSelected(false);        
    }

    /**
     * This method is called from within the constructor to initialize the form. WARNING: Do NOT modify this code. The content of this method is always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tbPruebas = new javax.swing.JTable();
        cbxCampo = new javax.swing.JComboBox<>();
        txtBuscar = new javax.swing.JTextField();
        dtBusqueda = new com.toedter.calendar.JDateChooser();
        jLabel2 = new javax.swing.JLabel();
        btnBusqueda = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        jSeparator2 = new javax.swing.JSeparator();
        jLabel6 = new javax.swing.JLabel();
        txtEdad = new javax.swing.JTextField();
        txtSexo = new javax.swing.JTextField();
        txtDepartamento = new javax.swing.JTextField();
        txtProvincia = new javax.swing.JTextField();
        txtDistrito = new javax.swing.JTextField();
        txtTipoMuestra = new javax.swing.JTextField();
        txtResultado = new javax.swing.JTextField();
        btnFiltrar = new javax.swing.JButton();
        ckbEdad = new javax.swing.JCheckBox();
        ckbSexo = new javax.swing.JCheckBox();
        ckbDepartamento = new javax.swing.JCheckBox();
        ckbProvincia = new javax.swing.JCheckBox();
        ckbDistrito = new javax.swing.JCheckBox();
        ckbTipoMuestra = new javax.swing.JCheckBox();
        ckbResultado = new javax.swing.JCheckBox();
        jMenuBar1 = new javax.swing.JMenuBar();
        btnActualizar = new javax.swing.JMenu();
        btnPDF = new javax.swing.JMenu();
        btnCSV = new javax.swing.JMenu();
        btnPrincipal = new javax.swing.JMenu();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Formulario de búsquedas");
        setResizable(false);

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 15)); // NOI18N
        jLabel1.setText("Buscar por:");

        tbPruebas.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Fecha corte", "UUID", "Fecha muestra", "Edad", "Sexo", "Institucion", "Ubi. Pac.", "Depa. Pac.", "Prov. Pac.", "Dist. Pac.", "Depa. Mues.", "Prov. Mues.", "Dist. Mues.", "Tipo Muestra", "Resultado"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.Integer.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        tbPruebas.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbPruebasMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tbPruebas);

        cbxCampo.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "SELEC. CAMPO:", "UUID", "Fecha muestra", "Institución", "Ubigeo" }));
        cbxCampo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbxCampoActionPerformed(evt);
            }
        });

        txtBuscar.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtBuscarKeyPressed(evt);
            }
        });

        dtBusqueda.setDateFormatString("yyyyMMdd");
        dtBusqueda.addPropertyChangeListener(new java.beans.PropertyChangeListener() {
            public void propertyChange(java.beans.PropertyChangeEvent evt) {
                dtBusquedaPropertyChange(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 15)); // NOI18N
        jLabel2.setText("Fecha muestra:");

        btnBusqueda.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/search.png"))); // NOI18N
        btnBusqueda.setText("Búsqueda");
        btnBusqueda.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnBusquedaMouseClicked(evt);
            }
        });

        jLabel4.setFont(new java.awt.Font("Segoe UI", 1, 15)); // NOI18N
        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel4.setText("Leyenda:");

        jLabel5.setFont(new java.awt.Font("Segoe UI", 1, 13)); // NOI18N
        jLabel5.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel5.setText("Ubi. Pac.: Ubigeo Paciente    Depa. Pac.: Departamento Paciente    Prov. Pac.: Provincia Paciente    Dist. Pac.: Distrito Paciente    Depa. Mues.: Departamento Muestra    Prov. Mues.: Provincia Muestra    Dist. Mues.: Distrito Muestra");

        jLabel3.setFont(new java.awt.Font("Segoe UI", 1, 15)); // NOI18N
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel3.setText("Escribir dato:");

        jSeparator1.setForeground(new java.awt.Color(102, 102, 102));
        jSeparator1.setOrientation(javax.swing.SwingConstants.VERTICAL);

        jSeparator2.setForeground(new java.awt.Color(102, 102, 102));

        jLabel6.setFont(new java.awt.Font("Segoe UI", 1, 15)); // NOI18N
        jLabel6.setText("Filtrar por:");

        txtEdad.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtEdad.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtEdadKeyPressed(evt);
            }
        });

        txtSexo.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtSexo.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtSexoKeyPressed(evt);
            }
        });

        txtDepartamento.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtDepartamento.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtDepartamentoKeyPressed(evt);
            }
        });

        txtProvincia.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtProvincia.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtProvinciaKeyPressed(evt);
            }
        });

        txtDistrito.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtDistrito.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtDistritoKeyPressed(evt);
            }
        });

        txtTipoMuestra.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtTipoMuestra.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtTipoMuestraKeyPressed(evt);
            }
        });

        txtResultado.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtResultado.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtResultadoKeyPressed(evt);
            }
        });

        btnFiltrar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/filter16.png"))); // NOI18N
        btnFiltrar.setText("Filtrar");
        btnFiltrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnFiltrarActionPerformed(evt);
            }
        });

        ckbEdad.setFont(new java.awt.Font("Segoe UI", 1, 15)); // NOI18N
        ckbEdad.setText("Edad");
        ckbEdad.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ckbEdadActionPerformed(evt);
            }
        });

        ckbSexo.setFont(new java.awt.Font("Segoe UI", 1, 15)); // NOI18N
        ckbSexo.setText("Sexo");
        ckbSexo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ckbSexoActionPerformed(evt);
            }
        });

        ckbDepartamento.setFont(new java.awt.Font("Segoe UI", 1, 15)); // NOI18N
        ckbDepartamento.setText("Departamento");
        ckbDepartamento.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ckbDepartamentoActionPerformed(evt);
            }
        });

        ckbProvincia.setFont(new java.awt.Font("Segoe UI", 1, 15)); // NOI18N
        ckbProvincia.setText("Provincia");
        ckbProvincia.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ckbProvinciaActionPerformed(evt);
            }
        });

        ckbDistrito.setFont(new java.awt.Font("Segoe UI", 1, 15)); // NOI18N
        ckbDistrito.setText("Distrito");
        ckbDistrito.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ckbDistritoActionPerformed(evt);
            }
        });

        ckbTipoMuestra.setFont(new java.awt.Font("Segoe UI", 1, 15)); // NOI18N
        ckbTipoMuestra.setText("Tipo de muestra");
        ckbTipoMuestra.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ckbTipoMuestraActionPerformed(evt);
            }
        });

        ckbResultado.setFont(new java.awt.Font("Segoe UI", 1, 15)); // NOI18N
        ckbResultado.setText("Resultado");
        ckbResultado.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ckbResultadoActionPerformed(evt);
            }
        });

        jMenuBar1.setBackground(new java.awt.Color(204, 204, 204));

        btnActualizar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/refresh32.png"))); // NOI18N
        btnActualizar.setText("Actualizar");
        btnActualizar.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        btnActualizar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnActualizarMouseClicked(evt);
            }
        });
        jMenuBar1.add(btnActualizar);

        btnPDF.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/pdf32.png"))); // NOI18N
        btnPDF.setText("Exportar PDF");
        btnPDF.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        btnPDF.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnPDFMouseClicked(evt);
            }
        });
        jMenuBar1.add(btnPDF);

        btnCSV.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/csv32.png"))); // NOI18N
        btnCSV.setText("Exportar CSV");
        btnCSV.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        btnCSV.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnCSVMouseClicked(evt);
            }
        });
        jMenuBar1.add(btnCSV);

        btnPrincipal.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/exit32.png"))); // NOI18N
        btnPrincipal.setText("Regresar a Principal");
        btnPrincipal.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        btnPrincipal.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnPrincipalMouseClicked(evt);
            }
        });
        jMenuBar1.add(btnPrincipal);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addComponent(txtBuscar)
                                .addGap(18, 18, 18)
                                .addComponent(btnBusqueda))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(cbxCampo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jLabel2)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(dtBusqueda, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(34, 34, 34)
                        .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 6, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btnFiltrar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(30, 30, 30)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtEdad, javax.swing.GroupLayout.PREFERRED_SIZE, 79, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(ckbEdad))
                        .addGap(29, 29, 29)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(txtSexo, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(29, 29, 29)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txtDepartamento, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(ckbDepartamento)))
                            .addComponent(ckbSexo))
                        .addGap(29, 29, 29)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtProvincia, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(ckbProvincia))
                        .addGap(29, 29, 29)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtDistrito, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(ckbDistrito))
                        .addGap(29, 29, 29)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtTipoMuestra, javax.swing.GroupLayout.PREFERRED_SIZE, 135, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(ckbTipoMuestra))
                        .addGap(29, 29, 29)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtResultado, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(ckbResultado)))
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                            .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 79, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(18, 18, 18)
                            .addComponent(jLabel5, javax.swing.GroupLayout.DEFAULT_SIZE, 1480, Short.MAX_VALUE))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jSeparator2)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(16, 16, 16)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jLabel1)
                                .addComponent(cbxCampo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabel2))
                            .addComponent(dtBusqueda, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(txtBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabel3))
                            .addComponent(btnBusqueda)))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 84, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(17, 17, 17)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel6)
                                    .addComponent(ckbEdad)
                                    .addComponent(ckbSexo)))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(ckbDepartamento, javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(ckbProvincia, javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(ckbDistrito)
                                        .addComponent(ckbTipoMuestra)
                                        .addComponent(ckbResultado)))))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(txtEdad, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtSexo, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtDepartamento, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtProvincia, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtDistrito, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtTipoMuestra, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtResultado, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(12, 12, 12)
                                .addComponent(btnFiltrar)))))
                .addGap(6, 6, 6)
                .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(12, 12, 12)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(jLabel5))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 395, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(16, 16, 16))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void cbxCampoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbxCampoActionPerformed
        if (cbxCampo.getSelectedIndex() == 2) {
            txtBuscar.setEnabled(false);
            dtBusqueda.setEnabled(true);
        } else {            
            txtBuscar.setEnabled(true);
            dtBusqueda.setEnabled(false);
            txtBuscar.setText("");
        }
    }//GEN-LAST:event_cbxCampoActionPerformed

    private void dtBusquedaPropertyChange(java.beans.PropertyChangeEvent evt) {//GEN-FIRST:event_dtBusquedaPropertyChange
        if (evt.getNewValue() != null) {
            String fecha = ((JTextField) dtBusqueda.getDateEditor().getUiComponent()).getText();            
            txtBuscar.setText(fecha);
        }
        
    }//GEN-LAST:event_dtBusquedaPropertyChange

    private void btnPrincipalMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnPrincipalMouseClicked
        PrincipalView view = new PrincipalView();
        view.setVisible(true);
        this.setVisible(false);
        this.dispose();
    }//GEN-LAST:event_btnPrincipalMouseClicked

    private void btnActualizarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnActualizarMouseClicked
        ((DefaultTableModel)tbPruebas.getModel()).setRowCount(0);
        listaPruebas.ImprimirInorden();
        txtBuscar.setText("");
        cbxCampo.setSelectedIndex(0);
        listaBusqueda.vaciarCola(listaBusqueda);
    }//GEN-LAST:event_btnActualizarMouseClicked

    private void btnBusquedaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnBusquedaMouseClicked
        Busqueda();                          
    }//GEN-LAST:event_btnBusquedaMouseClicked

    private void btnPDFMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnPDFMouseClicked
        if (!ckbEdad.isSelected() && !ckbSexo.isSelected()
                && !ckbDepartamento.isSelected() && !ckbProvincia.isSelected()
                && !ckbDistrito.isSelected() && !ckbTipoMuestra.isSelected()
                && !ckbResultado.isSelected()) {
            PDFView view = new PDFView(this, true, listaBusqueda);
            view.setVisible(true);
        }else{
            JOptionPane.showMessageDialog(null, "Primero realice el filtro para exportar o desactive los checkbox");
        }
        
    }//GEN-LAST:event_btnPDFMouseClicked

    private void btnCSVMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnCSVMouseClicked
        if (!ckbEdad.isSelected() && !ckbSexo.isSelected()
                && !ckbDepartamento.isSelected() && !ckbProvincia.isSelected()
                && !ckbDistrito.isSelected() && !ckbTipoMuestra.isSelected()
                && !ckbResultado.isSelected()) {
            CSVView view = new CSVView(this,true,listaBusqueda);
            view.setVisible(true);
        }else{
            JOptionPane.showMessageDialog(null, "Primero realice el filtro para exportar o desactive los checkbox");
        }        
    }//GEN-LAST:event_btnCSVMouseClicked

    private void tbPruebasMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbPruebasMouseClicked
        //PARA SELECCIONAR UNA FILA EN LA TABLA Y OBTENER SUS DATOS
        int selection = tbPruebas.rowAtPoint(evt.getPoint());
        int cbxopc = cbxCampo.getSelectedIndex();      
        switch(cbxopc){
            case 1: //UUID
                txtBuscar.setText(String.valueOf(tbPruebas.getValueAt(selection,1)));
                break;
            case 2: //FECHA MUESTRA
                txtBuscar.setText(String.valueOf(tbPruebas.getValueAt(selection,2)));
                break;
            case 3: //INSTITUCION
                txtBuscar.setText(String.valueOf(tbPruebas.getValueAt(selection,5)));
                break;
            case 4: //UBIGEO
                txtBuscar.setText(String.valueOf(tbPruebas.getValueAt(selection,6)));
                break;
            default: //SELECT
                txtBuscar.setText("");
        }
    }//GEN-LAST:event_tbPruebasMouseClicked

    private void ckbEdadActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ckbEdadActionPerformed
        if(ckbEdad.isSelected()){
            txtEdad.setEnabled(true);
        }
        else{
            txtEdad.setEnabled(false);
        }
    }//GEN-LAST:event_ckbEdadActionPerformed

    private void ckbSexoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ckbSexoActionPerformed
        if(ckbSexo.isSelected()){
            txtSexo.setEnabled(true);
        }
        else{
            txtSexo.setEnabled(false);
        }
    }//GEN-LAST:event_ckbSexoActionPerformed

    private void ckbDepartamentoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ckbDepartamentoActionPerformed
        if(ckbDepartamento.isSelected()){
            txtDepartamento.setEnabled(true);
        }
        else{
            txtDepartamento.setEnabled(false);
        }
    }//GEN-LAST:event_ckbDepartamentoActionPerformed

    private void ckbProvinciaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ckbProvinciaActionPerformed
        if(ckbProvincia.isSelected()){
            txtProvincia.setEnabled(true);
        }
        else{
            txtProvincia.setEnabled(false);
        }
    }//GEN-LAST:event_ckbProvinciaActionPerformed

    private void ckbDistritoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ckbDistritoActionPerformed
        if(ckbDistrito.isSelected()){
            txtDistrito.setEnabled(true);
        }
        else{
            txtDistrito.setEnabled(false);
        }
    }//GEN-LAST:event_ckbDistritoActionPerformed

    private void ckbTipoMuestraActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ckbTipoMuestraActionPerformed
        if(ckbTipoMuestra.isSelected()){
            txtTipoMuestra.setEnabled(true);
        }
        else{
            txtTipoMuestra.setEnabled(false);
        }
    }//GEN-LAST:event_ckbTipoMuestraActionPerformed

    private void ckbResultadoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ckbResultadoActionPerformed
        if(ckbResultado.isSelected()){
            txtResultado.setEnabled(true);
        }
        else{
            txtResultado.setEnabled(false);
        }
    }//GEN-LAST:event_ckbResultadoActionPerformed

    private void btnFiltrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnFiltrarActionPerformed
        Filtrado();
    }//GEN-LAST:event_btnFiltrarActionPerformed

    private void txtBuscarKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtBuscarKeyPressed
        if(evt.getKeyCode()==KeyEvent.VK_ENTER){
            Busqueda();
        }
    }//GEN-LAST:event_txtBuscarKeyPressed

    private void txtEdadKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtEdadKeyPressed
        if(evt.getKeyCode()==KeyEvent.VK_ENTER){
            Filtrado();
        }
    }//GEN-LAST:event_txtEdadKeyPressed

    private void txtSexoKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtSexoKeyPressed
        if(evt.getKeyCode()==KeyEvent.VK_ENTER){
            Filtrado();
        }
    }//GEN-LAST:event_txtSexoKeyPressed

    private void txtDepartamentoKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtDepartamentoKeyPressed
        if(evt.getKeyCode()==KeyEvent.VK_ENTER){
            Filtrado();
        }
    }//GEN-LAST:event_txtDepartamentoKeyPressed

    private void txtProvinciaKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtProvinciaKeyPressed
        if(evt.getKeyCode()==KeyEvent.VK_ENTER){
            Filtrado();
        }
    }//GEN-LAST:event_txtProvinciaKeyPressed

    private void txtDistritoKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtDistritoKeyPressed
        if(evt.getKeyCode()==KeyEvent.VK_ENTER){
            Filtrado();
        }
    }//GEN-LAST:event_txtDistritoKeyPressed

    private void txtTipoMuestraKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtTipoMuestraKeyPressed
        if(evt.getKeyCode()==KeyEvent.VK_ENTER){
            Filtrado();
        }
    }//GEN-LAST:event_txtTipoMuestraKeyPressed

    private void txtResultadoKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtResultadoKeyPressed
        if(evt.getKeyCode()==KeyEvent.VK_ENTER){
            Filtrado();
        }
    }//GEN-LAST:event_txtResultadoKeyPressed

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
            java.util.logging.Logger.getLogger(BusquedasView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(BusquedasView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(BusquedasView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(BusquedasView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new BusquedasView().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenu btnActualizar;
    private javax.swing.JButton btnBusqueda;
    private javax.swing.JMenu btnCSV;
    private javax.swing.JButton btnFiltrar;
    private javax.swing.JMenu btnPDF;
    private javax.swing.JMenu btnPrincipal;
    private javax.swing.JComboBox<String> cbxCampo;
    private javax.swing.JCheckBox ckbDepartamento;
    private javax.swing.JCheckBox ckbDistrito;
    private javax.swing.JCheckBox ckbEdad;
    private javax.swing.JCheckBox ckbProvincia;
    private javax.swing.JCheckBox ckbResultado;
    private javax.swing.JCheckBox ckbSexo;
    private javax.swing.JCheckBox ckbTipoMuestra;
    private com.toedter.calendar.JDateChooser dtBusqueda;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private static javax.swing.JTable tbPruebas;
    private javax.swing.JTextField txtBuscar;
    private javax.swing.JTextField txtDepartamento;
    private javax.swing.JTextField txtDistrito;
    private javax.swing.JTextField txtEdad;
    private javax.swing.JTextField txtProvincia;
    private javax.swing.JTextField txtResultado;
    private javax.swing.JTextField txtSexo;
    private javax.swing.JTextField txtTipoMuestra;
    // End of variables declaration//GEN-END:variables
}
