/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package m;




import java.awt.Desktop;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.List;
import java.util.ListIterator;
import java.util.Map.Entry;
import java.util.Optional;
import java.util.Scanner;

import javax.swing.SwingUtilities;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.event.UndoableEditEvent;
import javax.swing.event.UndoableEditListener;
import javax.swing.undo.UndoManager;

import javafx.animation.Timeline;
import javafx.application.Application; 
import javafx.application.Platform;
import javafx.beans.property.DoubleProperty;
import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.geometry.Bounds;
import javafx.geometry.Point2D;
import javafx.geometry.Pos;
import javafx.print.PrinterJob;
import javafx.scene.Cursor;
import javafx.scene.Group;
import javafx.scene.Node;
import javafx.scene.PerspectiveCamera;
import javafx.scene.Scene; 
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.ScrollPane.ScrollBarPolicy;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;  
import javafx.stage.Stage;  
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.ContextMenu;
import javafx.scene.control.Label;
import javafx.scene.control.MenuBar;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuItem;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.Separator;
import javafx.scene.control.SeparatorMenuItem;
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;
import javafx.scene.control.TextField;
import javafx.scene.control.ToolBar;
import javafx.scene.control.Tooltip;
import javafx.scene.control.TreeCell;
import javafx.scene.control.TreeItem;
import javafx.scene.control.TreeView;
import javafx.scene.input.ContextMenuEvent;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyCodeCombination;
import javafx.scene.input.KeyCombination;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.input.ScrollEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.Region;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.paint.Paint;
import javafx.scene.paint.PhongMaterial;
import javafx.scene.shape.Circle;
import javafx.scene.shape.CubicCurve;
import javafx.scene.shape.DrawMode;
import javafx.scene.shape.Line;
import javafx.scene.shape.MeshView;
import javafx.scene.shape.Polygon;
import javafx.scene.shape.Rectangle;
import javafx.scene.shape.StrokeLineCap;
import javafx.scene.shape.StrokeType;
import javafx.scene.shape.TriangleMesh;
import javafx.scene.text.TextAlignment;
import javafx.stage.FileChooser;
import javafx.stage.Modality;
import javafx.stage.Popup;
import javafx.util.Callback;
import javafx.util.Duration;
import m.M.Anchor;
import m.M.Anchor1;
import m.M.Bezzier;
import m.M.Bool;
import m.M.BoundLine;
import m.M.Openfile;
import m.M.Point;
import m.M.Triangle;
import m.M.bezier;
import m.NetMusic.Xform;






public class M extends Application {
	
   
public EventHandler<Event>  value=new EventHandler<Event>(){
          public void handle (Event me){
         	
         	 cpt--;
         	 cc[cpt]=null;
          }
      };

	public boolean Detreminant (Point A ,Point B,Point C) {
		// On suppose i, j , k direct
		// 1 si p hors du cercle, 0 sur le cercle, -1 dans le cercle
		double X2 = B.getX() - A.getX() ;
		double Y2 = B.getY() - A.getY() ;
		double Z2 = X2*X2 + Y2*Y2 ;
		double X3 = C.getX()-A.getX() ;
		double Y3 = C.getY()-A.getY() ;
		double Z3 = X3*X3+Y3*Y3 ;
		double det = X2*Y3-X3*Y2 ;
		if (det!=0) return true ;
		else return false  ;
		}
	public void DrawDanlaury(LinkedList<Bezzier> ll ,Group group) {
		ListIterator<Bezzier> l1 =ll.listIterator();
		LinkedList<Anchor1> l=new LinkedList() ;
		
		while(l1.hasNext()) {
			Bezzier l3=l1.next() ;
			LinkedList<bezier> l2 =l3.getList() ;
			ListIterator<bezier> l4 =l2.listIterator();
			while(l4.hasNext()) {
				bezier ZZ=l4.next() ;
				Anchor1 Z = new Anchor1(ZZ.startXProperty(), ZZ.startYProperty()) ;
				Z.setScaleZ(l3.getAltitude());
				l.add(Z) ;	
			}
		    
		}
			
			
			ListIterator<Anchor1> it1=l.listIterator();
			LinkedList<Triangle> p= new LinkedList() ;
			Anchor1 z1,z2,z3 ;
			Point a=null ,b=null,c=null ;
			Point d=new Point () ;
			Point e=new Point () ;
			Point f=new Point () ;
			Bool bb = new Bool() ;
			p.add(FirstTriangle(l, group));
			System.out.println(p.size());
			while(it1.hasNext()) {
				z1=it1.next() ;
				a =new Point(z1.getCenterX(), z1.getCenterY(),z1.getScaleZ());
				//ListIterator<Anchor1> it2=it1;
				ListIterator<Anchor1> it2=l.listIterator();
				
				while(it2.hasNext()) {
					z2=it2.next() ;
					b =new Point(z2.getCenterX(), z2.getCenterY(),z2.getScaleZ());
				//	ListIterator<Anchor1> it3=it2;
					ListIterator<Anchor1> it3=l.listIterator();
					while(it3.hasNext()) {
						z3=it3.next() ;
						c =new Point(z3.getCenterX(), z3.getCenterY(),z3.getScaleZ());
						if (Detreminant (a,b,c)&& z1!=null && z2!=null && z3!=null ) {
						
							 Triangle t = new Triangle(a,b,c) ;
							
							 Boolean B =false  ;
							 ListIterator<Anchor1> it =l.listIterator() ;
							 while (it.hasNext()) {
								 Anchor1 Z =it.next() ;
								 Point ZZ = new Point(Z.getCenterX(), Z.getCenterY()) ;
								 if (returnRadius(a,retourneCentre(a,b,c))>returnRadius(ZZ,retourneCentre(a,b,c))) {
									 B=true ;
								 }
							 }
							 if (!B) {		
									Circle ss =new Circle (retourneCentre(a,b,c).getX(),retourneCentre(a,b,c).getY(),returnRadius(a,retourneCentre(a,b,c))) ;
									ss.setFill(Color.TRANSPARENT);
									ss.setStroke(Color.BLACK);
									t.setStroke(Color.BLACK);
									float h =0 ;
									if(a.getZ()> b.getZ()&&a.getZ()>c.getZ()) {
										h=(float)a.getZ() ;
									}else {
										if(b.getZ()> a.getZ()&&b.getZ()>c.getZ()) {
											h=(float)b.getZ() ;
										}else {
											if(c.getZ()> a.getZ()&& c.getZ()>b.getZ()) {
												h=(float)c.getZ() ;
											}
										}
									}
									double hh =0 ;
									if(a.getZ()< b.getZ() && a.getZ()<c.getZ()) {
										hh=a.getZ() ;System.out.println("hh1");
									}else {
										if(b.getZ()< a.getZ() && b.getZ()<c.getZ()) {
											hh=b.getZ() ;System.out.println("hh2");
										}else {
											if(c.getZ()< a.getZ() && c.getZ()<b.getZ()) {
												hh=c.getZ() ;System.out.println("hh3");
											}
										}
									}
									t.setFill(getColor(hh));System.out.println(hh);
									t.setScaleZ(h);
									t.setTranslateZ(h);
									  TriangleMesh pyramidMesh = new TriangleMesh();

								 float s=(float)t.getStrokeWidth();
									pyramidMesh.getTexCoords().addAll(0,0);
							        pyramidMesh.getPoints().addAll(
							               (float) a.getX(),   (float) a.getY(),    (float)a.getZ(),            // Point 0 - Top
							               (float) b.getX(),   (float) b.getY(),    (float)b.getZ(),         // Point 1 - Front
							               (float) c.getX(),   (float) c.getY(),    (float)c.getZ(),            // Point 2 - Left
							               (float) c.getX(),   (float) c.getY(),    (float)c.getZ(),            // Point 3 - Back
							               (float) b.getX(),   (float) b.getY(),    (float)b.getZ()           // Point 4 - Right
							            );
							        

							       pyramidMesh.getFaces().addAll(
							          0,0,  2,0,  1,0,          // Front left face
							          0,0,  1,0,  3,0,          // Front right face
							          0,0,  3,0,  4,0,          // Back right face
							          0,0,  4,0,  2,0,          // Back left face
							          4,0,  1,0,  2,0,          // Bottom rear face
							          4,0,  3,0,  1,0           // Bottom front face
							      ); 

							        PhongMaterial whiteMaterial = new PhongMaterial();
							        whiteMaterial.setDiffuseColor(getColor(a.getZ()));
							        whiteMaterial.setSpecularColor(Color.WHITE);
							        


							        MeshView pyramid = new MeshView(pyramidMesh);
							        pyramid.setDrawMode(DrawMode.FILL);
							       
							        pyramid.setMaterial(whiteMaterial);
							        pyramid.setTranslateY(-200);
							     //  pyramid.setTranslateX(-100);;
							        
							        
									group.getChildren().addAll(pyramid) ;	 
								
								
								 
							
									 
								 }
						}
						
					}
			
		}
				}

		
				}
	public  void Draw11(LinkedList<bezier> l,Group root, Bool bool,double altitud){
		  
        Iterator<bezier> ll =l.iterator() ;
        bezier A ;  
    
        while (ll.hasNext()) {
            A=ll.next() ;
           A.setTranslateZ(altitud);
              A.setTranslateY(-200);
            A.setFill(getColor(altitud));
    root.getChildren().add(A) ;   
        }
       
        
       
    }




	 public Color getColor(double altitud) {
   	  Color color =Color.WHITE; 
   	  if(altitud>-20 && altitud<20 ) {
   		  color= Color.WHITE ;
   	  }else {
   		  if(altitud>=20 && altitud<50 ) {
   			  color= Color.GREENYELLOW ;
   	  }else {
   		  if(altitud>=50 && altitud<100 ) {
   			  color= Color.YELLOW ;
   		  }else {
   			  if(altitud>=100 && altitud<200 ) {
   				  color= Color.ORANGE ;
   			  }else {
   				  if(altitud>=200 && altitud<300 ) {
   					  color= Color.ORANGERED ;
   				  }else {
   					  if(altitud>=300 && altitud<500 ) {
   						  color= Color.RED; 
   					  }else {
   						  if(altitud>=500  ) {
   							  color= Color.DARKRED;
   						  }else {
   							  if(altitud>-50 && altitud<=-20 ) {
   								  color= Color.LIGHTBLUE;
   							  }
   							  else {
   								  if(altitud>-70 && altitud<=-50 ) {
   									 color= Color.DODGERBLUE ; 
   								  }else {
   									  if(altitud>-100 && altitud<=-70 ) {
   										  color=Color.BLUE; 
   									  }else {
   										  if(altitud>-200 && altitud<=-100 ) {
       										  color=Color.DARKBLUE; 
       									  }else {
       										  if( altitud<=-200 ) {
           										  color=Color.MIDNIGHTBLUE; 
           									  }
       									  }
   									  }
   								  }
   							  }
   						  }
   					  }
   				  }
   			  }
   		  }
   	  }
   	  }
   	return color;
	 }
//******************************************************************************
public  void Draw0(LinkedList<Bezzier> l,Group root ,Bool bool){
        Iterator<Bezzier> ll =l.iterator() ;
       Bezzier AA =new Bezzier() ;
        root.getChildren().remove(0, root.getChildren().size());
       while (ll.hasNext()) {
    	  AA= ll.next() ;
    	  double altitude =AA.getAltitude();
    	 Draw11(AA.getList(),root ,bool,altitude) ;
          
       }
}

//**************************************************************************************

	public Triangle FirstTriangle(LinkedList<Anchor1> l,Group root) {
		ListIterator<Anchor1> it1=l.listIterator();
		Point d= new Point() ;
		Point e=new Point() ;
		Point f = new Point() ;
		Anchor1 z ;
		Point a=null ,b=null,c=null ;
		double min =-1;
		while(it1.hasNext()) {
			z=it1.next() ;
			a =new Point(z.getCenterX(), z.getCenterY());
			ListIterator<Anchor1> it2=l.listIterator();
			while(it2.hasNext()) {
				
				z=it2.next() ;
				b =new Point(z.getCenterX(), z.getCenterY());
				ListIterator<Anchor1> it3=l.listIterator();
				while(it3.hasNext()) {
					
					z=it3.next();
					c =new Point(z.getCenterX(), z.getCenterY());
					if (((min==-1)||(min>returnRadius(a,retourneCentre(a,b,c))))&&(Detreminant (a,b,c))) {
					min =returnRadius(a,retourneCentre(a,b,c)) ;
					e.set(a.getX(), a.getY());
					f.set(b.getX(), b.getY());
					d.set(c.getX(), c.getY());
					
					}
					
				}
			}
			
			
		}
		Triangle t = new Triangle(e,f,d) ;
		root.getChildren().add(t) ;
		return t ;
	}
	public class Triangle extends Polygon{
		private Point A1 ;
		private Point A2 ;
		private Point A3 ;
		public Triangle() {
			super() ;
			setVisible(true);
			setStroke(Color.BLACK);
		    setFill(Color.TRANSPARENT);
		}
		public Triangle(Point A ,Point B, Point C) {
			A1 =A; 
			A2 =B ;
			A3 =C ;
			setVisible(true);
			setStroke(Color.BLACK);
		    setFill(Color.TRANSPARENT);
		    getPoints().addAll(new Double[]{
		              A1.getX(), A1.getY(),
		              A2.getX(), A2.getY(),
		              A3.getX(), A3.getY() });
			
		}
		public Point getA1() {return A1 ;}
		public Point getA2() {return A2 ;}
		public Point getA3() {return A3 ;}
		
		public void setA1(Point a) {A1 =a;	}
		public void setA2(Point a) {A2 =a;	}
		public void setA3(Point a) {A3 =a;	}
	}
	public double returnRadius(Point A, Point B) {
		return Math.pow(Math.pow((B.getX()-A.getX()), 2)+Math.pow((B.getY()-A.getY()), 2), 0.5);
	}
	public Point retourneCentre(Point A,Point B,Point C) {
		Point centre =null;
		if (centre == null) {
		
		double X2 = B.getX() - A.getX() ;
		double Y2 = B.getY() - A.getY() ;
		double Z2 = X2*X2 + Y2*Y2 ;
		double X3 = C.getX()-A.getX() ;
		double Y3 = C.getY()-A.getY() ;
		double Z3 = X3*X3+Y3*Y3 ;
		double det = X2*Y3-X3*Y2 ;
		double rx = 0.5*(Y3*Z2-Y2*Z3)/det + A.getX() ;
		double ry = 0.5*(X2*Z3 - X3*Z2)/det + A.getY() ;
		centre = new Point(rx,ry) ;
		}
		return centre ;
		}
	public  void Draw1(LinkedList<bezier> l,Group root, Bool bool){
		  
        Iterator<bezier> ll =l.iterator() ;
        bezier A ;  
        Anchor C1 ;
        Anchor D1 ;
        BoundLine l1;
        BoundLine l2;
        Bool first = new Bool() ;
   
        while (ll.hasNext()){
        	System.out.println("I Work 1");
		    	 
            A=ll.next() ;
            if ((!bool.get())&&(!first.get())) {
            	Anchor1 Start =new Anchor1(A.startXProperty(),A.startYProperty()) ;
            	root.getChildren().add(Start) ;
            	first.set(true);
            }
                C1 = new Anchor(Color.RED,  A.controlX1Property(), A.controlY1Property());
                D1 = new Anchor(Color.RED, A.controlX2Property(), A.controlY2Property()); 
                l1 = new BoundLine(A.startXProperty(),A.startYProperty(), A.controlX1Property(),A.controlY1Property());
                l2 = new BoundLine(A.endXProperty(),A.endYProperty(), A.controlX2Property(),A.controlY2Property());
                Anchor1 end= new Anchor1(A.endXProperty(),A.endYProperty());
               root.getChildren().add(end) ;
               root.getChildren().add(C1) ;
               root.getChildren().add(D1) ;
               root.getChildren().add(A) ;
               root.getChildren().add(l1) ;
               root.getChildren().add(l2) ;
              
           
        }
       
        
       
    }
	public int rechrch0(LinkedList<bezier> l, Point B) {
	   	 ListIterator<bezier> l1 =l.listIterator();
	   	 Boolean trouv =false ;
	   	 bezier A ;
	   	 int k=-1 ;
	        while(( l1.hasNext())&&(!trouv)){
	             A=l1.next();
	            k++;
	         
	            if ((A.getEndX()==B.getX())||(A.getEndY()==B.getY())){
	                trouv=true ;
	            }
	            

	   }
	        if(trouv) return k;
	        else {
	        	return -1;
	        }
	        }

	/*public void DrawDanlaury(LinkedList<Bezzier> l) {
		ListIterator<Bezzier> it=l.listIterator();
		while(it.hasNext()) {
			LinkedList<Anchor1> ll=it.next().getList();
			ListIterartor<Anchor1> itt= ll.listIterator() ;
			
			
		}
		
	}*/

