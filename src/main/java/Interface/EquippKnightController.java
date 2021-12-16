package Interface;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.CheckBox;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class EquippKnightController extends CommonMethods {

    @FXML
    private CheckBox armor_check;

    @FXML
    private CheckBox bow_check;

    @FXML
    private CheckBox flakJacket_check;

    @FXML
    private CheckBox helmet_check;

    @FXML
    private CheckBox horseArmour_check;

    @FXML
    private CheckBox ironShield_check;

    @FXML
    private Text message_label;

    @FXML
    private TextField ID_field;

    @FXML
    private CheckBox spear_check;

    @FXML
    private CheckBox sword_check;

    @FXML
    private CheckBox woodenShield_check;

    private static final String url = "jdbc:postgresql://localhost:5432/Knights";
    private static final String user = "postgres";
    private static final String password = "12345";

    private static Connection connection;

    @FXML
    void initialize(ActionEvent event) throws SQLException {
        try {
            connection = DriverManager.getConnection(url, user, password);
            System.out.println("Connected to PostgreSQL");

            boolean isEquipped = false, isHorseEquipped = false;
            String result = "";
            int knightID = Integer.parseInt(ID_field.getText());
            String sql = "UPDATE knights2  SET is_equipped = ?, is_horse_equipped = ?, " +
                    "equippment = ? WHERE knight_id = " + knightID;
            PreparedStatement statement = connection.prepareStatement(sql);
            if (armor_check.isSelected()) {
                result += "Кольчуга ";
                isEquipped = true;
            }
            if (flakJacket_check.isSelected()) {
                result += "Броня ";
                isEquipped = true;
            }
            if (helmet_check.isSelected()) {
                result += "Шолом ";
                isEquipped = true;
            }
            if (bow_check.isSelected()) {
                result += "Лук ";
                isEquipped = true;
            }
            if (sword_check.isSelected()) {
                result += "Меч ";
                isEquipped = true;
            }
            if (spear_check.isSelected()) {
                result += "Спис ";
                isEquipped = true;
            }
            if (ironShield_check.isSelected()) {
                result += "Залізний щит ";
                isEquipped = true;
            }
            if (woodenShield_check.isSelected()) {
                result += "Дерев'яний щит ";
                isEquipped = true;
            }
            if (horseArmour_check.isSelected()) {
                result += "Кінна кольчуга ";
                isHorseEquipped = true;
            }

            statement.setBoolean(1, isEquipped);
            statement.setBoolean(2, isHorseEquipped);
            statement.setString(3, result);
            statement.executeUpdate();

            message_label.setText("Лицар екіпірований.");
        } catch (SQLException e) {
            System.out.println("Error in connecting to PosgreSQL server");
            e.printStackTrace();
        } finally {
            try {
                connection.close();
            } catch (SQLException se) { /*can't do anything */ }
        }
    }
}

