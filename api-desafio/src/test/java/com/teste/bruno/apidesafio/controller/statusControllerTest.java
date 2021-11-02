package com.teste.bruno.apidesafio.controller;

import com.teste.bruno.apidesafio.AbstractControllerTest;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

public class statusControllerTest extends AbstractControllerTest {

    @Before
    public void setUp() {
        super.setUp();
    }

    @Test
    public void testCheck() throws Exception {
        String uri = "/api/status";

        MvcResult result = mvc.perform(MockMvcRequestBuilders.get(uri)).andReturn();

        String content = result.getResponse().getContentAsString();
        int status = result.getResponse().getStatus();

        Assert.assertEquals(content, "Online");
        Assert.assertEquals(status, 200);
    }
}
