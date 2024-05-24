package ru.hse.list.service;

import org.springframework.stereotype.Service;
import ru.hse.list.exception.IDAlreadyExistsException;
import ru.hse.list.exception.IDNotFoundException;
import ru.hse.list.model.Note;
import ru.hse.list.repository.ListRepository;

@Service
public class ListServiceImpl implements ListService {

    private final ListRepository listRepositoryImpl;

    public ListServiceImpl(ListRepository listRepositoryImpl) {
        this.listRepositoryImpl = listRepositoryImpl;
    }

    @Override
    public Note findById(Integer id) {
        return listRepositoryImpl.findById(id)
                .orElseThrow(IDNotFoundException::new);
    }

    @Override
    public void create(Integer id, String todo) {
        if (listRepositoryImpl.existsById(id)){
            throw new IDAlreadyExistsException();
        }
        listRepositoryImpl.save(new Note(id, todo));
    }

    @Override
    public void delete(Integer id) {
        if (!listRepositoryImpl.existsById(id)){
            throw new IDNotFoundException();
        }
        listRepositoryImpl.delete(id);
    }
}
