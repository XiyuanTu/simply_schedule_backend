package com.txy.appointment.service;


import com.txy.appointment.entity.OpenHour;
import com.txy.appointment.entity.Slot;

import java.util.List;

public interface OpenHourService {

    List<OpenHour> getOpenHoursByCoachId(Long coachId);
    OpenHour getOpenHourById(Long id);
    List<OpenHour> createOpenHours(Long coachId, List<OpenHour> openHours);

    void deleteOpenHourById(Long id);

    void deleteOpenHoursByCoachId(Long coachId);
}
