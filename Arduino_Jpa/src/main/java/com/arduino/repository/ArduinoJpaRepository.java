package com.arduino.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.arduino.domain.ArduinoEntity;

public interface ArduinoJpaRepository extends JpaRepository<ArduinoEntity, String>{

}
