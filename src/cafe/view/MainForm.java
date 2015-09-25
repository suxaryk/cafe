package cafe.view;

import cafe.Utils.db.CheckUtils;
import cafe.Utils.db.EmployeeUtils;
import cafe.Utils.db.UsersUtils;
import cafe.model.Check;
import cafe.Utils.db.Dish.DishUtils;
import cafe.Utils.db.Dish.RecepiesUtils;
import cafe.Utils.db.StorageUtils;
import cafe.Utils.json.JSONUtils;
import cafe.model.CheckItem;
import cafe.model.Dish;
import cafe.model.Employee;
import cafe.model.Ingredient;
import cafe.model.User;
import static cafe.view.LoginForm.userList;
import java.awt.Color;
import java.awt.Font;
import java.awt.Rectangle;
import java.awt.event.KeyEvent;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultCellEditor;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFormattedTextField;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import org.netbeans.lib.awtextra.AbsoluteLayout;
import javax.swing.JFrame;
import javax.swing.JTable;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.TableColumn;
import javax.swing.text.MaskFormatter;

/**
 *
 * @author suxarina1992@gmail.com
 * @date 22.08.2015
 */
public class MainForm extends javax.swing.JFrame {

    public MainForm() {
        initComponents();
        initBDmenu();
        initIcons();

        InitComonentsProperty();
        

        initLoginForm();
        initMainForm();
        initCalculationTable();

    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanel2 = new javax.swing.JPanel();
        table01 = new javax.swing.JButton();
        table02 = new javax.swing.JButton();
        table03 = new javax.swing.JButton();
        table4 = new javax.swing.JButton();
        table5 = new javax.swing.JButton();
        table6 = new javax.swing.JButton();
        table7 = new javax.swing.JButton();
        table8 = new javax.swing.JButton();
        table9 = new javax.swing.JButton();
        table10 = new javax.swing.JButton();
        table11 = new javax.swing.JButton();
        table12 = new javax.swing.JButton();
        table13 = new javax.swing.JButton();
        table14 = new javax.swing.JButton();
        table15 = new javax.swing.JButton();
        table16 = new javax.swing.JButton();
        table17 = new javax.swing.JButton();
        table18 = new javax.swing.JButton();
        table19 = new javax.swing.JButton();
        table20 = new javax.swing.JButton();
        table21 = new javax.swing.JButton();
        table22 = new javax.swing.JButton();
        table23 = new javax.swing.JButton();
        table24 = new javax.swing.JButton();
        table25 = new javax.swing.JButton();
        jTextField5 = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jButton18 = new javax.swing.JButton();
        jPanel4 = new javax.swing.JPanel();
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
        jPanel5 = new javax.swing.JPanel();
        jScrollPane3 = new javax.swing.JScrollPane();
        jList2 = new javax.swing.JList();
        btn10 = new javax.swing.JButton();
        btn6 = new javax.swing.JButton();
        btn7 = new javax.swing.JButton();
        btn8 = new javax.swing.JButton();
        btn9 = new javax.swing.JButton();
        btn5 = new javax.swing.JButton();
        btn1 = new javax.swing.JButton();
        btn2 = new javax.swing.JButton();
        btn3 = new javax.swing.JButton();
        btn4 = new javax.swing.JButton();
        jCheckBox1 = new javax.swing.JCheckBox();
        jTextField2 = new javax.swing.JTextField();
        jComboBox1 = new javax.swing.JComboBox();
        jLabel6 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jButton11 = new javax.swing.JButton();
        jButton12 = new javax.swing.JButton();
        jTextField4 = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jButton19 = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jButton3 = new javax.swing.JButton();
        jButton7 = new javax.swing.JButton();
        jScrollPane5 = new javax.swing.JScrollPane();
        jTable4 = new javax.swing.JTable();
        jButton9 = new javax.swing.JButton();
        jButton10 = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        jTextField1 = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jButton2 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        jButton5 = new javax.swing.JButton();
        jButton6 = new javax.swing.JButton();
        jLabel11 = new javax.swing.JLabel();
        jPanel6 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTable2 = new javax.swing.JTable();
        jButton8 = new javax.swing.JButton();
        jButton24 = new javax.swing.JButton();
        jButton25 = new javax.swing.JButton();
        jButton26 = new javax.swing.JButton();
        jButton27 = new javax.swing.JButton();
        jButton28 = new javax.swing.JButton();
        jButton29 = new javax.swing.JButton();
        jButton30 = new javax.swing.JButton();
        jButton31 = new javax.swing.JButton();
        jButton32 = new javax.swing.JButton();
        jButton33 = new javax.swing.JButton();
        jButton34 = new javax.swing.JButton();
        jPasswordField1 = new javax.swing.JPasswordField();
        jButton13 = new javax.swing.JButton();
        jLabel7 = new javax.swing.JLabel();
        jButton14 = new javax.swing.JButton();
        jButton15 = new javax.swing.JButton();
        jTextField3 = new javax.swing.JTextField();
        jButton17 = new javax.swing.JButton();
        jPanel7 = new javax.swing.JPanel();
        jScrollPane4 = new javax.swing.JScrollPane();
        jTable3 = new javax.swing.JTable();
        jLabel12 = new javax.swing.JLabel();
        jPanel8 = new javax.swing.JPanel();
        jScrollPane6 = new javax.swing.JScrollPane();
        jTable5 = new javax.swing.JTable();
        jButton23 = new javax.swing.JButton();
        jComboBox3 = new javax.swing.JComboBox();
        jLabel13 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jButton35 = new javax.swing.JButton();
        jButton36 = new javax.swing.JButton();
        jButton37 = new javax.swing.JButton();
        jTextField6 = new javax.swing.JTextField();
        jLabel15 = new javax.swing.JLabel();
        jButton38 = new javax.swing.JButton();
        jPanel10 = new javax.swing.JPanel();
        jButton53 = new javax.swing.JButton();
        jButton54 = new javax.swing.JButton();
        jButton55 = new javax.swing.JButton();
        jButton56 = new javax.swing.JButton();
        jButton57 = new javax.swing.JButton();
        jButton58 = new javax.swing.JButton();
        jButton59 = new javax.swing.JButton();
        jButton60 = new javax.swing.JButton();
        jButton61 = new javax.swing.JButton();
        jButton62 = new javax.swing.JButton();
        jButton63 = new javax.swing.JButton();
        jButton20 = new javax.swing.JButton();
        jButton39 = new javax.swing.JButton();
        jComboBox4 = new javax.swing.JComboBox();
        jLabel16 = new javax.swing.JLabel();
        jButton64 = new javax.swing.JButton();
        jPanel11 = new javax.swing.JPanel();
        jButton65 = new javax.swing.JButton();
        jButton66 = new javax.swing.JButton();
        jButton67 = new javax.swing.JButton();
        jButton68 = new javax.swing.JButton();
        jButton69 = new javax.swing.JButton();
        jButton70 = new javax.swing.JButton();
        jButton71 = new javax.swing.JButton();
        jButton72 = new javax.swing.JButton();
        jButton73 = new javax.swing.JButton();
        jButton74 = new javax.swing.JButton();
        jButton75 = new javax.swing.JButton();
        jButton21 = new javax.swing.JButton();
        jComboBox5 = new javax.swing.JComboBox();
        jLabel17 = new javax.swing.JLabel();
        jButton76 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);
        setTitle("SmartCafe");
        setEnabled(false);
        setResizable(false);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                formWindowClosing(evt);
            }
        });
        addComponentListener(new java.awt.event.ComponentAdapter() {
            public void componentShown(java.awt.event.ComponentEvent evt) {
                formComponentShown(evt);
            }
        });
        getContentPane().setLayout(null);

        jTabbedPane1.setBackground(new java.awt.Color(232, 232, 232));
        jTabbedPane1.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jTabbedPane1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jTabbedPane1MousePressed(evt);
            }
        });

        jPanel2.setBackground(new java.awt.Color(67, 96, 156));
        jPanel2.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jPanel2.setEnabled(false);
        jPanel2.setLayout(null);

        table01.setBackground(new java.awt.Color(0, 153, 102));
        table01.setFont(new java.awt.Font("Tahoma", 0, 36)); // NOI18N
        table01.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        table01.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        table01.setLabel("01");
        table01.setName("tbl1"); // NOI18N
        table01.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                chooseTable(evt);
            }
        });
        jPanel2.add(table01);
        table01.setBounds(80, 40, 100, 100);

        table02.setBackground(new java.awt.Color(0, 153, 102));
        table02.setFont(new java.awt.Font("Tahoma", 0, 36)); // NOI18N
        table02.setText("02");
        table02.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        table02.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        table02.setName("tbl2"); // NOI18N
        table02.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                chooseTable(evt);
            }
        });
        jPanel2.add(table02);
        table02.setBounds(180, 40, 100, 100);

        table03.setBackground(new java.awt.Color(0, 153, 102));
        table03.setFont(new java.awt.Font("Tahoma", 0, 36)); // NOI18N
        table03.setText("03");
        table03.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        table03.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        table03.setName("tbl3"); // NOI18N
        table03.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                chooseTable(evt);
            }
        });
        jPanel2.add(table03);
        table03.setBounds(280, 40, 100, 100);

        table4.setBackground(new java.awt.Color(0, 153, 102));
        table4.setFont(new java.awt.Font("Tahoma", 0, 36)); // NOI18N
        table4.setText("04");
        table4.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        table4.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        table4.setName("tbl4"); // NOI18N
        table4.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                chooseTable(evt);
            }
        });
        jPanel2.add(table4);
        table4.setBounds(380, 40, 100, 100);

        table5.setBackground(new java.awt.Color(0, 153, 102));
        table5.setFont(new java.awt.Font("Tahoma", 0, 36)); // NOI18N
        table5.setText("05");
        table5.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        table5.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        table5.setName("tbl5"); // NOI18N
        table5.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                chooseTable(evt);
            }
        });
        jPanel2.add(table5);
        table5.setBounds(480, 40, 100, 100);

        table6.setBackground(new java.awt.Color(0, 153, 102));
        table6.setFont(new java.awt.Font("Tahoma", 0, 36)); // NOI18N
        table6.setText("06");
        table6.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        table6.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        table6.setName("tbl6"); // NOI18N
        table6.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                chooseTable(evt);
            }
        });
        jPanel2.add(table6);
        table6.setBounds(80, 140, 100, 100);

        table7.setBackground(new java.awt.Color(0, 153, 102));
        table7.setFont(new java.awt.Font("Tahoma", 0, 36)); // NOI18N
        table7.setText("07");
        table7.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        table7.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        table7.setName("tbl7"); // NOI18N
        table7.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                chooseTable(evt);
            }
        });
        jPanel2.add(table7);
        table7.setBounds(180, 140, 100, 100);

        table8.setBackground(new java.awt.Color(0, 153, 102));
        table8.setFont(new java.awt.Font("Tahoma", 0, 36)); // NOI18N
        table8.setText("08");
        table8.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        table8.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        table8.setName("tbl8"); // NOI18N
        table8.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                chooseTable(evt);
            }
        });
        jPanel2.add(table8);
        table8.setBounds(280, 140, 100, 100);

        table9.setBackground(new java.awt.Color(0, 153, 102));
        table9.setFont(new java.awt.Font("Tahoma", 0, 36)); // NOI18N
        table9.setText("09");
        table9.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        table9.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        table9.setName("tbl9"); // NOI18N
        table9.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                chooseTable(evt);
            }
        });
        jPanel2.add(table9);
        table9.setBounds(380, 140, 100, 100);

        table10.setBackground(new java.awt.Color(0, 153, 102));
        table10.setFont(new java.awt.Font("Tahoma", 0, 36)); // NOI18N
        table10.setText("10");
        table10.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        table10.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        table10.setName("tbl10"); // NOI18N
        table10.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                chooseTable(evt);
            }
        });
        jPanel2.add(table10);
        table10.setBounds(480, 140, 100, 100);

        table11.setBackground(new java.awt.Color(0, 153, 102));
        table11.setFont(new java.awt.Font("Tahoma", 0, 36)); // NOI18N
        table11.setText("11");
        table11.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        table11.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        table11.setName("tbl11"); // NOI18N
        table11.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                chooseTable(evt);
            }
        });
        jPanel2.add(table11);
        table11.setBounds(80, 240, 100, 100);

        table12.setBackground(new java.awt.Color(0, 153, 102));
        table12.setFont(new java.awt.Font("Tahoma", 0, 36)); // NOI18N
        table12.setText("12");
        table12.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        table12.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        table12.setName("tbl12"); // NOI18N
        table12.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                chooseTable(evt);
            }
        });
        jPanel2.add(table12);
        table12.setBounds(180, 240, 100, 100);

        table13.setBackground(new java.awt.Color(0, 153, 102));
        table13.setFont(new java.awt.Font("Tahoma", 0, 36)); // NOI18N
        table13.setText("13");
        table13.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        table13.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        table13.setName("tbl13"); // NOI18N
        table13.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                chooseTable(evt);
            }
        });
        jPanel2.add(table13);
        table13.setBounds(280, 240, 100, 100);

        table14.setBackground(new java.awt.Color(0, 153, 102));
        table14.setFont(new java.awt.Font("Tahoma", 0, 36)); // NOI18N
        table14.setText("14");
        table14.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        table14.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        table14.setName("tbl14"); // NOI18N
        table14.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                chooseTable(evt);
            }
        });
        jPanel2.add(table14);
        table14.setBounds(380, 240, 100, 100);

        table15.setBackground(new java.awt.Color(0, 153, 102));
        table15.setFont(new java.awt.Font("Tahoma", 0, 36)); // NOI18N
        table15.setText("15");
        table15.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        table15.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        table15.setName("tbl15"); // NOI18N
        table15.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                chooseTable(evt);
            }
        });
        jPanel2.add(table15);
        table15.setBounds(480, 240, 100, 100);

        table16.setBackground(new java.awt.Color(0, 153, 102));
        table16.setFont(new java.awt.Font("Tahoma", 0, 36)); // NOI18N
        table16.setText("16");
        table16.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        table16.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        table16.setName("tbl16"); // NOI18N
        table16.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                chooseTable(evt);
            }
        });
        jPanel2.add(table16);
        table16.setBounds(80, 340, 100, 100);

        table17.setBackground(new java.awt.Color(0, 153, 102));
        table17.setFont(new java.awt.Font("Tahoma", 0, 36)); // NOI18N
        table17.setText("17");
        table17.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        table17.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        table17.setName("tbl17"); // NOI18N
        table17.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                chooseTable(evt);
            }
        });
        jPanel2.add(table17);
        table17.setBounds(180, 340, 100, 100);

        table18.setBackground(new java.awt.Color(0, 153, 102));
        table18.setFont(new java.awt.Font("Tahoma", 0, 36)); // NOI18N
        table18.setText("18");
        table18.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        table18.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        table18.setName("tbl18"); // NOI18N
        table18.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                chooseTable(evt);
            }
        });
        jPanel2.add(table18);
        table18.setBounds(280, 340, 100, 100);

        table19.setBackground(new java.awt.Color(0, 153, 102));
        table19.setFont(new java.awt.Font("Tahoma", 0, 36)); // NOI18N
        table19.setText("19");
        table19.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        table19.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        table19.setName("tbl19"); // NOI18N
        table19.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                chooseTable(evt);
            }
        });
        jPanel2.add(table19);
        table19.setBounds(380, 340, 100, 100);

        table20.setBackground(new java.awt.Color(0, 153, 102));
        table20.setFont(new java.awt.Font("Tahoma", 0, 36)); // NOI18N
        table20.setText("20");
        table20.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        table20.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        table20.setName("tbl20"); // NOI18N
        table20.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                chooseTable(evt);
            }
        });
        jPanel2.add(table20);
        table20.setBounds(480, 340, 100, 100);

        table21.setBackground(new java.awt.Color(0, 153, 102));
        table21.setFont(new java.awt.Font("Tahoma", 0, 36)); // NOI18N
        table21.setText("21");
        table21.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        table21.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        table21.setName("tbl21"); // NOI18N
        table21.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                chooseTable(evt);
            }
        });
        jPanel2.add(table21);
        table21.setBounds(80, 440, 100, 100);

        table22.setBackground(new java.awt.Color(0, 153, 102));
        table22.setFont(new java.awt.Font("Tahoma", 0, 36)); // NOI18N
        table22.setText("22");
        table22.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        table22.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        table22.setName("tbl22"); // NOI18N
        table22.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                chooseTable(evt);
            }
        });
        jPanel2.add(table22);
        table22.setBounds(180, 440, 100, 100);

        table23.setBackground(new java.awt.Color(0, 153, 102));
        table23.setFont(new java.awt.Font("Tahoma", 0, 36)); // NOI18N
        table23.setText("23");
        table23.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        table23.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        table23.setName("tbl23"); // NOI18N
        table23.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                chooseTable(evt);
            }
        });
        jPanel2.add(table23);
        table23.setBounds(280, 440, 100, 100);

        table24.setBackground(new java.awt.Color(0, 153, 102));
        table24.setFont(new java.awt.Font("Tahoma", 0, 36)); // NOI18N
        table24.setText("24");
        table24.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        table24.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        table24.setName("tbl24"); // NOI18N
        table24.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                chooseTable(evt);
            }
        });
        jPanel2.add(table24);
        table24.setBounds(380, 440, 100, 100);

        table25.setBackground(new java.awt.Color(0, 153, 102));
        table25.setFont(new java.awt.Font("Tahoma", 0, 36)); // NOI18N
        table25.setText("VIP");
        table25.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        table25.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        table25.setName("tbl25"); // NOI18N
        table25.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                chooseTable(evt);
            }
        });
        jPanel2.add(table25);
        table25.setBounds(480, 440, 100, 100);

        jTextField5.setEditable(false);
        jTextField5.setBackground(new java.awt.Color(67, 96, 156));
        jTextField5.setFont(new java.awt.Font("Verdana", 1, 24)); // NOI18N
        jTextField5.setForeground(new java.awt.Color(255, 102, 102));
        jTextField5.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        jTextField5.setText("0");
        jTextField5.setBorder(null);
        jPanel2.add(jTextField5);
        jTextField5.setBounds(80, 560, 90, 40);

        jLabel3.setFont(new java.awt.Font("Verdana", 1, 18)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 102, 102));
        jLabel3.setText("грн.");
        jPanel2.add(jLabel3);
        jLabel3.setBounds(180, 570, 60, 30);

        jButton18.setBackground(new java.awt.Color(67, 96, 156));
        jButton18.setFont(new java.awt.Font("Verdana", 1, 24)); // NOI18N
        jButton18.setForeground(new java.awt.Color(255, 102, 102));
        jButton18.setText("Каса:");
        jButton18.setBorder(null);
        jPanel2.add(jButton18);
        jButton18.setBounds(0, 560, 80, 40);

        jTabbedPane1.addTab("                          ", new javax.swing.ImageIcon(getClass().getResource("/cafe/icons/small/two200.png")), jPanel2); // NOI18N

        jPanel4.setBackground(new java.awt.Color(67, 96, 156));
        jPanel4.setToolTipText("");
        jPanel4.setLayout(null);

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
        jPanel4.add(cat5);
        cat5.setBounds(0, 220, 160, 160);

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
        jPanel4.add(cat6);
        cat6.setBounds(160, 220, 160, 160);

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
        jPanel4.add(cat7);
        cat7.setBounds(320, 220, 160, 160);

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
        jPanel4.add(cat8);
        cat8.setBounds(480, 220, 160, 160);

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
        jPanel4.add(cat3);
        cat3.setBounds(320, 60, 160, 160);

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
        jPanel4.add(cat4);
        cat4.setBounds(480, 60, 160, 160);

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
        jPanel4.add(cat2);
        cat2.setBounds(160, 60, 160, 160);

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
        jPanel4.add(cat1);
        cat1.setBounds(0, 60, 160, 160);

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
        jPanel4.add(cat9);
        cat9.setBounds(0, 380, 160, 160);

        cat10.setBackground(new java.awt.Color(233, 234, 237));
        cat10.setFont(new java.awt.Font("Verdana", 0, 18)); // NOI18N
        cat10.setIcon(new javax.swing.ImageIcon(getClass().getResource("/cafe/icons/drink175.png"))); // NOI18N
        cat10.setText("<html>  \n<br/> \n<br/> \n<br/> \n<br/>  \n<br/>  \n&nbsp;Алкоголь</html>");
        cat10.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        cat10.setHorizontalTextPosition(javax.swing.SwingConstants.LEFT);
        cat10.setName("cat9"); // NOI18N
        cat10.setVerticalAlignment(javax.swing.SwingConstants.TOP);
        cat10.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                chooseCat(evt);
            }
        });
        jPanel4.add(cat10);
        cat10.setBounds(160, 380, 160, 160);

        cat11.setBackground(new java.awt.Color(233, 234, 237));
        cat11.setFont(new java.awt.Font("Verdana", 0, 18)); // NOI18N
        cat11.setText("<html>  \n<br/> \n<br/> \n<br/> \n<br/>  \n<br/>  \n&nbsp;дод.страви</html>");
        cat11.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        cat11.setEnabled(false);
        cat11.setHorizontalTextPosition(javax.swing.SwingConstants.LEFT);
        cat11.setName("cat10"); // NOI18N
        cat11.setVerticalAlignment(javax.swing.SwingConstants.TOP);
        jPanel4.add(cat11);
        cat11.setBounds(320, 380, 160, 160);

        cat12.setBackground(new java.awt.Color(233, 234, 237));
        cat12.setFont(new java.awt.Font("Verdana", 0, 18)); // NOI18N
        cat12.setText("<html>  \n<br/> \n<br/> \n<br/> \n<br/>  \n<br/>  \n&nbsp;дод.страви</html>");
        cat12.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        cat12.setEnabled(false);
        cat12.setHorizontalTextPosition(javax.swing.SwingConstants.LEFT);
        cat12.setName("cat11"); // NOI18N
        cat12.setVerticalAlignment(javax.swing.SwingConstants.TOP);
        jPanel4.add(cat12);
        cat12.setBounds(480, 380, 160, 160);

        jTabbedPane1.addTab("                       ", new javax.swing.ImageIcon(getClass().getResource("/cafe/icons/plate24.png")), jPanel4, ""); // NOI18N

        jPanel5.setBackground(new java.awt.Color(233, 234, 237));
        jPanel5.setEnabled(false);
        jPanel5.setFocusable(false);
        jPanel5.addComponentListener(new java.awt.event.ComponentAdapter() {
            public void componentShown(java.awt.event.ComponentEvent evt) {
                jPanel5ComponentShown(evt);
            }
        });
        jPanel5.setLayout(null);

        jList2.setFont(new java.awt.Font("Verdana", 0, 18)); // NOI18N
        jList2.setModel(new javax.swing.AbstractListModel() {
            String[] strings = { "Асорті (креветка, тунець, спайе, ікра, огірок)", " " };
            public int getSize() { return strings.length; }
            public Object getElementAt(int i) { return strings[i]; }
        });
        jList2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                getListItem(evt);
            }
        });
        jScrollPane3.setViewportView(jList2);

        jPanel5.add(jScrollPane3);
        jScrollPane3.setBounds(0, 0, 570, 470);

        btn10.setBackground(new java.awt.Color(0, 153, 204));
        btn10.setFont(new java.awt.Font("Verdana", 1, 14)); // NOI18N
        btn10.setText("<html> 10 шт.<br/> 0 грн. </html>");
        btn10.setToolTipText("");
        btn10.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        btn10.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btn10.setMargin(new java.awt.Insets(0, 0, 0, 0));
        btn10.setName("btn10"); // NOI18N
        btn10.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btn10.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                chooseCount(evt);
            }
        });
        jPanel5.add(btn10);
        btn10.setBounds(570, 540, 70, 60);

        btn6.setBackground(new java.awt.Color(0, 153, 204));
        btn6.setFont(new java.awt.Font("Verdana", 1, 14)); // NOI18N
        btn6.setText("<html> 6 шт.<br/> 0 грн. </html>");
        btn6.setToolTipText("");
        btn6.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        btn6.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btn6.setMargin(new java.awt.Insets(0, 0, 0, 0));
        btn6.setName("btn6"); // NOI18N
        btn6.setNextFocusableComponent(btn7);
        btn6.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btn6.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                chooseCount(evt);
            }
        });
        jPanel5.add(btn6);
        btn6.setBounds(570, 300, 70, 60);

        btn7.setBackground(new java.awt.Color(0, 153, 204));
        btn7.setFont(new java.awt.Font("Verdana", 1, 14)); // NOI18N
        btn7.setText("<html> 7 шт. <br/> 0 грн. </html>");
        btn7.setToolTipText("");
        btn7.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        btn7.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btn7.setMargin(new java.awt.Insets(0, 0, 0, 0));
        btn7.setName("btn7"); // NOI18N
        btn7.setNextFocusableComponent(btn8);
        btn7.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btn7.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                chooseCount(evt);
            }
        });
        jPanel5.add(btn7);
        btn7.setBounds(570, 360, 70, 60);

        btn8.setBackground(new java.awt.Color(0, 153, 204));
        btn8.setFont(new java.awt.Font("Verdana", 1, 14)); // NOI18N
        btn8.setText("<html> 8 шт.<br/> 0 грн. </html>");
        btn8.setToolTipText("");
        btn8.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        btn8.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btn8.setMargin(new java.awt.Insets(0, 0, 0, 0));
        btn8.setName("btn8"); // NOI18N
        btn8.setNextFocusableComponent(btn9);
        btn8.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btn8.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                chooseCount(evt);
            }
        });
        jPanel5.add(btn8);
        btn8.setBounds(570, 420, 70, 60);

        btn9.setBackground(new java.awt.Color(0, 153, 204));
        btn9.setFont(new java.awt.Font("Verdana", 1, 14)); // NOI18N
        btn9.setText("<html> 9 шт.<br/> 0 грн. </html>");
        btn9.setToolTipText("");
        btn9.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        btn9.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btn9.setMargin(new java.awt.Insets(0, 0, 0, 0));
        btn9.setName("btn9"); // NOI18N
        btn9.setNextFocusableComponent(btn10);
        btn9.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btn9.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                chooseCount(evt);
            }
        });
        jPanel5.add(btn9);
        btn9.setBounds(570, 480, 70, 60);

        btn5.setBackground(new java.awt.Color(0, 153, 204));
        btn5.setFont(new java.awt.Font("Verdana", 1, 14)); // NOI18N
        btn5.setText("<html> 5 шт.<br/> 0 грн. </html>");
        btn5.setToolTipText("");
        btn5.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        btn5.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btn5.setMargin(new java.awt.Insets(0, 0, 0, 0));
        btn5.setName("btn5"); // NOI18N
        btn5.setNextFocusableComponent(btn6);
        btn5.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btn5.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                chooseCount(evt);
            }
        });
        jPanel5.add(btn5);
        btn5.setBounds(570, 240, 70, 60);

        btn1.setBackground(new java.awt.Color(0, 153, 204));
        btn1.setFont(new java.awt.Font("Verdana", 1, 14)); // NOI18N
        btn1.setText("<html> 1 шт.<br/> 0 грн. </html>");
        btn1.setToolTipText("");
        btn1.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        btn1.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btn1.setMargin(new java.awt.Insets(0, 0, 0, 0));
        btn1.setName("btn1"); // NOI18N
        btn1.setNextFocusableComponent(btn2);
        btn1.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btn1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                chooseCount(evt);
            }
        });
        jPanel5.add(btn1);
        btn1.setBounds(570, 0, 70, 60);

        btn2.setBackground(new java.awt.Color(0, 153, 204));
        btn2.setFont(new java.awt.Font("Verdana", 1, 14)); // NOI18N
        btn2.setText("<html> 2 шт.<br/> 0 грн. </html>");
        btn2.setToolTipText("");
        btn2.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        btn2.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btn2.setMargin(new java.awt.Insets(0, 0, 0, 0));
        btn2.setName("btn2"); // NOI18N
        btn2.setNextFocusableComponent(btn3);
        btn2.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btn2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                chooseCount(evt);
            }
        });
        jPanel5.add(btn2);
        btn2.setBounds(570, 60, 70, 60);

        btn3.setBackground(new java.awt.Color(0, 153, 204));
        btn3.setFont(new java.awt.Font("Verdana", 1, 14)); // NOI18N
        btn3.setText("<html> 3шт. <br/> 0 грн. </html>");
        btn3.setToolTipText("");
        btn3.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        btn3.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btn3.setMargin(new java.awt.Insets(0, 0, 0, 0));
        btn3.setName("btn3"); // NOI18N
        btn3.setNextFocusableComponent(btn4);
        btn3.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btn3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                chooseCount(evt);
            }
        });
        jPanel5.add(btn3);
        btn3.setBounds(570, 120, 70, 60);

        btn4.setBackground(new java.awt.Color(0, 153, 204));
        btn4.setFont(new java.awt.Font("Verdana", 1, 14)); // NOI18N
        btn4.setText("<html> 4 шт.<br/> 0 грн. </html>");
        btn4.setToolTipText("");
        btn4.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        btn4.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btn4.setMargin(new java.awt.Insets(0, 0, 0, 0));
        btn4.setName("btn4"); // NOI18N
        btn4.setNextFocusableComponent(btn5);
        btn4.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btn4.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                chooseCount(evt);
            }
        });
        jPanel5.add(btn4);
        btn4.setBounds(570, 180, 70, 60);

        jCheckBox1.setBackground(new java.awt.Color(255, 102, 102));
        jCheckBox1.setFont(new java.awt.Font("Verdana", 0, 18)); // NOI18N
        jCheckBox1.setText("велика");
        jCheckBox1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                changePizzaSize(evt);
            }
        });
        jPanel5.add(jCheckBox1);
        jCheckBox1.setBounds(0, 530, 120, 31);

        jTextField2.setFont(new java.awt.Font("Verdana", 0, 14)); // NOI18N
        jTextField2.setText("0");
        jTextField2.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                PriceTyped(evt);
            }
        });
        jPanel5.add(jTextField2);
        jTextField2.setBounds(490, 490, 80, 30);

        jComboBox1.setBackground(new java.awt.Color(240, 240, 240));
        jComboBox1.setFont(new java.awt.Font("Verdana", 0, 14)); // NOI18N
        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "як в меню", "за ціною", "за назвою" }));
        jComboBox1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBox1ActionPerformed(evt);
            }
        });
        jPanel5.add(jComboBox1);
        jComboBox1.setBounds(0, 490, 120, 30);

        jLabel6.setFont(new java.awt.Font("Verdana", 0, 14)); // NOI18N
        jLabel6.setText("Сортування:");
        jPanel5.add(jLabel6);
        jLabel6.setBounds(0, 470, 120, 18);

        jButton1.setBackground(new java.awt.Color(204, 204, 204));
        jButton1.setFont(new java.awt.Font("Verdana", 0, 14)); // NOI18N
        jButton1.setText("<html>&nbsp;видалити<br/>&nbsp; страву </html> ");
        jButton1.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                removeDish(evt);
            }
        });
        jPanel5.add(jButton1);
        jButton1.setBounds(270, 530, 100, 70);

        jButton11.setBackground(new java.awt.Color(204, 204, 204));
        jButton11.setFont(new java.awt.Font("Verdana", 0, 14)); // NOI18N
        jButton11.setText("<html>&nbsp;&nbsp;додати<br/>&nbsp; страву </html> ");
        jButton11.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jButton11.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addDish(evt);
            }
        });
        jPanel5.add(jButton11);
        jButton11.setBounds(170, 530, 100, 70);

        jButton12.setBackground(new java.awt.Color(102, 153, 255));
        jButton12.setFont(new java.awt.Font("Verdana", 0, 14)); // NOI18N
        jButton12.setText("<html>&nbsp;&nbsp;&nbsp;оновити<br/>  калькуляцію </html>\n");
        jButton12.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jButton12.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jButton12.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                refreshCalc(evt);
            }
        });
        jPanel5.add(jButton12);
        jButton12.setBounds(470, 530, 100, 70);

        jTextField4.setFont(new java.awt.Font("Verdana", 0, 14)); // NOI18N
        jPanel5.add(jTextField4);
        jTextField4.setBounds(130, 490, 360, 30);

        jLabel8.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        jLabel8.setText("Ціна");
        jPanel5.add(jLabel8);
        jLabel8.setBounds(490, 470, 60, 16);

        jLabel9.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        jLabel9.setText(" Назва");
        jPanel5.add(jLabel9);
        jLabel9.setBounds(130, 470, 90, 16);

        jButton19.setBackground(new java.awt.Color(102, 153, 255));
        jButton19.setFont(new java.awt.Font("Verdana", 0, 14)); // NOI18N
        jButton19.setText("<html>&nbsp;&nbsp;оновити<br/>  назву/ціну </html>\n");
        jButton19.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jButton19.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jButton19.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                updateTitleAndPrice(evt);
            }
        });
        jPanel5.add(jButton19);
        jButton19.setBounds(370, 530, 100, 70);

        jTabbedPane1.addTab("                        ", new javax.swing.ImageIcon(getClass().getResource("/cafe/icons/small/hot-food.png")), jPanel5); // NOI18N

        getContentPane().add(jTabbedPane1);
        jTabbedPane1.setBounds(0, 0, 643, 680);
        jTabbedPane1.getAccessibleContext().setAccessibleName("");

        jPanel3.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanel3.setToolTipText("");
        jPanel3.setLayout(null);

        jTable1.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jTable1.setModel(new javax.swing.table.DefaultTableModel(
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
        jTable1.setFocusable(false);
        jTable1.setRowHeight(18);
        jTable1.getTableHeader().setReorderingAllowed(false);
        jScrollPane1.setViewportView(jTable1);
        if (jTable1.getColumnModel().getColumnCount() > 0) {
            jTable1.getColumnModel().getColumn(1).setMinWidth(40);
            jTable1.getColumnModel().getColumn(1).setPreferredWidth(40);
            jTable1.getColumnModel().getColumn(1).setMaxWidth(40);
            jTable1.getColumnModel().getColumn(2).setMinWidth(50);
            jTable1.getColumnModel().getColumn(2).setPreferredWidth(50);
            jTable1.getColumnModel().getColumn(2).setMaxWidth(50);
            jTable1.getColumnModel().getColumn(3).setMinWidth(50);
            jTable1.getColumnModel().getColumn(3).setPreferredWidth(50);
            jTable1.getColumnModel().getColumn(3).setMaxWidth(50);
        }

        jPanel3.add(jScrollPane1);
        jScrollPane1.setBounds(0, 30, 500, 400);

        jButton3.setBackground(new java.awt.Color(255, 255, 255));
        jButton3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/cafe/icons/small/paper6.png"))); // NOI18N
        jButton3.setEnabled(false);
        jButton3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                PrintCheck(evt);
            }
        });
        jPanel3.add(jButton3);
        jButton3.setBounds(1, 460, 100, 70);

        jButton7.setBackground(new java.awt.Color(255, 102, 102));
        jButton7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/cafe/icons/small/delete101.png"))); // NOI18N
        jButton7.setEnabled(false);
        jButton7.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                removeCheckItem(evt);
            }
        });
        jPanel3.add(jButton7);
        jButton7.setBounds(390, 460, 100, 70);

        jTable4.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "#", "Назва", "Ціна", "Час"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.String.class, java.lang.Integer.class, java.lang.String.class
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
        jScrollPane5.setViewportView(jTable4);

        jPanel3.add(jScrollPane5);
        jScrollPane5.setBounds(1, 30, 488, 270);

        jButton9.setBackground(new java.awt.Color(255, 102, 102));
        jButton9.setIcon(new javax.swing.ImageIcon(getClass().getResource("/cafe/icons/dining4.png"))); // NOI18N
        jButton9.setEnabled(false);
        jButton9.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                clearTable(evt);
            }
        });
        jPanel3.add(jButton9);
        jButton9.setBounds(260, 460, 100, 70);

        jButton10.setBackground(new java.awt.Color(255, 255, 255));
        jButton10.setIcon(new javax.swing.ImageIcon(getClass().getResource("/cafe/icons/small/payment7.png"))); // NOI18N
        jButton10.setEnabled(false);
        jButton10.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                payCheck(evt);
            }
        });
        jPanel3.add(jButton10);
        jButton10.setBounds(130, 460, 100, 70);

        jLabel2.setFont(new java.awt.Font("Verdana", 1, 18)); // NOI18N
        jLabel2.setText("Сума замовлення:");
        jPanel3.add(jLabel2);
        jLabel2.setBounds(10, 430, 189, 23);

        jTextField1.setEditable(false);
        jTextField1.setFont(new java.awt.Font("Verdana", 1, 18)); // NOI18N
        jTextField1.setForeground(new java.awt.Color(255, 51, 51));
        jTextField1.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        jPanel3.add(jTextField1);
        jTextField1.setBounds(210, 430, 210, 29);

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel4.setText("Стіл № ");
        jPanel3.add(jLabel4);
        jLabel4.setBounds(390, 0, 100, 22);

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel5.setText("  Оператор №   ");
        jPanel3.add(jLabel5);
        jLabel5.setBounds(0, 0, 360, 22);

        jPanel1.setBackground(new java.awt.Color(255, 153, 153));
        jPanel1.setLayout(null);

        jButton2.setBackground(new java.awt.Color(255, 255, 255));
        jButton2.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jButton2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/cafe/icons/small/exit18.png"))); // NOI18N
        jButton2.setBorder(btn3.getBorder());
        jButton2.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                exitSystem(evt);
            }
        });
        jPanel1.add(jButton2);
        jButton2.setBounds(390, 0, 100, 70);

        jButton4.setBackground(new java.awt.Color(255, 255, 255));
        jButton4.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jButton4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/cafe/icons/small/boxes37.png"))); // NOI18N
        jButton4.setBorder(btn3.getBorder());
        jButton4.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                goToStorage(evt);
            }
        });
        jPanel1.add(jButton4);
        jButton4.setBounds(130, 0, 100, 70);

        jButton5.setBackground(new java.awt.Color(255, 255, 255));
        jButton5.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jButton5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/cafe/icons/small/coin.png"))); // NOI18N
        jButton5.setBorder(btn3.getBorder());
        jButton5.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton5);
        jButton5.setBounds(260, 0, 100, 70);

        jButton6.setBackground(new java.awt.Color(255, 255, 255));
        jButton6.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jButton6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/cafe/icons/small/login.png"))); // NOI18N
        jButton6.setBorder(btn3.getBorder());
        jButton6.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jButton6.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                PersonalLogining(evt);
            }
        });
        jPanel1.add(jButton6);
        jButton6.setBounds(0, 0, 100, 70);

        jPanel3.add(jPanel1);
        jPanel1.setBounds(1, 601, 500, 90);

        jLabel11.setFont(new java.awt.Font("Verdana", 1, 18)); // NOI18N
        jLabel11.setText("грн.");
        jPanel3.add(jLabel11);
        jLabel11.setBounds(430, 430, 60, 23);

        getContentPane().add(jPanel3);
        jPanel3.setBounds(643, 0, 500, 680);

        jTable2.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jTable2.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Ім'я", "Початок", "Кінець"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, true
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jTable2.setFocusable(false);
        jTable2.setRowHeight(22);
        jTable2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                EmployeeSelected(evt);
            }
        });
        jScrollPane2.setViewportView(jTable2);

        jButton8.setBackground(new java.awt.Color(255, 255, 255));
        jButton8.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jButton8.setIcon(new javax.swing.ImageIcon(getClass().getResource("/cafe/icons/small/exit18.png"))); // NOI18N
        jButton8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                goToMainMenu(evt);
            }
        });

        jButton24.setBackground(new java.awt.Color(204, 204, 204));
        jButton24.setFont(new java.awt.Font("Verdana", 0, 24)); // NOI18N
        jButton24.setText("9");
        jButton24.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jButton24.setEnabled(false);
        jButton24.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                NumberPressed(evt);
            }
        });

        jButton25.setBackground(new java.awt.Color(204, 204, 204));
        jButton25.setFont(new java.awt.Font("Verdana", 0, 22)); // NOI18N
        jButton25.setIcon(new javax.swing.ImageIcon(getClass().getResource("/cafe/icons/small/left145.png"))); // NOI18N
        jButton25.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jButton25.setEnabled(false);
        jButton25.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                clearDigit(evt);
            }
        });

        jButton26.setBackground(new java.awt.Color(204, 204, 204));
        jButton26.setFont(new java.awt.Font("Verdana", 0, 24)); // NOI18N
        jButton26.setText("8");
        jButton26.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jButton26.setEnabled(false);
        jButton26.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                NumberPressed(evt);
            }
        });

        jButton27.setBackground(new java.awt.Color(204, 204, 204));
        jButton27.setFont(new java.awt.Font("Verdana", 0, 24)); // NOI18N
        jButton27.setText("4");
        jButton27.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jButton27.setEnabled(false);
        jButton27.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                NumberPressed(evt);
            }
        });

        jButton28.setBackground(new java.awt.Color(204, 204, 204));
        jButton28.setFont(new java.awt.Font("Verdana", 0, 24)); // NOI18N
        jButton28.setText("5");
        jButton28.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jButton28.setEnabled(false);
        jButton28.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                NumberPressed(evt);
            }
        });

        jButton29.setBackground(new java.awt.Color(204, 204, 204));
        jButton29.setFont(new java.awt.Font("Verdana", 0, 24)); // NOI18N
        jButton29.setText("6");
        jButton29.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jButton29.setEnabled(false);
        jButton29.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                NumberPressed(evt);
            }
        });

        jButton30.setBackground(new java.awt.Color(204, 204, 204));
        jButton30.setFont(new java.awt.Font("Verdana", 0, 24)); // NOI18N
        jButton30.setText("3");
        jButton30.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jButton30.setEnabled(false);
        jButton30.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                NumberPressed(evt);
            }
        });

        jButton31.setBackground(new java.awt.Color(204, 204, 204));
        jButton31.setFont(new java.awt.Font("Verdana", 0, 24)); // NOI18N
        jButton31.setText("0");
        jButton31.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jButton31.setEnabled(false);
        jButton31.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                NumberPressed(evt);
            }
        });

        jButton32.setBackground(new java.awt.Color(204, 204, 204));
        jButton32.setFont(new java.awt.Font("Verdana", 0, 24)); // NOI18N
        jButton32.setText("2");
        jButton32.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jButton32.setEnabled(false);
        jButton32.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                NumberPressed(evt);
            }
        });

        jButton33.setBackground(new java.awt.Color(204, 204, 204));
        jButton33.setFont(new java.awt.Font("Verdana", 0, 24)); // NOI18N
        jButton33.setText("7");
        jButton33.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jButton33.setEnabled(false);
        jButton33.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                NumberPressed(evt);
            }
        });

        jButton34.setBackground(new java.awt.Color(204, 204, 204));
        jButton34.setFont(new java.awt.Font("Verdana", 0, 24)); // NOI18N
        jButton34.setText("1");
        jButton34.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jButton34.setEnabled(false);
        jButton34.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                NumberPressed(evt);
            }
        });

        jPasswordField1.setEditable(false);
        jPasswordField1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jPasswordField1.setToolTipText("");

        jButton13.setBackground(new java.awt.Color(255, 255, 255));
        jButton13.setIcon(new javax.swing.ImageIcon(getClass().getResource("/cafe/icons/small/check-box2.png"))); // NOI18N
        jButton13.setEnabled(false);
        jButton13.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                loginEmployee(evt);
            }
        });

        jLabel7.setFont(new java.awt.Font("Verdana", 0, 11)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(255, 51, 0));
        jLabel7.setText("введіть пароль");
        jLabel7.setToolTipText("");

        jButton14.setText("додати");
        jButton14.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addEmployee(evt);
            }
        });

        jButton15.setText("видалити");
        jButton15.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                removeEmployee(evt);
            }
        });

        jTextField3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField3ActionPerformed(evt);
            }
        });

        jButton17.setBackground(new java.awt.Color(102, 153, 255));
        jButton17.setText("змінити");
        jButton17.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                updateUserAndEmployee(evt);
            }
        });

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jButton14, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jButton15, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jButton17, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jButton8, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(170, 170, 170)
                        .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jButton25, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jButton31, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jButton33, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jButton27, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jButton34, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jButton26, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jButton28, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jButton32, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jButton24, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jButton29, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jButton30, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(20, 20, 20)
                        .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jPasswordField1, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jButton13, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 114, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addComponent(jTextField3, javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 594, Short.MAX_VALUE)))
                .addGap(26, 26, 26))
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 400, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(jTextField3, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(jButton14, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(10, 10, 10)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addComponent(jButton15, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(10, 10, 10)
                        .addComponent(jButton17, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton8))
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addGap(20, 20, 20)
                        .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel6Layout.createSequentialGroup()
                                .addComponent(jButton25, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(50, 50, 50)
                                .addComponent(jButton31, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel6Layout.createSequentialGroup()
                                .addComponent(jButton33, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, 0)
                                .addComponent(jButton27, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, 0)
                                .addComponent(jButton34, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel6Layout.createSequentialGroup()
                                .addComponent(jButton26, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, 0)
                                .addComponent(jButton28, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, 0)
                                .addComponent(jButton32, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel6Layout.createSequentialGroup()
                                .addComponent(jButton24, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, 0)
                                .addComponent(jButton29, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, 0)
                                .addComponent(jButton30, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel6Layout.createSequentialGroup()
                                .addComponent(jPasswordField1, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(2, 2, 2)
                                .addComponent(jLabel7)
                                .addGap(35, 35, 35)
                                .addComponent(jButton13, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addGap(3, 3, 3))
        );

        getContentPane().add(jPanel6);
        jPanel6.setBounds(20, 0, 630, 700);

        jPanel7.setLayout(null);

        jTable3.setFont(new java.awt.Font("Verdana", 0, 18)); // NOI18N
        jTable3.setModel(new javax.swing.table.DefaultTableModel(
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
        jTable3.setFocusable(false);
        jTable3.setRowHeight(20);
        jTable3.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        jTable3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                IngredientSelected(evt);
            }
        });
        jScrollPane4.setViewportView(jTable3);
        if (jTable3.getColumnModel().getColumnCount() > 0) {
            jTable3.getColumnModel().getColumn(0).setMinWidth(40);
            jTable3.getColumnModel().getColumn(0).setPreferredWidth(40);
            jTable3.getColumnModel().getColumn(0).setMaxWidth(40);
            jTable3.getColumnModel().getColumn(2).setMinWidth(100);
            jTable3.getColumnModel().getColumn(2).setPreferredWidth(100);
            jTable3.getColumnModel().getColumn(2).setMaxWidth(100);
        }

        jPanel7.add(jScrollPane4);
        jScrollPane4.setBounds(0, 30, 940, 640);

        jLabel12.setBackground(new java.awt.Color(0, 153, 204));
        jLabel12.setFont(new java.awt.Font("Verdana", 0, 18)); // NOI18N
        jLabel12.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel12.setText(" Інформація");
        jLabel12.setOpaque(true);
        jPanel7.add(jLabel12);
        jLabel12.setBounds(0, 0, 940, 30);

        getContentPane().add(jPanel7);
        jPanel7.setBounds(0, 0, 940, 700);

        jPanel8.setLayout(null);

        jTable5.setFont(new java.awt.Font("Verdana", 0, 18)); // NOI18N
        jTable5.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "№", "Назва", "Вага ( кг/ шт )", "Різниця"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.String.class, java.lang.Double.class, java.lang.Double.class
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
        jTable5.setRowHeight(20);
        jTable5.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        jScrollPane6.setViewportView(jTable5);
        if (jTable5.getColumnModel().getColumnCount() > 0) {
            jTable5.getColumnModel().getColumn(0).setMinWidth(40);
            jTable5.getColumnModel().getColumn(0).setPreferredWidth(40);
            jTable5.getColumnModel().getColumn(0).setMaxWidth(40);
            jTable5.getColumnModel().getColumn(2).setMinWidth(100);
            jTable5.getColumnModel().getColumn(2).setPreferredWidth(100);
            jTable5.getColumnModel().getColumn(2).setMaxWidth(100);
            jTable5.getColumnModel().getColumn(3).setMinWidth(100);
            jTable5.getColumnModel().getColumn(3).setPreferredWidth(100);
            jTable5.getColumnModel().getColumn(3).setMaxWidth(100);
        }

        jPanel8.add(jScrollPane6);
        jScrollPane6.setBounds(0, 30, 650, 510);

        jButton23.setBackground(new java.awt.Color(255, 255, 255));
        jButton23.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jButton23.setIcon(new javax.swing.ImageIcon(getClass().getResource("/cafe/icons/small/exit18.png"))); // NOI18N
        jButton23.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton23exitFromCalculation(evt);
            }
        });
        jPanel8.add(jButton23);
        jButton23.setBounds(0, 600, 100, 73);

        jComboBox3.setBackground(new java.awt.Color(240, 240, 240));
        jComboBox3.setFont(new java.awt.Font("Verdana", 0, 14)); // NOI18N
        jComboBox3.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "за номером", "за вагою", "за назвою" }));
        jComboBox3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBox3ActionPerformed(evt);
            }
        });
        jPanel8.add(jComboBox3);
        jComboBox3.setBounds(530, 560, 120, 30);

        jLabel13.setFont(new java.awt.Font("Verdana", 0, 14)); // NOI18N
        jLabel13.setText("Сортування:");
        jPanel8.add(jLabel13);
        jLabel13.setBounds(530, 540, 120, 18);

        jLabel14.setBackground(new java.awt.Color(0, 153, 204));
        jLabel14.setFont(new java.awt.Font("Verdana", 0, 18)); // NOI18N
        jLabel14.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel14.setText("Склад - наявність продуктів ");
        jLabel14.setOpaque(true);
        jPanel8.add(jLabel14);
        jLabel14.setBounds(0, 0, 650, 30);

        jButton35.setBackground(new java.awt.Color(204, 204, 204));
        jButton35.setFont(new java.awt.Font("Verdana", 0, 14)); // NOI18N
        jButton35.setText("<html> &nbsp;списати<br/> (відняти)</html> ");
        jButton35.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jButton35.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jPanel8.add(jButton35);
        jButton35.setBounds(550, 600, 100, 70);

        jButton36.setBackground(new java.awt.Color(204, 204, 204));
        jButton36.setFont(new java.awt.Font("Verdana", 0, 14)); // NOI18N
        jButton36.setText("<html>&nbsp;&nbsp;додати<br/>  інгредієнт </html>\n");
        jButton36.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jButton36.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addIngredient(evt);
            }
        });
        jPanel8.add(jButton36);
        jButton36.setBounds(170, 600, 100, 70);

        jButton37.setBackground(new java.awt.Color(204, 204, 204));
        jButton37.setFont(new java.awt.Font("Verdana", 0, 14)); // NOI18N
        jButton37.setText("<html>&nbsp;&nbsp;видалити<br/>&nbsp;  інгредієнт </html> ");
        jButton37.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jButton37.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                removeIngredient(evt);
            }
        });
        jPanel8.add(jButton37);
        jButton37.setBounds(270, 600, 100, 70);

        jTextField6.setFont(new java.awt.Font("Verdana", 0, 14)); // NOI18N
        jPanel8.add(jTextField6);
        jTextField6.setBounds(170, 560, 360, 30);

        jLabel15.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        jLabel15.setText(" Назва");
        jPanel8.add(jLabel15);
        jLabel15.setBounds(170, 540, 90, 16);

        jButton38.setBackground(new java.awt.Color(204, 204, 204));
        jButton38.setFont(new java.awt.Font("Verdana", 0, 14)); // NOI18N
        jButton38.setText("<html>поповнити<br/>&nbsp; (додати)</html> ");
        jButton38.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jButton38.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jPanel8.add(jButton38);
        jButton38.setBounds(450, 600, 100, 70);

        getContentPane().add(jPanel8);
        jPanel8.setBounds(0, 0, 650, 700);

        jPanel10.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanel10.setToolTipText("");
        jPanel10.setLayout(null);

        jButton53.setBackground(new java.awt.Color(204, 204, 204));
        jButton53.setFont(new java.awt.Font("Verdana", 0, 24)); // NOI18N
        jButton53.setText("9");
        jButton53.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jButton53.setEnabled(false);
        jButton53.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                PressNumber(evt);
            }
        });
        jPanel10.add(jButton53);
        jButton53.setBounds(150, 230, 50, 50);

        jButton54.setBackground(new java.awt.Color(204, 204, 204));
        jButton54.setFont(new java.awt.Font("Verdana", 0, 22)); // NOI18N
        jButton54.setIcon(new javax.swing.ImageIcon(getClass().getResource("/cafe/icons/small/left145.png"))); // NOI18N
        jButton54.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jButton54.setEnabled(false);
        jButton54.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                deleteDigit(evt);
            }
        });
        jPanel10.add(jButton54);
        jButton54.setBounds(0, 230, 50, 50);

        jButton55.setBackground(new java.awt.Color(204, 204, 204));
        jButton55.setFont(new java.awt.Font("Verdana", 0, 24)); // NOI18N
        jButton55.setText("8");
        jButton55.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jButton55.setEnabled(false);
        jButton55.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                PressNumber(evt);
            }
        });
        jPanel10.add(jButton55);
        jButton55.setBounds(100, 230, 50, 50);

        jButton56.setBackground(new java.awt.Color(204, 204, 204));
        jButton56.setFont(new java.awt.Font("Verdana", 0, 24)); // NOI18N
        jButton56.setText("4");
        jButton56.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jButton56.setEnabled(false);
        jButton56.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                PressNumber(evt);
            }
        });
        jPanel10.add(jButton56);
        jButton56.setBounds(50, 280, 50, 50);

        jButton57.setBackground(new java.awt.Color(204, 204, 204));
        jButton57.setFont(new java.awt.Font("Verdana", 0, 24)); // NOI18N
        jButton57.setText("5");
        jButton57.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jButton57.setEnabled(false);
        jButton57.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                PressNumber(evt);
            }
        });
        jPanel10.add(jButton57);
        jButton57.setBounds(100, 280, 50, 50);

        jButton58.setBackground(new java.awt.Color(204, 204, 204));
        jButton58.setFont(new java.awt.Font("Verdana", 0, 24)); // NOI18N
        jButton58.setText("6");
        jButton58.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jButton58.setEnabled(false);
        jButton58.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                PressNumber(evt);
            }
        });
        jPanel10.add(jButton58);
        jButton58.setBounds(150, 280, 50, 50);

        jButton59.setBackground(new java.awt.Color(204, 204, 204));
        jButton59.setFont(new java.awt.Font("Verdana", 0, 24)); // NOI18N
        jButton59.setText("3");
        jButton59.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jButton59.setEnabled(false);
        jButton59.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                PressNumber(evt);
            }
        });
        jPanel10.add(jButton59);
        jButton59.setBounds(150, 330, 50, 50);

        jButton60.setBackground(new java.awt.Color(204, 204, 204));
        jButton60.setFont(new java.awt.Font("Verdana", 0, 24)); // NOI18N
        jButton60.setText("0");
        jButton60.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jButton60.setEnabled(false);
        jButton60.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                PressNumber(evt);
            }
        });
        jPanel10.add(jButton60);
        jButton60.setBounds(0, 330, 50, 50);

        jButton61.setBackground(new java.awt.Color(204, 204, 204));
        jButton61.setFont(new java.awt.Font("Verdana", 0, 24)); // NOI18N
        jButton61.setText("2");
        jButton61.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jButton61.setEnabled(false);
        jButton61.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                PressNumber(evt);
            }
        });
        jPanel10.add(jButton61);
        jButton61.setBounds(100, 330, 50, 50);

        jButton62.setBackground(new java.awt.Color(204, 204, 204));
        jButton62.setFont(new java.awt.Font("Verdana", 0, 24)); // NOI18N
        jButton62.setText("7");
        jButton62.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jButton62.setEnabled(false);
        jButton62.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                PressNumber(evt);
            }
        });
        jPanel10.add(jButton62);
        jButton62.setBounds(50, 230, 50, 50);

        jButton63.setBackground(new java.awt.Color(204, 204, 204));
        jButton63.setFont(new java.awt.Font("Verdana", 0, 24)); // NOI18N
        jButton63.setText("1");
        jButton63.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jButton63.setEnabled(false);
        jButton63.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                PressNumber(evt);
            }
        });
        jPanel10.add(jButton63);
        jButton63.setBounds(50, 330, 50, 50);

        jButton20.setBackground(new java.awt.Color(255, 255, 255));
        jButton20.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jButton20.setIcon(new javax.swing.ImageIcon(getClass().getResource("/cafe/icons/small/exit18.png"))); // NOI18N
        jButton20.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                exitFromCalculation(evt);
            }
        });
        jPanel10.add(jButton20);
        jButton20.setBounds(1, 600, 200, 73);

        jButton39.setBackground(new java.awt.Color(153, 153, 255));
        jButton39.setFont(new java.awt.Font("Verdana", 0, 14)); // NOI18N
        jButton39.setText("<html> &nbsp;зберегти<br/> &nbsp;&nbsp; зміни</html> ");
        jButton39.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jButton39.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jButton39.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                saveCalculation(evt);
            }
        });
        jPanel10.add(jButton39);
        jButton39.setBounds(1, 430, 200, 70);

        jComboBox4.setBackground(new java.awt.Color(240, 240, 240));
        jComboBox4.setFont(new java.awt.Font("Verdana", 0, 14)); // NOI18N
        jComboBox4.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "за номером", "за вагою", "за назвою" }));
        jComboBox4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBox4ActionPerformed(evt);
            }
        });
        jPanel10.add(jComboBox4);
        jComboBox4.setBounds(2, 110, 120, 30);

        jLabel16.setFont(new java.awt.Font("Verdana", 0, 14)); // NOI18N
        jLabel16.setText("Сортування:");
        jPanel10.add(jLabel16);
        jLabel16.setBounds(2, 90, 120, 18);

        jButton64.setBackground(new java.awt.Color(204, 204, 204));
        jButton64.setFont(new java.awt.Font("Verdana", 0, 30)); // NOI18N
        jButton64.setText("C");
        jButton64.setToolTipText("");
        jButton64.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jButton64.setEnabled(false);
        jButton64.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                clearDigitLine(evt);
            }
        });
        jPanel10.add(jButton64);
        jButton64.setBounds(0, 280, 50, 50);

        getContentPane().add(jPanel10);
        jPanel10.setBounds(940, 0, 202, 680);

        jPanel11.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanel11.setToolTipText("");
        jPanel11.setLayout(null);

        jButton65.setBackground(new java.awt.Color(204, 204, 204));
        jButton65.setFont(new java.awt.Font("Verdana", 0, 24)); // NOI18N
        jButton65.setText("9");
        jButton65.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jButton65.setEnabled(false);
        jButton65.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton65PressNumber(evt);
            }
        });
        jPanel11.add(jButton65);
        jButton65.setBounds(151, 1, 50, 50);

        jButton66.setBackground(new java.awt.Color(204, 204, 204));
        jButton66.setFont(new java.awt.Font("Verdana", 0, 22)); // NOI18N
        jButton66.setIcon(new javax.swing.ImageIcon(getClass().getResource("/cafe/icons/small/left145.png"))); // NOI18N
        jButton66.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jButton66.setEnabled(false);
        jButton66.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton66deleteDigit(evt);
            }
        });
        jPanel11.add(jButton66);
        jButton66.setBounds(1, 1, 50, 50);

        jButton67.setBackground(new java.awt.Color(204, 204, 204));
        jButton67.setFont(new java.awt.Font("Verdana", 0, 24)); // NOI18N
        jButton67.setText("8");
        jButton67.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jButton67.setEnabled(false);
        jButton67.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton67PressNumber(evt);
            }
        });
        jPanel11.add(jButton67);
        jButton67.setBounds(101, 1, 50, 50);

        jButton68.setBackground(new java.awt.Color(204, 204, 204));
        jButton68.setFont(new java.awt.Font("Verdana", 0, 24)); // NOI18N
        jButton68.setText("4");
        jButton68.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jButton68.setEnabled(false);
        jButton68.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton68PressNumber(evt);
            }
        });
        jPanel11.add(jButton68);
        jButton68.setBounds(51, 51, 50, 50);

        jButton69.setBackground(new java.awt.Color(204, 204, 204));
        jButton69.setFont(new java.awt.Font("Verdana", 0, 24)); // NOI18N
        jButton69.setText("5");
        jButton69.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jButton69.setEnabled(false);
        jButton69.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton69PressNumber(evt);
            }
        });
        jPanel11.add(jButton69);
        jButton69.setBounds(101, 51, 50, 50);

        jButton70.setBackground(new java.awt.Color(204, 204, 204));
        jButton70.setFont(new java.awt.Font("Verdana", 0, 24)); // NOI18N
        jButton70.setText("6");
        jButton70.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jButton70.setEnabled(false);
        jButton70.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton70PressNumber(evt);
            }
        });
        jPanel11.add(jButton70);
        jButton70.setBounds(151, 51, 50, 50);

        jButton71.setBackground(new java.awt.Color(204, 204, 204));
        jButton71.setFont(new java.awt.Font("Verdana", 0, 24)); // NOI18N
        jButton71.setText("3");
        jButton71.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jButton71.setEnabled(false);
        jButton71.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton71PressNumber(evt);
            }
        });
        jPanel11.add(jButton71);
        jButton71.setBounds(151, 101, 50, 50);

        jButton72.setBackground(new java.awt.Color(204, 204, 204));
        jButton72.setFont(new java.awt.Font("Verdana", 0, 24)); // NOI18N
        jButton72.setText("0");
        jButton72.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jButton72.setEnabled(false);
        jButton72.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton72PressNumber(evt);
            }
        });
        jPanel11.add(jButton72);
        jButton72.setBounds(1, 101, 50, 50);

        jButton73.setBackground(new java.awt.Color(204, 204, 204));
        jButton73.setFont(new java.awt.Font("Verdana", 0, 24)); // NOI18N
        jButton73.setText("2");
        jButton73.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jButton73.setEnabled(false);
        jButton73.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton73PressNumber(evt);
            }
        });
        jPanel11.add(jButton73);
        jButton73.setBounds(101, 101, 50, 50);

        jButton74.setBackground(new java.awt.Color(204, 204, 204));
        jButton74.setFont(new java.awt.Font("Verdana", 0, 24)); // NOI18N
        jButton74.setText("7");
        jButton74.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jButton74.setEnabled(false);
        jButton74.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton74PressNumber(evt);
            }
        });
        jPanel11.add(jButton74);
        jButton74.setBounds(51, 1, 50, 50);

        jButton75.setBackground(new java.awt.Color(204, 204, 204));
        jButton75.setFont(new java.awt.Font("Verdana", 0, 24)); // NOI18N
        jButton75.setText("1");
        jButton75.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jButton75.setEnabled(false);
        jButton75.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton75PressNumber(evt);
            }
        });
        jPanel11.add(jButton75);
        jButton75.setBounds(51, 101, 50, 50);

        jButton21.setBackground(new java.awt.Color(255, 255, 255));
        jButton21.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jButton21.setIcon(new javax.swing.ImageIcon(getClass().getResource("/cafe/icons/small/exit18.png"))); // NOI18N
        jButton21.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton21exitFromCalculation(evt);
            }
        });
        jPanel11.add(jButton21);
        jButton21.setBounds(0, 600, 100, 73);

        jComboBox5.setBackground(new java.awt.Color(240, 240, 240));
        jComboBox5.setFont(new java.awt.Font("Verdana", 0, 14)); // NOI18N
        jComboBox5.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "за номером", "за вагою", "за назвою" }));
        jComboBox5.setEnabled(false);
        jComboBox5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBox5ActionPerformed(evt);
            }
        });
        jPanel11.add(jComboBox5);
        jComboBox5.setBounds(370, 20, 120, 30);

        jLabel17.setFont(new java.awt.Font("Verdana", 0, 14)); // NOI18N
        jLabel17.setText("Сортування:");
        jPanel11.add(jLabel17);
        jLabel17.setBounds(370, 0, 120, 18);

        jButton76.setBackground(new java.awt.Color(204, 204, 204));
        jButton76.setFont(new java.awt.Font("Verdana", 0, 30)); // NOI18N
        jButton76.setText("C");
        jButton76.setToolTipText("");
        jButton76.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jButton76.setEnabled(false);
        jButton76.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton76clearDigitLine(evt);
            }
        });
        jPanel11.add(jButton76);
        jButton76.setBounds(1, 51, 50, 50);

        getContentPane().add(jPanel11);
        jPanel11.setBounds(650, 0, 490, 680);

        setSize(new java.awt.Dimension(1149, 697));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private int getButtonId(java.awt.event.MouseEvent evt) {
        JButton myButton = (JButton) evt.getSource();
        int a = 0;
        String btnName = myButton.getName();
        a = Integer.parseInt(btnName.substring(3));
        return a;
    }
    private void chooseTable(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_chooseTable
        DefaultTableModel model = (DefaultTableModel) jTable1.getModel();
        model.setRowCount(0);

        activeTable = getButtonId(evt);
        System.out.println("table=" + activeTable);

        jLabel4.setText("Cтіл №" + activeTable);
        jLabel4.setForeground(RED);
        System.out.println("user" + User.getActiveUser);

        if (evt.getComponent().getBackground().equals(Color.yellow)) {

            jTextField1.setText(String.valueOf(checks.get(activeTable)
                    .getTotalsum()));
            for (int i = 0; i < checks.get(activeTable)
                    .getCheckList().size(); i++) {
                model.addRow(new Object[]{
                    checks.get(activeTable).getCheckList().get(i)
                    .getDish().getTitle(),
                    checks.get(activeTable).getCheckList().get(i).getCount(),
                    checks.get(activeTable).getCheckList().get(i).getDish()
                    .getPrice(),
                    checks.get(activeTable).getCheckList().get(i).getSum()
                });
            }
            markCheckItems();
        } else {
            checks.put(activeTable, new Check());
            jTextField1.setText("0");
        }
        if (checks.get(activeTable).isPayed()) {            
            jButton10.setEnabled(false);
            jButton3.setEnabled(false);
            jButton7.setEnabled(false);
            jButton10.setBackground(lightRed);
            jButton3.setBackground(lightRed);
            jButton7.setBackground(lightRed);
            jTable1.setBackground(lightRed);
        } else {
            jTabbedPane1.setEnabledAt(1, true);
            jTabbedPane1.setSelectedIndex(1);
            jButton10.setEnabled(true);
            jButton3.setEnabled(true);
            jButton7.setEnabled(true);
            jButton10.setBackground(Color.WHITE);
            jButton3.setBackground(Color.WHITE);
            jButton7.setBackground(Color.WHITE);
            jTable1.setBackground(Color.WHITE);
        }
        evt.getComponent().setBackground(Color.yellow);
        jButton7.setEnabled(true);
        jButton9.setEnabled(true);
    }//GEN-LAST:event_chooseTable

    private void PersonalLogining(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_PersonalLogining
        jTabbedPane1.setVisible(false);
        jPanel6.setVisible(true);
        mainForm.setSize(630, 697);
    }//GEN-LAST:event_PersonalLogining


    private void getListItem(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_getListItem
        clearCountButton();
        activeDishes = jList2.getSelectedIndex();
        System.out.println("selected index " + jList2.getSelectedIndex());
        String title = listofCat.get(activeCat).get(activeDishes).getTitle();
        int price = listofCat.get(activeCat).get(activeDishes).getPrice();
        jTextField4.setText(title);
        jTextField2.setText(String.valueOf(price));

        refreshListOfPrices();


    }//GEN-LAST:event_getListItem

    private void addRecordToTable(int count) {
        clearCountButton();
//        DateFormat dateFormat = new SimpleDateFormat("HH:mm:ss dd/MM/yyyy");
        DateFormat dateFormat = new SimpleDateFormat("HH:mm");
        DefaultTableModel model = (DefaultTableModel) jTable1.getModel();

        String title = listofCat.get(activeCat).get(activeDishes).getTitle();
        //boolean 
        if (jCheckBox1.isSelected()) {
            listofCat.get(activeCat).get(activeDishes).setTitle("(Вел.)" + title);
        }

        checks.get(activeTable).getCheckList().add(new CheckItem(listofCat.get(activeCat).get(activeDishes), count, new Date()));
        jTextField1.setText(String.valueOf(checks.get(activeTable).getTotalsum()));
        int addedIndex = checks.get(activeTable).getCheckList().size() - 1;

        model.addRow(new Object[]{
            checks.get(activeTable).getCheckList().get(addedIndex)
            .getDish().getTitle(),
            checks.get(activeTable).getCheckList().get(addedIndex)
            .getCount(),
            checks.get(activeTable).getCheckList().get(addedIndex)
            .getDish().getPrice(),
            checks.get(activeTable).getCheckList().get(addedIndex)
            .getSum(),
            dateFormat.format(checks.get(activeTable).getCheckList().
            get(addedIndex).getDate())
        });
    }

    private void fillPrices(int price) {
        btn1.setText("<html> 1 <br/> " + price + " грн. </html>");
        btn2.setText("<html> 2 <br/> " + price * 2 + " грн. </html>");
        btn3.setText("<html> 3 <br/> " + price * 3 + " грн. </html>");
        btn4.setText("<html> 4 <br/> " + price * 4 + " грн. </html>");
        btn5.setText("<html> 5 <br/> " + price * 5 + " грн. </html>");
        btn6.setText("<html> 6 <br/> " + price * 6 + " грн. </html>");
        btn7.setText("<html> 7 <br/> " + price * 7 + " грн. </html>");
        btn8.setText("<html> 8 <br/> " + price * 8 + " грн. </html>");
        btn9.setText("<html> 9 <br/> " + price * 9 + " грн. </html>");
        btn10.setText("<html> 10 <br/> " + price * 10 + " грн. </html>");
    }

    private void refreshListOfPrices() {
        int price = listofCat.get(activeCat).get(activeDishes).getPrice();
        String title = listofCat.get(activeCat).get(activeDishes).getTitle();
        if (jCheckBox1.isSelected()) {
            title = "(Вел.)" + title;
        }
        fillPrices(price);
    }

    private void jPanel5ComponentShown(java.awt.event.ComponentEvent evt) {//GEN-FIRST:event_jPanel5ComponentShown
        jList2.setSelectedIndex(0);
        activeDishes = 0;
        jList2.ensureIndexIsVisible(jList2.getSelectedIndex());
        clearCountButton();
        int price = listofCat.get(activeCat).get(0).getPrice();
        String title = listofCat.get(activeCat).get(0).getTitle();
        fillPrices(price);
        clearCheckboxs();
    }//GEN-LAST:event_jPanel5ComponentShown

    private void clearCountButton() {
        btn1.setBackground(BLUE);
        btn2.setBackground(BLUE);
        btn3.setBackground(BLUE);
        btn4.setBackground(BLUE);
        btn5.setBackground(BLUE);
        btn6.setBackground(BLUE);
        btn7.setBackground(BLUE);
        btn8.setBackground(BLUE);
        btn9.setBackground(BLUE);
        btn10.setBackground(BLUE);
    }

    private void chooseCat(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_chooseCat
        jTabbedPane1.setEnabledAt(2, true);
        jTabbedPane1.setSelectedIndex(2);
        int catId = getButtonId(evt);
        if (catId > 5) {
            catId++;
        }
        jList2.setListData(listofCat.get(catId).toArray());
        activeCat = catId;
        jTabbedPane1.setIconAt(2, icons.get(activeCat));
        if (activeCat == 5) {
            jCheckBox1.setVisible(true);
            jCheckBox1.setSelected(false);
        }
    }//GEN-LAST:event_chooseCat

    private void chooseCount(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_chooseCount
        addRecordToTable(getButtonId(evt));
        evt.getComponent().setBackground(RED);
    }//GEN-LAST:event_chooseCount

    private void clearTable(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_clearTable
        if (jButton9.isEnabled()) {
            checks.get(activeTable).getCheckList().clear();
            jTabbedPane1.setSelectedIndex(0);
            for (int i = 0; i < tablesCount; i++) {
                if (Integer.parseInt(jPanel2.getComponent(i).getName().
                        substring(3)) == activeTable) {
                    jPanel2.getComponent(i).setBackground(GREEN);
                    jTabbedPane1.setEnabledAt(1, false);
                    jTabbedPane1.setEnabledAt(2, false);
                    jLabel4.setText("Стіл № ");
                    DefaultTableModel model
                            = (DefaultTableModel) jTable1.getModel();
                    model.setRowCount(0);
                    jTextField1.setText("0");
                    jButton10.setBackground(Color.WHITE);
                }
            }
            jButton10.setBackground(Color.WHITE);
            jButton10.setEnabled(true);
            System.out.println("actTable=" + activeTable);
            jButton3.setEnabled(false);
            jButton7.setEnabled(false);
            jButton9.setEnabled(false);
            jButton10.setEnabled(false);
        }
    }//GEN-LAST:event_clearTable

    private void removeCheckItem(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_removeCheckItem
        DefaultTableModel model = (DefaultTableModel) jTable1.getModel();
        System.out.println("selectedRow" + jTable1.getSelectedRow());
        int activeRow = jTable1.getSelectedRow();
        if (jTable1.getRowCount() != 0) {
            if (!jTable1.getValueAt(jTable1.getRowCount() - 1, 0).equals("")) {
                model.removeRow(jTable1.getRowCount() - 1);
                checks.get(activeTable).getCheckList().
                        remove(checks.get(activeTable).
                                getCheckList().size() - 1);
            }
        }
        jTextField1.setText("" + checks.get(activeTable).getTotalsum());
    }//GEN-LAST:event_removeCheckItem

    private void formComponentShown(java.awt.event.ComponentEvent evt) {//GEN-FIRST:event_formComponentShown
        DefaultTableModel model = (DefaultTableModel) jTable2.getModel();
        if (User.getActiveUser == userList.size() - 1) {
            jLabel5.setText("  " + userList.get(User.getActiveUser).getName());
            jLabel5.setBackground(RED);
            model.setColumnCount(1);
            model.addColumn("пароль");

            jButton4.setVisible(true);
            jButton5.setVisible(true);
            jButton14.setVisible(true);
            jButton15.setVisible(true);
            jButton17.setVisible(true);
            jTextField3.setVisible(true);
            jPasswordField1.setForeground(RED);
            jButton1.setVisible(true);
            jButton11.setVisible(true);
            jButton12.setVisible(true);
            jButton19.setVisible(true);
            jTextField2.setVisible(true);
            jTextField4.setVisible(true);
            jLabel8.setVisible(true);
            jLabel9.setVisible(true);
        } else {
            jLabel5.setText("  " + userList.get(User.getActiveUser).getName());
            jLabel5.setForeground(BLUE);
            model.setColumnCount(1);
            model.addColumn("Початок");
            model.addColumn("Кінець");
        }
        initMainForm();
        initPassTable();
    }//GEN-LAST:event_formComponentShown

