package eu.stefanangelov.event.persistence.entity;

import javax.persistence.Entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Data
@Entity
public class Room extends BaseEntity {
	private String name;

	public Room(String id, String name) {
		this.setId(id);
		this.name = name;
	}
}


