package com.sumitava.todo;

import com.sumitava.todo.controller.TodoController;
import com.sumitava.todo.services.TodoItemService;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import static org.mockito.Mockito.mock;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

public class ControllerTest {
    private static MockMvc mockMvc;

    @BeforeAll
    public static void setup() {
        TodoItemService service = mock(TodoItemService.class);
        TodoController todoController = new TodoController();
        todoController.setService(service);
        mockMvc = MockMvcBuilders.standaloneSetup(todoController).build();
    }

    @Test
    public void testAddTodoMinimal() throws Exception{
        String json = "{\"title\": \"First\", \"startDate\": \"2023-11-10\"}";
        addWebCall(json);
    }

    @Test
    public void testAddTodoDescription() throws Exception{
        String json = "{\"title\":\"First\",\"startDate\":\"2023-11-10\",\"description\":\"Hello\"}";
        addWebCall(json);
    }

    @Test
    public void testGetAllItems(){

    }

    private static void addWebCall(String json) throws Exception {
        mockMvc.perform(post("/todo/add")
                        .contentType("application/json")
                        .content(json))
                .andExpect(status().isOk());
    }

    @Test
    public void postWebCall() throws Exception {
        mockMvc.perform(get("/todo/getAllTodoIds")).andExpect(status().isOk()).toString();
    }
}
