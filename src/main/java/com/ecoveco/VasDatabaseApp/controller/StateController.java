package com.ecoveco.VasDatabaseApp.controller;

import com.ecoveco.VasDatabaseApp.dto.StateDTO;
import com.ecoveco.VasDatabaseApp.service.StateService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/states")
public class StateController {

    private StateService service;

    public StateController(StateService stateService) {
        this.service = stateService;
    }

    @GetMapping("/")
    public List<StateDTO> getAll() {
        return service.getAllStates();
    }
}