	public class bezier extends CubicCurve{
		public bezier() {
			super() ;
			setFill(Color.TRANSPARENT);
	        setStroke(Color.FORESTGREEN);
	        setStrokeWidth(4);
	        setStrokeLineCap(StrokeLineCap.ROUND);
	        setOnMouseEntered(new EventHandler<MouseEvent>() {
	            @Override public void handle(MouseEvent mouseEvent) {
	                if (!mouseEvent.isPrimaryButtonDown()) {
	                    getScene().setCursor(Cursor.CLOSED_HAND);
	                }
	            }
	        });
	        setOnMouseExited(new EventHandler<MouseEvent>() {
	            @Override public void handle(MouseEvent mouseEvent) {
	                if (!mouseEvent.isPrimaryButtonDown()) {
	                    getScene().setCursor(Cursor.DEFAULT);
	                }
	            }
	        });
		}
		public bezier(double x1 ,double y1 ,double x2 ,double y2) {
			super() ;
			setStartX(x1);
	    	setStartY(y1);
	    	setControlX1(x1+10);
	    	setControlY1(y1-10);
	    	setControlX2(x2-10);
	    	setControlY2(y2+10);
	    	setEndX(x2);
	    	setEndY(y2);
			setFill(Color.TRANSPARENT);
	        setStroke(Color.FORESTGREEN);
	        setStrokeWidth(4);
	        setStrokeLineCap(StrokeLineCap.ROUND);
	        setOnMouseEntered(new EventHandler<MouseEvent>() {
	            @Override public void handle(MouseEvent mouseEvent) {
	                if (!mouseEvent.isPrimaryButtonDown()) {
	                    getScene().setCursor(Cursor.CLOSED_HAND);
	                }
	            }
	        });
	        setOnMouseExited(new EventHandler<MouseEvent>() {
	            @Override public void handle(MouseEvent mouseEvent) {
	                if (!mouseEvent.isPrimaryButtonDown()) {
	                    getScene().setCursor(Cursor.DEFAULT);
	                }
	            }
	        });
		}
public  bezier(Anchor1 B,Anchor1 A) {
	    	
	    	setStartX(B.getCenterX());
	    	setStartY(B.getCenterY());
	    	setControlX1(B.getCenterX()+10);
	    	setControlY1(B.getCenterY()-10);
	    	setControlX2(A.getCenterX()-10);
	    	setControlY2(A.getCenterY()+10);
	    	setEndX(A.getCenterX());
	    	setEndY(A.getCenterY());
	    	setFill(Color.TRANSPARENT);
	        setStroke(Color.FORESTGREEN);
	        setStrokeWidth(4);
	        setStrokeLineCap(StrokeLineCap.ROUND);
	        setOnMouseEntered(new EventHandler<MouseEvent>() {
	            @Override public void handle(MouseEvent mouseEvent) {
	                if (!mouseEvent.isPrimaryButtonDown()) {
	                    getScene().setCursor(Cursor.CLOSED_HAND);
	                }
	            }
	        });
	        setOnMouseExited(new EventHandler<MouseEvent>() {
	            @Override public void handle(MouseEvent mouseEvent) {
	                if (!mouseEvent.isPrimaryButtonDown()) {
	                    getScene().setCursor(Cursor.DEFAULT);
	                }
	            }
	        });
	        
	    }
	    public  bezier(Point B,Point A) {
	    	
	    	setStartX(B.getX());
	    	setStartY(B.getY());
	    	setControlX1(B.getX()+15);
	    	setControlY1(B.getY()-15);
	    	setControlX2(A.getX()-15);
	    	setControlY2(A.getY()+15);
	    	setEndX(A.getX());
	    	setEndY(A.getY());
	    	setFill(Color.TRANSPARENT);
	        setStroke(Color.FORESTGREEN);
	        setStrokeWidth(4);
	        setStrokeLineCap(StrokeLineCap.ROUND);
	        setOnMouseEntered(new EventHandler<MouseEvent>() {
	            @Override public void handle(MouseEvent mouseEvent) {
	                if (!mouseEvent.isPrimaryButtonDown()) {
	                    getScene().setCursor(Cursor.CLOSED_HAND);
	                }
	            }
	        });
	        setOnMouseExited(new EventHandler<MouseEvent>() {
	            @Override public void handle(MouseEvent mouseEvent) {
	                if (!mouseEvent.isPrimaryButtonDown()) {
	                    getScene().setCursor(Cursor.DEFAULT);
	                }
	            }
	        });
	    }
	    
	}
	public class Bezzier {
		private String nom ;
		private double altitude  ;
		LinkedList<bezier> l =new LinkedList<bezier>() ;
		public LinkedList<bezier> getList(){
			return l ;
		}
		public String getNom(){
			return nom ;
		}
		public double getAltitude(){
			return altitude ;
		}
		public void SetNom(String nom){
		this.nom= nom ;
		}
		public void setAltitude(double a){
			altitude = a ;
		}
	}
    class Bool{
        private boolean bool ;
        public int i ;
        public Bool(){
            bool=false ;
        }
        public void set(boolean bool){
            this.bool=bool  ;
        }
        public boolean get(){return bool;}
    }

    

    public class Point {

    	private double x ;
    	private double y ;
    	private double z ;
    	public Point()
    	{
    		x=0 ;
    		y=0 ;
    		z= 0;
    	}
    	public Point(double absc, double ord )
    	{
    		x=absc ;
    		y=ord ;
    		z= 0 ;
    	}
    	public Point(double absc, double ord,double zz )
    	{
    		x=absc ;
    		y=ord ;
    		z= zz ;
    	}
    	public double getX() {
    		return x;
    	}
    	public double getY() {
    		return y;
    	}
    	public void set(double xx,double yy) {
    		x=xx;
    		y=yy;
    	}
    	public double getZ() {
    		return z;
    	}
    	public void set(double xx,double yy,double zz) {
    		x=xx;
    		y=yy;
    		z=zz;
    	}
    	
    

    }

    public int rechrch(LinkedList<Anchor1> l, Point B) {
    	 ListIterator<Anchor1> l1 =l.listIterator();
    	 Boolean trouv =false ;
    	 Anchor1 A ;
    	 int k=-1 ;
         while(( l1.hasNext())&&(!trouv)){
              A=l1.next();
             k++;
          
             if ((A.getCenterX()==B.getX())||(A.getCenterY()==B.getY())){
                 trouv=true ;
             }
             

    }
         if(trouv) return k;
         else return -1;
         }
   
    public  int rechrch2(LinkedList<Anchor1> l, Point B){

        int k =0;
        Anchor1 A=null ;
        boolean trouv =false;
        double x,y,i=-20,j=-20 ;
        while((i<=20)&&(!trouv)){
            i++;
            while((j<=20)&&(!trouv)){
                j++;
                k=0;
                ListIterator<Anchor1> l1 =l.listIterator();

                while(( l1.hasNext())&&(!trouv)){
                     A=l1.next();
                    k++;
                    x=B.getX()+i;
                    y=B.getY()+j ;
                    if ((A.getCenterX()==x)||(A.getCenterY()==y)){
                        trouv=true ;
                    }

                }

        }




        }
        if(trouv) return k-1;
        else return -1;

    }
    public  void Draw(LinkedList<Bezzier> l,Group root ,Bool bool){
        Iterator<Bezzier> ll =l.iterator() ;
       Bezzier AA =new Bezzier() ;
        root.getChildren().remove(1, root.getChildren().size());
       while (ll.hasNext()) {
    	  AA= ll.next() ;
    	 Draw1(AA.getList(),root ,bool) ;
          
       }
       
    }

    class BoundLine extends Line {
      BoundLine(DoubleProperty startX, DoubleProperty startY, DoubleProperty endX, DoubleProperty endY) {
        startXProperty().bind(startX);
        startYProperty().bind(startY);
        endXProperty().bind(endX);
        endYProperty().bind(endY);
        setStrokeWidth(2);
        setStroke(Color.GRAY.deriveColor(0, 1, 1, 0.5));
        setStrokeLineCap(StrokeLineCap.BUTT);
        getStrokeDashArray().setAll(10.0, 5.0);
      }
    }
    
    class Anchor1 extends Circle {
    	
    	Anchor1()
  	  {
  		  super(0, 0, 4);
  		 setFill(Color.BLACK);
	        setStroke(Color.BLACK);
	        setStrokeWidth(2);
	        setStrokeType(StrokeType.OUTSIDE);
  		setOnMouseEntered(new EventHandler<MouseEvent>() {
            @Override public void handle(MouseEvent mouseEvent) {
                if (!mouseEvent.isPrimaryButtonDown()) {
                    getScene().setCursor(Cursor.HAND);
                }
            }
        });
        setOnMouseExited(new EventHandler<MouseEvent>() {
            @Override public void handle(MouseEvent mouseEvent) {
                if (!mouseEvent.isPrimaryButtonDown()) {
                    getScene().setCursor(Cursor.DEFAULT);
                }
            }
        });
  		  
  	  }
  	  Anchor1( DoubleProperty x, DoubleProperty y) {
  	        super(x.get(), y.get(), 4);
  	        setFill(Color.BLACK);
  	        setStroke(Color.BLACK);
  	        setStrokeWidth(2);
  	        setStrokeType(StrokeType.OUTSIDE);
            setOnMouseEntered(new EventHandler<MouseEvent>() {
                @Override public void handle(MouseEvent mouseEvent) {
                    if (!mouseEvent.isPrimaryButtonDown()) {
                        getScene().setCursor(Cursor.HAND);
                    }
                }
            });
            setOnMouseExited(new EventHandler<MouseEvent>() {
                @Override public void handle(MouseEvent mouseEvent) {
                    if (!mouseEvent.isPrimaryButtonDown()) {
                        getScene().setCursor(Cursor.DEFAULT);
                    }
                }
            });
  	 
    }}

    // a draggable anchor displayed around a point.
    class Anchor extends Circle { 
      Anchor(Color color, DoubleProperty x, DoubleProperty y) {
        super(x.get(), y.get(), 4);
        setFill(Color.RED);
        setStroke(Color.RED);
        setStrokeWidth(1);
        setStrokeType(StrokeType.OUTSIDE);

        x.bind(centerXProperty());
        y.bind(centerYProperty());
        Move();
      }
      Anchor( DoubleProperty x, DoubleProperty y) {
          super(x.get(), y.get(), 4);
          setFill(Color.BLACK);
          setStroke(Color.BLACK);
          setStrokeWidth(1);
          setStrokeType(StrokeType.OUTSIDE);

          x.bind(centerXProperty());
          y.bind(centerYProperty());
          Move();
        }

      // make a node movable by dragging it around with the mouse.
      private void Move() {
        final Delta dragDelta = new Delta();
        setOnMousePressed(new EventHandler<MouseEvent>() {
          @Override public void handle(MouseEvent mouseEvent) {
            // record a delta distance for the drag and drop operation.
            dragDelta.x = getCenterX() - mouseEvent.getX();
            dragDelta.y = getCenterY() - mouseEvent.getY();
            getScene().setCursor(Cursor.MOVE);
          }
        });
        setOnMouseReleased(new EventHandler<MouseEvent>() {
          @Override public void handle(MouseEvent mouseEvent) {
            getScene().setCursor(Cursor.HAND);
          }
        });
        setOnMouseDragged(new EventHandler<MouseEvent>() {
          @Override public void handle(MouseEvent mouseEvent) {
            double newX = mouseEvent.getX() + dragDelta.x;
            if (newX > 0 && newX < getScene().getWidth()) {
              setCenterX(newX);
            }  
            double newY = mouseEvent.getY() + dragDelta.y;
            if (newY > 0 && newY < getScene().getHeight()) {
              setCenterY(newY);
            }

            // update arrow positions
           
          }
        });
        setOnMouseEntered(new EventHandler<MouseEvent>() {
          @Override public void handle(MouseEvent mouseEvent) {
            if (!mouseEvent.isPrimaryButtonDown()) {
              getScene().setCursor(Cursor.HAND);
            }
          }
        });
        setOnMouseExited(new EventHandler<MouseEvent>() {
          @Override public void handle(MouseEvent mouseEvent) {
            if (!mouseEvent.isPrimaryButtonDown()) {
              getScene().setCursor(Cursor.DEFAULT);
            }
          }
        });
      }

      // records relative x and y co-ordinates.
      private class Delta { double x, y; }
    } 
	private Desktop desktop = Desktop.getDesktop();
    
    private Label label;
    private Stage stage=new Stage();
    private Openfile pf;
    private ScrollPane zoomPane;
    protected int cpt;
    private int iii;
    protected Openfile cc[] =new Openfile[256];
    Bool bool=new Bool() ;
    SelectionModel selectionModel =new SelectionModel() ;
	
	
	protected class Openfile {
		private ImageView imageView;
		 private String path;
		 private Image image;
		 private ScrollPane scrollpane;
		 private int pp; 
		 private Group group =new Group();
		private LinkedList<Anchor1> l= new LinkedList<Anchor1> () ;
    	private LinkedList<Bezzier> ll=new  LinkedList<Bezzier> ();
    	private Bezzier k =new Bezzier () ;
    	protected Point B=new Point();
    	protected Point A=new Point();
    	
    	Bool Relier =new Bool() ;
    	private Bezzier T[]=new Bezzier[10000] ;
        private  int j=0;
    	private undofx Undofx= new undofx();
    	protected void setSelection() {
    		new RubberBandSelection(this.group);
    	}
    	protected undofx getUndofx() {
    		return Undofx;
    	}
    	 protected Bezzier getT() {
    		 return T[j] ;
    	 }
    	 protected void setK(Bezzier k) {
    		 this.k=k ;
    	 }
    	 protected Bool getRelier() {
    		 return Relier;
    	 }
    	 
	 protected ScrollPane getscrollpane() {
		return scrollpane;
	}
	 protected void setPoint(Point a) {
		 B.set(a.x, a.y);
	 }
	 protected Point getA() {
		 return A;
	 }
	 protected Point getB() {
		 return B;
	 }
	 protected ImageView getImageView() {
		return imageView;
	}
	protected Image getImage() {
		return image;
	}
	protected String getpath() {
		return path;
	}
	protected Group getGroup() {
		return group;
	}
	protected void setImageView() {
		imageView=new ImageView(getImage());
		imageView.setX(0); 
	    imageView.setY(0); 
	    imageView.setFitHeight(500); 
	    imageView.setFitWidth(500); 
	    imageView.setPreserveRatio(true);
	}
	protected void setImage() throws FileNotFoundException {
		 image= new Image(new FileInputStream(getpath()));
	}
	protected void setpath(File file) {
		 path=file.getAbsolutePath();
	}
	protected void setGroup(ImageView img) {
		group=new Group(img);
	}
	
	protected int getTabIndex() {
		return pp;
	}
	protected void setTabIndex(int i) {
		pp=i;
	}
	protected Bezzier getK() {
		return k;
	}
	protected LinkedList<Anchor1> getL(){
		return l;
	}
	protected LinkedList<Bezzier> getLL(){
		return ll;
	}
	}

		 private  void openFile(File file,TabPane tab1,Tab tab,Openfile yy) throws FileNotFoundException {
	      yy.setpath(file);
	      yy.setImage();
	      yy.setImageView();
	     yy.setGroup(yy.getImageView());
	       
            
	       zoomPane = createZoomPane(yy.getGroup());
	       
	        //new ZoomableScrollPane(imageView);
	        tab.setContent(zoomPane);
	        tab.setOnClosed(value);
	        
	        tab1.getTabs().add(tab);
}	
	 private  void openFile1(File file,TabPane tab1,Tab tab,Openfile yy) throws FileNotFoundException {
		 yy.setpath(file);
	      yy.setImage();
	      yy.setImageView();
	     
	      yy.setGroup(yy.getImageView());
	       
          
	       zoomPane = createZoomPane(yy.getGroup());
	        //new ZoomableScrollPane(imageView);
	        tab.setContent(zoomPane);
	        tab.setOnClosed(value);
	     
}	
	 private  void openFile2(TabPane tab1,Tab tab,Openfile yy) throws FileNotFoundException {
		 
	       
		 
	       zoomPane = createZoomPane(yy.getGroup());
	        //new ZoomableScrollPane(imageView);
	        tab.setContent(zoomPane);
	        tab.setOnClosed(value);
	        
	        tab1.getTabs().add(tab);
	     
}	
	 public static void main(String[] args) {
	        
		Application.launch(M.class, args);
	    }

         
	//---------------------------------------------------------------//
     private ScrollPane createZoomPane(final Group group) {
    	    final double SCALE_DELTA = 1.1;
    	    final StackPane zoomPane = new StackPane();

    	    zoomPane.getChildren().add(group);

    	    final ScrollPane scroller = new ScrollPane();
    	    final Group scrollContent = new Group(zoomPane);
    	    scroller.setContent(scrollContent);

    	    scroller.viewportBoundsProperty().addListener(new ChangeListener<Bounds>() {
    	      @Override
    	      public void changed(ObservableValue<? extends Bounds> observable,
    	          Bounds oldValue, Bounds newValue) {
    	        zoomPane.setMinSize(newValue.getWidth(), newValue.getHeight());
    	      }
    	    });
    	    
    	    scroller.setPrefViewportWidth(256);
    	    scroller.setPrefViewportHeight(256);

    	    zoomPane.setOnScroll(new EventHandler<ScrollEvent>() {
    	      @Override
    	      public void handle(ScrollEvent event) {
    	        event.consume();

    	        if (event.getDeltaY() == 0) {
    	          return;
    	        }

    	        double scaleFactor = (event.getDeltaY() > 0) ? SCALE_DELTA
    	            : 1 / SCALE_DELTA;

    	        // amount of scrolling in each direction in scrollContent coordinate
    	        // units
    	        Point2D scrollOffset = figureScrollOffset(scrollContent, scroller);

    	        group.setScaleX(group.getScaleX() * scaleFactor);
    	        group.setScaleY(group.getScaleY() * scaleFactor);

    	        // move viewport so that old center remains in the center after the
    	        // scaling
    	        repositionScroller(scrollContent, scroller, scaleFactor, scrollOffset);

    	      }
    	    });

    	    // Panning via drag....
    	    final ObjectProperty<Point2D> lastMouseCoordinates = new SimpleObjectProperty<Point2D>();
    	    scrollContent.setOnMousePressed(new EventHandler<MouseEvent>() {
    	      @Override
    	      public void handle(MouseEvent event) {
    	        lastMouseCoordinates.set(new Point2D(event.getX(), event.getY()));
    	      }
    	    });

    	   

    	    return scroller;
    	  }
  
     private ScrollPane createZoomPane1(final Group group) {
  	    final double SCALE_DELTA = 1.1;
  	    final StackPane zoomPane = new StackPane();

  	    zoomPane.getChildren().add(group);

  	    final ScrollPane scroller = new ScrollPane();
  	    final Group scrollContent = new Group(zoomPane);
  	    scroller.setContent(scrollContent);

  	    scroller.viewportBoundsProperty().addListener(new ChangeListener<Bounds>() {
  	      @Override
  	      public void changed(ObservableValue<? extends Bounds> observable,
  	          Bounds oldValue, Bounds newValue) {
  	        zoomPane.setMinSize(newValue.getWidth(), newValue.getHeight());
  	      }
  	    });
  	    
  	    scroller.setPrefViewportWidth(256);
  	    scroller.setPrefViewportHeight(256);

  	    zoomPane.setOnScroll(new EventHandler<ScrollEvent>() {
  	      @Override
  	      public void handle(ScrollEvent event) {
  	        event.consume();

  	        if (event.getDeltaY() == 0) {
  	          return;
  	        }

  	        double scaleFactor = (event.getDeltaY() > 0) ? SCALE_DELTA
  	            : 1 / SCALE_DELTA;

  	        // amount of scrolling in each direction in scrollContent coordinate
  	        // units
  	        Point2D scrollOffset = figureScrollOffset(scrollContent, scroller);

  	        group.setScaleX(group.getScaleX() * scaleFactor);
  	        group.setScaleY(group.getScaleY() * scaleFactor);

  	        // move viewport so that old center remains in the center after the
  	        // scaling
  	        repositionScroller(scrollContent, scroller, scaleFactor, scrollOffset);

  	      }
  	    });

  	    // Panning via drag....
  	    final ObjectProperty<Point2D> lastMouseCoordinates = new SimpleObjectProperty<Point2D>();
  	    scrollContent.setOnMousePressed(new EventHandler<MouseEvent>() {
  	      @Override
  	      public void handle(MouseEvent event) {
  	        lastMouseCoordinates.set(new Point2D(event.getX(), event.getY()));
  	      }
  	    });

  	    scrollContent.setOnMouseDragged(new EventHandler<MouseEvent>() {
    	      @Override
    	      public void handle(MouseEvent event) {
    	        double deltaX = event.getX() - lastMouseCoordinates.get().getX();
    	        double extraWidth = scrollContent.getLayoutBounds().getWidth() - scroller.getViewportBounds().getWidth();
    	        double deltaH = deltaX * (scroller.getHmax() - scroller.getHmin()) / extraWidth;
    	        double desiredH = scroller.getHvalue() - deltaH;
    	        scroller.setHvalue(Math.max(0, Math.min(scroller.getHmax(), desiredH)));

    	        double deltaY = event.getY() - lastMouseCoordinates.get().getY();
    	        double extraHeight = scrollContent.getLayoutBounds().getHeight() - scroller.getViewportBounds().getHeight();
    	        double deltaV = deltaY * (scroller.getHmax() - scroller.getHmin()) / extraHeight;
    	        double desiredV = scroller.getVvalue() - deltaV;
    	        scroller.setVvalue(Math.max(0, Math.min(scroller.getVmax(), desiredV)));
    	      }
    	    });

  	    return scroller;
  	  }
    	  private Point2D figureScrollOffset(Node scrollContent, ScrollPane scroller) {
    	    double extraWidth = scrollContent.getLayoutBounds().getWidth() - scroller.getViewportBounds().getWidth();
    	    double hScrollProportion = (scroller.getHvalue() - scroller.getHmin()) / (scroller.getHmax() - scroller.getHmin());
    	    double scrollXOffset = hScrollProportion * Math.max(0, extraWidth);
    	    double extraHeight = scrollContent.getLayoutBounds().getHeight() - scroller.getViewportBounds().getHeight();
    	    double vScrollProportion = (scroller.getVvalue() - scroller.getVmin()) / (scroller.getVmax() - scroller.getVmin());
    	    double scrollYOffset = vScrollProportion * Math.max(0, extraHeight);
    	    return new Point2D(scrollXOffset, scrollYOffset);
    	  }

