package eu.stefanangelov.event.persistence.entity;

import javax.persistence.Entity;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@NoArgsConstructor
@Data
@Entity
public class User extends BaseEntity{
	private String username;

	public User(String id, String username) {
		this.setId(id);
		this.username = username;
	}
}
