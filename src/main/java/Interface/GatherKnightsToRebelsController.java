package Interface;

import com.nulp.pp.users.King;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;

public class GatherKnightsToRebelsController extends CommonMethods {

    @FXML
    private TextField rebelsNum_field;

    @FXML
    private Text message_label;

    @FXML
    private Button sendInfoButton;

    @FXML
    void initialize() {
        sendInfoButton.setOnAction(Event -> {
            try {
                int enemiesNum = Integer.parseInt(rebelsNum_field.getText());
                int numOfOurKnights = (int) (enemiesNum / 2);
                int numOfSquads = ((int) numOfOurKnights / 50) > 0 ? (int) numOfOurKnights / 50 : 1;
                if (King.isPossibleToCreateSquad(numOfSquads)) {
                    message_label.setText("Потрібно відправити " + numOfSquads + " загонів!");
                } else message_label.setText("Недостатьно війська, наберіть ще лицарів.");
            } catch (NumberFormatException e) {
                message_label.setText("Вводьте тільки числа!");
            } catch (Exception e) {
            }
        });
    }
}

