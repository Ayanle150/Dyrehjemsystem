package shelter.main;

import shelter.dao.DatabaseConnector;
import shelter.model.*;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class ImportAnimals {

    public static void main(String[] args) {
        String filePath = "src/main/resources/animals.txt";


        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            int antallShelters = Integer.parseInt(reader.readLine());

            // Les shelters
            for (int i = 0; i < antallShelters; i++) {
                int id = Integer.parseInt(reader.readLine());
                String name = reader.readLine();
                String address = reader.readLine();
                String phone = reader.readLine();
                String separator = reader.readLine();

                if (!separator.equals("---")) {
                    System.err.println("Forventet '---' etter shelter, fant: " + separator);
                    return;
                }

                Shelter shelter = new Shelter(id, name, address, phone);
                insertShelter(shelter);
            }

            int antallDyr = Integer.parseInt(reader.readLine());

            // Les dyr
            for (int i = 0; i < antallDyr; i++) {
                int id = Integer.parseInt(reader.readLine());
                String name = reader.readLine();
                int age = Integer.parseInt(reader.readLine());
                boolean vaccinated = Boolean.parseBoolean(reader.readLine());
                int shelterID = Integer.parseInt(reader.readLine());
                String type = reader.readLine(); // Hund, Katt, Fugl

                if (type.equalsIgnoreCase("Hund")) {
                    String breed = reader.readLine();
                    boolean adopted = Boolean.parseBoolean(reader.readLine());
                    String food = reader.readLine();
                    int grams = Integer.parseInt(reader.readLine());
                    reader.readLine(); // '---'
                    Dog dog = new Dog(id, name, age, vaccinated, shelterID, breed, adopted, food, grams);
                    insertDog(dog);
                } else if (type.equalsIgnoreCase("Katt")) {
                    String breed = reader.readLine();
                    boolean neutered = Boolean.parseBoolean(reader.readLine());
                    String litter = reader.readLine();
                    int grams = Integer.parseInt(reader.readLine());
                    reader.readLine(); // '---'
                    Cat cat = new Cat(id, name, age, vaccinated, shelterID, breed, neutered, litter, grams);
                    insertCat(cat);
                } else if (type.equalsIgnoreCase("Fugl")) {
                    String species = reader.readLine();
                    boolean canFly = Boolean.parseBoolean(reader.readLine());
                    String cageSize = reader.readLine();
                    reader.readLine(); // '---'
                    Bird bird = new Bird(id, name, age, vaccinated, shelterID, species, canFly, cageSize);
                    insertBird(bird);
                } else {
                    System.err.println("Ukjent dyretype: " + type);
                    return;
                }
            }

            System.out.println("Ferdig importert.");

        } catch (IOException | SQLException | NumberFormatException e) {
            System.err.println("Feil under lesing/import: " + e.getMessage());
        }
    }

    private static void insertShelter(Shelter shelter) throws SQLException {
        String sql = "INSERT INTO Shelter (ShelterID, Name, Address, PhoneNumber) VALUES (?, ?, ?, ?)";
        try (Connection conn = DatabaseConnector.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, shelter.getShelterID());
            stmt.setString(2, shelter.getName());
            stmt.setString(3, shelter.getAddress());
            stmt.setString(4, shelter.getPhoneNumber());
            stmt.executeUpdate();
        }
    }

    private static void insertDog(Dog dog) throws SQLException {
        String sql = "INSERT INTO Dog (AnimalID, Breed, Name, Age, Vaccinated, ReadyForAdoption, ShelterID, FoodType, DailyFoodAmount) " +
                "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)";
        try (Connection conn = DatabaseConnector.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, dog.getId());
            stmt.setString(2, dog.getBreed());
            stmt.setString(3, dog.getName());
            stmt.setInt(4, dog.getAge());
            stmt.setBoolean(5, dog.isVaccinated());
            stmt.setBoolean(6, dog.isAdopted());
            stmt.setInt(7, dog.getShelterID());
            stmt.setString(8, dog.getFoodType());
            stmt.setInt(9, dog.getGramsPerDay());
            stmt.executeUpdate();
        }
    }

    private static void insertCat(Cat cat) throws SQLException {
        String sql = "INSERT INTO Cat (AnimalID, Breed, Name, Age, Vaccinated, Neutered, ShelterID, LitterType, DailyLitterAmount) " +
                "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)";
        try (Connection conn = DatabaseConnector.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, cat.getId());
            stmt.setString(2, cat.getBreed());
            stmt.setString(3, cat.getName());
            stmt.setInt(4, cat.getAge());
            stmt.setBoolean(5, cat.isVaccinated());
            stmt.setBoolean(6, cat.isNeutered());
            stmt.setInt(7, cat.getShelterID());
            stmt.setString(8, cat.getLitterType());
            stmt.setInt(9, cat.getGramsPerDay());
            stmt.executeUpdate();
        }
    }

    private static void insertBird(Bird bird) throws SQLException {
        String sql = "INSERT INTO Bird (AnimalID, Species, Name, Age, Vaccinated, CanFly, ShelterID, CageSize) " +
                "VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
        try (Connection conn = DatabaseConnector.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, bird.getId());
            stmt.setString(2, bird.getSpecies());
            stmt.setString(3, bird.getName());
            stmt.setInt(4, bird.getAge());
            stmt.setBoolean(5, bird.isVaccinated());
            stmt.setBoolean(6, bird.canFly());
            stmt.setInt(7, bird.getShelterID());
            stmt.setString(8, bird.getCageSize());
            stmt.executeUpdate();
        }
    }
}
