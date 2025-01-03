package Obj;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.Color;
import java.util.ArrayList;
public class group_obj extends base_obj{
    private ArrayList<object> groupobj=new ArrayList<object>();
    public group_obj(ArrayList<object> arr,Rectangle r){
        groupobj=arr;
        width=r.width;
        height=r.height;
        x=r.x+width/2;
        y=r.y+height/2;
        isGroup=true;
    }
    public void draw(Graphics g){
        g.setColor(new Color(0,255,255,50));
        g.fillRect(x-width/2, y-height/2, width, height);
        g.setColor(Color.black);
        g.drawRect(x - width / 2, y - height / 2, width, height);
        for(int i=0;i<groupobj.size();i++){
            groupobj.get(i).draw(g);
        }
    }
    public void showport(Graphics g){
        for(int i=0;i<groupobj.size();i++){
            groupobj.get(i).showport(g);
        }
    }
    public void relocate(int x1,int y1){
        x+=x1;
        y+=y1;
        for(int i=0;i<groupobj.size();i++){
            groupobj.get(i).relocate(x1,y1);
        }
    }
    public ArrayList<object> get_groupobj(){
        return groupobj;
    }
}
