import ciphers.Cipher;
import ciphers.implementation.CesarCipher;
import javafx.application.Application;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TextArea;
import javafx.stage.Stage;


public class Main extends Application {
    String resourcePath = "/fxml/Main.fxml";

    @Override
    public void start(Stage primaryStage) throws Exception {
        FXMLLoader loader = new FXMLLoader(this.getClass().getResource(resourcePath));
        Parent root = loader.load();
        Scene scene = new Scene(root, 600, 400);
        primaryStage.setTitle("Enigma");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    @FXML
    TextArea textArea;

    public TextArea getTextArea() {
        return textArea;
    }

    public void getTextArea(TextArea textArea) {
        this.textArea = textArea;
    }

    @FXML
    public void triggerEncoding() {
        String userText = textArea.getText();
        if (!userText.isEmpty()) ;
        Cipher cezarCipher = new CesarCipher();
        String encode = cezarCipher.encode(userText);
        textArea.setText(encode);
    }
}
