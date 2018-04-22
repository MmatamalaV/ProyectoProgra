/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package PuntosDeControlYMovimiento;

import javafx.scene.paint.Color;
import javafx.scene.shape.Arc;

/**
 *
 * @author elias
 */
public class ArcosYLineas extends Lineas{
    //Método para configurar los arcos que recibe.
        protected void configuraArco (Arc arc) {
            arc.setStroke(Color.BLACK);
            arc.setFill(null);
            arc.setStrokeWidth(4);
        }
}
