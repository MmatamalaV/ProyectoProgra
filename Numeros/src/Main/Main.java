package Main;


import ProgramacionNumeros.Numero0;
import ProgramacionNumeros.Numero1;
import ProgramacionNumeros.Numero4;
import ProgramacionSimbolos.Multiplicacion;
import ProgramacionSimbolos.Resta;
import ProgramacionSimbolos.Suma;
import ProgramacionSimbolos.Division;
import ProgramacionSimbolos.Parentesis1;
import ProgramacionSimbolos.Parentesis2;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.shape.Path;
import javafx.stage.Stage;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author mario
 */
public class Main extends Application{
    double espacioNumero=0;
    double espacioSuperior=0;
    int contador=0;
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage stage) throws Exception {
        
        
        VBox general= new VBox();
        
            HBox botones=new HBox();
                Button boton0 = new Button("0");
                boton0.setMinWidth(100);
                boton0.setMaxWidth(100);
                
                Button boton1 = new Button("1");
                boton1.setMinWidth(100);
                boton1.setMaxWidth(100);
                 
                Button boton4 = new Button("4");
                boton4.setMinWidth(100);
                boton4.setMaxWidth(100);
                
                Button botonMulti = new Button("Multiplicacion");
                boton0.setMinWidth(100);
                boton0.setMaxWidth(100);
                
                Button botonSuma = new Button("Suma");
                boton0.setMinWidth(100);
                boton0.setMaxWidth(100);
                
                Button botonResta = new Button("Resta");
                boton0.setMinWidth(100);
                boton0.setMaxWidth(100);
                
                Button botonDivision = new Button("Division");
                boton0.setMinWidth(100);
                boton0.setMaxWidth(100);
                
                Button botonParentesis1 = new Button("Parentesis1");
                boton0.setMinWidth(100);
                boton0.setMaxWidth(100);
                 
                Button botonParentesis2 = new Button("Parentesis2");
                boton0.setMinWidth(100);
                boton0.setMaxWidth(100);
                        
                        
        botones.getChildren().addAll(boton0, boton1, boton4, botonMulti, botonSuma, botonResta, botonDivision, botonParentesis1, botonParentesis2);
        Path path = new Path();   
        general.getChildren().addAll(botones, path);
        
        Group root= new Group(general);
        
        
        boton0.setOnAction((ActionEvent event) ->
        { 
            double n =boton0.getHeight();
            Numero0 numero0=new Numero0(n, espacioNumero,espacioSuperior);
            root.getChildren().add(numero0.start(path));
            //contador para el salto de linea en la pantalla
            espacioNumero+=100;
            contador+=100;
            if(contador>300){
                espacioSuperior+=120;
                contador =0;
                espacioNumero=0;
            }
        });
        
        
        boton4.setOnAction((ActionEvent event) ->
        { 
            double n =boton4.getHeight();
            Numero4 numero4 = new Numero4(n, espacioNumero,espacioSuperior);
            root.getChildren().add(numero4.start(path));
            //contador para el salto de linea en la pantalla
            espacioNumero+=100;
            contador+=100;
            if(contador>300){
                espacioSuperior+=120;
                contador =0;
                espacioNumero=0;
            }
        });
        
        boton1.setOnAction((ActionEvent event) ->
        { 
            double n =boton1.getHeight();
            Numero1 numero1 = new Numero1(n, espacioNumero,espacioSuperior);
            root.getChildren().add(numero1.start(path));
            //contador para el salto de linea en la pantalla
            espacioNumero+=100;
            contador+=100;
            if(contador>300){
                espacioSuperior+=120;
                contador =0;
                espacioNumero=0;
            }
        });
        
        botonMulti.setOnAction((ActionEvent event) ->
        { 
            double n =boton0.getHeight();
            Multiplicacion multi=new Multiplicacion(n, espacioNumero,espacioSuperior);
            root.getChildren().add(multi.start(path));
            //contador para el salto de linea en la pantalla
            espacioNumero+=100;
            contador+=100;
            if(contador>300){
                espacioSuperior+=120;
                contador =0;
                espacioNumero=0;
            }
        });
        
        botonSuma.setOnAction((ActionEvent event) ->
        { 
            double n =boton0.getHeight();
            Suma suma=new Suma(n, espacioNumero,espacioSuperior);
            root.getChildren().add(suma.start(path));
            //contador para el salto de linea en la pantalla
            espacioNumero+=100;
            contador+=100;
            if(contador>300){
                espacioSuperior+=120;
                contador =0;
                espacioNumero=0;
            }
        });
        
        botonResta.setOnAction((ActionEvent event) ->
        { 
            double n =boton0.getHeight();
            Resta resta=new Resta(n, espacioNumero,espacioSuperior);
            root.getChildren().add(resta.start(path));
            //contador para el salto de linea en la pantalla
            espacioNumero+=100;
            contador+=100;
            if(contador>300){
                espacioSuperior+=120;
                contador =0;
                espacioNumero=0;
            }
        });
        
        botonDivision.setOnAction((ActionEvent event) ->
        { 
            double n =boton0.getHeight();
            Division division=new Division(n, espacioNumero,espacioSuperior);
            root.getChildren().add(division.start(path));
            //contador para el salto de linea en la pantalla
            espacioNumero+=100;
            contador+=100;
            if(contador>300){
                espacioSuperior+=120;
                contador =0;
                espacioNumero=0;
            }
        });
        
        botonParentesis1.setOnAction((ActionEvent event) ->
        { 
            double n =boton0.getHeight();
            Parentesis1 parentesis1 = new Parentesis1(n, espacioNumero,espacioSuperior);
            root.getChildren().add(parentesis1.start(path));
            //contador para el salto de linea en la pantalla
            espacioNumero+=100;
            contador+=100;
            if(contador>300){
                espacioSuperior+=120;
                contador =0;
                espacioNumero=0;
            }
        });
        
        botonParentesis2.setOnAction((ActionEvent event) ->
        { 
            double n =boton0.getHeight();
            Parentesis2 parentesis2 = new Parentesis2(n, espacioNumero,espacioSuperior);
            root.getChildren().add(parentesis2.start(path));
            //contador para el salto de linea en la pantalla
            espacioNumero+=100;
            contador+=100;
            if(contador>300){
                espacioSuperior+=120;
                contador =0;
                espacioNumero=0;
            }
        });
        
        Scene scene = new Scene(root, 700, 700);
        stage.setScene(scene);
        stage.show();
    }
    
}
