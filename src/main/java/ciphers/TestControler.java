package ciphers;

import implementation.CezarCipher;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TextArea;

import java.net.URL;
import java.util.ResourceBundle;

public class TestControler implements Initializable {
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
    }

    @FXML
    public TextArea textArea;


    @FXML
    public void triggerEncoding() {
        String userText = textArea.getText();
        if (!userText.isEmpty()) ;
        Cipher cezarCipher = new CezarCipher();
        String encode = cezarCipher.encode(userText);
        textArea.setText(encode);
    }

    @FXML
    public void triggerDecoding() {
        String userText = textArea.getText();
        if (!userText.isEmpty()) ;
        Cipher cezarCipher = new CezarCipher();
        String decode = cezarCipher.decode(userText);
        textArea.setText(decode);
    }
}

