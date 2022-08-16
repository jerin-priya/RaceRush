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

    public void createFrame(){
        frame=new JFrame("CarGame");
        frame.setSize(400,500);
        frame.setLayout(null);
        panel = new JPanel();
        panel.setLayout(null);
        panel.setBounds(0,0,300,470);
        panel.setBackground(Color.GRAY);
        Score.setBounds(80,0,100,40);
        Cars.setBounds(240,0,100,40);
        panel.add(Cars);
        cars[0]=new JButton("Easy");
        cars[0].setBounds(0,0,80,465);
        cars[0].setBackground(Color.GREEN);
        cars[0].setBorder(null);
        cars[0].setFocusable(false);
        cars[1]=new JButton(car);
        cars[1].setBounds(PCAR_XBOUND,PCAR_YBOUND,CAR_SIZEX,CAR_SIZEY);
        cars[1].setBackground(Color.YELLOW);
        cars[1].setBorder(null);
        panel.add(cars[1]);
        panel.add(cars[0]);
        panel2=new JPanel();
        panel2.setLayout(null);
        panel2.setBounds(300,0,95,470);
        panel2.setBackground(Color.GREEN);
        frame.add(panel2);
        lines[0]= new JButton();
        lines[0].setEnabled(false);
        lines[0].setBounds(145,0,5,465);
        lines[0].setBackground(Color.WHITE);
        panel.add(lines[0]);
        lines[1]= new JButton();
        lines[1].setEnabled(false);
        lines[1].setBounds(225,0,5,465);
        lines[1].setBackground(Color.WHITE);
        panel.add(lines[1]);
        panel.add(Score);
        createMenuBar();
        cars[1].addKeyListener(new KeyAdapter(){
            public void keyPressed(KeyEvent e){
                pressEvent(e);
            }
        });
        frame.setResizable(false);
        frame.getContentPane().add(panel);
        frame.setVisible(true);
        frame.setLocationRelativeTo(Null);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    public void createMenuBar(){
        JMenuBar menu = new JMenuBar();
        JMenu file = new JMenu("Game");
        JMenuItem exit = new JMenuItem("exit");
        JMenuItem newgame = new JMenuItem("New Game");
        newgame.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                NEWGAME=true;
            }
        });
        exit.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                System.exit(0);
            }
        });
        file.add(newgame);
        file.add(exit);
        menu.add(file);
        JMenu difficulty = new JMenu("Difficulty");
        JMenuItem easy = new JMenuItem("Easy");
        JMenuItem normal = new JMenuItem("Normal");
        JMenuItem hard = new JMenuItem("Hard");
        JMenuItem veryhard = new JMenuItem("Very Hard");
        easy.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                VHARD=false;
                GAME_LEVEL = 300;
                cars[0].setText("Easy");
                panel.add(cars[0]);
                score=0;
            }
        });
        normal.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                VHARD=false;
                GAME_LEVEL = 500;
                cars[0].setText("Normal");
                panel.add(cars[0]);
                score=0;
            }
        });
        hard.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                VHARD=false;
                GAME_LEVEL = 1000;
                cars[0].setText("Hard");
                panel.add(cars[0]);
                score=0;
            }
        });
        veryhard.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                GAME_LEVEL = 1000;
                cars[0].setText("Very Hard");
                panel.add(cars[0]);
                score = 0;
                k=1;
                VHARD=true;
            }
        });

        difficulty.add(easy);
        difficulty.add(normal);
        difficulty.add(hard);
        difficulty.add(veryhard);
        menu.add(difficulty);
        JMenu help = new JMenu("Help");
        JMenuItem about = new JMenuItem("About");
        about.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                JOptionPane.showMessageDialog(null,"Author - Jerin Hasan Priya\nArnab Sen Antu");
            }
        });
        JMenuItem instruction = new JMenuItem("Instructions");
        instruction.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                JOptionPane.showMessageDialog(null,"INSTRUCTIONS:\n* Use arrow keys to move the car Left,Right,Up and down\n * Use SpaceBar to pause and continue race");
            }
        });

        help.add(about);
        help.add(instruction);
        menu.add(help);
        frame.setJMenuBar(menu);
    }
}
