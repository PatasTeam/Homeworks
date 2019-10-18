package org.patas.gui;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import org.patas.Main;
import org.patas.student.Student;

import java.util.ArrayList;
import java.util.Collections;

public class GUIController {
    @FXML
    TextField name, enrollment, grade;
    @FXML
    Label students, studentAdd;

    private ArrayList<Student> student;

    @FXML
    void initialize(Main main) {
        student = main.getStudent();
        students.setText("");
    }

    @FXML
    public void register(ActionEvent actionEvent) {
        student.add(new Student(name.getText(), enrollment.getText(), Double.parseDouble(grade.getText())));
        studentAdd.setText("Student: " + name.getText() + " added");
        students.setText(students.getText() + student.get(student.size() - 1).toString() + '\n');
        name.setText("");
        enrollment.setText("");
        grade.setText("");
    }

    @FXML
    private void sort(ActionEvent actionEvent) {
        quickSort(0, student.size() - 1);
        refreshStudentsLabel();
    }

    private void quickSort(int p, int r) {
        if (p < r) {
            int q = partition(p, r);
            quickSort(p, q - 1);
            quickSort(q + 1, r);
        }
    }

    private int partition(int p, int r) {
        Student student_temp = student.get(r);
        int i = p - 1;
        for (int j = p; j < r; ++j) {
            if (student.get(j).compareTo(student_temp) < 0) {
                ++i;
                Collections.swap(student, i, j);
            }
        }
        Collections.swap(student, i + 1, r);
        return i + 1;
    }

    private void refreshStudentsLabel() {
        students.setText("");
        String info = "";
        for (Student std : student)
            info += std.toString() + '\n';
        students.setText(info);
    }
}
