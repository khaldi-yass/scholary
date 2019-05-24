package com.yassir.scholary.controllers;

import com.yassir.scholary.AbstractWebApplicationTest;
import com.yassir.scholary.dtos.UserDto;
import com.yassir.scholary.models.UserModel;
import com.yassir.scholary.utils.Constants.UserApiURIs;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import uk.co.jemos.podam.api.PodamFactory;
import uk.co.jemos.podam.api.PodamFactoryImpl;

public class UserControllerTest extends AbstractWebApplicationTest {

    @Override
    @Before
    public void setup() {
        super.setup();
    }

    @Test
    public void shouldFindAllUsers() throws Exception {
        MvcResult
                result =
                mvc.perform(MockMvcRequestBuilders.get(UserApiURIs.GET_ALL).accept(MediaType.APPLICATION_JSON))
                        .andReturn();
        int status = result.getResponse().getStatus();
        Assert.assertEquals(200, status);
        String content = result.getResponse().getContentAsString();
        UserDto[] users = fromJson(content, UserDto[].class);
        Assert.assertTrue(users.length > 0);
    }

    @Test
    public void shouldCreateUser() throws Exception {
        PodamFactory podamFactory = new PodamFactoryImpl();
        UserModel user = podamFactory.manufacturePojo(UserModel.class);
        String jsonInput = toJson(user);
        MvcResult
                result =
                mvc.perform(MockMvcRequestBuilders.post(UserApiURIs.CREATE)
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(jsonInput)).andReturn();
        int status = result.getResponse().getStatus();
        Assert.assertEquals(201, status);
        String content = result.getResponse().getContentAsString();
        Assert.assertEquals(content, "Successfully created.");
    }
}
