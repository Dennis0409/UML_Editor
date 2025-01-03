package Obj;
import java.awt.Color;
import java.awt.Graphics;

public class port extends object{
    private int size;
    public port(){
        size=10;
    }
    public port(int x,int y){
        this.x=x;
        this.y=y;
        size=10;
    }
    public void draw(Graphics g){
        g.setColor(Color.black);
        g.fillRect(x-size/2, y-size/2, size, size);
    }
    public int getsize(){
        return size;
    }
    public void relocate(int x1,int y1){
        x+=x1;
        y+=y1;
    }
    public void setport(int x1,int y1){
        x=x1;
        y=y1;
    }
}
