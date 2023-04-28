package com.ecoveco.VasDatabaseApp.service;

import com.ecoveco.VasDatabaseApp.mapper.StateMapper;
import com.ecoveco.VasDatabaseApp.repository.StateRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.mockito.Mockito.verify;

@ExtendWith(MockitoExtension.class)
class StateServiceTest {
    @Mock
    private StateRepository stateRepository;
    private StateMapper stateMapper = new StateMapper();

    private StateService underTest;

    @BeforeEach
    void setUp() {
        underTest = new StateService(stateRepository, stateMapper);
    }

    @Test
    @DisplayName("Get all states")
    void testGetAllStates() {
        // when
        underTest.getAllStates();

        // then
        verify(stateRepository).findAll();
    }
}