    	  private void repositionScroller(Node scrollContent, ScrollPane scroller, double scaleFactor, Point2D scrollOffset) {
    	    double scrollXOffset = scrollOffset.getX();
    	    double scrollYOffset = scrollOffset.getY();
    	    double extraWidth = scrollContent.getLayoutBounds().getWidth() - scroller.getViewportBounds().getWidth();
    	    if (extraWidth > 0) {
    	      double halfWidth = scroller.getViewportBounds().getWidth() / 2 ;
    	      double newScrollXOffset = (scaleFactor - 1) *  halfWidth + scaleFactor * scrollXOffset;
    	      scroller.setHvalue(scroller.getHmin() + newScrollXOffset * (scroller.getHmax() - scroller.getHmin()) / extraWidth);
    	    } else {
    	      scroller.setHvalue(scroller.getHmin());
    	    }
    	    double extraHeight = scrollContent.getLayoutBounds().getHeight() - scroller.getViewportBounds().getHeight();
    	    if (extraHeight > 0) {
    	      double halfHeight = scroller.getViewportBounds().getHeight() / 2 ;
    	      double newScrollYOffset = (scaleFactor - 1) * halfHeight + scaleFactor * scrollYOffset;
    	      scroller.setVvalue(scroller.getVmin() + newScrollYOffset * (scroller.getVmax() - scroller.getVmin()) / extraHeight);
    	    } else {
    	      scroller.setHvalue(scroller.getHmin());
    	    }
    	  }

    	 

    	


     //--------------------------------------------------------------//
	 
	 
    	  private final class TextFieldTreeCellImpl extends TreeCell<String> {
    		  
  	        private TextField textField;
  	        private ContextMenu addMenu = new ContextMenu();
  	 
  	        public TextFieldTreeCellImpl(TabPane tab2) {
  	            MenuItem addMenuItem = new MenuItem("Ajouter Un Onglet",idtreeviewt);
  	            addMenu.getItems().add(addMenuItem);
  	            addMenuItem.setOnAction(new EventHandler() {
  	                public void handle(Event t) {
  	                	pf=new Openfile();
  	                  cpt++;
  	                  try {
  	 					openFile2(tab2, new Tab("Onglet "+cpt),pf);
  	 					pf.setTabIndex(cpt);
  	                     cc[cpt]=pf;
  	 				} catch (FileNotFoundException e1) {
  	 					// TODO Auto-generated catch block
  	 					e1.printStackTrace();
  	 				}
  	                    TreeItem newEmployee = 
  	                        new TreeItem<String>(" Onglet n¬∞"+cpt);
  	                    
  	                            getTreeItem().getChildren().add(newEmployee);
  	                }
  	            });
  	        }
  	 
  	        @Override
  	        public void startEdit() {
  	            super.startEdit();
  	 
  	            if (textField == null) {
  	                createTextField();
  	            }
  	            setText(null);
  	            setGraphic(textField);
  	            textField.selectAll();
  	        }
  	 
  	        @Override
  	        public void cancelEdit() {
  	            
  	            super.cancelEdit();setText((String) getItem());
  	            setGraphic(getTreeItem().getGraphic());
  	        }
  	 
  	        @Override
  	        public void updateItem(String item, boolean empty) {
  	            super.updateItem(item, empty);
  	 
  	            if (empty) {
  	                setText(null);
  	                setGraphic(null);
  	            } else {
  	                if (isEditing()) {
  	                    if (textField != null) {
  	                        textField.setText(getString());
  	                    }
  	                    setText(null);
  	                    setGraphic(textField);
  	                } else {
  	                    setText(getString());
  	                    setGraphic(getTreeItem().getGraphic());
  	                    if (
  	                        !getTreeItem().isLeaf()&&getTreeItem().getParent()!= null
  	                    ){
  	                        setContextMenu(addMenu);
  	                    }
  	                }
  	            }
  	        }
  	        
  	        private void createTextField() {
  	            textField = new TextField(getString());
  	            textField.setOnKeyReleased(new EventHandler<KeyEvent>() {
  	 
  	                @Override
  	         
  	         public void handle(KeyEvent t) {
  	                    if (t.getCode() == KeyCode.ENTER) {
  	                        commitEdit(textField.getText());
  	                    } else if (t.getCode() == KeyCode.ESCAPE) {
  	                        cancelEdit();
  	                    }
  	                }
  	            });  
  	            
  	        }
  	 
  	        private String getString() {
  	            return getItem() == null ? "" : getItem().toString();
  	        }
  	    }
  	 
  	    public static class Employee {
  	 
  	        private final SimpleStringProperty name;
  	        private final SimpleStringProperty department;
  	 
  	        private Employee(String name, String department) {
  	            this.name = new SimpleStringProperty(name);
  	            this.department = new SimpleStringProperty(department);
  	        }
  	 
  	        public String getName() {
  	            return name.get();
  	        }
  	 
  	        public void setName(String fName) {
  	            name.set(fName);
  	        }
  	 
  	        public String getDepartment() {
  	            return department.get();  
  	             }
  	 
  	        public void setDepartment(String fName) {
  	            department.set(fName);
  	         
  	         
  	         
  	        }}
  	         
       
       
       
       
       
       
                        
                        
                        
                        
                        
                        
                        
                        
                        
         
         
         
         Image idtree = new Image(getClass().getResourceAsStream("user-3.png"));
         ImageView idtreeview = new ImageView(idtree);
       Image idtreet = new Image(getClass().getResourceAsStream("add-file-3.png"));
         ImageView idtreeviewt = new ImageView(idtreet);
         Image idtreew = new Image(getClass().getResourceAsStream("file-11.png"));
         ImageView idtreevieww = new ImageView(idtreew);
         
         
          List<Employee> employees = Arrays.<Employee>asList(
            new Employee(" Onglet n∞01 ", " Projet n∞01 "));
           TreeItem<String> rootNode = 
           new TreeItem<String>(" Utilisateur ID ",idtreeview);
          private final Image depIcon = 
        new Image(getClass().getResourceAsStream("folder-20.png"));
           
          
          static private void saveParentAndChildren(TreeItem<String> rootNode, String parent){
              System.out.println("Current Parent :" + rootNode.getValue());
              try(PrintWriter writer = new PrintWriter(new FileOutputStream(new File("C:\\Users\\adm\\Desktop\\M\\tree_structure.txt"),true /* append = true */))){
                  writer.println(rootNode.getValue() + "=" + parent);

                  for(TreeItem<String> child: rootNode.getChildren()){
                      if(child.getChildren().isEmpty()){
                          writer.println(child.getValue() + "=" + rootNode.getValue());
                      } else {
                          saveParentAndChildren(child, rootNode.getValue());
                      }
                  }
              }
              catch (FileNotFoundException ex) {
                  Logger.getLogger(M.class.getName()).log(Level.SEVERE, null, ex);
              }

          }

          static private TreeItem loadTree(){
              TreeItem rootNode = null;
              HashMap<String, String> treeStructure = new HashMap();

              File file = new File("C:\\Users\\adm\\Desktop\\M\tree_structure.txt");
              try(BufferedReader br = new BufferedReader(new FileReader(file)))
              {
                  String st;
                  while((st=br.readLine()) != null){
                      String[] splitLine = st.split("=");
                      treeStructure.put(splitLine[0], splitLine[1]);
                  }

                  rootNode = getChildrenNodes(treeStructure, "root").get(0);//This gets the root node
                  List<TreeItem> parentItems = getChildrenNodes(treeStructure, rootNode.getValue().toString());//get the root's children
                  //if the root has children get every child's children if they have some.
                  if(parentItems.size() > 0)
                  {                
                      rootNode.getChildren().addAll(parentItems);
                      for(TreeItem item : parentItems)
                      {
                          item.getChildren().addAll(getChildrenNodes(treeStructure, item.getValue().toString()));
                      }
                  }            
              }
              catch (IOException ex) {
                  Logger.getLogger(M.class.getName()).log(Level.SEVERE, null, ex);
              }

              return rootNode;
          }   

          static private List<TreeItem> getChildrenNodes(HashMap<String, String> hMap, String parent)
          {
              List<TreeItem> children = new ArrayList();

              for (Entry<String, String> entry : hMap.entrySet())
              {

                  if(entry.getValue().equals(parent))
                  {
                      System.out.println(entry.getKey() + "/" + entry.getValue());
                      children.add(new TreeItem(entry.getKey()));
                  }
              }

              return children;
          }
          private void SaveFile(String content, File file){
              try {
                  FileWriter fileWriter = null;
                   
                  fileWriter = new FileWriter(file);
                  fileWriter.write(content);
                  fileWriter.close();
              } catch (IOException ex) {
                  Logger.getLogger(M.class.getName()).log(Level.SEVERE, null, ex);
              }
               
          }

           
           
         
        
         
         
