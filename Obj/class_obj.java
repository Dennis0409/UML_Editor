package Obj;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;
public class class_obj extends base_obj{
    public class_obj(int x,int y){
        objname="class_obj";
        width=150;
        height=200;
        this.x=x;
        this.y=y;
        initport();
    }
    public void draw(Graphics g){
        g.setColor(Color.white);
        g.fillRect(x-width/2, y-height/2, width, height);
        g.setColor(Color.black);
		g.drawRect(x - width / 2, y - height / 2, width, height);
		g.drawLine(x - width / 2, y - height / 4, x + width / 2, y - height / 4); 
		g.drawLine(x - width / 2, y, x + width / 2, y);
        paintString(g,new Rectangle(x-width/2, y-height/2, width, height/4));
    }
}
