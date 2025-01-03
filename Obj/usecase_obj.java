package Obj;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;

public class usecase_obj extends base_obj{
    
    public usecase_obj(int x,int y){
        objname="usecase_obj";
        width=150;
        height=100;
        this.x=x;
        this.y=y;
        initport();
    }
    public void draw(Graphics g){
        g.setColor(Color.white);
        g.fillOval(x-width/2, y-height/2, width, height);
        g.setColor(Color.black);
		g.drawOval(x - width / 2, y - height / 2, width, height);
        paintString(g,new Rectangle(x-width/2, y-height/2, width, height));
    }
    
}
