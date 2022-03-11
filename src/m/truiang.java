package m;

import javafx.event.ActionEvent;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.Background;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Line;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class truiang {
	public static void display(String title)
	{
	    Stage window =new Stage();
	    window.initModality(Modality.APPLICATION_MODAL);

	     window.setTitle(title);
	    
	  Group grp = new Group();
	  Text userName = new Text("  Nom                                                Prénom");
      userName.setFont(Font.font("Tahoma", FontWeight.NORMAL, 20));
      userName.setFill(Color.BURLYWOOD);
      userName.setLayoutX(150);
      userName.setLayoutY(270);
      grp.getChildren().add(userName);
     
      
     
      
      TextField userTextField = new TextField();
      userTextField.setLayoutX(150);
      userTextField.setLayoutY(280);
      userTextField.setFont(Font.font("Tahoma", FontWeight.NORMAL, 16));
      userTextField.setStyle("-fx-text-inner-color: white;");
      userTextField.setBackground(Background.EMPTY);
      grp.getChildren().add(userTextField );
      
      Line line=new Line(160,310,350,310);
      line.setStroke(Color.LIGHTGRAY);
      grp.getChildren().add(line);
      
      TextField userTextField2 = new TextField();
      userTextField2.setLayoutX(490);
      userTextField2.setLayoutY(280);
      userTextField2.setFont(Font.font("Tahoma", FontWeight.NORMAL, 16));
      userTextField2.setStyle("-fx-text-inner-color: white;");
      userTextField2.setBackground(Background.EMPTY);
      grp.getChildren().add(userTextField2 );
      
      Line line22=new Line(500,310,690,310);
      line22.setStroke(Color.LIGHTGRAY);
      grp.getChildren().add(line22);
      
      
      
      
      
      
	    Scene scene=new Scene(grp,1200,1000);
	    
	    
	    
	    
	    
	    window.setScene(scene);
	     window.showAndWait();
	}
}
