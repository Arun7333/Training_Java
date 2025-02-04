package StudentManagementSystem.ui.components;

import StudentManagementSystem.models.Student;
import StudentManagementSystem.ui.models.Form;
import StudentManagementSystem.ui.main.GUI;
import StudentManagementSystem.ui.helpers.Validation;

import javax.swing.*;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import java.awt.*;
import java.util.Vector;

public class CreateDialog {
    private JDialog createDialog;
    private GUI gui;

    public CreateDialog(GUI gui){
        this.gui = gui;
    }

    public void open(){
        setCreateDialog();
        createDialog.setVisible(true);
    }

    public void setCreateDialog(){
        //Create Student dialog box main window
        createDialog = new JDialog(gui.window, "Create Student", true);
        createDialog.setSize(400, 300);
        createDialog.setResizable(false);
        createDialog.setLocationRelativeTo(gui.window);

        //Panel container for centralizing the input fields
        JPanel centerPanel = new JPanel(new GridBagLayout());
        GridBagConstraints constraints = new GridBagConstraints();
        constraints.insets = new Insets(5, 5, 5, 5);

        //Object for handling input form
        Form form = new Form();

        //setting the input fields
        setNameField(centerPanel, constraints, form);
        setEmailField(centerPanel, constraints, form);
        setAgeField(centerPanel, constraints, form);
        setGradeField(centerPanel, constraints, form);
        setButton(centerPanel, constraints, form);

        createDialog.setLayout(new BorderLayout());
        createDialog.add(centerPanel, BorderLayout.CENTER);
    }

    public void setNameField(JPanel panel, GridBagConstraints constraints, Form form){
        JLabel nameLabel = new JLabel("Enter the Name");
        JPanel inputPanel = new JPanel();
        JLabel status = new JLabel();
        JTextField nameField = new JTextField();

        nameLabel.setFont(gui.sansSerif);
        status.setVisible(false);
        status.setFont(new Font("SansSerif", Font.PLAIN, 10));
        nameField.setPreferredSize(new Dimension(200, 23));
        nameField.getDocument().addDocumentListener(new DocumentListener() {
            public void validateName(){
                String name = nameField.getText();

                if(Validation.isName(name)){
                    form.name = name;
                    form.validity[0] = true;

                    status.setText("valid name");
                    status.setForeground(Color.GREEN);
                }
                else{
                    form.name = "";
                    form.validity[0] = false;

                    status.setText("invalid name");
                    status.setForeground(Color.RED);
                }

                status.setVisible(true);
            }

            @Override
            public void insertUpdate(DocumentEvent e) {
                validateName();
            }

            @Override
            public void removeUpdate(DocumentEvent e) {
                validateName();
            }

            @Override
            public void changedUpdate(DocumentEvent e) {
                validateName();
            }
        });

        constraints.gridx = 0;
        constraints.gridy = 0;
        constraints.anchor = GridBagConstraints.LINE_START;
        panel.add(nameLabel, constraints);

        constraints.gridx = 1;
        constraints.anchor = GridBagConstraints.CENTER;

        panel.add(new JLabel(":"), constraints);

        GridBagConstraints newCon = new GridBagConstraints();
        newCon.gridx = 0;
        newCon.gridy = 0;
        newCon.weightx = 1.0;
        newCon.fill = GridBagConstraints.HORIZONTAL;
        inputPanel.setLayout(new GridBagLayout());

        inputPanel.add(nameField, newCon);

        newCon.gridy = 1;
        inputPanel.add(status, newCon);

        constraints.gridx = 2;
        constraints.anchor = GridBagConstraints.LINE_END;
        panel.add(inputPanel, constraints);
    }

