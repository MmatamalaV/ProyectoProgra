/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import javafx.event.EventHandler;
import javafx.scene.Group;
import javafx.scene.input.MouseButton;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.LineTo;
import javafx.scene.shape.MoveTo;
import javafx.scene.shape.Path;

/**
 *
 * @author elias
 */
public class Division {
    double m_nX = 0;
    double m_nY = 0;
    double m_nMouseX = 0;
    double m_nMouseY = 0;
    Group circle=new Group();
    double marco;
    double espacio;
    double superior;
    

    public Division(double marco, double espacio, double superior) {
        this.marco= marco;
        this.espacio=espacio;
        this.superior=superior;
    }
    
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
                 l.setY(event.getSceneY()-marco);

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
                 l.setY(event.getSceneY()-marco);

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
                 l1.setY(event.getSceneY()-marco);
                 l2.setX(event.getSceneX());
                 l2.setY(event.getSceneY()-marco);

                 // get the latest mouse coordinate.
                 m_nMouseX = event.getSceneX();
                 m_nMouseY = event.getSceneY();
             }
         }
     };
     return dragHandler;
    }

    public Group start(Path path) {
        
        double size=1.2;
        double amountOfSymbolsDivide = 1*size; //Variable para cantidad de números que irán en la división
        int xPoint = (int) (200+espacio);
        int yPoint = (int) (150+superior);

        MoveTo startDivide = new MoveTo(xPoint, yPoint);
        LineTo line1Divide = new LineTo(xPoint-33*amountOfSymbolsDivide, yPoint);
        LineTo line2Divide = new LineTo(xPoint+33*amountOfSymbolsDivide, yPoint);

        path.setStrokeWidth(4*size);
    
        path.getElements().addAll(startDivide, line1Divide, startDivide, line2Divide);

        //path.setStrokeWidth(4); //grisor de la linea


        //Adding all the elements to the path 
        //path.getElements().add(moveTo); 
        //path.getElements().addAll(line4,line1, line2, line3);        
        double circleRadius = size*3;
        double circleStrokeWidth = size*4;

        Circle c1Divide = new Circle();
        c1Divide.setCenterX(startDivide.getX());
        c1Divide.setCenterY(startDivide.getY()+marco);
        c1Divide.setRadius(circleRadius);
        c1Divide.setCache(true);
        c1Divide.setStroke(Color.RED);
        c1Divide.setStrokeWidth(circleStrokeWidth);

        Circle c2Divide = new Circle();
        c2Divide.setCenterX(line1Divide.getX());
        c2Divide.setCenterY(line1Divide.getY()+marco);
        c2Divide.setRadius(circleRadius);
        c2Divide.setCache(true);
        c2Divide.setStroke(Color.RED);
        c2Divide.setStrokeWidth(circleStrokeWidth);

        Circle c3Divide = new Circle();
        c3Divide.setCenterX(line2Divide.getX());
        c3Divide.setCenterY(line2Divide.getY()+marco);
        c3Divide.setRadius(circleRadius);
        c3Divide.setCache(true);
        c3Divide.setStroke(Color.RED);
        c3Divide.setStrokeWidth(circleStrokeWidth);

        Group root = new Group(path);
        circle.getChildren().addAll(c1Divide, c2Divide, c3Divide);
        root.getChildren().addAll(circle);

        circle.setVisible(true);

        c1Divide.setOnMousePressed(pressMouse(c1Divide));
        c1Divide.setOnMouseDragged(dragMouseInicial(c1Divide, startDivide));
        c2Divide.setOnMousePressed(pressMouse(c2Divide));
        c2Divide.setOnMouseDragged(dragMouse(c2Divide, line1Divide));
        c3Divide.setOnMousePressed(pressMouse(c3Divide));
        c3Divide.setOnMouseDragged(dragMouse(c3Divide, line2Divide));
    
        return root;
    }

    public double getMarco() {
        return marco;
    }

    public void setMarco(double marco) {
        this.marco = marco;
    }
    
}
