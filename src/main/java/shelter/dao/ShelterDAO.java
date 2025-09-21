package shelter.dao;

import shelter.model.Shelter;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class ShelterDAO {

    public static void insertShelter(Shelter shelter) {
        String sql = "INSERT INTO Shelter (shelterID, name, address, phoneNumber) VALUES (?, ?, ?, ?)";

        try (Connection conn = DatabaseConnector.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, shelter.getShelterID());
            stmt.setString(2, shelter.getName());
            stmt.setString(3, shelter.getAddress());
            stmt.setString(4, shelter.getPhoneNumber());

            stmt.executeUpdate();
            System.out.println("Shelter importert: " + shelter.getName());

        } catch (SQLException e) {
            System.err.println("Feil ved import av shelter: " + e.getMessage());
        }
    }
}
