package com.webetapi.api.JPATest;

import com.webetapi.api.repository.EmployeeRepository;
import com.webetapi.api.repository.MovieRepository;
import javafx.application.Application;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.assertj.core.api.Assertions.*;

//@RunWith(SpringRunner.class)
@SpringBootTest
public class DeleteEmployeeFromRepository {

    @Autowired
    private EmployeeRepository employeeRepository;

    @Autowired
    private MovieRepository movieRepository;

    long id=1;

    @Test
    public void whenDeleteByIdEmployee_thenDeletingShouldBeSuccessful() {
        employeeRepository.deleteById(id);
        assertThat(employeeRepository.count()).isEqualTo(2);
        // 2 car chargement de 2 users au démarrage via le data.sql
    }

    @Test
    public void whenDeleteAllFromEmployeeRepository_thenRepositoryShouldBeEmpty() {
        employeeRepository.deleteAll();
        assertThat(employeeRepository.count()).isEqualTo(0);
        // test de la persistence des données dans la data base après un delete - il y a 6 movies lors du chargement
        assertThat(movieRepository.count()).isEqualTo(6);
    }

}
