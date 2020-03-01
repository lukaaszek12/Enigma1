package controlers;

import aplication.Main;
import ciphers.Cipher;
import ciphers.implementation.VigenereCipher;
import factories.CipherFactory;
import factories.impl.CipherFactoryImpl;
import file.utils.FileTool;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextInputDialog;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import java.io.File;
import java.net.URL;
import java.util.Arrays;
import java.util.Optional;
import java.util.ResourceBundle;

import static factories.impl.CipherFactoryImpl.*;

public class MainControler implements Initializable {

    @FXML
    public TextArea inputTextArea;

    @FXML
    ChoiceBox<String> cipherChoiseBox;

    private Stage mainStage;
    private ObservableList<String> possibleCipherMethods =
            FXCollections.observableArrayList(Arrays.asList(CESAR, ROOT13, VIGENERE));

    private CipherFactory cipherFactory = new CipherFactoryImpl();


    @Override
    public void initialize(URL location, ResourceBundle resource) {
        cipherChoiseBox.setItems(possibleCipherMethods);
        cipherChoiseBox.setValue(CESAR);
        mainStage = Main.getMainStage();
    }

    @FXML
    public void triggerEncoding() {
        String userText = inputTextArea.getText();
        if (!userText.isEmpty()) {
            String cipherType = cipherChoiseBox.getValue();
            Cipher cipher = cipherFactory.create(cipherType);
            if (cipher instanceof VigenereCipher) {
                TextInputDialog inputDialog = new TextInputDialog("Key");
                inputDialog.setHeaderText("Please choose key and remember it.");
                inputDialog.setContentText("Key: ");
                Optional<String> userInputOptional = inputDialog.showAndWait();
                if (userInputOptional.isPresent() && !userInputOptional.get().equals("")) {
                    ((VigenereCipher) cipher).setKey(userInputOptional.get());
                } else {
                    return;
                }
            }
            String encode = cipher.encode(userText);
            inputTextArea.setText(encode);
        }
    }


    @FXML
    public void triggerDecoding() {
        String userText = inputTextArea.getText();
        if (!userText.isEmpty());
        String cipherType = cipherChoiseBox.getValue();
        Cipher cipher = cipherFactory.create(cipherType);
        if(cipher instanceof VigenereCipher) {
            TextInputDialog inputDialog = new TextInputDialog("Key");
            inputDialog.setContentText("Key:");
            inputDialog.setHeaderText("If you know the key, write it here.");
            Optional<String> userInputOptional = inputDialog.showAndWait();
            if(userInputOptional.isPresent() && !userInputOptional.get().equals("")) {
                ((VigenereCipher) (cipher)).setKey(userInputOptional.get());
            }else {
                return;
            }
        }
        String decoded = cipher.decode(userText);
        inputTextArea.setText(decoded);
    }


    @FXML
    public void saveToFile() {

        FileChooser fileChooser = new FileChooser();
        fileChooser.setTitle("Save ti file");
        fileChooser.setInitialFileName("message.crpy");
        fileChooser.getExtensionFilters().addAll(
                new FileChooser.ExtensionFilter("crypt file", "*.crpt"),
                new FileChooser.ExtensionFilter("test file", "*.txt")
        );
        File fileToSave = fileChooser.showSaveDialog(null);
        if (fileToSave != null) {
            String absolutePath = fileToSave.getAbsolutePath();
            FileTool.writeFileContent(absolutePath, inputTextArea.getText());
        }
    }

    public void loadFile() {
        FileChooser fileChooser = new FileChooser();
        fileChooser.setTitle("Save ti file");
        fileChooser.setInitialFileName("message.crpy");
        fileChooser.getExtensionFilters().addAll(
                new FileChooser.ExtensionFilter("crypt file", "*.crpt"),
                new FileChooser.ExtensionFilter("test file", "*.txt")
        );
        File fileToLoad = fileChooser.showOpenDialog(mainStage);
        if (null != fileToLoad) {
            String fileContent = FileTool.getFileContent(fileToLoad.getAbsolutePath());
            inputTextArea.setText(fileContent);
        }
    }
}
