package com.txy.appointment.service.impl;

import com.txy.appointment.entity.Appointment;
import com.txy.appointment.entity.Slot;
import com.txy.appointment.exception.ResourceNotFoundException;
import com.txy.appointment.repository.AppointmentRepository;
import com.txy.appointment.service.AppointmentService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
@AllArgsConstructor
public class AppointmentServiceImpl implements AppointmentService {
    private final AppointmentRepository appointmentRepository;
    @Override
    public List<Appointment> getAppointmentsByCoachId(Long coachId) {
        return appointmentRepository.findAppointmentsByCoachId(coachId).orElseThrow(() -> new ResourceNotFoundException("Appointment", "coachId", String.valueOf(coachId)));
    }

    @Override
    public Appointment getAppointmentById(Long id) {
        return appointmentRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Appointment", "id", String.valueOf(id)));
    }

    @Override
    public Appointment createAppointment(Appointment appointment) {
        return appointmentRepository.save(appointment);
    }

    @Override
    public void deleteAppointmentById(Long id) {
        getAppointmentById(id);
        appointmentRepository.deleteById(id);
    }

    @Override
    public void updateAppointment(Appointment appointment) {
        getAppointmentById(appointment.getId());
        appointmentRepository.save(appointment);
    }
}
