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
import PuntosDeControlYMovimiento.PuntosDeControl;
import java.util.ArrayList;
import java.util.List;
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
    public boolean puntosVisibles = true;
    private final List enPantalla = new ArrayList();
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        launch(args);
    }

    @Override
    public void start(Stage stage) throws Exception {
        List<PuntosDeControl> enPantalla = new ArrayList<>();
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
                
                Button botonMuestraEsconde = new Button("Mostrar/Ocultar Puntos");
                boton0.setMinWidth(100);
                boton0.setMaxWidth(100);
                        
                        
        botones.getChildren().addAll(botonMuestraEsconde, boton0, boton1, boton4, botonMulti, botonSuma, botonResta, botonDivision, botonParentesis1, botonParentesis2);
        Path path = new Path();   
        general.getChildren().addAll(botones, path);
        
        Group root= new Group(general);
        
        botonMuestraEsconde.setOnAction((ActionEvent event) ->
        { 
            int tamano = enPantalla.size();
            puntosVisibles = puntosVisibles != true;
            for (int x=0; x<tamano; x++)
                enPantalla.get(x).visibleCircle(puntosVisibles);
        });
        
        
        boton0.setOnAction((ActionEvent event) ->
        { 
            double n =boton0.getHeight();
            Numero0 numero0=new Numero0(n, espacioNumero,espacioSuperior, puntosVisibles);
            root.getChildren().add(numero0.start(path));
            //contador para el salto de linea en la pantalla
            espacioNumero+=100;
            contador+=100;
            if(contador>300){
                espacioSuperior+=120;
                contador =0;
                espacioNumero=0;
            }
            enPantalla.add(numero0);
        });
        
        
        boton4.setOnAction((ActionEvent event) ->
        { 
            double n =boton4.getHeight();
            Numero4 numero4 = new Numero4(n, espacioNumero,espacioSuperior, puntosVisibles);
            root.getChildren().add(numero4.start(path));
            //contador para el salto de linea en la pantalla
            espacioNumero+=100;
            contador+=100;
            if(contador>300){
                espacioSuperior+=120;
                contador =0;
                espacioNumero=0;
            }
            enPantalla.add(numero4);
        });
        
        boton1.setOnAction((ActionEvent event) ->
        { 
            double n =boton1.getHeight();
            Numero1 numero1 = new Numero1(n, espacioNumero,espacioSuperior, puntosVisibles);
            root.getChildren().add(numero1.start(path));
            //contador para el salto de linea en la pantalla
            espacioNumero+=100;
            contador+=100;
            if(contador>300){
                espacioSuperior+=120;
                contador =0;
                espacioNumero=0;
            }
            enPantalla.add(numero1);
        });
        
        botonMulti.setOnAction((ActionEvent event) ->
        { 
            double n =boton0.getHeight();
            Multiplicacion multi=new Multiplicacion(n, espacioNumero,espacioSuperior, puntosVisibles);
            root.getChildren().add(multi.start(path));
            //contador para el salto de linea en la pantalla
            espacioNumero+=100;
            contador+=100;
            if(contador>300){
                espacioSuperior+=120;
                contador =0;
                espacioNumero=0;
            }
            enPantalla.add(multi);
        });
        
        botonSuma.setOnAction((ActionEvent event) ->
        { 
            double n =boton0.getHeight();
            Suma suma=new Suma(n, espacioNumero,espacioSuperior, puntosVisibles);
            root.getChildren().add(suma.start(path));
            //contador para el salto de linea en la pantalla
            espacioNumero+=100;
            contador+=100;
            if(contador>300){
                espacioSuperior+=120;
                contador =0;
                espacioNumero=0;
            }
            enPantalla.add(suma);
        });
        
        botonResta.setOnAction((ActionEvent event) ->
        { 
            double n =boton0.getHeight();
            Resta resta=new Resta(n, espacioNumero,espacioSuperior, puntosVisibles);
            root.getChildren().add(resta.start(path));
            //contador para el salto de linea en la pantalla
            espacioNumero+=100;
            contador+=100;
            if(contador>300){
                espacioSuperior+=120;
                contador =0;
                espacioNumero=0;
            }
            enPantalla.add(resta);
        });
        
        botonDivision.setOnAction((ActionEvent event) ->
        { 
            double n =boton0.getHeight();
            Division division=new Division(n, espacioNumero,espacioSuperior, puntosVisibles);
            root.getChildren().add(division.start(path));
            //contador para el salto de linea en la pantalla
            espacioNumero+=100;
            contador+=100;
            if(contador>300){
                espacioSuperior+=120;
                contador =0;
                espacioNumero=0;
            }
            enPantalla.add(division);
        });
        
        botonParentesis1.setOnAction((ActionEvent event) ->
        { 
            double n =boton0.getHeight();
            Parentesis1 parentesis1 = new Parentesis1(n, espacioNumero,espacioSuperior, puntosVisibles);
            root.getChildren().add(parentesis1.start(path));
            //contador para el salto de linea en la pantalla
            espacioNumero+=100;
            contador+=100;
            if(contador>300){
                espacioSuperior+=120;
                contador =0;
                espacioNumero=0;
            }
            enPantalla.add(parentesis1);
        });
        
        botonParentesis2.setOnAction((ActionEvent event) ->
        { 
            double n =boton0.getHeight();
            Parentesis2 parentesis2 = new Parentesis2(n, espacioNumero,espacioSuperior, puntosVisibles);
            root.getChildren().add(parentesis2.start(path));
            //contador para el salto de linea en la pantalla
            espacioNumero+=100;
            contador+=100;
            if(contador>300){
                espacioSuperior+=120;
                contador =0;
                espacioNumero=0;
            }
            enPantalla.add(parentesis2);
        });
        
        Scene scene = new Scene(root, 700, 700);
        stage.setScene(scene);
        stage.show();
    }
    
}
