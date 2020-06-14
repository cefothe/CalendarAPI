package eu.stefanangelov.event.persistence.repository;

import eu.stefanangelov.event.persistence.entity.Event;

import org.springframework.data.repository.CrudRepository;

public interface EventRepository extends CrudRepository<Event, String> {
}
