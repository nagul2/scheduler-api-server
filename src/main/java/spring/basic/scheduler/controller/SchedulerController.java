package spring.basic.scheduler.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import spring.basic.scheduler.model.dto.SchedulerCreateRequestDto;
import spring.basic.scheduler.model.dto.SchedulerCommonResponseDto;
import spring.basic.scheduler.model.dto.SchedulerFindResponseDto;
import spring.basic.scheduler.model.dto.SchedulerSearchCond;
import spring.basic.scheduler.service.SchedulerService;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/scheduler")
public class SchedulerController {

    private final SchedulerService schedulerService;

    @PostMapping
    public ResponseEntity<SchedulerCommonResponseDto> addContent(@RequestBody SchedulerCreateRequestDto createRequestDto) {
        return new ResponseEntity<>(schedulerService.saveContent(createRequestDto), HttpStatus.CREATED);
    }

    @GetMapping
    public List<SchedulerFindResponseDto> schedules(SchedulerSearchCond searchCond) {
        return schedulerService.findAllSchedules(searchCond);
    }


}
