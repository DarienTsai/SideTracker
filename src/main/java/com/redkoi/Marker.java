package com.redkoi;

import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.HBox;
import javafx.scene.text.Text;

public class Marker extends HBox{
    //Variables
    private Button remove;
    private Button swap;
    private int index;
    private Side parent;
    private Text value;
    private removeHandler delete;

    //Construct
    public Marker(String val, Side parent){
        super(5);
        this.parent = parent;
        
        //Instantiate
        remove = new Button("Remove");
        swap = new Button("Swap");

        value = new Text(val);

        //Add
        this.getChildren().addAll(remove, swap, value);
        
    }

    public Marker(Marker toCopy){
        this(toCopy.getValueStr(), toCopy.getSide());
    }

    //Methods
    public String getValueStr(){
        return this.value.getText();
    }

    public Side getSide(){
        return this.parent;
    }

    public int getIndex(){
      return this.index;
    }

    public void setIndex(int index){

      this.index = index;

      //Event Listeners
      remove.addEventHandler(MouseEvent.MOUSE_CLICKED, new removeHandler(parent, index));
    }

    //Inner Classes
    class removeHandler implements EventHandler<MouseEvent>{
        //Variables
        private Side holder;
        private int index;

        //Construct
        public removeHandler(Side holder, int index){
            this.holder = holder;
            this.index = index;
        }

        //Method
        public void handle(MouseEvent e){
            holder.removeItem(index);
        }
    }
}