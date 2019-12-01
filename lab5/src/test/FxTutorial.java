package test;

import java.awt.Dialog;
import java.awt.JobAttributes.DialogType;
import java.util.ArrayList;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceDialog;
import javafx.scene.control.Label;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class FxTutorial extends Application {
	Stage window;
	Scene scene1;
	Scene scene2;
	Alert alert1;
	

	public static void main(String[] args) {
		launch(args);
		

	}

	@Override
	public void start(Stage PrimaryScene) throws Exception {
		
		
		
		window = PrimaryScene;
		window = new Stage(); 
		BorderPane bord = new BorderPane();
		Button b2 = new Button("go to scene 1");
		
		scene1 = new Scene(grid(),500,400); // parametern i scene är alltid layouten samt fönstrets dimensioner
		scene2 = new Scene(grid1(),500,400);
		window.setScene(scene1);
		window.show();

		
		
		
		
	}
	private GridPane grid() {
		GridPane grid = new GridPane();
		Button b1 = new Button("go to scene 2");
		Button b2 = new Button("Do you really want to close the window?");
		Button b3 = new Button("cola zero rea 100 kr");
		alert1 = new Alert(AlertType.ERROR);
		ArrayList<String> choices = new ArrayList();
		choices.add("ketchup");
		choices.add("senap");
		choices.add("lök");
		
		
		ChoiceDialog <String> dialog = new ChoiceDialog(choices);rr
		dialog.setHeaderText("ninjas on ice");
		
		
		
		b1.setOnAction(e->{
			window.setScene(scene2);
			dialog.showAndWait();
			
			
		});
		Label label = new Label("welcome to first scene");
		grid.getChildren().addAll(b1);
		
		
		return grid;
		
	}
	private HBox grid1() {
		HBox box = new HBox();
		
		Button b1 = new Button("go to scene 1");
		b1.setOnAction(e->{
			window.setScene(scene1);
			
		});
		Label label = new Label("welcome to first scene");
		box.getChildren().addAll(b1,label);
		return box;
		
	}
	

	

	

}