    public void setEmailField(JPanel panel, GridBagConstraints constraints, Form form){
        JLabel emailLabel = new JLabel("Enter the Email");
        JPanel inputPanel = new JPanel();
        JLabel status = new JLabel();
        JTextField emailField = new JTextField();

        emailLabel.setFont(gui.sansSerif);
        status.setVisible(false);
        status.setFont(new Font("SansSerif", Font.PLAIN, 10));
        emailField.setPreferredSize(new Dimension(200, 23));
        emailField.getDocument().addDocumentListener(new DocumentListener() {
            public void validateEmail(){
                String email = emailField.getText();


                if(Validation.isEmail(email)){
                    form.email = email;
                    form.validity[1] = true;

                    status.setText("valid email");
                    status.setForeground(Color.GREEN);
                }
                else{
                    form.email = "";
                    form.validity[1] = false;

                    status.setText("invalid email");
                    status.setForeground(Color.RED);
                }

                status.setVisible(true);
            }

            @Override
            public void insertUpdate(DocumentEvent e) {
                validateEmail();
            }

            @Override
            public void removeUpdate(DocumentEvent e) {
                validateEmail();
            }

            @Override
            public void changedUpdate(DocumentEvent e) {
                validateEmail();
            }
        });

        constraints.gridx = 0;
        constraints.gridy = 1;
        constraints.anchor = GridBagConstraints.LINE_START;
        panel.add(emailLabel, constraints);

        constraints.gridx = 1;
        constraints.anchor = GridBagConstraints.CENTER;

        panel.add(new JLabel(":"), constraints);

        GridBagConstraints newCon = new GridBagConstraints();
        newCon.gridx = 0;
        newCon.gridy = 0;
        newCon.weightx = 1.0;
        newCon.fill = GridBagConstraints.HORIZONTAL;
        inputPanel.setLayout(new GridBagLayout());

        inputPanel.add(emailField, newCon);

        newCon.gridy = 1;
        inputPanel.add(status, newCon);

        constraints.gridx = 2;
        constraints.anchor = GridBagConstraints.LINE_END;
        panel.add(inputPanel, constraints);
    }

    public void setAgeField(JPanel panel, GridBagConstraints constraints, Form form){
        JLabel ageLabel = new JLabel("Enter the Age");
        JPanel inputPanel = new JPanel();
        JLabel status = new JLabel();
        JTextField ageField = new JTextField();

        ageLabel.setFont(gui.sansSerif);
        status.setVisible(false);
        status.setFont(new Font("SansSerif", Font.PLAIN, 10));
        ageField.setPreferredSize(new Dimension(200, 23));
        ageField.getDocument().addDocumentListener(new DocumentListener() {
            public void validateAge(){
                String age = ageField.getText();

                if(age.matches("\\d*") && !age.trim().isEmpty()){
                    int val = Integer.parseInt(age);
                    if(Validation.isAge(val)){
                        form.age = val;
                        form.validity[2] = true;

                        status.setText("valid age");
                        status.setForeground(Color.GREEN);
                    }
                    else{
                        form.age = 0;
                        form.validity[2] = false;

                        status.setText("age must between 5 to 120");
                        status.setForeground(Color.RED);
                    }
                }
                else{
                    form.age = 0;
                    form.validity[2] = false;

                    status.setText("age must be a number");
                    status.setForeground(Color.RED);

                    SwingUtilities.invokeLater(() -> ageField.setText(age.replaceAll("\\D", "")));
                }

                status.setVisible(true);
            }

            @Override
            public void insertUpdate(DocumentEvent e) {
                validateAge();
            }

            @Override
            public void removeUpdate(DocumentEvent e) {
                validateAge();
            }

            @Override
            public void changedUpdate(DocumentEvent e) {
                validateAge();
            }
        });

        constraints.gridx = 0;
        constraints.gridy = 2;
        constraints.anchor = GridBagConstraints.LINE_START;
        panel.add(ageLabel, constraints);

        constraints.gridx = 1;
        constraints.anchor = GridBagConstraints.CENTER;

        panel.add(new JLabel(":"), constraints);

        GridBagConstraints newCon = new GridBagConstraints();
        newCon.gridx = 0;
        newCon.gridy = 0;
        newCon.weightx = 1.0;
        newCon.fill = GridBagConstraints.HORIZONTAL;
        inputPanel.setLayout(new GridBagLayout());

        inputPanel.add(ageField, newCon);

        newCon.gridy = 1;
        inputPanel.add(status, newCon);

        constraints.gridx = 2;
        constraints.anchor = GridBagConstraints.LINE_END;
        panel.add(inputPanel, constraints);
    }

