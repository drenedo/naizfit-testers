package me.renedo.naizfit.testers.infraestructure.jpa;

import java.time.LocalDate;
import java.util.Set;
import java.util.UUID;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "tester")
public class TesterEntity {

    @Id
    private UUID id;

    private String name;

    private String email;

    private String password;

    @Column(name = "birth_date")
    private LocalDate birthDate;

    private String sex;

    private Integer testsDone;

    @OneToMany(mappedBy = "tester", fetch = FetchType.EAGER)
    private Set<MeasureEntity> measures;

    public TesterEntity() {
    }

    public TesterEntity(UUID id, String name, String email, String password, LocalDate birthDate, String sex, Integer testsDone,
            Set<MeasureEntity> measures) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.password = password;
        this.birthDate = birthDate;
        this.sex = sex;
        this.testsDone = testsDone;
        this.measures = measures;
    }

    public UUID getId() {
        return id;
    }

    public Set<MeasureEntity> getMeasures() {
        return measures;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }

    public LocalDate getBirthDate() {
        return birthDate;
    }

    public String getSex() {
        return sex;
    }

    public Integer getTestsDone() {
        return testsDone;
    }
}
