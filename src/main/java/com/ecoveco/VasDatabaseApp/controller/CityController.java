package com.ecoveco.VasDatabaseApp.controller;

import com.ecoveco.VasDatabaseApp.dto.CityDTO;
import com.ecoveco.VasDatabaseApp.service.CityService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/cities")
public class CityController {
    private CityService service;

    public CityController(CityService cityService) {
        this.service = cityService;
    }

    @GetMapping("/{uf}")
    public List<CityDTO> getByUd(@PathVariable String uf) {
        return service.getByUf(uf);
    }
}
