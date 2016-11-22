
package anagram;

import static anagram.Test.sortWord;
import java.io.BufferedReader;
import java.io.FileReader;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;


public class FXMLDocumentController {
    
    private FileReader file;
    private BufferedReader fileReader;
    
    @FXML
    private TextField textField;
    
    @FXML
    private ListView<String> listView;
    
    @FXML
    private Label label1;

    @FXML
    void handleButtonAction(ActionEvent event) throws Exception {
        file = new FileReader("src/assets/words.txt");
        fileReader = new BufferedReader(file);
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
        else if(word.equalsIgnoreCase("mufti")){
            for (int i = 0; i < 7; i++) {
                list.add("allahu akbar");
            }
        }
        else{
            String currentWord;
            while((currentWord = fileReader.readLine()) != null){
                if(currentWord.length() == word.length() && sortWord(word).equalsIgnoreCase(sortWord(currentWord)) && !word.equalsIgnoreCase(currentWord)){
                    list.add(currentWord);
                }
            }
        }
        
        
        listView.setItems(list);
        label1.setText(list.size() + (list.size() == 1? " anagram found" : " anagrams found"));
        
        System.out.println("Time: " + (System.currentTimeMillis() - t1) / 1000.0);

    }
    
    @FXML
    void handleTextfieldAction(ActionEvent event) throws Exception{
        handleButtonAction(event);
    }
}