    public void setGradeField(JPanel panel, GridBagConstraints constraints, Form form){
        JLabel gradeLabel = new JLabel("Enter the Grade");
        JPanel inputPanel = new JPanel();
        JLabel status = new JLabel();
        JTextField gradeField = new JTextField();

        gradeLabel.setFont(gui.sansSerif);
        status.setVisible(false);
        status.setFont(new Font("SansSerif", Font.PLAIN, 10));
        gradeField.setPreferredSize(new Dimension(200, 23));
        gradeField.getDocument().addDocumentListener(new DocumentListener() {
            public void validateGrade(){
                String grade = gradeField.getText();

                if(grade.length() == 1){
                    boolean flag = Validation.isGrade(grade);

                    if(!flag){
                        form.grade = 'A';
                        form.validity[3] = false;

                        status.setForeground(Color.RED);
                        status.setText("grade must be (A, B, C or D)");
                    }
                    else{
                        form.grade = grade.charAt(0);
                        form.validity[3] = true;

                        status.setForeground(Color.GREEN);
                        status.setText("valid grade");
                    }
                }
                else{
                    form.grade = 'A';
                    form.validity[3] = false;

                    status.setForeground(Color.RED);
                    status.setText("grade must be (A, B, C or D)");

                    SwingUtilities.invokeLater(() -> gradeField.setText(""));
                }

                status.setVisible(true);
            }

            @Override
            public void insertUpdate(DocumentEvent e) {
                validateGrade();
            }

            @Override
            public void removeUpdate(DocumentEvent e) {
                validateGrade();
            }

            @Override
            public void changedUpdate(DocumentEvent e) {
                validateGrade();
            }
        });

        constraints.gridx = 0;
        constraints.gridy = 3;
        constraints.anchor = GridBagConstraints.LINE_START;
        panel.add(gradeLabel, constraints);

        constraints.gridx = 1;
        constraints.anchor = GridBagConstraints.CENTER;

        panel.add(new JLabel(":"), constraints);

        GridBagConstraints newCon = new GridBagConstraints();
        newCon.gridx = 0;
        newCon.gridy = 0;
        newCon.weightx = 1.0;
        newCon.fill = GridBagConstraints.HORIZONTAL;
        inputPanel.setLayout(new GridBagLayout());

        inputPanel.add(gradeField, newCon);

        newCon.gridy = 1;
        inputPanel.add(status, newCon);

        constraints.gridx = 2;
        constraints.anchor = GridBagConstraints.LINE_END;
        panel.add(inputPanel, constraints);
    }

    public void setButton(JPanel panel, GridBagConstraints constraints, Form form){
        JButton submitButton = new JButton("Submit");
        submitButton.setFont(new Font("SansSerif", Font.PLAIN, 12));

        submitButton.addActionListener((e) ->{
            if(form.isAllValid()){
                try {
                    Student newStudent = gui.manager.newStudent(form.name, form.age, form.email, form.grade);
                    gui.manager.add(newStudent);

                    Vector<String> row = new Vector<>();
                    row.add(String.valueOf(newStudent.getId()));
                    row.add(form.name);
                    row.add(String.valueOf(form.age));
                    row.add(form.email);
                    row.add(form.grade + "");

                    gui.table.dtm.addRow(row);

                    createDialog.dispose();
                }
                catch(Exception ex){
                    JLabel errorLabel = new JLabel("Error: " + ex.getMessage());
                    errorLabel.setFont(new Font("SansSerif", Font.PLAIN, 10));

                    constraints.gridy = 5;
                    panel.add(errorLabel, constraints);
                    panel.revalidate();
                    panel.repaint();
                }
            }
        });

        constraints.gridx = 0;
        constraints.gridy = 4;
        constraints.gridwidth = 3;
        constraints.anchor = GridBagConstraints.CENTER;
        panel.add(submitButton, constraints);
    }
}
