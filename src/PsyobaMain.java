import javax.swing.*;
import java.awt.*;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JLabel;

public class PsyobaMain {
    final static int WIDTH = 10;
    final static int HEIGHT = 10;
    final static int NUM_MINES = 10;

    public static void main(String[] args) {
        new PsyobaMain();

    }

    public PsyobaMain() {
        JFrame guiFrame = new JFrame();


        guiFrame.setLayout(new FlowLayout(FlowLayout.CENTER, 0, 0));

        Board board = new Board(10, 10, 10);



        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 10; j++) {
                board.boardSquareButtons[i][j] = new BoardSquareButton(50, 50, Color.gray, i, j,board);
                guiFrame.add(board.getButton(i, j));
                board.boardSquareButtons[i][j].setup(Color.gray);




            }
        }
        board.createMines(10);
        for (int i = 0; i <10 ; i++) {
            for (int j = 0; j < 10; j++) {
                board.countSurrounding(i,j);
            }

        }
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j <10 ; j++) {


            }

        }






        guiFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        guiFrame.setTitle("Label Demo");
        guiFrame.pack();
        guiFrame.setSize(505, 525);
        guiFrame.setVisible(true);




    }
}


