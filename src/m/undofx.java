package m;

import java.util.ArrayList;
import java.util.List;

import javafx.event.EventHandler;
import javafx.scene.Group;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Color;
import javafx.scene.shape.CubicCurve;
import javafx.scene.shape.Line;
import m.M.Anchor;
import m.M.Anchor1;
import m.M.Bool;
import m.M.BoundLine;
import m.M.Point;
import m.M.bezier;

public class undofx extends M {
	class struct{
		double x;
		double y;
		String chaine;
		public struct() {
			x=0;
			y=0;
			chaine=null;
			
		}
	}
private struct choix[]= new struct[10000];
private int yyy=0;
public undofx() {
	for (int uu=0;uu<10000;uu++) {
		choix[uu]=new struct();
	}
}
public void setChoix(String cha) {
	
	choix[yyy].chaine=cha;
	
}
public String getChoic() {
	
	return choix[yyy].chaine;
	
}
public void setX_Y(double a,double b) {
	choix[yyy].x=a;
	choix[yyy].y=b;
}

public void supp(Openfile xx) {
	 Point C =new Point();
      
     	   bool.i=-1;
     	   if (xx.getK().getList().size()==0) {
     		   xx.setK(xx.getLL().getLast());
     		   xx.getLL().removeLast();
     		  if ( xx.getGroup().getChildren().size()==2) xx.getGroup().getChildren().remove(1);
         	  else { 
         	  
         	  if (xx.getK().getList().size()==1) {
         		   xx.getK().getList().clear();
         		  xx.getGroup().getChildren().remove(2, xx.getGroup().getChildren().size());
         	   }
         	   else {
         		  
           		 C.set(choix[yyy].x,choix[yyy].y);
           		 bool.i=rechrch0(xx.getK().getList(),C) ;
           		if (bool.i!=-1) {
           			System.out.println((bool.i+" "+xx.getK().getList().size()));
           			if(bool.i==xx.getK().getList().size()-1) {
           				xx.getK().getList().removeLast();
           				
           				
           			}else {
           		
           				bezier c1=xx.getK().getList().get(bool.i);
    	                		 bezier c2 ;
    	                		 if (bool.i+1==xx.getK().getList().size()) c2=xx.getK().getList().get(0);
    	                		 else c2=xx.getK().getList().get(bool.i+1);
    	                		 bezier c = new bezier(c1.getStartX(),c1.getStartY(), c2.getEndX(),c2.getEndY()) ;
    	                		 c.setControlX1(c1.getControlX1());
    	                		 c.setControlY1(c1.getControlY1());
    	                		 c.setControlX2(c2.getControlX2());
    	                		 c.setControlY2(c2.getControlY2());
    	                		 xx.getK().getList().add(bool.i,c) ;
    	                		 xx.getK().getList().remove(c1) ;
    	                		 xx.getK().getList().remove(c2);
    	                		
    	                		
           			}
           			
               		if (xx.getLL().size()!=0)Draw(xx.getLL(),xx.getGroup(),xx.getRelier()) ;
               		else xx.getGroup().getChildren().remove(1, xx.getGroup().getChildren().size());
               		Draw1(xx.getK().getList() ,xx.getGroup(),xx.getRelier()) ;
               		if(!xx.getRelier().get())xx.getB().set(xx.getK().getList().getLast().getEndX(), xx.getK().getList().getLast().getEndY());
               		else xx.getB().set(0,0);
           		
           		}else {
                    		if((xx.getK().getList().getFirst().getStartX()==C.getX())&&(xx.getK().getList().getFirst().getStartY()==C.getY())) {
                    			xx.getK().getList().removeFirst();
                    			if (xx.getLL().size()!=0) Draw( xx.getLL(),xx.getGroup(),xx.getRelier()) ;
    	                	    else xx.getGroup().getChildren().remove(1, xx.getGroup().getChildren().size()); 
    	                		Draw1(xx.getK().getList() ,xx.getGroup(),xx.getRelier()) ;
    	                		if(!xx.getRelier().get())xx.getB().set(xx.getK().getList().getLast().getEndX(), xx.getK().getList().getLast().getEndY());
    	                		else xx.getB().set(0,0);
                      			
                    		}}}
         	  }
     	   }else {
     	  if ( xx.getGroup().getChildren().size()==2) xx.getGroup().getChildren().remove(1);
     	  else { 
     	  
     	  if (xx.getK().getList().size()==1) {
     		   xx.getK().getList().clear();
     		  xx.getGroup().getChildren().remove(2, xx.getGroup().getChildren().size());
     	   }
     	   else {
     		  
       		 C.set(choix[yyy].x,choix[yyy].y);
       		 bool.i=rechrch0(xx.getK().getList(),C) ;
       		if (bool.i!=-1) {
       			System.out.println((bool.i+" "+xx.getK().getList().size()));
       			if(bool.i==xx.getK().getList().size()-1) {
       				xx.getK().getList().removeLast();
       				
       				
       			}else {
       		
       				bezier c1=xx.getK().getList().get(bool.i);
	                		 bezier c2 ;
	                		 if (bool.i+1==xx.getK().getList().size()) c2=xx.getK().getList().get(0);
	                		 else c2=xx.getK().getList().get(bool.i+1);
	                		 bezier c = new bezier(c1.getStartX(),c1.getStartY(), c2.getEndX(),c2.getEndY()) ;
	                		 c.setControlX1(c1.getControlX1());
	                		 c.setControlY1(c1.getControlY1());
	                		 c.setControlX2(c2.getControlX2());
	                		 c.setControlY2(c2.getControlY2());
	                		 xx.getK().getList().add(bool.i,c) ;
	                		 xx.getK().getList().remove(c1) ;
	                		 xx.getK().getList().remove(c2);
	                		
	                		
       			}
       			
           		if (xx.getLL().size()!=0)Draw(xx.getLL(),xx.getGroup(),xx.getRelier()) ;
           		else xx.getGroup().getChildren().remove(1, xx.getGroup().getChildren().size());
           		Draw1(xx.getK().getList() ,xx.getGroup(),xx.getRelier()) ;
           		if(!xx.getRelier().get())xx.getB().set(xx.getK().getList().getLast().getEndX(), xx.getK().getList().getLast().getEndY());
           		else xx.getB().set(0,0);
       		
       		}else {
                		if((xx.getK().getList().getFirst().getStartX()==C.getX())&&(xx.getK().getList().getFirst().getStartY()==C.getY())) {
                			xx.getK().getList().removeFirst();
                			if (xx.getLL().size()!=0) Draw( xx.getLL(),xx.getGroup(),xx.getRelier()) ;
	                	    else xx.getGroup().getChildren().remove(1, xx.getGroup().getChildren().size()); 
	                		Draw1(xx.getK().getList() ,xx.getGroup(),xx.getRelier()) ;
	                		if(!xx.getRelier().get())xx.getB().set(xx.getK().getList().getLast().getEndX(), xx.getK().getList().getLast().getEndY());
	                		else xx.getB().set(0,0);
                  			
                		}}}
     	  }
     	   }
}

public void pint(Openfile xx) {
	xx.getA().set(choix[yyy].x,choix[yyy].y);
	if((xx.getB().getX()==0)&&(xx.getB().getY()==0))  System.out.print("cvbn,fdgbnfd\n");
	bezier curve=new bezier(xx.getB(),xx.getA()) ;
      Line controlLine1 = new BoundLine(curve.controlX1Property(), curve.controlY1Property(), curve.startXProperty(), curve.startYProperty());
      Line controlLine2 = new BoundLine(curve.controlX2Property(), curve.controlY2Property(), curve.endXProperty(),   curve.endYProperty());
      Anchor control1 = new Anchor(Color.RED,      curve.controlX1Property(), curve.controlY1Property());
      Anchor control2 = new Anchor(Color.RED, curve.controlX2Property(), curve.controlY2Property());
      Anchor1 end= new Anchor1(curve.endXProperty(),      curve.endYProperty());
      xx.getGroup().getChildren().add(end) ;
 
 if ((xx.getB().getX()!=0)&&(xx.getB().getY()!=0)) {
	 xx.getK().getList().add(curve);

	 xx.getGroup().getChildren().addAll( controlLine1, controlLine2, curve, control1, control2);
 }
     xx.getB().set(xx.getA().getX(),xx.getA().getY());
        
}
public void ajout(Openfile xx) {
	
}
public void zoumIn(Openfile xx) {
	xx.getGroup().setScaleX( xx.getGroup().getScaleX()*1.5);
	xx.getGroup().setScaleY( xx.getGroup().getScaleY()*1.5);
} 
public void zoumOut(Openfile xx) {
	xx.getGroup().setScaleX( xx.getGroup().getScaleX()*1/1.5);
	xx.getGroup().setScaleY( xx.getGroup().getScaleY()*1/1.5);
}
public void nondeplace(Openfile xx) {
	 Point C =new Point() ;
		bool.set(false);
	  bool.i=-1;
	Bool trouv =new Bool() ;
	trouv .set(false);
	trouv.i=-1;
	if (!bool.get()){
     	
     	
         
  	   Anchor1 CC = new Anchor1() ;
  	  
  		   C.set(choix[yyy].x,choix[yyy].y);
  		bool.i=rechrch0(xx.getK().getList(),  C) ;
  	
  		   if (bool.i!=-1) {
  			   bool.set(true);
  			   }else {
              		if((xx.getK().getList().getFirst().getStartX()==C.getX())&&(xx.getK().getList().getFirst().getStartY()==C.getY())) {
              			trouv.set(true) ;
              			trouv.i=0;
              			bool.set(true);
               		}
              		
              		}
  		  


}   else {
	if(trouv.get()) {
		xx.getK().getList().getFirst().setStartX(choix[yyy].x);
		xx.getK().getList().getFirst().setStartY(choix[yyy].y);
		trouv.set(false) ;
		trouv.i=-1;
		}else {
		xx.getK().getList().get(bool.i).setEndX(choix[yyy].x);
  	xx.getK().getList().get(bool.i).setEndY(choix[yyy].y);
  	if(bool.i+1==xx.getK().getList().size()) {
  		if(xx.Relier.get()) {
            		xx.getK().getList().getFirst().setStartX(choix[yyy].x);
            		xx.getK().getList().getFirst().setStartY(choix[yyy].y);
            		
       		}
  		}else {
  		xx.getK().getList().get(bool.i+1).setStartX(choix[yyy].x);
       	xx.getK().getList().get(bool.i+1).setStartY(choix[yyy].y);
  	}
  	 		                	}
	
	if (xx.getLL().size()!=0)Draw(xx.getLL() ,xx.getGroup(),xx.getRelier()) ;
	else xx.getGroup().getChildren().remove(1, xx.getGroup().getChildren().size()); 
		Draw1(xx.getK().getList() ,xx.getGroup(),xx.getRelier()) ;
	 
	bool.set(false);

}
}

public void nonRelier(Openfile xx) {

    		if(xx.getK().l.size()>1){
    			
    			 xx.getK().getList().remove(xx.getK().getList().size()-1) ;
    			xx.getGroup().getChildren().remove(xx.getGroup().getChildren().size()-3,xx.getGroup().getChildren().size()-1) ;
    	

    		}
    		xx.getRelier().set(false);
		  }   
public void Dec() {
if (yyy!=0) {
	yyy--;
}
else {
	yyy=0;
}
}
public void Inc() {
	yyy++;
}
public void Intialisez() {
	choix[yyy].chaine=null;
}
}
