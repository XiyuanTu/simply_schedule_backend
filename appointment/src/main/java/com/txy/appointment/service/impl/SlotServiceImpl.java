package com.txy.appointment.service.impl;

import com.txy.appointment.entity.Slot;
import com.txy.appointment.exception.ResourceNotFoundException;
import com.txy.appointment.repository.SlotRepository;
import com.txy.appointment.service.SlotService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@Service
@AllArgsConstructor
public class SlotServiceImpl implements SlotService {
    private final SlotRepository slotRepository;

    @Override
    public List<Slot> getSlotsByStudentIdAndCoachId(Long studentId, Long coachId) {
        return slotRepository.findSlotsByStudentIdAndCoachId(studentId, coachId).orElseThrow(() -> new ResourceNotFoundException("Slot", "studentId/coachId", studentId + "/" + coachId));
    }

    @Override
    public Slot getSlotById(Long id) {
        return slotRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Slot", "id", String.valueOf(id)));
    }

    @Override
    public List<Slot> createSlots(Long studentId, Long coachId, List<Slot> slots) {
        slotRepository.deleteSlotsByStudentIdAndCoachId(studentId, coachId);
        return slotRepository.saveAll(slots);
    }

    @Override
    public List<Slot> getSlotsByCoachId(Long coachId) {
        return slotRepository.findSlotsByCoachId(coachId).orElseThrow(() -> new ResourceNotFoundException("Slot", "coachId", String.valueOf(coachId)));
    }

    @Override
    public void deleteSlotById(Long id) {
        getSlotById(id);
        slotRepository.deleteById(id);
    }

    @Override
    public void updateSlot(Slot slot) {
        getSlotById(slot.getId());
        slotRepository.save(slot);
    }

    @Override
    public void deleteSlotsByStudentIdAndCoachId(Long studentId, Long coachId) {
        slotRepository.deleteSlotsByStudentIdAndCoachId(studentId, coachId);
    }
}
