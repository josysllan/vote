package br.com.voting.vote.services.impl;

import br.com.voting.vote.dtos.AssociateDTO;
import br.com.voting.vote.models.Associate;
import br.com.voting.vote.repositories.AssociateRepository;
import br.com.voting.vote.services.AssociateService;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AssociateServiceImpl implements AssociateService {

    private final AssociateRepository repository;

    public AssociateServiceImpl(AssociateRepository repository) {
        this.repository = repository;
    }

    @Transactional
    @Override
    public void createAssociate(AssociateDTO associateDTO) {
        Associate associate = new Associate();
        associate.setName(associateDTO.getName());
        associate.setCpf(associateDTO.getCpf());

        repository.save(associate);
    }

    @Override
    public List<Associate> findAll() {
        return repository.findAll();
    }

    @Override
    public Associate findById(String id) {
        Optional<Associate> associateOptional = repository.findById(Long.parseLong(id));

        if(associateOptional.isEmpty()){
            throw new RuntimeException("Associado não encontrado");
        }

        return associateOptional.get();
    }

    @Override
    public void deleteAssociate(String id) {
        Associate associate = findById(id);

        if(associate != null){
            repository.delete(associate);
        }
    }

    @Transactional
    @Override
    public void updateAssociate(AssociateDTO associateDTO, String id) {
        Associate associate = findById(id);
        if(associate != null){
            associate.setCpf(associateDTO.getCpf());
            associate.setName(associateDTO.getName());
            repository.save(associate);
        }
    }
}
