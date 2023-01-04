/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package principal;

import java.sql.ResultSet;
import java.sql.Statement;
import javax.swing.table.DefaultTableModel;
import java.util.ArrayList;

import java.sql.*;
import javax.swing.JOptionPane;

public class FormularioSuscripcion extends javax.swing.JFrame {
      
    Conexion conn = new Conexion();
    ArrayList listado = new ArrayList();
     Connection cn;
     Statement st;
     ResultSet rs;
 
    public FormularioSuscripcion() {
        initComponents();
        listarClientes();
    }
    
    
        public ArrayList ListarClientes(){
    
        ArrayList lista = new ArrayList();
        
        try{
            Statement sql = conn.conectar().createStatement();
            String query = "SELECT * FROM proveedores";
            ResultSet res = sql.executeQuery(query);
            
            while(res.next()){
            
                Proveedor objProveedor = new Proveedor();
                objProveedor.setIdProveedor(res.getInt(1));
                objProveedor.setNombre(res.getString(2));
                objProveedor.setCategoria(res.getString(3));
                objProveedor.setInicioSus(res.getString(4));
                objProveedor.setCiclo(res.getInt(5));
                objProveedor.setDuracion(res.getInt(6));
                objProveedor.setMoneda(res.getString(7));
                objProveedor.setPrecio(res.getFloat(8));
                objProveedor.setTotal(res.getFloat(9));
                lista.add(objProveedor);   
            }    
            
        }catch(SQLException e){
            
            System.out.println("Error: " + e.getMessage());
        }
        
        return lista;
    }
     
    private void listarClientes(){
        
        ListarClientes();
        
    
        try{
            listado = ListarClientes();
            DefaultTableModel table = new DefaultTableModel();
            table.setColumnCount(0);
            table.addColumn("Id proveedor");
            table.addColumn("Nombre");
            table.addColumn("Categoria");
            table.addColumn("Inicio de suscripcion");
            table.addColumn("Ciclo");
            table.addColumn("Duracion");
            table.addColumn("Moneda");
            table.addColumn("Precio/Ciclo");
            table.addColumn("Total");
            table.setRowCount(listado.size());
            
            for(int i = 0; i < listado.size(); i++){
                
                Proveedor objPro = (Proveedor)listado.get(i);
                table.setValueAt(objPro.getIdProveedor(), i ,0);
                table.setValueAt(objPro.getNombre(), i ,1);
                table.setValueAt(objPro.getCategoria(), i ,2);
                table.setValueAt(objPro.getInicioSus(), i ,3);
                table.setValueAt(objPro.getCiclo(), i ,4);
                table.setValueAt(objPro.getDuracion(), i ,5);
                table.setValueAt(objPro.getMoneda(), i ,6);
                table.setValueAt(objPro.getPrecio(), i ,7);
                table.setValueAt(objPro.getTotal(), i ,8);
            }
            
            jTable1.setModel(table);
            
        }catch(Exception e){
        
        }
    }
        
    public ArrayList ListarCategorias(){
    
        ArrayList lista = new ArrayList();
       
        
        try{
            String categoria = cboFiltroC.getSelectedItem().toString();
            Statement sql = conn.conectar().createStatement();
            String query = "SELECT * FROM proveedores where categoria = '" +categoria+"'";
            System.out.println(categoria);
            ResultSet res = sql.executeQuery(query);
            
            while(res.next()){
            
                Proveedor objProveedor = new Proveedor();
                objProveedor.setIdProveedor(res.getInt(1));
                objProveedor.setNombre(res.getString(2));
                objProveedor.setCategoria(res.getString(3));
                objProveedor.setInicioSus(res.getString(4));
                objProveedor.setCiclo(res.getInt(5));
                objProveedor.setDuracion(res.getInt(6));
                objProveedor.setMoneda(res.getString(7));
                objProveedor.setPrecio(res.getFloat(8));
                objProveedor.setTotal(res.getFloat(9));
                lista.add(objProveedor);   
            }    
            
        }catch(SQLException e){
            
            System.out.println("Error: " + e.getMessage());
        }
        
        return lista;
    }
    
