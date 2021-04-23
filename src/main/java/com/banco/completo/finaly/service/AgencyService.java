package com.banco.completo.finaly.service;

import com.banco.completo.finaly.entity.Agency;
import com.banco.completo.finaly.repository.AgencyRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@Service
public class AgencyService {

    @Autowired
    AgencyRepository agencyRepository;



    public List<Agency> searchAgency() {
        return agencyRepository.findAll();
    }
    public void saveAgency(Agency agency){
        agencyRepository.save(agency);
    }

    public void updateAgency(Agency agency, Long id) {
        Agency agencyBank = agencyRepository.findById(id).orElseThrow(() ->
                new ResponseStatusException(HttpStatus.BAD_REQUEST, "Erro ao atualizar cliente"));

        BeanUtils.copyProperties(agency, agencyBank,"id");
        this.saveAgency(agencyBank);
    }

    public void deleteAgency(Agency agency, Long id) {
        Agency agencyBanks = agencyRepository.findById(id).orElseThrow(()->
        new ResponseStatusException(HttpStatus.BAD_REQUEST, "Erro ao deletar"));

        this.agencyRepository.delete(agencyBanks);
    }
    public Agency searchAgencyById(Long id) {
        return agencyRepository.findById(id).get();
    }

}