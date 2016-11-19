/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package anagram;

import anagram.List.LinkedList;
import static anagram.Test.sortWord;
import java.io.File;
import java.util.Scanner;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;


public class FXMLDocumentController {
    
    private File file = new File("words.txt");
    private Scanner fileReader;
    
    @FXML
    private TextField textField;
    
    @FXML
    private ListView<String> listView;

    @FXML
    void handleButtonAction(ActionEvent event) throws Exception {
        fileReader = new Scanner(file);
        ObservableList<String> list = FXCollections.observableArrayList();
        String word = textField.getText().trim();
        
        long t1 = System.currentTimeMillis();
        
        if(word.equals("s2b")){
            for (int i = 0; i < 7; i++) {
                list.add("s2b, our lord and saviour");
            }
        }
        else if(word.equalsIgnoreCase("manny")){
            for (int i = 0; i < 7; i++) {
                list.add("creator of our lord and saviour");
            }
        }
        else if(word.equalsIgnoreCase("kamal")){
            for (int i = 0; i < 7; i++) {
                list.add("two habbas");
            }
        }
        else{
            while(fileReader.hasNext()){
                String currentWord = fileReader.nextLine();
                if(sortWord(word).equals(sortWord(currentWord)) && !word.equals(currentWord)){
                    list.add(currentWord);
                }
            }
        }
        
        
        listView.setItems(list);
        
        System.out.println("Time: " + (System.currentTimeMillis() - t1) / 1000.0);
        System.out.println("# of anagrams: " + list.size());

    }

}
