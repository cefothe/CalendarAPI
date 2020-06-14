package eu.stefanangelov.event.persistence.entity;

import javax.persistence.Entity;

import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Data
@Entity
public class Room extends BaseEntity {
	private String name;
}
