package co.edu.uniajc.controller;

import co.edu.uniajc.exception.ProfessorRequestException;
import co.edu.uniajc.model.ProfessorModel;
import co.edu.uniajc.service.ProfessorService;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/professor")
//@Api("Professors")
public class ProfessorController {

    private ProfessorService professorService;

    @Autowired
    public ProfessorController(ProfessorService professorService) {
        this.professorService = professorService;
    }

    @PostMapping(path = "/save")
    //@ApiOperation(value="Insert Professor", response = ProfessorModel.class)
    public ProfessorModel saveProfessor(@RequestBody ProfessorModel professorModel) {
        return professorService.createProfessor(professorModel);
    }

    @PutMapping(path = "/update")
    //@ApiOperation(value="Update Professor", response = ProfessorModel.class)
    public ProfessorModel updateProfessor(@RequestBody ProfessorModel professorModel) {
        return professorService.updateProfessor(professorModel);
    }

    @DeleteMapping(path = "/delete")
    //@ApiOperation(value="Delete Professor by Id", response = ProfessorModel.class)
    public void deleteProfessor(@RequestParam(name = "id") Long id) {
        professorService.deleteProfessor(id);
    }

    @GetMapping(path = "/all")
    //@ApiOperation(value="Find All Professors", response = ProfessorModel.class)
    public List<ProfessorModel> findAllProfessors() {
        return professorService.findAllProfessors();
    }

    @GetMapping(path = "/all/name")
    //@ApiOperation(value="Find Professor by Name", response = ProfessorModel.class)
    public List<ProfessorModel> findAllProfessorsByName(@RequestParam(name = "name") String name) {
        return professorService.findProfessorsByName(name);
    }

    @GetMapping(path = "/all/department")
    //@ApiOperation(value="Find Professors by Department", response = ProfessorModel.class)
    public List<ProfessorModel> findAllProfessorsByDepartment(@RequestParam(name = "department") String department) {
        return professorService.findProfessorsByDepartment(department);
    }

    @GetMapping(path = "/id")
    //@ApiOperation(value="Find Professor by Id", response = ProfessorModel.class)
    @ApiResponses(value = {
            @ApiResponse(responseCode = "400", description = "Something Went Wrong"),
            @ApiResponse(responseCode = "404", description = "No se encontro"),
            @ApiResponse(responseCode = "500", description = "Internal Server Error")
    })
    public ResponseEntity<ProfessorModel> findById(@RequestParam(name = "id") Long id) throws Exception {
        return ResponseEntity.ok(professorService.findById(id)
                .orElseThrow(() -> new ProfessorRequestException("No se encontro"))
        );
    }
}
