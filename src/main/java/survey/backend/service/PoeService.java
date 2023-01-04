package survey.backend.service;

import survey.backend.dto.PoeDto;
import survey.backend.dto.PoeDto;

import java.util.Collection;
import java.util.Optional;

public interface PoeService {

    /**
     * find all poes
     * @return all poes
     */
    Collection<PoeDto> findAll();

    /**
     * find poe with its id
     * @param id
     * @return optional with poe if found else optional empty
     */
    Optional<PoeDto> findById(long id);

    /**
     * search poes with criteria lastname, firstname ;
     * one criteria can be null, not both
     * @param lastname
     * @param firstname
     * @return poe set with this lastname (if not null) and this firstname (if not null) ;
     * empty set if no poe found with these criteria or both criteria are null
     */
    Collection<PoeDto> search(String lastname, String firstname);

    /**
     * add new poe
     * @param poeDto
     * @return poe completed (id, default values)
     */
    PoeDto add(PoeDto poeDto);

    /**
     * update poe
     * @param poeDto
     * @return poe updated if found, else optional empty
     */
    Optional<PoeDto> update(PoeDto poeDto);

    /**
     * delete poe with its id
     * @param id
     * @return true if found and deleted, false if not found
     */
    boolean remove(long id);
}
