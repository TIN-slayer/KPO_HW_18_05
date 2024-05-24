package ru.hse.list.service;

import ru.hse.list.model.Note;

public interface ListService {
    Note findById(Integer id);

    void create(Integer id, String todo);

    void delete(Integer id);
}
