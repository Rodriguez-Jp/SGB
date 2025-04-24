package co.edu.uniajc.service;

import co.edu.uniajc.model.StudentModel;
import co.edu.uniajc.repository.StudentRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import static org.mockito.BDDMockito.given;

@ExtendWith(SpringExtension.class)
class StudentServiceTest {

    @Mock
    private StudentRepository studentRepositoryMock;

    private StudentService studentService;

    @BeforeEach
    void setUp() {
        studentService = new StudentService(studentRepositoryMock);
    }

    @Test
    void When_CreateStudent_Expect_CreateStudent_In_BD() {
        var student = StudentModel.builder()
                .id(1L)
                .name("Student")
                .lastName("Last Name")
                .age(18)
                .state(true).build();

        given(studentRepositoryMock.save(student)).willReturn(student);

        studentService.createStudent(student);
    }

}