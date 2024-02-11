package com.txy.appointment.service.impl;

import com.txy.appointment.entity.Slot;
import com.txy.appointment.exception.ResourceNotFoundException;
import com.txy.appointment.repository.SlotRepository;
import com.txy.appointment.service.SlotService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class SlotServiceImpl implements SlotService {
    private final SlotRepository slotRepository;

    @Override
    public List<Slot> getSlotsByStudentId(Long studentId) {
        return slotRepository.findSlotsByStudentId(studentId).orElseThrow(() -> new ResourceNotFoundException("Slot", "studentId", String.valueOf(studentId)));
    }

    @Override
    public Slot getSlotById(Long id) {
        return slotRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Slot", "id", String.valueOf(id)));
    }

    @Override
    public Slot createSlot(Slot slot) {
        return slotRepository.save(slot);
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
}
