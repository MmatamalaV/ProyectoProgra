
import java.util.ArrayList;
import java.util.List;
import javafx.event.ActionEvent;
import javafx.geometry.Insets;
import javafx.geometry.Orientation;
import javafx.geometry.Pos;
import javafx.scene.Group;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.Slider;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Priority;
import javafx.scene.layout.VBox;
import javafx.scene.shape.Box;
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
public class Pantalla{

    private double espacioNumero=0; //Espacio en X que indica a las figuras en qué posición deben dibujarse.
    private double espacioSuperior=0; //Espacio en Y que indica a las figuras en qué posición deben dibujarse.
    private boolean puntosVisibles = true;
    private List<NumerosYSimbolos> enPantalla; //Lista de todos los elementos dibujados en Pantalla.
    private Group centro;
    private Group grupoPantalla;
    private int divideStatus = 0; //Variable que sirve para saber en qué estado está una división.
    //divideStatus = 1; Significa que se ha iniciado una nueva división y se está dibujando en la parte de arriba de esta.
    //divideStatus = 2; Significa que se está dibujando en la parte inferior de uan división.
    //divideStatus = 0; Significa que no hay división activa.
    private int divisiones = 0; //Contador de Divisiones. Utilizado para tener control sobre el crecimiento de la línea de división.
    Stage primaryStage=new Stage();
    Botonera botones=new Botonera();
    HBox contenerdorPrincipal =new HBox();
    BorderPane BpanePrueba=new BorderPane();
    private static Pantalla pantalla;

    public Pantalla() {
        this.enPantalla = new ArrayList<NumerosYSimbolos>();
        inicio();
    }

