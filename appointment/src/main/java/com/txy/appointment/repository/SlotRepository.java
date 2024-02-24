package com.txy.appointment.repository;

import com.txy.appointment.entity.Slot;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface SlotRepository extends JpaRepository<Slot, Long> {

    Optional<List<Slot>> findSlotsByStudentIdAndCoachId(Long studentId, Long coachId);
}
