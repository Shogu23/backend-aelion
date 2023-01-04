package survey.backend.service.impl;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import survey.backend.dto.PoeDto;
import survey.backend.dto.TraineeDto;
import survey.backend.entities.Poe;
import survey.backend.entities.Trainee;
import survey.backend.repository.PoeRepository;
import survey.backend.utils.StreamUtils;

import java.util.Collection;
import java.util.Optional;

@Service
public class PoeService implements survey.backend.service.PoeService {

    @Autowired
    PoeRepository poeRepository;

    @Autowired
    private ModelMapper modelMapper;

    public Collection<PoeDto> findAll() {
        return StreamUtils.toStream(this.poeRepository.findAll())
                .map(poeEntity -> modelMapper.map(poeEntity, PoeDto.class))
                .toList();
    }

    @Override
    public Optional<PoeDto> findById(long id) {
        return this.poeRepository.findById(id)
                .map(poeEntity -> modelMapper.map(poeEntity, PoeDto.class));
    }

    @Override
    public Collection<PoeDto> search(String lastname, String firstname) {
        return null;
    }

    @Override
    public PoeDto add(PoeDto poeDto) {
        Poe poeEntity = modelMapper.map(poeDto, Poe.class);
        this.poeRepository.save(poeEntity); // SQL: insert + id
        return modelMapper.map(poeEntity, PoeDto.class);
    }

    @Override
    public Optional<PoeDto> update(PoeDto poeDto) {
        return this.poeRepository.findById(poeDto.getId())
                .map(poeEntity -> {
                    // update entity object read from db with dto fields
                    modelMapper.map(poeDto, poeEntity);
                    // synchronize with database
                    poeRepository.save(poeEntity); // SQL: update
                    // transform entity updated in dto
                    return modelMapper.map(poeEntity, PoeDto.class);
                });
    }

    @Override
    public boolean remove(long id) {
        // 1st Get the Trainee by its id
        Optional<Poe> optionalPoe = this.poeRepository.findById(id);
        if (optionalPoe.isPresent()) {
            this.poeRepository.delete(optionalPoe.get());
            return true;
        }
        return false;
    }

}
