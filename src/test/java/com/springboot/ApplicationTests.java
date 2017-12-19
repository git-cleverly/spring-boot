package com.springboot;

import com.springboot.comm.VersionProperties;
import com.springboot.domain.User;
import com.springboot.repository.UserRepository;
import com.springboot.web.HelloWorldController;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import javax.annotation.Resource;

import java.text.DateFormat;
import java.util.Date;

import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ApplicationTests {

    private MockMvc mockMvc;

    @Resource
    private VersionProperties properties;

    @Resource
    private UserRepository userRepository;

    @Test
    public void contextLoads() {
    }

    @Before
    public void setUp() throws Exception {
        mockMvc = MockMvcBuilders.standaloneSetup(new HelloWorldController()).build();
    }

    @Test
    public void hello() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.post("/hello?name=小明").accept(MediaType.APPLICATION_JSON_UTF8)).andDo(print());
    }

    @Test
    public void getUser() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/getUser").accept(MediaType.APPLICATION_JSON_UTF8)).andDo(print());
    }

    @Test
    public void getUsers() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/getUsers").accept(MediaType.APPLICATION_JSON_UTF8)).andDo(print());
    }

    @Test
    public void get() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/get").accept(MediaType.APPLICATION_JSON_UTF8)).andDo(print());
    }

    @Test
    public void save() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.post("/save/").param("age", "160").accept(MediaType.APPLICATION_JSON_UTF8)).andDo(print());
    }

    @Test
    public void getProperties() throws Exception {
        System.out.println("title:" + properties.getName());
        System.out.println("description:" + properties.getDescription());
    }

    @Test
    public void test()  {
        Date date = new Date();
        DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG);
        String formattedDate = dateFormat.format(date);
    }

}
