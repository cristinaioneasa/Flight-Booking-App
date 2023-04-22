package com.example.demo.Repository;

import com.example.demo.entity.Ticket;
import jakarta.transaction.Transactional;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface TicketRepository extends CrudRepository<Ticket, Long> {
    Ticket findByNoTicket(Long number);
    List<Ticket> findByPassagerName(String passagerName);

    @Transactional
    void deleteByNoTicket(long noTicket);
    boolean existsByNoTicket(long noTichet);
}
