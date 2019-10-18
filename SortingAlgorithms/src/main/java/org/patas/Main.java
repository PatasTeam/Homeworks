package org.patas;
import org.patas.gui.GUI;
import org.patas.student.Student;

import javafx.application.Application;
import javafx.stage.Stage;

import java.util.ArrayList;


public class Main extends Application {

    private ArrayList<Student> student = new ArrayList<>();
    private Stage stage;

    @Override
    public void start(Stage stageInit) {
        stageInit.setScene(new GUI(this));
        stageInit.show();
    }

    public ArrayList<Student> getStudent() {
        return student;
    }

    public static void main(String[] args) {
        launch();
    }

}
