package com.rohan.emp;

import com.rohan.emp.controller.EmpController;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

@RunWith(SpringRunner.class)
@SpringBootTest
public class EmpAppTests {
    /*@Autowired 
    private MockMvc mockMvc;*/
private MockMvc mockMvc;

@Before
public void setUp() {
    EmpController productController= new EmpController();       
    mockMvc = MockMvcBuilders.standaloneSetup(productController).build();
}
    @Test
    public void contextLoads() {
    }
    

    @Test
    public void addEmp() throws Exception {
        String empJson = "{\"firstName\":\"Tur\", \"lastName\":\"Mak\", \"dateOfBirth\":\"12-05-1085\", \"dateOfEmployment\":\"12-05-1085\"}";
        this.mockMvc.perform(post("http://localhost:8080/employees")
                .contentType(MediaType.APPLICATION_JSON)
                .content(empJson))
                .andExpect(status().isCreated());
    }

}
