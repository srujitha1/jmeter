package com.loginportal.forgotpassword; 

import static org.junit.Assert.*;

import org.apache.http.entity.ContentType;
import org.junit.Before; 

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MvcResult; 

import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import com.loginportal.forgotpassword.controller.ForgotPasswordController;
import com.loginportal.forgotpassword.model.Request;
import com.loginportal.forgotpassword.model.User;

 @RunWith(SpringRunner.class)
@SpringBootTest
public class ForgotPasswordControllerTest extends AbstractTestClass { 
    @InjectMocks 
    ForgotPasswordController fpc;
 
	String email="shaikneha823@gmail.com";
     @Override 
       @Before 
       public void setUp() { 
          super.setUp(); 
  } 

       @Test 
       public void mailCheck() throws Exception {
    	   
          String uri = "/forgotpassword/uic"; 
         User person=new User(); 
          person.setEmailID(email); 
          String inputJson = super.mapToJson(person); 
         MvcResult mvcResult=mvc.perform(MockMvcRequestBuilders.post(uri)
        		 .contentType(MediaType.APPLICATION_JSON_VALUE)
        		 .content(inputJson)).andReturn();
	 
          int status = mvcResult.getResponse().getStatus();

          assertEquals(200, status); 

         String content = mvcResult.getResponse().getContentAsString(); 
          assertEquals(content,"{\"status\":\"true\"}"); 

       } 


    @Test 
    public void getSecurityQuestions() throws Exception { 

        String uri = "/forgotpassword/mts"; 
         Request person=new Request(); 
          person.setEmail(email);
          person.setChoice(3); 

          String inputJson = super.mapToJson(person); 
          MvcResult mvcResult = mvc.perform(MockMvcRequestBuilders.post(uri) 

             .contentType(MediaType.APPLICATION_JSON_VALUE) 

             .content(inputJson)).andReturn(); 

             int status = mvcResult.getResponse().getStatus(); 

             assertEquals(200, status); 
          
             String content = mvcResult.getResponse().getContentAsString(); 

            assertEquals(content,"{\"question1\":\"what is your favourite team?\",\"question2\":\"what is your favourite movie?\"}"); 

       } 

    @Test 

    public void getSecurityAnswers() throws Exception { 

        String uri = "/forgotpassword/sec"; 

         Request person=new Request(); 
         person.setEmail(email);
          person.setAns2("pink"); 

          person.setAns1("rcb"); 

          String inputJson = super.mapToJson(person); 

          MvcResult mvcResult = mvc.perform(MockMvcRequestBuilders.post(uri) 

             .contentType(MediaType.APPLICATION_JSON_VALUE) 

             .content(inputJson)).andReturn(); 

          int status = mvcResult.getResponse().getStatus(); 

          assertEquals(200, status); 

         String content = mvcResult.getResponse().getContentAsString(); 

          assertEquals(content,"{\"status\":\"true\"}"); 

       } 

    
    @Test 

    public void passwordCheck() throws Exception { 

    	 String uri = "/forgotpassword/set"; 

         Request person=new Request(); 
         person.setEmail(email);
          person.setPwd("Nehashaik@36"); 

           String inputJson = super.mapToJson(person); 

          MvcResult mvcResult = mvc.perform(MockMvcRequestBuilders.post(uri) 

             .contentType(MediaType.APPLICATION_JSON_VALUE) 

             .content(inputJson)).andReturn(); 

         
          int status = mvcResult.getResponse().getStatus(); 

          assertEquals(200, status); 

         String content = mvcResult.getResponse().getContentAsString(); 

          assertEquals(content,"{\"status\":\"false\"}"); 

       } 
        
    
    } 
