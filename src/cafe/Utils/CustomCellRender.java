/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cafe.Utils;

import java.awt.Color;
import java.awt.Component;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;

/**
 *
 * @author suxarina
 */
public class CustomCellRender extends DefaultTableCellRenderer {

    // This is a overridden function which gets executed for each action to
    /// your Jtable
    public Component getTableCellRendererComponent(JTable table,
            Object obj, boolean isSelected, boolean hasFocus, int row, int column) {
        
        Component comp = super.getTableCellRendererComponent(
                table, obj, isSelected, hasFocus, row, column);

        // Use this row, column to change color for the row you need, e.g.
        
        table.getModel().getValueAt(1, 1).toString();
        comp.setForeground(Color.GREEN);
        return  comp;
    }
}
