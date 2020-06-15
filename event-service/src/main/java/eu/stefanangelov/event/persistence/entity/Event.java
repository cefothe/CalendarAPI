package eu.stefanangelov.event.persistence.entity;


import java.time.LocalDateTime;
import java.util.List;

import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.Index;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

import javax.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;

@AllArgsConstructor
@Data
@Entity
@Table(indexes = @Index(name = "availability", columnList ="fromDate,toDate"))
public class Event extends BaseEntity {
	private String title;
	@Embedded
	private Availability availability;
	@OneToOne
	private User createdBy;
	private LocalDateTime createdAt;
	@ManyToOne
	private Room room;
	@ManyToMany
	private List<User> participants;
}
