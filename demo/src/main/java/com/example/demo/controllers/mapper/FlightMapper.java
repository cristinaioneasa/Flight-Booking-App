package com.example.demo.controllers.mapper;

import com.example.demo.controllers.DTO.FlightDTO;
import com.example.demo.entity.Flight;

public class FlightMapper {

    public static FlightDTO mapModelToDTO(Flight flight){
        FlightDTO flightDTO = new FlightDTO();
        flightDTO.setId(flight.getId());
        flightDTO.setNr_seats(flight.getNr_seats());
        flightDTO.setNumber(flight.getNumber());
        flightDTO.setDate_time(flight.getDate_time());
        flightDTO.setArrival(flight.getArrival());
        flightDTO.setDeparture(flight.getDeparture());

        return flightDTO;
    }
    public static Flight mapDTOToModel(FlightDTO flightDTO){
        Flight flight = new Flight();
        flight.setId(flightDTO.getId());
        flight.setNr_seats(flightDTO.getNr_seats());
        flight.setNumber(flightDTO.getNumber());
        flight.setDate_time(flightDTO.getDate_time());
        flight.setArrival(flightDTO.getArrival());
        flight.setDeparture(flightDTO.getDeparture());

        return flight;
    }

}
