package org.example;

import java.sql.*;

public class Main {
    public static void main(String[] args) {
        showTripInfo();
    }
    public static void showTripInfo(){
        String url = "jdbc:postgresql://localhost:5432/air_travel";
        String user = "postgres";
        String password = "postgres";
        try {
            Connection conn = DriverManager.getConnection(url, user, password);
            Statement stmt = conn.createStatement();
            String sql = "SELECT company_id, plane, passenger_name, boarding_place, departure_city, arrival_city FROM trip";
            ResultSet rs = stmt.executeQuery(sql);
            while (rs.next()) {
                String airCompanyName = rs.getString("air_company_name");
                String airshipName = rs.getString("airship_name");
                String passengerName = rs.getString("passenger_name");
                String boardingPlace = rs.getString("boarding_place");
                String departureCity = rs.getString("departure_city");
                String arrivalCity = rs.getString("arrival_city");
                System.out.println("Air Company Name: " + airCompanyName + ", Airship Name: " + airshipName + ", Passenger Name: " + passengerName +
                        ", Boarding Place: " + boardingPlace + ", Departure City: " + departureCity + ", Arrival City: " + arrivalCity);
            }
            conn.close();
        } catch (SQLException e) {
            System.err.println(e);
        }
    }
}