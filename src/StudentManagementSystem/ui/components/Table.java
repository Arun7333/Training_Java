package StudentManagementSystem.ui.components;

import StudentManagementSystem.ui.main.GUI;
import StudentManagementSystem.ui.helpers.Validation;

import javax.swing.*;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import static java.lang.System.out;

public class Table {
    public JTable table;
    public DefaultTableModel dtm;
    private GUI gui;

    public Table(GUI gui){
        this.gui = gui;
        setTable();
    }

    public void setTable(){
        JPanel tablePanel = new JPanel(new GridBagLayout());
        GridBagConstraints cons = new GridBagConstraints();
        cons.insets = new Insets(10, 10, 10, 10);

        dtm = new DefaultTableModel(){
            @Override
            public boolean isCellEditable(int row, int col){
                if(col == 0) return false;//making the table non editable
                return true;
            }

            @Override
            public void setValueAt(Object value, int row, int col){
                int id = Integer.parseInt((String)table.getValueAt(row, 0));
                String colName = table.getColumnName(col);

                switch (colName){
                    case "Name":
                        String name = (String) value;
                        if(Validation.isName(name)) {
                            gui.manager.updateName(id, name);
                            super.setValueAt(value, row, col);
                        }
                        break;
                    case "Age":
                        String age = (String) value;
                        if(age.matches("\\d*") && !age.trim().isEmpty()) {
                            int val =  Integer.parseInt(age);

                            if(Validation.isAge(val)) {
                                gui.manager.updateAge(id, Integer.parseInt((String) value));
                                super.setValueAt(value, row, col);
                            }
                        }
                        break;
                    case "Email":
                        String email = (String) value;
                        if(Validation.isEmail(email)) {
                            gui.manager.updateEmail(id, email);
                            super.setValueAt(value, row, col);
                        }
                        break;
                    case "Grade":
                        String grade = (String) value;
                        if(Validation.isGrade(grade)) {
                            gui.manager.updateGrade(id, grade.charAt(0));
                            super.setValueAt(value, row, col);
                        }
                        break;
                }
            }
        };
        for(String field : gui.fields){
            dtm.addColumn(field);
        }

        table = new JTable(dtm);
        table.setRowHeight(28);
        table.setFont(new Font("SansSerif", Font.PLAIN, 14));
        addShortcuts();

        DefaultTableCellRenderer headerRenderer = (DefaultTableCellRenderer) table.getTableHeader().getDefaultRenderer();
        headerRenderer.setHorizontalAlignment(JLabel.CENTER);
        table.getTableHeader().setFont(new Font("SansSerif", Font.BOLD, 14));

        DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
        centerRenderer.setHorizontalAlignment(JLabel.CENTER);
        for (int i = 0; i < table.getColumnCount(); i++) {
            table.getColumnModel().getColumn(i).setCellRenderer(centerRenderer);
        }

        //setting width for each column
        table.getColumnModel().getColumn(0).setPreferredWidth(50);
        table.getColumnModel().getColumn(1).setPreferredWidth(150);
        table.getColumnModel().getColumn(2).setPreferredWidth(50);
        table.getColumnModel().getColumn(3).setPreferredWidth(200);
        table.getColumnModel().getColumn(4).setPreferredWidth(50);

        JScrollPane scrollPane = new JScrollPane(table);

        cons.gridx = 0;
        cons.gridy = 0;
        cons.weightx = 0.2;
        cons.anchor = GridBagConstraints.CENTER;
        cons.fill = GridBagConstraints.HORIZONTAL;
        tablePanel.add(scrollPane, cons);

        gui.window.add(tablePanel, BorderLayout.CENTER);
    }

    public void addShortcuts(){
        table.addKeyListener(new KeyListener() {
            @Override
            public void keyTyped(KeyEvent e) {}

            @Override
            public void keyPressed(KeyEvent e) {
                int keyCode = e.getKeyCode();

                if(e.isControlDown()){
                    if(keyCode == KeyEvent.VK_N){
                        gui.createDialog.open();
                    }
                    else if(keyCode == KeyEvent.VK_D){
                        deleteRow();
                    }
                }
            }

            @Override
            public void keyReleased(KeyEvent e) {}
        });
    }

    public void deleteRow(){
        int selectedRow = table.getSelectedRow();
        out.println(selectedRow);

        if(selectedRow != -1){
            int option = JOptionPane.showConfirmDialog(gui.window,
                    "Do you really want to delete?", "Delete Confirmation",
                    JOptionPane.YES_NO_OPTION, JOptionPane.WARNING_MESSAGE);

            if (option == JOptionPane.YES_OPTION) {
                int id = Integer.parseInt((String) table.getValueAt(selectedRow, 0));

                gui.manager.remove(id);
                dtm.removeRow(selectedRow);
            }
        }
    }
}
