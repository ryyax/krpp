package Interface;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.text.Text;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;


public class ChangeKnightsTitleController extends CommonMethods {
    private static final String url = "jdbc:postgresql://localhost:5432/Knights";
    private static final String user = "postgres";
    private static final String password = "12345";
    private static Connection connection;
    @FXML
    private Button goBack_button;
    @FXML
    private ToggleGroup Knights1;
    @FXML
    private RadioButton bowman_rb1;
    @FXML
    private RadioButton commander_rb1;
    @FXML
    private RadioButton horseman_rb1;
    @FXML
    private RadioButton infantryman_rb1;
    @FXML
    private TextField knightID_field;
    @FXML
    private Text message_label;
    @FXML
    private Button sendInfoButton;

    @FXML
    void initialize() {
        infantryman_rb1.setToggleGroup(Knights1);
        horseman_rb1.setToggleGroup(Knights1);
        bowman_rb1.setToggleGroup(Knights1);
        commander_rb1.setToggleGroup(Knights1);
        sendInfoButton.setOnAction(Event -> {
            try {
                connection = DriverManager.getConnection(url, user, password);
                System.out.println("Connected to PostgreSQL");
                int knightID = Integer.parseInt(knightID_field.getText());
                String sql = "UPDATE knights2 SET knight_type = ? WHERE knight_id = " + knightID + ";";
                PreparedStatement statement = connection.prepareStatement(sql);
                if (infantryman_rb1.isSelected()) {
                    statement.setInt(1, 1);
                } else if (bowman_rb1.isSelected()) {
                    statement.setInt(1, 2);
                } else if (horseman_rb1.isSelected()) {
                    statement.setInt(1, 3);
                } else if (commander_rb1.isSelected()) {
                    statement.setInt(1, 4);
                } else message_label.setText("Виберіть тип лицаря.");
                statement.executeUpdate();
                message_label.setText("Звання лицаря було успішно змінено.");
            } catch (SQLException e) {
                System.out.println("Error in connecting to PosgreSQL server");
                e.printStackTrace();
            } finally {
                try {
                    connection.close();
                } catch (SQLException se) { /*can't do anything */ }
            }
        });
    }
}
