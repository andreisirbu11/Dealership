package com.example.demo.service;

import com.example.demo.model.User;
import com.example.demo.repository.UserRepo;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentCaptor;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class UserServiceTest {
    @Autowired
    private UserService underTest;
    /** this is meant to mock the behaviour of the repository which is already implemented and tested
     * in the framework */
    @Mock
    private UserRepo userRepo;
    @BeforeEach
    void setUp() {
        underTest = new UserService(userRepo);
    }
    @Test
    void itShouldTestIfItReturnsAllUsers() {
        /** when we call the method getAll() from Service */
        underTest.getAll();
        /** we expect that the method findAll() from the repo is called */
        verify(userRepo).findAll();
    }
    @Test
    void itShouldTestIfItReturnsAUserWithGivenId() {
        /** given ID */
        Long givenID = 0L;
        /** we call findByID from Service */
        underTest.getUserById(givenID);
        /** then we capture what parameter is send to the save method of the repository */
        ArgumentCaptor<Long> argumentCaptor = ArgumentCaptor.forClass(Long.class);
        verify(userRepo).findUserByID(argumentCaptor.capture());
        /** this represents the captured parameter*/
        Long capturedValue = argumentCaptor.getValue();
        /** we should verify if the given parameter is equal to the captured one */
        assertThat(capturedValue).isEqualTo(givenID);
    }
    @Test
    void itShouldTestIfItDeletesAllUsers() {
        /** when */
        underTest.deleteAll();
        /** then */
        verify(userRepo).deleteAll();
    }
    @Test
    void itShouldTestIfItDeletesUserById() {
        /** given ID */
        Long givenID = 0L;
        underTest.deleteByID(givenID);
        ArgumentCaptor<Long> argumentCaptor = ArgumentCaptor.forClass(Long.class);
        verify(userRepo).deleteById(argumentCaptor.capture());
        Long capturedValue =  argumentCaptor.getValue();
        assertThat(capturedValue).isEqualTo(givenID);
    }
    @Test
    void itShouldTestIfFoundUserByIdIsUpdated() {
        User foundUser = new User(
                1L,
                "Andrei",
                "andreis@gmail.com",
                "0000",
                2L
        );
        /** given ID and User */
        Long givenID = 1L;
        User givenUser = new User(
                givenID,
                "Marius",
                "mariusp@gmail.com",
                "1234",
                1L
        );
        when(userRepo.findUserByID(givenID)).thenReturn(foundUser);
        User newUser = underTest.updateByID(givenID, givenUser);
        assertThat(newUser.getId().equals(givenUser.getId()));
        assertThat(newUser.getEmail().equals(givenUser.getEmail()));
        assertThat(newUser.getName().equals(givenUser.getName()));
        assertThat(newUser.getPassword().equals(givenUser.getPassword()));
        assertThat(newUser.getIdRol().equals(givenUser.getIdRol()));
    }
    @Test
    void itShouldTestIfUserIsInserted() {
        /** given user */
        User givenUser = new User(
                1L,
                "Adrian",
                "adrianp@gmail.com",
                "1234",
                3L
        );
        /** when */
        underTest.insert(givenUser);
        /** then */
        ArgumentCaptor<User> argumentCaptor = ArgumentCaptor.forClass(User.class);
        verify(userRepo).save(argumentCaptor.capture());
        User capturedUser = argumentCaptor.getValue();
        assertThat(capturedUser).isEqualTo(givenUser);
    }
}