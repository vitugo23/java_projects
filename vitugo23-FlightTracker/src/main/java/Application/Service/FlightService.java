package Application.Service;

import Application.Model.Flight;
import Application.DAO.FlightDAO;

import java.util.List;

public class FlightService {
    FlightDAO flightDAO;

    public FlightService() {
        flightDAO = new FlightDAO();
    }

    public FlightService(FlightDAO flightDAO) {
        this.flightDAO = flightDAO;
    }

    public Flight addFlight(Flight flight) {
        return flightDAO.insertFlight(flight);
    }

    public Flight updateFlight(int flight_id, Flight flight) {
        if (flightDAO.getFlightById(flight_id) != null) {
            flightDAO.updateFlight(flight_id, flight);
            return flightDAO.getFlightById(flight_id);
        }
        return null;
    }

    public List<Flight> getAllFlights() {
        return flightDAO.getAllFlights();
    }

    public List<Flight> getAllFlightsFromCityToCity(String departure_city, String arrival_city) {
        return flightDAO.getAllFlightsFromCityToCity(departure_city, arrival_city);
    }
}
