package ru.hse.list.repository;

import jakarta.annotation.PostConstruct;
import org.springframework.stereotype.Repository;
import ru.hse.list.model.Note;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Repository
public class ListRepositoryImpl implements ListRepository {
    private final List<Note> entityList = new ArrayList<>();

    public ListRepositoryImpl() {
    }

    @Override
    public Optional<Note> findById(Integer id) {
        return entityList.stream().filter(c -> c.id().equals(id)).findFirst();
    }

    @Override
    public boolean existsById(Integer id) {
        return entityList.stream().filter(c -> c.id().equals(id)).count() == 1;
    }

    @Override
    public void save(Note note) {
        entityList.add(note);
    }

    @Override
    public void delete(Integer id) {
        entityList.removeIf(c -> c.id().equals(id));
    }
}
