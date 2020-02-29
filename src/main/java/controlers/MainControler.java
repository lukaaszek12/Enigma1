package controlers;

import aplication.Main;
import ciphers.Cipher;
import ciphers.implementation.CesarCipher;
import file.utils.FileTool;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TextArea;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

import java.io.File;
import java.net.URL;
import java.util.ResourceBundle;

public class MainControler implements Initializable {
    private Stage mainStage;


    @FXML
    public TextArea inputTextArea;

    @Override
    public void initialize(URL location, ResourceBundle resourceBundle) {
        mainStage = Main.getMainStage();
    }

    @FXML
    public void triggerEncoding() {
        String userText = inputTextArea.getText();
        if (!userText.isEmpty()) ;
        Cipher cezarCipher = new CesarCipher();
        String encode = cezarCipher.encode(userText);
        inputTextArea.setText(encode);
    }

    @FXML
    public void triggerDecoding() {
        String userText = inputTextArea.getText();
        if (!userText.isEmpty()) ;
        Cipher cezarCipher = new CesarCipher();
        String decode = cezarCipher.decode(userText);
        inputTextArea.setText(decode);
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
