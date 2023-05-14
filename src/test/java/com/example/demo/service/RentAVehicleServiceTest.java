package com.example.demo.service;

import com.example.demo.repository.RentAVehicleRepo;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentCaptor;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.mockito.Mockito.verify;

/** after each test this automatically close the conexions */
@ExtendWith(MockitoExtension.class)
class RentAVehicleServiceTest {
    @Autowired
    private RentAVehicleService underTest;
    /** this is a mocked representation of the repository
     * which is already implemented and tested behind the framework
     * we only need to mimic the behaviour of it
     * we do not need the real repository nor the real database
     */
    @Mock
    private RentAVehicleRepo rentAVehicleRepo;
    /** we give a fresh instance of the service before each test */
    @BeforeEach
    void setUp() {
        underTest = new RentAVehicleService(rentAVehicleRepo);
    }
    @Test
    void itShouldTestIfAllOrdersAreFound() {
        /** when we call the function getAllOrders() */
        underTest.getAllOrders();
        /** we expect the function findAll() from the repository to be called */
        verify(rentAVehicleRepo).findAll();
    }
    @Test
    void itShouldTestIfAllOrdersAreDeleted() {
        /** when we call the function deleteAllOrders() */
        underTest.deleteAllOrders();
        /** we expect the function deleteAll from the repository to be called */
        verify(rentAVehicleRepo).deleteAll();
    }
    @Test
    void itShouldTestIfOrderIsDeletedById() {
        /** given ID */
        Long givenId = 0L;
        underTest.deleteOrderById(givenId);
        ArgumentCaptor<Long> argumentCaptor = ArgumentCaptor.forClass(Long.class);
        verify(rentAVehicleRepo).deleteById(argumentCaptor.capture());
        Long capturedId = argumentCaptor.getValue();
        assertThat(capturedId).isEqualTo(givenId);
    }
    @Test
    void itShouldTestIfOrderIsFoundById() {
        /** with a given ID */
        Long givenId = 0L;
        /** We call the function getOrderById() from the repository */
        underTest.getOrderById(givenId);
        /** this will capture the argument which is passed by the service method to the
         * findOrderById function from the repository */
        ArgumentCaptor<Long> argumentCaptor = ArgumentCaptor.forClass(Long.class);
        verify(rentAVehicleRepo).findOrderById(argumentCaptor.capture());
        /** we save the value in a variable */
        Long capturedId = argumentCaptor.getValue();
        /** we expect the capturedValue to be equal to the given one */
        assertThat(capturedId).isEqualTo(givenId);
    }
    @Test
    void itShouldTestIfAllOrdersAreFoundByUserId() {
        /** exactly same as above */
        Long givenId = 0L;
        underTest.getAllOrdersByUserId(givenId);
        ArgumentCaptor<Long> argumentCaptor = ArgumentCaptor.forClass(Long.class);
        verify(rentAVehicleRepo).findOrdersByUserId(argumentCaptor.capture());
        Long capturedId = argumentCaptor.getValue();
        assertThat(capturedId).isEqualTo(givenId);
    }
    @Test
    void itShouldTestIfAllOrdersAreFoundByVehicleId() {
        /** same as above */
        Long giveId = 0L;
        underTest.getAllOrdersByVehicleId(giveId);
        ArgumentCaptor<Long> argumentCaptor = ArgumentCaptor.forClass(Long.class);
        verify(rentAVehicleRepo).findOrdersByVehicleId(argumentCaptor.capture());
        Long capturedId = argumentCaptor.getValue();
        assertThat(capturedId).isEqualTo(giveId);
    }
}