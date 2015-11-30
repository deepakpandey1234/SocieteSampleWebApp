package com.deepak.test;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import com.deepak.societe.com.SocieteSampleWebApp.HomeController;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations="classpath:testContext.xml")
@WebAppConfiguration
public class ControllerTest {
   private MockMvc mockMvc;
   
   @Autowired
   private ITodoTest todoTestmock;
   
   @Before
   public void setUp() {
       Mockito.reset(todoTestmock);

       mockMvc = MockMvcBuilders.standaloneSetup(new HomeController()).build();
   }
   
   @Test
   public void get_allUsers(){
	   try {
		mockMvc.perform(get("/SocieteSampleWebApp/getAll")).andExpect(status().isOk());
	} catch (Exception e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
   }
}
