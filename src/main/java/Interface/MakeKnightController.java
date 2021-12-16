package Interface;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.text.Text;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class MakeKnightController extends CommonMethods {
    private static final String url = "jdbc:postgresql://localhost:5432/Knights";
    private static final String user = "postgres";
    private static final String password = "12345";
    private static Connection connection;
    @FXML
    private Text message_lable;
    @FXML
    private ToggleGroup Knights;
    @FXML
    private RadioButton bowman_rb;
    @FXML
    private RadioButton commander_rb;
    @FXML
    private RadioButton horseman_rb;
    @FXML
    private RadioButton infantryman_rb;
    @FXML
    private TextField name_field;

    @FXML
    void initialize(ActionEvent event) throws SQLException {
        infantryman_rb.setToggleGroup(Knights);
        horseman_rb.setToggleGroup(Knights);
        bowman_rb.setToggleGroup(Knights);
        commander_rb.setToggleGroup(Knights);
        try {
            connection = DriverManager.getConnection(url, user, password);
            System.out.println("Connected to PostgreSQL");
            String sql = "INSERT INTO knights2 (knight_name, knight_type)" +
                    " VALUES (?, ?)";
            PreparedStatement statement = connection.prepareStatement(sql);
            String name = name_field.getText();
            if (infantryman_rb.isSelected()) {
                addKnightToDB(statement, name, 1);
                message_lable.setText("Лицар створений! Не забудьте видати йому спорядження.");
            } else if (bowman_rb.isSelected()) {
                addKnightToDB(statement, name, 2);
                message_lable.setText("Лицар створений! Не забудьте видати йому спорядження.");
            } else if (horseman_rb.isSelected()) {
                addKnightToDB(statement, name, 3);
                message_lable.setText("Лицар створений! Не забудьте видати йому спорядження.");
            } else if (commander_rb.isSelected()) {
                addKnightToDB(statement, name, 4);
                message_lable.setText("Лицар створений! Не забудьте видати йому спорядження.");
            } else message_lable.setText("Виберіть тип лицаря.");
        } catch (SQLException e) {
            System.out.println("Error in connecting to PosgreSQL server");
            e.printStackTrace();
        } finally {
            try {
                connection.close();
            } catch (SQLException se) { /*can't do anything */ }
        }
    }


    private void addKnightToDB(PreparedStatement statement, String name, int knightType) throws SQLException {
        statement.setString(1, name);
        statement.setInt(2, knightType);
        int rows = statement.executeUpdate();
        if (rows > 0) {
            System.out.println("Knight was succesfully added");
        }
    }
}