    private void listarCategorias(){
        
        ListarCategorias();
        
    
        try{
            listado = ListarCategorias();
            DefaultTableModel table = new DefaultTableModel();
            table.setColumnCount(0);
            table.addColumn("Id proveedor");
            table.addColumn("Nombre");
            table.addColumn("Categoria");
            table.addColumn("Inicio de suscripcion");
            table.addColumn("Ciclo");
            table.addColumn("Duracion");
            table.addColumn("Moneda");
            table.addColumn("Precio/Ciclo");
            table.addColumn("Total");
            table.setRowCount(listado.size());
            
            for(int i = 0; i < listado.size(); i++){
                
                Proveedor objPro = (Proveedor)listado.get(i);
                table.setValueAt(objPro.getIdProveedor(), i ,0);
                table.setValueAt(objPro.getNombre(), i ,1);
                table.setValueAt(objPro.getCategoria(), i ,2);
                table.setValueAt(objPro.getInicioSus(), i ,3);
                table.setValueAt(objPro.getCiclo(), i ,4);
                table.setValueAt(objPro.getDuracion(), i ,5);
                table.setValueAt(objPro.getMoneda(), i ,6);
                table.setValueAt(objPro.getPrecio(), i ,7);
                table.setValueAt(objPro.getTotal(), i ,8);
            }
            
            jTable1.setModel(table);
            
        }catch(Exception e){
        
        }
    }
    
    public ArrayList ListarMonedas(){
    
        ArrayList lista = new ArrayList();
       
        
        try{
            String moneda = cboFiltroM.getSelectedItem().toString();
            Statement sql = conn.conectar().createStatement();
            String query = "SELECT * FROM proveedores where moneda = '" +moneda+"'";
            System.out.println(moneda);
            ResultSet res = sql.executeQuery(query);
            
            while(res.next()){
            
                Proveedor objProveedor = new Proveedor();
                objProveedor.setIdProveedor(res.getInt(1));
                objProveedor.setNombre(res.getString(2));
                objProveedor.setCategoria(res.getString(3));
                objProveedor.setInicioSus(res.getString(4));
                objProveedor.setCiclo(res.getInt(5));
                objProveedor.setDuracion(res.getInt(6));
                objProveedor.setMoneda(res.getString(7));
                objProveedor.setPrecio(res.getFloat(8));
                objProveedor.setTotal(res.getFloat(9));
                lista.add(objProveedor);   
            }    
            
        }catch(SQLException e){
            
            System.out.println("Error: " + e.getMessage());
        }
        
        return lista;
    }
    
    private void listarModenas(){
        
        ListarMonedas();
        
    
        try{
            listado = ListarMonedas();
            DefaultTableModel table = new DefaultTableModel();
            table.setColumnCount(0);
            table.addColumn("Id proveedor");
            table.addColumn("Nombre");
            table.addColumn("Categoria");
            table.addColumn("Inicio de suscripcion");
            table.addColumn("Ciclo");
            table.addColumn("Duracion");
            table.addColumn("Moneda");
            table.addColumn("Precio/Ciclo");
            table.addColumn("Total");
            table.setRowCount(listado.size());
            
            for(int i = 0; i < listado.size(); i++){
                
                Proveedor objPro = (Proveedor)listado.get(i);
                table.setValueAt(objPro.getIdProveedor(), i ,0);
                table.setValueAt(objPro.getNombre(), i ,1);
                table.setValueAt(objPro.getCategoria(), i ,2);
                table.setValueAt(objPro.getInicioSus(), i ,3);
                table.setValueAt(objPro.getCiclo(), i ,4);
                table.setValueAt(objPro.getDuracion(), i ,5);
                table.setValueAt(objPro.getMoneda(), i ,6);
                table.setValueAt(objPro.getPrecio(), i ,7);
                table.setValueAt(objPro.getTotal(), i ,8);
            }
            
            jTable1.setModel(table);
            
        }catch(Exception e){
        
        }
    }
    
    
  
    
    
    
    void agregar(){
    
        int idProveedor, ciclo, duracion;
        String nombre, categoria, moneda, inicioSus;
        float precio, total;
        
        
        idProveedor = Integer.parseInt(txtId.getText());
        nombre = txtNombre.getText();
        categoria = cboCtg.getSelectedItem().toString();
        inicioSus = txtInicio.getText();
        ciclo =  Integer.parseInt(txtCiclo.getText());
        duracion = Integer.parseInt(txtDuracion.getText());
        moneda = cboMoneda.getSelectedItem().toString();
        precio = Float.parseFloat(txtPrecio.getText()) ;
        total = precio * duracion;
        
        if(txtId.equals("") || txtNombre.equals("") || txtInicio.equals("") || txtCiclo.equals("") 
                || txtDuracion.equals("") || txtPrecio.equals("")){
            
            JOptionPane.showMessageDialog(null, "Complete todas los recuadros");
            txtId.requestFocus();
        }
        else{
          
            String query = "  INSERT into proveedores VALUES("+idProveedor+",'"+nombre+"','"+categoria+"', '"+inicioSus+"',"+ciclo+
                    ","+duracion+",'"+moneda+"',"+precio+","+total+") ";
            
            try{        
                Statement st = conn.conectar().createStatement();      
                st.executeUpdate(query);
                
                JOptionPane.showMessageDialog(null, nombre + " agregado correctamente");
                              
            }
            catch(Exception e){
                JOptionPane.showMessageDialog(null, nombre + " Error al agregar");
            } 
        }
        
        listarClientes();
        limpiar();
    }
    
    
    