    public void inicio(){
        
        
       
       //*******fin numeros***************
       
       //*******inicio Esena de dibujo***********
       Box box = new Box(100,100,100);
       BorderPane pane = new BorderPane();
       box.setManaged(true);    
       //pane.setCenter(box);
       Path center = new Path();
       center.setManaged(false);
       
       centro=new Group(center);

       grupoPantalla=new Group(centro);
       
       ScrollPane mainPane=new ScrollPane(grupoPantalla);

       pane.setCenter(mainPane);
       BorderPane.setAlignment(mainPane, Pos.CENTER);
       
       //** comboboxes **//
       
       HBox boxes=new HBox();
            
            ComboBox selectSize=new ComboBox();
                selectSize.getItems().addAll(
                    "50%",
                    "100%",
                    "200%"
                );
            selectSize.getSelectionModel().select("100%");
        
            ComboBox typeKeyboard =new ComboBox();
                typeKeyboard.getItems().addAll(
                    "Basica",
                    "Cientifica"
                );
            typeKeyboard.getSelectionModel().selectFirst();
            
            ComboBox base =new ComboBox();
                base.getItems().addAll(
                    "Decimal",
                    "Binario"
                );
            base.getSelectionModel().selectFirst();
            base.setVisible(false);
        
        boxes.getChildren().addAll(selectSize,typeKeyboard,base);
       pane.setTop(boxes);
       
       selectSize.setOnAction(e -> SetSize(selectSize.getValue().toString()));
       typeKeyboard.setOnAction(e -> SetTypeKeyboard(typeKeyboard.getValue().toString(),base));
       base.setOnAction(e -> SetBase(base.getValue().toString()));
       
       /*
       
       //Botones y sus funcionalidades.
       buttonDiv.setOnAction((ActionEvent event) ->
        {
            espacioNumero+=90;
            rePaintDivide();
            double n =0;
            if (divideStatus==0 || divideStatus==1){ //En caso que no haya división o que se esté en la parte superior de una, se añade una nueva división.
                NumerosYSimbolos division = new NumerosYSimbolos(n, espacioNumero-40,espacioSuperior, puntosVisibles);
                divisiones+=1;
                centro.getChildren().add(division.division(1, divisiones));
                enPantalla.add(division);
                divideStatus=1;
                espacioSuperior-=140;
            }
            else if (divideStatus==2) { //En caso que esté en la parte de abajo de una división.
                if (divisiones==0) { //Si no hay más divisiones, vuelve a escribir de forma normal.
                    divideStatus=0;
                    contador(false);
                }
                else { //Si hay más divisiones, vuelve a la parte superior de la última división.
                    divideStatus=1;
                    contador(false);
                }
                //Busca la última división escrita, lo establcece como división cerrada.
                for (int x = enPantalla.size()-1; x>=0; x--) {
                    if (enPantalla.get(x).getID() == '/') {
                        enPantalla.get(x).getNumDivision();
                        if (enPantalla.get(x).getNumDivision()==divisiones) {
                            enPantalla.get(x).setID('%');
                        }
                    }
                }
                rePaintDivide();
                divisiones-=1;
                buttonDiv.setText("/");
                
            }
            

            
        });
       
       
       buttonPor.setOnAction((ActionEvent event) ->
        { 
            double n =0;
            NumerosYSimbolos multiplicacion = new NumerosYSimbolos(n, espacioNumero,espacioSuperior, puntosVisibles);
            centro.getChildren().add(multiplicacion.multiplicacion());
            contador(false);
            enPantalla.add(multiplicacion);
            tryDivide();
        });
       
       buttonPar1.setOnAction((ActionEvent event) ->
        { 
            double n =0;
            NumerosYSimbolos parentesis1 = new NumerosYSimbolos(n, espacioNumero,espacioSuperior, puntosVisibles);
            centro.getChildren().add(parentesis1.parentesis1());
            contador(false);
            enPantalla.add(parentesis1);
            tryDivide();
            
            
        });
       
       buttonPar2.setOnAction((ActionEvent event) ->
        { 
            double n =0;
            NumerosYSimbolos parentesis2 = new NumerosYSimbolos(n, espacioNumero,espacioSuperior, puntosVisibles);
            centro.getChildren().add(parentesis2.parentesis2());
            contador(false);
            enPantalla.add(parentesis2);
            tryDivide();
            
        });

       buttonMas.setOnAction((ActionEvent event) ->
        { 
            double n =0;
            NumerosYSimbolos suma = new NumerosYSimbolos(n, espacioNumero,espacioSuperior, puntosVisibles);
            centro.getChildren().add(suma.suma());
            contador(false);
            enPantalla.add(suma);
            tryDivide();
            
        });
       
       buttonMenos.setOnAction((ActionEvent event) ->
        { 
            double n =0;
            NumerosYSimbolos resta = new NumerosYSimbolos(n, espacioNumero,espacioSuperior, puntosVisibles);
            centro.getChildren().add(resta.resta());
            contador(false);
            enPantalla.add(resta);
            tryDivide();
        });
       
       button0.setOnAction((ActionEvent event) ->
        { 
            double n =0;
            NumerosYSimbolos numero0 = new NumerosYSimbolos(n, espacioNumero,espacioSuperior, puntosVisibles);
            centro.getChildren().add(numero0.numero0());
            contador(false);
            enPantalla.add(numero0);
            tryDivide();
        });
       
       button1.setOnAction((ActionEvent event) ->
        { 
            double n =0;
            NumerosYSimbolos numero1 = new NumerosYSimbolos(n, espacioNumero,espacioSuperior, puntosVisibles);
            centro.getChildren().add(numero1.numero1());
            contador(false);
            enPantalla.add(numero1);
            tryDivide();
            
        });
       
       button2.setOnAction((ActionEvent event) ->
        { 
            double n =0;
            NumerosYSimbolos numero2 = new NumerosYSimbolos(n, espacioNumero,espacioSuperior, puntosVisibles);
            centro.getChildren().add(numero2.numero2());
            contador(false);
            enPantalla.add(numero2);
            tryDivide();
            
        });
       
       button3.setOnAction((ActionEvent event) ->
       { 
            double n =0;
            NumerosYSimbolos numero3 = new NumerosYSimbolos(n, espacioNumero,espacioSuperior, puntosVisibles);
            centro.getChildren().add(numero3.numero3());
            contador(false);
            enPantalla.add(numero3);
            tryDivide();
            
        });
       
       button4.setOnAction((ActionEvent event) ->
       {
            double n =0;
            NumerosYSimbolos numero4 = new NumerosYSimbolos(n, espacioNumero,espacioSuperior, puntosVisibles);
            centro.getChildren().add(numero4.numero4());
            contador(false);
            enPantalla.add(numero4);
            tryDivide();
                
               
        });
       
       button5.setOnAction((ActionEvent event) ->
           
        {
            double n =0;
            NumerosYSimbolos numero5 = new NumerosYSimbolos(n, espacioNumero,espacioSuperior, puntosVisibles);
            centro.getChildren().add(numero5.numero5());
            contador(false);
            enPantalla.add(numero5);
            tryDivide();
                
               
        });
       
       button6.setOnAction((ActionEvent event) ->
           
        {
             double n =0;
             NumerosYSimbolos numero6 = new NumerosYSimbolos(n, espacioNumero,espacioSuperior, puntosVisibles);
             centro.getChildren().add(numero6.numero6());
             contador(false);
             enPantalla.add(numero6);
             tryDivide();


         });
       
       button7.setOnAction((ActionEvent event) ->
           
        {
             double n =0;
             NumerosYSimbolos numero7 = new NumerosYSimbolos(n, espacioNumero,espacioSuperior, puntosVisibles);
             centro.getChildren().add(numero7.numero7());
             contador(false);
             enPantalla.add(numero7);
             tryDivide();


         });
       
       button8.setOnAction((ActionEvent event) ->
           
        {
             double n =0;
             NumerosYSimbolos numero8 = new NumerosYSimbolos(n, espacioNumero,espacioSuperior, puntosVisibles);
             centro.getChildren().add(numero8.numero8());
             contador(false);
             enPantalla.add(numero8);
             tryDivide();


         });
       
       button9.setOnAction((ActionEvent event) ->
           
        {
             double n =0;
             NumerosYSimbolos numero9 = new NumerosYSimbolos(n, espacioNumero,espacioSuperior, puntosVisibles);
             centro.getChildren().add(numero9.numero9());
             contador(false);
             enPantalla.add(numero9);

             tryDivide();


         });
       
         buttonCos.setOnAction((ActionEvent event) ->
           
        {
            double n =0;
            NumerosYSimbolos cos = new NumerosYSimbolos(n, espacioNumero,espacioSuperior, puntosVisibles);
            centro.getChildren().add(cos.cos());
            contador(true);
            enPantalla.add(cos);
            tryDivide();
                
               
        });
       
       buttonSen.setOnAction((ActionEvent event) ->
           
        {
            double n =0;
            NumerosYSimbolos sen = new NumerosYSimbolos(n, espacioNumero,espacioSuperior, puntosVisibles);
            centro.getChildren().add(sen.sen());
            contador(true);
            enPantalla.add(sen);
            tryDivide();
                
               
        });
       
       buttonTan.setOnAction((ActionEvent event) ->
           
        {
            double n =0;
            NumerosYSimbolos tan = new NumerosYSimbolos(n, espacioNumero,espacioSuperior, puntosVisibles);
            centro.getChildren().add(tan.tan());
            contador(true);
            enPantalla.add(tan);
            tryDivide();
                
               
        });
       
       //Este botón quita o pone los Puntos de Control.
       //Va cambiando el texto del botón según el estado de puntosVisibles.
       buttonNn2.setOnAction((ActionEvent event) ->
        { 
            if (puntosVisibles==true) {
                puntosVisibles=false;
                for (int x=0; x<enPantalla.size(); x++) {
                    enPantalla.get(x).visibleCircle(puntosVisibles);
                }
                buttonNn2.setText(" Mostrar Puntos de Control ");
            }
            else {
                puntosVisibles=true;
                for (int x=0; x<enPantalla.size(); x++)
                    enPantalla.get(x).visibleCircle(puntosVisibles);
                buttonNn2.setText("Esconder Puntos de Control");
            }
        });
       
       //Este botón elimina el último número escrito (Beta, falla con divisiones).
       /*buttonEliminar.setOnAction((ActionEvent event) ->
        {
            if (enPantalla.size()>0) {
                centro.getChildren().remove(centro.getChildren().size()-1);
                enPantalla.remove(centro.getChildren().size()-1);
                espacioNumero-=90;
            }   
        });*/
//        buttonEliminar.setOnAction((ActionEvent event) ->
//        {
//            Node elemento = centro.getChildren().get(0);
//            centro.getChildren().removeAll(centro.getChildren());
//            centro.getChildren().add(elemento);
//            enPantalla.removeAll(enPantalla);
//            divideStatus=0;
//            divisiones=0;
//            espacioNumero=0;
//            espacioSuperior=0;
//            buttonDiv.setText("/");
//            /*puntosVisibles=true;
//                for (int x=0; x<enPantalla.size(); x++)
//                    enPantalla.get(x).visibleCircle(puntosVisibles);
//                buttonNn2.setText("Esconder Puntos de Control");*/
//        });
//        
       /*
       //Este botón, en caso de estar arriba de una división, hace que se dibujen números o símbolos abajo de esta.
       buttonBajar.setOnAction((ActionEvent event) ->
        {
            if (divideStatus==1) {
                divideStatus=2;
                espacioSuperior+=140;
                buttonDiv.setText("Cierra División");
            }
        });
       
        */
       
       //** botones y sus funciones **//
       
       contenerdorPrincipal= botones.basico();
       //-------------------------------------//
       
       Slider sliderSubScene = new Slider();
       sliderSubScene.setMax(10000);// se define el largo maximo del  slider
       sliderSubScene.setMin(-10000);
       sliderSubScene.valueProperty().bindBidirectional(centro.translateXProperty());//se le da el recorrido al Slider en este caso es el largo del box
       //pane.setBottom(sliderSubScene);
       
       Slider sliderSubScene2 = new Slider();
       sliderSubScene2.setMax(10000);// se define el largo maximo del  slider
       sliderSubScene2.setMin(-10000);
       sliderSubScene2.setOrientation(Orientation.VERTICAL);
       sliderSubScene2.valueProperty().bindBidirectional(centro.translateYProperty());//se le da el recorrido al Slider en este caso es el largo del box
       //pane.setLeft(sliderSubScene2);
       
       
       
       //SubScene pantallaDibujo = new SubScene(aux1,300,300);//creamos la SubScene dando su contenido  luego su ancho y altura 
       //en este caso su contenido es un border pane.
       
       //*******fin Esena de dibujo**************
      
       BpanePrueba.setBottom(contenerdorPrincipal);
        
       //BpanePrueba.setCenter(pantallaDibujo);
       BpanePrueba.setCenter(pane);
      
        
        //StackPane root = new StackPane();
        
        primaryStage.setTitle("Cancer de Piel");//titulo de la ventana 
        
        Scene scene = new Scene (BpanePrueba,800,600);//constructor de la ventana
        
        BpanePrueba.setMinSize(800, 600);
        //root.setPrefSize(400, 300);
        /**root.minHeight(300);
        root.minWidth(400);*/
        //root.getChildren().add(BpanePrueba);//agregamos el boton a al root
        primaryStage.setScene(scene);//agregamos scene a la pantalla
        primaryStage.show();//mostramos la pantalla
    }
    
