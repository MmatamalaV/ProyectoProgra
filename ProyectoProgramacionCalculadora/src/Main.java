/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import PuntosDeControlYMovimiento.PuntosDeControl;
import java.util.ArrayList;
import java.util.List;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.geometry.Insets;
import javafx.geometry.Orientation;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Slider;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Priority;
import javafx.scene.layout.VBox;
import javafx.scene.shape.Box;
import javafx.scene.shape.Path;
import javafx.stage.Stage;

/**
 *
 * @author Matias.Erenchun
 * @editor elias avendano
 */
public class Main extends Application {
    double espacioNumero=0;
    double espacioSuperior=0;
    int contador=0;
    public boolean puntosVisibles = true;
    private final List enPantalla = new ArrayList();
    
    @Override
    public void start(Stage primaryStage) {
       List<PuntosDeControl> enPantalla = new ArrayList<>();
       HBox contenerdorPrincipal = new HBox();
       
       //*******inicio numeros***************
       VBox contenedorNumeros = new VBox();
       HBox numerosFila1 = new HBox();//creamos el Hbox
       numerosFila1.setPadding(new Insets(0));// se define el  margen entre el  borde del panel y  los objetos que estan dentro en pixeles 
       Button button7 = new Button(" 7 ");
       Button button8 = new Button(" 8 ");// en este caso el contenido se entrega en el contructor
       Button button9 = new Button();
       button9.setText(" 9 ");//contenido del boton 
       button9.setMaxWidth(Double.MAX_VALUE);
      
       //HBox.setMargin(button1, new Insets(0,0,0,0));//margen entre objetos en este caso se dejo 5 a la  derecha 
       HBox.setHgrow(button7, Priority.ALWAYS);// esto  se define la prioridad  en caso de aumentar el tamaño de la ventana  los objetos con prioridad llenaran  el espacio 
       HBox.setHgrow(button8, Priority.ALWAYS);
       HBox.setHgrow(button9, Priority.ALWAYS);
       HBox.setMargin(button7, javafx.geometry.Insets.EMPTY);
       button7.setMaxWidth(Double.MAX_VALUE);
       button8.setMaxWidth(Double.MAX_VALUE);
       numerosFila1.getChildren().addAll(button7, button8,button9);
       
       
       //------------------------------//
       
       HBox numerosFila2 = new HBox();
       numerosFila2.setPadding(new Insets(0));// se define el  margen entre el  borde del panel y  los objetos que estan dentro en pixeles 
       Button button4 = new Button(" 4 ");
       
      
       Button button5 = new Button(" 5 ");// en este caso el contenido se entrega en el contructor
       Button button6 = new Button(" 6 ");
       HBox.setHgrow(button4, Priority.ALWAYS);// esto  se define la prioridad  en caso de aumentar el tamaño de la ventana  los objetos con prioridad llenaran  el espacio 
       HBox.setHgrow(button5, Priority.ALWAYS);
       HBox.setHgrow(button6, Priority.ALWAYS);
       button4.setMaxWidth(Double.MAX_VALUE);
       button5.setMaxWidth(Double.MAX_VALUE);
       button6.setMaxWidth(Double.MAX_VALUE);
       numerosFila2.getChildren().addAll(button4, button5,button6);
       
       //------------------------------//
       
       HBox numerosFila3 = new HBox();
       numerosFila1.setPadding(new Insets(0));// se define el  margen entre el  borde del panel y  los objetos que estan dentro en pixeles 
       Button button1 = new Button(" 1 ");
       Button button2 = new Button(" 2 ");// en este caso el contenido se entrega en el contructor
       Button button3 = new Button(" 3 ");
       HBox.setHgrow(button1, Priority.ALWAYS);// esto  se define la prioridad  en caso de aumentar el tamaño de la ventana  los objetos con prioridad llenaran  el espacio 
       HBox.setHgrow(button2, Priority.ALWAYS);
       HBox.setHgrow(button3, Priority.ALWAYS);
       button1.setMaxWidth(Double.MAX_VALUE);
       button2.setMaxWidth(Double.MAX_VALUE);
       button3.setMaxWidth(Double.MAX_VALUE);
       numerosFila3.getChildren().addAll(button1, button2,button3);
       
       //------------------------------//
       
       HBox numerosFila4 = new HBox();
       numerosFila1.setPadding(new Insets(0));// se define el  margen entre el  borde del panel y  los objetos que estan dentro en pixeles 
       Button button00 = new Button("    ");
       Button button0 = new Button(" 0 ");// en este caso el contenido se entrega en el contructor
       Button buttonNn = new Button("    ");
       HBox.setHgrow(button00, Priority.ALWAYS);// esto  se define la prioridad  en caso de aumentar el tamaño de la ventana  los objetos con prioridad llenaran  el espacio 
       HBox.setHgrow(button0, Priority.ALWAYS);
       HBox.setHgrow(buttonNn, Priority.ALWAYS);
       button00.setMaxWidth(Double.MAX_VALUE);
       button0.setMaxWidth(Double.MAX_VALUE);
       buttonNn.setMaxWidth(Double.MAX_VALUE);
       numerosFila4.getChildren().addAll(button00, button0,buttonNn);
       
       //------------------------------//
       
       contenedorNumeros.getChildren().addAll(numerosFila1,numerosFila2,numerosFila3,numerosFila4);
       
       //*******fin numeros***************
       
       //*******inicio simbolos***********
       
       VBox contenedorSimbolos = new VBox();
       
       //------------------------------//
       
       HBox simbolos1 = new HBox();
       numerosFila2.setPadding(new Insets(0));// se define el  margen entre el  borde del panel y  los objetos que estan dentro en pixeles 
       Button buttonPar1 = new Button(" ( ");
       Button buttonPar2 = new Button(" ) ");// en este caso el contenido se entrega en el contructor
       
       HBox.setHgrow(buttonPar1, Priority.ALWAYS);// esto  se define la prioridad  en caso de aumentar el tamaño de la ventana  los objetos con prioridad llenaran  el espacio 
       HBox.setHgrow(buttonPar2, Priority.ALWAYS);
       buttonPar1.setMaxWidth(Double.MAX_VALUE);
       buttonPar2.setMaxWidth(Double.MAX_VALUE);
      
       simbolos1.getChildren().addAll(buttonPar1, buttonPar2);
       
       //-------------------------------------//
       
        HBox simbolos2 = new HBox();
       numerosFila2.setPadding(new Insets(0));// se define el  margen entre el  borde del panel y  los objetos que estan dentro en pixeles 
       Button buttonMas= new Button(" + ");
       Button buttonMenos = new Button(" - ");// en este caso el contenido se entrega en el contructor
       
       HBox.setHgrow(buttonMas, Priority.ALWAYS);// esto  se define la prioridad  en caso de aumentar el tamaño de la ventana  los objetos con prioridad llenaran  el espacio 
       HBox.setHgrow(buttonMenos, Priority.ALWAYS);
       
       buttonMas.setMaxWidth(Double.MAX_VALUE);
       buttonMenos.setMaxWidth(Double.MAX_VALUE);
      
       simbolos2.getChildren().addAll(buttonMas, buttonMenos);
       
        //------------------------------//
       
       HBox simbolos3 = new HBox();
       numerosFila2.setPadding(new Insets(0));// se define el  margen entre el  borde del panel y  los objetos que estan dentro en pixeles 
       Button buttonPor = new Button(" * ");
       Button buttonDiv = new Button(" / ");// en este caso el contenido se entrega en el contructor
       
       HBox.setHgrow(buttonPor, Priority.ALWAYS);// esto  se define la prioridad  en caso de aumentar el tamaño de la ventana  los objetos con prioridad llenaran  el espacio 
       HBox.setHgrow(buttonDiv, Priority.ALWAYS);
       buttonPor.setMaxWidth(Double.MAX_VALUE);
       buttonDiv.setMaxWidth(Double.MAX_VALUE);
      
       simbolos3.getChildren().addAll(buttonPor, buttonDiv);
       
       //-------------------------------------//
       
        //------------------------------//
       
       HBox simbolos4 = new HBox();
       numerosFila2.setPadding(new Insets(0));// se define el  margen entre el  borde del panel y  los objetos que estan dentro en pixeles 
       Button buttonNn2 = new Button(" Mostrar/Esconder Puntos de Control ");
       //Button buttonDiv = new Button(" / ");// en este caso el contenido se entrega en el contructor
       
       HBox.setHgrow(buttonNn2, Priority.ALWAYS);// esto  se define la prioridad  en caso de aumentar el tamaño de la ventana  los objetos con prioridad llenaran  el espacio 
       //HBox.setHgrow(buttonDiv, Priority.ALWAYS);
       buttonNn2.setMaxWidth(Double.MAX_VALUE);
       //buttonDiv.setMaxWidth(Double.MAX_VALUE);
      
       simbolos4.getChildren().addAll(buttonNn2);
       
       //-------------------------------------//
       
       
       contenedorSimbolos.getChildren().addAll(simbolos1,simbolos2,simbolos3,simbolos4);
       
       //*******fin numeros***************
       
       //*******inicio Esena de dibujo***********
       Box box = new Box(100,100,100);
       BorderPane pane = new BorderPane();
       box.setManaged(true);
       //pane.setCenter(box);
       Path center = new Path();
       center.setManaged(false);
       Group centro=new Group(center);
       pane.setCenter(centro);
       
       
       buttonDiv.setOnAction((ActionEvent event) ->
        { 
            double n =0;
            NumerosYSimbolos division = new NumerosYSimbolos(n, espacioNumero,espacioSuperior, puntosVisibles);
            centro.getChildren().add(division.division(center));
            //contador para el salto de linea en la pantalla
            contador();
            enPantalla.add(division);
            
        });
       
       buttonPor.setOnAction((ActionEvent event) ->
        { 
            double n =0;
            NumerosYSimbolos multiplicacion = new NumerosYSimbolos(n, espacioNumero,espacioSuperior, puntosVisibles);
            centro.getChildren().add(multiplicacion.multiplicacion(center));
            //contador para el salto de linea en la pantalla
            contador();
            enPantalla.add(multiplicacion);
        });
       
       buttonPar1.setOnAction((ActionEvent event) ->
        { 
            double n =0;
            NumerosYSimbolos parentesis1 = new NumerosYSimbolos(n, espacioNumero,espacioSuperior, puntosVisibles);
            centro.getChildren().add(parentesis1.parentesis1(center));
            //contador para el salto de linea en la pantalla
            contador();
            enPantalla.add(parentesis1);
        });
       
       buttonPar2.setOnAction((ActionEvent event) ->
        { 
            double n =0;
            NumerosYSimbolos parentesis2 = new NumerosYSimbolos(n, espacioNumero,espacioSuperior, puntosVisibles);
            centro.getChildren().add(parentesis2.parentesis2(center));
            //contador para el salto de linea en la pantalla
            contador();
            enPantalla.add(parentesis2);
        });
       
       buttonMas.setOnAction((ActionEvent event) ->
        { 
            double n =0;
            NumerosYSimbolos suma = new NumerosYSimbolos(n, espacioNumero,espacioSuperior, puntosVisibles);
            centro.getChildren().add(suma.suma(center));
            //contador para el salto de linea en la pantalla
            contador();
            enPantalla.add(suma);
        });
       
       buttonMenos.setOnAction((ActionEvent event) ->
        { 
            double n =0;
            NumerosYSimbolos resta = new NumerosYSimbolos(n, espacioNumero,espacioSuperior, puntosVisibles);
            centro.getChildren().add(resta.resta(center));
            //contador para el salto de linea en la pantalla
            contador();
            enPantalla.add(resta);
        });
       
       button0.setOnAction((ActionEvent event) ->
        { 
            double n =0;
            NumerosYSimbolos numero0 = new NumerosYSimbolos(n, espacioNumero,espacioSuperior, puntosVisibles);
            centro.getChildren().add(numero0.numero0(center));
            //contador para el salto de linea en la pantalla
            contador();
            enPantalla.add(numero0);
        });
       
       button1.setOnAction((ActionEvent event) ->
        { 
            double n =0;
            NumerosYSimbolos numero1 = new NumerosYSimbolos(n, espacioNumero,espacioSuperior, puntosVisibles);
            centro.getChildren().add(numero1.numero1(center));
            //contador para el salto de linea en la pantalla
            contador();
            enPantalla.add(numero1);
        });
       
       button2.setOnAction((ActionEvent event) ->
        { 
            double n =0;
            NumerosYSimbolos numero2 = new NumerosYSimbolos(n, espacioNumero,espacioSuperior, puntosVisibles);
            centro.getChildren().add(numero2.numero2(center));
            //contador para el salto de linea en la pantalla
            contador();
            enPantalla.add(numero2);
        });
       
       button3.setOnAction((ActionEvent event) ->
        { 
            double n =0;
            NumerosYSimbolos numero3 = new NumerosYSimbolos(n, espacioNumero,espacioSuperior, puntosVisibles);
            centro.getChildren().add(numero3.numero3(center));
            //contador para el salto de linea en la pantalla
            contador();
            enPantalla.add(numero3);
        });
       
       button4.setOnAction((ActionEvent event) ->
           
           {
               double n =0;
                NumerosYSimbolos numero4 = new NumerosYSimbolos(n, espacioNumero,espacioSuperior, puntosVisibles);
                centro.getChildren().add(numero4.numero4(center));
                //contador para el salto de linea en la pantalla
                contador();
                enPantalla.add(numero4);
               
            });
       
       buttonNn2.setOnAction((ActionEvent event) ->
        { 
            int tamano = enPantalla.size();
            puntosVisibles = puntosVisibles != true;
            for (int x=0; x<tamano; x++)
                enPantalla.get(x).visibleCircle(puntosVisibles);
        });
       
       
       //-------------------------------------//
       
       Slider sliderSubScene = new Slider();
       sliderSubScene.setMax(10000);// se define el largo maximo del  slider
       sliderSubScene.setMin(-10000);
       sliderSubScene.valueProperty().bindBidirectional(centro.translateXProperty());//se le da el recorrido al Slider en este caso es el largo del box
       pane.setBottom(sliderSubScene);
       
       Slider sliderSubScene2 = new Slider();
       sliderSubScene2.setMax(10000);// se define el largo maximo del  slider
       sliderSubScene2.setMin(-10000);
       sliderSubScene2.setOrientation(Orientation.VERTICAL);
       sliderSubScene2.valueProperty().bindBidirectional(centro.translateYProperty());//se le da el recorrido al Slider en este caso es el largo del box
       pane.setLeft(sliderSubScene2);
       
       
       
       //SubScene pantallaDibujo = new SubScene(aux1,300,300);//creamos la SubScene dando su contenido  luego su ancho y altura 
       //en este caso su contenido es un border pane.
       
       //*******fin Esena de dibujo**************
       contenerdorPrincipal.getChildren().addAll(contenedorNumeros,contenedorSimbolos);
       HBox.setHgrow(contenedorNumeros, Priority.ALWAYS);// se define la prioridad de llenado de espacio que tiene el nodo  dentro de su contenedor.
       HBox.setHgrow(contenedorSimbolos, Priority.ALWAYS);
       VBox.setVgrow(numerosFila1, Priority.ALWAYS);
       VBox.setVgrow(numerosFila2, Priority.ALWAYS);
       VBox.setVgrow(numerosFila3, Priority.ALWAYS);
       VBox.setVgrow(numerosFila4, Priority.ALWAYS);
       BorderPane BpanePrueba = new BorderPane();
       BpanePrueba.setBottom(contenerdorPrincipal);
       //BpanePrueba.setCenter(pantallaDibujo);
       BpanePrueba.setCenter(pane);
      
        
        //StackPane root = new StackPane();
        
        primaryStage.setTitle("Cancer de Piel");//titulo de la ventana 
        
        Scene scene = new Scene (BpanePrueba,640,480);//constructor de la ventana
        
        BpanePrueba.setMinSize(640, 480);
        //root.setPrefSize(400, 300);
        /**root.minHeight(300);
        root.minWidth(400);*/
        //root.getChildren().add(BpanePrueba);//agregamos el boton a al root
        primaryStage.setScene(scene);//agregamos scene a la pantalla
        primaryStage.show();//mostramos la pantalla
    }
    
    private void contador(){
        espacioNumero+=90;
        //contador+=200;
        /*if(contador>14000){
            espacioSuperior+=120;
            contador=0;
            espacioNumero=0;
        }*/
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
    
}

