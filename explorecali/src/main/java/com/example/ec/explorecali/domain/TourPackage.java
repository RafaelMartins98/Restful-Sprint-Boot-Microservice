package com.example.ec.explorecali.domain;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class TourPackage implements Serializable {

	private static final long serialVersionUID = -2871667067086455007L;

	@Id
	private String code;

	@Column
	private String name;

	
    protected TourPackage() {
    }
    
	public TourPackage(String code, String name) {
		super();
		this.code = code;
		this.name = name;
	}

	@Override
	public String toString() {

		StringBuilder sb = new StringBuilder();

		sb.append("TourPackage{");
		sb.append("code='").append(code).append("\'");
		sb.append("name='").append(name).append("\'}");

		return sb.toString();
	}

	@Override
	public boolean equals(Object o) {

		if (this == o) {
			return true;
		} else if (o instanceof TourPackage) {
			TourPackage tp = (TourPackage) o;
			return code.equals(tp.getCode()) && name.equals(tp.getName());
		}

		return false;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

}
