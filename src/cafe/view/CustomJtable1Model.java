/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cafe.view;

import java.awt.Color;
import java.awt.Component;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;

/**
 *
 * @author suxarina
 */
public class CustomJtable1Model extends DefaultTableCellRenderer {
    public static int col;
    public static int rowz;
    

    /**
     *
     */
    private static final long serialVersionUID = 1L;
    
    

    @Override
    public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
        JLabel label = (JLabel) super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);
        Color c = Color.WHITE;
        if (isSelected && row == rowz & column == col) {
            c = Color.GREEN;
        }
        label.setBackground(c);
        return label;
    }
    
    public class CustomListener extends MouseAdapter {

        @Override
        public void mouseClicked(MouseEvent arg0) {
            super.mouseClicked(arg0);
            // Select the current cell
            
//            rowz = MainForm.jTable1.getSelectedRow();
//            col = MainForm.jTable1.getSelectedColumn();
//                
//            // Repaints JTable
//            MainForm.jTable1.repaint();
        }
    }
}
