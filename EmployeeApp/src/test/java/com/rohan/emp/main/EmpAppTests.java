package com.rohan.emp.main;

import com.rohan.emp.controller.EmpController;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;

@RunWith(SpringRunner.class)
@WebMvcTest(EmpController.class)
public class EmpAppTests {
    @Autowired 
    private MockMvc mockMvc;
    @Test
    public void contextLoads() {
    }
    

    @Test
    public void addEmp() throws Exception {
        String empJson = "{\"firstName\":\"Tur\", \"lastName\":\"Mak\", \"dateOfBirth\":\"12-05-1085\", \"dateOfEmployment\":\"12-05-1085\"}";
        this.mockMvc.perform(post("/employee/add")
                .contentType(MediaType.APPLICATION_JSON)
                .content(empJson))
                .andExpect(status().isCreated());
    }

}
