package com.arduino.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.arduino.repository.ArduinoJpaRepository;

@Service("ArduinoService")
@Transactional
public class ArduinoServiceImpl implements ArduinoService {
	
	@Autowired
	private ArduinoJpaRepository arduinoJpaRepository;
	
	@Override
	public List listArduino() {
		return arduinoJpaRepository.findAll();
	}

}
