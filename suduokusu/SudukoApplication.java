package suduokusu;



import java.util.Random;

import javafx.application.Application;
import javafx.geometry.Pos;

import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.Priority;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;
import textproc.WordCountComparator;
public class SudukoApplication extends Application {
	
	
	private Bricka[][]board;
	private Pane creation() {
		Pane rootnode = new Pane();
		rootnode.setPrefSize(800, 800);
		
		int colourWave =0;
		board = new Bricka[9][9];
		
		for(int row=0;row<board.length;row++) {
			colourWave=0;
			for (int col=0;col<board[row].length;col++){
				colourWave = colourTheme(row,col);

				Bricka bricks = new Bricka(colourWave,0); // här sätts nummret, hur har vi tillgång till att knyta en
				bricks.setTranslateX(col*50);
				bricks.setTranslateY(row*50);
				board[row][col]=bricks;
				rootnode.getChildren().add(bricks);
				



			}	
		}
		


		return rootnode;
	}




	



	
	public VBox btnBox() {
		VBox vbox = new VBox();
		Button solve = new Button("Solve");
		Button genBoard = new Button("Generate Board");
		Random rand = new Random();
		vbox.getChildren().addAll(genBoard,solve);
	
		
		genBoard.setOnAction( e-> { //Skapar söndags sudoku
			for(int row=0;row<board.length;row++) {
				for (int col=0;col<board[row].length;col++){
					
					int n = rand.nextInt(9)+1;
					
					board[row][col].setNumber(n);
				}
								
			}});
	
		return vbox;
		
	}
	@Override
	public void start(Stage primaryStage) throws Exception {
		
		BorderPane pane = new BorderPane();
		
		Pane panet = creation();
		pane.setTop(panet);
		pane.setBottom(btnBox());
		
		
		Scene mainScene = new Scene(pane);
		
		primaryStage.setScene(mainScene);
		primaryStage.show();
		
		
			
		
		
		
		

	}
	public int colourTheme(int i, int l) {
	
		if(l ==1 && i== 1 || l == 1 && i == 2  || l==1 && i==3 || l ==2 && i== 1 || l == 2 && i == 2  || l==2 && i==3 || l ==3 && i== 1 ||l == 3 && i == 2  || l==3 && i==3 
				|| l == 7 && i== 1 || l == 7 && i == 2  || l==7 && i==3 || l ==8 && i== 1 || l == 8 && i == 2  || l==8 && i==3 || l ==9 && i== 1 ||
				l == 9 && i == 2  || l==9 && i==3||i ==4 && l== 4 || i == 4 && l == 5  || i==4 && l== 6 || i ==5 && l== 4 
				|| i == 5 && l == 5  || i==5 && l==6 || i ==6 && l== 4 || i == 6 && l == 5  || i==6 && l==6 || i ==7 && l== 1 || i == 7 && l == 2  ||
				i==7 && l==3 || i ==8 && l== 1 || i == 8 && l == 2  || i==8 && l==3 || i ==9 && l== 1 || i == 9 && l == 2  || i==9 && l==3 
				|| i ==7 && l== 7 || i == 7 && l == 8  || i==7 && l==9 || i ==8 && l== 7 || i == 8 && l == 8  || i==8 && l==9 || i ==9 && l== 7 || i == 9 && l == 8  || i==9 && l==9) {
		return 1;
		}
		return 0;
		
	}
	






	public static void main(String[] args) {
		launch(args);
	}


}