    void actualizar(){
    
        int idProveedor, ciclo, duracion;
        String nombre, categoria, moneda, inicioSus;
        float precio, total;
        
        
        idProveedor = Integer.parseInt(txtId.getText());
        nombre = txtNombre.getText();
        categoria = cboCtg.getSelectedItem().toString();
        inicioSus = txtInicio.getText();
        ciclo =  Integer.parseInt(txtCiclo.getText());
        duracion = Integer.parseInt(txtDuracion.getText());
        moneda = cboMoneda.getSelectedItem().toString();
        precio = Float.parseFloat(txtPrecio.getText()) ;
        total = precio * duracion;
        ;
        
         if(txtId.equals("") || txtNombre.equals("") || txtInicio.equals("") || txtCiclo.equals("") 
                || txtDuracion.equals("") || txtPrecio.equals("")){
            
            JOptionPane.showMessageDialog(null, "Complete todas los recuadros");
            txtId.requestFocus();
        }
        else{
          
            String query = "UPDATE proveedores SET nombre='"+nombre+"', categoria='"+categoria+
                    "',inicioSus= '"+inicioSus+"', ciclo = "+ciclo+" , duracion= "+duracion+", moneda = '"+moneda+"', precio = "
                    +precio+ " WHERE idProveedor ="+idProveedor ;
            
            try{        
                Statement st = conn.conectar().createStatement();      
                st.executeUpdate(query);
                
                JOptionPane.showMessageDialog(null, nombre + " actualizado correctamente");
                
                /*limpiar();*/
                
                          
            }
            catch(Exception e){} 
        }
         listarClientes();
         limpiar();
    }
    
    void eliminar(){
        
        String idProveedor = txtID2.getText();
        
        if(idProveedor.equals("")){
            
            JOptionPane.showMessageDialog(null, "Ingrese ID para eliminar");
            txtID2.requestFocus();
        }
        else{
          
            String query = " DELETE FROM proveedores WHERE idProveedor = "+idProveedor;
            
            try{        
                Statement st = conn.conectar().createStatement();      
                st.executeUpdate(query);
                
                JOptionPane.showMessageDialog(null, idProveedor + " eliminado correctamente");
                
                /*limpiar();*/
                
                          
            }
            catch(Exception e){} 
        }
        listarClientes();
        txtID2.requestFocus();
    
    }

