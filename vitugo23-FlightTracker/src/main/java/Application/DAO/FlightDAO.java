package Application.DAO;

import Application.Model.Flight;
import Application.Util.ConnectionUtil;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class FlightDAO {

    /**
     * Retrieve all flights from the flight table.
     */
    public List<Flight> getAllFlights() {
        Connection connection = ConnectionUtil.getConnection();
        List<Flight> flights = new ArrayList<>();
        try {
            // Correct SQL statement to retrieve all flights
            String sql = "SELECT * FROM flight";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            ResultSet rs = preparedStatement.executeQuery();

            while (rs.next()) {
                Flight flight = new Flight(rs.getInt("flight_id"), rs.getString("departure_city"),
                        rs.getString("arrival_city"));
                flights.add(flight);
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return flights;
    }

    /**
     * Retrieve a specific flight using its flight ID.
     */
    public Flight getFlightById(int id) {
        Connection connection = ConnectionUtil.getConnection();
        try {
            // Correct SQL statement to retrieve a flight by ID
            String sql = "SELECT * FROM flight WHERE flight_id = ?";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, id); // Set flight ID

            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()) {
                return new Flight(rs.getInt("flight_id"), rs.getString("departure_city"),
                        rs.getString("arrival_city"));
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return null;
    }

    /**
     * Add a flight record into the database.
     */
    public Flight insertFlight(Flight flight) {
        Connection connection = ConnectionUtil.getConnection();
        try {
            // Correct SQL statement to insert a flight
            String sql = "INSERT INTO flight (departure_city, arrival_city) VALUES (?, ?)";
            PreparedStatement preparedStatement = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            preparedStatement.setString(1, flight.getDeparture_city());
            preparedStatement.setString(2, flight.getArrival_city());

            preparedStatement.executeUpdate();
            ResultSet pkeyResultSet = preparedStatement.getGeneratedKeys();
            if (pkeyResultSet.next()) {
                int generated_flight_id = pkeyResultSet.getInt(1);
                return new Flight(generated_flight_id, flight.getDeparture_city(), flight.getArrival_city());
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return null;
    }

    /**
     * Update the flight identified by the flight ID.
     */
    public void updateFlight(int id, Flight flight) {
        Connection connection = ConnectionUtil.getConnection();
        try {
            // Correct SQL statement to update a flight
            String sql = "UPDATE flight SET departure_city = ?, arrival_city = ? WHERE flight_id = ?";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, flight.getDeparture_city());
            preparedStatement.setString(2, flight.getArrival_city());
            preparedStatement.setInt(3, id);

            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    /**
     * Retrieve all flights following a particular flight path.
     */
    public List<Flight> getAllFlightsFromCityToCity(String departure_city, String arrival_city) {
        Connection connection = ConnectionUtil.getConnection();
        List<Flight> flights = new ArrayList<>();
        try {
            // Correct SQL statement to retrieve flights by departure and arrival cities
            String sql = "SELECT * FROM flight WHERE departure_city = ? AND arrival_city = ?";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, departure_city);
            preparedStatement.setString(2, arrival_city);

            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()) {
                Flight flight = new Flight(rs.getInt("flight_id"), rs.getString("departure_city"),
                        rs.getString("arrival_city"));
                flights.add(flight);
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return flights;
    }
}

