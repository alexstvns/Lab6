/*
Alex Stevens
2/23/2017
Lab-6
Csis 123B-3183
0495503
 */
package lab6;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.stage.Stage;
import javafx.scene.image.*;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import java.util.Random;
import static javafx.application.Application.launch;

/**
 *
 * @author Alex
 */
        
public class Lab6 extends Application {
    
    private Label lblCardLeft = new Label();
     private Label lblCardDeck = new Label();
     private Label lblCardRight = new Label();
     
    // String rightBuild;
   //  String leftBuild;
     //String resetImg;
     
    private int rightVal=0;
     private int leftVal=0;
     private int Score=0;
     
   
     boolean rightsTurn = true;
     
     TextField tfRight = new TextField();
     TextField tfLeft = new TextField();     
     
     
     Button btnReset = new Button("Reset");

    
    @Override
    public void start(Stage primaryStage) {
        
        
        btnReset.setOnAction(new EventHandler<ActionEvent>(){
            
            @Override
            public void handle(ActionEvent event) {
                rightVal =0;
                leftVal =0;
                Score =0;
                tfRight.setText("0");
                tfLeft.setText("0");
                rightsTurn = true;
                resetCardImages();
            }
            
        });

        lblCardDeck.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                Random rand = new Random();
                
                    int pathVal = rand.nextInt((152-101)+1)+101;
                    String Builder = ("file:img\\"+pathVal+".gif");
                if(rightsTurn == true)
                {
                    Card rCard = new Card(Builder);
                    rightVal = rCard.getValue();

                    lblCardRight.setGraphic(rCard.getCard());
                  //  Image rCard = new Image(rightBuild);
                  //  lblCardRight.setGraphic(new ImageView(rCard));
                   
                   
                  
                   
                }

                else
                {
                    
                
                Card lCard = new Card(Builder);
                leftVal = lCard.getValue();
                lblCardLeft.setGraphic(lCard.getCard());
                //Image lCard = new Image(leftBuild);
                //lblCardLeft.setGraphic(new ImageView(lCard));
                }
                
                if(rightVal > leftVal)
                {
                   Score = Integer.parseInt(tfRight.getText());
                   Score+=rightVal;
                   tfRight.setText(""+Score);
                }
                
                else if(leftVal > rightVal)
                {
                    Score = Integer.parseInt(tfLeft.getText());
                    Score+= leftVal;
                    tfLeft.setText(""+Score);
                    
                }
                rightsTurn =! rightsTurn;
            }
        });
   

        
        
        // Top Pane Objects 
         GridPane topPane = new GridPane();
            
        // NOTE : grid pane (object, col,row);
        
        
        Label lblScore = new Label("SCORE:");
        lblScore.setTextFill(Color.PURPLE);
        Font sFont = Font.font("Arial",FontWeight.MEDIUM,22.6);
        lblScore.setFont(sFont);
        
        tfLeft.setPrefWidth(50);
        tfLeft.setDisable(true);
        tfLeft.setText("0");
        
        tfRight.setPrefWidth(50);
        tfRight.setDisable(true);
        tfRight.setText("0");
        
        
        topPane.setVgap(10);
        topPane.setHgap(20);
        topPane.add(lblScore,0,0);
        topPane.add(new Label("Left:"),0,1);
        topPane.add(tfLeft,1,1);
        topPane.add(new Label("Right:"), 2, 1);
        topPane.add(tfRight,3,1);
        
        
        //Center Pane objects
         GridPane cardPane = new GridPane();
         cardPane.setHgap(20.0);
         cardPane.setAlignment(Pos.CENTER);
         

         
         cardPane.add(lblCardLeft,0,0);
         cardPane.add(lblCardDeck,1,0);
         cardPane.add(lblCardRight,2,0);
        
         
         this.resetCardImages();
        //Root Objects 
       BorderPane root = new BorderPane();

        root.setTop(topPane);
        root.setCenter(cardPane);
        root.setBottom(btnReset);
        
        Scene scene = new Scene(root, 400, 400);
        
        primaryStage.setTitle("Assignment 6- Game of War");
        primaryStage.setScene(scene);
        primaryStage.show();
        
    } 
 
    
    private void resetCardImages()
    {
        
        Card cR = new Card();
        Card cL = new Card();
        Card cD =new Card();
           
        
        lblCardLeft.setGraphic(cL.getCard());
        lblCardRight.setGraphic(cR.getCard());
        lblCardDeck.setGraphic(cD.getCard());
        
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
    
}