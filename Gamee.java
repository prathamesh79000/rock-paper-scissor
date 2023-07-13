package com.company;
import javax.swing.JFrame;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Color;
import java.awt.Image;
import java.awt.event.MouseListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseAdapter;
import java.awt.*;

class Gamee extends JFrame{
//create label for ComputerChoice and for result
    JLabel computerChoice,result;
//create label for displaying score
    JLabel computerScore,PlayerScore;
    int player_score = 0, computer_score =0;
    ImageIcon image_rock, image_paper, image_scissor;
    public void setup(){
        image_rock =  new ImageIcon(new ImageIcon("/Users/prathameshjadhav/Downloads/rock.png").getImage()
                      .getScaledInstance(80,80,Image.SCALE_DEFAULT));
        image_paper = new ImageIcon(new ImageIcon("/Users/prathameshjadhav/Downloads/paper.png").getImage()
                      .getScaledInstance(80,80,Image.SCALE_DEFAULT));
        image_scissor = new ImageIcon(new ImageIcon("/Users/prathameshjadhav/Downloads/scissor.png").getImage()
                        .getScaledInstance(80,80,Image.SCALE_DEFAULT));

        //create label
        JLabel score = new JLabel("Score");
        score.setBounds(500,0,100,100);

        computerScore = new JLabel();
        computerScore.setText("Computer :: 0");
        computerScore.setBounds(500,15,100,100);

        PlayerScore = new JLabel();
        PlayerScore.setText("Player :: 0");
        PlayerScore.setBounds(500,30,100,100);


        computerChoice = new JLabel();
        computerChoice.setHorizontalTextPosition(JLabel.CENTER);
        computerChoice.setVerticalTextPosition(JLabel.BOTTOM);
        computerChoice.setBounds(250,90,100,100);

        result = new JLabel();
        result.setFont(new Font("Serif",Font.BOLD,20));
        result.setBounds(250,450,100,100);

        JLabel label_computer = new JLabel();
        label_computer.setText("Computer");
        label_computer.setBounds(260,180,100,100);

        JLabel label_vs = new JLabel();
        label_vs.setText("VS");
        label_vs.setBounds(280,200,100,100);

        JLabel label_player = new JLabel();
        label_player.setText("Player");
        label_player.setBounds(270,220,100,100);


        JLabel label_rock = new JLabel();
        label_rock.setText("Rock");
        label_rock.setIcon(image_rock); //set icon
        label_rock.setHorizontalTextPosition(JLabel.CENTER);
        label_rock.setVerticalTextPosition(JLabel.BOTTOM);
        label_rock.setBounds(150,300,100,100);

        JLabel label_paper = new JLabel();
        label_paper.setText("Paper");
        label_paper.setIcon(image_paper); //set icon
        label_paper.setHorizontalTextPosition(JLabel.CENTER);
        label_paper.setVerticalTextPosition(JLabel.BOTTOM);
        label_paper.setBounds(250,300,100,100);

        JLabel label_scissor = new JLabel();
        label_scissor.setText("Scissor");
        label_scissor.setIcon(image_scissor); //set icon
        label_scissor.setHorizontalTextPosition(JLabel.CENTER);
        label_scissor.setVerticalTextPosition(JLabel.BOTTOM);
        label_scissor.setBounds(350,300,100,100);

        //add mouse listener to labels
        label_rock.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent e){
                //call calculate method
                calculate(label_rock.getText());
            }
        });
        label_paper.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent e){
                //call calculate method
                calculate(label_paper.getText());
            }
        });
        label_scissor.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent e){
                //call calculate method
                calculate(label_scissor.getText());
            }
        });

        //add components in frame
        add(label_rock);
        add(label_paper);
        add(label_scissor);
        add(computerChoice);
        add(result);
        add(score);
        add(computerScore);
        add(PlayerScore);
        add(label_computer);
        add(label_vs);
        add(label_player);
        setLayout(null);

    }
    public void calculate(String player){
        String [] list = {"Rock","Paper","Scissor"};
        int random_choice = (int)((Math.random()*10)%3);
        String computer = list[random_choice];

        //display computer choice on frame
        computerChoice.setText(computer);
        if(random_choice==0){
            computerChoice.setIcon(image_rock);
        }
        else if(random_choice==1){
            computerChoice.setIcon(image_paper);
        }
        else{
            computerChoice.setIcon(image_scissor);
        }

        String res = "";
        if(player.equals(computer)){
            res = "DRAW";
        }
        else if(player.equals("Rock")){
            if(computer.equals("Paper")){
                res = "You lose!";
                computer_score++;
            }
            else {
                res = "You Win!";
                player_score++;
            }
        }
        else if(player.equals("Paper")){
            if(computer.equals("Scissor")){
                res = "You lose!";
                computer_score++;
            }
            else {
                res = "You Win!";
                player_score++;
            }
        }
        else{
            if(computer.equals("Rock")){
                res = "You lose!";
                computer_score++;
            }
            else {
                res = "You Win!";
                player_score++;
            }
        }
        result.setText(res);
        PlayerScore.setText("Player :: "+ player_score);
        computerScore.setText("Computer :: "+computer_score);

    }
    public static void main(String[] args) {
        //CREATE FRAME
        Gamee g = new Gamee();
        g.setTitle("ROCK PAPER SCISSOR");
        g.setBounds(200,200,600,600);
        g.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        g.getContentPane().setBackground(Color.LIGHT_GRAY);
        g.setup();
        g.setResizable(false);
        g.setVisible(true);

    }
}
