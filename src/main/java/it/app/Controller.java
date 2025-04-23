package it.app;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

public class Controller {
    private double pastNumber = 0;
    @FXML
    private TextField newNumber;

    public interface Operation {
        double operate(double x, double y);
    }
    private enum Operator implements Operation{
        PLUS{
            public double operate(double a, double b){return a+b;}
        },
        MINUS{
            public double operate(double a, double b){return a-b;}
        },
        MULTIPLY{
            public double operate(double a, double b){return a*b;}
        },
        DIVIDE{
            public double operate(double a, double b){return a/b;}
        };
    }
    private Operator currentOperator = Operator.PLUS;

    @FXML
    private void digitClick(ActionEvent event) {
        Button button = (Button) event.getSource();
        String digitString = button.getText();
        // Handle the event
        System.out.println("Button " + button.getText() +  "clicked! display value: " + newNumber.getText());

        newNumber.setText(newNumber.getText()+digitString);
    }

    @FXML
    private void operatorClick(ActionEvent event){
        pastNumber = currentOperator.operate(pastNumber,Double.parseDouble(newNumber.getText())) ;
        newNumber.setText("");
        Button operatorButton = (Button) event.getSource();
        switch (operatorButton.getText()){
            case "+":
                currentOperator = Operator.PLUS;
                break;
            case "-":
                currentOperator = Operator.MINUS;
                break;
            case "*":
                currentOperator = Operator.MULTIPLY;
                break;
            case "/":
                currentOperator = Operator.DIVIDE;
                break;
        }
        System.out.println("operator " + currentOperator);
        System.out.println(pastNumber);
    }

    @FXML
    private void equalClick(ActionEvent event){
        newNumber.setText(Double.toString(currentOperator.operate(pastNumber,Double.parseDouble(newNumber.getText()))));
        pastNumber = 0;
        currentOperator = Operator.PLUS;
        System.out.println("equal " + newNumber.getText() + pastNumber);
    }

    @FXML
    private void cleanClick(ActionEvent event){
        newNumber.setText("");
        pastNumber = 0;
        currentOperator = Operator.PLUS;
    }

}