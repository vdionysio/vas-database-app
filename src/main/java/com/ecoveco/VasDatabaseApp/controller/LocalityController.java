package com.ecoveco.VasDatabaseApp.controller;

import com.ecoveco.VasDatabaseApp.dto.LocalityDTO;
import com.ecoveco.VasDatabaseApp.dto.LocalityFormDTO;
import com.ecoveco.VasDatabaseApp.service.LocalityService;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/localities")
public class LocalityController {

    private LocalityService localityService;

    public LocalityController(LocalityService localityService) {
        this.localityService = localityService;
    }

    @GetMapping
    public List<LocalityDTO> getByCity(@RequestParam Long cityId) {
        return localityService.getByCityId(cityId);
    }

    @PostMapping
    public void add(@Valid @RequestBody LocalityFormDTO locality) {
        localityService.addLocality(locality);
    }

    @DeleteMapping("/{localityId}")
    public void delete(@PathVariable Long localityId) {
        localityService.deleteLocality(localityId);
    }

    @PutMapping("/{localityId}")
    public void edit(@PathVariable Long localityId, @Valid @RequestBody LocalityFormDTO locality) {
        localityService.editLocality(localityId, locality);
    }
}
