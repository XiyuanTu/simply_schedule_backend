package com.txy.appointment.service.impl;

import com.txy.appointment.entity.OpenHour;
import com.txy.appointment.exception.ResourceNotFoundException;
import com.txy.appointment.repository.OpenHourRepository;
import com.txy.appointment.repository.SlotRepository;
import com.txy.appointment.service.OpenHourService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class OpenHourServiceImpl implements OpenHourService {
    private final OpenHourRepository openHourRepository;
    @Override
    public List<OpenHour> getOpenHoursByCoachId(Long coachId) {
        return openHourRepository.findOpenHoursByCoachId(coachId).orElseThrow(() -> new ResourceNotFoundException("OpenHour", "coachId", String.valueOf(coachId)));
    }

    @Override
    public OpenHour getOpenHourById(Long id) {
        return openHourRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("OpenHour", "id", String.valueOf(id)));
    }

    @Override
    public List<OpenHour> createOpenHours(Long coachId, List<OpenHour> openHours) {
        openHourRepository.deleteOpenHoursByCoachId(coachId);
        return openHourRepository.saveAll(openHours);
    }

    @Override
    public void deleteOpenHourById(Long id) {
        getOpenHourById(id);
        openHourRepository.deleteById(id);
    }

    @Override
    public void deleteOpenHoursByCoachId(Long coachId) {
        openHourRepository.deleteOpenHoursByCoachId(coachId);
    }
}
