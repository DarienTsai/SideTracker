package com.redkoi;

import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.ScrollPane;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.VBox;
import javafx.collections.ObservableList;
import javafx.event.EventHandler;
import javafx.geometry.Pos;

//Creates a side of the sidetracker
public class Side extends VBox{

    //Variables
    private Side other;
    private ObservableList<Node> items;

    //Constructs
    public Side(){
        super();
        this.setAlignment(Pos.CENTER);

        //Create, Style Nodes
        VBox list = new VBox();
        list.setMinWidth(420);
        list.setAlignment(Pos.TOP_CENTER);

        ScrollPane viewport = new ScrollPane(list);
        viewport.setMinSize(450, 500);

        Button add = new Button("+");

        //Add Nodes
        this.getChildren().addAll(viewport, add);

        //Instantiation
        this.items = list.getChildren();

        //Event Handler
        AddHandle addItem = new AddHandle(this);
        add.addEventFilter(MouseEvent.MOUSE_CLICKED, addItem);
    }

    public Side(Side other){
      this();
      
      //Set others
      this.setOther(other);
      other.setOther(this);
  }

    //Methods
    public void setOther(Side other){
      this.other = other;
    }

    public void openForm(){
        new ItemForm(this);
    }

    public ObservableList<Node> getItems(){
      return items;
    }

    public void addItem(String value){
        items.add(new Marker(value, this));
        this.rebuildIndex();
    }

    public void removeItem(int index){
        try{
            items.remove(index);
        }
        catch(IndexOutOfBoundsException e){
            System.out.println("aiya");
        }
        this.rebuildIndex();
    }

    public void rebuildIndex(){
        try{
            for(int i = 0; i < items.size(); i += 1){
                items.set(i, new Marker(((Marker)items.get(i))));
                ((Marker)items.get(i)).setIndex(i);
            }
        }
        catch(IndexOutOfBoundsException e){
            System.out.println("aiya");
        }
    }

    //Inner Class
    class AddHandle implements EventHandler<MouseEvent>{

      //Variables
      private Side parent;

      //Construct
      public AddHandle(Side parent){
          super();
          this.parent = parent;
      }

      //Method
      @Override
      public void handle(MouseEvent e){
          parent.openForm();
      }
    }
}