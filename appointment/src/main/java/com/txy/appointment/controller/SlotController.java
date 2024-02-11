package com.txy.appointment.controller;

import com.txy.appointment.entity.Slot;
import com.txy.appointment.payload.ErrorDto;
import com.txy.appointment.payload.SlotDto;
import com.txy.appointment.service.SlotService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping(path = "/api/v1/slot", produces = {MediaType.APPLICATION_JSON_VALUE})
@AllArgsConstructor
@Validated
@Tag(
        name = "CRUD for time slots"
)
public class SlotController {
    private final SlotService slotService;
    private final ModelMapper modelMapper;

    @GetMapping("/{studentId}")
    @Operation(
            summary = "Get all the time slots picked by some student"
    )
    @ApiResponses({
            @ApiResponse(
                responseCode = "200",
                description = "Time slots fetched"
            ),
            @ApiResponse(
                    responseCode = "404",
                    description = "Time slot not found"
            ),
            @ApiResponse(
                    responseCode = "500",
                    description = "HTTP Status Internal Server Error",
                    content = @Content(
                            schema = @Schema(implementation = ErrorDto.class)
                    )
            )
        }
    )
    public ResponseEntity<List<SlotDto>> getSlotsByStudentId(@PathVariable Long studentId) {
        List<Slot> slots = slotService.getSlotsByStudentId(studentId);
        List<SlotDto> slotDtos = slots.stream().map(slot -> modelMapper.map(slot, SlotDto.class)).toList();
        // todo: combine with user dao
        return new ResponseEntity<>(slotDtos, HttpStatus.OK);
    }

    @PostMapping()
    @Operation(
            summary = "Create a time slot"
    )
    @ApiResponses({
            @ApiResponse(
                    responseCode = "201",
                    description = "Time slot created"
            ),
            @ApiResponse(
                    responseCode = "500",
                    description = "HTTP Status Internal Server Error",
                    content = @Content(
                            schema = @Schema(implementation = ErrorDto.class)
                    )
            )
        }
    )
    public ResponseEntity<SlotDto> createSlot(@Valid @RequestBody SlotDto slotDto) {
        Slot slot = slotService.createSlot(modelMapper.map(slotDto, Slot.class));
        SlotDto slotDtoResponse = modelMapper.map(slot, SlotDto.class);
        return new ResponseEntity<>(slotDtoResponse, HttpStatus.CREATED);
    }

    @DeleteMapping("/{id}")
    @Operation(
            summary = "Delete a time slot"
    )
    @ApiResponses({
            @ApiResponse(
                    responseCode = "200",
                    description = "Time slot deleted"
            ),
            @ApiResponse(
                    responseCode = "404",
                    description = "Time slot not found"
            ),
            @ApiResponse(
                    responseCode = "500",
                    description = "HTTP Status Internal Server Error",
                    content = @Content(
                            schema = @Schema(implementation = ErrorDto.class)
                    )
            )
        }
    )
    public ResponseEntity<String> deleteSlotById(@PathVariable Long id) {
        slotService.deleteSlotById(id);
        return new ResponseEntity<>("Deleted slot successfully", HttpStatus.OK);
    }

    @PutMapping()
    @Operation(
            summary = "Update a time slot"
    )
    @ApiResponses({
            @ApiResponse(
                    responseCode = "200",
                    description = "Time slot updated"
            ),
            @ApiResponse(
                    responseCode = "404",
                    description = "Time slot not found"
            ),
            @ApiResponse(
                    responseCode = "500",
                    description = "HTTP Status Internal Server Error",
                    content = @Content(
                            schema = @Schema(implementation = ErrorDto.class)
                    )
            )
        }
    )
    public ResponseEntity<String> updateSlot(@Valid @RequestBody SlotDto slotDto) {
        slotService.updateSlot(modelMapper.map(slotDto, Slot.class));
        return new ResponseEntity<>("Updated slot successfully", HttpStatus.OK);
    }

}
