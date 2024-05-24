package ru.hse.list.api;

import ru.hse.list.model.Note;

public interface ListApi {
    Note findById(Integer id);

    void create(Integer id, String todo);

    void delete(Integer id);
}
