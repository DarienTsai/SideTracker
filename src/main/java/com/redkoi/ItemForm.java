package com.redkoi;

import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

public class ItemForm extends Stage{

    //Variables
    private Side parent;
    private TextField input;
    private Button submit;

    //Construct
    public ItemForm(Side parent){

      //Set Connections
      this.parent = parent;

      //Instantiate
      this.input = new TextField();
      this.submit = new Button("submit");

      //Create, Style Branch
      HBox layout = new HBox(5, input, submit);
      layout.setAlignment(Pos.BASELINE_CENTER);

      //Create, Style Root
      Scene root = new Scene(layout);

      //Set Stage
      this.setResizable(false);
      this.setScene(root);
      this.setTitle("Input");
      this.setAlwaysOnTop(true);
      this.show();
      
      //Event Handler
      EntryHandle entry = new EntryHandle(this, this.parent, input);
      submit.addEventHandler(MouseEvent.MOUSE_CLICKED, entry);
    }

    //Inner Class
    class EntryHandle implements EventHandler<MouseEvent>{
      //Construct
      private Stage stage;
      private Side parent;
      private TextField input;

      public EntryHandle(ItemForm stage, Side parent, TextField in){
          super();
          this.stage = stage;
          this.parent = parent;
          this.input = in;
      }

      //Method
      @Override
      public void handle(MouseEvent e){
          parent.addItem(input.getText());
          stage.close();
      }
    }
}
