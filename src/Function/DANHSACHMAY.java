package Function;

import DATABASE.ConnectDB;
import java.sql.PreparedStatement;
import java.util.Vector;
import javax.swing.table.DefaultTableModel;
import java.sql.Statement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.Connection;
import javax.swing.JOptionPane;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;


public class DANHSACHMAY extends javax.swing.JFrame {
    DefaultTableModel tbn = new DefaultTableModel();

    public DANHSACHMAY() {
        initComponents();
        loadDSMAY();      
    }
    public void loadDSMAY()
    {
        try {
           ConnectDB a = new ConnectDB();
           Connection conn =  (Connection) a.ConnectDB();
           PreparedStatement pst1 = conn.prepareStatement("select COUNT(MAMAY) AS '' from MAY;");
           ResultSet rs1 = pst1.executeQuery();
           while(rs1.next())
           {
               SOMAY.setText(rs1.getString(1));
           }
           int number;
            Vector row,column;
            column = new Vector();
            Statement st;
            st = conn.createStatement();
            ResultSet rs = st.executeQuery("Select * from MAY");
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
                MAYTable.setModel(tbn);
            }
            MAYTable.getSelectionModel().addListSelectionListener(new ListSelectionListener() {
               @Override
               public void valueChanged(ListSelectionEvent e) {
                     if(MAYTable.getSelectedRow()>=0)
        {
            txtMAMAY.setText(MAYTable.getValueAt(MAYTable.getSelectedRow(),0 )+"");
            txtTENMAY.setText(MAYTable.getValueAt(MAYTable.getSelectedRow(),1 )+"");
        }
                   
               }
           });  
            conn.close();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Lỗi kết nối database!");
        }
    }
   
   
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        MAYTable = new javax.swing.JTable();
        jButtonSearch = new javax.swing.JButton();
        jTextSearch = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        txtMAMAY = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        ADD = new javax.swing.JButton();
        CHANGE = new javax.swing.JButton();
        txtTENMAY = new javax.swing.JTextField();
        DELETE = new javax.swing.JButton();
        F5 = new javax.swing.JButton();
        SOMAY = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        OUT = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("DANH SÁCH MÁY");

        MAYTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null}
            },
            new String [] {
                "STT", "Mã Máy", "Tên Máy"
            }
        ));
        jScrollPane1.setViewportView(MAYTable);

        jButtonSearch.setBackground(new java.awt.Color(0, 102, 204));
        jButtonSearch.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jButtonSearch.setForeground(new java.awt.Color(255, 255, 255));
        jButtonSearch.setText("Tìm Kiếm theo Mã Máy");
        jButtonSearch.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonSearchActionPerformed(evt);
            }
        });

        jTextSearch.setHorizontalAlignment(javax.swing.JTextField.CENTER);

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel4.setText("   Mã Máy:");

        txtMAMAY.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        txtMAMAY.setHorizontalAlignment(javax.swing.JTextField.CENTER);

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel2.setText("  Tên Máy:");

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
        CHANGE.setPreferredSize(new java.awt.Dimension(70, 20));
        CHANGE.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CHANGEActionPerformed(evt);
            }
        });

        txtTENMAY.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        txtTENMAY.setHorizontalAlignment(javax.swing.JTextField.CENTER);

        DELETE.setBackground(new java.awt.Color(0, 102, 204));
        DELETE.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        DELETE.setForeground(new java.awt.Color(255, 255, 255));
        DELETE.setText("Xóa");
        DELETE.setPreferredSize(new java.awt.Dimension(70, 23));
        DELETE.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                DELETEActionPerformed(evt);
            }
        });

        F5.setBackground(new java.awt.Color(0, 102, 204));
        F5.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        F5.setForeground(new java.awt.Color(255, 255, 255));
        F5.setText("Làm mới");
        F5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                F5ActionPerformed(evt);
            }
        });

        SOMAY.setEditable(false);
        SOMAY.setBackground(new java.awt.Color(204, 204, 204));
        SOMAY.setHorizontalAlignment(javax.swing.JTextField.CENTER);

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Máy");

        jLabel3.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel3.setText("Phòng máy có");

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
                        .addGap(57, 57, 57)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 82, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(6, 6, 6)
                                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 82, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addComponent(ADD, javax.swing.GroupLayout.PREFERRED_SIZE, 111, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(28, 28, 28))
                            .addComponent(jButtonSearch, javax.swing.GroupLayout.Alignment.TRAILING))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(DELETE, javax.swing.GroupLayout.PREFERRED_SIZE, 103, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(40, 40, 40))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtTENMAY, javax.swing.GroupLayout.PREFERRED_SIZE, 159, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtMAMAY, javax.swing.GroupLayout.PREFERRED_SIZE, 159, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(CHANGE, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jTextSearch, javax.swing.GroupLayout.PREFERRED_SIZE, 132, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(66, 66, 66)
                                .addComponent(F5)))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 575, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(SOMAY, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(41, 41, 41))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(2, 2, 2)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtMAMAY, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtTENMAY, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(CHANGE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(ADD, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(DELETE, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(31, 31, 31)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButtonSearch)
                    .addComponent(jTextSearch, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(F5, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 201, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel3, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(SOMAY, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE))))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void OUTActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_OUTActionPerformed
        new Manager().setVisible(true);
        this.dispose();
    }//GEN-LAST:event_OUTActionPerformed

    private void jButtonSearchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonSearchActionPerformed
        String MAMAY = jTextSearch.getText();
        if(MAMAY.equals("") )
        {
            JOptionPane.showMessageDialog(this, "Trống!");
            tbn.setRowCount(0);
            loadDSMAY();
        }
        else 
        {
        try {
            ConnectDB a = new ConnectDB();
            Connection conn = a.ConnectDB();
            PreparedStatement pst = conn.prepareStatement("Select * from MAY where MAMAY= ?");
            pst.setString(1, jTextSearch.getText());
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
                {   
                    row.addElement(rs.getString(i));
                }
                tbn.addRow(row);
                MAYTable.setModel(tbn);
            }
            MAYTable.getSelectionModel().addListSelectionListener(new ListSelectionListener() {
               @Override
               public void valueChanged(ListSelectionEvent e) {
                    if(MAYTable.getSelectedRow()>=0)
                {
            txtMAMAY.setText(MAYTable.getValueAt(MAYTable.getSelectedRow(),0 )+"");
            txtTENMAY.setText(MAYTable.getValueAt(MAYTable.getSelectedRow(),1 )+"");
                }
                   
               }
               
           });       
            conn.close();
        } 
        catch (Exception e) 
        {
             JOptionPane.showMessageDialog(this, "Lỗi kết nối databse!");
        } 
    }//GEN-LAST:event_jButtonSearchActionPerformed
    }
    private void ADDActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ADDActionPerformed
    String MAMAY = txtMAMAY.getText();
    String TENMAY = txtTENMAY.getText();  
    if (MAMAY.equals("") || TENMAY.equals("")) 
    {
        JOptionPane.showConfirmDialog(rootPane, "Mã Máy hoặc Tên Máy không được trống!", "Lỗi", -1);
        tbn.setRowCount(0);
        loadDSMAY();
    }
    else 
    {
        try {
            ConnectDB a = new ConnectDB();
            Connection conn = a.ConnectDB();
            PreparedStatement pst = conn.prepareStatement("insert into MAY(MAMAY,TENMAY) value (?,?)");
            pst.setString(1, MAMAY);
            pst.setString(2, TENMAY);
            int chk = pst.executeUpdate();
            if (chk >0)
            {
                JOptionPane.showMessageDialog(this, "Thêm Thành Công");
                tbn.setRowCount(0);
                loadDSMAY();    
            }
            else 
            {
                JOptionPane.showMessageDialog(this, "Thêm Thất Bại!");
            }
            conn.close();
            }
        catch (Exception e)
       {
            JOptionPane.showMessageDialog(this, "Lỗi!");
       }
    }
    }//GEN-LAST:event_ADDActionPerformed

    private void CHANGEActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CHANGEActionPerformed
        String MAMAY = txtMAMAY.getText();
        if (MAMAY.equals("") ) 
        {
            JOptionPane.showMessageDialog(this , "Trống");
            tbn.setRowCount(0);
            loadDSMAY();
        }
        else 
        {
        try
        {
            ConnectDB a = new ConnectDB();
            Connection conn = a.ConnectDB();
            PreparedStatement pst1 = conn.prepareStatement("update MAY set TENMAY = ? where MAMAY = ?");
            pst1.setString(2,txtMAMAY.getText());
            pst1.setString(1, txtTENMAY.getText());
            int chk = pst1.executeUpdate();
            if (chk > 0) 
            {
                JOptionPane.showMessageDialog(this, "Sửa Thành Công!");
            }
            else 
            {
                JOptionPane.showMessageDialog(rootPane, "Sửa Thất Bại");
            }
            conn.close();
        }
        catch (Exception e)
            {
            JOptionPane.showMessageDialog(this, "Lỗi!");
            }
        }
    }//GEN-LAST:event_CHANGEActionPerformed

    private void DELETEActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_DELETEActionPerformed
        try {
            ConnectDB a = new ConnectDB();
            Connection conn = a.ConnectDB();
            PreparedStatement pst2 = conn.prepareStatement("Delete from MAY where MAMAY=?");
            pst2.setString(1,MAYTable.getValueAt(MAYTable.getSelectedRow(), 0).toString());
            if(JOptionPane.showConfirmDialog(this, "Xóa Máy?","Xác nhận", JOptionPane.YES_NO_OPTION)==JOptionPane.YES_OPTION)
            {
                int chk = pst2.executeUpdate();
                if (chk>0)
                {
                    JOptionPane.showMessageDialog(rootPane, "Xóa Thành Công!");
                    txtMAMAY.setText("");
                    txtTENMAY.setText("");
                    tbn.setRowCount(0);
                    loadDSMAY();
                }
                else 
                {
                    JOptionPane.showMessageDialog(rootPane, "Xóa Thất Bại!");
                    tbn.setRowCount(0);
                    loadDSMAY();
                }
                
            }
            conn.close();
            
        } catch (Exception e) {
            JOptionPane.showMessageDialog(rootPane, "Lỗi");
        }
    }//GEN-LAST:event_DELETEActionPerformed

    private void F5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_F5ActionPerformed
        tbn.setRowCount(0);
        loadDSMAY();
        
    }//GEN-LAST:event_F5ActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton ADD;
    private javax.swing.JButton CHANGE;
    private javax.swing.JButton DELETE;
    private javax.swing.JButton F5;
    private javax.swing.JTable MAYTable;
    private javax.swing.JMenuItem OUT;
    private javax.swing.JTextField SOMAY;
    private javax.swing.JButton jButtonSearch;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField jTextSearch;
    private javax.swing.JTextField txtMAMAY;
    private javax.swing.JTextField txtTENMAY;
    // End of variables declaration//GEN-END:variables
}
