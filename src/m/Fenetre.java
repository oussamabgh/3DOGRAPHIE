package m;

import java.util.Optional;

import javafx.scene.*;
import javafx.scene.control.TextInputDialog;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import m.M.Bezzier;

public class Fenetre   {

	public static void display(Bezzier K) {
		Stage s =new Stage();
		
		 Group root = new Group();
		 Scene scene= new Scene( root, 400, 400, Color.ALICEBLUE);
		 TextInputDialog d=new TextInputDialog("");
		 d.setHeaderText("Donner vle nom de la courbe");
		 d.setContentText("Le nom de la courbe");
		 Optional<String> text=d.showAndWait();
		 K.SetNom(text.get());
		 TextInputDialog d2=new TextInputDialog("");
		 d2.setHeaderText("Donner l'altitude de la courbe");
		 d2.setContentText("L'altitude de la courbe");
		 Optional<String> text2=d2.showAndWait();
		 K.setAltitude(Double.parseDouble(text2.get()));
		s.setScene(scene);
	
	}

	

}
