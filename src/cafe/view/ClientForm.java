package cafe.view;

import cafe.Utils.db.DbConnect;
import static cafe.Utils.db.DbConnect.PASSWORD;
import static cafe.Utils.db.DbConnect.URL;
import static cafe.Utils.db.DbConnect.USERNAME;
import static cafe.Utils.db.DbConnect.chooseServer;
import cafe.Utils.db.EmployeeUtils;
import cafe.Utils.db.OrderUtils;
import static cafe.Utils.db.OrderUtils.getSumKeyMoneyForUserBetween;
import static cafe.Utils.db.OrderUtils.getUserKasa;
import cafe.Utils.db.ReviziaUtils;
import cafe.Utils.db.StorageUtils;
import static cafe.Utils.db.StorageUtils.getAddedIngredients;
import static cafe.Utils.db.StorageUtils.getIngTitleById;
import static cafe.Utils.db.StorageUtils.getOrderedDishes;
import static cafe.Utils.db.StorageUtils.getRemovedIngredients;
import cafe.Utils.db.UsersUtils;
import cafe.model.Employee;
import cafe.model.Ingredient;
import cafe.model.Order;
import cafe.model.OrderItem;
import cafe.model.ReviziaItem;
import static cafe.view.LoginForm.userList;
import static cafe.view.MainForm.GREEN;
import static cafe.view.MainForm.employees;
import static cafe.view.MainForm.setColumnRender;
import static cafe.view.MainForm.setSort;
import static cafe.view.MainForm.showCalcTable;
import static cafe.view.MainForm.sortListOfIngredients;
import static cafe.view.MainForm.sortListOfOrderItems;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class ClientForm extends javax.swing.JFrame {

    public ClientForm() {
        initComponents();

        initEnabledComponents();

    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        jComboBox1 = new javax.swing.JComboBox();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jXDatePicker1 = new org.jdesktop.swingx.JXDatePicker();
        jXDatePicker2 = new org.jdesktop.swingx.JXDatePicker();
        jProgressBar1 = new javax.swing.JProgressBar();
        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTable2 = new javax.swing.JTable();
        jComboBox2 = new javax.swing.JComboBox();
        jLabel3 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane6 = new javax.swing.JScrollPane();
        jTable6 = new javax.swing.JTable();
        jComboBox7 = new javax.swing.JComboBox();
        jButton39 = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();
        jScrollPane5 = new javax.swing.JScrollPane();
        jTable5 = new javax.swing.JTable();
        jLabel17 = new javax.swing.JLabel();
        jScrollPane10 = new javax.swing.JScrollPane();
        jTable10 = new javax.swing.JTable();
        jLabel22 = new javax.swing.JLabel();
        jPanel7 = new javax.swing.JPanel();
        jScrollPane11 = new javax.swing.JScrollPane();
        jTable11 = new javax.swing.JTable();
        jLabel6 = new javax.swing.JLabel();
        jComboBox3 = new javax.swing.JComboBox();
        jToggleButton1 = new javax.swing.JToggleButton();
        jPanel4 = new javax.swing.JPanel();
        jScrollPane3 = new javax.swing.JScrollPane();
        jTable3 = new javax.swing.JTable();
        jLabel4 = new javax.swing.JLabel();
        jXDatePicker3 = new org.jdesktop.swingx.JXDatePicker();
        jButton2 = new javax.swing.JButton();
        jPanel5 = new javax.swing.JPanel();
        jLabel12 = new javax.swing.JLabel();
        jScrollPane8 = new javax.swing.JScrollPane();
        jTable8 = new javax.swing.JTable();
        jLabel20 = new javax.swing.JLabel();
        jScrollPane9 = new javax.swing.JScrollPane();
        jTable9 = new javax.swing.JTable();
        jLabel21 = new javax.swing.JLabel();
        jPanel6 = new javax.swing.JPanel();
        jScrollPane7 = new javax.swing.JScrollPane();
        jTable7 = new javax.swing.JTable();
        jComboBox8 = new javax.swing.JComboBox();
        jLabel8 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jLabel19 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        jScrollPane4 = new javax.swing.JScrollPane();
        jTable4 = new javax.swing.JTable();
        jLabel5 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(null);

        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Шепетівка", "Староконстянтинів", "Славута" }));
        jComboBox1.setSelectedIndex(-1);
        jComboBox1.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jComboBox1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                chooseCafe(evt);
            }
        });
        getContentPane().add(jComboBox1);
        jComboBox1.setBounds(0, 0, 220, 30);

        jLabel1.setFont(new java.awt.Font("Verdana", 1, 18)); // NOI18N
        jLabel1.setText("З");
        getContentPane().add(jLabel1);
        jLabel1.setBounds(0, 40, 40, 20);

        jLabel2.setFont(new java.awt.Font("Verdana", 1, 18)); // NOI18N
        jLabel2.setText("По");
        getContentPane().add(jLabel2);
        jLabel2.setBounds(0, 80, 40, 20);

        jButton1.setBackground(new java.awt.Color(0, 153, 204));
        jButton1.setFont(new java.awt.Font("Verdana", 1, 14)); // NOI18N
        jButton1.setText("підключитись до кафе");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                getAllOrders(evt);
            }
        });
        getContentPane().add(jButton1);
        jButton1.setBounds(0, 140, 220, 40);
        getContentPane().add(jXDatePicker1);
        jXDatePicker1.setBounds(50, 40, 170, 22);
        getContentPane().add(jXDatePicker2);
        jXDatePicker2.setBounds(50, 80, 170, 22);

        jProgressBar1.setForeground(new java.awt.Color(51, 153, 0));
        getContentPane().add(jProgressBar1);
        jProgressBar1.setBounds(0, 120, 220, 10);

        jTabbedPane1.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        jTabbedPane1.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N

        jPanel1.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        jPanel1.setLayout(null);

        jTable1.setFont(new java.awt.Font("Verdana", 0, 14)); // NOI18N
        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null}
            },
            new String [] {
                "№", "№ чеку", "Бармен", "Сума (грн)", "Дата Час", "Кіл.", "Видал"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Long.class, java.lang.Integer.class, java.lang.String.class, java.lang.Integer.class, java.lang.String.class, java.lang.Integer.class, java.lang.Integer.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jTable1.setRowHeight(20);
        jTable1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jTable1MousePressed(evt);
            }
        });
        jTable1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jTable1KeyReleased(evt);
            }
        });
        jScrollPane1.setViewportView(jTable1);
        if (jTable1.getColumnModel().getColumnCount() > 0) {
            jTable1.getColumnModel().getColumn(0).setMinWidth(70);
            jTable1.getColumnModel().getColumn(0).setPreferredWidth(70);
            jTable1.getColumnModel().getColumn(0).setMaxWidth(70);
            jTable1.getColumnModel().getColumn(1).setMinWidth(50);
            jTable1.getColumnModel().getColumn(1).setPreferredWidth(50);
            jTable1.getColumnModel().getColumn(1).setMaxWidth(50);
            jTable1.getColumnModel().getColumn(2).setMinWidth(75);
            jTable1.getColumnModel().getColumn(2).setPreferredWidth(75);
            jTable1.getColumnModel().getColumn(2).setMaxWidth(75);
            jTable1.getColumnModel().getColumn(3).setMinWidth(70);
            jTable1.getColumnModel().getColumn(3).setPreferredWidth(70);
            jTable1.getColumnModel().getColumn(3).setMaxWidth(70);
            jTable1.getColumnModel().getColumn(4).setMinWidth(120);
            jTable1.getColumnModel().getColumn(4).setPreferredWidth(120);
            jTable1.getColumnModel().getColumn(4).setMaxWidth(120);
            jTable1.getColumnModel().getColumn(5).setMinWidth(40);
            jTable1.getColumnModel().getColumn(5).setPreferredWidth(40);
            jTable1.getColumnModel().getColumn(5).setMaxWidth(40);
            jTable1.getColumnModel().getColumn(6).setMinWidth(40);
            jTable1.getColumnModel().getColumn(6).setPreferredWidth(40);
            jTable1.getColumnModel().getColumn(6).setMaxWidth(40);
        }

        jPanel1.add(jScrollPane1);
        jScrollPane1.setBounds(1, 1, 470, 530);

        jTable2.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jTable2.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Назва", "Кіл.", "Ціна", "Сума"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.Integer.class, java.lang.Double.class, java.lang.Double.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jTable2.setFocusable(false);
        jTable2.setRowHeight(18);
        jTable2.getTableHeader().setReorderingAllowed(false);
        jScrollPane2.setViewportView(jTable2);
        if (jTable2.getColumnModel().getColumnCount() > 0) {
            jTable2.getColumnModel().getColumn(0).setPreferredWidth(200);
            jTable2.getColumnModel().getColumn(1).setMinWidth(40);
            jTable2.getColumnModel().getColumn(1).setPreferredWidth(40);
            jTable2.getColumnModel().getColumn(1).setMaxWidth(40);
            jTable2.getColumnModel().getColumn(2).setMinWidth(50);
            jTable2.getColumnModel().getColumn(2).setPreferredWidth(50);
            jTable2.getColumnModel().getColumn(2).setMaxWidth(50);
            jTable2.getColumnModel().getColumn(3).setMinWidth(50);
            jTable2.getColumnModel().getColumn(3).setPreferredWidth(50);
            jTable2.getColumnModel().getColumn(3).setMaxWidth(50);
        }

        jPanel1.add(jScrollPane2);
        jScrollPane2.setBounds(470, 50, 330, 380);

        jComboBox2.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Оплачені страви", "Видалені страви" }));
        jComboBox2.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jComboBox2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                getRemovedDishes(evt);
            }
        });
        jPanel1.add(jComboBox2);
        jComboBox2.setBounds(470, 20, 330, 30);

        jLabel3.setFont(new java.awt.Font("Verdana", 1, 14)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(0, 153, 204));
        jLabel3.setText("Чек № ");
        jPanel1.add(jLabel3);
        jLabel3.setBounds(470, 0, 180, 20);

        jTabbedPane1.addTab("Чеки", jPanel1);

        jPanel2.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));

        jTable6.setFont(new java.awt.Font("Verdana", 0, 14)); // NOI18N
        jTable6.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "№", "Назва", "Вага по базі (кг/ шт)", "Різниця"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.String.class, java.lang.Double.class, java.lang.Double.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, true
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jTable6.setRowHeight(20);
        jScrollPane6.setViewportView(jTable6);
        if (jTable6.getColumnModel().getColumnCount() > 0) {
            jTable6.getColumnModel().getColumn(0).setMinWidth(50);
            jTable6.getColumnModel().getColumn(0).setPreferredWidth(50);
            jTable6.getColumnModel().getColumn(0).setMaxWidth(50);
            jTable6.getColumnModel().getColumn(2).setMinWidth(120);
            jTable6.getColumnModel().getColumn(2).setPreferredWidth(120);
            jTable6.getColumnModel().getColumn(2).setMaxWidth(120);
            jTable6.getColumnModel().getColumn(3).setMinWidth(100);
            jTable6.getColumnModel().getColumn(3).setPreferredWidth(100);
            jTable6.getColumnModel().getColumn(3).setMaxWidth(100);
        }

        jComboBox7.setBackground(new java.awt.Color(240, 240, 240));
        jComboBox7.setFont(new java.awt.Font("Verdana", 0, 18)); // NOI18N
        jComboBox7.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "за номером", "за вагою", "за назвою" }));
        jComboBox7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBox7ActionPerformed(evt);
            }
        });

        jButton39.setBackground(new java.awt.Color(204, 204, 204));
        jButton39.setFont(new java.awt.Font("Verdana", 0, 14)); // NOI18N
        jButton39.setText("<html>поповнити<br/>&nbsp; склад</html> ");
        jButton39.setBorder(null);
        jButton39.setEnabled(false);
        jButton39.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jButton39.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addToStorage(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addComponent(jScrollPane6, javax.swing.GroupLayout.PREFERRED_SIZE, 566, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jComboBox7, 0, 198, Short.MAX_VALUE)
                    .addComponent(jButton39))
                .addContainerGap(41, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addComponent(jComboBox7, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jButton39, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(139, 139, 139))
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addComponent(jScrollPane6, javax.swing.GroupLayout.PREFERRED_SIZE, 526, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("Склад", jPanel2);

        jPanel3.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        jPanel3.setLayout(null);

        jTable5.setFont(new java.awt.Font("Verdana", 0, 14)); // NOI18N
        jTable5.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "№", "Назва", "Вага ( кг/ шт )"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.String.class, java.lang.Double.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jTable5.setRowHeight(20);
        jScrollPane5.setViewportView(jTable5);
        if (jTable5.getColumnModel().getColumnCount() > 0) {
            jTable5.getColumnModel().getColumn(0).setMinWidth(50);
            jTable5.getColumnModel().getColumn(0).setPreferredWidth(50);
            jTable5.getColumnModel().getColumn(0).setMaxWidth(50);
            jTable5.getColumnModel().getColumn(2).setMinWidth(100);
            jTable5.getColumnModel().getColumn(2).setPreferredWidth(100);
            jTable5.getColumnModel().getColumn(2).setMaxWidth(100);
        }

        jPanel3.add(jScrollPane5);
        jScrollPane5.setBounds(0, 30, 390, 496);

        jLabel17.setFont(new java.awt.Font("Verdana", 1, 18)); // NOI18N
        jLabel17.setForeground(new java.awt.Color(255, 51, 51));
        jLabel17.setText("Списані продукти");
        jPanel3.add(jLabel17);
        jLabel17.setBounds(90, 2, 220, 23);

        jTable10.setFont(new java.awt.Font("Verdana", 0, 14)); // NOI18N
        jTable10.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "№", "Назва", "Вага ( кг/ шт )"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.String.class, java.lang.Double.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jTable10.setRowHeight(20);
        jScrollPane10.setViewportView(jTable10);
        if (jTable10.getColumnModel().getColumnCount() > 0) {
            jTable10.getColumnModel().getColumn(0).setMinWidth(50);
            jTable10.getColumnModel().getColumn(0).setPreferredWidth(50);
            jTable10.getColumnModel().getColumn(0).setMaxWidth(50);
            jTable10.getColumnModel().getColumn(2).setMinWidth(100);
            jTable10.getColumnModel().getColumn(2).setPreferredWidth(100);
            jTable10.getColumnModel().getColumn(2).setMaxWidth(100);
        }

        jPanel3.add(jScrollPane10);
        jScrollPane10.setBounds(400, 30, 390, 496);

        jLabel22.setFont(new java.awt.Font("Verdana", 1, 18)); // NOI18N
        jLabel22.setForeground(new java.awt.Color(255, 51, 51));
        jLabel22.setText("Приход");
        jPanel3.add(jLabel22);
        jLabel22.setBounds(570, 0, 90, 23);

        jTabbedPane1.addTab("Продукти", jPanel3);

        jPanel7.setLayout(null);

        jTable11.setFont(new java.awt.Font("Verdana", 0, 18)); // NOI18N
        jTable11.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "№", "Назва", "Вага стара", "Вага нова", "Різниця"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.String.class, java.lang.Double.class, java.lang.Double.class, java.lang.Double.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jTable11.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jTable11.setRowHeight(20);
        jScrollPane11.setViewportView(jTable11);
        if (jTable11.getColumnModel().getColumnCount() > 0) {
            jTable11.getColumnModel().getColumn(0).setMinWidth(40);
            jTable11.getColumnModel().getColumn(0).setPreferredWidth(40);
            jTable11.getColumnModel().getColumn(0).setMaxWidth(40);
            jTable11.getColumnModel().getColumn(2).setMinWidth(130);
            jTable11.getColumnModel().getColumn(2).setPreferredWidth(130);
            jTable11.getColumnModel().getColumn(2).setMaxWidth(130);
            jTable11.getColumnModel().getColumn(3).setMinWidth(130);
            jTable11.getColumnModel().getColumn(3).setPreferredWidth(130);
            jTable11.getColumnModel().getColumn(3).setMaxWidth(130);
            jTable11.getColumnModel().getColumn(4).setMinWidth(130);
            jTable11.getColumnModel().getColumn(4).setPreferredWidth(130);
            jTable11.getColumnModel().getColumn(4).setMaxWidth(130);
        }

        jPanel7.add(jScrollPane11);
        jScrollPane11.setBounds(0, 40, 810, 480);

        jLabel6.setFont(new java.awt.Font("Verdana", 1, 14)); // NOI18N
        jLabel6.setText("Дата");
        jPanel7.add(jLabel6);
        jLabel6.setBounds(500, 10, 60, 18);

        jPanel7.add(jComboBox3);
        jComboBox3.setBounds(560, 10, 140, 20);

        jToggleButton1.setText("Відкрити");
        jToggleButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                showRevizia(evt);
            }
        });
        jPanel7.add(jToggleButton1);
        jToggleButton1.setBounds(713, 10, 90, 23);

        jTabbedPane1.addTab("Ревізія", jPanel7);

        jPanel4.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        jPanel4.setLayout(null);

        jTable3.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jTable3.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null}
            },
            new String [] {
                "Ім'я", "Початок", "Кінець"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane3.setViewportView(jTable3);
        if (jTable3.getColumnModel().getColumnCount() > 0) {
            jTable3.getColumnModel().getColumn(1).setMinWidth(200);
            jTable3.getColumnModel().getColumn(1).setPreferredWidth(200);
            jTable3.getColumnModel().getColumn(1).setMaxWidth(200);
            jTable3.getColumnModel().getColumn(2).setMinWidth(200);
            jTable3.getColumnModel().getColumn(2).setPreferredWidth(200);
            jTable3.getColumnModel().getColumn(2).setMaxWidth(200);
        }

        jPanel4.add(jScrollPane3);
        jScrollPane3.setBounds(10, 30, 630, 260);

        jLabel4.setFont(new java.awt.Font("Verdana", 1, 14)); // NOI18N
        jLabel4.setText("Час роботи працівників");
        jPanel4.add(jLabel4);
        jLabel4.setBounds(10, 10, 230, 20);
        jPanel4.add(jXDatePicker3);
        jXDatePicker3.setBounds(290, 8, 170, 22);

        jButton2.setText("показати час");
        jButton2.setEnabled(false);
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                showEmployeeShedule(evt);
            }
        });
        jPanel4.add(jButton2);
        jButton2.setBounds(470, 8, 130, 23);

        jTabbedPane1.addTab("Працівники", jPanel4);

        jPanel5.setLayout(null);

        jLabel12.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel12.setForeground(new java.awt.Color(255, 51, 51));
        jPanel5.add(jLabel12);
        jLabel12.setBounds(580, 20, 210, 20);

        jTable8.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jTable8.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null}
            },
            new String [] {
                "Ім'я", "Сума"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.Integer.class
            };
            boolean[] canEdit = new boolean [] {
                false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jTable8.setRowHeight(20);
        jScrollPane8.setViewportView(jTable8);
        if (jTable8.getColumnModel().getColumnCount() > 0) {
            jTable8.getColumnModel().getColumn(1).setMinWidth(150);
            jTable8.getColumnModel().getColumn(1).setPreferredWidth(150);
            jTable8.getColumnModel().getColumn(1).setMaxWidth(150);
        }

        jPanel5.add(jScrollPane8);
        jScrollPane8.setBounds(10, 30, 640, 180);

        jLabel20.setFont(new java.awt.Font("Verdana", 1, 18)); // NOI18N
        jLabel20.setText("Аванс");
        jPanel5.add(jLabel20);
        jLabel20.setBounds(10, 0, 220, 23);

        jTable9.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jTable9.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Ім'я", "Призначення", "Дата", "Сума"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.Integer.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jTable9.setRowHeight(20);
        jScrollPane9.setViewportView(jTable9);
        if (jTable9.getColumnModel().getColumnCount() > 0) {
            jTable9.getColumnModel().getColumn(1).setMinWidth(200);
            jTable9.getColumnModel().getColumn(1).setPreferredWidth(200);
            jTable9.getColumnModel().getColumn(1).setMaxWidth(200);
            jTable9.getColumnModel().getColumn(2).setMinWidth(200);
            jTable9.getColumnModel().getColumn(2).setPreferredWidth(200);
            jTable9.getColumnModel().getColumn(2).setMaxWidth(200);
            jTable9.getColumnModel().getColumn(3).setMinWidth(150);
            jTable9.getColumnModel().getColumn(3).setPreferredWidth(150);
            jTable9.getColumnModel().getColumn(3).setMaxWidth(150);
        }

        jPanel5.add(jScrollPane9);
        jScrollPane9.setBounds(10, 240, 640, 280);

        jLabel21.setFont(new java.awt.Font("Verdana", 1, 18)); // NOI18N
        jLabel21.setText("Інкасація");
        jPanel5.add(jLabel21);
        jLabel21.setBounds(10, 210, 220, 23);

        jTabbedPane1.addTab("Загальна", jPanel5);

        jTable7.setFont(new java.awt.Font("Verdana", 0, 14)); // NOI18N
        jTable7.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Назва", "Кількість"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.Double.class
            };
            boolean[] canEdit = new boolean [] {
                false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jTable7.setRowHeight(20);
        jScrollPane7.setViewportView(jTable7);
        if (jTable7.getColumnModel().getColumnCount() > 0) {
            jTable7.getColumnModel().getColumn(1).setMinWidth(100);
            jTable7.getColumnModel().getColumn(1).setPreferredWidth(100);
            jTable7.getColumnModel().getColumn(1).setMaxWidth(100);
        }

        jComboBox8.setBackground(new java.awt.Color(240, 240, 240));
        jComboBox8.setFont(new java.awt.Font("Verdana", 0, 18)); // NOI18N
        jComboBox8.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "за назвою", "за кількістю" }));
        jComboBox8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                changeOrderedDishSort(evt);
            }
        });

        jLabel8.setFont(new java.awt.Font("Verdana", 1, 18)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(0, 153, 204));
        jLabel8.setText("Замовлені страви");

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addGap(20, 20, 20)
                        .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 195, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(5, 5, 5)
                        .addComponent(jComboBox8, javax.swing.GroupLayout.PREFERRED_SIZE, 198, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jScrollPane7, javax.swing.GroupLayout.PREFERRED_SIZE, 420, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 393, Short.MAX_VALUE))
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel6Layout.createSequentialGroup()
                .addGap(0, 6, Short.MAX_VALUE)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel8)
                    .addComponent(jComboBox8, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(5, 5, 5)
                .addComponent(jScrollPane7, javax.swing.GroupLayout.PREFERRED_SIZE, 496, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        jTabbedPane1.addTab("Замовлені страви", jPanel6);

        getContentPane().add(jTabbedPane1);
        jTabbedPane1.setBounds(220, 0, 820, 570);

        jLabel10.setFont(new java.awt.Font("Verdana", 1, 14)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(0, 153, 0));
        jLabel10.setText("0");
        jLabel10.setFocusable(false);
        jLabel10.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
        getContentPane().add(jLabel10);
        jLabel10.setBounds(150, 280, 110, 18);

        jLabel16.setFont(new java.awt.Font("Verdana", 1, 14)); // NOI18N
        jLabel16.setForeground(new java.awt.Color(0, 153, 0));
        jLabel16.setText("Заг. кіл. страв:");
        getContentPane().add(jLabel16);
        jLabel16.setBounds(10, 280, 160, 18);

        jLabel14.setFont(new java.awt.Font("Verdana", 1, 14)); // NOI18N
        jLabel14.setForeground(new java.awt.Color(0, 153, 204));
        jLabel14.setText("Сума в касі:");
        getContentPane().add(jLabel14);
        jLabel14.setBounds(10, 260, 140, 18);

        jLabel18.setFont(new java.awt.Font("Verdana", 1, 14)); // NOI18N
        jLabel18.setForeground(new java.awt.Color(255, 51, 51));
        jLabel18.setText("Аванс:");
        getContentPane().add(jLabel18);
        jLabel18.setBounds(10, 240, 140, 18);

        jLabel11.setFont(new java.awt.Font("Verdana", 1, 14)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(255, 51, 51));
        jLabel11.setText("Інкасація:");
        getContentPane().add(jLabel11);
        jLabel11.setBounds(10, 220, 140, 18);

        jLabel7.setFont(new java.awt.Font("Verdana", 1, 14)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(0, 153, 0));
        jLabel7.setText("Заг. каса:");
        getContentPane().add(jLabel7);
        jLabel7.setBounds(10, 200, 140, 18);

        jLabel9.setFont(new java.awt.Font("Verdana", 1, 14)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(0, 153, 0));
        jLabel9.setText("0");
        jLabel9.setFocusable(false);
        jLabel9.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
        getContentPane().add(jLabel9);
        jLabel9.setBounds(150, 200, 110, 23);

        jLabel13.setFont(new java.awt.Font("Verdana", 1, 14)); // NOI18N
        jLabel13.setForeground(new java.awt.Color(255, 51, 51));
        jLabel13.setText("-0");
        jLabel13.setFocusable(false);
        jLabel13.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
        getContentPane().add(jLabel13);
        jLabel13.setBounds(143, 220, 110, 18);

        jLabel19.setFont(new java.awt.Font("Verdana", 1, 14)); // NOI18N
        jLabel19.setForeground(new java.awt.Color(255, 51, 51));
        jLabel19.setText("-0");
        jLabel19.setFocusable(false);
        jLabel19.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
        getContentPane().add(jLabel19);
        jLabel19.setBounds(143, 240, 110, 18);

        jLabel15.setFont(new java.awt.Font("Verdana", 1, 14)); // NOI18N
        jLabel15.setForeground(new java.awt.Color(0, 153, 204));
        jLabel15.setText("0");
        jLabel15.setFocusable(false);
        jLabel15.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
        getContentPane().add(jLabel15);
        jLabel15.setBounds(150, 260, 110, 18);

        jTable4.setFont(new java.awt.Font("Verdana", 0, 14)); // NOI18N
        jTable4.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null},
                {null, null}
            },
            new String [] {
                "Бармен", "Каса"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.Integer.class
            };
            boolean[] canEdit = new boolean [] {
                false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jTable4.setRowHeight(20);
        jScrollPane4.setViewportView(jTable4);
        if (jTable4.getColumnModel().getColumnCount() > 0) {
            jTable4.getColumnModel().getColumn(1).setMinWidth(100);
            jTable4.getColumnModel().getColumn(1).setPreferredWidth(100);
            jTable4.getColumnModel().getColumn(1).setMaxWidth(100);
        }

        getContentPane().add(jScrollPane4);
        jScrollPane4.setBounds(0, 330, 220, 230);

        jLabel5.setFont(new java.awt.Font("Verdana", 1, 14)); // NOI18N
        jLabel5.setText("Каса по барменах");
        getContentPane().add(jLabel5);
        jLabel5.setBounds(0, 310, 290, 20);

        setSize(new java.awt.Dimension(1051, 599));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    //need to fix
    private static void initServer() {
        JFrame frame = new JFrame();
        String[] servers = {"Шепетовка", "Староконстянтинів", "Славута"};
        final JComboBox<String> combo = new JComboBox<>(servers);
        String[] options = {"OK"};
        int selection = JOptionPane.showOptionDialog(null, combo, "Виберіть кафе для підключення",
                JOptionPane.DEFAULT_OPTION, JOptionPane.PLAIN_MESSAGE, null,
                options, options[0]);
        Object server = combo.getSelectedItem();
        if (server != null) {
            System.out.println("server: " + server);
//            System.out.println("server index" + servers.);
            chooseServer(employees.indexOf(server));
            DbConnect.ConnectDb();
        }

    }

    private void initEnabledComponents() {

        jTable1.setEnabled(false);
        jComboBox2.setEnabled(false);
        jButton39.setBackground(GREEN);

        try {
            setColumnRender(jTable6.getColumnModel().getColumn(2));
        } catch (ParseException ex) {
            Logger.getLogger(ClientForm.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private void getUsersStatistics() {
        for (int i = 0; i < LoginForm.userList.size(); i++) {
            userList.get(i).setKasa(getUserKasa(startDate, endDate, i));
        }
    }

    public void testCafeConnection() {
        try (Connection connection = DriverManager
                .getConnection(URL, USERNAME, PASSWORD);) {
            System.out.println(!connection.isClosed() ? "DB connected to " + URL
                    : "Error DB connecting");
        } catch (SQLException e) {
            System.out.println("Connection to DB Failed! ");
            JFrame frame = new JFrame();
            int reply = JOptionPane.showOptionDialog(frame.getContentPane(),
                    "Немаэ підключення до бази данних!\nВихід з програми", "ПОМИЛКА!",
                    0, JOptionPane.YES_OPTION, null, new String[]{"ТАК"}, null);

        } catch (Exception e) {

        }
    }

    private void getAllOrders(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_getAllOrders
        if (jComboBox1.getSelectedIndex() >= 0) {
            if (jXDatePicker1.getDate() != null && jXDatePicker2.getDate() != null) {
                jTable1.setEnabled(true);
                jComboBox2.setEnabled(true);
                try {
                    startDate = new java.sql.Timestamp((jXDatePicker1.getDate().getTime()));
                    System.out.println("start " + startDate);
                    endDate = new java.sql.Timestamp(jXDatePicker2.getDate().getTime() + TWO_HOURS);
                    orders.clear();
                    orders.addAll(OrderUtils.getOrdersBetween(startDate, endDate));
                    System.out.println("orders size " + orders.size());
                    refreshOrderTable(jTable1, orders);
                } finally {
                    jProgressBar1.setIndeterminate(false);
                }
                MainForm.initBDmenu();
                UsersUtils.readAllUsers();
                getStorageTable();

                jButton2.setEnabled(true);
                jButton39.setEnabled(true);
                refreshBarmensTable();
                refreshRemovedIngTable();
                refreshAddedIngTable();
                getDishes();
                getEmployeeKeyMoney();
                getInkass();
            }
        }
    }//GEN-LAST:event_getAllOrders

    private void jTable1MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable1MousePressed
        activeOrder = jTable1.getSelectedRow();
        getRemovedDishes(null);
    }//GEN-LAST:event_jTable1MousePressed

    private void getRemovedDishes(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_getRemovedDishes
        int index = jComboBox2.getSelectedIndex();
        if (activeOrder != -1) {
            if (index == 0) {
                refreshRecipeTable(activeOrder);
            } else {
                refreshRemoveRecipeTable(activeOrder);
            }
            jLabel3.setText("Чек № " + orders.get(activeOrder).getDayId());
        }
    }//GEN-LAST:event_getRemovedDishes

    private void jTable1KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTable1KeyReleased
        jTable1MousePressed(null);
    }//GEN-LAST:event_jTable1KeyReleased

    private void showEmployeeShedule(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_showEmployeeShedule
        EmployeeDate = new java.sql.Timestamp((jXDatePicker3.getDate().getTime()));
        EmployeeUtils.getEmployeeTime(EmployeeDate);
        refreshEmployeeTable();
    }//GEN-LAST:event_showEmployeeShedule

    private void chooseCafe(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_chooseCafe
        chooseServer(jComboBox1.getSelectedIndex());
        testCafeConnection();
        refreshReviziaDates();
        StorageUtils.readStorage();
    }//GEN-LAST:event_chooseCafe

    private void addToStorage(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addToStorage
        StorageUtils.readStorage();
        setSort(jComboBox7, jTable6);
        MainForm.addIngCountToStorage(jTable6);
        StorageUtils.readStorage();
        setSort(jComboBox7, jTable6);
        showCalcTable(jTable6);
    }//GEN-LAST:event_addToStorage

    private void jComboBox7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBox7ActionPerformed
        setSort(jComboBox7, jTable6);
        showCalcTable(jTable6);
        System.out.println("change sort storageList  ");
    }//GEN-LAST:event_jComboBox7ActionPerformed

    private void changeOrderedDishSort(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_changeOrderedDishSort
        setSort(jComboBox8, jTable7);
        sortListOfOrderItems(orderedDishes, jComboBox8.getSelectedIndex());
        refreshDishesTable();
    }//GEN-LAST:event_changeOrderedDishSort

    private void showRevizia(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_showRevizia
        Timestamp date  = new java.sql.Timestamp(((Date) jComboBox3.getSelectedItem()).getTime());
        
        DefaultTableModel model = (DefaultTableModel) jTable11.getModel();
        model.setRowCount(0);
        List<ReviziaItem> revizia =  ReviziaUtils.getReviziaByDate(date);
        for (ReviziaItem item : revizia) {
            model.addRow(new Object[]{
                item.getId(),
                getIngTitleById(item.getId()),                
                item.getOldCount(),
                item.getNewCount(),
                item.getDiffCount()                
            });
            
        }
        
    }//GEN-LAST:event_showRevizia

    private void getStorageTable() {
        StorageUtils.readStorage();

        setSort(jComboBox7, jTable6);
        showCalcTable(jTable6);
    }

    private void getDishes() {
        orderedDishes.clear();
        orderedDishes.addAll(getOrderedDishes(startDate, endDate));
        sortListOfOrderItems(orderedDishes, jComboBox8.getSelectedIndex());
        refreshDishesTable();

    }

    private void refreshDishesTable() {
        DefaultTableModel model = (DefaultTableModel) jTable7.getModel();
        model.setRowCount(0);
        for (OrderItem item : orderedDishes) {
            model.addRow(new Object[]{
                item.getDish().getTitle(),
                item.getCount()
            });
        }
    }

    private void getEmployeeKeyMoney() {
        EmployeeUtils.readAllEmployees();
        System.out.println("employee size " + employees.size());
        for (Employee employee : employees) {
            employee.setKeyMoney(getSumKeyMoneyForUserBetween(startDate, endDate, employee.getName()));
        }
        refresEmployeeKeyMoneyTable();

    }

    private void refresEmployeeKeyMoneyTable() {
        DefaultTableModel model = (DefaultTableModel) jTable8.getModel();
        model.setRowCount(0);
        for (Employee employee : employees) {
            model.addRow(new Object[]{
                employee.getName(),
                employee.getKeyMoney()

            });
        }
    }

    private void getInkass() {
        inkassOrders.clear();
        inkassOrders.addAll(OrderUtils.getInkassOrders(startDate, endDate));
        DefaultTableModel model = (DefaultTableModel) jTable9.getModel();
        model.setRowCount(0);
        for (Order order : inkassOrders) {
            model.addRow(new Object[]{
                order.getUser(),
                order.getComent(),
                order.getDate(),
                order.getOrderSum()
            });
        }

    }

    private void refreshEmployeeTable() {
//        SimpleDateFormat format1 = new SimpleDateFormat("HH:mm:ss");
        DefaultTableModel model = (DefaultTableModel) jTable3.getModel();
        model.setRowCount(0);
        for (Employee item : employees) {
            model.addRow(new Object[]{
                item.getName(),
                item.getStartTime(),
                //                format1.format(item.getStartTime()),
                item.getEndTime()
//                format1.format(item.getEndTime())
            });
        }
    }

    private void refreshRecipeTable(int id) {
        DefaultTableModel model = (DefaultTableModel) jTable2.getModel();
        model.setRowCount(0);
        for (OrderItem item : orders.get(id).getItems()) {
            model.addRow(new Object[]{
                item.getDish().getTitle(),
                item.getCount(),
                item.getDish().getPrice(),
                item.getSum()
            });
        }
    }

    private void refreshRemoveRecipeTable(int id) {
        DefaultTableModel model = (DefaultTableModel) jTable2.getModel();
        model.setRowCount(0);
        for (OrderItem item : orders.get(id).getRemovedItems()) {
            model.addRow(new Object[]{
                item.getDish().getTitle(),
                item.getCount(),
                item.getDish().getPrice(),
                item.getSum()
            });
        }
    }

    private void refreshBarmensTable() {
        getUsersStatistics();
        DefaultTableModel model = (DefaultTableModel) jTable4.getModel();
        model.setRowCount(0);

        for (int i = 0; i < LoginForm.userList.size(); i++) {
            model.addRow(new Object[]{
                LoginForm.userList.get(i).getName(),
                LoginForm.userList.get(i).getKasa()
            });
        }
        jLabel9.setText(String.valueOf(OrderUtils.getAllBarmenSumBetween(startDate, endDate)));
        jLabel10.setText(String.valueOf(OrderUtils.getAllCookCountBetween(startDate, endDate)));
        jLabel13.setText(String.valueOf(OrderUtils.getAllRemovedSumBetween(startDate, endDate)));
        jLabel15.setText(String.valueOf(OrderUtils.getAllSumBefore(new Timestamp(new Date().getTime()))));

    }

    private void refreshRemovedIngTable() {

        DefaultTableModel model = (DefaultTableModel) jTable5.getModel();
        model.setRowCount(0);
        List<Ingredient> removedIng = new ArrayList<>();
        removedIng.addAll(getRemovedIngredients(startDate, endDate));
        for (Ingredient ing : removedIng) {
            ing.setTitle(getIngTitleById(ing.getId()));  //fix getIngTitleById
        }

        sortListOfIngredients(removedIng, 2);
        for (Ingredient ing : removedIng) {
            model.addRow(new Object[]{
                ing.getId(),
                ing.getTitle(),
                ing.getCount()
            });
        }
        getStorageTable();

    }

    private void refreshAddedIngTable() {

        DefaultTableModel model = (DefaultTableModel) jTable10.getModel();
        model.setRowCount(0);
        List<Ingredient> addedIng = new ArrayList<>();
        addedIng.addAll(getAddedIngredients(startDate, endDate));
        for (Ingredient ing : addedIng) {
            ing.setTitle(getIngTitleById(ing.getId()));
        }

        sortListOfIngredients(addedIng, 2);
        for (Ingredient ing : addedIng) {
            model.addRow(new Object[]{
                ing.getId(),
                ing.getTitle(),
                ing.getCount()
            });
        }
        getStorageTable();

    }
    
    private void refreshReviziaDates(){       
        jComboBox3.removeAllItems();
        List<Date> reviziaDates = new ArrayList<>(ReviziaUtils.getReviziaDates());
        for (Date reviziaDate : reviziaDates) {         
            jComboBox3.addItem(reviziaDate);
        }
    }

    private void refreshOrderTable(JTable table, List<Order> list) {
        DefaultTableModel model = (DefaultTableModel) table.getModel();
        model.setRowCount(0);
        int k = 1;

        for (Order order : list) {
            model.addRow(new Object[]{
                order.getId(),
                order.getDayId(),
                order.getUser(),
                order.getOrderSum(),
                dateFormat.format(order.getDate()),
                order.getCookCount(),
                order.getRemovedItems().size()
            });
        }
    }

    public static void main(String args[]) {
        clientForm = new ClientForm();
        clientForm.setVisible(true);
        clientForm.setExtendedState(JFrame.MAXIMIZED_BOTH);
    }
    
    private static final int TWO_HOURS = 3 * 60 * 60 * 1000;
    private static Timestamp startDate, endDate, EmployeeDate;
    private static int activeOrder;
    private static final List<Order> orders = new ArrayList<>();
    private static final List<Order> inkassOrders = new ArrayList<>();
    private static final List<OrderItem> orderedDishes = new ArrayList<>();
    private static final DateFormat dateFormat = new SimpleDateFormat("dd/MM HH:mm:ss");
    public static ClientForm clientForm;
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton39;
    private javax.swing.JComboBox jComboBox1;
    private javax.swing.JComboBox jComboBox2;
    private javax.swing.JComboBox jComboBox3;
    private javax.swing.JComboBox jComboBox7;
    private javax.swing.JComboBox jComboBox8;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
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
    private javax.swing.JProgressBar jProgressBar1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane10;
    private javax.swing.JScrollPane jScrollPane11;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JScrollPane jScrollPane6;
    private javax.swing.JScrollPane jScrollPane7;
    private javax.swing.JScrollPane jScrollPane8;
    private javax.swing.JScrollPane jScrollPane9;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JTable jTable10;
    private javax.swing.JTable jTable11;
    private javax.swing.JTable jTable2;
    private javax.swing.JTable jTable3;
    private javax.swing.JTable jTable4;
    private javax.swing.JTable jTable5;
    private javax.swing.JTable jTable6;
    private javax.swing.JTable jTable7;
    private javax.swing.JTable jTable8;
    private javax.swing.JTable jTable9;
    private javax.swing.JToggleButton jToggleButton1;
    private org.jdesktop.swingx.JXDatePicker jXDatePicker1;
    private org.jdesktop.swingx.JXDatePicker jXDatePicker2;
    private org.jdesktop.swingx.JXDatePicker jXDatePicker3;
    // End of variables declaration//GEN-END:variables
}
