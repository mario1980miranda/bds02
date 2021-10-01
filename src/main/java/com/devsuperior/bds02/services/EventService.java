package com.devsuperior.bds02.services;

import javax.persistence.EntityNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.devsuperior.bds02.dto.EventDTO;
import com.devsuperior.bds02.entities.City;
import com.devsuperior.bds02.entities.Event;
import com.devsuperior.bds02.repositories.EventRepository;
import com.devsuperior.bds02.services.exceptions.ResourceNotFoundException;

@Service
public class EventService {

	@Autowired
	private EventRepository repository;

	@Transactional(readOnly = true)
	public EventDTO update(final Long id, final EventDTO dto) {
		try {
			Event inputEntity = repository.getOne(id);
			inputEntity.setName(dto.getName());
			inputEntity.setUrl(dto.getUrl());
			inputEntity.setDate(dto.getDate());
			inputEntity.setCity(new City(dto.getCityId(), null));
			final Event resultEntity = repository.save(inputEntity);
			return new EventDTO(resultEntity);
		} catch (final EntityNotFoundException e) {
			throw new ResourceNotFoundException("Id not found : " + id);
		}
	}

}
