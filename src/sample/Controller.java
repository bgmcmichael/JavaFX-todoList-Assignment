package sample;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;

import java.io.*;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;
import java.util.Scanner;

public class Controller implements Initializable, Serializable {
    ArrayList<String> userList = new ArrayList<String>();
    File userFile;
    String user = "";

    @FXML
    ListView todoList;

    @FXML
    TextField todoText;

    ObservableList<ToDoItem> todoItems = FXCollections.observableArrayList();

    @Override
    public void initialize(URL location, ResourceBundle resources) {
//        Scanner scan = new Scanner(System.in);
//        System.out.println("What is your name?");
//        String userInput = scan.nextLine();
//        if (userList.size() == 0){
//            userInput = (String)(userInput.substring(0, 1).toUpperCase() + userInput.substring(1).toLowerCase());
//            System.out.println(userInput);
//            userList.add(userInput);
//            user = userInput;
//            todoList.setItems(todoItems);
//        }
//        for (String currentUserName: userList){
//            if (userInput.equalsIgnoreCase(currentUserName)) {
//                userInput = (String) (userInput.substring(0, 1).toUpperCase() + userInput.substring(1).toLowerCase());
//                System.out.println(userInput);
//                user = userInput;
//            }else if(userList.size() != 0){
//                userInput = (String)(userInput.substring(0, 1).toUpperCase() + userInput.substring(1).toLowerCase());
//                System.out.println(userInput);
//                userList.add(userInput);
//                user = userInput;
//                todoList.setItems(todoItems);
//            }
//        }
        todoList.setItems(todoItems);
    }

    public ObservableList<ToDoItem> getTodoItems() {
        return todoItems;
    }

    public void addItem() {
        System.out.println("Adding item ...");
        todoItems.add(new ToDoItem(todoText.getText()));
        todoText.setText("");
//        try {
//            FileOutputStream fout = new FileOutputStream(user);
//            ObjectOutputStream oos = new ObjectOutputStream(fout);
//            oos.writeObject(this);
//
//        } catch (IOException ex) {
//            ex.printStackTrace();
//        }
    }

    public void removeItem() {
        ToDoItem todoItem = (ToDoItem)todoList.getSelectionModel().getSelectedItem();
        System.out.println("Removing " + todoItem.text + " ...");
        todoItems.remove(todoItem);
    }

    public void toggleItem() {
        System.out.println("Toggling item ...");
        ToDoItem todoItem = (ToDoItem)todoList.getSelectionModel().getSelectedItem();
        if (todoItem != null) {
            todoItem.isDone = !todoItem.isDone;
            todoList.setItems(null);
            todoList.setItems(todoItems);
        }
    }

    public void toggleAllItems() {
        System.out.println("Toggling all items ...");
        for (ToDoItem currentItem: todoItems) {
            currentItem.isDone = !currentItem.isDone;
        }
        todoList.setItems(null);
        todoList.setItems(todoItems);
    }

    public void markAllItemsDone() {
        System.out.println("Toggling all items ...");
        for (ToDoItem currentItem: todoItems) {
            currentItem.isDone = true;
        }
        todoList.setItems(null);
        todoList.setItems(todoItems);
    }

    public void markAllItemsNotDone() {
        System.out.println("Toggling all items ...");
        for (ToDoItem currentItem: todoItems) {
            currentItem.isDone = false;
        }
        todoList.setItems(null);
        todoList.setItems(todoItems);
    }

}
