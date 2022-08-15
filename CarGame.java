import java.util.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.lang.Object;

public class CarGame {
    public static void main(String args[]){
        new Racing();
    }
}

class Racing{
    boolean NEWGAME=false;
    boolean PAUSE=false;
    boolean VHARD=false;
    int CAR_COUNT=0;
    int score=0,k=0;
    int CAR_SIZEX=32;
    int CAR_SIZEY=63;
    Random random = new Random();
    int GAME_LEVEL=300;
    int PCAR_XBOUND=170;
    int PCAR_YBOUND=375;
    boolean IS_GAME_OVER=false;
    boolean LEFT_END,RIGHT_END;
    JLabel paused =new JLabel("Paused");
    JFrame frame;
    JPanel panel,panel2;
    JButton[] lines = new JButton[2];
    JButton[] cars = new JButton[10];
    JLabel Score = new JLabel("Score:"+score);
    JLabel Cars = new JLabel("Cars:"+CAR_COUNT);
    ImageIcon car = new ImageIcon("car1.jpg","Player Car");
    ImageIcon car1 = new ImageIcon("car2.jpg","opp Car");

    public Racing(){
        createFrame();
        createGame();
    }
}
