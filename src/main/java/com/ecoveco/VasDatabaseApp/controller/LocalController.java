package com.ecoveco.VasDatabaseApp.controller;

import com.ecoveco.VasDatabaseApp.dto.LocalDTO;
import com.ecoveco.VasDatabaseApp.dto.LocalFormDTO;
import com.ecoveco.VasDatabaseApp.service.LocalService;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/locals")
public class LocalController {

    private LocalService localService;

    public LocalController(LocalService localService) {
        this.localService = localService;
    }

    @GetMapping
    public List<LocalDTO> getByCity(@RequestParam Long cityId) {
        return localService.getByCity(cityId);
    }

    @PostMapping
    public void add(@Valid @RequestBody LocalFormDTO local) {
        localService.addLocal(local);
    }

    @DeleteMapping("/{localId}")
    public void delete(@PathVariable Long localId) {
        localService.deleteLocal(localId);
    }

    @PutMapping("/{localId}")
    public void edit(@PathVariable Long localId, @Valid @RequestBody LocalFormDTO local) {
        localService.editLocal(localId, local);
    }
}
