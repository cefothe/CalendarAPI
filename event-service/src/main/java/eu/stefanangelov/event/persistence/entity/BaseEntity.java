package eu.stefanangelov.event.persistence.entity;

import java.util.UUID;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;
import javax.persistence.PrePersist;
import javax.validation.constraints.NotNull;

import lombok.Data;

@Data
@MappedSuperclass
public abstract class BaseEntity {

	@Id
	@Column(columnDefinition = "CHAR(36)", unique = true)
	@NotNull
	private String id;

	@PrePersist
	public void generateId() {
		if (this.id == null) {
			this.id = UUID.randomUUID().toString();
		}
	}
}
