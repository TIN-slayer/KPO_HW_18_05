package ru.hse.list.service;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import ru.hse.list.exception.IDAlreadyExistsException;
import ru.hse.list.exception.IDNotFoundException;
import ru.hse.list.model.Note;
import ru.hse.list.repository.ListRepository;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class ListServiceTest {

    @Mock
    private ListRepository listRepository;

    @InjectMocks
    private ListServiceImpl listService;

    @Test
    public void findById_IDIsPresent_returnEntity(){
        Note testNote = new Note(2, "Wash your dishes");

        when(listRepository.findById(2)).thenReturn(Optional.of(testNote));
        Note note = listService.findById(2);

        assertEquals(testNote, note);
    }

    @Test
    public void findById_IDIsPresent_throwException(){
        when(listRepository.findById(2)).thenReturn(Optional.empty());

        assertThrows(IDNotFoundException.class, () -> listService.findById(2));
    }

    @Test
    public void create_IDNotExists_doesntThrowException(){
        when(listRepository.existsById(2)).thenReturn(false);
        doNothing().when(listRepository).save(new Note(2, "Wash your dishes"));

        assertDoesNotThrow(() -> listService.create(2, "Wash your dishes"));
    }

    @Test
    public void create_IDExists_throwException(){
        when(listRepository.existsById(2)).thenReturn(true);

        assertThrows(IDAlreadyExistsException.class, () -> listService.create(2, "Wash your dishes"));
    }

    @Test
    public void delete_IDExists_doesntThrowException(){
        when(listRepository.existsById(2)).thenReturn(true);
        doNothing().when(listRepository).delete(2 );

        assertDoesNotThrow(() -> listService.delete(2));
    }

    @Test
    public void delete_IDNotExists_throwException(){
        when(listRepository.existsById(2)).thenReturn(false);

        assertThrows(IDNotFoundException.class, () -> listService.delete(2));
    }
}
