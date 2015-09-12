package cafe.view;

import cafe.model.User;
import static cafe.view.MainForm.mainForm;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import javax.swing.JButton;

/**
 *
 * @author suxarina
 */
public class LoginForm extends javax.swing.JFrame {

    /**
     * Creates new form LoginForm
     */
    public LoginForm() {
        initComponents();
        initPassTable();
        getDate();

    }

    private void initPassTable() {
        userList = new ArrayList<>();
        userList.add(new User("Оператор №1", 101));
        userList.add(new User("Оператор №2", 102));
        userList.add(new User("Оператор №3", 103));
        userList.add(new User("Оператор №4", 104));
        userList.add(new User("Оператор №5", 105));
        userList.add(new User("Адміністратор", 1));

    }

 
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jComboBox1 = new javax.swing.JComboBox();
        jButton1 = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        jButton6 = new javax.swing.JButton();
        jButton7 = new javax.swing.JButton();
        jButton8 = new javax.swing.JButton();
        jButton9 = new javax.swing.JButton();
        jButton10 = new javax.swing.JButton();
        jButton11 = new javax.swing.JButton();
        jButton5 = new javax.swing.JButton();
        jButton12 = new javax.swing.JButton();
        jPasswordField1 = new javax.swing.JPasswordField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Вхід в систему");
        setResizable(false);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowDeactivated(java.awt.event.WindowEvent evt) {
                formWindowDeactivated(evt);
            }
        });
        getContentPane().setLayout(null);

        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "оператор1", "оператор2", "оператор3", "оператор4", "оператор5", "Администратор" }));
        getContentPane().add(jComboBox1);
        jComboBox1.setBounds(370, 20, 134, 20);

        jButton1.setBackground(new java.awt.Color(0, 153, 0));
        jButton1.setText("відкрити касу");
        jButton1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jButton1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                enterToSystem(evt);
            }
        });
        getContentPane().add(jButton1);
        jButton1.setBounds(370, 110, 134, 30);

        jLabel1.setFont(new java.awt.Font("Verdana", 0, 11)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 51, 0));
        jLabel1.setText("введіть пароль");
        jLabel1.setToolTipText("");
        getContentPane().add(jLabel1);
        jLabel1.setBounds(370, 80, 140, 15);

        jLabel2.setFont(new java.awt.Font("Verdana", 0, 18)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(0, 153, 51));
        jLabel2.setText("<html>  date\n<br/> \ndate</html>  ");
        jLabel2.setToolTipText("");
        getContentPane().add(jLabel2);
        jLabel2.setBounds(10, 10, 160, 80);

        jButton2.setBackground(new java.awt.Color(204, 204, 204));
        jButton2.setFont(new java.awt.Font("Verdana", 0, 24)); // NOI18N
        jButton2.setText("9");
        jButton2.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                NumberPressed(evt);
            }
        });
        getContentPane().add(jButton2);
        jButton2.setBounds(300, 10, 50, 50);

        jButton3.setBackground(new java.awt.Color(204, 204, 204));
        jButton3.setFont(new java.awt.Font("Verdana", 0, 22)); // NOI18N
        jButton3.setText("C");
        jButton3.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                clearDigit(evt);
            }
        });
        getContentPane().add(jButton3);
        jButton3.setBounds(150, 10, 50, 50);

        jButton4.setBackground(new java.awt.Color(204, 204, 204));
        jButton4.setFont(new java.awt.Font("Verdana", 0, 24)); // NOI18N
        jButton4.setText("8");
        jButton4.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                NumberPressed(evt);
            }
        });
        getContentPane().add(jButton4);
        jButton4.setBounds(250, 10, 50, 50);

        jButton6.setBackground(new java.awt.Color(204, 204, 204));
        jButton6.setFont(new java.awt.Font("Verdana", 0, 24)); // NOI18N
        jButton6.setText("4");
        jButton6.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jButton6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                NumberPressed(evt);
            }
        });
        getContentPane().add(jButton6);
        jButton6.setBounds(200, 60, 50, 50);

        jButton7.setBackground(new java.awt.Color(204, 204, 204));
        jButton7.setFont(new java.awt.Font("Verdana", 0, 24)); // NOI18N
        jButton7.setText("5");
        jButton7.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jButton7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                NumberPressed(evt);
            }
        });
        getContentPane().add(jButton7);
        jButton7.setBounds(250, 60, 50, 50);

        jButton8.setBackground(new java.awt.Color(204, 204, 204));
        jButton8.setFont(new java.awt.Font("Verdana", 0, 24)); // NOI18N
        jButton8.setText("6");
        jButton8.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jButton8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                NumberPressed(evt);
            }
        });
        getContentPane().add(jButton8);
        jButton8.setBounds(300, 60, 50, 50);

        jButton9.setBackground(new java.awt.Color(204, 204, 204));
        jButton9.setFont(new java.awt.Font("Verdana", 0, 24)); // NOI18N
        jButton9.setText("3");
        jButton9.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jButton9.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                NumberPressed(evt);
            }
        });
        getContentPane().add(jButton9);
        jButton9.setBounds(300, 110, 50, 50);

        jButton10.setBackground(new java.awt.Color(204, 204, 204));
        jButton10.setFont(new java.awt.Font("Verdana", 0, 24)); // NOI18N
        jButton10.setText("0");
        jButton10.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jButton10.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                NumberPressed(evt);
            }
        });
        getContentPane().add(jButton10);
        jButton10.setBounds(150, 110, 50, 50);

        jButton11.setBackground(new java.awt.Color(204, 204, 204));
        jButton11.setFont(new java.awt.Font("Verdana", 0, 24)); // NOI18N
        jButton11.setText("2");
        jButton11.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jButton11.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                NumberPressed(evt);
            }
        });
        getContentPane().add(jButton11);
        jButton11.setBounds(250, 110, 50, 50);

        jButton5.setBackground(new java.awt.Color(204, 204, 204));
        jButton5.setFont(new java.awt.Font("Verdana", 0, 24)); // NOI18N
        jButton5.setText("7");
        jButton5.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                NumberPressed(evt);
            }
        });
        getContentPane().add(jButton5);
        jButton5.setBounds(200, 10, 50, 50);

        jButton12.setBackground(new java.awt.Color(204, 204, 204));
        jButton12.setFont(new java.awt.Font("Verdana", 0, 24)); // NOI18N
        jButton12.setText("1");
        jButton12.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jButton12.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                NumberPressed(evt);
            }
        });
        getContentPane().add(jButton12);
        jButton12.setBounds(200, 110, 50, 50);

        jPasswordField1.setToolTipText("");
        getContentPane().add(jPasswordField1);
        jPasswordField1.setBounds(370, 60, 130, 20);

        setSize(new java.awt.Dimension(536, 215));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void getDate() {
        Locale locale = new Locale("uk", "UA");
        DateFormat dateFormat = new SimpleDateFormat("EEEE", locale);
        DateFormat dateFormat1 = new SimpleDateFormat("HH:mm", locale);
        DateFormat dateFormat2 = new SimpleDateFormat("dd/MM/yyyy", locale);
        String date = "<html> " + dateFormat.format(new Date()) + "<br/>"
                + dateFormat1.format(new Date()) + "<br/> "
                + dateFormat2.format(new Date()) + "</html> ";

        jLabel2.setText(date);

    }
    private void enterToSystem(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_enterToSystem
        // TODO add your handling code here:       
        System.out.println("index= " + jComboBox1.getSelectedIndex());

        jLabel1.setText("");
        String pass = new String(jPasswordField1.getPassword());
        if (pass.equals("пароль") || pass.equals("")) {
            jLabel1.setText("Невірний пароль!");

        } else if (userList.get(jComboBox1.getSelectedIndex())
                .getPass() == Integer.parseInt(pass)) {
            User.activeUserOfList = jComboBox1.getSelectedIndex();         
            this.dispose();

        } else {
            jLabel1.setText("Невірний пароль!");
        }


    }//GEN-LAST:event_enterToSystem

    private void formWindowDeactivated(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowDeactivated
        // TODO add your handling code here:
        mainForm.setVisible(true);

    }//GEN-LAST:event_formWindowDeactivated

    private void NumberPressed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_NumberPressed
        // TODO add your handling code here:
        JButton myButton = (JButton) evt.getSource();
        jPasswordField1.setText("" + new String(jPasswordField1.getPassword())
                                                        + myButton.getText());
    }//GEN-LAST:event_NumberPressed

    private void clearDigit(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_clearDigit
        // TODO add your handling code here:
        if (jPasswordField1.getPassword().length > 0) {
            jPasswordField1.setText("" + jPasswordField1.getPassword().
                    toString().substring(0, jPasswordField1.
                            getPassword().length - 1));
        }

    }//GEN-LAST:event_clearDigit

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
            java.util.logging.Logger.getLogger(LoginForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(LoginForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(LoginForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(LoginForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new LoginForm().setVisible(true);
            }
        });
    }
    // private boolean sw = true;
    public static List<User> userList;
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton10;
    private javax.swing.JButton jButton11;
    private javax.swing.JButton jButton12;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JButton jButton6;
    private javax.swing.JButton jButton7;
    private javax.swing.JButton jButton8;
    private javax.swing.JButton jButton9;
    private javax.swing.JComboBox jComboBox1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPasswordField jPasswordField1;
    // End of variables declaration//GEN-END:variables
}
