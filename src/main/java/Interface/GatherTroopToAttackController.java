package Interface;

        import com.nulp.pp.users.King;
        import javafx.event.ActionEvent;
        import javafx.fxml.FXML;
        import javafx.scene.control.TextField;
        import javafx.scene.text.Text;

public class GatherTroopToAttackController extends CommonMethods {

    @FXML
    private Text message_label;

    @FXML
    private TextField enemiesNum_field;

    @FXML
    void initialize(ActionEvent event) {
        try {
            int enemiesNum = Integer.parseInt(enemiesNum_field.getText());
            int numOfOurKnights = (int) (enemiesNum * 1.25);
            int numOfBatallions = (numOfOurKnights / 200) > 0 ? numOfOurKnights / 200 : 1;
            if (King.isPossibleToCreateBatallions(numOfBatallions)) {
                message_label.setText("Потрібно відправити " + numOfBatallions + " батальйонів!");
            } else message_label.setText("Недостатьно війська, наберіть ще лицарів.");
        } catch (NumberFormatException e) {
            message_label.setText("Вводьте тільки числа!");
        } catch (Exception e) {
        }
    }
}
