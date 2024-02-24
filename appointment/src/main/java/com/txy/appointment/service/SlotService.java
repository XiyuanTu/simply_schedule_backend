package com.txy.appointment.service;

import com.txy.appointment.entity.Slot;

import java.util.List;

public interface SlotService {
    List<Slot> getSlotsByStudentIdAndCoachId(Long studentId, Long coachId);
    Slot getSlotById(Long id);
    List<Slot> createSlots(Long studentId, Long coachId, List<Slot> slots);

    void deleteSlotById(Long id);

    void updateSlot(Slot slot);
}
