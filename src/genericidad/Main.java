package genericidad;

/**
 *
 * @author USER
 */
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.time.LocalDate;



public class Main {
    private static final String DB_URL = "jdbc:mysql://localhost:3306/usuarios";
    private static final String DB_USER = "root"; 
    private static final String DB_PASSWORD = ""; 

    public static void main(String[] args) {
        // Crear un Pair para almacenar el nombre y la edad de una persona
        Pair<String, Integer> person = new Pair<>("Juan Pérez", 30);
        System.out.println("Datos de la persona: " + person.toString());

        // Crear un Pair para almacenar la EPS y la fecha de nacimiento
        Pair<String, LocalDate> epsAndBirthDate = new Pair<>("Salud Total", LocalDate.of(1993, 5, 15));
        System.out.println("Datos de la EPS y fecha de nacimiento: " + epsAndBirthDate.toString());

        // Guardar los datos en la base de datos
        saveToDatabase(person, epsAndBirthDate);
    }

    // Método para guardar los pares en la base de datos
    public static void saveToDatabase(Pair<String, Integer> person, Pair<String, LocalDate> epsAndBirthDate) {
        try (Connection conn = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD)) {
            // Insertar datos de la persona
            String insertPersonSQL = "INSERT INTO personas (nombre, edad) VALUES (?, ?)";
            try (PreparedStatement personStmt = conn.prepareStatement(insertPersonSQL)) {
                personStmt.setString(1, person.getFirst());
                personStmt.setInt(2, person.getSecond());
                personStmt.executeUpdate();
            }

            // Insertar datos de la EPS y la fecha de nacimiento
            String insertEpsSQL = "INSERT INTO eps_info (eps, fecha_nacimiento) VALUES (?, ?)";
            try (PreparedStatement epsStmt = conn.prepareStatement(insertEpsSQL)) {
                epsStmt.setString(1, epsAndBirthDate.getFirst());
                epsStmt.setDate(2, java.sql.Date.valueOf(epsAndBirthDate.getSecond()));
                epsStmt.executeUpdate();
            }

            System.out.println("Datos guardados correctamente en la base de datos.");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
