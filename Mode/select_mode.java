package Mode;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import Obj.*;
import frame.Canva;
import java.awt.Point;
import java.awt.Rectangle;
public class select_mode extends Mode{
    private Point prevpoint;
    public void mousePressed(MouseEvent e){
        //System.out.println("select click");
        prevpoint=e.getPoint();
        if(canva.getobject(prevpoint).size()!=0){
            if(canva.select_obj.size()!=0){
                //System.out.println(canva.select_obj.size());
                canva.select_obj.clear();
                //System.out.println("clear "+canva.select_obj.size());
            }
                
            canva.set_select(canva.getobject(prevpoint).get(0));
            canva.select_Rectangle=null;
            
        }else{
            if(canva.select_obj!=null)
                canva.select_obj.clear();
            canva.select_Rectangle=new Rectangle();
        }
        canva.repaint();
    }
    public void mouseDragged(MouseEvent e){
        if(canva.select_obj!=null){
            if(canva.select_obj.size()!=0){
                //System.out.println("relocating");
                canva.select_obj.get(0).relocate(e.getX()-prevpoint.x,e.getY()-prevpoint.y);
                canva.repaint();
                prevpoint.x=e.getX();
                prevpoint.y=e.getY();
            }else{
                //System.out.println("select obj null");
                int x1=Math.min(prevpoint.x,e.getX());
                int y1=Math.min(prevpoint.y,e.getY());
                canva.select_Rectangle.setBounds(x1, y1, Math.abs(prevpoint.x-e.getX()),Math.abs(prevpoint.y-e.getY()));
                canva.repaint();
            }
        }
    }
    public void mouseReleased(MouseEvent e){
        //System.out.println("release");
        if(canva.select_Rectangle!=null){
            ArrayList<object>ret=canva.getobject_rectangle(canva.select_Rectangle);
            if(ret.size()<2){
                canva.select_Rectangle=null;
            }else{
                for(int i=0;i<ret.size();i++){
                    canva.set_select(ret.get(i));
                }
            }
            canva.repaint();
        }
        
        //System.out.println("release if out");
    }
}
