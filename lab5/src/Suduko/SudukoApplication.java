package Suduko;
import javafx.application.Application;
import javafx.geometry.Pos;

import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;
public class SudukoApplication extends Application {
	private Pane creation() {
		Pane rootnode = new Pane();
		rootnode.setPrefSize(800, 800);
		int colourWave =0;
		for(int i=1;i<10;i++) {
			colourWave=0;
			for (int l=1; l<10;l++){
				if(l ==1 && i== 1 || l == 1 && i == 2  || l==1 && i==3 || l ==2 && i== 1 || l == 2 && i == 2  || l==2 && i==3 || l ==3 && i== 1 ||l == 3 && i == 2  || l==3 && i==3 
						|| l == 7 && i== 1 || l == 7 && i == 2  || l==7 && i==3 || l ==8 && i== 1 || l == 8 && i == 2  || l==8 && i==3 || l ==9 && i== 1 ||
						l == 9 && i == 2  || l==9 && i==3||i ==4 && l== 4 || i == 4 && l == 5  || i==4 && l== 6 || i ==5 && l== 4 
						|| i == 5 && l == 5  || i==5 && l==6 || i ==6 && l== 4 || i == 6 && l == 5  || i==6 && l==6 || i ==7 && l== 1 || i == 7 && l == 2  ||
						i==7 && l==3 || i ==8 && l== 1 || i == 8 && l == 2  || i==8 && l==3 || i ==9 && l== 1 || i == 9 && l == 2  || i==9 && l==3 
						|| i ==7 && l== 7 || i == 7 && l == 8  || i==7 && l==9 || i ==8 && l== 7 || i == 8 && l == 8  || i==8 && l==9 || i ==9 && l== 7 || i == 9 && l == 8  || i==9 && l==9) {
					colourWave = 1;
				}
				else {
					colourWave =0;
				}





				Bricka bricks = new Bricka(colourWave,0);
				bricks.setTranslateX(l*50);
				bricks.setTranslateY(i*50);

				rootnode.getChildren().add(bricks);



			}

		}


		return rootnode;




	}



	@Override
	public void start(Stage primaryStage) throws Exception {
		primaryStage.setScene(new Scene(creation()));
		primaryStage.show();

	}
	






	public static void main(String[] args) {
		launch(args);
	}


}



