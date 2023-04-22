package com.example.demo.Service;

import com.example.demo.Repository.FlightRepository;
import com.example.demo.controllers.DTO.FlightDTO;
import com.example.demo.controllers.mapper.FlightMapper;
import com.example.demo.entity.Flight;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class FlightServiceImplementare implements FlightService{
    @Autowired
    FlightRepository flightRep;
    public FlightServiceImplementare(FlightRepository flightRepository){
        this.flightRep = flightRepository;
    }

    @Override
    public Flight findByNumber(String number) {
        return flightRep.findByNumber(number);
    }

    @Override
    public Optional<Flight> findById(Long id) {
        return flightRep.findById(id);
    }

    @Override
    public List<FlightDTO> findByArrival(String arrival) {
        List<Flight> flights = (List<Flight>) flightRep.findByArrival(arrival);
        return flights.stream().map(f -> FlightMapper.mapModelToDTO(f)).toList();
    }

    @Override
    public List<FlightDTO> findByDeparture(String departure) {
        List<Flight> flights = (List<Flight>) flightRep.findByDeparture(departure);
        return flights.stream().map(f -> FlightMapper.mapModelToDTO(f)).toList();
    }

    @Override
    public List<FlightDTO> findByArrivalAndDeparture(String arrival, String departure) {
        List<Flight> flights = (List<Flight>) flightRep.findByArrivalAndDeparture(arrival, departure);
        return flights.stream().map(f -> FlightMapper.mapModelToDTO(f)).toList();
    }

    @Override
    public List<FlightDTO> findAll() {
        List<Flight> flights = (List<Flight>) flightRep.findAll();
        return flights.stream().map(f -> FlightMapper.mapModelToDTO(f)).toList();
    }

    @Override
    public void anulateFlight(Long id) {
        flightRep.deleteById(id);
    }

    @Override
    public Flight updateFlight(FlightDTO flightDTO, int nr_seats) {
        flightDTO.setNr_seats(nr_seats);
        Flight flight = FlightMapper.mapDTOToModel(flightDTO);
        flightRep.save(flight);

        return flight;
    }

    @Override
    public Flight insertFlight(Flight flight) {
        return flightRep.save(flight);
    }
}