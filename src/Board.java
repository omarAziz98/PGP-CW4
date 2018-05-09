import java.awt.*;
import javax.swing.*;
import java.util.Random;

public class Board {
    int width = 10;
    int height = 10;
    BoardSquareButton[][] boardSquareButtons;


    public Board(int width, int height, final int NUM_MINES){
        boardSquareButtons = new BoardSquareButton[10][10];



    }
    public BoardSquareButton getButton(int x, int y){

        return boardSquareButtons[x][y];

    }



    public void createMines(final int NUM_MINES){
        Random rand = new Random();


        for (int i = 0; i < 11 ; i++) {
            int x = rand.nextInt(9);
            int y = rand.nextInt(9);
            boardSquareButtons[x][y].mine = true;
            boardSquareButtons[x][y].setText("M");



        }
    }




    public int countSurrounding(int x, int y) {
        int mines = 0;

        for (int i = Math.max(x -1,0); i < Math.min(x +2, width) ; i++) {
            for (int j = Math.max(y -1,0);  j <Math.min(y +2, height); j++) {
                if (boardSquareButtons[i][j].mine){
                    mines++;
                }
            }
        }
        return mines;
    }
}
