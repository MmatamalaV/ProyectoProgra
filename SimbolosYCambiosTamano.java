import static java.lang.Math.PI;
import javafx.application.Application; 
import javafx.event.EventHandler;
import javafx.scene.Group; 
import javafx.scene.Scene; 
import javafx.scene.input.MouseButton;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Color;
import javafx.scene.shape.Arc;
import javafx.scene.shape.ArcType;
import javafx.scene.shape.Circle;
import javafx.stage.Stage; 
import javafx.scene.shape.LineTo; 
import javafx.scene.shape.MoveTo; 
import javafx.scene.shape.Path; 
         
public class SimbolosYCambiosTamano extends Application { 

    //hola
    
    double m_nX = 0;
    double m_nY = 0;
    double m_nMouseX = 0;
    double m_nMouseY = 0;
    Group circle=new Group();
    Group g = new Group();
        
    @Override 
    public void start(Stage stage) { 
    
    

    Path path = new Path(); 
       
    int xPoint; //Variable Posicion X de la figura
    int yPoint; //Variable Posicion Y de la Figura
    double size; //Variable para el tamaño de la figura
    boolean control = true; //Boolean para mostrar o no los puntos de control.
    
    size=2;
    
    //Multiplicación
    xPoint=(int) (30*size);
    yPoint=(int) (45*size);

    MoveTo centroMulti = new MoveTo(xPoint, yPoint);
    LineTo line1Multi = new LineTo(xPoint-15*size, yPoint-15*size);
    LineTo line2Multi = new LineTo(xPoint+15*size, yPoint+15*size);
    LineTo line3Multi = new LineTo(xPoint, yPoint-20*size);
    LineTo line4Multi = new LineTo(xPoint, yPoint+20*size);
    LineTo line5Multi = new LineTo(xPoint+15*size, yPoint-15*size);
    LineTo line6Multi = new LineTo(xPoint-15*size, yPoint+15*size);
    LineTo line7Multi = new LineTo(xPoint-20*size, yPoint);
    LineTo line8Multi = new LineTo(xPoint+20*size, yPoint);
    
    path.setStrokeWidth(4*size);
    
    path.getElements().addAll(centroMulti, line1Multi,centroMulti, line2Multi, centroMulti, line3Multi, centroMulti, line4Multi, centroMulti, line5Multi, centroMulti, line6Multi, centroMulti, line7Multi, centroMulti, line8Multi);
    
    //Cero
    xPoint=(int) (90*size);
    yPoint=(int) (45*size);
    
    Arc arcZero = new Arc(xPoint, yPoint,25*size,40*size,90,90);
    Arc arc1Zero = new Arc(xPoint, yPoint,25*size,40*size,180,90);
    Arc arc2Zero = new Arc(xPoint, yPoint,25*size,40*size,270,90);
    Arc arc3Zero = new Arc(xPoint, yPoint,25*size,40*size,360,90);
    
    arcZero.setStroke(Color.BLACK);
    arcZero.setFill(null);
    
    arc1Zero.setStroke(Color.BLACK);
    arc1Zero.setFill(null);
    
    arc2Zero.setStroke(Color.BLACK);
    arc2Zero.setFill(null);
    
    arc3Zero.setStroke(Color.BLACK);
    arc3Zero.setFill(null);

    arcZero.setStrokeWidth(4*size);
    arc1Zero.setStrokeWidth(4*size);
    arc2Zero.setStrokeWidth(4*size);
    arc3Zero.setStrokeWidth(4*size);
    
    //Resta
    xPoint=(int) (147*size);
    yPoint=(int) (45*size);
    
    MoveTo startMinus = new MoveTo(xPoint, yPoint);
    LineTo line1Minus = new LineTo(xPoint-20*size, yPoint);
    LineTo line2Minus = new LineTo(xPoint+20*size, yPoint);

    path.setStrokeWidth(4*size);
    
    path.getElements().addAll(startMinus, line1Minus, startMinus, line2Minus);
    
    
    //División
    double amountOfSymbolsDivide = 3*size; //Variable para cantidad de números que irán en la división
    
    xPoint=(int) (160*size);
    yPoint=(int) (100*size);
    
    MoveTo startDivide = new MoveTo(xPoint, yPoint);
    LineTo line1Divide = new LineTo(xPoint-40*amountOfSymbolsDivide, yPoint);
    LineTo line2Divide = new LineTo(xPoint+40*amountOfSymbolsDivide, yPoint);

    path.setStrokeWidth(4*size);
    
    path.getElements().addAll(startDivide, line1Divide, startDivide, line2Divide);
    
    //Suma
    xPoint=(int) (200*size);
    yPoint=(int) (45*size);
    
    MoveTo startPlus = new MoveTo(xPoint, yPoint);
    LineTo line1Plus = new LineTo(xPoint+20*size, yPoint);
    LineTo line2Plus = new LineTo(xPoint-20*size, yPoint);
    LineTo line3Plus = new LineTo(xPoint, yPoint+20*size);
    LineTo line4Plus = new LineTo(xPoint, yPoint-20*size);

    path.setStrokeWidth(4*size);
    
    path.getElements().addAll(startPlus, line1Plus, startPlus, line2Plus, startPlus, line3Plus, startPlus, line4Plus);
    
    //Paréntesis 1
    int amountOfSymbolsParen1 = (int) (1*size); //Para cambiar tamaño de acuerdo a la cantidad de operaciones en vertical
    xPoint=(int) (250*size);
    yPoint=(int) (45*size);
    
    Arc arc1Paren1 = new Arc(xPoint, yPoint,8*amountOfSymbolsParen1,42*amountOfSymbolsParen1,90,90);
    Arc arc2Paren1 = new Arc(xPoint, yPoint,8*amountOfSymbolsParen1,42*amountOfSymbolsParen1,180,90);
    
    arc1Paren1.setStroke(Color.BLACK);
    arc1Paren1.setFill(null);
    
    arc2Paren1.setStroke(Color.BLACK);
    arc2Paren1.setFill(null);
    
    arc1Paren1.setStrokeWidth(4*size);
    arc2Paren1.setStrokeWidth(4*size);
    
    //Paréntesis 2
    int amountOfSymbolsParen2 = (int) (1*size); //Para cambiar tamaño de acuerdo a la cantidad de operaciones en vertical
    xPoint=(int) (270*size);
    yPoint=(int) (45*size);
    
    Arc arc1Paren2 = new Arc(xPoint, yPoint,8*amountOfSymbolsParen2,42*amountOfSymbolsParen2,270,90);
    Arc arc2Paren2 = new Arc(xPoint, yPoint,8*amountOfSymbolsParen2,42*amountOfSymbolsParen2,360,90);
    
    arc1Paren2.setStroke(Color.BLACK);
    arc1Paren2.setFill(null);
    
    arc2Paren2.setStroke(Color.BLACK);
    arc2Paren2.setFill(null);
    
    arc1Paren2.setStrokeWidth(4*size);
    arc2Paren2.setStrokeWidth(4*size);
    
    
    double circleRadius = size*2;
    double circleStrokeWidth = size*2;
            
    //Círculos de Control para número 0
    Circle c1Zero = new Circle();
    c1Zero.setCenterX(arcZero.getCenterX());
    c1Zero.setCenterY(arcZero.getCenterY()-40*size);
    c1Zero.setRadius(circleRadius);
    c1Zero.setCache(true);
    c1Zero.setStroke(Color.RED);
    c1Zero.setStrokeWidth(circleStrokeWidth);

    Circle c2Zero = new Circle();
    c2Zero.setCenterX(arc1Zero.getCenterX()+25*size);
    c2Zero.setCenterY(arc1Zero.getCenterY());
    c2Zero.setRadius(circleRadius);
    c2Zero.setCache(true);
    c2Zero.setStroke(Color.RED);
    c2Zero.setStrokeWidth(circleStrokeWidth);

    Circle c3Zero = new Circle();
    c3Zero.setCenterX(arc2Zero.getCenterX());
    c3Zero.setCenterY(arc2Zero.getCenterY()+40*size);
    c3Zero.setRadius(circleRadius);
    c3Zero.setStroke(Color.RED);
    c3Zero.setStrokeWidth(circleStrokeWidth);

    Circle c4Zero = new Circle();
    c4Zero.setCenterX(arc3Zero.getCenterX()-25*size);
    c4Zero.setCenterY(arc3Zero.getCenterY());
    c4Zero.setRadius(circleRadius);
    c4Zero.setStroke(Color.RED);
    c4Zero.setStrokeWidth(circleStrokeWidth);

    //Círculos de Control para el símbolo de Multiplicación
    Circle c1Multi = new Circle();
    c1Multi.setCenterX(centroMulti.getX());
    c1Multi.setCenterY(centroMulti.getY());
    c1Multi.setRadius(circleRadius);
    c1Multi.setCache(true);
    c1Multi.setStroke(Color.RED);
    c1Multi.setStrokeWidth(circleStrokeWidth);

    Circle c2Multi = new Circle();
    c2Multi.setCenterX(line1Multi.getX());
    c2Multi.setCenterY(line1Multi.getY());
    c2Multi.setRadius(circleRadius);
    c2Multi.setStroke(Color.RED);
    c2Multi.setStrokeWidth(circleStrokeWidth);

    Circle c3Multi = new Circle();
    c3Multi.setCenterX(line2Multi.getX());
    c3Multi.setCenterY(line2Multi.getY());
    c3Multi.setRadius(circleRadius);
    c3Multi.setCache(true);
    c3Multi.setStroke(Color.RED);
    c3Multi.setStrokeWidth(circleStrokeWidth);

    Circle c4Multi = new Circle();
    c4Multi.setCenterX(line3Multi.getX());
    c4Multi.setCenterY(line3Multi.getY());
    c4Multi.setRadius(circleRadius);
    c4Multi.setStroke(Color.RED);
    c4Multi.setStrokeWidth(circleStrokeWidth);

    Circle c5Multi = new Circle();
    c5Multi.setCenterX(line4Multi.getX());
    c5Multi.setCenterY(line4Multi.getY());
    c5Multi.setRadius(circleRadius);
    c5Multi.setCache(true);
    c5Multi.setStroke(Color.RED);
    c5Multi.setStrokeWidth(circleStrokeWidth);

    Circle c6Multi = new Circle();
    c6Multi.setCenterX(line5Multi.getX());
    c6Multi.setCenterY(line5Multi.getY());
    c6Multi.setRadius(circleRadius);
    c6Multi.setStroke(Color.RED);
    c6Multi.setStrokeWidth(circleStrokeWidth);

    Circle c7Multi = new Circle();
    c7Multi.setCenterX(line6Multi.getX());
    c7Multi.setCenterY(line6Multi.getY());
    c7Multi.setRadius(circleRadius);
    c7Multi.setCache(true);
    c7Multi.setStroke(Color.RED);
    c7Multi.setStrokeWidth(circleStrokeWidth);

    Circle c8Multi = new Circle();
    c8Multi.setCenterX(line7Multi.getX());
    c8Multi.setCenterY(line7Multi.getY());
    c8Multi.setRadius(circleRadius);
    c8Multi.setStroke(Color.RED);
    c8Multi.setStrokeWidth(circleStrokeWidth);

    Circle c9Multi = new Circle();
    c9Multi.setCenterX(line8Multi.getX());
    c9Multi.setCenterY(line8Multi.getY());
    c9Multi.setRadius(circleRadius);
    c9Multi.setStroke(Color.RED);
    c9Multi.setStrokeWidth(circleStrokeWidth);
    
    //Círculos de Control para símbolo Resta
    Circle c1Minus = new Circle();
    c1Minus.setCenterX(startMinus.getX());
    c1Minus.setCenterY(startMinus.getY());
    c1Minus.setRadius(circleRadius);
    c1Minus.setCache(true);
    c1Minus.setStroke(Color.RED);
    c1Minus.setStrokeWidth(circleStrokeWidth);
    
    Circle c2Minus = new Circle();
    c2Minus.setCenterX(line1Minus.getX());
    c2Minus.setCenterY(line1Minus.getY());
    c2Minus.setRadius(circleRadius);
    c2Minus.setCache(true);
    c2Minus.setStroke(Color.RED);
    c2Minus.setStrokeWidth(circleStrokeWidth);
    
    Circle c3Minus = new Circle();
    c3Minus.setCenterX(line2Minus.getX());
    c3Minus.setCenterY(line2Minus.getY());
    c3Minus.setRadius(circleRadius);
    c3Minus.setCache(true);
    c3Minus.setStroke(Color.RED);
    c3Minus.setStrokeWidth(circleStrokeWidth);
    
    //Círculos de Control para símbolo Suma
    Circle c1Plus = new Circle();
    c1Plus.setCenterX(startPlus.getX());
    c1Plus.setCenterY(startPlus.getY());
    c1Plus.setRadius(circleRadius);
    c1Plus.setCache(true);
    c1Plus.setStroke(Color.RED);
    c1Plus.setStrokeWidth(circleStrokeWidth);
    
    Circle c2Plus = new Circle();
    c2Plus.setCenterX(line1Plus.getX());
    c2Plus.setCenterY(line1Plus.getY());
    c2Plus.setRadius(circleRadius);
    c2Plus.setCache(true);
    c2Plus.setStroke(Color.RED);
    c2Plus.setStrokeWidth(circleStrokeWidth);
    
    Circle c3Plus = new Circle();
    c3Plus.setCenterX(line2Plus.getX());
    c3Plus.setCenterY(line2Plus.getY());
    c3Plus.setRadius(circleRadius);
    c3Plus.setCache(true);
    c3Plus.setStroke(Color.RED);
    c3Plus.setStrokeWidth(circleStrokeWidth);
    
    Circle c4Plus = new Circle();
    c4Plus.setCenterX(line3Plus.getX());
    c4Plus.setCenterY(line3Plus.getY());
    c4Plus.setRadius(circleRadius);
    c4Plus.setCache(true);
    c4Plus.setStroke(Color.RED);
    c4Plus.setStrokeWidth(circleStrokeWidth);
    
    Circle c5Plus = new Circle();
    c5Plus.setCenterX(line4Plus.getX());
    c5Plus.setCenterY(line4Plus.getY());
    c5Plus.setRadius(circleRadius);
    c5Plus.setCache(true);
    c5Plus.setStroke(Color.RED);
    c5Plus.setStrokeWidth(circleStrokeWidth);
    
    //Círculos de Control Símbolo División
    Circle c1Divide = new Circle();
    c1Divide.setCenterX(startDivide.getX());
    c1Divide.setCenterY(startDivide.getY());
    c1Divide.setRadius(circleRadius);
    c1Divide.setCache(true);
    c1Divide.setStroke(Color.RED);
    c1Divide.setStrokeWidth(circleStrokeWidth);
    
    Circle c2Divide = new Circle();
    c2Divide.setCenterX(line1Divide.getX());
    c2Divide.setCenterY(line1Divide.getY());
    c2Divide.setRadius(circleRadius);
    c2Divide.setCache(true);
    c2Divide.setStroke(Color.RED);
    c2Divide.setStrokeWidth(circleStrokeWidth);
    
    Circle c3Divide = new Circle();
    c3Divide.setCenterX(line2Divide.getX());
    c3Divide.setCenterY(line2Divide.getY());
    c3Divide.setRadius(circleRadius);
    c3Divide.setCache(true);
    c3Divide.setStroke(Color.RED);
    c3Divide.setStrokeWidth(circleStrokeWidth);
    
    //Círculos de Control para Paréntesis 1
    Circle c1Paren1 = new Circle();
    c1Paren1.setCenterX(arc1Paren1.getCenterX());
    c1Paren1.setCenterY(arc1Paren1.getCenterY()-42*size);
    c1Paren1.setRadius(circleRadius);
    c1Paren1.setCache(true);
    c1Paren1.setStroke(Color.RED);
    c1Paren1.setStrokeWidth(circleStrokeWidth);
    
    Circle c2Paren1 = new Circle();
    c2Paren1.setCenterX(arc2Paren1.getCenterX()-7.5*size);
    c2Paren1.setCenterY(arc2Paren1.getCenterY());
    c2Paren1.setRadius(circleRadius);
    c2Paren1.setCache(true);
    c2Paren1.setStroke(Color.RED);
    c2Paren1.setStrokeWidth(circleStrokeWidth);
    
    Circle c3Paren1 = new Circle();
    c3Paren1.setCenterX(arc2Paren1.getCenterX());
    c3Paren1.setCenterY(arc2Paren1.getCenterY()+42*size);
    c3Paren1.setRadius(circleRadius);
    c3Paren1.setCache(true);
    c3Paren1.setStroke(Color.RED);
    c3Paren1.setStrokeWidth(circleStrokeWidth);
    
    //Círculos de Control para Paréntesis 2
    Circle c1Paren2 = new Circle();
    c1Paren2.setCenterX(arc1Paren2.getCenterX());
    c1Paren2.setCenterY(arc1Paren2.getCenterY()-42*size);
    c1Paren2.setRadius(circleRadius);
    c1Paren2.setCache(true);
    c1Paren2.setStroke(Color.RED);
    c1Paren2.setStrokeWidth(circleStrokeWidth);
    
    Circle c2Paren2 = new Circle();
    c2Paren2.setCenterX(arc2Paren2.getCenterX()+7.5*size);
    c2Paren2.setCenterY(arc2Paren2.getCenterY());
    c2Paren2.setRadius(circleRadius);
    c2Paren2.setCache(true);
    c2Paren2.setStroke(Color.RED);
    c2Paren2.setStrokeWidth(circleStrokeWidth);
    
    Circle c3Paren2 = new Circle();
    c3Paren2.setCenterX(arc2Paren2.getCenterX());
    c3Paren2.setCenterY(arc2Paren2.getCenterY()+42*size);
    c3Paren2.setRadius(circleRadius);
    c3Paren2.setCache(true);
    c3Paren2.setStroke(Color.RED);
    c3Paren2.setStrokeWidth(circleStrokeWidth);

            
    //se crea el grupo para generar el numero
    Group root = new Group(path, arcZero, arc1Zero, arc2Zero, arc3Zero, arc1Paren1, arc2Paren1, arc1Paren2, arc2Paren2);
    
    //Se aplican los círculos de control al símbolo de Multiplicación
    
    if (control== true){
        //Multiplicación
        circle.getChildren().addAll(c1Multi, c2Multi, c3Multi, c4Multi, c5Multi, c6Multi, c7Multi, c8Multi, c9Multi);
        //Cero
        circle.getChildren().addAll(c1Zero,c2Zero,c3Zero,c4Zero);
        //Resta
        circle.getChildren().addAll(c1Minus, c2Minus, c3Minus);
        //Suma
        circle.getChildren().addAll(c1Plus, c2Plus, c3Plus, c4Plus, c5Plus);
        //División
        circle.getChildren().addAll(c1Divide, c2Divide, c3Divide);
        //Paréntesis 1
        circle.getChildren().addAll(c1Paren1, c2Paren1, c3Paren1);
        //Paréntesis 2
        circle.getChildren().addAll(c1Paren2, c2Paren2, c3Paren2);

        root.getChildren().addAll(circle);
    }
    

    
    //se toma la posicion del circulo al cl1ckearlo
    //Multiplicacion
    c1Multi.setOnMousePressed(pressMouse(c1Multi));
    c1Multi.setOnMouseDragged(dragMouseInicial(c1Multi, centroMulti));
    c2Multi.setOnMousePressed(pressMouse(c2Multi));
    c2Multi.setOnMouseDragged(dragMouse(c2Multi, line1Multi));
    c3Multi.setOnMousePressed(pressMouse(c3Multi));
    c3Multi.setOnMouseDragged(dragMouse(c3Multi, line2Multi));
    c4Multi.setOnMousePressed(pressMouse(c4Multi));
    c4Multi.setOnMouseDragged(dragMouse(c4Multi, line3Multi));
    c5Multi.setOnMousePressed(pressMouse(c5Multi));
    c5Multi.setOnMouseDragged(dragMouse(c5Multi, line4Multi));
    c6Multi.setOnMousePressed(pressMouse(c6Multi));
    c6Multi.setOnMouseDragged(dragMouse(c6Multi, line5Multi));
    c7Multi.setOnMousePressed(pressMouse(c7Multi));
    c7Multi.setOnMouseDragged(dragMouse(c7Multi, line6Multi));
    c8Multi.setOnMousePressed(pressMouse(c8Multi));
    c8Multi.setOnMouseDragged(dragMouse(c8Multi, line7Multi));
    c9Multi.setOnMousePressed(pressMouse(c9Multi));
    c9Multi.setOnMouseDragged(dragMouse(c9Multi, line8Multi));
    
    //Suma
    c1Plus.setOnMousePressed(pressMouse(c1Plus));
    c1Plus.setOnMouseDragged(dragMouseInicial(c1Plus, startPlus));
    c2Plus.setOnMousePressed(pressMouse(c2Plus));
    c2Plus.setOnMouseDragged(dragMouse(c2Plus, line1Plus));
    c3Plus.setOnMousePressed(pressMouse(c3Plus));
    c3Plus.setOnMouseDragged(dragMouse(c3Plus, line2Plus));
    c4Plus.setOnMousePressed(pressMouse(c4Multi));
    c4Plus.setOnMouseDragged(dragMouse(c4Plus, line3Plus));
    c5Plus.setOnMousePressed(pressMouse(c5Plus));
    c5Plus.setOnMouseDragged(dragMouse(c5Plus, line4Plus));
    
    //Menos
    c1Minus.setOnMousePressed(pressMouse(c1Minus));
    c1Minus.setOnMouseDragged(dragMouseInicial(c1Minus, startMinus));
    c2Minus.setOnMousePressed(pressMouse(c2Minus));
    c2Minus.setOnMouseDragged(dragMouse(c2Minus, line1Minus));
    c3Minus.setOnMousePressed(pressMouse(c3Minus));
    c3Minus.setOnMouseDragged(dragMouse(c3Minus, line2Minus));
    
    //División
    c1Divide.setOnMousePressed(pressMouse(c1Divide));
    c1Divide.setOnMouseDragged(dragMouseInicial(c1Divide, startDivide));
    c2Divide.setOnMousePressed(pressMouse(c2Divide));
    c2Divide.setOnMouseDragged(dragMouse(c2Divide, line1Divide));
    c3Divide.setOnMousePressed(pressMouse(c3Divide));
    c3Divide.setOnMouseDragged(dragMouse(c3Divide, line2Divide));
    
    //Paréntesis 1
    
    //Paréntesis 2
            
      
    //se crea la escena 
    Scene scene = new Scene(root, 320*size,240*size);  

    //titulo
    stage.setTitle("Atacaso Artístico");

    //se agrega la escena a la ventana
    stage.setScene(scene);

    //se hace correr la ventana
    stage.show();         
   } 
   public static void main(String args[]){ 
      launch(args); 
   } 
   
   
   //se usa para obtener la posicion del circulo o punto de movimiento
   EventHandler<MouseEvent> pressMouse(Circle c) {
        EventHandler<MouseEvent> mousePressHandler = new EventHandler<MouseEvent>() {

            public void handle(MouseEvent event) {
                if (event.getButton() == MouseButton.PRIMARY) {
                    // get the current mouse coordinates according to the scene.
                    m_nMouseX = event.getSceneX();
                    m_nMouseY = event.getSceneY();

                    // get the current coordinates of the draggable node.
                    m_nX = c.getLayoutX();
                    m_nY = c.getLayoutY();
                }
            }
        };
        return mousePressHandler;
    }
   
