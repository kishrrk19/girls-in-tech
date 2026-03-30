package co.simplon.girls_in_tech_business.services;

import co.simplon.girls_in_tech_business.dtos.*;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.HashSet;
import java.util.List;

public interface FormationService {

    void create(@Valid FormationCreate inputs);

    boolean isUniqueCombination(String formationName,String schoolName, String diplomaName, String city);

    List<FormationView> getAllFormations();

    FormationDetail getFormationAllInfo(Long formationId);

    FormationTotalResult searchFormation(FormationSearch formationSearch, int page, int size);

    FormationToUpdate getFormationInfoToUpdate(Long formationId);

    void updateFormation(Long formationId, @Valid FormationUpdate inputs);

    public void deleteFormation(Long id);

}