    //Método que aumenta en X para dejar espacio a los números.
    void contador(boolean saltaTres){
        if (saltaTres==false)
            espacioNumero+=90;
        else
            espacioNumero+=270;
        
        //contador+=200;
        /*if(contador>14000){
            espacioSuperior+=120;
            contador=0;
            espacioNumero=0;
        }*/
    }
    /*Este método busca la úlima división escrita guiándose por su ID, obtiene sus datos de ubicación y cantidad
    de simbolos escritos en esta, entonces elimina la actual, para dar paso a una nueva división la cual aumenta en tamaño con la variable
    aumountOfSymbolsDivide.
    */
    private void rePaintDivide(){
        double espacioDivision;
        double superiorDivision;
        double amountOfSymbols;
        int x = enPantalla.size()-1;
        int divisionesActual;
        while (enPantalla.size()>x && x>=0) {
            //Se verifica que el elemento corresponda a una división abierta.
            if (enPantalla.get(x).getID()=='/') {
                //Se obtienen las coordenadas iniciales de la división.
                espacioDivision= enPantalla.get(x).getxPoint()-200;
                superiorDivision = enPantalla.get(x).getyPoint()-80;
                //Se aumenta en 1 la de elementos en la división.
                amountOfSymbols = enPantalla.get(x).getAmountOfSymbolsDivide()+1;
                divisionesActual = enPantalla.get(x).getNumDivision();
                //Se elimina la división actual.
                enPantalla.remove(x);
                centro.getChildren().remove(x+1);
                //Se crea una nueva división que abarque más elementos.
                NumerosYSimbolos division = new NumerosYSimbolos(0, espacioDivision,superiorDivision, puntosVisibles);
                centro.getChildren().add(division.division(amountOfSymbols, divisionesActual));
                enPantalla.add(division);
            }
            x--;
        }
    }
    
