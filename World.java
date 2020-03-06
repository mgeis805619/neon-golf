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
    private Player player;
    private int width = 1440;
    private int height = 900;
    private boolean main = true;
    private boolean select = false;
    
    
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
        playerselectscreen = new PlayerSelectScreen(width,height);
    }
    
    @Override
    public void paintComponent(Graphics g) {
        if (main == true) {
            mainMenu.draw(g);
            startButton.draw(g);
            exitButton.draw(g);
        }
        else if (main == false && select == true){
            backButton.draw(g);
            blueselectbutton.draw(g);
            orangeselectbutton.draw(g);
            playerselectscreen.draw(g); 
        }
        else {
            backButton.draw(g);
        }
    }
    
    public void keyReleased(KeyEvent e) {
        if (e.getKeyCode() == KeyEvent.VK_SPACE) {
            System.out.println("Spacebar pressed"); 
        }  
    }
    
    void mousePressed(MouseEvent e) {
        if (main == true) {
            if ( e.getX() > 50 && e.getX() < 350 && e.getY() > 250 && e.getY() < 550) {
            main = false;
            select = true;
            }
            else if ( e.getX() > 30 && e.getX() < 330 && e.getY() > 500 && e.getY() < 850) {
            System.exit(0);    
            }
            
            else if (main == false && select == true){
                if ( e.getX() > 50 && e.getX() < 350 && e.getY() > 250 && e.getY() < 550) {
            main = false;
            select = true;
            }
            else if ( e.getX() > 30 && e.getX() < 330 && e.getY() > 500 && e.getY() < 850) {
            System.exit(0);    
            }
            else if ( e.getX() > 30 && e.getX() < 330 && e.getY() > 500 && e.getY() < 850) {
                select = false;
                main = true;
            }    
            }
            else {
            if ( e.getX() > 50 && e.getX() < 350 && e.getY() > 250 && e.getY() < 550) {
            main = true;
            }
            }
        }
    }
    
    private class ScheduleTask extends TimerTask {

        @Override
        public void run() {         
            repaint();
        }
    }
}
