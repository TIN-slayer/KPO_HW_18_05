package ru.hse.list.controller;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import ru.hse.list.api.ListApi;
import ru.hse.list.model.Note;
import ru.hse.list.service.ListService;

@RestController
public class ListController implements ListApi {

    private final ListService listServiceImpl;

    public ListController(ListService listServiceImpl) {
        this.listServiceImpl = listServiceImpl;
    }

    @Override
    @GetMapping("/{id}")
    public Note findById(@PathVariable Integer id) {
        return listServiceImpl.findById(id);
    }

    @Override
    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping
    public void create(@RequestParam Integer id, @RequestParam String todo) {
        listServiceImpl.create(id, todo);
    }

    @Override
    @ResponseStatus(HttpStatus.NO_CONTENT)
    @DeleteMapping
    public void delete(Integer id) {
        listServiceImpl.delete(id);
    }
}
