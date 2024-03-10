package com.txy.appointment.payload;

import com.txy.appointment.constant.AppointmentStatus;
import com.txy.appointment.constant.SlotStatus;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.FutureOrPresent;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Schema(
        name = "Time slot"
)
public class SlotDto {

    private Long id;
    @Schema(
            description = "Student's id in User table",
            example = "324243252"
    )
    private Long studentId;

    @Schema(
            description = "Coach's id in User table",
            example = "324243252"
    )
    private Long coachId;

    @Schema(
            description = "The start of the slot",
            example = "2024-02-01T15:09:00.9920024"
    )
    @NotNull(message = "StartAt can't be empty")
    @FutureOrPresent
    private LocalDateTime startAt;

    @Schema(
            description = "The end of the slot",
            example = "2024-02-01T15:09:00.9920024"
    )
    @NotNull(message = "EndAt can't be empty")
    @FutureOrPresent
    private LocalDateTime endAt;

    private SlotStatus status;
}
