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

public class ExecuteKnightController extends CommonMethods {

    @FXML
    private TextField knightID_field;

    @FXML
    private Text rezOfExecutinhKnight_lable;

    @FXML
    private Button sendInfoButton;
    private static final String url = "jdbc:postgresql://localhost:5432/Knights";
    private static final String user = "postgres";
    private static final String password = "12345";

    private static Connection connection;

    @FXML
    public void initialize() {
        sendInfoButton.setOnAction(Event -> {
            try {
                connection = DriverManager.getConnection(url, user, password);
                System.out.println("Connected to PostgreSQL");
                int knightID = Integer.parseInt(knightID_field.getText());
                String sql = "DELETE FROM knights2 WHERE knight_id = " + knightID + ";";
                PreparedStatement statement = connection.prepareStatement(sql);
                statement.executeUpdate();
                rezOfExecutinhKnight_lable.setText("Лицар був успішно страчений.");
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

