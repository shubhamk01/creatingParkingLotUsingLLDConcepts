package com.starter.demo.lld.repository;

import com.starter.demo.lld.modals.ParkingFloor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ParkingFloorRepository extends JpaRepository<ParkingFloor, String> {
}
