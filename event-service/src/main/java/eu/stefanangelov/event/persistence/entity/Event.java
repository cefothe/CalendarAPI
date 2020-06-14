package eu.stefanangelov.event.persistence.entity;


import java.time.LocalDateTime;
import java.util.List;

import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@NoArgsConstructor
@Data
@Entity
public class Event extends BaseEntity {
	private String title;
	@Embedded
	private Availability availability;
	@OneToOne
	private User createdBy;
	private LocalDateTime createdAt;
	@OneToMany
	private Room room;
	@ManyToMany
	private List<User> participants;
}