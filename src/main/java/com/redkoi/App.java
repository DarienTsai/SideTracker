package com.redkoi;

import javafx.application.Application;
import javafx.css.*;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class App extends Application{

    //Constants
    final private double gap = 20;

    //Variable
    private Stage stage;

    //Stages the app on launch
    public void start(Stage stage){
        //Instantiate
        this.stage = stage;

        //Create, Style Nodes
        Text title = new Text("SideTracker");
        title.getStyleClass().add("");

        Side left = new Side();
        Side right = new Side(left);

        //Create, Style Branch Layouts
        HBox head = new HBox(title);
        head.setAlignment(Pos.CENTER);

        HBox sides = new HBox(gap, left, right);
        sides.setAlignment(Pos.CENTER);
        

        //Create, Style Root Layout
        GridPane root = new GridPane();
        root.setAlignment(Pos.BASELINE_CENTER);

        //Adding: Nodes>Branch>Root>Scene>Stage
        root.add(head, 0, 0);
        root.add(sides, 0, 1);

        //Create, Style Scene
        Scene mainModule = new Scene(root);

        //Show
        stage.setTitle("SideTracker");
        stage.setResizable(false);
        stage.setScene(mainModule);
        stage.show();
    }

    //Methoods
    public Stage getStage(){
        return this.stage;
    }

    //Main Method
    public static void main( String[] args ){
        launch();
    }
}
