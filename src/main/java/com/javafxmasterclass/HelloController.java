package com.javafxmasterclass;

import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

public class HelloController {
    @FXML
    private Label welcomeText;

    @FXML
    private TextField nameField;

    @FXML
    private Button helloButton;

    @FXML
    private Button byeButton;

    @FXML
    private CheckBox ourCheckBox;

    @FXML
    private Label ourLabel;

    @FXML
    public void initialize(){
        helloButton.setDisable(true);
        byeButton.setDisable(true);
    }

    @FXML
    protected void onHelloButtonClick() {
        welcomeText.setText("Welcome to JavaFX Application!");
    }


    public void onButtonCliked(ActionEvent e){
        if(e.getSource().equals(helloButton)){
            System.out.println("Hello " + nameField.getText());
        } else if (e.getSource().equals(byeButton)) {
            System.out.println("Bye " + nameField.getText());
        }



        Runnable task = new Runnable() {
            @Override
            public void run() {
                //// put the process to sleep
                try{
                    String s = Platform.isFxApplicationThread() ? "Using UI Thread" : "Using Background Thread";
                    System.out.println(s);
                    Thread.sleep(10000);

                    Platform.runLater(new Runnable() {
                        @Override
                        public void run() {
                            ourLabel.setText("We did Something !!");

                        }
                    });

                }catch(InterruptedException event){
                    //// nothing here
                }
            }
        };


        //// Start the task /
        new Thread(task).start();


        if(ourCheckBox.isSelected()){
            nameField.clear();
            helloButton.setDisable(true);
            byeButton.setDisable(true);
        }
    }


    @FXML
    public void handleKeyReleased(){
        String text = nameField.getText();
        boolean disabledButtons = text.isEmpty() | text.trim().isEmpty();
        helloButton.setDisable(disabledButtons);
        byeButton.setDisable(disabledButtons);
    }

    public void handleChecked(){
        System.out.println("the check box is" + ((ourCheckBox.isSelected()) ? "checked" : "not checked"));
    }
}