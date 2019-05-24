package com.yassir.scholary.controllers;

import com.yassir.scholary.AbstractWebApplicationTest;
import com.yassir.scholary.dtos.UserDto;
import com.yassir.scholary.models.UserModel;
import com.yassir.scholary.services.UserService;
import com.yassir.scholary.utils.Constants.UserApiURIs;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import uk.co.jemos.podam.api.PodamFactory;
import uk.co.jemos.podam.api.PodamFactoryImpl;

public class UserControllerTest extends AbstractWebApplicationTest {

    @Autowired
    UserService userService;

    @Override
    @Before
    public void setup() {
        super.setup();
    }

    @Test
    public void shouldFindAllUsers() throws Exception {
        MvcResult result = findAll();
        int status = result.getResponse().getStatus();
        Assert.assertEquals(200, status);
        UserDto[] users = fromJson(result.getResponse().getContentAsString(), UserDto[].class);
        Assert.assertTrue(users.length > 0);
    }

    @Test
    public void shouldFindUserById() throws Exception {
        long id = userService.getAvailableUserIds().get(0);
        MvcResult result = findById(id);
        int status = result.getResponse().getStatus();
        Assert.assertEquals(200, status);
        UserDto user = fromJson(result.getResponse().getContentAsString(), UserDto.class);
        Assert.assertNotNull(user);
    }

    @Test
    public void shouldCreateUser() throws Exception {
        PodamFactory podamFactory = new PodamFactoryImpl();
        UserDto user = mapper.toUserDto(podamFactory.manufacturePojo(UserModel.class));
        String jsonInput = toJson(user);
        MvcResult result = createNew(jsonInput);
        int status = result.getResponse().getStatus();
        Assert.assertEquals(201, status);
        String content = result.getResponse().getContentAsString();
        Assert.assertEquals("Successfully created.", content);
    }

    @Test
    public void shouldUpdateUser() throws Exception {
        long id = userService.getAvailableUserIds().get(0);
        MvcResult result = findById(id);
        UserDto user = fromJson(result.getResponse().getContentAsString(), UserDto.class);
        int uniqueInt = (int) ((System.currentTimeMillis() / 1000) % 10000); //gets int based on current time;
        user.setFirstName("Yassir" + uniqueInt);
        user.setLastName("Khaldi" + uniqueInt);
        String inputJson = toJson(user);
        MvcResult mvcResult = updateById(id, inputJson);
        int status = mvcResult.getResponse().getStatus();
        Assert.assertEquals(200, status);
        String content = mvcResult.getResponse().getContentAsString();
        Assert.assertEquals("Successfully updated.", content);
    }

    @Test
    public void shouldDeleteUser() throws Exception {
        long id = userService.getAvailableUserIds().get(0);
        MvcResult result = deleteById(id);
        int status = result.getResponse().getStatus();
        Assert.assertEquals(200, status);
        String content = result.getResponse().getContentAsString();
        Assert.assertEquals("Successfully deleted.", content);
    }

    private MvcResult findAll() throws Exception {
        return mvc.perform(MockMvcRequestBuilders.get(UserApiURIs.GET_ALL).accept(MediaType.APPLICATION_JSON))
                .andReturn();
    }

    private MvcResult findById(long id) throws Exception {
        return mvc.perform(MockMvcRequestBuilders.get(UserApiURIs.GET_ID + id).accept(MediaType.APPLICATION_JSON))
                .andReturn();
    }

    private MvcResult createNew(String jsonInput) throws Exception {
        return mvc.perform(MockMvcRequestBuilders.post(UserApiURIs.CREATE)
                .contentType(MediaType.APPLICATION_JSON)
                .content(jsonInput)).andReturn();
    }

    private MvcResult updateById(long id, String inputJson) throws Exception {
        return mvc.perform(MockMvcRequestBuilders.put(UserApiURIs.UPDATE + id)
                .contentType(MediaType.APPLICATION_JSON_VALUE)
                .content(inputJson)).andReturn();
    }

    private MvcResult deleteById(long id) throws Exception {
        return mvc.perform(MockMvcRequestBuilders.delete(UserApiURIs.DELETE + id)).andReturn();
    }
}
