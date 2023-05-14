package com.example.demo.service;

import com.example.demo.model.User;
import com.example.demo.model.Vehicle;
import com.example.demo.repository.VehicleRepo;
import org.assertj.core.api.AtomicBooleanAssert;
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
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class VehicleServiceTest {
    @Autowired
    private VehicleService underTest;
    @Mock
    private VehicleRepo vehicleRepo;
    @BeforeEach
    void setUp() {
        underTest =  new VehicleService(vehicleRepo);
    }
    @Test
    void itShouldTestIfReturnsAllVehicles() {
        underTest.getAllVehicles();
        verify(vehicleRepo).findAll();
    }
    @Test
    void itShouldTestIfReturnsVehicleWithGivenId() {
        /** given ID */
        Long givenId = 0L;
        underTest.getVehicleById(givenId);
        ArgumentCaptor<Long> argumentCaptor = ArgumentCaptor.forClass(Long.class);
        verify(vehicleRepo).getVehicleById(argumentCaptor.capture());
        Long capturedId = argumentCaptor.getValue();
        assertThat(givenId).isEqualTo(capturedId);
    }
    @Test
    void itShouldTestIfReturnsAllVehiclesWithGivenBrand() {
        /** given brand */
        String givenBrand = "BMW";
        underTest.getAllVehiclesByBrand(givenBrand);
        ArgumentCaptor<String> argumentCaptor = ArgumentCaptor.forClass(String.class);
        verify(vehicleRepo).getAllVehiclesByBrand(argumentCaptor.capture());
        String capturedBrand = argumentCaptor.getValue();
        assertThat(givenBrand).isEqualTo(capturedBrand);
    }
    @Test
    void itShouldTestIfDeletesAllVehicles() {
        underTest.deleteAllVehicles();
        verify(vehicleRepo).deleteAll();
    }
    @Test
    void itShouldTestIfDeletesVehicleWithGivenId() {
        /** given ID */
        Long givenId = 0L;
        underTest.deleteVehicleById(givenId);
        ArgumentCaptor<Long> argumentCaptor = ArgumentCaptor.forClass(Long.class);
        verify(vehicleRepo).deleteById(argumentCaptor.capture());
        Long capturedId = argumentCaptor.getValue();
        assertThat(givenId).isEqualTo(capturedId);
    }
    @Test
    void itShouldTestIfReturnsAllTheCarsOrderedByUser() {
        /** given id */
        Long givenId = 1L;
        /** when */
        underTest.getBrandModelName(givenId);
        /** then */
        ArgumentCaptor<Long> argumentCaptor = ArgumentCaptor.forClass(Long.class);
        verify(vehicleRepo).getBrandModelName(argumentCaptor.capture());
        Long capturedId = argumentCaptor.getValue();
        assertThat(givenId).isEqualTo(capturedId);
    }
    @Test
    void itShouldTestIfInsertsNewVehicle() {
        /** given vehicle */
        Vehicle givenVehicle = new Vehicle(
                4L,
                "Lexus",
                "LFA",
                "Sports",
                210L,
                1000L
        );
        /** when */
        underTest.insertNewVehicle(givenVehicle);
        /** then */
        ArgumentCaptor<Vehicle> argumentCaptor = ArgumentCaptor.forClass(Vehicle.class);
        verify(vehicleRepo).save(argumentCaptor.capture());
        Vehicle capturedVehicle = argumentCaptor.getValue();
        assertThat(givenVehicle).isEqualTo(capturedVehicle);
    }
    @Test
    void itShouldTestIfVehicleIsUpdated() {
        Vehicle foundVehicle = new Vehicle(
                2L,
                "BMW",
                "Series 7",
                "Luxury Sedan",
                170L,
                100L
        );
        /** given vehicle */
        Long givenId = 2L;
        Vehicle givenVehicle = new Vehicle(
                givenId,
                "BMW",
                "730i",
                "Sedan",
                170L,
                100L
        );
        when(vehicleRepo.getVehicleById(givenId)).thenReturn(foundVehicle);
        Vehicle newVehicle = underTest.updateVehicleById(givenId, givenVehicle);
        assertThat(givenVehicle.getId().equals(newVehicle.getId()));
        assertThat(givenVehicle.getBrand().equals(newVehicle.getBrand()));
        assertThat(givenVehicle.getModel().equals(newVehicle.getModel()));
        assertThat(givenVehicle.getClaSS().equals(newVehicle.getClaSS()));
        assertThat(givenVehicle.getTopSpeed().equals(newVehicle.getTopSpeed()));
        assertThat(givenVehicle.getPrice().equals(newVehicle.getPrice()));
    }
    @Test
    void itShouldTestIfPriceAreIncreased() {
        /** when */
        underTest.increasePrice();
        /** then */
        verify(vehicleRepo).increasePrice();
    }
    @Test
    void itShouldTestIfDiscountIsApplied() {
        /** given brand */
        String givenBrand = "BMW";
        /** when */
        underTest.discount(givenBrand);
        /** then */
        ArgumentCaptor<String> argumentCaptor = ArgumentCaptor.forClass(String.class);
        verify(vehicleRepo).discount(argumentCaptor.capture());
        String capturedBrand = argumentCaptor.getValue();
        assertThat(givenBrand).isEqualTo(capturedBrand);
    }
}