   //dragMouse y dragMouseInicial son lo mismo pero uno es para el moveto que es el punto inicial y el otro para el lineto que son el resto de puntos
   EventHandler<MouseEvent> dragMouseInicial(Circle c, MoveTo l) {
        EventHandler<MouseEvent> dragHandler = new EventHandler<MouseEvent>() {

            public void handle(MouseEvent event) {
                if (event.getButton() == MouseButton.PRIMARY) {
                    // find the delta coordinates by subtracting the new mouse
                    // coordinates with the old.
                    double deltaX = event.getSceneX() - m_nMouseX;
                    double deltaY = event.getSceneY() - m_nMouseY;

                    // add the delta coordinates to the node coordinates.
                    m_nX += deltaX;
                    m_nY += deltaY;

                    // set the layout for the draggable node.
                    c.setLayoutX(m_nX);
                    c.setLayoutY(m_nY);
                    l.setX(event.getSceneX());
                    l.setY(event.getSceneY());
                    
                    //l.setCenterX(m_nX);
                    //l.setLayoutY(m_nY);

                    // get the latest mouse coordinate.
                    m_nMouseX = event.getSceneX();
                    m_nMouseY = event.getSceneY();
                }
            }
        };
        return dragHandler;
    }
   
   EventHandler<MouseEvent> dragMouse(Circle c, LineTo l) {
        EventHandler<MouseEvent> dragHandler = new EventHandler<MouseEvent>() {

            public void handle(MouseEvent event) {
                if (event.getButton() == MouseButton.PRIMARY) {
                    // find the delta coordinates by subtracting the new mouse
                    // coordinates with the old.
                    double deltaX = event.getSceneX() - m_nMouseX;
                    double deltaY = event.getSceneY() - m_nMouseY;

                    // add the delta coordinates to the node coordinates.
                    m_nX += deltaX;
                    m_nY += deltaY;

                    // set the layout for the draggable node.
                    c.setLayoutX(m_nX);
                    c.setLayoutY(m_nY);
                    l.setX(event.getSceneX());
                    l.setY(event.getSceneY());

                    // get the latest mouse coordinate.
                    m_nMouseX = event.getSceneX();
                    m_nMouseY = event.getSceneY();
                }
            }
        };
        return dragHandler;
    }
   
   EventHandler<MouseEvent> dragMouseFinal(Circle c, LineTo l1, LineTo l2) {
        EventHandler<MouseEvent> dragHandler = new EventHandler<MouseEvent>() {

            public void handle(MouseEvent event) {
                if (event.getButton() == MouseButton.PRIMARY) {
                    // find the delta coordinates by subtracting the new mouse
                    // coordinates with the old.
                    double deltaX = event.getSceneX() - m_nMouseX;
                    double deltaY = event.getSceneY() - m_nMouseY;

                    // add the delta coordinates to the node coordinates.
                    m_nX += deltaX;
                    m_nY += deltaY;

                    // set the layout for the draggable node.
                    c.setLayoutX(m_nX);
                    c.setLayoutY(m_nY);
                    l1.setX(event.getSceneX());
                    l1.setY(event.getSceneY());
                    l2.setX(event.getSceneX());
                    l2.setY(event.getSceneY());

                    // get the latest mouse coordinate.
                    m_nMouseX = event.getSceneX();
                    m_nMouseY = event.getSceneY();
                }
            }
        };
        return dragHandler;
    }
   
}  