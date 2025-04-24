package co.edu.uniajc.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "professor")

public class ProfessorModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "pf_id")
    private Long id;

    @Column(name = "pf_name")
    private String name;

    @Column(name = "pf_last_name")
    private String lastName;

    @Column(name = "pf_department")
    private String department;

    @Column(name = "pf_email")
    private String email;

    @Column(name = "pf_state")
    private Boolean state;
}