    //Este método verifica si acutalmente hay una división activa o no, para entonces dar paso a rePaintDivide o no.
    void tryDivide(){
        if (divideStatus==0)
            return;
        if (divideStatus==1)
            rePaintDivide();
        if (divideStatus==2)
            rePaintDivide();
    }

    
    //** aqui va todo lo de los cambios de tamaño **//
    private void SetSize(String toString) {
        switch (toString){
            
            case "100%":
                setScaleNumbers(1);
            break;
            
            case "50%":
                setScaleNumbers(0.5);
                
            break;
                
            case "200%":
                setScaleNumbers(2);
                
            break;
        }
    }
    
    //** aqui va todo lo de los cambios de base **//
    private void SetBase(String toString) {
        
    }

    //** aqui va todo lo de los cambios de teclado **//
    private void SetTypeKeyboard(String toString,ComboBox base) {
        switch(toString){
            case "Basica":
                base.setVisible(false);
                base.getSelectionModel().selectFirst();
                BpanePrueba.getChildren().remove(contenerdorPrincipal);
                contenerdorPrincipal=botones.basico();
                BpanePrueba.setBottom(contenerdorPrincipal);
            break;
            
            case "Cientifica":
                base.setVisible(true);
                BpanePrueba.getChildren().remove(contenerdorPrincipal);
                contenerdorPrincipal=botones.cientifica();
                BpanePrueba.setBottom(contenerdorPrincipal);
            break;
        }
    }
    
    private void setScaleNumbers(double size){
        centro.setScaleX(size);
        centro.setScaleY(size);
    }
    
    public static Pantalla getSingletonInstance() {
        if (pantalla == null){
            pantalla = new Pantalla();
        }
        else{
            System.out.println("error");
        }
        
        return pantalla;
    }
    
    void agregarACentro(Group n){
        this.centro.getChildren().add(n);
    }

    public double getEspacioNumero() {
        return espacioNumero;
    }

    public void setEspacioNumero(double espacioNumero) {
        this.espacioNumero = espacioNumero;
    }

    public double getEspacioSuperior() {
        return espacioSuperior;
    }

    public void setEspacioSuperior(double espacioSuperior) {
        this.espacioSuperior = espacioSuperior;
    }

    public boolean isPuntosVisibles() {
        return puntosVisibles;
    }

    public void setPuntosVisibles(boolean puntosVisibles) {
        this.puntosVisibles = puntosVisibles;
    }

    public List<NumerosYSimbolos> getEnPantalla() {
        return enPantalla;
    }

    public void addEnPantalla(NumerosYSimbolos n) {
        this.enPantalla.add(n);
    }
    
}
    