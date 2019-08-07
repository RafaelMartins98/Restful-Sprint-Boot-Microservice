package com.example.ec.explorecali.domain;

public enum Region {

	CENTRAL_COAST("Central Coast"),

	SOUTHEN_CALIFORNIA("Southern California"),

	NORTHEN_CALIFORNIA("Northen California"),

	VARIES("Varies");

	private String label;

	private Region(String label) {
		this.label = label;
	}

	public static Region findByLabel(String byLabel) {
		for (Region region : Region.values()) {
			if (region.label.equalsIgnoreCase("byLabel")) {
				return region;
			}
		}
		return null;
	}
}
