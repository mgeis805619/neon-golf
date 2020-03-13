/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package neongolf;

import java.awt.Color;
import java.awt.Rectangle;

/**
 *
 * @author 805619
 */
public class Wall {
    private Rectangle bounds;
    private Color color;
    private int x,y, width,height;
    
   public Wall (int cx, int cy, int cwidth, int cheight, Color color){
    this.x = cx * 40;
    this.y = cy * 40;
    this.width = cwidth;
    this.height = cheight;
    this.color = color;
    this.bounds = new Rectangle (this.x,this.y, this.width, this.height);

}
}
