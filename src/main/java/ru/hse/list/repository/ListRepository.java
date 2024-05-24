package ru.hse.list.repository;

import ru.hse.list.model.Note;

import java.util.Optional;

public interface ListRepository {
    Optional<Note> findById(Integer id);

    boolean existsById(Integer id);

    void save(Note note);

    void delete(Integer id);
}