         public  void display(TabPane tab1 )
         {
             Stage window =new Stage();
             final FileChooser fileChooser = new FileChooser();
             window.initModality(Modality.APPLICATION_MODAL);
             window.setMinWidth(400);
              window.setMinHeight(200);
              window.setTitle("Nouvel Onglet");
            
             Image impo= new Image(getClass().getResourceAsStream("image-6.png"));
             ImageView impoview = new ImageView(impo);
             impoview.setFitWidth(50);
              impoview.setFitHeight(50);
             
              Image ongg= new Image(getClass().getResourceAsStream("file-10.png"));
             ImageView onggview = new ImageView(ongg);
             onggview.setFitWidth(50);
             onggview.setFitHeight(50);
              
              
              
              Button onglet =new Button("  Ouvrir Un Onlget ",onggview);
             onglet.setOnAction((ActionEvent e)->{
            	 
            	 pf=new Openfile();
                 cpt++;
                 try {
					openFile2(tab1, new Tab("Onglet "+cpt),pf);
					pf.setTabIndex(cpt);
                    cc[cpt]=pf;
                    iii=1;
				} catch (FileNotFoundException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
                     window.close();
                     
             });
             onglet.setTranslateX(9);
             onglet.setTranslateY(50);
             
             
             Button impor =new Button(" Ouvrir et Importer ",impoview);
             impor.setOnAction((final ActionEvent e) -> {
                 configureFileChooser(fileChooser);
                 File file = fileChooser.showOpenDialog(stage);
                 if (file != null) {
                       try {
                    	    pf=new Openfile();
                               cpt++;
                               openFile(file,tab1, new Tab("Onglet "+cpt),pf);
                               pf.setTabIndex(cpt);
                               cc[cpt]=pf;
                               iii=1;
                            } catch (FileNotFoundException e1) {
                       // TODO Auto-generated catch block
                               e1.printStackTrace();
                            }
                              }
                 window.close();
                 });
              
             impor.setTranslateX(202);
             impor.setTranslateY(-30);
             Label label1 = new Label("Voulez vous importer une image ‡ cet onglet? ");
             label1.setTranslateY(40);
             label1.setTranslateX(30);
             label1.setStyle

        (

                "-fx-font-family: \"arial\";"

                + "-fx-font-size: 15px;"

                + "-fx-font-style: normal;"

                + "-fx-font-weight: bolder;"

        );

             
             
             
              VBox layout =new VBox(20);
             layout.getChildren().addAll(label1,onglet,impor);
             
          
             
             Scene scene=new Scene(layout);
             
             
             
             
             window.setFullScreen(false);
             window.setMaximized(false);
             window.setResizable(false);
             window.setScene(scene);
              window.show();
         }
         

        private static void configureFileChooser(
		        final FileChooser fileChooser) {      
		            fileChooser.setTitle("Importer Image");
		            fileChooser.setInitialDirectory(
		                new File(System.getProperty("user.home"))
		            );                 
		            fileChooser.getExtensionFilters().addAll(
		                new FileChooser.ExtensionFilter("Toutes les images", "*.*"),
		                new FileChooser.ExtensionFilter("JPG", "*.jpg"),
		                new FileChooser.ExtensionFilter("PNG", "*.png")
		            );
		    }
       
        private void popupMenu(TabPane borderPane,Stage primaryStage) {
		  ContextMenu contextMenu = new ContextMenu();
	
                  
                  Image ferm = new Image(getClass().getResourceAsStream("closeclose.png"));
                  ImageView fermview = new ImageView(ferm);
                  fermview.setFitWidth(19);
                  fermview.setFitHeight(19);
        
                  Image copy= new Image(getClass().getResourceAsStream("document_text.png"));
                  ImageView copyview = new ImageView(copy);
                  copyview.setFitWidth(18);
                  copyview.setFitHeight(18);
        
        
                   Image pastee= new Image(getClass().getResourceAsStream("clip_paste.png"));
                   ImageView pasteeview = new ImageView(pastee);
                   pasteeview.setFitWidth(18);
                   pasteeview.setFitHeight(18);
        
                  
                  Image coup= new Image(getClass().getResourceAsStream("CCC.png"));
                  ImageView coupview = new ImageView(coup);
                  coupview.setFitWidth(18);
                  coupview.setFitHeight(18);
                   
                   
                   Image mini= new Image(getClass().getResourceAsStream("minimize-3.png"));
                  ImageView miniview = new ImageView(mini);
                  miniview.setFitWidth(18);
                  miniview.setFitHeight(18);
                   
                  Image mega= new Image(getClass().getResourceAsStream("mega.png"));
                  ImageView megaview = new ImageView(mega);
                  megaview.setFitWidth(17);
                  megaview.setFitHeight(17);
                  
                   Image retour= new Image(getClass().getResourceAsStream("back-arrow.png"));
                    ImageView retourview = new ImageView(retour);
                     retourview.setFitWidth(17);
                       retourview.setFitHeight(17);
                  
                 
                  
                  
                  
                  
                  
                  
		 MenuItem item1 = new MenuItem("Copier  ",copyview);
	         MenuItem item2  = new MenuItem("Coller  ",pasteeview);
	         MenuItem  item4= new MenuItem("Couper  ",coupview);
	         MenuItem item6= new MenuItem("Maximiser  ",megaview);
	         MenuItem item8= new MenuItem("Undo   ",retourview);
	         MenuItem item7= new MenuItem("Minimiser  ",miniview);
                 MenuItem item3  = new MenuItem("Fermer  ",fermview);
	         //-----------------------------------------------------------//
	         item6.setOnAction((ActionEvent event) -> {
                     primaryStage.setMaximized(true);
                  });
	         
	         item3.setOnAction((ActionEvent event) -> {
                     showConfirmation(primaryStage);
                  });
      
                 item7.setOnAction(new EventHandler<ActionEvent>() {
	        	 @Override

	 			public void handle(ActionEvent event) {

	 				primaryStage.sizeToScene();

	 			}
	        	 
	         });

                 
                 
                 
                 
                 
	         
	         
	         
	         contextMenu.getItems().addAll(item1, item2,item4,item8,item6,item7,item3);
	         borderPane.addEventHandler(ContextMenuEvent.CONTEXT_MENU_REQUESTED, event -> {
	             contextMenu.show(borderPane, event.getScreenX(), event.getScreenY());
	             event.consume();
	         });
	         borderPane.addEventHandler(MouseEvent.MOUSE_PRESSED, event -> {
	             contextMenu.hide();
	         });
	 }

        private void print(Node node)
        
            {
        
                // Define the Job Status Message
        
              
       
                 
        
                // Create a printer job for the default printer
        
                PrinterJob job = PrinterJob.createPrinterJob();
       
                 
      
                if (job != null)
       
                {
       
                    // Show the printer job status
       
                   
        
                     
       
                    // Print the node
        
                    boolean printed = job.printPage(node);
       
         
       
                    if (printed)
        
                    {
       
                        // End the printer job
        
                        job.endJob();
        
                    }
        
                    else
       
                    {
        
                        // Write Error Message
        
                        System.out.println("vous pouvez pas imprimer ");      
                    }
      
                }
        
                else
       
                {
       
                    // Write Error Message
        
                	System.out.println("vous pouvez pas imprimer ");      
        
                }
       
            }  

	
         
 
    private void showConfirmation(Stage stag) {
 
        Alert alert = new Alert(AlertType.NONE);
        alert.setTitle(" Fermeture ");
        alert.setContentText("Voulez Vous Vraiment Fermer Cette FenÍtre? ");
       alert.getWidth();
       
        ButtonType yes = new ButtonType(" Oui  ");
        ButtonType cancel = new ButtonType("Annuler");
        
        // Remove default ButtonTypes
        alert.getButtonTypes().clear();
 
        alert.getButtonTypes().addAll(yes,cancel);
 
        // option != null.
        Optional<ButtonType> option = alert.showAndWait();
 
        if (option.get() == null) {
            this.label.setText("No selection!");
        } 
        else if (option.get() == yes) {
           stag.close();
        } 
        else if (option.get() == cancel) {
            
        } 
        
    }
         
    private void showConfirmation1(Stage stag) {
 
        Alert alert = new Alert(AlertType.NONE);
        alert.setTitle(" Fermeture ");
       
        alert.setContentText("Voulez Vous Vraiment Fermer Ce Projet? ");
       alert.getWidth();
      
       
        ButtonType yes = new ButtonType(" Oui  ");
        ButtonType cancel = new ButtonType("Annuler");
        
        // Remove default ButtonTypes
        alert.getButtonTypes().clear();
 
        alert.getButtonTypes().addAll(yes,cancel);
 
        // option != null.
        Optional<ButtonType> option = alert.showAndWait();
 
        if (option.get() == null) {
            this.label.setText("No selection!");
        } 
        else if (option.get() == yes) {
         stag.close();
        } 
        else if (option.get() == cancel) {
            
        } 
        
    }
         
     private void showConfirmation2(Stage stag) {
         Alert alert = new Alert(AlertType.CONFIRMATION);
        alert.setTitle(" Fermeture ");
       
    
       alert.setHeaderText("Votre projet a ete modifiÈ ,voulez vous vraiment le fermer sans enregistrer les modifications?  ");
       
        ButtonType yes = new ButtonType(" Oui  ");
        ButtonType cancel = new ButtonType("Enregistrer et Fermer");
        ButtonType non = new ButtonType(" Non  ");
        // Remove default ButtonTypes
        alert.getButtonTypes().clear();
 
        alert.getButtonTypes().addAll(cancel,yes,non);
 
        // option != null.
        Optional<ButtonType> option = alert.showAndWait();
 
        if (option.get() == null) {
            this.label.setText("No selection!");
        } 
         if (option.get() == yes) {
            stag.close();
        } 
         if (option.get() == cancel) {
             this.label.setText("No selection!");
        } 
         if (option.get() == non) {
            this.label.setText("No selection!");
        } 
        
         
    
     }
         
     
     
    
         
         
         
    @Override
    public void start(Stage primaryStage) throws FileNotFoundException, InterruptedException  {
    	primaryStage.setMinWidth(800);
    	primaryStage.setMinHeight(550);
    
    	
    	
    	undoRdo undoredo =new undoRdo();
        UndoManager editManager = new UndoManager();
        
        BorderPane borderPane3 = new BorderPane();
        borderPane3.setPrefHeight(50.0);
        borderPane3.setPrefWidth(50.0);
        
        BorderPane borderPane4 = new BorderPane();
        borderPane4.setPrefHeight(100.0);
        borderPane4.setPrefWidth(100.0);
        
        BorderPane borderPane5= new BorderPane();
        borderPane5.setPrefHeight(100.0);
        borderPane5.setPrefWidth(100.0);
        

         ToolBar toolbar2 = new ToolBar();
         toolbar2.resizeRelocate(0,-1,50,50);
         toolbar2.setStyle("-fx-background-color: #330033");
         
         ToolBar toolbar3 = new ToolBar();
         toolbar3.resizeRelocate(0,-1,63,50);
         toolbar3.setStyle("-fx-background-color: #330033");
          ToolBar toolbar4 = new ToolBar();
         toolbar4.resizeRelocate(0,502,63,50);
         //#A9A9A9
        toolbar4.setStyle("-fx-background-color: linear-gradient(from 25% 25% to 90% 90%, #330033, #330033)");
       
        
        javafx.scene.image.Image projj = new javafx.scene.image.Image(getClass().getResourceAsStream("kkk.png"));
        ImageView projviewj = new ImageView(projj);
        projviewj.setFitWidth(16);
        projviewj.setFitHeight(16);
        
        
        javafx.scene.image.Image usus = new javafx.scene.image.Image(getClass().getResourceAsStream("user-5.png"));
        ImageView ususview = new ImageView(usus);
        ususview.setFitWidth(25);
        ususview.setFitHeight(25);
        
         javafx.scene.image.Image logoutt = new javafx.scene.image.Image(getClass().getResourceAsStream("logout.png"));
        ImageView logview = new ImageView(logoutt);
        logview.setFitWidth(20);
        logview.setFitHeight(20);
        
         javafx.scene.image.Image cur = new javafx.scene.image.Image(getClass().getResourceAsStream("io.png"));
        ImageView curview = new ImageView(cur);
        curview.setFitWidth(24);
        curview.setFitHeight(24);
        
        TabPane tabPane = new TabPane();
       
        
         Button bubu= new Button("",curview);
        Button buttonLeft = new Button("",projviewj);
        Button buttonbu= new Button("",ususview);
      buttonbu.setStyle(
                "-fx-background-radius: 40em; " +
                "-fx-min-width: 40px; " +
                "-fx-min-height: 40px; " +
                "-fx-max-width: 40px; " +
                "-fx-max-height: 40px;"
        );
      bubu.setStyle(
                "-fx-background-radius: 40em; " +
                "-fx-min-width: 40px; " +
                "-fx-min-height: 40px; " +
                "-fx-max-width: 40px; " +
                "-fx-max-height: 40px;"
        );
      Button mmm= new Button(" D√©connexion",logview);
      mmm.setLayoutY(280);
       
        rootNode.setExpanded(true);
       
        TreeView<String> treeView = new TreeView<String>(rootNode);
        treeView.setEditable(true);
        treeView.setCellFactory(new Callback<TreeView<String>,TreeCell<String>>(){
            @Override
            public TreeCell<String> call(TreeView<String> p) {
               
                return new TextFieldTreeCellImpl(tabPane);
            }
        });
        treeView.setStyle("-fx-background-color: #330033");
        
         /**
         * Instanciate a BorderSlideBar for each childs layouts
         */
        

        BorderSlideBar leftFlapBar = new BorderSlideBar(174, buttonLeft, Pos.BASELINE_LEFT);
        borderPane3.setLeft(leftFlapBar);
        
     
       borderPane3.setMaxSize(50, 700);
         leftFlapBar.setTranslateY(49);
         treeView.setMinHeight(430);
         
       leftFlapBar.getChildren().add(treeView);
        
        toolbar2.getItems().addAll( buttonLeft);
        borderPane3.getChildren().addAll( toolbar2);

        
 BorderSlideBar leftFlapBar2 = new BorderSlideBar(200, buttonbu, Pos.BASELINE_RIGHT);
        borderPane4.setRight(leftFlapBar2);
        
 BorderSlideBar leftFlapBar3 = new BorderSlideBar(200, bubu, Pos.BASELINE_LEFT);       
        borderPane4.setLeft(leftFlapBar3);
        leftFlapBar3.setTranslateY(278);
       
         toolbar4.getItems().addAll(bubu);
        
    Label MyProfileLabel;
    Label Mesc;
    Label prenomuser;
    Label ageuser;
    Label nomuser;
    Label emp;
    Label vvv;
    Label vm;
    Label vl;
    Label emp1;
     Label empp1;
    Label emp2;
    Label emp3;
    Label videvide2;
    Label videvide1;
    Label videvide3;
    Label videvide4;
    Label videvide5;
     Label videvide6;
    Label videvide;
      Label videvidee;
    Label videvide7;
    TextField NomTextField;
    TextField prenomTextField;
    TextField NomTextField1;
    TextField prenomTextField1;
    TextField ageTextField;
    TextField ppp;
    TextField pppm;
    TextField pppl;
    TextField pppp;
     
     
     
    MyProfileLabel=new Label("             Mon Profil");
     Mesc=new Label("             Mes Courbes");
    nomuser=new Label("   Nom :");
    videvide=new Label("       ");
      videvidee=new Label("       ");
    videvide2=new Label("    ");
    videvide1=new Label("    ");
    videvide3=new Label("    ");
    videvide4=new Label("    ");
    videvide5=new Label("    ");
    videvide6=new Label("    ");
     videvide7=new Label("    ");
     emp=new Label("    ");
     emp3=new Label("    ");
     emp1=new Label("    ");
      empp1=new Label("    ");
     emp2=new Label("    ");
     vvv=new Label("    ");
       vm=new Label("    ");
         vl=new Label("    ");
     
    prenomuser=new Label("   Prenom :");
    ageuser=new Label("    Age :");
    
    nomuser.setTextFill(Color.web("#ffffff"));
    prenomuser.setTextFill(Color.web("#ffffff"));
    ageuser.setTextFill(Color.web("#ffffff"));
    MyProfileLabel.setTextFill(Color.web("#ffffff"));
     Mesc.setTextFill(Color.web("#ffffff"));
    
    /* MyProfileLabel.setStyle
     /* cc[cpt].getGroup().set
        (

                "-fx-font-family: \"times\";"

                + "-fx-font-size: 20px;"

                + "-fx-font-style: normal;"

                + "-fx-font-weight: bolder;"
                
                + "-fx-font-float: center;"

        );*/
     Mesc.setStyle

        (

                "-fx-font-family: \"times\";"

                + "-fx-font-size: 20px;"

                + "-fx-font-style: normal;"

                + "-fx-font-weight: bolder;"
                
                + "-fx-font-float: center;"

        );
     
     
      videvide4.setStyle

        (
                 "-fx-font-size: 4px;"

        );
     videvide5.setStyle

        ( "-fx-font-size: 4px;" );
     videvide6.setStyle

        ( "-fx-font-size: 5px;" );
      videvide3.setStyle
        ("-fx-font-size: 5px;");
      vvv.setStyle
        ("-fx-font-size: 5px;");
      vm.setStyle
        ("-fx-font-size: 5px;");
      vl.setStyle
        ("-fx-font-size: 5px;");
      emp.setStyle
        ("-fx-font-size: 1px;");
      emp2.setStyle
        ("-fx-font-size: 1px;");
      emp3.setStyle
        ("-fx-font-size: 1px;");
      
      emp1.setStyle
        ("-fx-font-size: 12px;");
      empp1.setStyle
        ("-fx-font-size: 10px;");
       videvide7.setStyle
        ("-fx-font-size: 17px;");
      
    
     NomTextField=new TextField();
     NomTextField.setMinWidth(Region.USE_PREF_SIZE);
     NomTextField.setMaxWidth(Region.USE_PREF_SIZE);
     NomTextField.setTranslateX(8);
     prenomTextField=new TextField();
     prenomTextField.setMinWidth(Region.USE_PREF_SIZE);
     prenomTextField.setMaxWidth(Region.USE_PREF_SIZE);
     prenomTextField.setTranslateX(8);
     NomTextField1=new TextField();
     NomTextField1.setMinWidth(Region.USE_PREF_SIZE);
     NomTextField1.setMaxWidth(Region.USE_PREF_SIZE);
     NomTextField1.setTranslateX(15);
     prenomTextField1=new TextField();
     prenomTextField1.setMinWidth(Region.USE_PREF_SIZE);
     prenomTextField1.setMaxWidth(Region.USE_PREF_SIZE);
     prenomTextField1.setTranslateX(15);
     ageTextField=new TextField();
     ageTextField.setMinWidth(Region.USE_PREF_SIZE);
     ageTextField.setMaxWidth(Region.USE_PREF_SIZE);
     ageTextField.setTranslateX(8);
     ppp=new TextField();
     ppp.setMinWidth(Region.USE_PREF_SIZE);
     ppp.setMaxWidth(Region.USE_PREF_SIZE);
     ppp.setTranslateX(15);
     pppp=new TextField();
     pppp.setMinWidth(Region.USE_PREF_SIZE);
     pppp.setMaxWidth(Region.USE_PREF_SIZE);
     pppp.setTranslateX(15);
     pppm=new TextField();
     pppm.setMinWidth(Region.USE_PREF_SIZE);
     pppm.setMaxWidth(Region.USE_PREF_SIZE);
     pppm.setTranslateX(15);
     pppl=new TextField();
     pppl.setMinWidth(Region.USE_PREF_SIZE);
     pppl.setMaxWidth(Region.USE_PREF_SIZE);
     pppl.setTranslateX(15);
     
     
     
     

    mmm.setTranslateX(63);
    mmm.setTranslateY(1);
       
       borderPane4.setMaxSize(50, 280);
        
       leftFlapBar2.setTranslateY(-1);
        
       leftFlapBar2.getChildren().addAll(emp1,vl,MyProfileLabel,videvide,videvide1,nomuser,emp,NomTextField,videvide4,prenomuser,emp2,prenomTextField,videvide5,ageuser,emp3,ageTextField,videvide2,videvide3,mmm);
       toolbar3.getItems().addAll( buttonbu);
     
      borderPane4.getChildren().addAll( toolbar3,toolbar4);
     leftFlapBar2.setStyle("-fx-background-color: linear-gradient(from 35% 35% to 90% 90%, #330033, #661a33)");
        leftFlapBar3.setStyle("-fx-background-color: linear-gradient(from 10% 70% to -4% 25%, #330033, #661a33)");
       leftFlapBar3.getChildren().addAll(empp1,videvidee,NomTextField1,videvide3,prenomTextField1,vvv,ppp,vl,pppp,vm,pppm,videvide6,pppl,videvide7,Mesc);
      
       
        
        
	

   
    
   
    
    
    
     Group root= new Group();
     Scene scene = new Scene(root, 1200, 644,Color.DARKGRAY);
  
        
        
        
        
        
    	primaryStage.setTitle("WorkPlace");
    	primaryStage.centerOnScreen();
        
        
        
        stage.setScene(scene);
       
       
        
        
        scene.getStylesheets().addAll(this.getClass().getResource("Cs.css").toExternalForm());
       
         final FileChooser fileChooser = new FileChooser();
        
        
        //Les Raccourcis Clavier *.*
       
        
             
        
    
              
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
     
        

     
   
    

        
       
        
        
        
        //Adding icons to our menu and menuitems         
         Image win = new Image(getClass().getResourceAsStream("windows.bmp"));
         ImageView winview = new ImageView(win);
         winview.setFitWidth(19);
         winview.setFitHeight(19);
         
         
         
         Image zoomavant = new Image(getClass().getResourceAsStream("zoa.png"));
         ImageView zoomav = new ImageView(zoomavant);
         zoomav.setFitWidth(23);
         zoomav.setFitHeight(23);
         
         Image zoomavantt = new Image(getClass().getResourceAsStream("zoom-in.png"));
         ImageView zoomavt = new ImageView(zoomavantt);
         zoomavt.setFitWidth(23);
         zoomavt.setFitHeight(23);
         
         Image zoomarr = new Image(getClass().getResourceAsStream("zoar.png"));
         ImageView zor = new ImageView(zoomarr);
         zor.setFitWidth(23);
         zor.setFitHeight(23);
         
         Image zoomarrt = new Image(getClass().getResourceAsStream("zoom-out.png"));
         ImageView zort = new ImageView(zoomarrt);
         zort.setFitWidth(23);
         zort.setFitHeight(23);
         
         Image one = new Image(getClass().getResourceAsStream("image-4.png"));
          ImageView oneview= new ImageView(one);
         oneview.setFitWidth(25);
         oneview.setFitHeight(25);
         
         
         
         Image two = new Image(getClass().getResourceAsStream("photos.png"));
         ImageView twoview = new ImageView(two);
         twoview.setFitWidth(25);
         twoview.setFitHeight(25);
         
         Image closee = new Image(getClass().getResourceAsStream("cancel-3.png"));
         ImageView closeview = new ImageView(closee);
         closeview.setFitWidth(25);
         closeview.setFitHeight(25);
         
         
         Image fol = new Image(getClass().getResourceAsStream("folder_1.png"));
         ImageView folview = new ImageView(fol);
         folview.setFitWidth(25);
         folview.setFitHeight(25);
         
         
         
         Image proj = new Image(getClass().getResourceAsStream("proj.png"));
         ImageView projview = new ImageView(proj);
         projview.setFitWidth(25);
         projview.setFitHeight(25);
         
         Image nouv= new Image(getClass().getResourceAsStream("folder-3_1.png"));
         ImageView nouvview = new ImageView(nouv);
         nouvview.setFitWidth(25);
         nouvview.setFitHeight(25);
         
         
         Image imp= new Image(getClass().getResourceAsStream("010-technology.png"));
         ImageView impview = new ImageView(imp);
         impview.setFitWidth(25);
         impview.setFitHeight(25);
         
         Image impt= new Image(getClass().getResourceAsStream("010-technology.png"));
         ImageView impviewt = new ImageView(impt);
         impviewt.setFitWidth(23);
         impviewt.setFitHeight(23);
         
         
         
         
         
         
         Image ap= new Image(getClass().getResourceAsStream("app.png"));
         ImageView apview = new ImageView(ap);
         apview.setFitWidth(25);
         apview.setFitHeight(25);
         
         
         
         Image enrs= new Image(getClass().getResourceAsStream("folder-10.png"));
         ImageView enrsview = new ImageView(enrs);
         enrsview.setFitWidth(25);
         enrsview.setFitHeight(25);
         
         Image enrss= new Image(getClass().getResourceAsStream("sos.png"));
         ImageView enrsviews = new ImageView(enrss);
         enrsviews.setFitWidth(25);
         enrsviews.setFitHeight(25);
      
       
         Image enr= new Image(getClass().getResourceAsStream("savee.png"));
         ImageView enrview = new ImageView(enr);
         enrview.setFitWidth(23);
         enrview.setFitHeight(23);
         
         Image plein= new Image(getClass().getResourceAsStream("002-cut.png"));
         ImageView pleinview = new ImageView(plein);
         pleinview.setFitWidth(25);
         pleinview.setFitHeight(25);
      
         
         Image zz= new Image(getClass().getResourceAsStream("search-2.png"));
         ImageView zzview = new ImageView(zz);
         zzview.setFitWidth(25);
         zzview.setFitHeight(25);
         
         
         Image fff= new Image(getClass().getResourceAsStream("folder-6.png"));
         ImageView fffview = new ImageView(fff);
         fffview.setFitWidth(25);
         fffview.setFitHeight(25);
         
         
         Image mise= new Image(getClass().getResourceAsStream("globe_browse.png"));
         ImageView miseview = new ImageView(mise);
         miseview.setFitWidth(25);
         miseview.setFitHeight(25);
         
         Image pref= new Image(getClass().getResourceAsStream("application-help.png"));
         ImageView prefview = new ImageView(pref);
         prefview.setFitWidth(25);
         prefview.setFitHeight(25);
         
         
         Image aide= new Image(getClass().getResourceAsStream("011-communication.png"));
         ImageView aideview = new ImageView(aide);
         aideview.setFitWidth(25);
         aideview.setFitHeight(25);
         
         
         Image folder= new Image(getClass().getResourceAsStream("folder-4.png"));
         ImageView folderview = new ImageView(folder);
         folderview.setFitWidth(29);
         folderview.setFitHeight(26);
         
         
         Image wind= new Image(getClass().getResourceAsStream("windows.png"));
         ImageView windview = new ImageView(wind);
         windview.setFitWidth(29);
         windview.setFitHeight(26);
         
         
         Image copy= new Image(getClass().getResourceAsStream("document_text.png"));
         ImageView copyview = new ImageView(copy);
         copyview.setFitWidth(25);
         copyview.setFitHeight(25);
         
         
         Image pastee= new Image(getClass().getResourceAsStream("clip_paste.png"));
         ImageView pasteeview = new ImageView(pastee);
         pasteeview.setFitWidth(25);
         pasteeview.setFitHeight(25);
         
         
         Image copyt= new Image(getClass().getResourceAsStream("document_text.png"));
         ImageView copyviewt = new ImageView(copyt);
         copyviewt.setFitWidth(25);
         copyviewt.setFitHeight(25);
         
         
         Image pasteet= new Image(getClass().getResourceAsStream("clip_paste.png"));
         ImageView pasteeviewt = new ImageView(pasteet);
         pasteeviewt.setFitWidth(25);
         pasteeviewt.setFitHeight(25);
         
          Image sel= new Image(getClass().getResourceAsStream("001-photo-1.png"));
         ImageView selview = new ImageView(sel);
         selview.setFitWidth(25);
         selview.setFitHeight(25);
         
         Image selt= new Image(getClass().getResourceAsStream("3d.png"));
         ImageView selviewt = new ImageView(selt);
         selviewt.setFitWidth(25);
         selviewt.setFitHeight(25);
         
         Image seltt= new Image(getClass().getResourceAsStream("select-2.png"));
         ImageView selviewtt = new ImageView(seltt);
         selviewtt.setFitWidth(25);
         selviewtt.setFitHeight(25);
         
         
         Image impo= new Image(getClass().getResourceAsStream("image-5.png"));
         ImageView impoview = new ImageView(impo);
         impoview.setFitWidth(25);
         impoview.setFitHeight(25);
         
     
         
         
         
         Image openn = new Image(getClass().getResourceAsStream("folder-2.png"));
         ImageView openview = new ImageView(openn);
         openview.setFitWidth(25);
         openview.setFitHeight(25);
         
         
         Image su = new Image(getClass().getResourceAsStream("005-delete.png"));
         ImageView suview = new ImageView(su);
         suview.setFitWidth(25);
         suview.setFitHeight(25);
         
         Image preff= new Image(getClass().getResourceAsStream("settings-gears.png"));
         ImageView pview = new ImageView(preff);
         pview.setFitWidth(25);
         pview.setFitHeight(25);
         
         
         Image esc= new Image(getClass().getResourceAsStream("cursor-13.png"));
         ImageView escview = new ImageView(esc);
         escview.setFitWidth(25);
         escview.setFitHeight(25);
         
         Image arrow= new Image(getClass().getResourceAsStream("001-arrow.png"));
         ImageView arrowview = new ImageView(arrow);
         arrowview.setFitWidth(21);
         arrowview.setFitHeight(21);
         
         
         Image hand= new Image(getClass().getResourceAsStream("mm.png"));
         ImageView handview = new ImageView(hand);
         handview.setFitWidth(21);
         handview.setFitHeight(21);
         
         
         Image ong= new Image(getClass().getResourceAsStream("ongg.png"));
         ImageView ongview = new ImageView(ong);
         ongview.setFitWidth(29);
         ongview.setFitHeight(26);
         
         
         Image coup= new Image(getClass().getResourceAsStream("CCC.png"));
         ImageView coupview = new ImageView(coup);
         coupview.setFitWidth(25);
         coupview.setFitHeight(25);
         
         
         Image coupt= new Image(getClass().getResourceAsStream("CC.png"));
         ImageView coupviewt = new ImageView(coupt);
         coupviewt.setFitWidth(25);
         coupviewt.setFitHeight(25);
         
         
         
         Image retour= new Image(getClass().getResourceAsStream("back-arrow.png"));
         ImageView retourview = new ImageView(retour);
         retourview.setFitWidth(21);
         retourview.setFitHeight(21);
         
         Image ai= new Image(getClass().getResourceAsStream("icon.png"));
         ImageView aiview = new ImageView(ai);
         aiview.setFitWidth(21);
         aiview.setFitHeight(21);
         
         Image mini= new Image(getClass().getResourceAsStream("minimize-2.png"));
         ImageView miniview = new ImageView(mini);
         miniview.setFitWidth(23);
         miniview.setFitHeight(23);
         
         
         Image retourr= new Image(getClass().getResourceAsStream("b.png"));
         ImageView retourrview = new ImageView(retourr);
         retourrview.setFitWidth(21);
         retourrview.setFitHeight(21);
         
         
         Image pain= new Image(getClass().getResourceAsStream("coll.png"));
         ImageView painview = new ImageView(pain);
         painview.setFitWidth(25);
         painview.setFitHeight(25);
         
         Image paint= new Image(getClass().getResourceAsStream("pppp.png"));
         ImageView painviewt = new ImageView(paint);
         painviewt.setFitWidth(25);
         painviewt.setFitHeight(25);
         
         Image hhh= new Image(getClass().getResourceAsStream("???.png"));
         ImageView hhhview = new ImageView(hhh);
         hhhview.setFitWidth(23);
         hhhview.setFitHeight(23);
         
         
         Image qst= new Image(getClass().getResourceAsStream("help.png"));
         ImageView qstview = new ImageView(qst);
         qstview.setFitWidth(23);
         qstview.setFitHeight(23);
         
         Image crptw= new Image(getClass().getResourceAsStream("cursor-15.png"));
         ImageView crptvieww = new ImageView(crptw);
         crptvieww.setFitWidth(23);
         crptvieww.setFitHeight(23);
         
         Image ajtpt= new Image(getClass().getResourceAsStream("cursor.png"));
         ImageView ajtptview = new ImageView(ajtpt);
         ajtptview.setFitWidth(25);
         ajtptview.setFitHeight(25);
         
         Image ajtptw= new Image(getClass().getResourceAsStream("cursor-14.png"));
         ImageView ajtptvieww = new ImageView(ajtptw);
         ajtptvieww.setFitWidth(23);
         ajtptvieww.setFitHeight(23);
         
         Image deppt= new Image(getClass().getResourceAsStream("move-3.png"));
         ImageView depptview = new ImageView(deppt);
         depptview.setFitWidth(25);
         depptview.setFitHeight(25);
         
          Image depptw= new Image(getClass().getResourceAsStream("move-3.png"));
         ImageView depptvieww = new ImageView(depptw);
         depptvieww.setFitWidth(23);
         depptvieww.setFitHeight(23);
         
         
         Image suppt= new Image(getClass().getResourceAsStream("round-delete-button.png"));
         ImageView supptview = new ImageView(suppt);
         supptview.setFitWidth(25);
         supptview.setFitHeight(25);
         
         Image fercb= new Image(getClass().getResourceAsStream("cursor-moving-line-3.png"));
         ImageView fercbview = new ImageView(fercb);
         fercbview.setFitWidth(25);
         fercbview.setFitHeight(25);
         
         
         Image scrr= new Image(getClass().getResourceAsStream("iooo.png"));
         ImageView scrview = new ImageView(scrr);
         scrview.setFitWidth(25);
         scrview.setFitHeight(25);
         
         Image fercbw= new Image(getClass().getResourceAsStream("cursor-moving-line.png"));
         ImageView fercbvieww = new ImageView(fercbw);
         fercbvieww.setFitWidth(23);
         fercbvieww.setFitHeight(23);
         
         Image crpt= new Image(getClass().getResourceAsStream("click-9.png"));
         ImageView crptview = new ImageView(crpt);
         crptview.setFitWidth(26);
         crptview.setFitHeight(26);
         
          Image scrw= new Image(getClass().getResourceAsStream("ioo.png"));
         ImageView scrvieww = new ImageView(scrw);
         scrvieww.setFitWidth(23);
         scrvieww.setFitHeight(23);
         
         Image ptt= new Image(getClass().getResourceAsStream("click-8.png"));
         ImageView pttview = new ImageView(ptt);
         pttview.setFitWidth(25);
         pttview.setFitHeight(25);
         
         Image crbb= new Image(getClass().getResourceAsStream("growth-2.png"));
         ImageView crbbview = new ImageView(crbb);
         crbbview.setFitWidth(26);
         crbbview.setFitHeight(26);
         
         Image app= new Image(getClass().getResourceAsStream("approved-4.png"));
         ImageView appview = new ImageView(app);
         appview.setFitWidth(25);
         appview.setFitHeight(25);
        
        
        
        
        
        MenuBar menuBar = new MenuBar(); 
        
       
        menuBar.prefWidthProperty().bind(primaryStage.widthProperty());
        
      //Creation d'un MenuBar
        Menu Menu1 = new Menu("_3DOGRAPHIE  "); 
         Menu1.setStyle

       (

               "-fx-font-family: \"arial\";"

               + "-fx-font-size: 14px;"

               + "-fx-font-style: normal;"

               + "-fx-font-weight: bolder;"
               
               + "-fx-font-float: center;"

       );
        
        
        MenuItem apropos = new MenuItem("  A Propos       ",appview);
        
        apropos.setAccelerator(new KeyCodeCombination(KeyCode.A, KeyCombination.CONTROL_DOWN));
        apropos.setOnAction(e-> AproposBox.display("A propos  "));
        
        
        
        
        MenuItem fermer = new MenuItem("  Fermer          ");
        fermer.setGraphic(closeview);
        
        fermer.setAccelerator(new KeyCodeCombination(KeyCode.F, KeyCombination.CONTROL_DOWN));
      
   
        
        
        fermer.setOnAction((ActionEvent event) -> {
            showConfirmation(primaryStage);
           });
     
        
       

        MenuItem p = new MenuItem("  Pr√©ferences            ",pview);
        
        p.setAccelerator(new KeyCodeCombination(KeyCode.P, KeyCombination.ALT_DOWN, KeyCombination.CONTROL_DOWN));
        Menu1.getItems().addAll(apropos,p,new SeparatorMenuItem(),fermer);
        

        
        
            
         
         
         
         Menu Menu2 = new Menu("_Fichier  "); 
         //Son menuitem
         
         
         
         Menu nouveau =new Menu("  Nouveau  ",nouvview);
         nouveau.setAccelerator(new KeyCodeCombination(KeyCode.N, KeyCombination.CONTROL_DOWN));
         MenuItem project = new MenuItem("  Projet   ",projview);
         
          project.setOnAction((final ActionEvent e) -> { 
            
        	  
        	  File file = new File("Projet n∞01");
              if (!file.exists()) {
                  if (file.mkdir()) {
                      System.out.println("Directory is created!");
                  } else {
                      System.out.println("Failed to create directory!");
                  }
             
              }
        	  
        	  
        	  
       cpt++;
                     
       
           Employee employee=  new Employee(" Onglet n¬∞"+cpt, " Projet n¬∞01 ");
                  
        TreeItem<String> empLeaf = new TreeItem<String>(employee.getName());
            boolean found = false;
            for (TreeItem<String> depNode : rootNode.getChildren()) {
                if (depNode.getValue().contentEquals(employee.getDepartment())){
                    depNode.getChildren().add(empLeaf);
                    found = true;
                    
                   
                    break;
                }
            }
            
              
            if (!found) {
                TreeItem depNode = new TreeItem(employee.getDepartment(),
                    new ImageView(depIcon)
                );
                rootNode.getChildren().addAll(depNode);
                depNode.getChildren().addAll(empLeaf);
                depNode.setExpanded(true);
               
            }
       
       
                     tabPane.getTabs().add(new Tab("Onglet n¬∞"+cpt));
        
      
       
      
             
           
        
         
         
          treeView.getSelectionModel().selectedItemProperty().addListener((observable, oldValue, newValue) -> {
       if(newValue != null && newValue != oldValue){
    		
    
    	   String cchaine=treeView.getSelectionModel().selectedItemProperty().getValue().getValue();
    	   System.out.println(cchaine);
    	   String chaine11="";
    	   for(int i=11;i<cchaine.length();i++) {
    	      chaine11+=cchaine.charAt(i);
    	   }
    	    	  Scanner scanner = new Scanner(chaine11);
    	    	  int value = scanner.nextInt();
    	    	  System.out.println(value);
    	        	tabPane.getSelectionModel().select(value-1);
        	
        	
        	
         
    
   
           
    }
       
      
      
   });
         
         
     
          
          
          });       
         

         
         
         
         
         project.setAccelerator(new KeyCodeCombination(KeyCode.P, KeyCombination.CONTROL_DOWN));
         MenuItem fenfen  = new MenuItem("  Fenetre    ",winview);
         fenfen.setAccelerator(new KeyCodeCombination(KeyCode.W, KeyCombination.CONTROL_DOWN));
         fenfen.setOnAction((final ActionEvent e) -> { 
            
        	
         
           Stage stg= new Stage();
             try {
				this.start(stg);
			} catch (FileNotFoundException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			} catch (InterruptedException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
             
          	
        });
         
         nouveau.getItems().addAll(project,fenfen);
     
         MenuItem ouvrir = new MenuItem("  Ouvrir    ");
         ouvrir.setAccelerator(new KeyCodeCombination(KeyCode.O, KeyCombination.CONTROL_DOWN));
         ouvrir.setGraphic(folview);
         ouvrir.setOnAction(new EventHandler<ActionEvent>()
         {            
             @Override
             public void handle(ActionEvent event)
             {        
                //Load the tree structure into the old treeView
                treeView.setRoot(loadTree());
             }
         });


         MenuItem save = new MenuItem("  Enregistrer    ",enrsviews);
         save.setAccelerator(new KeyCodeCombination(KeyCode.E, KeyCombination.CONTROL_DOWN));
         save.setOnAction(new EventHandler<ActionEvent>()
         {            
             @Override
             public void handle(ActionEvent event)
             {
                 //If the file exist delete it and save new info
                FileChooser fileChooser = new FileChooser();
             
             //Set extension filter
             FileChooser.ExtensionFilter extFilter = 
                 new FileChooser.ExtensionFilter("TXT files (*.txt)", "*.txt");
             fileChooser.getExtensionFilters().add(extFilter);
             
             //Show save file dialog
             File file = fileChooser.showSaveDialog(primaryStage);
             
                 if(file.exists()) {
                    file.delete();     
                 }
                 saveParentAndChildren(rootNode, "root");
             }
        
         });
         
         MenuItem ffff = new MenuItem("  Fermer Projet    ",fffview);
           
        
         
         ffff.setAccelerator(new KeyCodeCombination(KeyCode.F,KeyCombination.ALT_DOWN, KeyCombination.CONTROL_DOWN));
         MenuItem impp = new MenuItem("  Imprimer    ",impview);
          impp.setOnAction((final ActionEvent e) -> { 
        
        	
             
             if (cpt==tabPane.getSelectionModel().getSelectedIndex()+1) {
            	 print(cc[cpt].getGroup());
          	}else
          	{
          		cpt=tabPane.getSelectionModel().getSelectedIndex()+1;          		
          		zoomPane=createZoomPane(cc[cpt].getGroup());
          	tabPane.getSelectionModel().getSelectedItem().setContent(zoomPane);
          	 print(cc[cpt].getGroup());
          	}
        });
        
         
     
         
         
         
         
         
         impp.setAccelerator(new KeyCodeCombination(KeyCode.I, KeyCombination.CONTROL_DOWN));
         
         
         
         ffff.setOnAction((ActionEvent event) -> {
             showConfirmation1(primaryStage);
            });
         
         
         

         
         
          Menu2.getItems().addAll(nouveau,ouvrir,save,impp,new SeparatorMenuItem(),ffff);
          
         
        
          
         
         
          /* ************************************************************************************ */
          
          Menu Menu3 = new Menu("_Edition  "); 
          
          
          Menu pppoint =new Menu("  Point  ",pttview);
          
         
            MenuItem crcr =new MenuItem("  Cr√©er point ",crptview);
            
           
            MenuItem ajtajt =new MenuItem("  Ajouter point ",ajtptview);
            
            
            
            
            MenuItem deppp =new MenuItem("  D√©placer point ",depptview);
            
           
            

           MenuItem supp = new MenuItem("  Supprimer point ",supptview);
           
          
           
           
           
         
           pppoint.getItems().addAll(crcr,ajtajt,deppp,supp);
          
           
          
          
          
          
          
           
           
           
           
           
           
           Menu cccourb =new Menu("  Courbe  ",crbbview);
          
            MenuItem crbcrb =new MenuItem(" Fermer la courbe ",fercbview);
             MenuItem scr =new MenuItem(" Sauvegarde Courbe",scrview);
            
            
   
           cccourb.getItems().addAll(crbcrb,scr);
        
         
         MenuItem copyy = new MenuItem("  Copier   ");
         copyy.setGraphic(copyview);
         copyy.setAccelerator(new KeyCodeCombination(KeyCode.C, KeyCombination.CONTROL_DOWN));
         MenuItem paste = new MenuItem("  Coller   ",pasteeview);
         paste.setGraphic(pasteeview);
         paste.setAccelerator(new KeyCodeCombination(KeyCode.V, KeyCombination.CONTROL_DOWN));
         MenuItem couper = new MenuItem("  Couper   ",coupview);
         couper.setAccelerator(new KeyCodeCombination(KeyCode.X, KeyCombination.CONTROL_DOWN));
         couper.setGraphic(coupview);
        
         
         
        
         
         
         
         Menu3.getItems().addAll(pppoint,cccourb,copyy,paste,couper);
         
          
          
          
          
        
         
         
         
         
         
         Menu Menu4 = new Menu("_Affichage  "); 
         //son menuitem
         
         
         Menu zoom =new Menu("  Zoom  ");
         zoom.setGraphic(zzview);
         
            MenuItem zoomin =new MenuItem("  Zoom avant  ",zoomavt);
            zoomin.setAccelerator(new KeyCodeCombination(KeyCode.ADD,KeyCombination.CONTROL_DOWN));

            zoomin.setOnAction((ActionEvent event) -> {
            	
            	
            	
            	if (cpt==tabPane.getSelectionModel().getSelectedIndex()+1) {
            		cc[cpt].getGroup().setScaleX( cc[cpt].getGroup().getScaleX()*1.5);
            		cc[cpt].getGroup().setScaleY( cc[cpt].getGroup().getScaleY()*1.5);
           		 cc[cpt].getUndofx().Inc();
            		 cc[cpt].getUndofx().setChoix("zoumIn");
    		
            	
            	}else
            	{
            		cpt=tabPane.getSelectionModel().getSelectedIndex()+1;            		
            		zoomPane=createZoomPane(cc[cpt].getGroup());
            	tabPane.getSelectionModel().getSelectedItem().setContent(zoomPane);            	
            	cc[cpt].getGroup().setScaleX( cc[cpt].getGroup().getScaleX()*1.5);
            	cc[cpt].getGroup().setScaleY( cc[cpt].getGroup().getScaleY()*1.5);
       		 cc[cpt].getUndofx().Inc();
            	 cc[cpt].getUndofx().setChoix("zoumIn");
            	}
            
            });
 
            
            MenuItem zoomout = new MenuItem("  Zoom arriÍre  ",zort);
        	
            zoomout.setAccelerator(new KeyCodeCombination(KeyCode.SUBTRACT,KeyCombination.CONTROL_DOWN));
            zoomout.setOnAction((ActionEvent event) -> {
            	if (cpt==tabPane.getSelectionModel().getSelectedIndex()+1) {
            		cc[cpt].getGroup().setScaleX( cc[cpt].getGroup().getScaleX()*1/1.5);
            		cc[cpt].getGroup().setScaleY( cc[cpt].getGroup().getScaleY()*1/1.5);
           		 cc[cpt].getUndofx().Inc();
            		cc[cpt].getUndofx().setChoix("zoumOut");
            	}else
            	{
            		cpt=tabPane.getSelectionModel().getSelectedIndex()+1;
            		
            	
            		zoomPane=createZoomPane(cc[cpt].getGroup());
            	tabPane.getSelectionModel().getSelectedItem().setContent(zoomPane);
            	
            	cc[cpt].getGroup().setScaleX( cc[cpt].getGroup().getScaleX()*1/1.5);
            	cc[cpt].getGroup().setScaleY( cc[cpt].getGroup().getScaleY()*1/1.5);
       		 cc[cpt].getUndofx().Inc();
            	cc[cpt].getUndofx().setChoix("zoumOut");
            	}
            });

         
         zoom.getItems().addAll(zoomin,zoomout);
         
         
         MenuItem plec = new MenuItem("  Plein Ècran  ");
         plec.setGraphic(pleinview);
         
         plec.setOnAction((ActionEvent event) -> {
             primaryStage.setMaximized(true);
            });
         
         
         
       
         
         
         MenuItem  re= new MenuItem("  RÈduire fenÍtre",miniview);
         
         
         re.setOnAction(new EventHandler<ActionEvent>() {
	        	 @Override

	 			public void handle(ActionEvent event) {

	 				primaryStage.sizeToScene();

	 			}
	        	 
	         });

                 
         
         
         
         Menu4.getItems().addAll(zoom,plec,re);
      
         
         Menu Menu5= new Menu("_Importation  "); 
         //son menuitem
         
         MenuItem image = new MenuItem("  Image   ");
         image.setGraphic(oneview);
         image.setOnAction((final ActionEvent e) -> {
             configureFileChooser(fileChooser);
             File filee = new File("Projet n∞01");
             if (!filee.exists()) {
                 if (filee.mkdir()) {
                     System.out.println("Directory is created!");
                 } else {
                     System.out.println("Failed to create directory!");
                 }}
             File file = fileChooser.showOpenDialog(stage);
             if (file != null) {
                 try {
                	 
                	 
                	  pf=new Openfile();
                	 
                     cpt++;
                     Employee employee=  new Employee(" Onglet n¬∞"+cpt, " Projet n¬∞01 ");
                     
                     TreeItem<String> empLeaf = new TreeItem<String>(employee.getName());
                         boolean found = false;
                         for (TreeItem<String> depNode : rootNode.getChildren()) {
                             if (depNode.getValue().contentEquals(employee.getDepartment())){
                                 depNode.getChildren().add(empLeaf);
                                 found = true;
                                 
                                
                                 break;
                             }
                         }
                         
                           
                         if (!found) {
                             TreeItem depNode = new TreeItem(employee.getDepartment(),
                                 new ImageView(depIcon)
                             );
                             rootNode.getChildren().addAll(depNode);
                             depNode.getChildren().addAll(empLeaf);
                             depNode.setExpanded(true);
                         }
                    
                     openFile(file,tabPane, new Tab("Onglet "+cpt),pf);
                     pf.setTabIndex(cpt);
                     cc[cpt]=pf;
                     treeView.getSelectionModel().selectedItemProperty().addListener((observable, oldValue, newValue) -> {
                         if(newValue != null && newValue != oldValue){
                      		
                      
                      	   String cchaine=treeView.getSelectionModel().selectedItemProperty().getValue().getValue();
                      	   System.out.println(cchaine);
                      	   String chaine11="";
                      	   for(int i=11;i<cchaine.length();i++) {
                      	      chaine11+=cchaine.charAt(i);
                      	   }
                      	    	  Scanner scanner = new Scanner(chaine11);
                      	    	  int value = scanner.nextInt();
                      	    	  System.out.println(value);
                      	        	tabPane.getSelectionModel().select(value-1);
                          	
                          	
                          	
                           
                      
                     
                             
                      }
                         
                        
                        
                     });
                     
                 } catch (FileNotFoundException e1) {
                     // TODO Auto-generated catch block
                     e1.printStackTrace();
                 }
             }
            });
      
      
         
         
         
         
         
         MenuItem pimage = new MenuItem("  Plusieurs images   ");
         pimage.setGraphic(twoview);
         pimage.setOnAction((final ActionEvent e) -> {
             configureFileChooser(fileChooser);
             File filee = new File("Projet n∞01");
             if (!filee.exists()) {
                 if (filee.mkdir()) {
                     System.out.println("Directory is created!");
                 } else {
                     System.out.println("Failed to create directory!");
                 }}
             List<File> list =
                     fileChooser.showOpenMultipleDialog(stage);
             if (list != null) {
                 for (File file : list) {
                     try {
                    	 pf=new Openfile();
                    	 
                         cpt++;
                         Employee employee=  new Employee(" Onglet n¬∞"+cpt, " Projet n¬∞01 ");
                         
                         TreeItem<String> empLeaf = new TreeItem<String>(employee.getName());
                             boolean found = false;
                             for (TreeItem<String> depNode : rootNode.getChildren()) {
                                 if (depNode.getValue().contentEquals(employee.getDepartment())){
                                     depNode.getChildren().add(empLeaf);
                                     found = true;
                                     
                                    
                                     break;
                                 }
                             }
                             
                               
                             if (!found) {
                                 TreeItem depNode = new TreeItem(employee.getDepartment(),
                                     new ImageView(depIcon)
                                 );
                                 rootNode.getChildren().addAll(depNode);
                                 depNode.getChildren().addAll(empLeaf);
                                 depNode.setExpanded(true);
                             }
                        
                         openFile(file,tabPane, new Tab("Onglet "+cpt),pf);					
                         cc[cpt]=pf;
                         treeView.getSelectionModel().selectedItemProperty().addListener((observable, oldValue, newValue) -> {
                             if(newValue != null && newValue != oldValue){
                          		
                          
                          	   String cchaine=treeView.getSelectionModel().selectedItemProperty().getValue().getValue();
                          	   System.out.println(cchaine);
                          	   String chaine11="";
                          	   for(int i=11;i<cchaine.length();i++) {
                          	      chaine11+=cchaine.charAt(i);
                          	   }
                          	    	  Scanner scanner = new Scanner(chaine11);
                          	    	  int value = scanner.nextInt();
                          	    	  System.out.println(value);
                          	        	tabPane.getSelectionModel().select(value-1);
                              	
                              	
                              	
                               
                          
                         
                                 
                          }
                             
                           
                            
                         });
                         } catch (FileNotFoundException e1) {
                             // TODO Auto-generated catch block
                             e1.printStackTrace();
                         }
                 }
             }
            });
         
         
         
         
         
         
         
         
         
         Menu5.getItems().addAll(image,pimage);
         
         
         
         Menu Menu6 = new Menu("_Aide  ");  
         //son menuitem
         
         
         MenuItem comm = new MenuItem("  Commentaires    ");
         comm.setGraphic(aideview);
         comm.setOnAction(e-> AideBox.displayy(" Commentaires  "));
         
         
         MenuItem helpp = new MenuItem("  Aide    ",aiview);
         
         helpp.setOnAction(e-> AideBox.displayy(" Aide  "));
         
         
         
         
         
         Menu6.getItems().addAll(comm,helpp);
      
         
       
         menuBar.getMenus().addAll(Menu1, Menu2, Menu5,Menu3,Menu4,Menu6);
        
        
        //Realisation De La Barre d'outils
        
        Button     i1   = new Button("",folderview);
        Button     i2   = new Button("",windview);
        Button     i3   = new Button("",ongview);
        Separator  i4   = new Separator();
        Button     i5   = new Button("",openview);
        Button     i6   = new Button("",impoview);
        Separator  i7   = new Separator();
        Button     i8   = new Button("",arrowview);
        Button     i9   = new Button("",handview);
        Button     i10  = new Button("",retourview);
        Button     i11  = new Button("",retourrview);
        Separator  i12  = new Separator();
        Button     i13  = new Button("",copyviewt);
        Button     i14  = new Button("",pasteeviewt);
        Button     i15  = new Button("",coupviewt);
       
        Button     i17  = new Button("",selviewt);
        Button     i18  = new Button("",zoomav);
        Button     i19  = new Button("",zor);
        Button     i20  = new Button("",escview);
        Separator  i21  = new Separator();            
        Button     i22  = new Button("",enrview);
        Button     i23  = new Button("",impviewt);
        Button     i24  = new Button("",hhhview);
        Button     i25  = new Button("",crptvieww);
        Button     i26  = new Button("",ajtptvieww);
        Button     i27  = new Button("",depptvieww); 
        Button     i28  = new Button("",fercbvieww);             
        Separator  i29  = new Separator() ;
        Button     i30  = new Button("",scrvieww);
        Separator  i31  = new Separator() ;
                    
         
         
          
                       //Ajouter Les Fonctionnalit√às
                       
                  i1.setTooltip(new Tooltip(" Nouveau Projet"));
                  i2.setTooltip(new Tooltip(" Nouvelle Fen√çtre"));    
                  i3.setTooltip(new Tooltip(" Nouvel Onglet"));     
                  
                  i5.setTooltip(new Tooltip(" Ouvrir "));     
                  i6.setTooltip(new Tooltip(" Importer Image "));     
                  i8.setTooltip(new Tooltip(" Curseur ")); 
                  i9.setTooltip(new Tooltip(" Main"));  
                  i10.setTooltip(new Tooltip(" Annuler "));     
                  i11.setTooltip(new Tooltip("Refaire"));     
                 
                  i13.setTooltip(new Tooltip(" Copier"));     
                  i14.setTooltip(new Tooltip(" Coller "));     
                  i15.setTooltip(new Tooltip(" Couper "));     
                   
                  i17.setTooltip(new Tooltip(" 3D "));     
                  i18.setTooltip(new Tooltip(" Zoom Avant "));     
                  i19.setTooltip(new Tooltip(" Zoom Arri√®re "));     
                  i20.setTooltip(new Tooltip(" Supprimer point"));     
                  i22.setTooltip(new Tooltip(" Enregistrer "));  
                  i23.setTooltip(new Tooltip(" Imprimer")); 
                  i24.setTooltip(new Tooltip(" Aide ")); 
                  i25.setTooltip(new Tooltip(" Cr√©er point "));
                  i26.setTooltip(new Tooltip(" Ajouter point "));
                  i27.setTooltip(new Tooltip(" DÈplacer point  "));
                  i28.setTooltip(new Tooltip(" Fermer la courbe "));
                  i30.setTooltip(new Tooltip(" Sauvegarder la courbe "));

          ToolBar  toolBar = 
              new ToolBar(i1,i2,i3,i4, i5,i6,i7,i25,i26,i20,i27,i28,i30,i29,i17,i31,i8,i9,i10,i11,i12,i13,i14,i15,i18,i19,i21,i22,i23,i24);

          i5.setOnAction(new EventHandler<ActionEvent>()
          {            
              @Override
              public void handle(ActionEvent event)
              {        
                 //Load the tree structure into the old treeView
                 treeView.setRoot(loadTree());
              }
          });

          
          
           i17.setOnAction(ActionEvent->{
        	   if (cc[cpt].getLL().size()!=0)Draw0(cc[cpt].getLL(),cc[cpt].getGroup(),cc[cpt].getRelier());
                DrawDanlaury(cc[cpt].getLL(),cc[cpt].getGroup());
                cc[cpt].getGroup().setRotate(180);
              /* Sample1 Sp=new Sample1();
              Sp.createModel(cc[cpt].getGroup());
              Sp.start(stage);*/
              NetMusic t= new NetMusic();
              t.setGrp(cc[cpt].group);
              t.start(stage);
              
           });
      
          
           
                        //Ajouter Les FonctionnalitÈs
                      
                       i13.setOnAction(actionEvent->{
                    	   if (cpt==tabPane.getSelectionModel().getSelectedIndex()+1) {
                    		 
              				 
                    		   cc[cpt].setSelection();

              				
              				
                       	}else
                       	{
                       		cpt=tabPane.getSelectionModel().getSelectedIndex()+1;
                       		zoomPane=createZoomPane(cc[cpt].getGroup());
                       	tabPane.getSelectionModel().getSelectedItem().setContent(zoomPane);
                       
            	       
                       
                       	cc[cpt].setSelection();
                 		 
                            
                       	}
                       });
                     
         
 ////******************** AJOUTER UN POINT **********************/
                        i26.setOnAction(ActionEvent->{
                       	  if (cpt==tabPane.getSelectionModel().getSelectedIndex()+1) {
                       	
                                    
                              			  
                              				  Point D =new Point () ;
                                          		 cc[cpt].getGroup().setOnMouseClicked(new EventHandler<MouseEvent>(){
                                                       public void handle (MouseEvent me){
                                                      	
                                                       	   if(me.getClickCount() == 2 )    {
                                                       	
                                                     		   if (bool.bool==false) {
                                                     			bezier ss=new bezier() ;
                                                     			System.out.println(me.getTarget().getClass());
                                                     			   if (ss.getClass()==me.getTarget().getClass()) {
                                                     				  cc[cpt].getUndofx().Inc();
                                                                      cc[cpt].getUndofx().setChoix("ajout");			
                                           	        				cc[cpt].getUndofx().setX_Y(me.getX(), me.getY());
                                                     			 D.set(me.getX(), me.getY()); 
                                                     			 ss=(bezier)me.getTarget();
                                                     			bezier c1 =new bezier(ss.getStartX(),ss.getStartY(),me.getX(),me.getY()) ;
                                                     			
                                                     			c1.setControlX1(ss.getControlX1());
                                                     			c1.setControlY1(ss.getControlY1());
                                                     			
                                                     			bezier c2 =new bezier(me.getX(),me.getY(),ss.getEndX(),ss.getEndY()) ;
                                                     		
                                                     			c2.setControlX2(ss.getControlX2());
                                                     			c2.setControlY2(ss.getControlY2());
                                                     			
                                                     			
                                                     			if (cc[cpt].getK().getList().indexOf(ss)+1>=cc[cpt].getK().getList().size()) {
                                                     				cc[cpt].getK().getList().add(c1);
                                                         			cc[cpt].getK().getList().add(c2);
                                                     			}else{
                                                     				cc[cpt].getK().getList().add(cc[cpt].getK().getList().indexOf(ss),c1);
                                                         			cc[cpt].getK().getList().add(cc[cpt].getK().getList().indexOf(ss)+1,c2);
                                                     			}
                                                     			cc[cpt].getK().getList().remove(ss) ;
                                                     			if (cc[cpt].getLL().size()!=0)Draw(cc[cpt].getLL() ,cc[cpt].getGroup(),cc[cpt].getRelier()) ;
                                                     			else cc[cpt].getGroup().getChildren().remove(1, cc[cpt].getGroup().getChildren().size()); 
                               		                		Draw1(cc[cpt].getK().getList() ,cc[cpt].getGroup(),cc[cpt].getRelier()) ;
                                                     			 
                                                     			   }
                                                     		   }
                                                       	   }
                                          	 } });
                               	 
                                          		 
                              			  
                              			 
                                     		 
                                     	
                               	 
                                     	 
                                    	  
                      	
                       	  }
                       	 else {
               				cpt=tabPane.getSelectionModel().getSelectedIndex()+1;
                       		
                       		zoomPane=createZoomPane(cc[cpt].getGroup());
                       	tabPane.getSelectionModel().getSelectedItem().setContent(zoomPane);
                       	
               				  Point D =new Point () ;
                           		 cc[cpt].getGroup().setOnMouseClicked(new EventHandler<MouseEvent>(){
                                        public void handle (MouseEvent me){
                                       	
                                        	   if(me.getClickCount() == 2 )    {
                                        	
                                      		   if (bool.bool==false) {
                                      			bezier ss=new bezier() ;
                                      			System.out.println(me.getTarget().getClass());
                                      			   if (ss.getClass()==me.getTarget().getClass()) {
                                      				 cc[cpt].getUndofx().Inc();
                                                     cc[cpt].getUndofx().setChoix("ajout");			
                          	        				cc[cpt].getUndofx().setX_Y(me.getX(), me.getY());
                                      			 D.set(me.getX(), me.getY()); 
                                      			 ss=(bezier)me.getTarget();
                                      			bezier c1 =new bezier(ss.getStartX(),ss.getStartY(),me.getX(),me.getY()) ;
                                      			
                                      			c1.setControlX1(ss.getControlX1());
                                      			c1.setControlY1(ss.getControlY1());
                                      			
                                      			bezier c2 =new bezier(me.getX(),me.getY(),ss.getEndX(),ss.getEndY()) ;
                                      		
                                      			c2.setControlX2(ss.getControlX2());
                                      			c2.setControlY2(ss.getControlY2());
                                      			
                                      			
                                      			if (cc[cpt].getK().getList().indexOf(ss)+1>=cc[cpt].getK().getList().size()) {
                                      				cc[cpt].getK().getList().add(c1);
                                          			cc[cpt].getK().getList().add(c2);
                                      			}else{
                                      				cc[cpt].getK().getList().add(cc[cpt].getK().getList().indexOf(ss),c1);
                                          			cc[cpt].getK().getList().add(cc[cpt].getK().getList().indexOf(ss)+1,c2);
                                      			}
                                      			cc[cpt].getK().getList().remove(ss) ;
                                      			if (cc[cpt].getLL().size()!=0)Draw(cc[cpt].getLL() ,cc[cpt].getGroup(),cc[cpt].getRelier()) ;
                                      			else cc[cpt].getGroup().getChildren().remove(1, cc[cpt].getGroup().getChildren().size()); 
                		                		Draw1(cc[cpt].getK().getList() ,cc[cpt].getGroup(),cc[cpt].getRelier()) ;
                                      			 
                                      			   }
                                      		   }
                                        	   }
                           	 } });
                           		 
                           		
               			  }
                      	
                       });
                        
        
        /************************* SAUVGARDE **************************************/
        
        i30.setOnAction(ActionEvent->{
		   
		   
		    	try {
		    		 if (cpt==tabPane.getSelectionModel().getSelectedIndex()+1) {
	 		    		 Fenetre.display(cc[cpt].getK());
	    				 System.out.println(cc[cpt].getK().getNom()+" "+cc[cpt].getK().getAltitude());
	                     cc[cpt].getLL().add(cc[cpt].getK()) ; 
	                     cc[cpt].getB().set(0, 0);
	                   
	                   
	                    
	                     try {
	            	            System.out.println("donnez le nom du fichier");
	                         String Filename = cc[cpt].getK().getNom();
	                         System.out.println(cc[cpt].getK().getNom());
	            				FileWriter fichier = new FileWriter(Filename);
	            				BufferedWriter fichierwrite = new BufferedWriter( fichier);
	            				
	            				int k =cc[cpt].getK().getList().size();
	            				System.out.println(" lll nb elem is "+k);
	            				FileReader fichierread = new FileReader(Filename);
	            				BufferedReader fich = new BufferedReader(fichierread);
	            			     System.out.println("im in tryyyy");
	            				
	            				for( int b=0;b<k;b++) {
	            				 System.out.println("im in while");
	            			
	            				 fichier.write(""+cc[cpt].getK().getList().get(b).getStartX());
	        					 fichier.write(" "+cc[cpt].getK().getList().get(b).getStartY());
	        					 fichier.write(" "+cc[cpt].getK().getList().get(b).getEndX());
	        					 fichier.write(" "+cc[cpt].getK().getList().get(b).getEndY());
	        					 fichier.write(" "+cc[cpt].getK().getList().get(b).getControlX1());
	        					 fichier.write(" "+cc[cpt].getK().getList().get(b).getControlY1());
	        					 fichier.write(" "+cc[cpt].getK().getList().get(b).getControlX2());	
	        					 fichier.write(" "+cc[cpt].getK().getList().get(b).getControlY2());
	        					 fichier.write("\n");
	        			
	        					 System.out.println("wrote info of  kieme curve");
	        						            				}
	            				
	            					 
	            				fichier.close();
	            			
	            			}
	            			catch(FileNotFoundException e) {
	            				  e.printStackTrace();
	            			  } catch (IOException e) {
	            				   e.printStackTrace();
	            				  }
	             
	                     cc[cpt].getRelier().set(false);
    					 cc[cpt].setK(new Bezzier());

        					 
	             	}else
	             	{
	             		cpt=tabPane.getSelectionModel().getSelectedIndex()+1;
	             		zoomPane=createZoomPane(cc[cpt].getGroup());
	             	    tabPane.getSelectionModel().getSelectedItem().setContent(zoomPane);
	             	    Fenetre.display(cc[cpt].getK());
					    System.out.println(cc[cpt].getK().getNom()+" "+cc[cpt].getK().getAltitude());
	                    cc[cpt].getLL().add(cc[cpt].getK()) ;
	                  
	                     cc[cpt].getB().set(0, 0);
	                     cc[cpt].getK().getList().clear();
	                   
	                     cc[cpt].getRelier().set(false);
	                     }
	 		    	 
		    	}catch(NullPointerException ee) {
		    		
		    	}
                    
                });
        ////////////**********************  RELIER LA FIN ET DEBUT ***************************/
        
         i28.setOnAction(new EventHandler<ActionEvent>() {
       	  public void handle(ActionEvent event) {
       		  
       	  try {
       		  if (cpt==tabPane.getSelectionModel().getSelectedIndex()+1) {
       			  if (!cc[cpt].getRelier().get()) {
   		    		if(cc[cpt].getK().l.size()>1){
   		    		 cc[cpt].getUndofx().Inc();
	                     cc[cpt].getUndofx().setChoix("relier");
   		    			 bezier c = new bezier(cc[cpt].getK().getList().getLast().getEndX(),cc[cpt].getK().getList().getLast().getEndY(),cc[cpt].getK().getList().getFirst().getStartX(),cc[cpt].getK().getList().getFirst().getStartY()) ;
   		    			Anchor C1 = new Anchor(Color.RED,c.controlX1Property(),c.controlY1Property()) ;
   		    			Anchor D1 = new Anchor(Color.RED,c.controlX2Property(),c.controlY2Property()) ;
   		    			 cc[cpt].getK().getList().add(c) ;
   		    			cc[cpt].getGroup().getChildren().addAll(c,C1,D1) ; 

   		    		}
   		    		cc[cpt].getRelier().set(true);
       			  }   
       			
              	}else
              	{
              		cpt=tabPane.getSelectionModel().getSelectedIndex()+1;
              		
              		zoomPane=createZoomPane(cc[cpt].getGroup());
              	tabPane.getSelectionModel().getSelectedItem().setContent(zoomPane);
              	if (!cc[cpt].getRelier().get()) {

              	if(cc[cpt].getK().l.size()>1){
              		 cc[cpt].getUndofx().Inc();
                     cc[cpt].getUndofx().setChoix("relier");
              		 bezier c = new bezier(cc[cpt].getK().getList().getLast().getEndX(),cc[cpt].getK().getList().getLast().getEndY(),cc[cpt].getK().getList().getFirst().getStartX(),cc[cpt].getK().getList().getFirst().getStartY()) ;
              		Anchor C1 = new Anchor(Color.RED,c.controlX1Property(),c.controlY1Property()) ;
		    			Anchor D1 = new Anchor(Color.RED,c.controlX2Property(),c.controlY2Property()) ;
		    			 cc[cpt].getK().getList().add(c) ;
		    			cc[cpt].getGroup().getChildren().addAll(c,C1,D1) ; 
		    		}
              	cc[cpt].getRelier().set(true);
              	}
              	
              	}
     			
       		
       			
       		
     		     
     		    	                           
       	  }catch(NullPointerException e) {
       		  System.out.println("il faut que vous importer une image");  
        	 }
       	  }});
         /****************** DEPLACER *****************************/
         
         i27.setOnAction(new EventHandler<ActionEvent>() {
 		      @Override
 		      public void handle(ActionEvent event) {
 		    	  try {
 		    		  Point C =new Point() ;
 		    		bool.set(false);
   		    	  bool.i=-1;
   		    	Bool trouv =new Bool() ;
   		    	trouv .set(false);
   		    	trouv.i=-1;
   		    	  if (cpt==tabPane.getSelectionModel().getSelectedIndex()+1) {
     		    		cc[cpt].getGroup().setOnMouseClicked(new EventHandler<MouseEvent>(){
     		            public void handle (MouseEvent me){
   		                if(me.getClickCount()==2){
   		                	
   		                	
   		            
       		                if (!bool.get()){
   		                      	   Anchor1 CC = new Anchor1() ;
      		                	   if (me.getTarget().getClass()==CC.getClass()) {
      		                		   CC= (Anchor1)me.getTarget() ;
      		                		 cc[cpt].getUndofx().Inc();
          		                     cc[cpt].getUndofx().setChoix("deplacer");
          	        				cc[cpt].getUndofx().setX_Y(CC.getCenterX(), CC.getCenterY());
      		                		   C.set(CC.getCenterX(), CC.getCenterY());
      		                		bool.i=rechrch0(cc[cpt].getK().getList(),  C) ;
      		                	
      		                		   if (bool.i!=-1) {
      		                			bool.set(true);
      		                			   }else {
                 		                		if((cc[cpt].getK().getList().getFirst().getStartX()==C.getX())&&(cc[cpt].getK().getList().getFirst().getStartY()==C.getY())) {
                 		                			trouv.set(true) ;
                 		                			trouv.i=0;
                 		                			bool.set(true);
                  		                		}
                 		                		
                 		                		}
      		                		 
      		                		   }

		                   
		                }   else {
		                	 cc[cpt].getUndofx().Inc();
  		                     cc[cpt].getUndofx().setChoix("deplacer");
  	        				cc[cpt].getUndofx().setX_Y(me.getX(), me.getY());
		                	if(trouv.get()) {
		                		System.out .println("here");
		                		cc[cpt].getK().getList().getFirst().setStartX(me.getX());
		                		cc[cpt].getK().getList().getFirst().setStartY(me.getY());
		                		trouv.set(false) ;
		                		trouv.i=-1;
		                		}else {
		                			cc[cpt].getK().getList().get(bool.i).setEndX(me.getX());
	 	 		                	cc[cpt].getK().getList().get(bool.i).setEndY(me.getY());
	 	 		                	if(bool.i+1==cc[cpt].getK().getList().size()) {
	 	 		                		if(cc[cpt].Relier.get()) {
	 	 	 		                		cc[cpt].getK().getList().getFirst().setStartX(me.getX());
	 	 	 		                		cc[cpt].getK().getList().getFirst().setStartY(me.getY());
	 	 	 		                		
	 	 		                		}
	 	 		               
	 		                		}else {
	 		                		cc[cpt].getK().getList().get(bool.i+1).setStartX(me.getX());
	 	 		                	cc[cpt].getK().getList().get(bool.i+1).setStartY(me.getY());
	 		                	}
	 		                	 		                	}
		                	
		                	if (cc[cpt].getLL().size()!=0)Draw(cc[cpt].getLL() ,cc[cpt].getGroup(),cc[cpt].getRelier()) ;
		                	else cc[cpt].getGroup().getChildren().remove(1, cc[cpt].getGroup().getChildren().size()); 
		                		Draw1(cc[cpt].getK().getList() ,cc[cpt].getGroup(),cc[cpt].getRelier()) ;
	                  			 
	 		                	bool.set(false);

		                	
		                }
 	                		  
   		                }




   		            }}); 
     		    		
              	}else
              	{
              		cpt=tabPane.getSelectionModel().getSelectedIndex()+1;
              		
              		zoomPane=createZoomPane(cc[cpt].getGroup());
              	tabPane.getSelectionModel().getSelectedItem().setContent(zoomPane);
              	cc[cpt].getGroup().setOnMouseClicked(new EventHandler<MouseEvent>(){
		            public void handle (MouseEvent me){
                         if(me.getClickCount()==2){
                       	  if (!bool.get()){
 		                    	
 		                    	
         		                   
     		                	   Anchor1 CC = new Anchor1() ;
     		                	   if (me.getTarget().getClass()==CC.getClass()) {
     		                		   CC= (Anchor1)me.getTarget() ;
     		                		  cc[cpt].getUndofx().Inc();
           		                     cc[cpt].getUndofx().setChoix("deplacer");
           	        				cc[cpt].getUndofx().setX_Y(CC.getCenterX(), CC.getCenterY());
     		                		   C.set(CC.getCenterX(), CC.getCenterY());
     		                		bool.i=rechrch0(cc[cpt].getK().getList(),  C) ;
     		                	
     		                		   if (bool.i!=-1) {
     		                			   bool.set(true);
     		                			   }else {
                 		                		if((cc[cpt].getK().getList().getFirst().getStartX()==C.getX())&&(cc[cpt].getK().getList().getFirst().getStartY()==C.getY())) {
                 		                			trouv.set(true) ;
                 		                			trouv.i=0;
                 		                			bool.set(true);
                  		                		}
                 		                		
                 		                		}
     		                		   }

		                   
		                }   else {
		                	cc[cpt].getUndofx().Inc();
 		                     cc[cpt].getUndofx().setChoix("deplacer");
 	        				cc[cpt].getUndofx().setX_Y(me.getX(), me.getY());
		                	if(trouv.get()) {
		                		cc[cpt].getK().getList().getFirst().setStartX(me.getX());
		                		cc[cpt].getK().getList().getFirst().setStartY(me.getY());
		                		trouv.set(false) ;
		                		trouv.i=-1;
		                		}else {
		                		cc[cpt].getK().getList().get(bool.i).setEndX(me.getX());
	 		                	cc[cpt].getK().getList().get(bool.i).setEndY(me.getY());
	 		                	if(bool.i+1==cc[cpt].getK().getList().size()) {
	 		                		if(cc[cpt].Relier.get()) {
	 	 	 		                		cc[cpt].getK().getList().getFirst().setStartX(me.getX());
	 	 	 		                		cc[cpt].getK().getList().getFirst().setStartY(me.getY());
	 	 	 		                		
	 	 		                		}
	 		                		}else {
	 		                		cc[cpt].getK().getList().get(bool.i+1).setStartX(me.getX());
	 	 		                	cc[cpt].getK().getList().get(bool.i+1).setStartY(me.getY());
	 		                	}
	 		                	 		                	}
		                	
		                	if (cc[cpt].getLL().size()!=0)Draw(cc[cpt].getLL() ,cc[cpt].getGroup(),cc[cpt].getRelier()) ;
		                	else cc[cpt].getGroup().getChildren().remove(1, cc[cpt].getGroup().getChildren().size()); 
		                		Draw1(cc[cpt].getK().getList() ,cc[cpt].getGroup(),cc[cpt].getRelier()) ;
                 			 
		                	bool.set(false);

		                }
	                		
  		                	   }
  		                		
                         }


                 }); 
              	
              	}
 		    	  } catch(NullPointerException e) {
 		    		 System.out.println("il faut que vous importer une image");  
 		    	  }
 		    	  
            
                 }});
        /********************************** SUPPRIM *********************************/
      
         i20.setOnAction(new EventHandler<ActionEvent>() {
     		      @Override
     		      public void handle(ActionEvent event) {
     		    	  try {
     		    		  Point C =new Point();
     		    		if (cpt==tabPane.getSelectionModel().getSelectedIndex()+1) {
     		    			cc[cpt].getGroup().setOnMouseClicked(new EventHandler<MouseEvent>(){
        		               public void handle (MouseEvent me){
        		            	 
        		            	  Anchor1 CC = new Anchor1() ;
      		                   if(me.getClickCount()==2){
      		                	 
      		                	   bool.i=-1;
      		                	   if (cc[cpt].getK().getList().size()==1) {
      		                		   cc[cpt].getK().getList().clear();
      		                		  cc[cpt].getGroup().getChildren().remove(2, cc[cpt].getGroup().getChildren().size());
      		                	   }
      		                	   else {
      		                		  if (me.getTarget().getClass()==CC.getClass()) {
        		                		   CC= (Anchor1)me.getTarget() ;
        		                		   cc[cpt].getUndofx().Inc();
        	       		                     cc[cpt].getUndofx().setChoix("supp");
        	       	        				cc[cpt].getUndofx().setX_Y(CC.getCenterX(), CC.getCenterY());
        		                		 C.set(CC.getCenterX(), CC.getCenterY());
        		                		 bool.i=rechrch0(cc[cpt].getK().getList(),C) ;
        		                		if (bool.i!=-1) {
        		                			System.out.println((bool.i+" "+cc[cpt].getK().getList().size()));
        		                			if(bool.i==cc[cpt].getK().getList().size()-1) {
        		                				cc[cpt].getK().getList().removeLast();
        		                				
        		                				
        		                			}else {
        		                		
        		                				bezier c1=cc[cpt].getK().getList().get(bool.i);
        	      		                		 bezier c2 ;
        	      		                		 if (bool.i+1==cc[cpt].getK().getList().size()) c2=cc[cpt].getK().getList().get(0);
        	      		                		 else c2=cc[cpt].getK().getList().get(bool.i+1);
        	      		                		 bezier c = new bezier(c1.getStartX(),c1.getStartY(), c2.getEndX(),c2.getEndY()) ;
        	      		                		 c.setControlX1(c1.getControlX1());
        	      		                		 c.setControlY1(c1.getControlY1());
        	      		                		 c.setControlX2(c2.getControlX2());
        	      		                		 c.setControlY2(c2.getControlY2());
        	      		                		 cc[cpt].getK().getList().add(bool.i,c) ;
        	      		                		 cc[cpt].getK().getList().remove(c1) ;
        	      		                		 cc[cpt].getK().getList().remove(c2);
        	      		                		
        	      		                		
        		                			}
        		                			
            		                		if (cc[cpt].getLL().size()!=0)Draw(cc[cpt].getLL(),cc[cpt].getGroup(),cc[cpt].getRelier()) ;
            		                		else cc[cpt].getGroup().getChildren().remove(1, cc[cpt].getGroup().getChildren().size());
            		                		Draw1(cc[cpt].getK().getList() ,cc[cpt].getGroup(),cc[cpt].getRelier()) ;
            		                		if(!cc[cpt].getRelier().get())cc[cpt].getB().set(cc[cpt].getK().getList().getLast().getEndX(), cc[cpt].getK().getList().getLast().getEndY());
            		                		else cc[cpt].getB().set(0,0);
        		                		
        		                		}else {
                 		                		if((cc[cpt].getK().getList().getFirst().getStartX()==C.getX())&&(cc[cpt].getK().getList().getFirst().getStartY()==C.getY())) {
                 		                			cc[cpt].getK().getList().removeFirst();
                 		                			if (cc[cpt].getLL().size()!=0) Draw( cc[cpt].getLL(),cc[cpt].getGroup(),cc[cpt].getRelier()) ;
                    		                	    else cc[cpt].getGroup().getChildren().remove(1, cc[cpt].getGroup().getChildren().size()); 
                 			                		Draw1(cc[cpt].getK().getList() ,cc[cpt].getGroup(),cc[cpt].getRelier()) ;
                 			                		if(!cc[cpt].getRelier().get())cc[cpt].getB().set(cc[cpt].getK().getList().getLast().getEndX(), cc[cpt].getK().getList().getLast().getEndY());
                    		                		else cc[cpt].getB().set(0,0);
                     	                  			
                 		                		}}}}
      		                	}
        		               }    });
     		    			
     		    		}else
                  	{
                  		cpt=tabPane.getSelectionModel().getSelectedIndex()+1;
                 
                  		zoomPane=createZoomPane(cc[cpt].getGroup());
                  	tabPane.getSelectionModel().getSelectedItem().setContent(zoomPane);
                  	cc[cpt].getGroup().setOnMouseClicked(new EventHandler<MouseEvent>(){
 		               public void handle (MouseEvent me){

		            	  Anchor1 CC = new Anchor1() ;
		                   if(me.getClickCount()==2){
		                	 
		                	   bool.i=-1;
		                	   if (cc[cpt].getK().getList().size()==1) {
		                		   cc[cpt].getK().getList().clear();
		                		  cc[cpt].getGroup().getChildren().remove(2, cc[cpt].getGroup().getChildren().size());
		                	   }
		                	   else {
		                		  if (me.getTarget().getClass()==CC.getClass()) {
 		                		   CC= (Anchor1)me.getTarget() ;
 		                		  cc[cpt].getUndofx().Inc();
       		                     cc[cpt].getUndofx().setChoix("supp");
       	        				cc[cpt].getUndofx().setX_Y(CC.getCenterX(), CC.getCenterY());
 		                		 C.set(CC.getCenterX(), CC.getCenterY());
 		                		 bool.i=rechrch0(cc[cpt].getK().getList(),C) ;
 		                		if (bool.i!=-1) {
 		                			System.out.println((bool.i+" "+cc[cpt].getK().getList().size()));
 		                			if(bool.i==cc[cpt].getK().getList().size()-1) {
 		                				cc[cpt].getK().getList().removeLast();
 		                			
 		                				
 		                				
 		                			}else {
 		                				
 		                				bezier c1=cc[cpt].getK().getList().get(bool.i);
 	      		                		 bezier c2 ;
 	      		                		 if (bool.i+1==cc[cpt].getK().getList().size()) c2=cc[cpt].getK().getList().get(0);
 	      		                		 else c2=cc[cpt].getK().getList().get(bool.i+1);
 	      		                		 bezier c = new bezier(c1.getStartX(),c1.getStartY(), c2.getEndX(),c2.getEndY()) ;
 	      		                		 c.setControlX1(c1.getControlX1());
 	      		                		 c.setControlY1(c1.getControlY1());
 	      		                		 c.setControlX2(c2.getControlX2());
 	      		                		 c.setControlY2(c2.getControlY2());
 	      		                		 cc[cpt].getK().getList().add(bool.i,c) ;
 	      		                		 cc[cpt].getK().getList().remove(c1) ;
 	      		                		 cc[cpt].getK().getList().remove(c2);
 	      		                		
 	      		                		
 		                			}
 		                			 
     		                		if (cc[cpt].getLL().size()!=0)Draw(cc[cpt].getLL(),cc[cpt].getGroup(),cc[cpt].getRelier()) ;
     		                		else cc[cpt].getGroup().getChildren().remove(1, cc[cpt].getGroup().getChildren().size());
     		                		Draw1(cc[cpt].getK().getList() ,cc[cpt].getGroup(),cc[cpt].getRelier()) ;
     		                		if(!cc[cpt].getRelier().get())cc[cpt].getB().set(cc[cpt].getK().getList().getLast().getEndX(), cc[cpt].getK().getList().getLast().getEndY());
    		                		else cc[cpt].getB().set(0,0);
     		                		}
     		                		
     	                  			else {
          		                		if((cc[cpt].getK().getList().getFirst().getStartX()==C.getX())&&(cc[cpt].getK().getList().getFirst().getStartY()==C.getY())) {
          		                			cc[cpt].getK().getList().removeFirst();
          		                			
          		                			
          		                			if (cc[cpt].getLL().size()!=0)Draw( cc[cpt].getLL(),cc[cpt].getGroup(),cc[cpt].getRelier()) ;
             		                		else cc[cpt].getGroup().getChildren().remove(1, cc[cpt].getGroup().getChildren().size()); 
          		                			Draw1(cc[cpt].getK().getList() ,cc[cpt].getGroup(),cc[cpt].getRelier()) ;
          		                			if(!cc[cpt].getRelier().get())cc[cpt].getB().set(cc[cpt].getK().getList().getLast().getEndX(), cc[cpt].getK().getList().getLast().getEndY());
            		                		else cc[cpt].getB().set(0,0);
          		                		}}
 		                		 
  		                	  
  		                	  }   
		                	   }
		                	 
		                	   }
		                  }
 		           });
                  	
                  	}   
        		    	  
        		    	  
        		    	  
        		    	  
     		    	 }catch(NullPointerException e) {
     		    		 System.out.println("il faut que vous importer une image");  
     		    	  }
                    
                     }
         });
        
           /*******************************  DRAW   *************************************////////
        
        
                        i25.setOnAction(new EventHandler<ActionEvent>() {
     		      @Override
     		      public void handle(ActionEvent event) {
     		    	  try {
           		    	
           		    	if (cpt==tabPane.getSelectionModel().getSelectedIndex()+1) {
           		    	     if (cc[cpt].getGroup().getChildren().size()>0) {
           		    	    	 cc[cpt].getGroup().setOnMouseClicked(new EventHandler<MouseEvent>() {
                                        @Override public void handle(MouseEvent me) {
                                       	 
                                            if (me.getClickCount()==2) {
                                           	 
                  		                       cc[cpt].getA().set(me.getX(),me.getY());
                  		                	 cc[cpt].getUndofx().Inc();
                  		                     cc[cpt].getUndofx().setChoix("print");
                  	        				cc[cpt].getUndofx().setX_Y(cc[cpt].getA().x, cc[cpt].getA().y);
                  		                       bezier curve=new bezier(cc[cpt].getB(),cc[cpt].getA()) ;
                  		                       Line controlLine1 = new BoundLine(curve.controlX1Property(), curve.controlY1Property(), curve.startXProperty(), curve.startYProperty());
                  		                       Line controlLine2 = new BoundLine(curve.controlX2Property(), curve.controlY2Property(), curve.endXProperty(),   curve.endYProperty());
                  		                       Anchor control1 = new Anchor(Color.RED,      curve.controlX1Property(), curve.controlY1Property());
                  		                       Anchor control2 = new Anchor(Color.RED, curve.controlX2Property(), curve.controlY2Property());
                  		                       Anchor1 end= new Anchor1(curve.endXProperty(),      curve.endYProperty());
                  		                       cc[cpt].getGroup().getChildren().add(end) ;
                                            
                                            if ((cc[cpt].getB().getX()!=0)&&(cc[cpt].getB().getY()!=0)) {
                                           	 cc[cpt].getK().getList().add(curve);
                                          
                                           	 cc[cpt].getGroup().getChildren().addAll( controlLine1, controlLine2, curve, control1, control2);
                                            }
                                                cc[cpt].getB().set(cc[cpt].getA().getX(),cc[cpt].getA().getY());
                                           }


                                        }
                                    });
           		    	     }
           		    	  
                     	}else
                     	{
                     		cpt=tabPane.getSelectionModel().getSelectedIndex()+1;
                     		
                     		zoomPane=createZoomPane(cc[cpt].getGroup());
                     	tabPane.getSelectionModel().getSelectedItem().setContent(zoomPane);
                     	 if (cc[cpt].getGroup().getChildren().size()>0) {
                     		
                            
   		    	    	 cc[cpt].getGroup().setOnMouseClicked(new EventHandler<MouseEvent>() {
                                @Override public void handle(MouseEvent me) {
                               	 
                                    if (me.getClickCount()==2) { cc[cpt].getA().set(me.getX(),me.getY());
                               	 cc[cpt].getUndofx().Inc();
                                    cc[cpt].getUndofx().setChoix("print");			
         	        				cc[cpt].getUndofx().setX_Y(cc[cpt].getA().x, cc[cpt].getA().y);
         	        			
        		                       bezier curve=new bezier(cc[cpt].getB(),cc[cpt].getA()) ;
        		                       Line controlLine1 = new BoundLine(curve.controlX1Property(), curve.controlY1Property(), curve.startXProperty(), curve.startYProperty());
        		                       Line controlLine2 = new BoundLine(curve.controlX2Property(), curve.controlY2Property(), curve.endXProperty(),   curve.endYProperty());
        		                       Anchor control1 = new Anchor(Color.RED,      curve.controlX1Property(), curve.controlY1Property());
        		                       Anchor control2 = new Anchor(Color.RED, curve.controlX2Property(), curve.controlY2Property());
        		                       Anchor1 end= new Anchor1(curve.endXProperty(),      curve.endYProperty());
        		                       cc[cpt].getGroup().getChildren().add(end) ;
                                  
                                  if ((cc[cpt].getB().getX()!=0)&&(cc[cpt].getB().getY()!=0)) {
                                 	 cc[cpt].getK().getList().add(curve);
                                 	 
                                 	 cc[cpt].getGroup().getChildren().addAll( controlLine1, controlLine2, curve, control1, control2);
                                  }
                                      cc[cpt].getB().set(cc[cpt].getA().getX(),cc[cpt].getA().getY());
                                 }


                                }
                            });
   		    	     }
                     	
                     	}
           		
           		     
     		    	  }catch(NullPointerException e) {
     		    		 System.out.println("il faut que vous importer une image");  
     		    	  }
     		      } });
                       
            i3.setOnAction(new EventHandler<ActionEvent>() {
     		      @Override
     		   
     		      public void handle(ActionEvent event) {
     		
     		    	display(tabPane);
     		   	File filee = new File("Projet n∞01");
                if (!filee.exists()) {
                    if (filee.mkdir()) {
                        System.out.println("Directory is created!");
                    } else {
                        System.out.println("Failed to create directory!");
                    }}
     		    	System.out.println("qsdfghjfvscdxwcfghvbjnk,vfcdxgvhbjn,vcdx");
     		    	if (iii==1) {
     		    		iii=0;
     		    		System.out.println("qsdfghjfvscdxwcfghvbjnk,vfcdxgvhbjn,vcdx");
     		    		
     		    	
     		    		
     		    		 Employee employee=  new Employee(" Onglet n¬∞"+cpt, " Projet n¬∞01 ");
                         
                         TreeItem<String> empLeaf = new TreeItem<String>(employee.getName());
                             boolean found = false;
                             for (TreeItem<String> depNode : rootNode.getChildren()) {
                                 if (depNode.getValue().contentEquals(employee.getDepartment())){
                                     depNode.getChildren().add(empLeaf);
                                     found = true;
                                     
                                    
                                     break;
                                 }
                             }
                             
                               
                             if (!found) {
                                 TreeItem depNode = new TreeItem(employee.getDepartment(),
                                     new ImageView(depIcon)
                                 );
                                 rootNode.getChildren().addAll(depNode);
                                 depNode.getChildren().addAll(empLeaf);
                                 depNode.setExpanded(true);
                             }
                             treeView.getSelectionModel().selectedItemProperty().addListener((observable, oldValue, newValue) -> {
                                 if(newValue != null && newValue != oldValue){
                              		
                              
                              	   String cchaine=treeView.getSelectionModel().selectedItemProperty().getValue().getValue();
                              	   String chaine11="";
                              	   for(int i=11;i<cchaine.length();i++) {
                              	      chaine11+=cchaine.charAt(i);
                              	   }
                              	    	  Scanner scanner = new Scanner(chaine11);
                              	    	  int value = scanner.nextInt();
                              	        	tabPane.getSelectionModel().select(value-1);
                                  	
                                  	
                                  	
                                   
                              
                             
                                     
                              }
                                 
                                
                                
                             });
     		    	}
     		      }
     		    });
            
             
                      
           
            
             i6.setOnAction(( ActionEvent e) -> {
           	  Tab tab11= tabPane.getSelectionModel().getSelectedItem();
           	  if (tab11!=null)
              {configureFileChooser(fileChooser);
              File file = fileChooser.showOpenDialog(stage);
              if (file != null) {
                   
                   	 
                   	 
                            try {
                           	 	
                           	 	pf=new Openfile();
                           	 	tab11.setId("onglet"+cpt);
								openFile1(file,tabPane,tab11 ,pf );
								cc[cpt]=pf;
							} catch (FileNotFoundException e1) {
								// TODO Auto-generated catch block
								e1.printStackTrace();
							}
    
                      
                           }
              }       
           	  else {
           		  configureFileChooser(fileChooser);
                     File file = fileChooser.showOpenDialog(stage);
                     if (file != null) {
                          
                          	 
                          	 
                                   try {
                                  	 	cpt++;
                                  	 	pf=new Openfile();
                                  	 	
										openFile(file,tabPane,new Tab("onglet"+cpt) ,pf );
										cc[cpt]=pf;
									} catch (FileNotFoundException e1) {
										// TODO Auto-generated catch block
										e1.printStackTrace();
									}
           
                             
                                  }
           	  }
              });

      
             
                      
        
        		 i18.setOnAction((ActionEvent event) -> {
        			 if (cpt==tabPane.getSelectionModel().getSelectedIndex()+1) {
        				
        				 cc[cpt].getGroup().setScaleX( cc[cpt].getGroup().getScaleX()*1.5);
        				 cc[cpt].getGroup().setScaleY( cc[cpt].getGroup().getScaleY()*1.5);  
        				 cc[cpt].getUndofx().Inc();
        				 cc[cpt].getUndofx().setChoix("zoumIn");
                 	}else
                 	{
                 		cpt=tabPane.getSelectionModel().getSelectedIndex()+1;
                 		zoomPane=createZoomPane(cc[cpt].getGroup());
                 	tabPane.getSelectionModel().getSelectedItem().setContent(zoomPane);
                 	cc[cpt].getGroup().setScaleX( cc[cpt].getGroup().getScaleX()*1.5);
                 	cc[cpt].getGroup().setScaleY( cc[cpt].getGroup().getScaleY()*1.5); 	
           		 cc[cpt].getUndofx().Inc();
                 	cc[cpt].getUndofx().setChoix("zoumIn");
                      
                 	}
            });

          
        
        i19.setOnAction(new EventHandler<ActionEvent>() {
       		      @Override
       		      public void handle(ActionEvent event) {
       		    	if (cpt==tabPane.getSelectionModel().getSelectedIndex()+1) {
       		    		
       				

       		    		cc[cpt].getGroup().setScaleX( cc[cpt].getGroup().getScaleX()*1/1.5);
       		    		cc[cpt].getGroup().setScaleY( cc[cpt].getGroup().getScaleY()*1/1.5);
       		    		cc[cpt].getUndofx().setChoix("zoumOut");
    				 cc[cpt].getUndofx().Inc();
                	}else
                	{
                		cpt=tabPane.getSelectionModel().getSelectedIndex()+1;
                		
                		
                		zoomPane=createZoomPane(cc[cpt].getGroup());
                	tabPane.getSelectionModel().getSelectedItem().setContent(zoomPane);
                	 
                	cc[cpt].getGroup().setScaleX( cc[cpt].getGroup().getScaleX()*1/1.5);
                	cc[cpt].getGroup().setScaleY( cc[cpt].getGroup().getScaleY()*1/1.5);
                	cc[cpt].getUndofx().setChoix("zoumOut");
    				 cc[cpt].getUndofx().Inc();
                	}

       		      }
       		    });

       
           i1.setOnAction((final ActionEvent e) -> { 
       	 
            
            
        	   File file = new File("Projet n∞01");
               if (!file.exists()) {
                   if (file.mkdir()) {
                       System.out.println("Directory is created!");
                   } else {
                       System.out.println("Failed to create directory!");
                   }
              
               }
         	  
         	  
         	  
        cpt++;
                      
        
            Employee employee=  new Employee(" Onglet n¬∞"+cpt, " Projet n¬∞01 ");
                   
         TreeItem<String> empLeaf = new TreeItem<String>(employee.getName());
             boolean found = false;
             for (TreeItem<String> depNode : rootNode.getChildren()) {
                 if (depNode.getValue().contentEquals(employee.getDepartment())){
                     depNode.getChildren().add(empLeaf);
                     found = true;
                     
                    
                     break;
                 }
             }
             
               
             if (!found) {
                 TreeItem depNode = new TreeItem(employee.getDepartment(),
                     new ImageView(depIcon)
                 );
                 rootNode.getChildren().addAll(depNode);
                 depNode.getChildren().addAll(empLeaf);
                 depNode.setExpanded(true);
                
             }
        
        
                      tabPane.getTabs().add(new Tab("Onglet n¬∞"+cpt));
         
       
        
       
              
            
         
          
          
           treeView.getSelectionModel().selectedItemProperty().addListener((observable, oldValue, newValue) -> {
        if(newValue != null && newValue != oldValue){    
     	   String cchaine=treeView.getSelectionModel().selectedItemProperty().getValue().getValue();
     	   System.out.println(cchaine);
     	   String chaine11="";
     	   for(int i=11;i<cchaine.length();i++) {
     	      chaine11+=cchaine.charAt(i);
     	   }
     	    	  Scanner scanner = new Scanner(chaine11);
     	    	  int value = scanner.nextInt();
     	        	tabPane.getSelectionModel().select(value-1);
         	
         	
         	
          
     
    
            
     }
        
       
       
    });




           });
        
        
        i23.setOnAction((final ActionEvent e) -> { 
        
        	
             
             if (cpt==tabPane.getSelectionModel().getSelectedIndex()+1) {
            	 print(cc[cpt].getGroup());
          	}else
          	{
          		cpt=tabPane.getSelectionModel().getSelectedIndex()+1;
          		
          		
          		zoomPane=createZoomPane(cc[cpt].getGroup());
          	tabPane.getSelectionModel().getSelectedItem().setContent(zoomPane);
          	 print(cc[cpt].getGroup());
          	}
        });
        
        
        i10.setOnAction(( ActionEvent e) -> { 
            
        	
            
            if (cpt==tabPane.getSelectionModel().getSelectedIndex()+1) {
            	
            	if (cc[cpt].getUndofx().getChoic()=="supp") {
            		cc[cpt].getUndofx().Intialisez();            	
            		cc[cpt].getUndofx().pint(cc[cpt]);
            		cc[cpt].getUndofx().Dec();
            		System.out.print("pint\n");
            	}
            	else {
            	if (cc[cpt].getUndofx().getChoic()=="ajout") {
            		cc[cpt].getUndofx().Intialisez();            		
            		cc[cpt].getUndofx().supp(cc[cpt]);
            		cc[cpt].getUndofx().Dec();
            		System.out.print("supp\n");
            	}
            	else {
            	if (cc[cpt].getUndofx().getChoic()=="print") {
            		cc[cpt].getUndofx().Intialisez();
            	    cc[cpt].getUndofx().supp(cc[cpt]);
            		cc[cpt].getUndofx().Dec();
            		System.out.print("supp\n");
            	}
            	else {
            	if (cc[cpt].getUndofx().getChoic()=="relier") {
            		cc[cpt].getUndofx().Intialisez();
            		cc[cpt].getUndofx().nonRelier(cc[cpt]);
            		cc[cpt].getUndofx().Dec();
            		System.out.print("supp\n");
            	} else {
            	if (cc[cpt].getUndofx().getChoic()=="zoumIn") {
            		cc[cpt].getUndofx().Intialisez();           		
            		cc[cpt].getUndofx().zoumOut(cc[cpt]);
            		cc[cpt].getUndofx().Dec();
            		System.out.print("zoumOut\n");
            	}
            	else {
            	if (cc[cpt].getUndofx().getChoic()=="zoumOut") {
            		cc[cpt].getUndofx().Intialisez();            	
            		cc[cpt].getUndofx().zoumIn(cc[cpt]);
            		cc[cpt].getUndofx().Dec();
            		System.out.print("zoumIn\n");
            	}
            	else {
            	if (cc[cpt].getUndofx().getChoic()=="deplacer") {
            		cc[cpt].getUndofx().Intialisez(); 
            		cc[cpt].getUndofx().nondeplace(cc[cpt]);
            		cc[cpt].getUndofx().Dec();
            		System.out.print("deplace\n");
            	}
            	}
            	}
            	}
            	}
            	}
            }
         	}else
         	{
         		cpt=tabPane.getSelectionModel().getSelectedIndex()+1;
         	
         		
         		zoomPane=createZoomPane(cc[cpt].getGroup());
         	tabPane.getSelectionModel().getSelectedItem().setContent(zoomPane);
         	if (cc[cpt].getUndofx().getChoic()=="supp") {
        		cc[cpt].getUndofx().Intialisez();            	
        		cc[cpt].getUndofx().pint(cc[cpt]);
        		cc[cpt].getUndofx().Dec();
        		System.out.print("pint\n");
        	}
        	else {
        	if (cc[cpt].getUndofx().getChoic()=="ajout") {
        		cc[cpt].getUndofx().Intialisez();            		
        		cc[cpt].getUndofx().supp(cc[cpt]);
        		cc[cpt].getUndofx().Dec();
        		System.out.print("supp\n");
        	}
        	else {
        	if (cc[cpt].getUndofx().getChoic()=="print") {
        		cc[cpt].getUndofx().Intialisez();
        	    cc[cpt].getUndofx().supp(cc[cpt]);
        		cc[cpt].getUndofx().Dec();
        		System.out.print("supp\n");
        	}
        	else {
        	if (cc[cpt].getUndofx().getChoic()=="relier") {
        		cc[cpt].getUndofx().Intialisez();
        		cc[cpt].getUndofx().nonRelier(cc[cpt]);
        		cc[cpt].getUndofx().Dec();
        		System.out.print("supp\n");
        	} else {
        	if (cc[cpt].getUndofx().getChoic()=="zoumIn") {
        		cc[cpt].getUndofx().Intialisez();           		
        		cc[cpt].getUndofx().zoumOut(cc[cpt]);
        		cc[cpt].getUndofx().Dec();
        		System.out.print("zoumOut\n");
        	}
        	else {
        	if (cc[cpt].getUndofx().getChoic()=="zoumOut") {
        		cc[cpt].getUndofx().Intialisez();            	
        		cc[cpt].getUndofx().zoumIn(cc[cpt]);
        		cc[cpt].getUndofx().Dec();
        		System.out.print("zoumIn\n");
        	}
        	else {
        	if (cc[cpt].getUndofx().getChoic()=="deplacer") {
        		cc[cpt].getUndofx().Intialisez(); 
        		cc[cpt].getUndofx().nondeplace(cc[cpt]);
        		cc[cpt].getUndofx().Dec();
        		System.out.print("deplace\n");
        	}
        	}
        	}
        	}
        	}
        	}
        }
       	 
        
         	}
       });
      i11.setOnAction((final ActionEvent e) -> { 
            
        	
            
            if (cpt==tabPane.getSelectionModel().getSelectedIndex()+1) {
           	
         	}else
         	{
         		cpt=tabPane.getSelectionModel().getSelectedIndex()+1;
         		
         		
         		zoomPane=createZoomPane(cc[cpt].getGroup());
         	tabPane.getSelectionModel().getSelectedItem().setContent(zoomPane);
         	
         	}
       });

        
        
        
        
        primaryStage.setScene(scene);
        
             
          
          
          
          i2.setOnAction((final ActionEvent e) -> {         
           Stage stg= new Stage();
             try {
				this.start(stg);
			} catch (FileNotFoundException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			} catch (InterruptedException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
             
          	
        });
          
          toolBar.resizeRelocate(0,0,300,300);
          toolBar.prefWidthProperty().bind(primaryStage.widthProperty());
          toolBar.setStyle("-fx-background-color: #330033");	
          toolBar.setPrefHeight(63);
             
             BorderPane borderPane = new BorderPane();
             BorderPane borderPane1 = new BorderPane();
        
             popupMenu(tabPane,primaryStage);
      
        
             borderPane1.setTop(toolBar);
             
             borderPane1.setCenter(tabPane);
        
             borderPane.prefHeightProperty().bind(scene.heightProperty());
             borderPane.prefWidthProperty().bind(scene.widthProperty());
       
             borderPane.setTop(menuBar);
             borderPane.setCenter(borderPane1);
             borderPane1.setLeft(borderPane3);
           
            borderPane1.setRight(borderPane4);
           
                        root.getChildren().add(borderPane);
                           primaryStage.setOnCloseRequest(e -> {
                                           showConfirmation2(primaryStage);
                                                                });
        
        
        
        
        
        
                   primaryStage.show(); 

    }

  
           
                   
                
       
    
}