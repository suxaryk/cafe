package cafe.view;

import cafe.Utils.db.DBUtils;
import cafe.Utils.db.EmployeeUtils;
import static cafe.Utils.db.EmployeeUtils.getEmployeeFullWorksDay;
import static cafe.Utils.db.EmployeeUtils.getEmployeeHalfWorksDay;
import cafe.Utils.db.OrderUtils;
import static cafe.Utils.db.OrderUtils.getCustomSumKeyMoneyForUserBetween;
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
import cafe.model.User;
import static cafe.view.MainForm.GREEN;
import static cafe.view.MainForm.RED;
import static cafe.view.MainForm.employees;
import static cafe.view.MainForm.setColumnRender;
import static cafe.view.MainForm.setSort;
import static cafe.view.MainForm.sortListOfIngredients;
import static cafe.view.MainForm.sortListOfOrderItems;
import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;
import javax.swing.JTable;
import javax.swing.event.TableModelEvent;
import javax.swing.event.TableModelListener;
import javax.swing.table.DefaultTableModel;
import static cafe.Utils.db.DBUtils.chooseServer;
import cafe.Utils.db.DishUtils;
import cafe.Utils.db.RecepiesUtils;
import cafe.Utils.json.JSONUtils;
import cafe.model.Category;
import cafe.model.Dish;
import static cafe.view.MainForm.activeCat;
import static cafe.view.MainForm.activeDishes;
import static cafe.view.MainForm.getListFromTable;
import static cafe.view.MainForm.menu;
import static cafe.view.MainForm.scrollToLastItem;
import static cafe.view.MainForm.showCalcTable;
import static cafe.view.MainForm.sortListOfDish;
import static cafe.view.MainForm.storageList;
import java.math.BigDecimal;
import static java.math.BigDecimal.ZERO;
import java.math.RoundingMode;
import java.text.DecimalFormat;
import java.util.Optional;
import javax.swing.JOptionPane;

public class ClientForm extends javax.swing.JFrame {
    
    private static final org.apache.log4j.Logger log = org.apache.log4j.Logger.getLogger(ClientForm.class);
    private String[] serverArray ;

