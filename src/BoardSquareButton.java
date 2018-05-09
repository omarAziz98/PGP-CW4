import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.InputStream;


public class BoardSquareButton extends JButton {
    boolean mine = false;
    boolean investigated = false;
    boolean potentialMine = false;
    Board board;
    int bX, bY;

    public BoardSquareButton(int width, int height, Color color, int x, int y, Board board) {
        bX = x;
        bY = y;
        setMinimumSize(new Dimension(15, 15));
        setPreferredSize(new Dimension(width, height));
        this.board = board;

        addMouseListener(new MouseAdapter() {
                             @Override
                             public void mouseClicked(MouseEvent e) {
                                 if ((e.getButton() == MouseEvent.BUTTON3) && (potentialMine == false)) {
                                     potentialMine = true;
                                     board.boardSquareButtons[bX][bY].setText("F");
                                     board.boardSquareButtons[bX][bY].setBackground(Color.ORANGE);
                                 }else if ((e.getButton() == MouseEvent.BUTTON3) && (potentialMine == true)){
                                     potentialMine = false;
                                     board.boardSquareButtons[bX][bY].setText("?");
                                     board.boardSquareButtons[bX][bY].setBackground(Color.gray);
                                 }
                             }
                         });

                addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {

                        if (mine) {
                            setText("M");
                            setBackground(Color.RED);
                            for (int i = 0; i < 10; i++) {
                                for (int j = 0; j < 10; j++) {
                                    if (board.boardSquareButtons[i][j].mine) {
                                        board.boardSquareButtons[i][j].setText("M");
                                        board.boardSquareButtons[i][j].setBackground(Color.RED);


                                    }

                                }

                            }
                            JOptionPane.showMessageDialog(null, "Game Over");
                            new PsyobaMain();

                        }
                        if ((!mine) && (board.countSurrounding(bX, bY) > 0) && (!investigated)) {
                            setBackground(Color.GREEN);
                            setText(board.countSurrounding(bX, bY) + "");
                        }
                        else if ((!mine) && (board.countSurrounding(bX, bY) == 0) && (!investigated)) {
                            recursiveShow();
                        }
                        investigated=true;
                        boolean hasWon = true;
                        for (int i = 0; i < 10; i++) {
                            for (int j = 0; j < 10; j++) {
                                if ((!board.boardSquareButtons[i][j].investigated) &&(!board.boardSquareButtons[i][j].mine)) {
                                    hasWon = false;

                                }

                            }

                        }

                        if (hasWon){
                            JOptionPane.showMessageDialog(null, "You Won");
                            new PsyobaMain();
                        }


                    }

                });

    }

    public void recursiveShow(){
        if ((!mine)  && (!investigated) ) {
            setBackground(Color.GREEN);
            setText(board.countSurrounding(bX, bY) + "");
            investigated=true;
            for (int i = Math.max(bX - 1, 0); i < Math.min(bX + 2, board.width); i++) {
                for (int j = Math.max(bY - 1, 0); j < Math.min(bY + 2, board.height); j++) {
                    if (!board.boardSquareButtons[i][j].mine) {
                        board.boardSquareButtons[i][j].setText(board.countSurrounding(i, j) + "");
                        if(board.countSurrounding(i, j)==0){
                            board.boardSquareButtons[i][j].recursiveShow();
                        }else{
                            board.boardSquareButtons[i][j].investigated=true;
                        }


                    }


                }

            }
        }

    }

    public boolean getMine() {
        return mine;
    }

    public void setMine() {
        this.mine = mine;
    }

    public boolean getInvestigated() {
        return investigated;
    }

    public void setInvestigated() {
        this.investigated = investigated;
    }

    public boolean getPotentialMine() {
        return potentialMine;
    }

    public void setPotentialMine() {
        this.potentialMine = potentialMine;
    }


    public void setup(Color color) {
        setFont(new Font("Helvetica", Font.PLAIN, 30));
        setText("?");
        if (color != null) {
            setBackground(color);
        } else {
            setBackground(Color.gray);
        }
        investigated = false;
        mine = false;
        potentialMine = false;


    }


}
