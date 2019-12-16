package suduokusu;
import javafx.application.Application;
import javafx.geometry.Pos;

import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class Bricka extends StackPane {
	
	private int number;
	private Text text = new Text();

	
	
	public Bricka() {
		
	}
	public Bricka(int colour,int number) {
		
		text.setFont(Font.font(26));
		this.number = number;
		
		Rectangle square = new Rectangle(50,50);
		if ( colour == 1 ) { 
			square.setFill(Color.BURLYWOOD);
			
		}
		else {
			square.setFill(null);
			
		}											 //||||||||||||||||||||||\\
		                     						//beskriver färgen i rutan\\
		square.setStroke(Color.LIGHTGRAY);         //beskriver border färgen;  \\
		square.setStrokeWidth(5);
		
		setAlignment(Pos.CENTER);
		getChildren().addAll(square,text);
		setNumber(number);
		
	}
	public void setNumber(int n) {
		this.number=number;
		text.setText(Integer.toString(n));     
		
	}
	public int getNumber() {
		return this.number;
		
	}
	
	

}
