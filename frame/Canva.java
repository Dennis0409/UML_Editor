package frame;
//package project1;

import java.awt.*;
import java.util.ArrayList;

import javax.swing.*;
import Obj.*;
import Mode.Mode;

public class Canva extends JPanel{
    private static Canva canva=null; 
    private Mode canva_mode=null;
    private ArrayList<object> obj_list=new ArrayList<object>();
    public ArrayList<object> select_obj=new ArrayList<object>();
    public Rectangle select_Rectangle=null;

    private Canva(){}
    public static Canva get_canva(){
        if(canva==null) return canva=new Canva();
        else return canva;
    }
    public void set_mode(Mode mode){
        select_obj.clear();
        //System.out.println("set mode");
        removeMouseListener(canva_mode);
        removeMouseMotionListener(canva_mode);
        canva_mode=mode;
        addMouseListener(canva_mode);
        addMouseMotionListener(canva_mode);
    }
    public void addObj(object Object1){
        obj_list.add(Object1);
        //System.out.println("add");
    }
    public void paintComponent(Graphics g){
        super.paintComponent(g);
        for(int i=0;i<obj_list.size();i++){
            obj_list.get(i).draw(g);
            if(select_obj!=null){
                for(int j=0;j<select_obj.size();j++){
                    if(select_obj.get(j)==obj_list.get(i)) select_obj.get(j).showport(g);
                }
            }
            
        }
        if(select_Rectangle!=null){
            //System.out.println("rectangle");
            g.setColor(new Color(255,175,175,45));
            g.fillRect(select_Rectangle.x, select_Rectangle.y, select_Rectangle.width, select_Rectangle.height);
            g.setColor(Color.black);
            g.drawRect(select_Rectangle.x, select_Rectangle.y, select_Rectangle.width, select_Rectangle.height);
        }
    }
    public ArrayList<object> getobject(Point p){
        ArrayList<object> ret=new ArrayList<object>();
        for(int i=obj_list.size()-1;i>=0;i--){
            if(obj_list.get(i).isInside(p)){
                ret.add(obj_list.get(i));
            }
        }
        return ret;
    }
    public ArrayList<object> getobject_rectangle(Rectangle r){
        ArrayList<object> ret=new ArrayList<object>();
        for(int i=0;i<obj_list.size();i++){
            int count=0;
            for(Point p:obj_list.get(i).getpoints()){
                if(r.contains(p)){
                    count++;
                }
            }
            if(count==2) ret.add(obj_list.get(i));
        }
        return ret;
    }
    public void set_select(object obj){
        select_obj.add(obj);
    }
    public ArrayList<object> get_obj_list(){
        return obj_list;
    }
    public Rectangle get_select_Rectangle(){
        return select_Rectangle;
    }
    public void group_obj(){
        if(select_Rectangle==null) return ;
        ArrayList<object> ret=getobject_rectangle(select_Rectangle);
        if(ret.size()>1){
            addObj(new group_obj(ret,select_Rectangle));
            for(int i=0;i<ret.size();i++){
                obj_list.remove(ret.get(i));
            }
        }
        select_Rectangle=null;
        repaint();
    }
    public void ungroup_obj(){
        if(select_obj.size()!=0 && select_obj.get(0).get_isGroup()){
            group_obj temp=(group_obj) select_obj.get(0);
            for(int i=0;i<temp.get_groupobj().size();i++){
                obj_list.add(temp.get_groupobj().get(i));
            }
            obj_list.remove(select_obj.get(0));
            select_obj.clear();
            repaint();
        }
    }
    public void change_name(){
        if(select_obj.size()==1&&!select_obj.get(0).get_isGroup()){
            String objName = JOptionPane.showInputDialog("change name");
            if(objName==null) return ;
            base_obj obj=(base_obj)select_obj.get(0);
            obj.changename(objName);
            repaint();
        }
    }
    public void remove_obj(){
        if(select_obj.size()==1 && !select_obj.get(0).get_isGroup()){
            ArrayList<object> temp=new ArrayList<object>();
            //obj_list.remove(select_obj);
            for(int i=0;i<obj_list.size();i++){
                if(select_obj.get(0)!=obj_list.get(i) && obj_list.get(i).get_isLine()){
                    port from=((base_line)obj_list.get(i)).get_from_to()[0];
                    port to=((base_line)obj_list.get(i)).get_from_to()[1];
                    port[] p=((base_obj)select_obj.get(0)).getports();
                    for(int j=0;j<4;j++){
                        if(from==p[j] || to==p[j]){
                            temp.add(obj_list.get(i));
                            break;
                        }
                    }
                }
            }
            temp.add(select_obj.get(0));
            for(int i=0;i<temp.size();i++){
                obj_list.remove(temp.get(i));
            }
            //obj_list.remove(select_obj);
            select_obj.clear();
            repaint();
        }
    }
    public void clear_obj(){
        select_obj.clear();
        obj_list.clear();
        repaint();
    }
    
}

