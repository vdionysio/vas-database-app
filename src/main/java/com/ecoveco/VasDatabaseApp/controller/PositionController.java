package com.ecoveco.VasDatabaseApp.controller;

import com.ecoveco.VasDatabaseApp.dto.PositionDTO;
import com.ecoveco.VasDatabaseApp.dto.PositionFormDTO;
import com.ecoveco.VasDatabaseApp.service.PositionService;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/positions")
public class PositionController {
    private PositionService positionService;

    public PositionController(PositionService positionService) {
        this.positionService = positionService;
    }

    @GetMapping
    public List<PositionDTO> getByLocalityId(@RequestParam Long localityId) {
        return positionService.getByLocalityId(localityId);
    }

    @PostMapping
    public void add(@Valid @RequestBody PositionFormDTO position) {
        positionService.add(position);
    }
}