//    public void printComponenet() {
//
//        PrinterJob pj = PrinterJob.getPrinterJob();
//        pj.setJobName(" Print Component ");
//        
//        pj.setPrintable(new Printable() {
//
//            @Override
//            public int print(Graphics pg, PageFormat pf, int pageNum) {
//                if (pageNum > 0) {
//                    return Printable.NO_SUCH_PAGE;
//                }
//
//                Graphics2D g2 = (Graphics2D) pg;
//                g2.translate(pf.getImageableX(), pf.getImageableY());
//                jPanel3.paint(g2);
//                return Printable.PAGE_EXISTS;
//            }
//        });
//        PrintService[] printServices;
//        PrintService printService;
//        String printerName = "Canon iP2700 series";
//
//        PrintServiceAttributeSet printServiceAttributeSet = new HashPrintServiceAttributeSet();
//        printServiceAttributeSet.add(new PrinterName(printerName, null));
//        printServices = PrintServiceLookup.lookupPrintServices(null, printServiceAttributeSet);
//        
//       
//       
//        
//        if (pj.printDialog() == false) {
//            return;
//        }
//
//        try {
//            printService = printServices[0];
//            pj.setPrintService(printService);
//            pj.print();
//        } catch (PrinterException ex) {
//            // handle exception
//        }
//    }
    public void markCheckItems() {
        DefaultTableModel model = (DefaultTableModel) jTable1.getModel();
        model.addRow(new Object[]{
            "", null, null, null
        });
    }
    private void PrintCheck(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_PrintCheck
        //  printComponenet(); 
        if (activeCat != 9 || activeCat != 10) {
            if (!jTable1.getValueAt(jTable1.getRowCount() - 1, 0).equals("")) {
                markCheckItems();
                System.out.println("activeCat" + activeCat);

//        if (jButton3.isEnabled()) {
//            if (checks.get(activeTable).getTotalsum() != 0) {
//                DateFormat dateFormat = new SimpleDateFormat(
//                                                        "HH:mm:ss dd/MM/yyyy");
//                MessageFormat header = new MessageFormat(
//                                                dateFormat.format(new Date()));
//                MessageFormat footer = new MessageFormat(LoginForm.userList.
//                        get(User.getActiveUser).getName() 
//                        + "\t" + "Сума по чеку: "
//                        + String.valueOf(checks.get(activeTable).getTotalsum())
//                        + " грн.");
//
//                PrintRequestAttributeSet set = new HashPrintRequestAttributeSet();
//                set.add(OrientationRequested.PORTRAIT);
//                try {
//                    jTable1.print(JTable.PrintMode.FIT_WIDTH, header, footer, false, set, false);
//
//                } catch (PrinterException ex) {
//                    Logger.getLogger(MainForm.class.getName()).log(Level.SEVERE, null, ex);
//                    JOptionPane.showMessageDialog(null, "\n" + "Помилка роботи принтера "
//                            + "\n" + ex);
//                } catch (HeadlessException ex) {
//                    Logger.getLogger(MainForm.class.getName()).log(Level.SEVERE, null, ex);
//                    JOptionPane.showMessageDialog(null, "\n" + "Error from Printer Job "
//                            + "\n" + ex);
//                }
//                CalculFromDB();
//            }
//
//        }
            }
        }
    }//GEN-LAST:event_PrintCheck
    private void sortListOfDish(List list, final int orderArg) {
        Collections.sort(list, new Comparator<Dish>() {
            @Override
            public int compare(Dish o1, Dish o2) {
                if (orderArg == 0) {
                    return ((Integer) o1.getDbID()).compareTo(o2.getDbID());
                } else if (orderArg == 1) {
                    return ((Integer) o1.getPrice()).compareTo(o2.getPrice());
                } else {
                    return o1.getTitle().compareToIgnoreCase(o2.getTitle());
                }
            }
        });
    }

    private void sortListOfIngredients(List list, final int orderArg) {
        Collections.sort(list, new Comparator<Ingredient>() {
            @Override
            public int compare(Ingredient o1, Ingredient o2) {
                if (orderArg == 0) {
                    return ((Integer) o1.getId()).compareTo(o2.getId());
                } else if (orderArg == 1) {
                    return ((Double) o2.getCount()).compareTo(o1.getCount());
                } else {
                    return o1.getTitle().compareToIgnoreCase(o2.getTitle());
                }
            }
        });
    }

    private void jComboBox1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBox1ActionPerformed
        for (ArrayList<Dish> listofCat1 : listofCat) {
            sortListOfDish(listofCat1, jComboBox1.getSelectedIndex());
        }
        jList2.setListData(listofCat.get(activeCat).toArray());
        jList2.ensureIndexIsVisible(0);
        jPanel5ComponentShown(null);
    }//GEN-LAST:event_jComboBox1ActionPerformed

    private void payCheck(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_payCheck
        if (jButton10.isEnabled()) {
            if (checks.get(activeTable).getTotalsum() != 0) {
                if (jTable1.getValueAt(jTable1.getRowCount() - 1, 0).equals("") || activeCat == 9 || activeCat == 10) {
                    if (activeCat == 9 || activeCat == 10) {
                        markCheckItems();
                    }
                    CheckUtils.addCheck(checks.get(activeTable), userList.get(User.getActiveUser));
                    checks.get(activeTable).setPayed(true);
                    jTable1.setBackground(lightRed);
                    dayCash += checks.get(activeTable).getTotalsum();
                    jTextField5.setText(String.valueOf(dayCash));

                    jButton10.setBackground(lightRed);
                    jButton3.setBackground(lightRed);
                    jButton7.setBackground(lightRed);
                    jButton10.setEnabled(false);
                    jButton3.setEnabled(false);
                    jButton7.setEnabled(false);
                    jTabbedPane1.setEnabledAt(1, false);
                    jTabbedPane1.setEnabledAt(2, false);
                    jTabbedPane1.setSelectedIndex(0);
                }
            }
        }
    }//GEN-LAST:event_payCheck

    private void jTabbedPane1MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTabbedPane1MousePressed
        if (jTabbedPane1.getSelectedIndex() != 2) {
            jCheckBox1.setVisible(false);
            clearCountButton();
        }
    }//GEN-LAST:event_jTabbedPane1MousePressed

    private void clearDigit(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_clearDigit
        if (jPasswordField1.getPassword().length > 0) {
            jPasswordField1.setText("" + new String(jPasswordField1.
                    getPassword()).
                    substring(0, jPasswordField1.getPassword().length - 1));
        }
    }//GEN-LAST:event_clearDigit

    private void NumberPressed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_NumberPressed
        if (User.getActiveUser == userList.size() - 1) {
            jPasswordField1.setEchoChar((char) 0);
        }
        JButton myButton = (JButton) evt.getSource();
        if (myButton.isEnabled()) {
            jPasswordField1.setText("" + new String(jPasswordField1.
                    getPassword()) + myButton.getText());
        }
    }//GEN-LAST:event_NumberPressed


    private void loginEmployee(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_loginEmployee
        int activeRow = jTable2.getSelectedRow();
        if (jButton13.isEnabled() && !new String(jPasswordField1.
                getPassword()).equals("")) {
            DateFormat dateFormat = new SimpleDateFormat("HH:mm:ss dd/MM/yyyy");
            DefaultTableModel model = (DefaultTableModel) jTable2.getModel();
            if (employeeList.get(activeRow)
                    .getPass() == Integer.parseInt(new String(jPasswordField1.
                                    getPassword()))) {
                if (employeeList.get(activeRow).getActive() == 0) {
                    model.setValueAt(dateFormat.format(
                            new Date()), activeRow, 1);
                    employeeList.get(activeRow).setActive(1);
                } else if (employeeList.get(activeRow).getActive() == 1) {
                    model.setValueAt(dateFormat.format(
                            new Date()), activeRow, 2);
                    employeeList.get(activeRow).setActive(2);
                }
            } else {
                jLabel7.setText("Невірний пароль!");
            }
        }
        jPasswordField1.setText("");
    }//GEN-LAST:event_loginEmployee

    private void formWindowClosing(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosing
        JFrame frame = new JFrame();
        String[] options = new String[2];
        options[0] = "Так";
        options[1] = "Ні";
        int reply = JOptionPane.showOptionDialog(frame.getContentPane(),
                "Ви закрили касу?", "Закриття програми?", 0,
                JOptionPane.YES_NO_OPTION, null, options, null);
        if (reply == JOptionPane.YES_OPTION) {
            System.exit(0);
        }
    }//GEN-LAST:event_formWindowClosing

    private void PriceTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_PriceTyped
        char c = evt.getKeyChar();
        if (!(Character.isDigit(c) || (c == KeyEvent.VK_BACK_SPACE) || c == KeyEvent.VK_DELETE)) {
            evt.consume();
        }
    }//GEN-LAST:event_PriceTyped

    private void addDish(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addDish
        if (!jTextField2.getText().equals("") && !jTextField4.getText().equals("")) {
            String title = jTextField4.getText();
            int price = Integer.parseInt(jTextField2.getText());

            DishUtils.addDish(new Dish(title, price), activeCat);
            listofCat.get(activeCat).clear();
            DishUtils.readDBCategoryById(activeCat);
            jList2.clearSelection();
            jList2.setListData(listofCat.get(activeCat).toArray());
            jList2.ensureIndexIsVisible(jList2.getModel().getSize() - 1);
            jList2.setSelectedIndex(jList2.getModel().getSize() - 1);
            getListItem(null);
        }
    }//GEN-LAST:event_addDish

    private void removeDish(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_removeDish
        System.out.println("selectd index = " + jList2.getSelectedIndex());
        int activeIndex = jList2.getSelectedIndex();
        int dbId = listofCat.get(activeCat).get(activeIndex).getDbID();
        if (activeIndex >= 0) {
            DishUtils.removeDishById(dbId, activeCat);
            listofCat.get(activeCat).clear();
            DishUtils.readDBCategoryById(activeCat);
            jList2.clearSelection();
            jList2.setListData(listofCat.get(activeCat).toArray());
            jList2.ensureIndexIsVisible(jList2.getModel().getSize() - 1);
            jList2.setSelectedIndex(jList2.getModel().getSize() - 1);
            getListItem(null);
        }
    }//GEN-LAST:event_removeDish

    private void showCalcTable(JTable jTable) {
        DefaultTableModel model = (DefaultTableModel) jTable.getModel();
        model.setRowCount(0);
        if (jTable.getColumnCount() == 3) {
            for (Ingredient storageList1 : storageList) {
                model.addRow(new Object[]{
                    storageList1.getId(),
                    storageList1.getTitle(),
                    storageList1.getCount()
                });
            }
        }else if (jTable.getColumnCount() == 4) {
            for (Ingredient storageList1 : storageList) {
                model.addRow(new Object[]{
                    storageList1.getId(),
                    storageList1.getTitle(),
                    storageList1.getCount(),
                    0.0
                });
            }            
        }             
    }
    private void refreshCalc(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_refreshCalc
        jTabbedPane1.setVisible(false);
        jPanel3.setVisible(false);
        jPanel7.setVisible(true);
        jPanel10.setVisible(true);       
        String title = listofCat.get(activeCat).get(activeDishes).getTitle();
        jLabel12.setText(title);
        //join between storageList(all count = 0) and exist recipes into storageList
        ArrayList<Ingredient> tmpList = new ArrayList<>();
        tmpList.addAll(listofCat.get(activeCat).get(activeDishes).getListOfIngredients());
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
        showCalcTable(jTable3);
        
    }//GEN-LAST:event_refreshCalc

    private void goToMainMenu(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_goToMainMenu
        jPanel6.setVisible(false);
        jTabbedPane1.setVisible(true);
        mainForm.setSize(1149, 697);
    }//GEN-LAST:event_goToMainMenu

    private void exitFromCalculation(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_exitFromCalculation
        jPanel7.setVisible(false);
        jPanel10.setVisible(false);
        jPanel3.setVisible(true);
        jTabbedPane1.setVisible(true);        
    }//GEN-LAST:event_exitFromCalculation

    private void exitSystem(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_exitSystem
        CheckUtils.setCheckId(0);
        mainForm.setVisible(false);
        mainForm.setEnabled(false);
        loginForm.getDate();
        loginForm.setVisible(true);
        jButton1.setVisible(false);
        jButton11.setVisible(false);
        jButton12.setVisible(false);
        jButton19.setVisible(false);
        jTextField2.setVisible(false);
        jTextField4.setVisible(false);
        jLabel8.setVisible(false);
        jLabel9.setVisible(false);
        jButton14.setVisible(false);
        jButton15.setVisible(false);
        jButton17.setVisible(false);
        jTextField3.setVisible(false);
        jButton4.setVisible(false);
        jButton5.setVisible(false);

        DefaultTableModel model = (DefaultTableModel) jTable2.getModel();
        model.setRowCount(0);
        employeeList.clear();
        jTabbedPane1.setSelectedIndex(0);
    }//GEN-LAST:event_exitSystem

    private void updateTitleAndPrice(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_updateTitleAndPrice
        int index = jList2.getSelectedIndex();
        int dbId = listofCat.get(activeCat).get(index).getDbID();
        String title = jTextField4.getText();
        System.out.println("title = " + title);
        int price = Integer.parseInt(jTextField2.getText());
        if (!title.equals("")) {
            DishUtils.updateDishTitle(dbId, title, activeCat);
        }
        if (price != 0) {
            DishUtils.updateDishPrice(dbId, price, activeCat);
        }
        listofCat.get(activeCat).clear();
        DishUtils.readDBCategoryById(activeCat);
        jList2.clearSelection();
        jList2.setListData(listofCat.get(activeCat).toArray());
        jList2.ensureIndexIsVisible(index);
        jList2.setSelectedIndex(index);
        getListItem(null);
    }//GEN-LAST:event_updateTitleAndPrice

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
//          JSONUtils.writeAllIngredients();
    }//GEN-LAST:event_jButton5ActionPerformed

    private void setSort(JComboBox comboBox, JTable table){
        int index = comboBox.getSelectedIndex();
        sortListOfIngredients(storageList, index);
        showCalcTable(table);
        if (index == 1 || index == 2) {
            table.setRowSelectionInterval(0, 0);
            Rectangle cellRect = jTable3.getCellRect(0, 0, true);
            table.scrollRectToVisible(cellRect);
        }
    }
    private void saveCalculation(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_saveCalculation
        ArrayList<Ingredient> changedList = new ArrayList<>();
        for (int i = 0; i < jTable3.getRowCount(); i++) {
            int dbId = Integer.parseInt(jTable3.getValueAt(i, 0).toString());
            String title = jTable3.getValueAt(i, 1).toString();
            double count;
            try {
                 count = Double.parseDouble(jTable3.getValueAt(i, 2).toString());
            } catch (NumberFormatException e) {
                count = 0.0;
            }                   
            if (count != 0.0) {
                changedList.add(new Ingredient(dbId, title, count));
            }
        }
        JSONUtils.updateDishIngredients(changedList, activeCat, activeDishes);
        String JSONString = RecepiesUtils.readRecipesFromDB(activeCat,
                listofCat.get(activeCat).get(activeDishes).getDbID());
        System.out.println("JSONString=" + JSONString);
        JSONUtils.setJSONToRecipes(JSONString, activeCat, activeDishes);
        refreshCalc(null);

    }//GEN-LAST:event_saveCalculation

    private void changePizzaSize(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_changePizzaSize
        clearCountButton();
        if (jCheckBox1.isSelected()) {
            jList2.setListData(listofCat.get(6).toArray());
            jCheckBox1.setBackground(GREEN);
            activeCat = 6;
        } else {
            jCheckBox1.setBackground(RED);
            jList2.setListData(listofCat.get(5).toArray());
            activeCat = 5;
        }
        if (activeDishes != -1) {
            jList2.setSelectedIndex(activeDishes);
        }
        refreshListOfPrices();
    }//GEN-LAST:event_changePizzaSize

    private void jButton23exitFromCalculation(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton23exitFromCalculation
        jPanel8.setVisible(false);
        jTabbedPane1.setVisible(true);
        mainForm.setSize(1149, 697);
    }//GEN-LAST:event_jButton23exitFromCalculation

    private void addIngredient(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addIngredient
        String title = jTextField6.getText();
        if (!title.equals("")) {
            StorageUtils.addIngredientToDB(new Ingredient(title));
            StorageUtils.readStorage();
            showCalcTable(jTable5);
        }
        
        
        

    }//GEN-LAST:event_addIngredient

    private void removeIngredient(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_removeIngredient
        int index = jTable5.getSelectedRow();
        if (index != -1) {
            StorageUtils.removeIngredientFromDB(storageList.get(index).getId());
            StorageUtils.readStorage();
            showCalcTable(jTable5);            
        }        
    }//GEN-LAST:event_removeIngredient

    private void goToStorage(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_goToStorage
        jPanel8.setVisible(true);
        jTabbedPane1.setVisible(false);
        StorageUtils.readStorage();
        showCalcTable(jTable5);
        mainForm.setSize(655, 700);
    }//GEN-LAST:event_goToStorage

    private void jComboBox3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBox3ActionPerformed
        setSort(jComboBox3, jTable5);
    }//GEN-LAST:event_jComboBox3ActionPerformed

    private void jTextField3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField3ActionPerformed

    }//GEN-LAST:event_jTextField3ActionPerformed

    private void EmployeeSelected(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_EmployeeSelected
        jPasswordField1.setText("");
        jLabel7.setText("введіть пароль");
        jButton24.setEnabled(true);
        jButton25.setEnabled(true);
        jButton26.setEnabled(true);
        jButton27.setEnabled(true);
        jButton28.setEnabled(true);
        jButton29.setEnabled(true);
        jButton30.setEnabled(true);
        jButton31.setEnabled(true);
        jButton32.setEnabled(true);
        jButton33.setEnabled(true);
        jButton34.setEnabled(true);
        jButton13.setEnabled(true);
    }//GEN-LAST:event_EmployeeSelected

    private void updateUserAndEmployee(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_updateUserAndEmployee
        int activeRow = jTable2.getSelectedRow();
        String name = jTextField3.getText();
        int listIndex = activeRow - userList.size();
        String newPass = new String(jPasswordField1.getPassword());
        DefaultTableModel model = (DefaultTableModel) jTable2.getModel();
        if (activeRow < userList.size()) {
            int dbId = employeeList.get(activeRow).getDbId();
            if (!name.equals("")) {
                UsersUtils.updateUserName(dbId, name);
                System.out.println("name");
            }
            if (!newPass.equals("")) {
                UsersUtils.updateUserPass(dbId, Integer.parseInt(newPass));
                System.out.println("pass");
            }
            userList.clear();
            UsersUtils.readAllUsers();
        } else {
            int dbId = employeeList.get(activeRow - userList.size()).getDbId();
            if (!name.equals("")) {
                EmployeeUtils.updateEmployeeName(dbId, name);
            }
            if (!newPass.equals("")) {
                EmployeeUtils.updateEmployeePass(dbId, Integer.parseInt(newPass));
            }
        }
        model.setRowCount(0);
        employeeList.clear();
        initPassTable();
        jTable2.setRowSelectionInterval(activeRow, activeRow);
        Rectangle cellRect = jTable2.getCellRect(activeRow, 0, true);
        jTable2.scrollRectToVisible(cellRect);
    }//GEN-LAST:event_updateUserAndEmployee

    private void removeEmployee(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_removeEmployee
        System.out.println("size in remove" + employeeList.size());
        int activeRow = jTable2.getSelectedRow();
        int listIndex = activeRow - userList.size();
        System.out.println("activeRow= " + activeRow);
        if (activeRow > 5) {
            EmployeeUtils.removeById(employeeList.get(listIndex).getDbId());
            DefaultTableModel model = (DefaultTableModel) jTable2.getModel();
            model.setRowCount(0);
            employeeList.clear();
            initPassTable();
            jTable2.setRowSelectionInterval(jTable2.getRowCount() - 1, jTable2.getRowCount() - 1);
            Rectangle cellRect = jTable2.getCellRect(jTable2.getRowCount() - 1, 0, true);
            jTable2.scrollRectToVisible(cellRect);
        }
    }//GEN-LAST:event_removeEmployee

    private void addEmployee(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addEmployee
        String name = jTextField3.getText();
        String pass = new String(jPasswordField1.getPassword());
        if (!name.equals("") && !pass.equals("")) {
            EmployeeUtils.addEmployeeToDB(name, Integer.parseInt(pass));
            DefaultTableModel model = (DefaultTableModel) jTable2.getModel();
            model.setRowCount(0);
            employeeList.clear();
            initPassTable();
            jTable2.setRowSelectionInterval(jTable2.getRowCount() - 1, jTable2.getRowCount() - 1);
            Rectangle cellRect = jTable2.getCellRect(jTable2.getRowCount() - 1, 0, true);
            jTable2.scrollRectToVisible(cellRect);
        }
    }//GEN-LAST:event_addEmployee

    private void setNumber(JButton button, JTable table, int columnIndex){
        int index = table.getSelectedRow();        
          String old =  table.getValueAt(index, columnIndex).toString();
          old = old.trim();
          if (old.equals("0.0")) {
            old = "";
        }
          String newLine = old + button.getText();
          if (newLine.length() < 7) {
              if (newLine.length() == 2) {
                  newLine +=".";
              }
              table.setValueAt(newLine, index, columnIndex);            
        } 
    }
    private void PressNumber(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_PressNumber
        JButton myButton = (JButton) evt.getSource();
        setNumber(myButton, jTable3, 2);           
    }//GEN-LAST:event_PressNumber

    private void jComboBox4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBox4ActionPerformed
        setSort(jComboBox4, jTable3);
    }//GEN-LAST:event_jComboBox4ActionPerformed

    private void IngredientSelected(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_IngredientSelected
        jButton53.setEnabled(true);
        jButton54.setEnabled(true);
        jButton55.setEnabled(true);
        jButton56.setEnabled(true);
        jButton57.setEnabled(true);
        jButton58.setEnabled(true);
        jButton59.setEnabled(true);
        jButton60.setEnabled(true);
        jButton61.setEnabled(true);
        jButton62.setEnabled(true);
        jButton63.setEnabled(true);
        jButton64.setEnabled(true);
    }//GEN-LAST:event_IngredientSelected

    private void deleteDigit(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_deleteDigit
        int index = jTable3.getSelectedRow();
        String old = jTable3.getValueAt(index, 2).toString();
        if (old.length() > 0) {
            old = old.substring(0, old.length() - 1);
            System.out.println("old" + old);
            jTable3.setValueAt(old, index, 2);
        }

        
        
    }//GEN-LAST:event_deleteDigit

    private void clearDigitLine(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_clearDigitLine
        int index = jTable3.getSelectedRow();
        jTable3.setValueAt("", index, 2);        
    }//GEN-LAST:event_clearDigitLine

    private void jButton66deleteDigit(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton66deleteDigit
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton66deleteDigit

    private void jButton67PressNumber(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton67PressNumber
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton67PressNumber

    private void jButton74PressNumber(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton74PressNumber
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton74PressNumber

    private void jButton65PressNumber(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton65PressNumber
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton65PressNumber

    private void jButton76clearDigitLine(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton76clearDigitLine
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton76clearDigitLine

    private void jButton68PressNumber(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton68PressNumber
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton68PressNumber

    private void jButton69PressNumber(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton69PressNumber
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton69PressNumber

    private void jButton70PressNumber(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton70PressNumber
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton70PressNumber

    private void jButton72PressNumber(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton72PressNumber
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton72PressNumber

    private void jButton75PressNumber(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton75PressNumber
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton75PressNumber

    private void jButton73PressNumber(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton73PressNumber
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton73PressNumber

    private void jButton71PressNumber(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton71PressNumber
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton71PressNumber

    private void jButton21exitFromCalculation(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton21exitFromCalculation
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton21exitFromCalculation

    private void jComboBox5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBox5ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jComboBox5ActionPerformed

    private void clearCheckboxs() {
        jCheckBox1.setSelected(false);
        jCheckBox1.setBackground(RED);
    }

    private void initLoginForm() {
        loginForm = new LoginForm();
        loginForm.setVisible(true);
        loginForm.toFront();
        loginForm.setAlwaysOnTop(true);
        loginForm.addWindowListener(new WindowListener() {

            @Override
            public void windowOpened(WindowEvent e) {
            }

            @Override
            public void windowClosing(WindowEvent e) {
            }

            @Override
            public void windowClosed(WindowEvent e) {
                //mainForm.setEnabled(true);
            }

            @Override
            public void windowIconified(WindowEvent e) {
            }

            @Override
            public void windowDeiconified(WindowEvent e) {
            }

            @Override
            public void windowActivated(WindowEvent e) {
            }

            @Override
            public void windowDeactivated(WindowEvent e) {
                //mainForm.setEnabled(true);
            }

        });

    }

    private void initPassTable() {
        EmployeeUtils.readAllEmployees();
        DefaultTableModel model = (DefaultTableModel) jTable2.getModel();
        if (User.getActiveUser == userList.size() - 1) {
            for (int i = 0; i < userList.size(); i++) {
                model.addRow(new Object[]{
                    userList.get(i).getName(),
                    userList.get(i).getPass()
                });
            }
            for (int i = 0; i < employeeList.size(); i++) {
                model.addRow(new Object[]{
                    employeeList.get(i).getName(),
                    employeeList.get(i).getPass()
                });
            }
        } else {
            for (int i = 0; i < employeeList.size(); i++) {
                model.addRow(new Object[]{
                    employeeList.get(i).getName(), null, null
                });
            }
        }
    }

    public void initMainForm() {
        Locale locale = new Locale("uk", "UA");
        DateFormat dateFormat = new SimpleDateFormat("EEEE, dd/MM/yyyy", locale);
        this.setTitle("SmartCafe " + dateFormat.format(new Date()));
    }
    private void initCalculationTable(){
        try {
            setColumnRender(jTable3.getColumnModel().getColumn(2));
            setColumnRender(jTable5.getColumnModel().getColumn(2));
            setColumnRender(jTable5.getColumnModel().getColumn(3));
            
        } catch (ParseException ex) {
            Logger.getLogger(MainForm.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    //initCalculationTable
    private void setColumnRender(TableColumn column) throws ParseException {
        DefaultTableCellRenderer leftRenderer = new DefaultTableCellRenderer();
        leftRenderer.setHorizontalAlignment(SwingConstants.LEFT);
        column.setCellRenderer(leftRenderer);       
        MaskFormatter mf2 = new MaskFormatter("#.###");
        JFormattedTextField formattedTextField = new JFormattedTextField(mf2);
        formattedTextField.setFont(new Font("Verdana", 0, 18));
        DefaultCellEditor dce = new DefaultCellEditor(formattedTextField);
        column.setCellEditor(dce);
    
                
    }

    public void initBDmenu() {
        ArrayList<Dish> fdishes = new ArrayList();
        ArrayList<Dish> salads = new ArrayList();
        ArrayList<Dish> rogerdishes = new ArrayList();
        ArrayList<Dish> pandishes = new ArrayList();
        ArrayList<Dish> meats = new ArrayList();
        ArrayList<Dish> pizzaS = new ArrayList();
        ArrayList<Dish> pizzaB = new ArrayList();
        ArrayList<Dish> sushi = new ArrayList();
        ArrayList<Dish> desserts = new ArrayList();
        ArrayList<Dish> drinks = new ArrayList();
        ArrayList<Dish> alcohols = new ArrayList();
        ArrayList<Dish> newCat1 = new ArrayList();
        ArrayList<Dish> newCat2 = new ArrayList();
        listofCat.add(fdishes);
        listofCat.add(salads);
        listofCat.add(rogerdishes);
        listofCat.add(pandishes);
        listofCat.add(meats);
        listofCat.add(pizzaS);
        listofCat.add(pizzaB);
        listofCat.add(sushi);
        listofCat.add(desserts);
        listofCat.add(drinks);
        listofCat.add(alcohols);
        listofCat.add(newCat1);
        listofCat.add(newCat2);

        DishUtils.readDBmenu();
        StorageUtils.readStorage();

    }
    private void InitComonentsProperty(){
        
        
        jCheckBox1.setVisible(false);
        jTabbedPane1.setEnabledAt(1, false);
        jTabbedPane1.setEnabledAt(2, false);
        jTextField2.setLayout(new AbsoluteLayout());
        jTextField2.setVisible(false);
        jTable4.setVisible(false);
        jButton4.setVisible(false);
        jButton5.setVisible(false);
        jButton1.setVisible(false);
        jButton11.setVisible(false);
        jButton12.setVisible(false);
        jButton14.setVisible(false);
        jButton14.setBackground(GREEN);
        jButton15.setVisible(false);
        jButton17.setVisible(false);
        jButton19.setVisible(false);
        jButton15.setBackground(RED);
        jTextField3.setVisible(false);
        jTextField2.setVisible(false);
        jTextField4.setVisible(false);
        jPanel6.setVisible(false);
        jLabel8.setVisible(false);
        jLabel9.setVisible(false);
        jPanel7.setVisible(false);
        jPanel8.setVisible(false);
        jPanel10.setVisible(false);
        jPanel11.setVisible(false);
        jButton11.setBackground(GREEN);
        jButton1.setBackground(RED);
        jButton36.setBackground(GREEN);
        jButton37.setBackground(RED);
        jButton38.setBackground(GREEN);
        jButton35.setBackground(RED);
    }

//    public void refreshBDmenu(int orderArg) {
//        DishUtils.readDBmenu();
//    }

    public void initIcons() {
        icons.add(new ImageIcon(getClass().
                getResource("/cafe/icons/small/hot-food.png")));
        icons.add(new ImageIcon(getClass().
                getResource("/cafe/icons/small/salad.png")));
        icons.add(new ImageIcon(getClass().
                getResource("/cafe/icons/small/burger.png")));
        icons.add(new ImageIcon(getClass().
                getResource("/cafe/icons/small/fryingpan1.png")));
        icons.add(new ImageIcon(getClass().
                getResource("/cafe/icons/small/christmas161.png")));
        icons.add(new ImageIcon(getClass().
                getResource("/cafe/icons/small/italian1.png")));
        icons.add(new ImageIcon(getClass().
                getResource("/cafe/icons/small/italian1.png")));
        icons.add(new ImageIcon(getClass().
                getResource("/cafe/icons/small/sushi6.png")));
        icons.add(new ImageIcon(getClass().
                getResource("/cafe/icons/small/ice53.png")));
        icons.add(new ImageIcon(getClass().
                getResource("/cafe/icons/small/coffee127.png")));
        icons.add(new ImageIcon(getClass().
                getResource("/cafe/icons/small/drink175.png")));
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        mainForm = new MainForm();
        mainForm.setIconImage(null);
    }
    private static int dayCash;
    public static ArrayList<Employee> employeeList = new ArrayList<>();
    private static Map<Integer, Check> checks = new HashMap<Integer, Check>();
    private static final int tablesCount = 25;
    public static int activeDishes;
    public static int activeCat;
    private static int activeTable;
    public static ArrayList<Ingredient> storageList = new ArrayList<>();
    public static ArrayList<ArrayList<Dish>> listofCat = new ArrayList<>();
    private static final ArrayList<Icon> icons = new ArrayList<>();
    private static ArrayList<CheckItem> dayList = new ArrayList<>();
    public static MainForm mainForm;
    private static LoginForm loginForm;
    private static final Color RED = new Color(255, 102, 102);
    private static final Color BLUE = new Color(0, 153, 204);
    private static final Color lightRed = new Color(255, 102, 102);
    private static final Color GREEN = new Color(0, 153, 102);
//    private static final Color WHITE = new Color(255, 255, 255);
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn1;
    private javax.swing.JButton btn10;
    private javax.swing.JButton btn2;
    private javax.swing.JButton btn3;
    private javax.swing.JButton btn4;
    private javax.swing.JButton btn5;
    private javax.swing.JButton btn6;
    private javax.swing.JButton btn7;
    private javax.swing.JButton btn8;
    private javax.swing.JButton btn9;
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
    private javax.swing.JButton jButton15;
    private javax.swing.JButton jButton17;
    private javax.swing.JButton jButton18;
    private javax.swing.JButton jButton19;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton20;
    private javax.swing.JButton jButton21;
    private javax.swing.JButton jButton23;
    private javax.swing.JButton jButton24;
    private javax.swing.JButton jButton25;
    private javax.swing.JButton jButton26;
    private javax.swing.JButton jButton27;
    private javax.swing.JButton jButton28;
    private javax.swing.JButton jButton29;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton30;
    private javax.swing.JButton jButton31;
    private javax.swing.JButton jButton32;
    private javax.swing.JButton jButton33;
    private javax.swing.JButton jButton34;
    private javax.swing.JButton jButton35;
    private javax.swing.JButton jButton36;
    private javax.swing.JButton jButton37;
    private javax.swing.JButton jButton38;
    private javax.swing.JButton jButton39;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JButton jButton53;
    private javax.swing.JButton jButton54;
    private javax.swing.JButton jButton55;
    private javax.swing.JButton jButton56;
    private javax.swing.JButton jButton57;
    private javax.swing.JButton jButton58;
    private javax.swing.JButton jButton59;
    private javax.swing.JButton jButton6;
    private javax.swing.JButton jButton60;
    private javax.swing.JButton jButton61;
    private javax.swing.JButton jButton62;
    private javax.swing.JButton jButton63;
    private javax.swing.JButton jButton64;
    private javax.swing.JButton jButton65;
    private javax.swing.JButton jButton66;
    private javax.swing.JButton jButton67;
    private javax.swing.JButton jButton68;
    private javax.swing.JButton jButton69;
    private javax.swing.JButton jButton7;
    private javax.swing.JButton jButton70;
    private javax.swing.JButton jButton71;
    private javax.swing.JButton jButton72;
    private javax.swing.JButton jButton73;
    private javax.swing.JButton jButton74;
    private javax.swing.JButton jButton75;
    private javax.swing.JButton jButton76;
    private javax.swing.JButton jButton8;
    private javax.swing.JButton jButton9;
    private javax.swing.JCheckBox jCheckBox1;
    private javax.swing.JComboBox jComboBox1;
    private javax.swing.JComboBox jComboBox3;
    private javax.swing.JComboBox jComboBox4;
    private javax.swing.JComboBox jComboBox5;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JList jList2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel10;
    private javax.swing.JPanel jPanel11;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JPasswordField jPasswordField1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JScrollPane jScrollPane6;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JTable jTable2;
    private javax.swing.JTable jTable3;
    private javax.swing.JTable jTable4;
    private javax.swing.JTable jTable5;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextField jTextField2;
    private javax.swing.JTextField jTextField3;
    private javax.swing.JTextField jTextField4;
    private javax.swing.JTextField jTextField5;
    private javax.swing.JTextField jTextField6;
    private javax.swing.JButton table01;
    private javax.swing.JButton table02;
    private javax.swing.JButton table03;
    private javax.swing.JButton table10;
    private javax.swing.JButton table11;
    private javax.swing.JButton table12;
    private javax.swing.JButton table13;
    private javax.swing.JButton table14;
    private javax.swing.JButton table15;
    private javax.swing.JButton table16;
    private javax.swing.JButton table17;
    private javax.swing.JButton table18;
    private javax.swing.JButton table19;
    private javax.swing.JButton table20;
    private javax.swing.JButton table21;
    private javax.swing.JButton table22;
    private javax.swing.JButton table23;
    private javax.swing.JButton table24;
    private javax.swing.JButton table25;
    private javax.swing.JButton table4;
    private javax.swing.JButton table5;
    private javax.swing.JButton table6;
    private javax.swing.JButton table7;
    private javax.swing.JButton table8;
    private javax.swing.JButton table9;
    // End of variables declaration//GEN-END:variables

}
