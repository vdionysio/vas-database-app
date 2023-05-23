package com.ecoveco.VasDatabaseApp.controller;

import com.ecoveco.VasDatabaseApp.dto.StateDTO;
import com.ecoveco.VasDatabaseApp.service.StateService;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/states")
public class StateController {

    private StateService service;

    public StateController(StateService stateService) {
        this.service = stateService;
    }

    @GetMapping
//    @PreAuthorize("hasAuthority('read:vas-data')")
    public List<StateDTO> getAll() {
        return service.getAllStates();
    }
}
