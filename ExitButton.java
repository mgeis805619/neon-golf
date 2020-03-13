/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package neongolf;

import java.awt.Graphics;
import java.awt.Image;
import javax.swing.ImageIcon;

/**
 *
 * @author 805619
 */
public class ExitButton {
   
    private int height;
    private int width;
    private int x;
    private int y;
    private Image img;
    private ImageIcon ii;
    
     public ExitButton (int cWidth, int cHeight) {
        x = 800;
        y = 310;
        this.height = 270;
        this.width = 200;
        this. ii = new ImageIcon(getClass().getResource("NeonExitButton.png"));
        this.img = ii.getImage();
     }
     
     public void draw(Graphics g) {
           g.drawImage(img, this.x, this.y, this.width, this.height, null);
       }
}
    

