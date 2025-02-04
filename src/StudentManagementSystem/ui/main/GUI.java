package StudentManagementSystem.ui.main;

import StudentManagementSystem.services.StudentManager;
import StudentManagementSystem.ui.components.CreateDialog;
import StudentManagementSystem.ui.components.Table;

import javax.swing.*;
import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class GUI {
    //shared resources
    public StudentManager manager;
    public JFrame window;
    public CreateDialog createDialog;
    public Table table;

    //datas
    public Font sansSerif = new Font("SansSerif", Font.PLAIN, 15);
    public String[] fields = new String[]{"Id", "Name", "Age", "Email", "Grade"};
    public static char[] grades = new char[]{'A', 'B', 'C', 'D'};

    public GUI(StudentManager manager){
        this.manager = manager;
        setWindow();
        createDialog = new CreateDialog(this);
        table = new Table(this);

        window.revalidate();
        window.repaint();
    }

    public void setWindow(){
        window = new JFrame();
        window.setTitle("Student Management System");
        window.setSize(900, 800);
        window.setDefaultCloseOperation(WindowConstants.DO_NOTHING_ON_CLOSE);

        window.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                int option = JOptionPane.showConfirmDialog(window,
                        "Do you really want to exit?", "Exit Confirmation",
                        JOptionPane.YES_NO_OPTION, JOptionPane.WARNING_MESSAGE);

                if (option == JOptionPane.YES_OPTION) {
                    manager.completeTasks();

                    System.exit(0);
                }
            }
        });
        window.setLayout(new BorderLayout());
        window.setLocationRelativeTo(null);
        window.setVisible(true);
    }

}

