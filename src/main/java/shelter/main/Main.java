package shelter.main;

import shelter.dao.DatabaseConnector;
import java.sql.*;
import java.util.Scanner;

public class Main {
    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        boolean running = true;

        while (running) {
            printMenu();
            String input = scanner.nextLine();

            switch (input) {
                case "1":
                    visAlleShelters();
                    break;
                case "2":
                    visAlleHunder();
                    break;
                case "3":
                    visAlleKatter();
                    break;
                case "4":
                    visAlleFugler();
                    break;
                case "5":
                    System.out.println("Avslutter programmet.");
                    running = false;
                    break;
                default:
                    System.out.println("Ugyldig valg, prøv igjen.");
            }
        }
    }

    private static void printMenu() {
        System.out.println("\n MENY:");
        System.out.println("1. Vis alle shelters");
        System.out.println("2. Vis alle hunder");
        System.out.println("3. Vis alle katter");
        System.out.println("4. Vis alle fugler");
        System.out.println("5. Avslutt");
        System.out.print("Velg et alternativ: ");
    }

    private static void visAlleShelters() {
        String query = "SELECT * FROM Shelter";
        try (Connection conn = DatabaseConnector.getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(query)) {

            System.out.println("\n Shelters:");
            while (rs.next()) {
                System.out.printf("- ID: %d | Navn: %s | Adresse: %s | Telefon: %s%n",
                        rs.getInt("ShelterID"),
                        rs.getString("Name"),
                        rs.getString("Address"),
                        rs.getString("PhoneNumber"));
            }
        } catch (SQLException e) {
            System.out.println("Feil ved henting av shelters: " + e.getMessage());
        }
    }

    private static void visAlleHunder() {
        String query = "SELECT * FROM Dog";
        try (Connection conn = DatabaseConnector.getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(query)) {

            System.out.println("\n Hunder:");
            while (rs.next()) {
                System.out.printf("- ID: %d | Navn: %s | Rase: %s | Alder: %d | Vaksinert: %b | Klar for adopsjon: %b | ShelterID: %d | Mat: %s (%dg)%n",
                        rs.getInt("AnimalID"),
                        rs.getString("Name"),
                        rs.getString("Breed"),
                        rs.getInt("Age"),
                        rs.getBoolean("Vaccinated"),
                        rs.getBoolean("ReadyForAdoption"),
                        rs.getInt("ShelterID"),
                        rs.getString("FoodType"),
                        rs.getInt("DailyFoodAmount"));
            }
        } catch (SQLException e) {
            System.out.println("Feil ved henting av hunder: " + e.getMessage());
        }
    }

    private static void visAlleKatter() {
        String query = "SELECT * FROM Cat";
        try (Connection conn = DatabaseConnector.getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(query)) {

            System.out.println("\n Katter:");
            while (rs.next()) {
                System.out.printf("- ID: %d | Navn: %s | Rase: %s | Alder: %d | Vaksinert: %b | Sterilisert: %b | ShelterID: %d | Kattesand: %s (%dg)%n",
                        rs.getInt("AnimalID"),
                        rs.getString("Name"),
                        rs.getString("Breed"),
                        rs.getInt("Age"),
                        rs.getBoolean("Vaccinated"),
                        rs.getBoolean("Neutered"),
                        rs.getInt("ShelterID"),
                        rs.getString("LitterType"),
                        rs.getInt("DailyLitterAmount"));
            }
        } catch (SQLException e) {
            System.out.println("Feil ved henting av katter: " + e.getMessage());
        }
    }

    private static void visAlleFugler() {
        String query = "SELECT * FROM Bird";
        try (Connection conn = DatabaseConnector.getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(query)) {

            System.out.println("\n Fugler:");
            while (rs.next()) {
                System.out.printf("- ID: %d | Navn: %s | Art: %s | Alder: %d | Vaksinert: %b | Kan fly: %b | ShelterID: %d | Burstørrelse: %s%n",
                        rs.getInt("AnimalID"),
                        rs.getString("Name"),
                        rs.getString("Species"),
                        rs.getInt("Age"),
                        rs.getBoolean("Vaccinated"),
                        rs.getBoolean("CanFly"),
                        rs.getInt("ShelterID"),
                        rs.getString("CageSize"));
            }
        } catch (SQLException e) {
            System.out.println("Feil ved henting av fugler: " + e.getMessage());
        }
    }
}
