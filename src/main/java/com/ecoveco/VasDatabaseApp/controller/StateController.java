package com.ecoveco.VasDatabaseApp.controller;

import com.ecoveco.VasDatabaseApp.dto.StateDTO;
import com.ecoveco.VasDatabaseApp.entity.State;
import com.ecoveco.VasDatabaseApp.service.StateService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class StateController {

    private StateService service;

    public StateController(StateService stateService) {
        this.service = stateService;
    }

    @GetMapping("/states")
    public List<StateDTO> getAll() {
        return service.getAll();
    }
}