    void limpiar(){
    
        txtId.setText("");
        txtNombre.setText("");
        txtInicio.setText("");
        txtCiclo.setText("");
        txtDuracion.setText("");
        txtPrecio.setText("");
        cboCtg.setSelectedIndex(0);
        cboMoneda.setSelectedIndex(0);
        
        
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        txtId = new javax.swing.JTextField();
        txtNombre = new javax.swing.JTextField();
        txtInicio = new javax.swing.JTextField();
        txtDuracion = new javax.swing.JTextField();
        txtPrecio = new javax.swing.JTextField();
        txtCiclo = new javax.swing.JTextField();
        cboCtg = new javax.swing.JComboBox<>();
        cboMoneda = new javax.swing.JComboBox<>();
        jLabel6 = new javax.swing.JLabel();
        cboServicios = new javax.swing.JComboBox<>();
        jButton1 = new javax.swing.JButton();
        jLabel10 = new javax.swing.JLabel();
        txtID2 = new javax.swing.JTextField();
        btnEliminar = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        jLabel11 = new javax.swing.JLabel();
        cboFiltroM = new javax.swing.JComboBox<>();
        jLabel12 = new javax.swing.JLabel();
        cboFiltroC = new javax.swing.JComboBox<>();
        btnListar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane1.setViewportView(jTable1);

        jLabel1.setText("ID Proveedor");

        jLabel2.setText("Nombre de servicio");

        jLabel3.setText("Categoria");

        jLabel4.setText("Inicio Suscripcion");

        jLabel5.setText("Precio");

        jLabel7.setText("Duracion");

        jLabel8.setText("Ciclo");
        jLabel8.setToolTipText("");

        jLabel9.setText("Moneda");

        cboCtg.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Peliculas y Series", "Musica y Podcast", "Entretenimiento" }));

        cboMoneda.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Soles (S/.)", "Euros (€)", "Dolar USD (US$)", "Yen (¥)", "Libra esterlina (£)", "Yuan( 元)", "Won (₩)" }));

        jLabel6.setText("Agregue suscripcion");

        cboServicios.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Manual", "Netflix", "Amazon Prime Video", "Disney Plus", "Apple TV", "HBO PLUS", "Spotify", "Apple Music", "Amazon Prime Music", "Google Play Music", "Discord Nitro", "Dota Plus", "Apple Arcade", "Playstatios Plus", "Xbox Game Pass", "Nintengo Switch Online" }));
        cboServicios.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cboServiciosItemStateChanged(evt);
            }
        });
        cboServicios.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cboServiciosActionPerformed(evt);
            }
        });

        jButton1.setText("Agregar");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jLabel10.setText(" ID");

        btnEliminar.setText("Eliminar");
        btnEliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEliminarActionPerformed(evt);
            }
        });

        jButton4.setText("Actualizar");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        jLabel11.setText("Filtrar categoria");

        cboFiltroM.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Moneda", "Soles (S/.)", "Euros (€)", "Dolar USD (US$)", "Yen (¥)", "Libra esterlina (£)", "Yuan( 元)", "Won (₩)" }));
        cboFiltroM.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cboFiltroMItemStateChanged(evt);
            }
        });

        jLabel12.setText("Filtrar moneda");

        cboFiltroC.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Categoria", "Peliculas y Series", "Musica y Podcast", "Entretenimiento" }));
        cboFiltroC.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cboFiltroCItemStateChanged(evt);
            }
        });

        btnListar.setText("Ver todo");
        btnListar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnListarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(22, 22, 22)
                        .addComponent(jLabel6)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(cboServicios, javax.swing.GroupLayout.PREFERRED_SIZE, 225, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(52, 52, 52)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jLabel1)
                                    .addComponent(jLabel2))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                        .addComponent(txtId)
                                        .addGap(78, 78, 78))
                                    .addComponent(txtNombre, javax.swing.GroupLayout.PREFERRED_SIZE, 164, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(8, 8, 8)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jLabel4)
                                    .addComponent(jLabel3)
                                    .addComponent(jLabel8)
                                    .addComponent(jLabel7)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jLabel5)
                                        .addGap(49, 49, 49))
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jLabel9)
                                        .addGap(38, 38, 38)))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(cboCtg, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                                .addComponent(txtInicio, javax.swing.GroupLayout.DEFAULT_SIZE, 105, Short.MAX_VALUE)
                                                .addComponent(txtCiclo)
                                                .addComponent(txtDuracion)
                                                .addComponent(txtPrecio, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE))
                                            .addComponent(cboMoneda, javax.swing.GroupLayout.PREFERRED_SIZE, 166, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGap(0, 42, Short.MAX_VALUE))))))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(120, 120, 120)
                        .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 82, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton4)))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 1081, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap())
                    .addGroup(layout.createSequentialGroup()
                        .addGap(82, 82, 82)
                        .addComponent(jLabel10)
                        .addGap(18, 18, 18)
                        .addComponent(txtID2, javax.swing.GroupLayout.PREFERRED_SIZE, 164, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnEliminar)
                        .addGap(67, 67, 67)
                        .addComponent(jLabel11)
                        .addGap(18, 18, 18)
                        .addComponent(cboFiltroC, javax.swing.GroupLayout.PREFERRED_SIZE, 233, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel12)
                        .addGap(18, 18, 18)
                        .addComponent(cboFiltroM, javax.swing.GroupLayout.PREFERRED_SIZE, 113, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 56, Short.MAX_VALUE)
                        .addComponent(btnListar)
                        .addGap(34, 34, 34))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(56, 56, 56)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(cboServicios, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(42, 42, 42)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(txtId, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(txtNombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(cboCtg, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(9, 9, 9)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(txtInicio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8)
                    .addComponent(txtCiclo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(txtDuracion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel9)
                    .addComponent(cboMoneda, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(txtPrecio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton4)
                    .addComponent(jButton1))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(62, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel10)
                    .addComponent(txtID2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnEliminar)
                    .addComponent(jLabel11)
                    .addComponent(cboFiltroM, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel12)
                    .addComponent(cboFiltroC, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnListar))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 466, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(49, 49, 49))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void cboServiciosItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cboServiciosItemStateChanged
        
        if( cboServicios.getSelectedIndex() != 0){
            txtId.disable();
            txtNombre.disable();
            cboCtg.disable();
        
            Conexion conn = new Conexion();
                
            Connection cn;
            Statement st;
            ResultSet rs;
        
        
        }
        else{
            txtId.enable();
            txtNombre.enable();
            cboCtg.enable();
        }
    }//GEN-LAST:event_cboServiciosItemStateChanged

    private void cboServiciosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cboServiciosActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cboServiciosActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        agregar();
    }//GEN-LAST:event_jButton1ActionPerformed

    private void btnEliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliminarActionPerformed
       
        eliminar();
        
    }//GEN-LAST:event_btnEliminarActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        
        actualizar();
    }//GEN-LAST:event_jButton4ActionPerformed

    private void cboFiltroCItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cboFiltroCItemStateChanged
        
        listarCategorias();
        cboFiltroM.setSelectedIndex(0);
        
        
    }//GEN-LAST:event_cboFiltroCItemStateChanged

    private void btnListarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnListarActionPerformed
        
        cboFiltroC.setSelectedIndex(0);
        cboFiltroM.setSelectedIndex(0);
        listarClientes();
        
    }//GEN-LAST:event_btnListarActionPerformed

    private void cboFiltroMItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cboFiltroMItemStateChanged
        
        listarModenas();
        cboFiltroC.setSelectedIndex(0);
    }//GEN-LAST:event_cboFiltroMItemStateChanged

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
            java.util.logging.Logger.getLogger(FormularioSuscripcion.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FormularioSuscripcion.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FormularioSuscripcion.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FormularioSuscripcion.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FormularioSuscripcion().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnEliminar;
    private javax.swing.JButton btnListar;
    private javax.swing.JComboBox<String> cboCtg;
    private javax.swing.JComboBox<String> cboFiltroC;
    private javax.swing.JComboBox<String> cboFiltroM;
    private javax.swing.JComboBox<String> cboMoneda;
    private javax.swing.JComboBox<String> cboServicios;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton4;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JTextField txtCiclo;
    private javax.swing.JTextField txtDuracion;
    private javax.swing.JTextField txtID2;
    private javax.swing.JTextField txtId;
    private javax.swing.JTextField txtInicio;
    private javax.swing.JTextField txtNombre;
    private javax.swing.JTextField txtPrecio;
    // End of variables declaration//GEN-END:variables
}
