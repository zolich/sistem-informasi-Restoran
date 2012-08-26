package transaksi;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.table.DefaultTableModel;
import restoran.main;

/**
 *
 * @author meita
 */
public class pesanan extends javax.swing.JInternalFrame {
    private javax.swing.table.DefaultTableModel tblModel = getDefaultTabelModel();
    
    public pesanan() {
        initComponents();
        operator.setText("Operator : "+main.username);
        tbldetail.setModel(tblModel);
        loadMakanan();
        nopesanan.getDocument().addDocumentListener(new DocumentListener() {

            @Override
            public void insertUpdate(DocumentEvent e) {
              if (nopesanan.getText().length()>0) {
                  cariDetailPesanan(Integer.parseInt(nopesanan.getText()));
              }
            }

            @Override
            public void removeUpdate(DocumentEvent e) {
              if (nopesanan.getText().length()>0) {
                  cariDetailPesanan(Integer.parseInt(nopesanan.getText()));
              }
            }

            @Override
            public void changedUpdate(DocumentEvent e) {
              if (nopesanan.getText().length()>0) {
                  cariDetailPesanan(Integer.parseInt(nopesanan.getText()));
              }
            }
        });
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        nopesanan = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        tglpesan = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        meja = new javax.swing.JComboBox();
        operator = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        makanan = new javax.swing.JComboBox();
        jLabel7 = new javax.swing.JLabel();
        jumlah = new javax.swing.JFormattedTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        tbldetail = new javax.swing.JTable();
        list_hapus = new javax.swing.JButton();
        list_tambah = new javax.swing.JButton();
        keluar = new javax.swing.JButton();
        hapus = new javax.swing.JButton();
        ubah = new javax.swing.JButton();
        tambah = new javax.swing.JButton();
        jLabel8 = new javax.swing.JLabel();
        cari = new javax.swing.JButton();

        setClosable(true);
        setTitle("Transaksi Pesanan");

        jLabel1.setText("No. Pesanan");

        nopesanan.setEditable(false);
        nopesanan.setHorizontalAlignment(javax.swing.JTextField.RIGHT);

        jLabel2.setText("Tgl. Pesanan");

        tglpesan.setEditable(false);

        jLabel3.setText("No. Meja");

        meja.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "1", "2", "3", "4", "5", "6", "7", "8", "9", "10" }));

        operator.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        operator.setText("Operator : -");

        jPanel1.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabel5.setText("Nama Makanan");

        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel6.setText("Detail Pesanan");

        jLabel7.setText("Jumlah");

        jumlah.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.NumberFormatter(new java.text.DecimalFormat("#0"))));

        tbldetail.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null},
                {null, null},
                {null, null},
                {null, null}
            },
            new String [] {
                "Nama Makanan", "Jumlah"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.Integer.class
            };
            boolean[] canEdit = new boolean [] {
                true, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tbldetail.setColumnSelectionAllowed(true);
        jScrollPane1.setViewportView(tbldetail);
        tbldetail.getColumnModel().getSelectionModel().setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);

        list_hapus.setText("hapus list");
        list_hapus.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                list_hapusActionPerformed(evt);
            }
        });

        list_tambah.setText("tambah list");
        list_tambah.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                list_tambahActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 580, Short.MAX_VALUE)
                    .addComponent(jLabel6)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel5)
                            .addComponent(jLabel7))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(makanan, javax.swing.GroupLayout.PREFERRED_SIZE, 236, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jumlah, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(list_tambah)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(list_hapus)))))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel6)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(makanan, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(jumlah, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(list_hapus)
                    .addComponent(list_tambah))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 220, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        keluar.setText("Keluar");
        keluar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                keluarActionPerformed(evt);
            }
        });

        hapus.setText("Hapus");

        ubah.setText("Ubah");
        ubah.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ubahActionPerformed(evt);
            }
        });

        tambah.setText("Tambah");
        tambah.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tambahActionPerformed(evt);
            }
        });

        jLabel8.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel8.setText("Belum Terbayar");

        cari.setText("...");
        cari.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cariActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2)
                            .addComponent(jLabel1)
                            .addComponent(jLabel3))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(nopesanan, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(cari, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(operator))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(meja, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(tglpesan, javax.swing.GroupLayout.PREFERRED_SIZE, 119, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jLabel8))))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(tambah)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(ubah)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(hapus)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(keluar)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(nopesanan, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(operator)
                    .addComponent(cari))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(tglpesan, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel8))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(meja, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(keluar)
                    .addComponent(hapus)
                    .addComponent(ubah)
                    .addComponent(tambah))
                .addContainerGap(16, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
    
    private void loadMakanan(){
        try {
            Class.forName ("com.mysql.jdbc.Driver");
            String urldb="jdbc:mysql://localhost:3306/restaurant";
            String user=main.dbUser;
            String password=main.dbPassword;
            Connection koneksi=java.sql.DriverManager.getConnection(urldb,user,password);
            String strSQL = "SELECT `makanan`.`nama` "
                            + "FROM `makanan`";

            Statement st = koneksi.createStatement();
            ResultSet rs = st.executeQuery(strSQL);
            
            while (rs.next()){
                makanan.addItem(rs.getString(1));
            }
            
            rs.close();
            st.close();
            koneksi.close();
        }catch(ClassNotFoundException cnfe){
            System.out.println("kesalahan saat"+"me-load driver jdbc \n"+cnfe.getMessage());
        }catch(SQLException sqle){
            System.out.println("keslahan saat koneksi atau "+"kesalahan query sql \n"+sqle.getMessage());
        }
    }
    
    private void cariDetailPesanan(int noPesanan){
        try {
            Class.forName ("com.mysql.jdbc.Driver");
            String urldb="jdbc:mysql://localhost:3306/restaurant";
            String user=main.dbUser;
            String password=main.dbPassword;
            Connection koneksi=java.sql.DriverManager.getConnection(urldb,user,password);
            String strSQL = "SELECT * "
                            + "FROM `detail_pesanan` "
                            + "WHERE `no_pesanan` = '"+noPesanan+"' ";

            Statement st = koneksi.createStatement();
            ResultSet rs = st.executeQuery(strSQL);
            
            while (tblModel.getRowCount() > 0){
                tblModel.removeRow(0);
            }
            
            while (rs.next()){
                tblModel.addRow(new String[]{rs.getString(2), rs.getString(3)});
            }
            
            rs.close();
            st.close();
            koneksi.close();
        }catch(ClassNotFoundException cnfe){
            System.out.println("kesalahan saat"+"me-load driver jdbc \n"+cnfe.getMessage());
        }catch(SQLException sqle){
            System.out.println("keslahan saat koneksi atau "+"kesalahan query sql \n"+sqle.getMessage());
        }
    }
    
    private javax.swing.table.DefaultTableModel getDefaultTabelModel() {
        return new javax.swing.table.DefaultTableModel(
                new Object[][] {},
                new String[] {"Nama Makanan", "Jumlah"}
            ){
                boolean[] canEdit=new boolean[]{
                    false,false
                };

                public boolean isiCellEditable(int rowIndex,int columnIndex){
                        return canEdit[columnIndex];

                }
            };
    }
    
    private void cariActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cariActionPerformed
        cari_pesanan cari = new cari_pesanan(nopesanan, meja, tglpesan);
        cari.setVisible(true);
    }//GEN-LAST:event_cariActionPerformed

    private void list_tambahActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_list_tambahActionPerformed
        tblModel.addRow(new Object[]{makanan.getSelectedItem().toString(), jumlah.getText()});
    }//GEN-LAST:event_list_tambahActionPerformed

    private void list_hapusActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_list_hapusActionPerformed
        if (tbldetail.getSelectedRow() > -1){
            int row = tbldetail.convertRowIndexToView(tbldetail.getSelectedRow());
            DefaultTableModel tbl =(DefaultTableModel) tbldetail.getModel();
            
            try {
                Class.forName ("com.mysql.jdbc.Driver");
                String urldb="jdbc:mysql://localhost:3306/restaurant";
                String user=main.dbUser;
                String password=main.dbPassword;
                Connection koneksi=java.sql.DriverManager.getConnection(urldb,user,password);
                String strSQL = "delete from `detail_pesanan` "
                              + "where `no_pesanan` = '"+nopesanan.getText()+"' and  `nama` = '"+tbl.getValueAt(row, 0).toString()+"'";

                Statement st = koneksi.createStatement();
                st.executeUpdate(strSQL);

                st.close();
                koneksi.close();
            }catch(ClassNotFoundException cnfe){
                System.out.println("kesalahan saat"+"me-load driver jdbc \n"+cnfe.getMessage());
            }catch(SQLException sqle){
                System.out.println("keslahan saat koneksi atau "+"kesalahan query sql \n"+sqle.getMessage());
            }
            tbl.removeRow(row);
        }
    }//GEN-LAST:event_list_hapusActionPerformed

    private int cariNoPesananTerakhir(){
        int result = 0;
        try {
            Class.forName ("com.mysql.jdbc.Driver");
            String urldb="jdbc:mysql://localhost:3306/restaurant";
            String user=main.dbUser;
            String password=main.dbPassword;
            Connection koneksi=java.sql.DriverManager.getConnection(urldb,user,password);
            String strSQL = "SELECT MAX(no_pesanan) AS max "
                            + "FROM `pesanan` WHERE `lunas` = 0";

            Statement st = koneksi.createStatement();
            ResultSet rs = st.executeQuery(strSQL);
            
            while (rs.next()){
                result = rs.getInt("max");
            }
            
            rs.close();
            st.close();
            koneksi.close();
        }catch(ClassNotFoundException cnfe){
            System.out.println("kesalahan saat"+"me-load driver jdbc \n"+cnfe.getMessage());
        }catch(SQLException sqle){
            System.out.println("keslahan saat koneksi atau "+"kesalahan query sql \n"+sqle.getMessage());
        }
        return result;
    }
    
    private void tambahActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tambahActionPerformed
         try {
            Class.forName ("com.mysql.jdbc.Driver");
            String urldb="jdbc:mysql://localhost:3306/restaurant";
            String user=main.dbUser;
            String password=main.dbPassword;
            DefaultTableModel tbl =(DefaultTableModel) tbldetail.getModel();
            
            Connection koneksi=java.sql.DriverManager.getConnection(urldb,user,password);
            String strSQL = "insert into `pesanan`(`no_meja`, `username`, `tgl_pesanan`, `lunas`) "
                          + "values('"+(meja.getSelectedIndex()+1)+"','"+main.username+"',CURRENT_TIMESTAMP, 0)";

            Statement st = koneksi.createStatement();
            st.executeUpdate(strSQL);
            
            int no_pesanan = cariNoPesananTerakhir();
            String nama_makanan;
            int jumlah = 0;
            String sql;
            
            for (int i = 0; i < tbldetail.getRowCount(); i++){
                nama_makanan = tbl.getValueAt(i, 0).toString();
                jumlah = Integer.parseInt(tbl.getValueAt(i, 1).toString());
                sql = "insert into detail_pesanan(`no_pesanan`,`nama`,`jumlah`) values('"+no_pesanan+"','"+nama_makanan+"','"+jumlah+"')";
                st.executeUpdate(sql);
            }
            st.close();
            koneksi.close();
        }catch(ClassNotFoundException cnfe){
            System.out.println("kesalahan saat"+"me-load driver jdbc \n"+cnfe.getMessage());
        }catch(SQLException sqle){
            System.out.println("keslahan saat koneksi atau "+"kesalahan query sql \n"+sqle.getMessage());
        }
    }//GEN-LAST:event_tambahActionPerformed

    private void keluarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_keluarActionPerformed
        this.dispose();
    }//GEN-LAST:event_keluarActionPerformed

    private void ubahActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ubahActionPerformed
        try {
            Class.forName ("com.mysql.jdbc.Driver");
            String urldb="jdbc:mysql://localhost:3306/restaurant";
            String user=main.dbUser;
            String password=main.dbPassword;
            DefaultTableModel tbl =(DefaultTableModel) tbldetail.getModel();
            
            Connection koneksi=java.sql.DriverManager.getConnection(urldb,user,password);
            String strSQL = "update `pesanan` set no_meja = '"+(meja.getSelectedIndex()+1)+"', username = '"+main.username+"' where no_pesanan = '"+nopesanan.getText()+"'";

            Statement st = koneksi.createStatement();
            st.executeUpdate(strSQL);
            strSQL = "delete from detail_pesanan where no_pesanan = '"+nopesanan.getText()+"'";
            st.executeUpdate(strSQL);
            
            int no_pesanan = cariNoPesananTerakhir();
            String nama_makanan;
            int jumlah = 0;
            String sql;
            
            for (int i = 0; i < tbldetail.getRowCount(); i++){
                nama_makanan = tbl.getValueAt(i, 0).toString();
                jumlah = Integer.parseInt(tbl.getValueAt(i, 1).toString());
                sql = "insert into detail_pesanan(`no_pesanan`,`nama`,`jumlah`) values('"+no_pesanan+"','"+nama_makanan+"','"+jumlah+"')";
                st.executeUpdate(sql);
            }
            st.close();
            koneksi.close();
        }catch(ClassNotFoundException cnfe){
            System.out.println("kesalahan saat"+"me-load driver jdbc \n"+cnfe.getMessage());
        }catch(SQLException sqle){
            System.out.println("keslahan saat koneksi atau "+"kesalahan query sql \n"+sqle.getMessage());
        }
    }//GEN-LAST:event_ubahActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton cari;
    private javax.swing.JButton hapus;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JFormattedTextField jumlah;
    private javax.swing.JButton keluar;
    private javax.swing.JButton list_hapus;
    private javax.swing.JButton list_tambah;
    private javax.swing.JComboBox makanan;
    private javax.swing.JComboBox meja;
    private javax.swing.JTextField nopesanan;
    private javax.swing.JLabel operator;
    private javax.swing.JButton tambah;
    private javax.swing.JTable tbldetail;
    private javax.swing.JTextField tglpesan;
    private javax.swing.JButton ubah;
    // End of variables declaration//GEN-END:variables
}
