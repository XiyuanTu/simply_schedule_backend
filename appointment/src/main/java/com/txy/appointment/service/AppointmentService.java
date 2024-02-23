package com.txy.appointment.service;

import com.txy.appointment.entity.Appointment;
import com.txy.appointment.entity.Slot;

import java.util.List;

public interface AppointmentService {
    List<Appointment> getAppointmentsByCoachId(Long id);
    Appointment getAppointmentById(Long id);
    Appointment createAppointment(Appointment appointment);

    void deleteAppointmentById(Long id);

    void updateAppointment(Appointment appointment);
}
