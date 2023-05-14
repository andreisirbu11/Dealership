package com.example.demo.service;

import com.example.demo.repository.RoleRepo;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentCaptor;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.verify;

@ExtendWith(MockitoExtension.class)
class RoleServiceTest {
    @Autowired
    private RoleService underTest;
    @Mock
    private RoleRepo roleRepo;
    @BeforeEach
    void setUp() {
        underTest = new RoleService(roleRepo);
    }
    @Test
    void itShouldTestIfItReturnsAllRoles() {
        underTest.getAllRoles();
        verify(roleRepo).findAll();
    }
    @Test
    void itShouldTestIfItDeletesAllRoles() {
        underTest.deleteAllRoles();
        verify(roleRepo).deleteAll();
    }
    @Test
    void itShouldTestIfReturnTheRoleNameOfUser() {
        /** given id */
        Long givenId = 1L;
        /** when */
        underTest.getUserRole(givenId);
        /** then */
        ArgumentCaptor<Long> argumentCaptor = ArgumentCaptor.forClass(Long.class);
        verify(roleRepo).getUserRole(argumentCaptor.capture());
        Long capturedId = argumentCaptor.getValue();
        assertThat(givenId).isEqualTo(capturedId);
    }
}