package com.mum.ea.entities;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalTime;

import javax.persistence.Embeddable;

import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;

@Embeddable
public class CreationInfo implements Serializable {

	private LocalDate creationDate;
	private LocalTime creationTime;

	public CreationInfo() {
	}

	public CreationInfo(LocalDate creationDate, LocalTime creationTime) {
		this.creationDate = creationDate;
		this.creationTime = creationTime;
	}

	public LocalDate getCreationDate() {
		return creationDate;
	}

	public void setCreationDate(LocalDate creationDate) {
		this.creationDate = creationDate;
	}

	public LocalTime getCreationTime() {
		return creationTime;
	}

	public void setCreationTime(LocalTime creationTime) {
		this.creationTime = creationTime;
	}

	@Override
	public int hashCode() {
		return new HashCodeBuilder().append(creationDate).append(creationTime).toHashCode();
	}

	@Override
	public boolean equals(Object obj) {
		if (obj instanceof CreationInfo) {
			final CreationInfo other = (CreationInfo) obj;
			return new EqualsBuilder().append(creationDate, other.creationDate).append(creationTime, other.creationTime)
					.isEquals();
		} else {
			return false;
		}
	}

}