    public ClientForm() {
        initComponents();
        User.active = 5;
        chooseServer(0);
        DBUtils.ConnectDb();
        MainForm.initBDmenu();
                
        initEnabledComponents();  
            serverArray = new String[]{"Шепетовка", "Староконстянтинів", "Славута"};
            servers.addAll(Arrays.asList(serverArray));
            jComboBox1.setModel(new javax.swing.DefaultComboBoxModel(serverArray));
            jXDatePicker1.setDate(new Date());
            jXDatePicker2.setDate(new Date());
            jCheckBox2.setVisible(false);
            StorageUtils.readStorage();
            
            chooseCafe(null);
            jTabbedPane2.setEnabledAt(1, false);
            jTabbedPane2.setEnabledAt(2, false);
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
        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTable2 = new javax.swing.JTable();
        jComboBox2 = new javax.swing.JComboBox();
        jLabel3 = new javax.swing.JLabel();
        jButton3 = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        jTabbedPane3 = new javax.swing.JTabbedPane();
        jPanel10 = new javax.swing.JPanel();
        jScrollPane6 = new javax.swing.JScrollPane();
        jTable6 = new javax.swing.JTable();
        jComboBox7 = new javax.swing.JComboBox();
        jButton39 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        jButton41 = new javax.swing.JButton();
        jButton43 = new javax.swing.JButton();
        jPanel8 = new javax.swing.JPanel();
        jScrollPane12 = new javax.swing.JScrollPane();
        jTable12 = new javax.swing.JTable();
        jComboBox10 = new javax.swing.JComboBox();
        jButton9 = new javax.swing.JButton();
        jPanel9 = new javax.swing.JPanel();
        jButton40 = new javax.swing.JButton();
        jComboBox11 = new javax.swing.JComboBox();
        jScrollPane14 = new javax.swing.JScrollPane();
        jTable14 = new javax.swing.JTable();
        jButton10 = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();
        jScrollPane5 = new javax.swing.JScrollPane();
        jTable5 = new javax.swing.JTable();
        jLabel17 = new javax.swing.JLabel();
        jScrollPane10 = new javax.swing.JScrollPane();
        jTable10 = new javax.swing.JTable();
        jLabel22 = new javax.swing.JLabel();
        jButton5 = new javax.swing.JButton();
        jPanel7 = new javax.swing.JPanel();
        jScrollPane11 = new javax.swing.JScrollPane();
        jTable11 = new javax.swing.JTable();
        jLabel6 = new javax.swing.JLabel();
        jComboBox3 = new javax.swing.JComboBox();
        jToggleButton1 = new javax.swing.JToggleButton();
        jComboBox9 = new javax.swing.JComboBox();
        jLabel24 = new javax.swing.JLabel();
        jLabel25 = new javax.swing.JLabel();
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
        jButton6 = new javax.swing.JButton();
        jButton7 = new javax.swing.JButton();
        jPanel6 = new javax.swing.JPanel();
        jScrollPane7 = new javax.swing.JScrollPane();
        jTable7 = new javax.swing.JTable();
        jComboBox8 = new javax.swing.JComboBox();
        jLabel8 = new javax.swing.JLabel();
        jButton8 = new javax.swing.JButton();
        jPanel11 = new javax.swing.JPanel();
        jTabbedPane2 = new javax.swing.JTabbedPane();
        CategoriesPanel = new javax.swing.JPanel();
        cat5 = new javax.swing.JButton();
        cat6 = new javax.swing.JButton();
        cat7 = new javax.swing.JButton();
        cat8 = new javax.swing.JButton();
        cat3 = new javax.swing.JButton();
        cat4 = new javax.swing.JButton();
        cat2 = new javax.swing.JButton();
        cat1 = new javax.swing.JButton();
        cat9 = new javax.swing.JButton();
        cat10 = new javax.swing.JButton();
        cat11 = new javax.swing.JButton();
        cat12 = new javax.swing.JButton();
        DishesPanel = new javax.swing.JPanel();
        jScrollPane15 = new javax.swing.JScrollPane();
        jTable15 = new javax.swing.JTable();
        jCheckBox3 = new javax.swing.JCheckBox();
        jCheckBox2 = new javax.swing.JCheckBox();
        jComboBox4 = new javax.swing.JComboBox();
        jLabel30 = new javax.swing.JLabel();
        jLabel31 = new javax.swing.JLabel();
        jTextField4 = new javax.swing.JTextField();
        jLabel32 = new javax.swing.JLabel();
        jTextField2 = new javax.swing.JTextField();
        jButton12 = new javax.swing.JButton();
        jButton19 = new javax.swing.JButton();
        jButton13 = new javax.swing.JButton();
        jButton14 = new javax.swing.JButton();
        jPanel12 = new javax.swing.JPanel();
        jScrollPane13 = new javax.swing.JScrollPane();
        jTable13 = new javax.swing.JTable();
        jButton42 = new javax.swing.JButton();
        jLabel33 = new javax.swing.JLabel();
        jComboBox6 = new javax.swing.JComboBox();
        jLabel34 = new javax.swing.JLabel();
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
        jLabel23 = new javax.swing.JLabel();
        jCheckBox1 = new javax.swing.JCheckBox();
        jLabel26 = new javax.swing.JLabel();
        jLabel27 = new javax.swing.JLabel();
        jLabel28 = new javax.swing.JLabel();
        jLabel29 = new javax.swing.JLabel();
        jButton11 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(null);

        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Буковель" }));
        jComboBox1.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jComboBox1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                chooseCafe(evt);
            }
        });
        getContentPane().add(jComboBox1);
        jComboBox1.setBounds(0, 0, 220, 30);

        jLabel1.setFont(new java.awt.Font("Verdana", 1, 18)); // NOI18N
        jLabel1.setText(" З");
        getContentPane().add(jLabel1);
        jLabel1.setBounds(0, 30, 40, 20);

        jLabel2.setFont(new java.awt.Font("Verdana", 1, 18)); // NOI18N
        jLabel2.setText(" По");
        getContentPane().add(jLabel2);
        jLabel2.setBounds(0, 50, 40, 20);

        jButton1.setBackground(new java.awt.Color(0, 153, 204));
        jButton1.setFont(new java.awt.Font("Verdana", 1, 14)); // NOI18N
        jButton1.setText("Показати всі дані");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                getAllOrders(evt);
            }
        });
        getContentPane().add(jButton1);
        jButton1.setBounds(0, 110, 220, 40);
        getContentPane().add(jXDatePicker1);
        jXDatePicker1.setBounds(50, 30, 170, 22);

        jXDatePicker2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jXDatePicker2ActionPerformed(evt);
            }
        });
        getContentPane().add(jXDatePicker2);
        jXDatePicker2.setBounds(50, 50, 170, 22);

        jTabbedPane1.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        jTabbedPane1.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jTabbedPane1.addComponentListener(new java.awt.event.ComponentAdapter() {
            public void componentShown(java.awt.event.ComponentEvent evt) {
                jTabbedPane1ComponentShown(evt);
            }
        });

        jPanel1.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        jPanel1.setLayout(null);

        jTable1.setFont(new java.awt.Font("Verdana", 0, 18)); // NOI18N
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
            jTable1.getColumnModel().getColumn(3).setMinWidth(70);
            jTable1.getColumnModel().getColumn(3).setPreferredWidth(70);
            jTable1.getColumnModel().getColumn(3).setMaxWidth(70);
            jTable1.getColumnModel().getColumn(4).setMinWidth(200);
            jTable1.getColumnModel().getColumn(4).setPreferredWidth(200);
            jTable1.getColumnModel().getColumn(4).setMaxWidth(200);
            jTable1.getColumnModel().getColumn(5).setMinWidth(40);
            jTable1.getColumnModel().getColumn(5).setPreferredWidth(40);
            jTable1.getColumnModel().getColumn(5).setMaxWidth(40);
            jTable1.getColumnModel().getColumn(6).setMinWidth(45);
            jTable1.getColumnModel().getColumn(6).setPreferredWidth(45);
            jTable1.getColumnModel().getColumn(6).setMaxWidth(45);
        }

        jPanel1.add(jScrollPane1);
        jScrollPane1.setBounds(1, 1, 810, 690);

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
        jScrollPane2.setBounds(820, 60, 320, 380);

        jComboBox2.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Оплачені страви", "Видалені страви" }));
        jComboBox2.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jComboBox2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                getRemovedDishes(evt);
            }
        });
        jPanel1.add(jComboBox2);
        jComboBox2.setBounds(820, 30, 320, 30);

        jLabel3.setFont(new java.awt.Font("Verdana", 1, 14)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(0, 153, 204));
        jLabel3.setText("Чек № ");
        jPanel1.add(jLabel3);
        jLabel3.setBounds(820, 10, 170, 20);

        jButton3.setBackground(new java.awt.Color(0, 153, 204));
        jButton3.setFont(new java.awt.Font("Verdana", 1, 14)); // NOI18N
        jButton3.setText("Показати чеки");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3getAllOrders(evt);
            }
        });
        jPanel1.add(jButton3);
        jButton3.setBounds(850, 460, 220, 40);

        jTabbedPane1.addTab("Чеки", jPanel1);

        jPanel2.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        jPanel2.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jPanel2KeyPressed(evt);
            }
        });
        jPanel2.setLayout(null);

        jTabbedPane3.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N

        jPanel10.setLayout(null);

        jTable6.setFont(new java.awt.Font("Verdana", 0, 18)); // NOI18N
        jTable6.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "№", "Назва", "Вага по базі (кг/ шт)", "Різниця", "Вибраний"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.String.class, java.lang.Double.class, java.lang.Double.class, java.lang.Boolean.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, true, true
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jTable6.setRowHeight(18);
        jScrollPane6.setViewportView(jTable6);
        if (jTable6.getColumnModel().getColumnCount() > 0) {
            jTable6.getColumnModel().getColumn(0).setMinWidth(50);
            jTable6.getColumnModel().getColumn(0).setPreferredWidth(50);
            jTable6.getColumnModel().getColumn(0).setMaxWidth(50);
            jTable6.getColumnModel().getColumn(2).setMinWidth(120);
            jTable6.getColumnModel().getColumn(2).setPreferredWidth(120);
            jTable6.getColumnModel().getColumn(2).setMaxWidth(120);
            jTable6.getColumnModel().getColumn(3).setMinWidth(110);
            jTable6.getColumnModel().getColumn(3).setPreferredWidth(110);
            jTable6.getColumnModel().getColumn(3).setMaxWidth(110);
            jTable6.getColumnModel().getColumn(4).setMinWidth(70);
            jTable6.getColumnModel().getColumn(4).setPreferredWidth(70);
            jTable6.getColumnModel().getColumn(4).setMaxWidth(70);
            jTable6.getColumnModel().getColumn(4).setHeaderValue("Вибраний");
        }

        jPanel10.add(jScrollPane6);
        jScrollPane6.setBounds(0, 0, 610, 490);

        jComboBox7.setBackground(new java.awt.Color(240, 240, 240));
        jComboBox7.setFont(new java.awt.Font("Verdana", 0, 18)); // NOI18N
        jComboBox7.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "за номером", "за вагою", "за назвою" }));
        jComboBox7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBox7ActionPerformed(evt);
            }
        });
        jPanel10.add(jComboBox7);
        jComboBox7.setBounds(620, 20, 198, 25);

        jButton39.setBackground(new java.awt.Color(204, 204, 204));
        jButton39.setFont(new java.awt.Font("Verdana", 1, 14)); // NOI18N
        jButton39.setText("Поповнити склад");
        jButton39.setBorder(null);
        jButton39.setEnabled(false);
        jButton39.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jButton39.setMargin(new java.awt.Insets(2, 2, 2, 2));
        jButton39.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addToStorage(evt);
            }
        });
        jPanel10.add(jButton39);
        jButton39.setBounds(620, 190, 198, 48);

        jButton4.setBackground(new java.awt.Color(0, 153, 204));
        jButton4.setFont(new java.awt.Font("Verdana", 1, 14)); // NOI18N
        jButton4.setText("Показати склад");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });
        jPanel10.add(jButton4);
        jButton4.setBounds(620, 380, 190, 40);

        jButton41.setBackground(new java.awt.Color(255, 153, 153));
        jButton41.setFont(new java.awt.Font("Verdana", 1, 14)); // NOI18N
        jButton41.setText("Списання зі складу");
        jButton41.setBorder(null);
        jButton41.setEnabled(false);
        jButton41.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jButton41.setMargin(new java.awt.Insets(2, 2, 2, 2));
        jButton41.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton41addToStorage(evt);
            }
        });
        jPanel10.add(jButton41);
        jButton41.setBounds(620, 260, 198, 48);

        jButton43.setBackground(new java.awt.Color(102, 153, 255));
        jButton43.setFont(new java.awt.Font("Verdana", 1, 14)); // NOI18N
        jButton43.setText("Добавити товар");
        jButton43.setBorder(null);
        jButton43.setEnabled(false);
        jButton43.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jButton43.setMargin(new java.awt.Insets(2, 2, 2, 2));
        jButton43.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton43ActionPerformed(evt);
            }
        });
        jPanel10.add(jButton43);
        jButton43.setBounds(620, 80, 198, 48);

        jTabbedPane3.addTab("Склад", jPanel10);

        jPanel8.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jPanel8.setLayout(null);

        jTable12.setFont(new java.awt.Font("Verdana", 0, 18)); // NOI18N
        jTable12.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null},
                {null, null, null}
            },
            new String [] {
                "№", "Назва", "Вага"
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
        jTable12.setRowHeight(18);
        jScrollPane12.setViewportView(jTable12);
        if (jTable12.getColumnModel().getColumnCount() > 0) {
            jTable12.getColumnModel().getColumn(0).setMinWidth(50);
            jTable12.getColumnModel().getColumn(0).setPreferredWidth(50);
            jTable12.getColumnModel().getColumn(0).setMaxWidth(50);
            jTable12.getColumnModel().getColumn(2).setMinWidth(100);
            jTable12.getColumnModel().getColumn(2).setPreferredWidth(100);
            jTable12.getColumnModel().getColumn(2).setMaxWidth(100);
        }

        jPanel8.add(jScrollPane12);
        jScrollPane12.setBounds(0, 0, 600, 490);

        jComboBox10.setBackground(new java.awt.Color(240, 240, 240));
        jComboBox10.setFont(new java.awt.Font("Verdana", 0, 18)); // NOI18N
        jComboBox10.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "за номером", "за вагою", "за назвою" }));
        jComboBox10.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBox10ActionPerformed(evt);
            }
        });
        jPanel8.add(jComboBox10);
        jComboBox10.setBounds(630, 10, 198, 25);

        jButton9.setBackground(new java.awt.Color(0, 153, 204));
        jButton9.setFont(new java.awt.Font("Verdana", 1, 14)); // NOI18N
        jButton9.setText("Завантажити дані");
        jButton9.setMargin(new java.awt.Insets(2, 5, 2, 5));
        jButton9.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton9ActionPerformed(evt);
            }
        });
        jPanel8.add(jButton9);
        jButton9.setBounds(610, 410, 240, 40);

        jTabbedPane3.addTab("Історія складу", jPanel8);

        jPanel9.setLayout(null);

        jButton40.setBackground(new java.awt.Color(204, 204, 0));
        jButton40.setFont(new java.awt.Font("Verdana", 1, 14)); // NOI18N
        jButton40.setText("Оновити собівартість");
        jButton40.setToolTipText("");
        jButton40.setBorder(null);
        jButton40.setEnabled(false);
        jButton40.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jButton40.setMargin(new java.awt.Insets(2, 2, 2, 2));
        jButton40.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton40addToStorage(evt);
            }
        });
        jPanel9.add(jButton40);
        jButton40.setBounds(620, 180, 198, 48);
        jButton40.getAccessibleContext().setAccessibleName("");

        jComboBox11.setBackground(new java.awt.Color(240, 240, 240));
        jComboBox11.setFont(new java.awt.Font("Verdana", 0, 18)); // NOI18N
        jComboBox11.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "за номером", "за ціною", "за назвою" }));
        jComboBox11.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBox11ActionPerformed(evt);
            }
        });
        jPanel9.add(jComboBox11);
        jComboBox11.setBounds(620, 10, 198, 25);

        jTable14.setFont(new java.awt.Font("Verdana", 0, 18)); // NOI18N
        jTable14.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "№", "Назва", "Собівартість (грн)", "Вибраний"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.String.class, java.lang.Double.class, java.lang.Boolean.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, true, true
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jTable14.setRowHeight(18);
        jScrollPane14.setViewportView(jTable14);
        if (jTable14.getColumnModel().getColumnCount() > 0) {
            jTable14.getColumnModel().getColumn(0).setMinWidth(50);
            jTable14.getColumnModel().getColumn(0).setPreferredWidth(50);
            jTable14.getColumnModel().getColumn(0).setMaxWidth(50);
            jTable14.getColumnModel().getColumn(2).setMinWidth(110);
            jTable14.getColumnModel().getColumn(2).setPreferredWidth(110);
            jTable14.getColumnModel().getColumn(2).setMaxWidth(110);
            jTable14.getColumnModel().getColumn(3).setMinWidth(70);
            jTable14.getColumnModel().getColumn(3).setPreferredWidth(70);
            jTable14.getColumnModel().getColumn(3).setMaxWidth(70);
            jTable14.getColumnModel().getColumn(3).setHeaderValue("Вибраний");
        }

        jPanel9.add(jScrollPane14);
        jScrollPane14.setBounds(0, 0, 610, 490);

        jButton10.setBackground(new java.awt.Color(0, 153, 204));
        jButton10.setFont(new java.awt.Font("Verdana", 1, 14)); // NOI18N
        jButton10.setText("Показати склад");
        jButton10.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton10ActionPerformed(evt);
            }
        });
        jPanel9.add(jButton10);
        jButton10.setBounds(620, 400, 200, 40);

        jTabbedPane3.addTab("Собівартість", jPanel9);

        jPanel2.add(jTabbedPane3);
        jTabbedPane3.setBounds(0, 0, 1140, 530);

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
        jScrollPane5.setBounds(0, 50, 550, 640);

        jLabel17.setFont(new java.awt.Font("Verdana", 1, 18)); // NOI18N
        jLabel17.setForeground(new java.awt.Color(255, 51, 51));
        jLabel17.setText("Списані продукти");
        jPanel3.add(jLabel17);
        jLabel17.setBounds(120, 10, 220, 23);

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
        jScrollPane10.setBounds(550, 50, 590, 640);

        jLabel22.setFont(new java.awt.Font("Verdana", 1, 18)); // NOI18N
        jLabel22.setForeground(new java.awt.Color(255, 51, 51));
        jLabel22.setText("Приходи");
        jPanel3.add(jLabel22);
        jLabel22.setBounds(840, 10, 90, 23);

        jButton5.setBackground(new java.awt.Color(0, 153, 204));
        jButton5.setFont(new java.awt.Font("Verdana", 1, 14)); // NOI18N
        jButton5.setText("Показати приходи/списання");
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });
        jPanel3.add(jButton5);
        jButton5.setBounds(410, 10, 270, 27);

        jTabbedPane1.addTab("Продукти", jPanel3);

        jPanel7.addComponentListener(new java.awt.event.ComponentAdapter() {
            public void componentShown(java.awt.event.ComponentEvent evt) {
                jPanel7ComponentShown(evt);
            }
        });
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
        jScrollPane11.setBounds(0, 40, 830, 650);

        jLabel6.setFont(new java.awt.Font("Verdana", 1, 14)); // NOI18N
        jLabel6.setText("Дата");
        jPanel7.add(jLabel6);
        jLabel6.setBounds(840, 50, 60, 18);

        jPanel7.add(jComboBox3);
        jComboBox3.setBounds(900, 50, 140, 20);

        jToggleButton1.setText("Відкрити");
        jToggleButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                showRevizia(evt);
            }
        });
        jPanel7.add(jToggleButton1);
        jToggleButton1.setBounds(880, 90, 160, 40);

        jComboBox9.setBackground(new java.awt.Color(240, 240, 240));
        jComboBox9.setFont(new java.awt.Font("Verdana", 0, 18)); // NOI18N
        jComboBox9.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "за номером", "за різн.ваги", "за назвою" }));
        jComboBox9.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBox9ActionPerformed(evt);
            }
        });
        jPanel7.add(jComboBox9);
        jComboBox9.setBounds(40, 0, 145, 29);

        jLabel24.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jLabel24.setText("Вага стара - яка мала би бути");
        jPanel7.add(jLabel24);
        jLabel24.setBounds(210, 0, 240, 17);

        jLabel25.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jLabel25.setText("Вага нова - вага фактична яка є на складі");
        jPanel7.add(jLabel25);
        jLabel25.setBounds(210, 20, 280, 17);

        jTabbedPane1.addTab("Ревізія", jPanel7);

        jPanel4.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        jPanel4.addComponentListener(new java.awt.event.ComponentAdapter() {
            public void componentShown(java.awt.event.ComponentEvent evt) {
                jPanel4ComponentShown(evt);
            }
        });
        jPanel4.setLayout(null);

        jTable3.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
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
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Ім'я", "Сума", "Кіл. змін", "Кіл. пів змін"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.Integer.class, java.lang.Integer.class, java.lang.Integer.class
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
        jTable8.setRowHeight(20);
        jScrollPane8.setViewportView(jTable8);
        if (jTable8.getColumnModel().getColumnCount() > 0) {
            jTable8.getColumnModel().getColumn(1).setMinWidth(150);
            jTable8.getColumnModel().getColumn(1).setPreferredWidth(150);
            jTable8.getColumnModel().getColumn(1).setMaxWidth(150);
            jTable8.getColumnModel().getColumn(2).setMinWidth(75);
            jTable8.getColumnModel().getColumn(2).setPreferredWidth(75);
            jTable8.getColumnModel().getColumn(2).setMaxWidth(75);
            jTable8.getColumnModel().getColumn(3).setMinWidth(75);
            jTable8.getColumnModel().getColumn(3).setPreferredWidth(75);
            jTable8.getColumnModel().getColumn(3).setMaxWidth(75);
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

        jButton6.setBackground(new java.awt.Color(0, 153, 204));
        jButton6.setFont(new java.awt.Font("Verdana", 0, 14)); // NOI18N
        jButton6.setText("показати аванс");
        jButton6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton6ActionPerformed(evt);
            }
        });
        jPanel5.add(jButton6);
        jButton6.setBounds(660, 160, 150, 40);

        jButton7.setBackground(new java.awt.Color(0, 153, 204));
        jButton7.setFont(new java.awt.Font("Verdana", 0, 14)); // NOI18N
        jButton7.setText("показати інкас");
        jButton7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton7ActionPerformed(evt);
            }
        });
        jPanel5.add(jButton7);
        jButton7.setBounds(660, 370, 150, 40);

        jTabbedPane1.addTab("Загальна", jPanel5);

        jPanel6.setLayout(null);

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

        jPanel6.add(jScrollPane7);
        jScrollPane7.setBounds(0, 30, 900, 660);

        jComboBox8.setBackground(new java.awt.Color(240, 240, 240));
        jComboBox8.setFont(new java.awt.Font("Verdana", 0, 18)); // NOI18N
        jComboBox8.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "за назвою", "за кількістю" }));
        jComboBox8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                changeOrderedDishSort(evt);
            }
        });
        jPanel6.add(jComboBox8);
        jComboBox8.setBounds(220, 0, 198, 25);

        jLabel8.setFont(new java.awt.Font("Verdana", 1, 18)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(0, 153, 204));
        jLabel8.setText("Замовлені страви");
        jPanel6.add(jLabel8);
        jLabel8.setBounds(20, 0, 195, 23);

        jButton8.setBackground(new java.awt.Color(0, 153, 204));
        jButton8.setFont(new java.awt.Font("Verdana", 0, 14)); // NOI18N
        jButton8.setText("показати страви");
        jButton8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton8ActionPerformed(evt);
            }
        });
        jPanel6.add(jButton8);
        jButton8.setBounds(930, 600, 160, 40);

        jTabbedPane1.addTab("Замовлені страви", jPanel6);

        jPanel11.setLayout(null);

        jTabbedPane2.setBackground(new java.awt.Color(232, 232, 232));
        jTabbedPane2.setToolTipText("");
        jTabbedPane2.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N

        CategoriesPanel.setBackground(new java.awt.Color(67, 96, 156));
        CategoriesPanel.setToolTipText("");
        CategoriesPanel.setLayout(null);

        cat5.setBackground(new java.awt.Color(233, 234, 237));
        cat5.setFont(new java.awt.Font("Verdana", 0, 18)); // NOI18N
        cat5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/cafe/icons/christmas161.png"))); // NOI18N
        cat5.setText("<html>\n<br/>\n<br/>\n<br/>\n<br/>\n <br/> \n&nbsp;М'ясне</html>");
        cat5.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        cat5.setHorizontalTextPosition(javax.swing.SwingConstants.LEFT);
        cat5.setName("cat4"); // NOI18N
        cat5.setVerticalAlignment(javax.swing.SwingConstants.TOP);
        cat5.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                chooseCat(evt);
            }
        });
        CategoriesPanel.add(cat5);
        cat5.setBounds(210, 230, 160, 160);

        cat6.setBackground(new java.awt.Color(233, 234, 237));
        cat6.setFont(new java.awt.Font("Verdana", 0, 18)); // NOI18N
        cat6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/cafe/icons/italian1.png"))); // NOI18N
        cat6.setText("<html>  \n<br/> \n<br/> \n<br/> \n<br/>  \n<br/>  \n&nbsp;Піцца</html>");
        cat6.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        cat6.setHorizontalTextPosition(javax.swing.SwingConstants.LEFT);
        cat6.setName("cat5"); // NOI18N
        cat6.setVerticalAlignment(javax.swing.SwingConstants.TOP);
        cat6.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                chooseCat(evt);
            }
        });
        CategoriesPanel.add(cat6);
        cat6.setBounds(370, 230, 160, 160);

        cat7.setBackground(new java.awt.Color(233, 234, 237));
        cat7.setFont(new java.awt.Font("Verdana", 0, 18)); // NOI18N
        cat7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/cafe/icons/sushi6.png"))); // NOI18N
        cat7.setText("<html>  \n<br/> \n<br/> \n<br/> \n<br/>  \n<br/>  \n&nbsp;Суші</html>");
        cat7.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        cat7.setHorizontalTextPosition(javax.swing.SwingConstants.LEFT);
        cat7.setName("cat6"); // NOI18N
        cat7.setVerticalAlignment(javax.swing.SwingConstants.TOP);
        cat7.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                chooseCat(evt);
            }
        });
        CategoriesPanel.add(cat7);
        cat7.setBounds(530, 230, 160, 160);

        cat8.setBackground(new java.awt.Color(233, 234, 237));
        cat8.setFont(new java.awt.Font("Verdana", 0, 18)); // NOI18N
        cat8.setIcon(new javax.swing.ImageIcon(getClass().getResource("/cafe/icons/ice53.png"))); // NOI18N
        cat8.setText("<html>  \n<br/> \n<br/> \n<br/> \n<br/>  \n<br/>  \n&nbsp;Десерт</html>");
        cat8.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        cat8.setHorizontalTextPosition(javax.swing.SwingConstants.LEFT);
        cat8.setName("cat7"); // NOI18N
        cat8.setVerticalAlignment(javax.swing.SwingConstants.TOP);
        cat8.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                chooseCat(evt);
            }
        });
        CategoriesPanel.add(cat8);
        cat8.setBounds(690, 230, 160, 160);

        cat3.setBackground(new java.awt.Color(233, 234, 237));
        cat3.setFont(new java.awt.Font("Verdana", 0, 18)); // NOI18N
        cat3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/cafe/icons/burger.png"))); // NOI18N
        cat3.setText("<html>  \n<br/> \n<br/> \n<br/>    \n<br/>\n<br/>\nСтрави&nbsp;Роджера</html> ");
        cat3.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        cat3.setHorizontalTextPosition(javax.swing.SwingConstants.LEFT);
        cat3.setName("cat2"); // NOI18N
        cat3.setVerticalAlignment(javax.swing.SwingConstants.TOP);
        cat3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                chooseCat(evt);
            }
        });
        CategoriesPanel.add(cat3);
        cat3.setBounds(530, 70, 160, 160);

        cat4.setBackground(new java.awt.Color(233, 234, 237));
        cat4.setFont(new java.awt.Font("Verdana", 0, 18)); // NOI18N
        cat4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/cafe/icons/fryingpan1.png"))); // NOI18N
        cat4.setText("<html>  \n<br/> \n<br/> \n<br/>    \n<br/>\n&nbsp;Страви  <br/>  \n&nbsp;на&nbsp;пательні</html>");
        cat4.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        cat4.setHorizontalTextPosition(javax.swing.SwingConstants.LEFT);
        cat4.setName("cat3"); // NOI18N
        cat4.setVerticalAlignment(javax.swing.SwingConstants.TOP);
        cat4.setVerticalTextPosition(javax.swing.SwingConstants.TOP);
        cat4.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                chooseCat(evt);
            }
        });
        CategoriesPanel.add(cat4);
        cat4.setBounds(690, 70, 160, 160);

        cat2.setBackground(new java.awt.Color(233, 234, 237));
        cat2.setFont(new java.awt.Font("Verdana", 0, 18)); // NOI18N
        cat2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/cafe/icons/salad.png"))); // NOI18N
        cat2.setText("<html>  \n<br/> \n<br/> \n<br/> \n<br/>  \n<br/>  \n&nbsp;Салати</html>");
        cat2.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        cat2.setHorizontalTextPosition(javax.swing.SwingConstants.LEFT);
        cat2.setName("cat1"); // NOI18N
        cat2.setVerticalAlignment(javax.swing.SwingConstants.TOP);
        cat2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                chooseCat(evt);
            }
        });
        CategoriesPanel.add(cat2);
        cat2.setBounds(370, 70, 160, 160);

        cat1.setBackground(new java.awt.Color(233, 234, 237));
        cat1.setFont(new java.awt.Font("Verdana", 0, 18)); // NOI18N
        cat1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/cafe/icons/hot-food.png"))); // NOI18N
        cat1.setText("<html>  \n<br/> \n<br/> \n<br/> \n<br/>  \n<br/>  \n&nbsp;1, 2 страви</html>");
        cat1.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        cat1.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        cat1.setName("cat0"); // NOI18N
        cat1.setVerticalAlignment(javax.swing.SwingConstants.TOP);
        cat1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                chooseCat(evt);
            }
        });
        CategoriesPanel.add(cat1);
        cat1.setBounds(210, 70, 160, 160);

        cat9.setBackground(new java.awt.Color(233, 234, 237));
        cat9.setFont(new java.awt.Font("Verdana", 0, 18)); // NOI18N
        cat9.setIcon(new javax.swing.ImageIcon(getClass().getResource("/cafe/icons/coffee127.png"))); // NOI18N
        cat9.setText("<html>  \n<br/> \n<br/> \n<br/> \n<br/>  \n<br/> \n&nbsp;Напої</html>");
        cat9.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        cat9.setHorizontalTextPosition(javax.swing.SwingConstants.LEFT);
        cat9.setName("cat8"); // NOI18N
        cat9.setVerticalAlignment(javax.swing.SwingConstants.TOP);
        cat9.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                chooseCat(evt);
            }
        });
        CategoriesPanel.add(cat9);
        cat9.setBounds(210, 390, 160, 160);

        cat10.setBackground(new java.awt.Color(233, 234, 237));
        cat10.setFont(new java.awt.Font("Verdana", 0, 18)); // NOI18N
        cat10.setIcon(new javax.swing.ImageIcon(getClass().getResource("/cafe/icons/beer.png"))); // NOI18N
        cat10.setText("<html>   <br/>  <br/>  <br/>  <br/>   <br/>&nbsp;  Пиво</html>");
        cat10.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        cat10.setHorizontalTextPosition(javax.swing.SwingConstants.LEFT);
        cat10.setName("cat9"); // NOI18N
        cat10.setVerticalAlignment(javax.swing.SwingConstants.TOP);
        cat10.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                chooseCat(evt);
            }
        });
        CategoriesPanel.add(cat10);
        cat10.setBounds(370, 390, 160, 160);
        cat10.getAccessibleContext().setAccessibleName("<html>   <br/>  <br/>  <br/>  <br/>   <br/>  &nbsp;Пиво</html>");

        cat11.setBackground(new java.awt.Color(233, 234, 237));
        cat11.setFont(new java.awt.Font("Verdana", 0, 18)); // NOI18N
        cat11.setIcon(new javax.swing.ImageIcon(getClass().getResource("/cafe/icons/drink175.png"))); // NOI18N
        cat11.setText("<html>   <br/>  <br/>  <br/>  <br/>   <br/>   &nbsp;Алкоголь</html>");
        cat11.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        cat11.setHorizontalTextPosition(javax.swing.SwingConstants.LEFT);
        cat11.setName("cat10"); // NOI18N
        cat11.setVerticalAlignment(javax.swing.SwingConstants.TOP);
        cat11.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                chooseCat(evt);
            }
        });
        CategoriesPanel.add(cat11);
        cat11.setBounds(530, 390, 160, 160);

        cat12.setBackground(new java.awt.Color(233, 234, 237));
        cat12.setFont(new java.awt.Font("Verdana", 0, 18)); // NOI18N
        cat12.setIcon(new javax.swing.ImageIcon(getClass().getResource("/cafe/icons/no-drink.png"))); // NOI18N
        cat12.setText("<html>   <br/>  <br/>  <br/> <br/>    <br/>  &nbspБезал.<br/>  </html>");
        cat12.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        cat12.setHorizontalTextPosition(javax.swing.SwingConstants.LEFT);
        cat12.setName("cat11"); // NOI18N
        cat12.setVerticalAlignment(javax.swing.SwingConstants.TOP);
        cat12.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                chooseCat(evt);
            }
        });
        CategoriesPanel.add(cat12);
        cat12.setBounds(690, 390, 160, 160);

        jTabbedPane2.addTab("Категорії", null, CategoriesPanel, "");

        DishesPanel.setBackground(new java.awt.Color(233, 234, 237));
        DishesPanel.setEnabled(false);
        DishesPanel.setFocusable(false);
        DishesPanel.setLayout(null);

        jTable15.setFont(new java.awt.Font("Verdana", 0, 18)); // NOI18N
        jTable15.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "№", "Назва", "Собівартість (грн)", "Ціна в меню(грн)"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.String.class, java.lang.String.class, java.lang.Double.class
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
        jTable15.setRowHeight(18);
        jTable15.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jTable15MousePressed(evt);
            }
        });
        jTable15.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jTable15KeyReleased(evt);
            }
        });
        jScrollPane15.setViewportView(jTable15);
        if (jTable15.getColumnModel().getColumnCount() > 0) {
            jTable15.getColumnModel().getColumn(0).setMinWidth(50);
            jTable15.getColumnModel().getColumn(0).setPreferredWidth(50);
            jTable15.getColumnModel().getColumn(0).setMaxWidth(50);
            jTable15.getColumnModel().getColumn(2).setMinWidth(110);
            jTable15.getColumnModel().getColumn(2).setPreferredWidth(110);
            jTable15.getColumnModel().getColumn(2).setMaxWidth(110);
            jTable15.getColumnModel().getColumn(3).setMinWidth(100);
            jTable15.getColumnModel().getColumn(3).setPreferredWidth(100);
            jTable15.getColumnModel().getColumn(3).setMaxWidth(100);
        }

        DishesPanel.add(jScrollPane15);
        jScrollPane15.setBounds(0, 0, 710, 490);

        jCheckBox3.setFont(new java.awt.Font("Verdana", 0, 14)); // NOI18N
        jCheckBox3.setText("страва");
        DishesPanel.add(jCheckBox3);
        jCheckBox3.setBounds(10, 600, 130, 27);

        jCheckBox2.setBackground(new java.awt.Color(255, 102, 102));
        jCheckBox2.setFont(new java.awt.Font("Verdana", 0, 18)); // NOI18N
        jCheckBox2.setText("велика піцца");
        jCheckBox2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCheckBox2changePizzaSize(evt);
            }
        });
        DishesPanel.add(jCheckBox2);
        jCheckBox2.setBounds(10, 560, 150, 31);

        jComboBox4.setBackground(new java.awt.Color(240, 240, 240));
        jComboBox4.setFont(new java.awt.Font("Verdana", 0, 14)); // NOI18N
        jComboBox4.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "як в меню", "за ціною", "за назвою" }));
        jComboBox4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBox4ActionPerformed(evt);
            }
        });
        DishesPanel.add(jComboBox4);
        jComboBox4.setBounds(10, 520, 120, 30);

        jLabel30.setFont(new java.awt.Font("Verdana", 0, 14)); // NOI18N
        jLabel30.setText("Сортування:");
        DishesPanel.add(jLabel30);
        jLabel30.setBounds(10, 500, 120, 18);

        jLabel31.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        jLabel31.setText(" Назва");
        DishesPanel.add(jLabel31);
        jLabel31.setBounds(140, 500, 90, 16);

        jTextField4.setFont(new java.awt.Font("Verdana", 0, 14)); // NOI18N
        DishesPanel.add(jTextField4);
        jTextField4.setBounds(140, 520, 360, 30);

        jLabel32.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        jLabel32.setText("Ціна");
        DishesPanel.add(jLabel32);
        jLabel32.setBounds(500, 500, 60, 16);

        jTextField2.setFont(new java.awt.Font("Verdana", 0, 14)); // NOI18N
        jTextField2.setText("0");
        DishesPanel.add(jTextField2);
        jTextField2.setBounds(500, 520, 80, 30);

        jButton12.setBackground(new java.awt.Color(102, 153, 255));
        jButton12.setFont(new java.awt.Font("Verdana", 1, 12)); // NOI18N
        jButton12.setText("<html>&nbsp;оновити<br/>  калькул.</html>\n");
        jButton12.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jButton12.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jButton12.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton12refreshCalc(evt);
            }
        });
        DishesPanel.add(jButton12);
        jButton12.setBounds(510, 560, 70, 70);

        jButton19.setBackground(new java.awt.Color(204, 204, 0));
        jButton19.setFont(new java.awt.Font("Verdana", 1, 12)); // NOI18N
        jButton19.setText("<html>&nbsp;&nbsp;оновити<br/>&nbsp;&nbsp; страву </html>\n");
        jButton19.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jButton19.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jButton19.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton19updateTitleAndPrice(evt);
            }
        });
        DishesPanel.add(jButton19);
        jButton19.setBounds(440, 560, 70, 70);

        jButton13.setBackground(new java.awt.Color(255, 102, 102));
        jButton13.setFont(new java.awt.Font("Verdana", 1, 12)); // NOI18N
        jButton13.setText("<html>видалити<br/>&nbsp; страву </html> ");
        jButton13.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jButton13.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton13removeDish(evt);
            }
        });
        DishesPanel.add(jButton13);
        jButton13.setBounds(370, 560, 70, 70);

        jButton14.setBackground(new java.awt.Color(51, 204, 0));
        jButton14.setFont(new java.awt.Font("Verdana", 1, 12)); // NOI18N
        jButton14.setText("<html>&nbsp;&nbsp;додати<br/>&nbsp; страву </html> ");
        jButton14.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jButton14.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton14addDish(evt);
            }
        });
        DishesPanel.add(jButton14);
        jButton14.setBounds(300, 560, 70, 70);

        jTabbedPane2.addTab("Страви", DishesPanel);

        jPanel12.setLayout(null);

        jTable13.setFont(new java.awt.Font("Verdana", 0, 18)); // NOI18N
        jTable13.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "№", "Назва", "Вага ( кг/ шт )", "Вибраний"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.String.class, java.lang.Double.class, java.lang.Boolean.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, true, true
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jTable13.setFocusable(false);
        jTable13.setRowHeight(20);
        jScrollPane13.setViewportView(jTable13);
        if (jTable13.getColumnModel().getColumnCount() > 0) {
            jTable13.getColumnModel().getColumn(0).setMinWidth(50);
            jTable13.getColumnModel().getColumn(0).setPreferredWidth(50);
            jTable13.getColumnModel().getColumn(0).setMaxWidth(50);
            jTable13.getColumnModel().getColumn(2).setMinWidth(100);
            jTable13.getColumnModel().getColumn(2).setPreferredWidth(100);
            jTable13.getColumnModel().getColumn(2).setMaxWidth(100);
            jTable13.getColumnModel().getColumn(3).setMinWidth(100);
            jTable13.getColumnModel().getColumn(3).setPreferredWidth(100);
            jTable13.getColumnModel().getColumn(3).setMaxWidth(100);
        }

        jPanel12.add(jScrollPane13);
        jScrollPane13.setBounds(0, 30, 900, 620);

        jButton42.setBackground(new java.awt.Color(153, 153, 255));
        jButton42.setFont(new java.awt.Font("Verdana", 0, 14)); // NOI18N
        jButton42.setText("<html> &nbsp; &nbsp; &nbsp; &nbsp;зберегти<br/>  зміни кальукуляції</html> ");
        jButton42.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jButton42.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jButton42.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton42saveCalculation(evt);
            }
        });
        jPanel12.add(jButton42);
        jButton42.setBounds(910, 430, 200, 70);

        jLabel33.setFont(new java.awt.Font("Verdana", 1, 18)); // NOI18N
        jLabel33.setForeground(new java.awt.Color(0, 153, 204));
        jLabel33.setText("назва страви");
        jLabel33.setToolTipText("");
        jPanel12.add(jLabel33);
        jLabel33.setBounds(20, 0, 880, 23);

        jComboBox6.setBackground(new java.awt.Color(240, 240, 240));
        jComboBox6.setFont(new java.awt.Font("Verdana", 0, 14)); // NOI18N
        jComboBox6.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "за номером", "за вагою", "за назвою" }));
        jComboBox6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBox6ActionPerformed(evt);
            }
        });
        jPanel12.add(jComboBox6);
        jComboBox6.setBounds(910, 60, 198, 30);

        jLabel34.setFont(new java.awt.Font("Verdana", 0, 14)); // NOI18N
        jLabel34.setText("Сортування:");
        jPanel12.add(jLabel34);
        jLabel34.setBounds(960, 40, 120, 18);

        jTabbedPane2.addTab("Калькуляція", jPanel12);

        jPanel11.add(jTabbedPane2);
        jTabbedPane2.setBounds(0, 0, 1120, 690);

        jTabbedPane1.addTab("Меню", jPanel11);

        getContentPane().add(jTabbedPane1);
        jTabbedPane1.setBounds(220, 0, 1150, 730);

        jLabel10.setFont(new java.awt.Font("Verdana", 1, 14)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(0, 153, 0));
        jLabel10.setText("0");
        jLabel10.setFocusable(false);
        jLabel10.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
        getContentPane().add(jLabel10);
        jLabel10.setBounds(140, 340, 80, 18);

        jLabel16.setFont(new java.awt.Font("Verdana", 1, 14)); // NOI18N
        jLabel16.setForeground(new java.awt.Color(0, 153, 0));
        jLabel16.setText("Заг. кіл. страв:");
        getContentPane().add(jLabel16);
        jLabel16.setBounds(0, 340, 160, 18);

        jLabel14.setFont(new java.awt.Font("Verdana", 1, 14)); // NOI18N
        jLabel14.setForeground(new java.awt.Color(0, 153, 204));
        jLabel14.setText("Сума в касі:");
        getContentPane().add(jLabel14);
        jLabel14.setBounds(0, 320, 140, 18);

        jLabel18.setFont(new java.awt.Font("Verdana", 1, 14)); // NOI18N
        jLabel18.setForeground(new java.awt.Color(255, 51, 51));
        jLabel18.setText("Аванс:");
        getContentPane().add(jLabel18);
        jLabel18.setBounds(0, 300, 140, 18);

        jLabel11.setFont(new java.awt.Font("Verdana", 1, 14)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(255, 51, 51));
        jLabel11.setText("Інкасація:");
        getContentPane().add(jLabel11);
        jLabel11.setBounds(0, 280, 140, 18);

        jLabel7.setFont(new java.awt.Font("Verdana", 1, 14)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(0, 153, 0));
        jLabel7.setText("Заг. каса:");
        getContentPane().add(jLabel7);
        jLabel7.setBounds(0, 260, 140, 18);

        jLabel9.setFont(new java.awt.Font("Verdana", 1, 14)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(0, 153, 0));
        jLabel9.setText("0");
        jLabel9.setFocusable(false);
        jLabel9.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
        getContentPane().add(jLabel9);
        jLabel9.setBounds(140, 260, 80, 23);

        jLabel13.setFont(new java.awt.Font("Verdana", 1, 14)); // NOI18N
        jLabel13.setForeground(new java.awt.Color(255, 51, 51));
        jLabel13.setText("-0");
        jLabel13.setFocusable(false);
        jLabel13.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
        getContentPane().add(jLabel13);
        jLabel13.setBounds(140, 280, 80, 18);

        jLabel19.setFont(new java.awt.Font("Verdana", 1, 14)); // NOI18N
        jLabel19.setForeground(new java.awt.Color(255, 51, 51));
        jLabel19.setText("-0");
        jLabel19.setFocusable(false);
        jLabel19.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
        getContentPane().add(jLabel19);
        jLabel19.setBounds(140, 300, 80, 18);

        jLabel15.setFont(new java.awt.Font("Verdana", 1, 14)); // NOI18N
        jLabel15.setForeground(new java.awt.Color(0, 153, 204));
        jLabel15.setText("0");
        jLabel15.setFocusable(false);
        jLabel15.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
        getContentPane().add(jLabel15);
        jLabel15.setBounds(140, 320, 80, 18);

        jTable4.setFont(new java.awt.Font("Verdana", 0, 14)); // NOI18N
        jTable4.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null},
                {null, null},
                {null, null},
                {null, null},
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
        jScrollPane4.setBounds(0, 360, 220, 150);

        jLabel23.setText("Є підключенення до");
        getContentPane().add(jLabel23);
        jLabel23.setBounds(10, 170, 210, 14);

        jCheckBox1.setText("Знаходжусь в даному кафе");
        jCheckBox1.setToolTipText("");
        getContentPane().add(jCheckBox1);
        jCheckBox1.setBounds(4, 74, 210, 20);

        jLabel26.setFont(new java.awt.Font("Verdana", 1, 14)); // NOI18N
        jLabel26.setForeground(new java.awt.Color(102, 102, 255));
        jLabel26.setText("Безнал. каса:");
        getContentPane().add(jLabel26);
        jLabel26.setBounds(0, 240, 130, 18);

        jLabel27.setFont(new java.awt.Font("Verdana", 1, 14)); // NOI18N
        jLabel27.setForeground(new java.awt.Color(102, 102, 255));
        jLabel27.setText("0");
        jLabel27.setFocusable(false);
        jLabel27.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
        getContentPane().add(jLabel27);
        jLabel27.setBounds(140, 240, 80, 23);

        jLabel28.setFont(new java.awt.Font("Verdana", 1, 14)); // NOI18N
        jLabel28.setForeground(new java.awt.Color(0, 204, 102));
        jLabel28.setText("Готівка:");
        getContentPane().add(jLabel28);
        jLabel28.setBounds(0, 220, 130, 18);

        jLabel29.setFont(new java.awt.Font("Verdana", 1, 14)); // NOI18N
        jLabel29.setForeground(new java.awt.Color(0, 204, 102));
        jLabel29.setText("0");
        jLabel29.setFocusable(false);
        jLabel29.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
        getContentPane().add(jLabel29);
        jLabel29.setBounds(140, 220, 80, 23);

        jButton11.setBackground(new java.awt.Color(0, 153, 204));
        jButton11.setFont(new java.awt.Font("Verdana", 1, 14)); // NOI18N
        jButton11.setText("Показати касу");
        jButton11.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton11ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton11);
        jButton11.setBounds(0, 510, 220, 50);

        setSize(new java.awt.Dimension(1384, 770));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

 

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
    
    private boolean validInputDates(){
            if (jXDatePicker1.getDate() != null && jXDatePicker2.getDate() != null && jComboBox1.getSelectedIndex() >= 0) {
//                if (DBUtils.getHost(cafeId).equalsIgnoreCase(HOSTS.get(4))) {
//                    startDate = new java.sql.Timestamp((jXDatePicker1.getDate().getTime() + EIGHT_HOURS));
//                    endDate = new java.sql.Timestamp(jXDatePicker2.getDate().getTime() + ONE_DAY_PLUS_EIGHT_HOURS);
//                }else{
                    startDate = new java.sql.Timestamp((jXDatePicker1.getDate().getTime() + SIX_HOURS));
                    endDate = new java.sql.Timestamp(jXDatePicker2.getDate().getTime() + ONE_DAY_PLUS_THREE_HOURS);
//                }
                return true;
            } else {
                DBUtils.showMessage("Задані дати введено не корректно, спробуйте задати дати");
                return false;
            }
    }

    private void getAllOrders(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_getAllOrders
        if (validInputDates()) {
            jTable1.setEnabled(true);
            jComboBox2.setEnabled(true);                             
            //show all data
            orders.clear();
            
            try {
                UsersUtils.readAllUsers();
                User.active = 5;
                refreshReviziaDates();

                EmployeeUtils.readAllEmployees();
                orders.addAll(OrderUtils.getOrdersBetween(startDate, endDate));

                refreshOrderTable(jTable1, orders);

                getEmployeeFullWorksDay(startDate, endDate);
                getEmployeeHalfWorksDay(startDate, endDate);
                getStorageTable();
                refreshRemovedIngTable();
                refreshAddedIngTable();
                showOrderedDishes();
                //awans
                getEmployeeKeyMoney();
                getInkass();
                showUserKasa();
                refreshBarmensTable();
                log.debug("orders list size = " + orders.size());
            } catch (Exception e) {
                DBUtils.showInfo("Проблеми зі зєднання, спробуйте ще раз");
            }         
            jButton2.setEnabled(true);
            jButton39.setEnabled(true);
            jButton41.setEnabled(true);
            jButton43.setEnabled(true);
        }
    }//GEN-LAST:event_getAllOrders

    private void clearAllForms(){
        jLabel27.setText("0");
        jLabel13.setText("-0");
        jLabel19.setText("-0");
        jLabel15.setText("0");
        jLabel10.setText("0");
        jLabel29.setText("0");
        jLabel9.setText("0");
        
        jCheckBox2.setVisible(false);
        jTabbedPane2.setEnabledAt(1, false);
        jTabbedPane2.setEnabledAt(2, false);
        
        jButton39.setEnabled(false);
        jButton41.setEnabled(false);
        jButton43.setEnabled(false);
        
        ((DefaultTableModel)jTable4.getModel()).setRowCount(0);
        ((DefaultTableModel)jTable1.getModel()).setRowCount(0);
        ((DefaultTableModel)jTable2.getModel()).setRowCount(0);
        ((DefaultTableModel)jTable6.getModel()).setRowCount(0);
        ((DefaultTableModel)jTable5.getModel()).setRowCount(0);
        ((DefaultTableModel)jTable10.getModel()).setRowCount(0);
        ((DefaultTableModel)jTable11.getModel()).setRowCount(0);
        ((DefaultTableModel)jTable8.getModel()).setRowCount(0);
        ((DefaultTableModel)jTable9.getModel()).setRowCount(0);
        ((DefaultTableModel)jTable7.getModel()).setRowCount(0);
        ((DefaultTableModel)jTable12.getModel()).setRowCount(0);
        ((DefaultTableModel)jTable14.getModel()).setRowCount(0);
        ((DefaultTableModel)jTable15.getModel()).setRowCount(0);
        ((DefaultTableModel)jTable13.getModel()).setRowCount(0);
    }

    private  void addStorageListener(){
        jTable6.getModel().addTableModelListener(new TableModelListener() {

            @Override
            public void tableChanged(TableModelEvent e) {
                System.out.println("changed");
                MainForm.validateCell(jTable6, 3);
            }
        });
     
    } 
    
    
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
        clearAllForms();
        cafeId = jComboBox1.getSelectedIndex();
        if (jCheckBox1.isSelected()) {                   
            isLocalHost = true;
        }else{            
            isLocalHost = false;
        }       
        chooseServer(cafeId);
        tryConnectToCafe();      
        
        MainForm.initBDmenu();
    }//GEN-LAST:event_chooseCafe

    private boolean tryConnectToCafe() {  
        if (DBUtils.checkConnection(cafeId)) {
            jLabel23.setText("Є підключення до " + servers.get(cafeId));
            log.debug("DB Connection " + serverArray[cafeId]);
            jLabel23.setForeground(GREEN);
            jTabbedPane1.setEnabled(true);
            return true;                
        }else{
            jLabel23.setText("Немає підключення до " + servers.get(cafeId));
            log.debug("ERROR DB Connection " + serverArray[cafeId]);
            jLabel23.setForeground(RED);
            jTabbedPane1.setEnabled(false);
            return false;
       }   
    }

    private void addToStorage(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addToStorage
        StorageUtils.readStorage();
        setSort(jComboBox7, jTable6, storageList);
        UsersUtils.readAllUsers();
        MainForm.addIngCountToStorage(jTable6, 3);
        StorageUtils.readStorage();
        setSort(jComboBox7, jTable6, storageList);
        showStorageStatisticTable(jTable6);
    }//GEN-LAST:event_addToStorage

    private void jComboBox7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBox7ActionPerformed
        setSort(jComboBox7, jTable6, storageList);
        showStorageStatisticTable(jTable6);
        System.out.println("change sort storageList  ");
    }//GEN-LAST:event_jComboBox7ActionPerformed

    private void changeOrderedDishSort(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_changeOrderedDishSort
        setSort(jComboBox8, jTable7, storageList);
        sortListOfOrderItems(orderedDishes, jComboBox8.getSelectedIndex());
        refreshDishesTable();
    }//GEN-LAST:event_changeOrderedDishSort

    private void showRevizia(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_showRevizia
        showReviziaa("ingredient_id");  
        jComboBox9.setSelectedIndex(0);

    }//GEN-LAST:event_showRevizia
    
    
    private void showReviziaa(String orderCriteria){
        Timestamp date = new java.sql.Timestamp(((Date) jComboBox3.getSelectedItem()).getTime());
        DefaultTableModel model = (DefaultTableModel) jTable11.getModel();
        model.setRowCount(0);
        List<ReviziaItem> revizia = ReviziaUtils.getReviziaByDate(date, orderCriteria);
        for (ReviziaItem item : revizia) {
            model.addRow(new Object[]{
                item.getId(),
                getIngTitleById(item.getId()),
                item.getOldCount(),
                item.getNewCount(),
                item.getDiffCount()
            });

        }
    }
    
    
    private void jComboBox9ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBox9ActionPerformed
           int index = jComboBox9.getSelectedIndex();
           if (index == 0) {
               showReviziaa("ingredient_id");            
            }else if (index == 1) {                
                showReviziaa("diff_count");            
            }else if (index == 2) {
                showReviziaa("title");            
        }     
    }//GEN-LAST:event_jComboBox9ActionPerformed

    private void jPanel2KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jPanel2KeyPressed
        System.out.println("111");        // TODO add your handling code here:
    }//GEN-LAST:event_jPanel2KeyPressed

    private void jButton3getAllOrders(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3getAllOrders
        if (validInputDates()) {
            orders.clear();
            orders.addAll(OrderUtils.getOrdersBetween(startDate, endDate));
            refreshOrderTable(jTable1, orders);
        }
    }//GEN-LAST:event_jButton3getAllOrders

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        if (validInputDates()) {
            getStorageTable();     
            jButton39.setEnabled(true);
            jButton41.setEnabled(true);
            jButton43.setEnabled(true);
        }
    }//GEN-LAST:event_jButton4ActionPerformed

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
        if (validInputDates()) {
            refreshRemovedIngTable();
            refreshAddedIngTable(); 
        }
    }//GEN-LAST:event_jButton5ActionPerformed

    private void jButton6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton6ActionPerformed
        if (validInputDates()) {
            EmployeeUtils.readAllEmployees();
            getEmployeeFullWorksDay(startDate, endDate);
            getEmployeeHalfWorksDay(startDate, endDate);
            refreshReviziaDates();
            getEmployeeKeyMoney();
        }
    }//GEN-LAST:event_jButton6ActionPerformed

    private void jButton7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton7ActionPerformed
        if (validInputDates()) {
            getInkass();
        }
    }//GEN-LAST:event_jButton7ActionPerformed

    private void jButton8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton8ActionPerformed
        if (validInputDates()) {
            showOrderedDishes();
        }
    }//GEN-LAST:event_jButton8ActionPerformed

    private void jPanel7ComponentShown(java.awt.event.ComponentEvent evt) {//GEN-FIRST:event_jPanel7ComponentShown
        // TODO add your handling code here:
        refreshReviziaDates();
    }//GEN-LAST:event_jPanel7ComponentShown

    private void jTabbedPane1ComponentShown(java.awt.event.ComponentEvent evt) {//GEN-FIRST:event_jTabbedPane1ComponentShown
        // TODO add your handling code here:
    }//GEN-LAST:event_jTabbedPane1ComponentShown

    private void jPanel4ComponentShown(java.awt.event.ComponentEvent evt) {//GEN-FIRST:event_jPanel4ComponentShown
        // TODO add your handling code here:
        jButton2.setEnabled(true);
    }//GEN-LAST:event_jPanel4ComponentShown

    private void jXDatePicker2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jXDatePicker2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jXDatePicker2ActionPerformed

    private void jButton9ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton9ActionPerformed
        // read data from storage history by dates
        jTable12.setToolTipText("Стовпчик вага \n"
                + "показує сумарну вагу/кількість \n"
                + "використаних продуктів \n"
                + "в замовленнях \n"
                + "в даному терміні");
        if (validInputDates()) {
            StorageUtils.readStorageOrderHistory(startDate, endDate);
            for (Ingredient ing : MainForm.storageDiffList) {
                ing.setTitle(getIngTitleById(ing.getId()));
            }

            DefaultTableModel model = (DefaultTableModel) jTable12.getModel();
            model.setRowCount(0);
            sortListOfIngredients(MainForm.storageDiffList, 0);
            for (Ingredient ing : MainForm.storageDiffList) {
                model.addRow(new Object[]{
                    ing.getId(),
                    ing.getTitle(),
                    ing.getCount()
                });
            }
        }
    }//GEN-LAST:event_jButton9ActionPerformed

    private void jComboBox10ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBox10ActionPerformed
        setSort(jComboBox10, jTable12, MainForm.storageDiffList);
        DefaultTableModel model = (DefaultTableModel) jTable12.getModel();
        model.setRowCount(0);
            for (Ingredient ingredient : MainForm.storageDiffList) {
                model.addRow(new Object[]{
                    ingredient.getId(),
                    ingredient.getTitle(),
                    ingredient.getCount()
                });
            }
        System.out.println("change sort storageDiffList  ");
    }//GEN-LAST:event_jComboBox10ActionPerformed

    private void jButton40addToStorage(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton40addToStorage
        StorageUtils.readStorage();
        setSort(jComboBox11, jTable14, storageList);
        UsersUtils.readAllUsers();
        MainForm.updateStorageCost(jTable14, 2);
        StorageUtils.readStorage();
        setSort(jComboBox11, jTable14, storageList);
        showStorageCostTable(jTable14);
    }//GEN-LAST:event_jButton40addToStorage

    private void jComboBox11ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBox11ActionPerformed
        setSort(jComboBox11, jTable14, storageList);
        showStorageCostTable(jTable14);
    }//GEN-LAST:event_jComboBox11ActionPerformed

    private void jButton10ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton10ActionPerformed
        StorageUtils.readStorage();
        setSort(jComboBox11, jTable14, storageList);
        showStorageCostTable(jTable14);
        jButton40.setEnabled(true);
    }//GEN-LAST:event_jButton10ActionPerformed

    private void chooseCat(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_chooseCat
        jTabbedPane2.setEnabledAt(1, true);
        jTabbedPane2.setSelectedIndex(1);

        int catId = MainForm.getButtonId(evt);
        jCheckBox2.setVisible(catId == 5 ? true : false);
        if (catId > 5) {
            catId++;
        }
        MainForm.menu.get(catId).getDishes().forEach(this::updateDishCost);
        showDishesTable(jTable15, MainForm.menu.get(catId).getDishes());
        MainForm.activeCat = catId;
        
        jCheckBox2.setBackground(RED);
        jCheckBox2.setSelected(false);
    }//GEN-LAST:event_chooseCat

    private void jButton11ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton11ActionPerformed
        if (validInputDates()) {
            UsersUtils.readAllUsers();
            User.active = 5;
            showUserKasa();
            refreshBarmensTable();
        }
    }//GEN-LAST:event_jButton11ActionPerformed

    private void jButton41addToStorage(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton41addToStorage
        StorageUtils.readStorage();
        setSort(jComboBox7, jTable6, storageList);
        UsersUtils.readAllUsers();
        MainForm.removeIngCountFromStorage(jTable6, 3);
        StorageUtils.readStorage();
        setSort(jComboBox7, jTable6, storageList);
        showStorageStatisticTable(jTable6);
    }//GEN-LAST:event_jButton41addToStorage

    private void jCheckBox2changePizzaSize(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCheckBox2changePizzaSize
        if (jCheckBox2.isSelected()) {
            jCheckBox2.setBackground(GREEN);
            activeCat = 6;
        } else {
            jCheckBox2.setBackground(RED);
            activeCat = 5;
        }
        showDishesTable(jTable15, MainForm.menu.get(activeCat).getDishes());
        jTable15.setRowSelectionInterval(0, 0);
        jTable15MousePressed(null);
    }//GEN-LAST:event_jCheckBox2changePizzaSize

    private void jComboBox4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBox4ActionPerformed
        int index = jComboBox4.getSelectedIndex();
        for (Category category : menu) {
            sortListOfDish(category.getDishes(), index);
        }
        showDishesTable(jTable15, MainForm.menu.get(activeCat).getDishes());
        jTable15.setRowSelectionInterval(0, 0);
        jTable15MousePressed(null);
    }//GEN-LAST:event_jComboBox4ActionPerformed

    private void jButton12refreshCalc(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton12refreshCalc
        int index = jTable15.getSelectedRow();
        if (index == -1) {
            index = 0;
        }
            jTabbedPane2.setEnabledAt(2, true);
            jTabbedPane2.setSelectedIndex(2);
            final int dbId = Integer.valueOf(jTable15.getValueAt(index, 0).toString());
            Optional<Dish> maybeDish = menu.get(activeCat).getDishes().stream()
                    .filter(a -> a.getDbID() == dbId)
                    .findFirst();
            if (maybeDish.isPresent()) {
                jLabel33.setText(maybeDish.get().getTitle());
                //join between storageList(all count = 0) and exist recipe into storageList
                ArrayList<Ingredient> tmpList = new ArrayList<>();
                tmpList.addAll(maybeDish.get().getRecipe());
                final int zero = 0;
                for (Ingredient storageList1 : storageList) {
                    for (int j = 0; j < tmpList.size(); j++) {
                        if (storageList1.getId() == tmpList.get(j).getId()) {
                            storageList1.setCount(tmpList.get(j).getCount());
                            break;
                        }
                        if (j == tmpList.size() - 1) {
                            storageList1.setCount(zero);
                        }
                    }
                    if (tmpList.isEmpty()) {
                        storageList1.setCount(zero);
                    }
                }
                setSort(jComboBox6, jTable13, storageList);
                showCalcTable(jTable13);
            }
    }//GEN-LAST:event_jButton12refreshCalc

    private void jButton19updateTitleAndPrice(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton19updateTitleAndPrice
        int index = jTable15.getSelectedRow();
        if (index != -1) {
            final int dbId = Integer.valueOf(jTable15.getValueAt(index, 0).toString());
            Optional<Dish> maybeDish = menu.get(activeCat).getDishes().stream()
                    .filter(a -> a.getDbID() == dbId)
                    .findFirst();
            if (maybeDish.isPresent()) {
                String title = jTextField4.getText();
                int price = Integer.parseInt(jTextField2.getText());
                if (!title.equals("")) {
                    DishUtils.updateDishTitle(maybeDish.get().getDbID(), title, activeCat);
                }
                if (price != 0) {
                    DishUtils.updateDishPrice(maybeDish.get().getDbID(), price, activeCat);
                }
                boolean isCook = jCheckBox3.isSelected();
                DishUtils.updateCookDishParametr(maybeDish.get().getDbID(), isCook, activeCat);

                DishUtils.readDBCategoryById(activeCat);
                jComboBox4ActionPerformed(null);
            }
        }
    }//GEN-LAST:event_jButton19updateTitleAndPrice

    private void jButton13removeDish(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton13removeDish
        int index = jTable15.getSelectedRow();
        if (index != -1) {
            final int dbId = Integer.valueOf(jTable15.getValueAt(index, 0).toString());
            Optional<Dish> maybeDish = menu.get(activeCat).getDishes().stream()
                    .filter(a -> a.getDbID() == dbId)
                    .findFirst();
            if (maybeDish.isPresent()) {
                DishUtils.removeDishById(maybeDish.get().getDbID(), activeCat);
                DishUtils.readDBCategoryById(activeCat);
                jComboBox4ActionPerformed(null);
                log.debug("removeDish from menu cat " + menu.get(activeCat).getTitle() + " dbID " + maybeDish.get().getDbID() + " " + maybeDish.get().getTitle());
            }
        }
    }//GEN-LAST:event_jButton13removeDish

    private void jButton14addDish(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton14addDish
        if (!jTextField2.getText().equals("") && !jTextField4.getText().equals("")) {
            String title = jTextField4.getText();
            int price = Integer.parseInt(jTextField2.getText());
            boolean cook = jCheckBox3.isSelected();
            DishUtils.addDish(new Dish(title, price, cook), activeCat);
            menu.get(activeCat).getDishes().clear();
            DishUtils.readDBCategoryById(activeCat);
            jComboBox4ActionPerformed(null);
        }
    }//GEN-LAST:event_jButton14addDish

    private void jButton42saveCalculation(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton42saveCalculation
        
        JSONUtils.updateDishIngredients(getListFromTable(jTable13, 2), activeCat, activeDishes);
        String JSONString = RecepiesUtils.readRecipeFromDB(activeCat, menu.get(activeCat).getDishes().get(activeDishes).getDbID());
        log.debug("saveCalculation =" + JSONString);
        menu.get(activeCat).getDishes().get(activeDishes).getRecipe().clear();
        menu.get(activeCat).getDishes().get(activeDishes).setRecipe(JSONUtils.getRecipeFromJSON(JSONString));
        jButton12refreshCalc(null);
    }//GEN-LAST:event_jButton42saveCalculation

    private void jTable15MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable15MousePressed
        activeDishes = jTable15.getSelectedRow();
        int index = jTable15.getSelectedRow();
        if (index != -1) {
            final int dbId = Integer.valueOf(jTable15.getValueAt(index, 0).toString());
            Optional<Dish> maybeDish = menu.get(activeCat).getDishes().stream()
                    .filter(a -> a.getDbID() == dbId)
                    .findFirst();
            if (maybeDish.isPresent()) {
                jCheckBox3.setSelected(maybeDish.get().isCook());
                jTextField4.setText(maybeDish.get().getTitle());
                jTextField2.setText(String.valueOf(maybeDish.get().getPrice()));
            }
        }
        jTable15.setRowSelectionInterval(index, index);
    }//GEN-LAST:event_jTable15MousePressed

    private void jTable15KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTable15KeyReleased
        jTable15MousePressed(null);
    }//GEN-LAST:event_jTable15KeyReleased

    private void jComboBox6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBox6ActionPerformed
        setSort(jComboBox6, jTable13, storageList);
        showCalcTable(jTable13);
        if (jComboBox6.getSelectedIndex() == 1) {
            scrollToLastItem(jTable13);
        }
    }//GEN-LAST:event_jComboBox6ActionPerformed

    private void jButton43ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton43ActionPerformed
        Object[] message = {"Введіть назву нового товару на складі"};
        String option = JOptionPane.showInputDialog(null, message, "Новий товар на складі", JOptionPane.OK_CANCEL_OPTION);
        if (option == null && !option.isEmpty()) {
            System.out.println("Cancel is clicked..");
        } else {
            StorageUtils.addIngredientToDB(new Ingredient(option));
            jButton4ActionPerformed(null);
        }
        MainForm.setSelectedLastIndex(jTable6);
    }//GEN-LAST:event_jButton43ActionPerformed

    public static void showDishesTable(JTable jTable, List<Dish> dishes) {
        DefaultTableModel model = (DefaultTableModel) jTable.getModel();
        model.setRowCount(0);
        for (Dish dish : dishes) {
            model.addRow(new Object[]{
                dish.getDbID(),
                dish.getTitle(),
                new BigDecimal(dish.getCost()).setScale(1, RoundingMode.HALF_UP).toString(),
                dish.getPrice()
            });
        }
    }
    private void updateDishCost(Dish dish) {
        final Double cost = dish.getRecipe().stream()
                .mapToDouble(this::getIngredientCost)
                .sum();
        dish.setCost(cost);
    }

    
    private Double getIngredientCost(Ingredient ingredient){
        return MainForm.storageList.stream()
                .filter(a -> a.getDbId() == ingredient.getDbId() && a.getCost() > 0)
                .findFirst()
                .map(a -> new BigDecimal(a.getCost()).multiply(new BigDecimal(ingredient.getCount())).doubleValue())
                .orElse(ZERO.doubleValue());
    }
    private void getStorageTable() {
        StorageUtils.readStorage();
        setSort(jComboBox7, jTable6, storageList);
        showStorageStatisticTable(jTable6);        
    }
        
    public static void showStorageStatisticTable(JTable jTable) {
        DefaultTableModel model = (DefaultTableModel) jTable.getModel();
        model.setRowCount(0);
        for (Ingredient ingredient : storageList) { //admin 
            model.addRow(new Object[]{
                ingredient.getId(),
                ingredient.getTitle(),
                ingredient.getCount(),
                0.0,
                false                  
            });
        }
    }
    
    public static void showStorageCostTable(JTable jTable) {
        DefaultTableModel model = (DefaultTableModel) jTable.getModel();
        model.setRowCount(0);
        for (Ingredient ingredient : storageList) { //admin 
            model.addRow(new Object[]{
                ingredient.getId(),
                ingredient.getTitle(),
                ingredient.getCost(),
                false                  
            });
        }
    }

    private void showOrderedDishes() {
        orderedDishes.clear();
        //todo fix
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
        log.debug("employee size " + employees.size());
        getCustomSumKeyMoneyForUserBetween(startDate, endDate);
        refresEmployeeKeyMoneyTable();

    }

    private void refresEmployeeKeyMoneyTable() {
        DefaultTableModel model = (DefaultTableModel) jTable8.getModel();
        model.setRowCount(0);
        for (Employee employee : employees) {
            model.addRow(new Object[]{
                employee.getName(),
                employee.getKeyMoney(),
                employee.getWorkDaysCount(),
                employee.getHalfWorkDaysCount()
            });
        }
    }

    private void getInkass() {
        inkassOrders.clear();
        inkassStatSum = 0;
        inkassOrders.addAll(OrderUtils.getInkassOrders(startDate, endDate));
        DefaultTableModel model = (DefaultTableModel) jTable9.getModel();
        model.setRowCount(0);
        for (Order order : inkassOrders) {
            inkassStatSum += order.getOrderSum();
            model.addRow(new Object[]{
                order.getUser(),
                order.getComent(),
                order.getDate(),
                order.getOrderSum()
            });
        }
    }
    

    private void refreshEmployeeTable() {
        DefaultTableModel model = (DefaultTableModel) jTable3.getModel();
        model.setRowCount(0);
        for (Employee item : employees) {
            model.addRow(new Object[]{
                item.getName(),
                item.getStartTime(),
                item.getEndTime()
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

        jLabel27.setText(String.valueOf(OrderUtils.getAllBarmenSumWithCardBetween(startDate, endDate, true)));
        jLabel15.setText(String.valueOf(OrderUtils.getAllSumBefore(new Timestamp(new Date().getTime() + SIX_HOURS))));
        jLabel29.setText(String.valueOf(OrderUtils.getAllBarmenSumWithCardBetween(startDate, endDate, false)));
        jLabel9.setText(String.valueOf(OrderUtils.getAllBarmenSumBetween(startDate, endDate)));
        showInkassAndAvans();        

        jLabel10.setText(String.valueOf(OrderUtils.getAllCookCountBetween(startDate, endDate)));
    }
    
    private void showInkassAndAvans(){
        if (inkassStatSum == 0) {
            jLabel13.setText(String.valueOf("-" + inkassStatSum));
        }else{
            jLabel13.setText(String.valueOf(inkassStatSum));
        }
        int avans = getAllAvans();
        if (avans == 0) {
            jLabel19.setText(String.valueOf("-" + avans));
        }else{
            jLabel19.setText(String.valueOf(avans));
        }             
    }
    
    private void showUserKasa(){
        getUserKasa(startDate, endDate);
        DefaultTableModel model = (DefaultTableModel) jTable4.getModel();
        model.setRowCount(0);

        for (User user : LoginForm.userList) {
            model.addRow(new Object[]{
                user.getName(),
                user.getKasa()
            });
        }
    }
    
    private int getAllAvans(){
        int AllAvans = 0;
        for (Employee employee : employees) {
            AllAvans += employee.getKeyMoney();
        }
        return AllAvans;
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
    }

    private void refreshReviziaDates() {
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
    
    private static Date actualDate;
    private static final int SIX_HOURS = 6 * 60 * 60 * 1000;
    private static final int EIGHT_HOURS = 8 * 60 * 60 * 1000;
    private static final long ONE_DAY_PLUS_THREE_HOURS = 27 * 60 * 60 * 1000;
    private static final long ONE_DAY_PLUS_EIGHT_HOURS = 32 * 60 * 60 * 1000;
    public static int cafeId;
    public static boolean isLocalHost;
    private static List<String> servers = new ArrayList<>();
    private static Timestamp startDate, endDate, EmployeeDate;
    private static int activeOrder;
    private static final List<Order> orders = new ArrayList<>();
    private static final List<Order> inkassOrders = new ArrayList<>();
    private static int inkassStatSum = 0;
    private static final List<OrderItem> orderedDishes = new ArrayList<>();
    private static final DateFormat dateFormat = new SimpleDateFormat("dd/MM HH:mm:ss");
    public static ClientForm clientForm;
    public static DecimalFormat df1 = new DecimalFormat(".#");
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel CategoriesPanel;
    private javax.swing.JPanel DishesPanel;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JButton cat1;
    private javax.swing.JButton cat10;
    private javax.swing.JButton cat11;
    private javax.swing.JButton cat12;
    private javax.swing.JButton cat2;
    private javax.swing.JButton cat3;
    private javax.swing.JButton cat4;
    private javax.swing.JButton cat5;
    private javax.swing.JButton cat6;
    private javax.swing.JButton cat7;
    private javax.swing.JButton cat8;
    private javax.swing.JButton cat9;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton10;
    private javax.swing.JButton jButton11;
    private javax.swing.JButton jButton12;
    private javax.swing.JButton jButton13;
    private javax.swing.JButton jButton14;
    private javax.swing.JButton jButton19;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton39;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton40;
    private javax.swing.JButton jButton41;
    private javax.swing.JButton jButton42;
    private javax.swing.JButton jButton43;
    private javax.swing.JButton jButton5;
    private javax.swing.JButton jButton6;
    private javax.swing.JButton jButton7;
    private javax.swing.JButton jButton8;
    private javax.swing.JButton jButton9;
    private javax.swing.JCheckBox jCheckBox1;
    private javax.swing.JCheckBox jCheckBox2;
    private javax.swing.JCheckBox jCheckBox3;
    private javax.swing.JComboBox jComboBox1;
    private javax.swing.JComboBox jComboBox10;
    private javax.swing.JComboBox jComboBox11;
    private javax.swing.JComboBox jComboBox2;
    private javax.swing.JComboBox jComboBox3;
    private javax.swing.JComboBox jComboBox4;
    private javax.swing.JComboBox jComboBox6;
    private javax.swing.JComboBox jComboBox7;
    private javax.swing.JComboBox jComboBox8;
    private javax.swing.JComboBox jComboBox9;
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
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel25;
    private javax.swing.JLabel jLabel26;
    private javax.swing.JLabel jLabel27;
    private javax.swing.JLabel jLabel28;
    private javax.swing.JLabel jLabel29;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel30;
    private javax.swing.JLabel jLabel31;
    private javax.swing.JLabel jLabel32;
    private javax.swing.JLabel jLabel33;
    private javax.swing.JLabel jLabel34;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel10;
    private javax.swing.JPanel jPanel11;
    private javax.swing.JPanel jPanel12;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JPanel jPanel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane10;
    private javax.swing.JScrollPane jScrollPane11;
    private javax.swing.JScrollPane jScrollPane12;
    private javax.swing.JScrollPane jScrollPane13;
    private javax.swing.JScrollPane jScrollPane14;
    private javax.swing.JScrollPane jScrollPane15;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JScrollPane jScrollPane6;
    private javax.swing.JScrollPane jScrollPane7;
    private javax.swing.JScrollPane jScrollPane8;
    private javax.swing.JScrollPane jScrollPane9;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JTabbedPane jTabbedPane2;
    private javax.swing.JTabbedPane jTabbedPane3;
    private javax.swing.JTable jTable1;
    private javax.swing.JTable jTable10;
    private javax.swing.JTable jTable11;
    private javax.swing.JTable jTable12;
    private javax.swing.JTable jTable13;
    private javax.swing.JTable jTable14;
    private javax.swing.JTable jTable15;
    private javax.swing.JTable jTable2;
    private javax.swing.JTable jTable3;
    private javax.swing.JTable jTable4;
    private javax.swing.JTable jTable5;
    private javax.swing.JTable jTable6;
    private javax.swing.JTable jTable7;
    private javax.swing.JTable jTable8;
    private javax.swing.JTable jTable9;
    private javax.swing.JTextField jTextField2;
    private javax.swing.JTextField jTextField4;
    private javax.swing.JToggleButton jToggleButton1;
    private org.jdesktop.swingx.JXDatePicker jXDatePicker1;
    private org.jdesktop.swingx.JXDatePicker jXDatePicker2;
    private org.jdesktop.swingx.JXDatePicker jXDatePicker3;
    // End of variables declaration//GEN-END:variables
}
