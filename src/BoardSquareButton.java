import javax.swing.*;
import java.awt.*;
import java.io.InputStream;

public class BoardSquareButton extends JButton{
        int x;
        int y;
        boolean Mine;
        boolean Investigated;
        boolean PotentialMine;
    public BoardSquareButton(int width, int height, Color color){
        setMinimumSize(new Dimension(15,15));
        setPreferredSize(new Dimension(50,50));

    }

    @Override
    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY(){
        return y;
    }

    public void setY(){
        this.y = y;
    }

    public boolean getMine(){
        return Mine;
    }

    public void setMine(){
        this.Mine = Mine;
    }
    public boolean getInvestigated(){
        return Investigated;
    }

    public void setInvestigated(){
        this.Investigated = Investigated;
    }
    public boolean getPotentialMine(){
        return PotentialMine;
    }

    public void setPotentialMine(){
        this.PotentialMine = PotentialMine;
    }






    public void setup(Color color){
        setFont(new Font("Helvetica", Font.PLAIN, 30));
        if (color != null){
            setBackground(color);
        }else{
            setBackground(Color.gray);
        }
        Investigated = false;
        Mine = false;
        PotentialMine = false;




    }



}
