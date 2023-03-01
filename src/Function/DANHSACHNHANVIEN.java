package Function;

import DATABASE.ConnectDB;
import GUI.LOGIN;
import javax.swing.table.DefaultTableModel;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.Statement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.util.Vector;
import javax.swing.JOptionPane;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.text.html.HTML;
public class DANHSACHNHANVIEN extends javax.swing.JFrame {
DefaultTableModel tbn = new DefaultTableModel();
  
    public DANHSACHNHANVIEN() {
        initComponents();
        loadDSNV();
    }
    @SuppressWarnings("unchecked")
     public void loadDSNV()
    { 
        try {
           ConnectDB a = new ConnectDB();
           Connection conn =  (Connection) a.ConnectDB();
           PreparedStatement pst1 = conn.prepareStatement("select count(TENDANGNHAP) AS '' from LOGIN;");
           ResultSet rs1 = pst1.executeQuery();
           while(rs1.next())
           {
               SONV.setText(rs1.getString(1));
           }
           int number;
            Vector row,column;
            column = new Vector();
            Statement st;
            st = conn.createStatement();
            ResultSet rs = st.executeQuery("Select * from LOGIN");
            ResultSetMetaData metaData = rs.getMetaData();
            number = metaData.getColumnCount();
            for (int i = 1 ; i<=number ; i++)
            {
                column.add(metaData.getColumnName(i));
            }
            tbn.setColumnIdentifiers(column);
                
            while(rs.next())
            {
                row = new Vector();
                for (int i =1; i<=number;i++)
                {   row.addElement(rs.getString(i));
                }
                tbn.addRow(row);
                NHANVIENTable.setModel(tbn);
            }
            NHANVIENTable.getSelectionModel().addListSelectionListener(new ListSelectionListener() {
               @Override
               public void valueChanged(ListSelectionEvent e) {
                     if(NHANVIENTable.getSelectedRow()>=0)
        {
            txtTENDANGNHAP.setText(NHANVIENTable.getValueAt(NHANVIENTable.getSelectedRow(),0 )+"");
            txtMATKHAU.setText(NHANVIENTable.getValueAt(NHANVIENTable.getSelectedRow(),1 )+"");
        }
                   
               }
           });
                
            conn.close();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(rootPane, "Lỗi Kết Nối Database!");
        }
    }
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        NHANVIENTable = new javax.swing.JTable();
        jButtonSearch = new javax.swing.JButton();
        jTextSearch = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        txtTENDANGNHAP = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        ADD = new javax.swing.JButton();
        CHANGE = new javax.swing.JButton();
        DELETE = new javax.swing.JButton();
        txtMATKHAU = new javax.swing.JPasswordField();
        F5 = new javax.swing.JButton();
        SONV = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        OUT = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("NHÂN VIÊN");

        NHANVIENTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null}
            },
            new String [] {
                "ID", "Tên đăng nhập", "Mật Khẩu"
            }
        ));
        jScrollPane1.setViewportView(NHANVIENTable);

        jButtonSearch.setBackground(new java.awt.Color(0, 102, 204));
        jButtonSearch.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jButtonSearch.setForeground(new java.awt.Color(255, 255, 255));
        jButtonSearch.setText("Tìm Kiếm");
        jButtonSearch.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonSearchActionPerformed(evt);
            }
        });

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel4.setText("Tên đăng nhập");

        txtTENDANGNHAP.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel2.setText("Mật khẩu");

        ADD.setBackground(new java.awt.Color(0, 102, 204));
        ADD.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        ADD.setForeground(new java.awt.Color(255, 255, 255));
        ADD.setText("Thêm");
        ADD.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ADDActionPerformed(evt);
            }
        });

        CHANGE.setBackground(new java.awt.Color(0, 102, 204));
        CHANGE.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        CHANGE.setForeground(new java.awt.Color(255, 255, 255));
        CHANGE.setText("Sửa");
        CHANGE.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CHANGEActionPerformed(evt);
            }
        });

        DELETE.setBackground(new java.awt.Color(0, 102, 204));
        DELETE.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        DELETE.setForeground(new java.awt.Color(255, 255, 255));
        DELETE.setText("Xóa");
        DELETE.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                DELETEActionPerformed(evt);
            }
        });

        F5.setBackground(new java.awt.Color(0, 102, 204));
        F5.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        F5.setForeground(new java.awt.Color(255, 255, 255));
        F5.setText("Làm Mới");
        F5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                F5ActionPerformed(evt);
            }
        });

        SONV.setEditable(false);
        SONV.setBackground(new java.awt.Color(204, 204, 204));
        SONV.setHorizontalAlignment(javax.swing.JTextField.CENTER);

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel1.setText("Phòng Máy Có");

        jLabel3.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel3.setText("Nhân Viên");

        jMenu1.setText("File");

        OUT.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_Q, java.awt.event.InputEvent.ALT_DOWN_MASK));
        OUT.setText("Thoát");
        OUT.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                OUTActionPerformed(evt);
            }
        });
        jMenu1.add(OUT);

        jMenuBar1.add(jMenu1);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1)
            .addGroup(layout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(15, 15, 15)
                                .addComponent(ADD, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(33, 33, 33)
                                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 82, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(37, 37, 37)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txtTENDANGNHAP)
                                    .addComponent(txtMATKHAU))
                                .addGap(143, 143, 143))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addGap(60, 60, 60)
                                .addComponent(DELETE, javax.swing.GroupLayout.PREFERRED_SIZE, 121, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(41, 41, 41)
                                .addComponent(CHANGE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGap(21, 21, 21))))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jButtonSearch)
                        .addGap(49, 49, 49)
                        .addComponent(jTextSearch, javax.swing.GroupLayout.PREFERRED_SIZE, 132, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(72, 72, 72)
                        .addComponent(F5)
                        .addGap(33, 33, 33))))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(276, 276, 276)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(SONV, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(2, 2, 2)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtTENDANGNHAP, javax.swing.GroupLayout.DEFAULT_SIZE, 35, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtMATKHAU))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(4, 4, 4)
                        .addComponent(ADD, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(CHANGE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(DELETE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addGap(37, 37, 37)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButtonSearch)
                    .addComponent(jTextSearch, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(F5, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(45, 45, 45)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 139, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 24, Short.MAX_VALUE)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(SONV, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addGap(10, 10, 10))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void OUTActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_OUTActionPerformed
         new Manager().setVisible(true);
                        this.dispose();
    }//GEN-LAST:event_OUTActionPerformed

    private void jButtonSearchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonSearchActionPerformed
        String TENDANGNHAP = jTextSearch.getText();
        if(TENDANGNHAP.equals("") )
        {
            JOptionPane.showMessageDialog(rootPane, "Trống!");
            tbn.setRowCount(0);
            loadDSNV();
        }
        else 
        {
            try {
            ConnectDB a = new ConnectDB();
            Connection conn = a.ConnectDB();
            PreparedStatement pst = conn.prepareStatement("Select * from LOGIN where TENDANGNHAP= ?");
            pst.setString(1, TENDANGNHAP);
            tbn.setRowCount(0);
            int number;
            Vector row,column;
            column = new Vector();
            Statement st;
            st = conn.createStatement();
            ResultSet rs = pst.executeQuery();
            ResultSetMetaData metaData = rs.getMetaData();
            number = metaData.getColumnCount();
            for (int i = 1 ; i<=number ; i++)
            {
                column.add(metaData.getColumnName(i));
            }
            tbn.setColumnIdentifiers(column);
                
            while(rs.next())
            {
                row = new Vector();
                for (int i =1; i<=number;i++)
                {   row.addElement(rs.getString(i));
                }
                tbn.addRow(row);
                NHANVIENTable.setModel(tbn);
            }
            NHANVIENTable.getSelectionModel().addListSelectionListener(new ListSelectionListener() {
               @Override
               public void valueChanged(ListSelectionEvent e) {
                     if(NHANVIENTable.getSelectedRow()>=0)
        {
            txtTENDANGNHAP.setText(NHANVIENTable.getValueAt(NHANVIENTable.getSelectedRow(),0 )+"");
            txtMATKHAU.setText(NHANVIENTable.getValueAt(NHANVIENTable.getSelectedRow(),1 )+"");
        }
                   
               }
               
           });
            conn.close();
        }
            catch (Exception e)
            {
            JOptionPane.showMessageDialog(this, "Lỗi kết nối database!");}
            }        
    }//GEN-LAST:event_jButtonSearchActionPerformed

    private void ADDActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ADDActionPerformed
        String TENDANGNHAP = txtTENDANGNHAP.getText();
        String MATKHAU = txtMATKHAU.getText();
       if (TENDANGNHAP.equals("") || MATKHAU.equals("")) 
        {
            JOptionPane.showConfirmDialog(rootPane, "Tên Đăng Nhập hoặc Mật Khẩu không được để trống!!", "Lỗi", -1);
        }
        try {
            ConnectDB a = new ConnectDB();
            Connection conn = a.ConnectDB();
            PreparedStatement pst = conn.prepareStatement("insert into LOGIN(TENDANGNHAP,MATKHAU) value (?,?)");
            pst.setString(1, txtTENDANGNHAP.getText());
            pst.setString(2, txtMATKHAU.getText());
            int chk = pst.executeUpdate();
            if (chk >0)
            {
                JOptionPane.showMessageDialog(this, "Thêm Thành Công");
                tbn.setRowCount(0);
                loadDSNV(); 
            }
            else 
            {
                JOptionPane.showMessageDialog(this, "Thêm Thất bại!");

            }
            conn.close();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Lỗi!");
        }
    }//GEN-LAST:event_ADDActionPerformed

    private void CHANGEActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CHANGEActionPerformed
        String TENDANGNHAP =  txtTENDANGNHAP.getText();
        String MATKHAU = txtMATKHAU.getText();
        if (TENDANGNHAP.equals(""))
                {
                    JOptionPane.showMessageDialog(this, "Trống!");
                }
        else
        {
            try
            {
                ConnectDB a = new ConnectDB();
                Connection conn = a.ConnectDB();
                PreparedStatement pst1 = conn.prepareStatement("update LOGIN set MATKHAU = ? where TENDANGNHAP = ?");
                pst1.setString(2,txtTENDANGNHAP.getText());
                pst1.setString(1, txtMATKHAU.getText());
                int chk = pst1.executeUpdate();
                if(chk >0 )
                {
                    JOptionPane.showMessageDialog(rootPane, "Sửa thành công!");
                    tbn.setRowCount(0);
                    loadDSNV();
                    
                }
                else 
                {
                    JOptionPane.showMessageDialog(rootPane, "Sửa Thất Bại!");
                }
                conn.close();
            }
        catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Lỗi!");
        }
        }
    }//GEN-LAST:event_CHANGEActionPerformed

    private void DELETEActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_DELETEActionPerformed
      try {
            ConnectDB a = new ConnectDB();
            Connection conn = a.ConnectDB();
            PreparedStatement pst2 = conn.prepareStatement("Delete from LOGIN where TENDANGNHAP=?");
            pst2.setString(1,NHANVIENTable.getValueAt(NHANVIENTable.getSelectedRow(), 0).toString());
            if(JOptionPane.showConfirmDialog(this, "Xóa Nhân Viên?.Lưu ý:Sau khi xóa thành công bạn sẽ bị đăng xuất.","Xác nhận", JOptionPane.YES_NO_OPTION)==JOptionPane.YES_OPTION)
            {
                int chk = pst2.executeUpdate();
                if(chk > 0)
                {
                tbn.setRowCount(0);
                loadDSNV(); 
                new LOGIN().setVisible(true);
                this.dispose();
                }
                else 
                {
                    JOptionPane.showMessageDialog(rootPane, "Xóa Thất Bại!");
                    tbn.setRowCount(0);
                    loadDSNV();
                }
            }
            conn.close();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Lỗi");
        }
    }//GEN-LAST:event_DELETEActionPerformed

    private void F5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_F5ActionPerformed
        tbn.setRowCount(0);
        loadDSNV();
    }//GEN-LAST:event_F5ActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton ADD;
    private javax.swing.JButton CHANGE;
    private javax.swing.JButton DELETE;
    private javax.swing.JButton F5;
    private javax.swing.JTable NHANVIENTable;
    private javax.swing.JMenuItem OUT;
    private javax.swing.JTextField SONV;
    private javax.swing.JButton jButtonSearch;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField jTextSearch;
    private javax.swing.JPasswordField txtMATKHAU;
    private javax.swing.JTextField txtTENDANGNHAP;
    // End of variables declaration//GEN-END:variables
}
