package com.satya.todomanagement;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

import java.util.Date;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import com.satya.todomanagement.model.Todo;
import com.satya.todomanagement.repository.TodoRepository;
import com.satya.todomanagement.service.TodoService;


@RunWith(SpringRunner.class)
@SpringBootTest
public class TodoManagementSpringBoot2ApplicationTests {

	@Autowired
	private TodoService service;

	@MockBean
	private TodoRepository repository;

	@Test
	public void geTodosByUserTest() {
		when(repository.findAll()).thenReturn(Stream
				.of(new Todo("admin", "My test task-1", new Date(2020,05,05),false), new Todo("admin", "My test task-2", new Date(2020,06,05),false)).collect(Collectors.toList()));
		assertEquals(2, service.getTodosByUser("admin").size());
	}


}