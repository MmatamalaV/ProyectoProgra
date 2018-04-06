/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ProgramacionNumeros;

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
public class Numero1 {
    double m_nX = 0;
    double m_nY = 0;
    double m_nMouseX = 0;
    double m_nMouseY = 0;
    Group circle=new Group();
    double marco;
    double espacio;
    double superior;
    
    public Numero1(double marco, double espacio, double superior) {
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
    
    public Group start(Path path){
        path.setStrokeWidth(4);
        
        Group root= new Group(path,circle);
        
        MoveTo p1=new MoveTo(200+espacio,200+superior);
        LineTo p2= new LineTo(200+espacio,100+superior);
        LineTo p3= new LineTo(150+espacio,150+superior);
        
        Circle c1 = new Circle();
        c1.setCenterX(p1.getX());
        c1.setCenterY(p1.getY()+marco);
        c1.setRadius(5.0);
        c1.setCache(true);
        c1.setStroke(Color.RED);
        c1.setFill(Color.GREENYELLOW);
        c1.setStrokeWidth(3);
        c1.setOnMousePressed(pressMouse(c1));
        c1.setOnMouseDragged(dragMouseInicial(c1, p1));
        
        Circle c2 = new Circle();
        c2.setCenterX(p2.getX());
        c2.setCenterY(p2.getY()+marco);
        c2.setRadius(5.0);
        c2.setCache(true);
        c2.setStroke(Color.RED);
        c2.setFill(Color.GREENYELLOW);
        c2.setStrokeWidth(3);
        c2.setOnMousePressed(pressMouse(c2));
        c2.setOnMouseDragged(dragMouse(c2, p2));
    
        Circle c3 = new Circle();
        c3.setCenterX(p3.getX());
        c3.setCenterY(p3.getY()+marco);
        c3.setRadius(5.0);
        c3.setCache(true);
        c3.setStroke(Color.RED);
        c3.setFill(Color.GREENYELLOW);
        c3.setStrokeWidth(3);
        c3.setOnMousePressed(pressMouse(c3));
        c3.setOnMouseDragged(dragMouse(c3, p3));
    
    
    
        circle.getChildren().addAll(c1,c2,c3);
        path.getElements().addAll(p1,p2,p3);
        return root;
        
    }
}
