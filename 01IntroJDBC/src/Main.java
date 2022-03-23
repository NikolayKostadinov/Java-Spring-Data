import java.sql.*;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws SQLException {
        Scanner scan = new Scanner(System.in);
        StringBuilder stringBuilder;

        try (Connection connection = DriverManager
                .getConnection(
                        "jdbc:mysql://localhost:3306/soft_uni",
                        "root",
                        "")) {
            System.out.println("Enter the salary you want to search for:");
            Double salary = Double.parseDouble(scan.nextLine());
            String query = "SELECT * FROM employees WHERE salary > ?";
            ResultSet resultSet;
            try (PreparedStatement statement = connection.prepareStatement(query)) {
                statement.setDouble(1, salary);
                resultSet = statement.executeQuery();
                stringBuilder = new StringBuilder();
                while (resultSet.next()) {
                    stringBuilder.append(resultSet.getInt(1)).append("\t|\t");
                    stringBuilder.append(resultSet.getString(2)).append("\t|\t");
                    stringBuilder.append(resultSet.getString(4)).append("\t|\t");
                    stringBuilder.append(resultSet.getString(3)).append("\t|\t");
                    stringBuilder.append(System.lineSeparator());
                }
            }
        }
        System.out.println(stringBuilder);
    }
}
