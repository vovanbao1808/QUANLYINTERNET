package Function;

import DATABASE.ConnectDB;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.Statement;
import java.util.Vector;
import javax.swing.JOptionPane;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;

public class DICHVU extends javax.swing.JFrame {
    DefaultTableModel tbn = new DefaultTableModel();
    public DICHVU() {
        initComponents();
        loadDICHVU();       
    }
    public void loadDICHVU()
    {
        try {
           ConnectDB a = new ConnectDB();
           Connection conn =  (Connection) a.ConnectDB();
           PreparedStatement pst1 = conn.prepareStatement("select Count(TENDICHVU) AS '' from DICHVU;");
           ResultSet rs1 = pst1.executeQuery();
           while(rs1.next())
           {
               SODV.setText(rs1.getString(1));
           }
           int number;
            Vector row,column;
            column = new Vector();
            Statement st;
            st = conn.createStatement();
            ResultSet rs = st.executeQuery("Select * from DICHVU");
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
                DICHVUTable.setModel(tbn);
            }
            DICHVUTable.getSelectionModel().addListSelectionListener(new ListSelectionListener() {
               @Override
               public void valueChanged(ListSelectionEvent e) {
                     if(DICHVUTable.getSelectedRow()>=0)
        {
            txtTENDICHVU.setText(DICHVUTable.getValueAt(DICHVUTable.getSelectedRow(),0 )+"");
            txtGIA.setText(DICHVUTable.getValueAt(DICHVUTable.getSelectedRow(),1 )+"");
        }
               }
           });
            conn.close();
        } catch (Exception e) {
        }
    }
    
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane2 = new javax.swing.JScrollPane();
        DICHVUTable = new javax.swing.JTable();
        jButtonSearch = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        txtTENDICHVU = new javax.swing.JTextField();
        txtGIA = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        ADD = new javax.swing.JButton();
        CHANGE = new javax.swing.JButton();
        DELETE = new javax.swing.JButton();
        jTextSearch = new javax.swing.JTextField();
        F5 = new javax.swing.JButton();
        SODV = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        OUT = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("DỊCH VỤ");

        DICHVUTable.setBorder(javax.swing.BorderFactory.createTitledBorder(""));
        DICHVUTable.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        DICHVUTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null},
                {null, null},
                {null, null},
                {null, null}
            },
            new String [] {
                "Tên Dịch Vụ", "Giá"
            }
        ));
        DICHVUTable.setAutoResizeMode(javax.swing.JTable.AUTO_RESIZE_ALL_COLUMNS);
        DICHVUTable.setColumnSelectionAllowed(true);
        jScrollPane2.setViewportView(DICHVUTable);
        DICHVUTable.getColumnModel().getSelectionModel().setSelectionMode(javax.swing.ListSelectionModel.SINGLE_INTERVAL_SELECTION);

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
        jLabel4.setText("Tên Dịch Vụ");

        txtTENDICHVU.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N

        txtGIA.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel2.setText("Giá");

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

        jTextSearch.setHorizontalAlignment(javax.swing.JTextField.CENTER);

        F5.setBackground(new java.awt.Color(0, 102, 204));
        F5.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        F5.setForeground(new java.awt.Color(255, 255, 255));
        F5.setText("Làm Mới");
        F5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                F5ActionPerformed(evt);
            }
        });

        SODV.setEditable(false);
        SODV.setBackground(new java.awt.Color(204, 204, 204));
        SODV.setHorizontalAlignment(javax.swing.JTextField.CENTER);

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel1.setText("Tổng cộng có ");

        jLabel3.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel3.setText("Dịch vụ");

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
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(68, 68, 68)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 82, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(txtTENDICHVU, javax.swing.GroupLayout.PREFERRED_SIZE, 153, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 82, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(txtGIA, javax.swing.GroupLayout.PREFERRED_SIZE, 153, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(ADD, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(CHANGE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(DELETE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(45, 45, 45)
                        .addComponent(jButtonSearch)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jTextSearch, javax.swing.GroupLayout.PREFERRED_SIZE, 132, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(137, 137, 137)
                        .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(SODV, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(37, 37, 37)))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 287, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(110, 110, 110)
                        .addComponent(F5)))
                .addContainerGap())
        );

        layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {F5, jButtonSearch});

        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE, false)
                    .addComponent(jTextSearch, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(F5, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButtonSearch, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(32, 32, 32)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtTENDICHVU, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtGIA, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(26, 26, 26)
                        .addComponent(ADD, javax.swing.GroupLayout.DEFAULT_SIZE, 41, Short.MAX_VALUE)
                        .addGap(18, 18, 18)
                        .addComponent(CHANGE, javax.swing.GroupLayout.DEFAULT_SIZE, 41, Short.MAX_VALUE)
                        .addGap(18, 18, 18)
                        .addComponent(DELETE, javax.swing.GroupLayout.DEFAULT_SIZE, 40, Short.MAX_VALUE)
                        .addGap(31, 31, 31)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, 22, Short.MAX_VALUE)
                                .addComponent(SODV, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(24, 24, 24))
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)))
        );

        layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {F5, jButtonSearch});

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void OUTActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_OUTActionPerformed
         new Manager().setVisible(true);
         this.dispose();
    }//GEN-LAST:event_OUTActionPerformed

    private void jButtonSearchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonSearchActionPerformed
        String TENDICHVU = jTextSearch.getText();
        if(TENDICHVU.equals("") )
        {
            JOptionPane.showMessageDialog(this, "Trống");
            tbn.setRowCount(0);
            loadDICHVU();
        }
        else 
        {
        try {
            ConnectDB a = new ConnectDB();
            Connection conn = a.ConnectDB();
            PreparedStatement pst = conn.prepareStatement("Select * from DICHVU Where TENDICHVU=?");
            pst.setString(1, TENDICHVU);
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
                DICHVUTable.setModel(tbn);
            }
            DICHVUTable.getSelectionModel().addListSelectionListener(new ListSelectionListener() {
             
               @Override
               public void valueChanged(ListSelectionEvent e) {
                     if(DICHVUTable.getSelectedRow()>=0)
        {
            txtTENDICHVU.setText(DICHVUTable.getValueAt(DICHVUTable.getSelectedRow(),0 )+"");
            txtGIA.setText(DICHVUTable.getValueAt(DICHVUTable.getSelectedRow(),1 )+"");
        }
                   
        }
            });
            conn.close();
        } 
        catch (Exception e) 
        {
            JOptionPane.showMessageDialog(this, "Lỗi kết nối database!");
        }
        }
    }//GEN-LAST:event_jButtonSearchActionPerformed

    private void CHANGEActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CHANGEActionPerformed
        String TENDICHVU = txtTENDICHVU.getText();
        String GIA = txtGIA.getText();
        if(TENDICHVU.equals("") )
        {
            JOptionPane.showMessageDialog(this, "Trống!");
            tbn.setRowCount(0);
            loadDICHVU();
        }
        else 
        {
            try
            {
                ConnectDB a = new ConnectDB();
                Connection conn = a.ConnectDB();
                PreparedStatement pst1 = conn.prepareStatement("update DICHVU set GIA = ? where TENDICHVU = ?");
                pst1.setString(2,TENDICHVU);
                pst1.setString(1, GIA);
                int chk = pst1.executeUpdate();
                if(chk > 0)
                {
                   JOptionPane.showMessageDialog(this, "Sửa Thành Công!");
                   tbn.setRowCount(0);
                   loadDICHVU();
                }
                else 
                {
                    JOptionPane.showMessageDialog(rootPane, "Sửa Thất Bại!");
                    tbn.setRowCount(0);
                    loadDICHVU();
                }
                conn.close();
            }
        catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Lỗi!");
        }
        }
    }//GEN-LAST:event_CHANGEActionPerformed

    private void ADDActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ADDActionPerformed
        String TENDICHVU = txtTENDICHVU.getText();
        String GIA = txtGIA.getText();
        if (TENDICHVU.equals("") || GIA.equals(""))
        {
            JOptionPane.showConfirmDialog(rootPane, "Tên Dịch Vụ hoặc Giá không được trống!", "Lỗi", -1);
            tbn.setRowCount(0);
            loadDICHVU();
        }
        else
        {
            try {
                ConnectDB a = new ConnectDB();
                Connection conn = a.ConnectDB();
                PreparedStatement pst = conn.prepareStatement("insert into DICHVU(TENDICHVU,GIA) value (?,?)");
                pst.setString(1, txtTENDICHVU.getText());
                pst.setString(2, txtGIA.getText());
                int chk = pst.executeUpdate();
                if (chk >0)
                {
                    JOptionPane.showMessageDialog(this, "Thêm Thành Công");
                    tbn.setRowCount(0);
                    loadDICHVU(); 
                }
                else 
                {
                    JOptionPane.showMessageDialog(rootPane, "Thêm Thất Bại!");
                }
                conn.close();
        } 
        catch (Exception e) 
        {
            JOptionPane.showMessageDialog(rootPane, "Lỗi");
        }
        }
    }//GEN-LAST:event_ADDActionPerformed

    private void DELETEActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_DELETEActionPerformed
     try {
            ConnectDB a = new ConnectDB();
            Connection conn = a.ConnectDB();
            PreparedStatement pst2 = conn.prepareStatement("Delete from DICHVU where TENDICHVU=?");
            pst2.setString(1,DICHVUTable.getValueAt(DICHVUTable.getSelectedRow(), 0).toString());
            if(JOptionPane.showConfirmDialog(this, "Xóa Dịch vụ?","Xác nhận", JOptionPane.YES_NO_OPTION)==JOptionPane.YES_OPTION)
            {
                int chk = pst2.executeUpdate();
                if(chk >0 )
                {
                    JOptionPane.showMessageDialog(rootPane, "Xóa thành công");
                    txtTENDICHVU.setText("");
                    txtGIA.setText("");
                    tbn.setRowCount(0);
                    loadDICHVU();
                }
                else 
                {
                    JOptionPane.showMessageDialog(rootPane, "Xóa Thất Bại!");
                }
            } 
            conn.close();
            
        } catch (Exception e) {
            JOptionPane.showMessageDialog(rootPane, "Lỗi!");
        }
    }//GEN-LAST:event_DELETEActionPerformed

    private void F5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_F5ActionPerformed
       tbn.setRowCount(0);
                loadDICHVU();
    }//GEN-LAST:event_F5ActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton ADD;
    private javax.swing.JButton CHANGE;
    private javax.swing.JButton DELETE;
    private javax.swing.JTable DICHVUTable;
    private javax.swing.JButton F5;
    private javax.swing.JMenuItem OUT;
    private javax.swing.JTextField SODV;
    private javax.swing.JButton jButtonSearch;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTextField jTextSearch;
    private javax.swing.JTextField txtGIA;
    private javax.swing.JTextField txtTENDICHVU;
    // End of variables declaration//GEN-END:variables
}
