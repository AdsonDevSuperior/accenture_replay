package com.banco.completo.finaly.controller;
import com.banco.completo.finaly.entity.Agency;
import com.banco.completo.finaly.service.AgencyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.io.Serializable;
import java.util.List;

@RestController
@RequestMapping("/system")
public class AgencyController implements Serializable {
    private static final long serialVersionUID = 1L;

    @Autowired
    AgencyService agencyService;

    @GetMapping("/agency")
    public List<Agency> searchAgency() {
        return agencyService.searchAgency();
    }

    @GetMapping("/agency/{id}")
    private Agency searchAgency(@PathVariable("id") Long id) {
        return agencyService.searchAgencyById(id);
    }

    @PostMapping("/agency")
    @ResponseStatus(HttpStatus.CREATED)
    public void saveAgency(Agency agency){
        agencyService.saveAgency(agency);

    }
    @PutMapping("/agency/{id}")
    @ResponseStatus(HttpStatus.CREATED)
    public void updateAgency(@PathVariable ("id") Long id, @RequestBody Agency agency){
        agencyService.updateAgency(agency, id);
    }
    @DeleteMapping("/agency/{id}")
    @ResponseStatus(HttpStatus.CREATED)
    public void deleteAgency(@PathVariable ("id") Long id, @RequestBody Agency agency){
        agencyService.deleteAgency(agency, id);
    }
}
