/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package neongolf;

import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.Timer;
import java.util.TimerTask;
import javax.swing.JPanel;

/**
 *
 * @author 805619
 */
public class World extends JPanel {
    private Timer timer;
    private MainMenu mainMenu;
    private int strokes;
    private BackButton backButton;
    private ExitButton exitButton;
    private StartButton startButton;
    private BlueSelectButton blueselectbutton;
    private OrangeSelectButton orangeselectbutton;
    private PlayerSelectScreen playerselectscreen;
    private HoleScreen holeScreen;
    private OrangeBall orangeBall;
    private BlueBall blueBall;
    private int width = 1440;
    private int height = 900;
    private boolean main = true;
    private boolean select = false;
    private boolean hole = false;
    private boolean winScreen = false;
    private boolean colorBlue = true;
    
    
    public World() {
        super();
        timer = new Timer();
        timer.scheduleAtFixedRate(new ScheduleTask(), 100, 1000/12);
        mainMenu = new MainMenu(width, height);
        startButton = new StartButton (800,600);
        exitButton = new ExitButton (800,600);
        backButton = new BackButton (800,600);
        blueselectbutton = new BlueSelectButton (800,600);
        orangeselectbutton = new OrangeSelectButton(800,600);
        orangeBall = new OrangeBall (800,600);
        blueBall = new BlueBall (800,600);
        playerselectscreen = new PlayerSelectScreen(width,height);
        holeScreen = new HoleScreen(width,height);
    }
    
    @Override
    public void paintComponent(Graphics g) {
        if (main == true) {
            mainMenu.draw(g);
            startButton.draw(g);
            exitButton.draw(g);
        }
        else if (main == false && select == true){
            playerselectscreen.draw(g);
            blueselectbutton.draw(g);
            orangeselectbutton.draw(g); 
            backButton.draw(g);
        }
        else if (hole == true && main == false && select == false) {
            holeScreen.draw(g);
            backButton.draw(g);
            if (colorBlue == true) {
                blueBall.draw(g);
            }
            else if (colorBlue == false) {
                orangeBall.draw(g);
            }
        }
        else {
        
        }
    }
    
    public void keyReleased(KeyEvent e) {
        if (e.getKeyCode() == KeyEvent.VK_SPACE) {
            System.out.println("Spacebar pressed"); 
        }  
    }
    
    void mousePressed(MouseEvent e) {
        if (main == true) {
            if ( e.getX() > 300 && e.getX() < 600 && e.getY() > 300 && e.getY() < 650) {
            main = false;
            select = true;
            }
            else if ( e.getX() > 800 && e.getX() < 1070 && e.getY() > 310 && e.getY() < 510) {
            System.exit(0);    
            }
        }
        else if (main == false && select == true){ 
                if ( e.getX() > 300 && e.getX() < 600 && e.getY() > 350 && e.getY() < 650) {
            colorBlue = true;
            select = false;
            hole = true;
            }
            else if ( e.getX() > 0 && e.getX() < 80 && e.getY() > 0 && e.getY() < 80) {
                select = false;
                main = true;
            }    
            else if ( e.getX() > 850 && e.getX() < 1150 && e.getY() > 350 && e.getY() < 650) {
            colorBlue = false;
            select = false;
            hole = true;
            }
            }
        else if (hole == true && main == false && select == false){
           if ( e.getX() > 0 && e.getX() < 80 && e.getY() > 0 && e.getY() < 80) {
                select = true;
                hole = false;
            }  
        }
        else {
                
        }
        }
    
    
    private class ScheduleTask extends TimerTask {

        @Override
        public void run() {         
            repaint();
        }
    }
}
