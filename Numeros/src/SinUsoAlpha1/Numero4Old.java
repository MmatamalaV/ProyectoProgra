/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SinUsoAlpha1;

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
 * @author mario
 */
public class Numero4Old {
    double m_nX = 0;
    double m_nY = 0;
    double m_nMouseX = 0;
    double m_nMouseY = 0;
    Group circle=new Group();
    double marco;
    double espacio;
    double superior;
    

    public Numero4Old(double marco, double espacio, double superior) {
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
    
        MoveTo moveTo=new MoveTo(200+espacio, 200+superior);
        LineTo line1 = new LineTo(200+espacio, 100+superior);
        LineTo line2 = new LineTo(150+espacio, 150+superior);
        LineTo line3 = new LineTo(200+espacio, 150+superior);
        LineTo line4 = new LineTo(200+espacio, 150+superior);
        path.setStrokeWidth(4); //grisor de la linea


    //Adding all the elements to the path 
    path.getElements().add(moveTo); 
    path.getElements().addAll(line4,line1, line2, line3);
    
        
        Circle c1 = new Circle();
        createCircle(c1, moveTo.getX(), moveTo.getY()+marco, circle);
        
        Circle c2 = new Circle();
        createCircle(c2, line1.getX(), line1.getY()+marco, circle);

        Circle c3 = new Circle();
        createCircle(c3, line2.getX(), line2.getY()+marco, circle);

        Circle c4 = new Circle();
        createCircle(c4, line3.getX(), line3.getY()+marco, circle);
        
    Group root = new Group(path);
    //circle.getChildren().addAll(c2,c3,c4);
    root.getChildren().addAll(circle);
    
    circle.setVisible(true);
    
    //se toma la posicion del circulo al cl1ckearlo
    c1.setOnMousePressed(pressMouse(c1));
    c1.setOnMouseDragged(dragMouseInicial(c1, moveTo));
    c2.setOnMousePressed(pressMouse(c2));
    c2.setOnMouseDragged(dragMouse(c2, line1));
    c3.setOnMousePressed(pressMouse(c3));
    c3.setOnMouseDragged(dragMouse(c3, line2));
    c4.setOnMousePressed(pressMouse(c4));
    c4.setOnMouseDragged(dragMouseFinal(c4, line3, line4));
      
    
    return root;
    }

    public double getMarco() {
        return marco;
    }

    public void setMarco(double marco) {
        this.marco = marco;
    }
    public void createCircle(Circle circulo, double centerX, double centerY, Group circle) {
        circulo.setCenterX(centerX);
        circulo.setCenterY(centerY);
        circulo.setRadius(5.0);
        circulo.setCache(true);
        circulo.setStroke(Color.RED);
        circulo.setFill(Color.GREENYELLOW);
        circulo.setStrokeWidth(3);
        circle.getChildren().add(circulo);
    }
    
}
