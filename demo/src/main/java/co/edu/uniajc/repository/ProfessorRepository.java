package co.edu.uniajc.repository;

import co.edu.uniajc.model.ProfessorModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ProfessorRepository extends JpaRepository<ProfessorModel, Long> {

    Optional<ProfessorModel> findById(Long id);

    List<ProfessorModel> findAllByNameContains(String name);

    List<ProfessorModel> findAllByDepartment(String department);


}
