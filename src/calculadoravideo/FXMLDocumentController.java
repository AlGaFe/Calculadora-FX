package calculadoravideo;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

/* @author Álvaro García Fernández */
public class FXMLDocumentController implements Initializable {

    String operacion;
    Double respuesta=null;
    Double resultado;
    Double numero1=null;
    Double numero2=null;
    private Label label;
    @FXML
    private Button uno;
    @FXML
    private Button dos;
    @FXML
    private Button cuatro;
    @FXML
    private Button cinco;
    @FXML
    private Button siete;
    @FXML
    private Button ocho;
    @FXML
    private Button cero;
    @FXML
    private Button igual;
    @FXML
    private Button limpiar;
    @FXML
    private Button sumar;
    @FXML
    private Button restar;
    @FXML
    private Button multiplicar;
    @FXML
    private Button dividir;
    @FXML
    private Button tres;
    @FXML
    private Button seis;
    @FXML
    private Button nueve;
    @FXML
    private TextField display;
    @FXML
    private TextField cuadroHistorial;
    @FXML
    private Button VerHistoria;

    private void handleButtonAction(ActionEvent event) {
        System.out.println("You clicked me!");
        label.setText("Hello World!");
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }

    @FXML
    private void Boton1(ActionEvent event) {
        this.display.setText(this.display.getText() + "1");
    }

    @FXML
    private void Boton2(ActionEvent event) {
        this.display.setText(this.display.getText() + "2");
    }

    @FXML
    private void Boton3(ActionEvent event) {
        this.display.setText(this.display.getText() + "3");
    }

    @FXML
    private void InsertarNumeros(ActionEvent event) {
        if (event.getSource() == cuatro) {
            this.display.setText(this.display.getText() + "4");
        } else if (event.getSource() == cinco) {
            this.display.setText(this.display.getText() + "5");
        } else if (event.getSource() == seis) {
            this.display.setText(this.display.getText() + "6");
        } else if (event.getSource() == siete) {
            this.display.setText(this.display.getText() + "7");
        } else if (event.getSource() == ocho) {
            this.display.setText(this.display.getText() + "8");
        } else if (event.getSource() == nueve) {
            this.display.setText(this.display.getText() + "9");
 
        } else if (event.getSource() == cero) {
            this.display.setText(this.display.getText() + "0");
        }
    }

    @FXML
    private void InsertarOperacor(ActionEvent event) {
        if (event.getSource() == sumar) {
            if (numero1!=null) {
                numero2=Double.parseDouble(this.display.getText());
                resultado=sumar(numero1,numero2);
                historial(numero1,"+",numero2);
                numero1=resultado;
            }else{
                numero1 = Double.parseDouble(this.display.getText());
            }
            operacion = "+";
            this.display.setText("");
        } else if (event.getSource() == restar) {
             if (numero1!=null) {
                numero2=Double.parseDouble(this.display.getText());
                resultado=restar(numero1,numero2);
                historial(numero1,"-",numero2);
                numero1=resultado;
            }else{
                numero1 = Double.parseDouble(this.display.getText());
            }
            operacion = "-";
            this.display.setText("");
        } else if (event.getSource() == multiplicar) {
             if (numero1!=null) {
                numero2=Double.parseDouble(this.display.getText());
                resultado=multiplicar(numero1,numero2);
                historial(numero1,"*",numero2);
                numero1=resultado;
                
            }else{
                numero1 = Double.parseDouble(this.display.getText());
            }
            operacion = "*";
            this.display.setText("");
        } else if (event.getSource() == dividir) {
             if (numero1!=null) {
                numero2=Double.parseDouble(this.display.getText());
                resultado=dividir(numero1,numero2);
                historial(numero1,"/",numero2);
                numero1=resultado;
            }else{
                numero1 = Double.parseDouble(this.display.getText());
            }
            operacion = "/";
            this.display.setText("");
        }

        if (event.getSource() == igual) {
            numero2 = Double.parseDouble(this.display.getText());
            if (respuesta==null) {
               if (operacion.equalsIgnoreCase("+")) {
                respuesta = sumar(numero1, numero2);
            } else if (operacion.equalsIgnoreCase("-")) {
                respuesta = restar(numero1, numero2);  
            } else if (operacion.equalsIgnoreCase("*")) {
                respuesta = multiplicar(numero1, numero2);  
            } else if (operacion.equalsIgnoreCase("/")) {
                respuesta = dividir(numero1, numero2);
            }
            this.display.setText("" + respuesta); 
            }
            else{
             if (operacion.equalsIgnoreCase("+")) {
                resultado = sumar(respuesta, numero2);
                   
            } else if (operacion.equalsIgnoreCase("-")) {
                resultado = restar(respuesta, numero2);
            } else if (operacion.equalsIgnoreCase("*")) {
                resultado = multiplicar(respuesta, numero2);
            } else if (operacion.equalsIgnoreCase("/")) {
                resultado = dividir(respuesta, numero2); 
            }
            this.display.setText("" + resultado);


        }
    }
        if (event.getSource() == VerHistoria) {
                  historial(numero1,operacion,numero2);
                }   
    }
    private void historial(Double numero,String operacion,Double numero2){
    this.cuadroHistorial.appendText(" "+numero+operacion+numero2+" | ");
    }

    private double sumar(double numero1, double numero2) {
        double resultado;
        resultado = numero1 + numero2;
        return resultado;
    }

    private double restar(double numero1, double numero2) {
        double resultado;
        resultado = numero1 - numero2;
        return resultado;
    }

    private double multiplicar(double numero1, double numero2) {
        double resultado;
        resultado = numero1 * numero2;
        return resultado;
    }

    private double dividir(double numero1, double numero2) {
        double resultado = 0;
        try {
            resultado = numero1 / numero2;
        } catch (Exception e) {
            display.setText("Error");
        }
        return resultado;
    }

    @FXML
    private void Limpiar(ActionEvent event) {
        this.display.setText("");
        resultado=null;
        numero1=null;
        numero2=null;
        respuesta=null;
    }

    @FXML
    private void Display(ActionEvent event) {
    }

    @FXML
    private void AccionHistorial(ActionEvent event) {
    }

}
