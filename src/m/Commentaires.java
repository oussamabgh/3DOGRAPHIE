/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package m;

import javafx.event.ActionEvent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.VBox;
import javafx.stage.Modality;
import javafx.stage.Stage;

/**
 *
 * @author mac
 */
public class Commentaires {
    
    
    public static void display(String title)
{
    Stage window =new Stage();
    window.initModality(Modality.APPLICATION_MODAL);
    window.setMinWidth(800);
     window.setMinHeight(550);
     window.setTitle(title);
    
    
     Button closee =new Button(" Fermer  ");
    closee.setOnAction((ActionEvent e)->{
        window.close();
        
    });
     
     VBox layout =new VBox(20);
    layout.getChildren().addAll(closee);
    
  closee.setTranslateX(710);
closee.setTranslateY(480);
    
    
    Scene scene=new Scene(layout);
    
    
    
    
    
    window.setScene(scene);
     window.showAndWait();
}
} 



