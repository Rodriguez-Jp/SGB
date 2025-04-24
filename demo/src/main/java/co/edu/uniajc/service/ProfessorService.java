package co.edu.uniajc.service;

import co.edu.uniajc.model.ProfessorModel;
import co.edu.uniajc.repository.ProfessorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class ProfessorService {

    private final ProfessorRepository professorRepository;

    @Autowired
    public ProfessorService(ProfessorRepository professorRepository) {
        this.professorRepository = professorRepository;
    }

    public ProfessorModel createProfessor(ProfessorModel professorModel) {
        return professorRepository.save(professorModel);
    }

    public ProfessorModel updateProfessor(ProfessorModel professorModel) {
        return professorRepository.save(professorModel);
    }

    public void deleteProfessor(Long id) {
        professorRepository.deleteById(id);
    }

    public List<ProfessorModel> findAllProfessors() {
        return professorRepository.findAll();
    }

    public List<ProfessorModel> findProfessorsByName(String name) {
        return professorRepository.findAllByNameContains(name);
    }

    public List<ProfessorModel> findProfessorsByDepartment(String department) {
        return professorRepository.findAllByDepartment(department);
    }

    public Optional<ProfessorModel> findById(Long id) {
        return professorRepository.findById(id);
    }
}