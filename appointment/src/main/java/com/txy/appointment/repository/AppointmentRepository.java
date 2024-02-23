package com.txy.appointment.repository;

import com.txy.appointment.entity.Appointment;
import com.txy.appointment.entity.Slot;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface AppointmentRepository extends JpaRepository<Appointment, Long> {
    Optional<List<Appointment>> findAppointmentsByCoachId(Long coachId);
}
