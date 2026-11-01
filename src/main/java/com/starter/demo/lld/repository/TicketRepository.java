package com.starter.demo.lld.repository;

import com.starter.demo.lld.dto.TicketDTO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TicketRepository extends JpaRepository<TicketDTO, String> {
}
