package com.common.enumdata;

public enum DateEnum {
	DATE_FORMAT("dd/MM/yyyy"),
	DATE_TIME_FORMAT("dd/MM/yyyy HH:mm");

	private final String value;

	private DateEnum(String value) {
		this.value = value;
	}

	/**
	 * Return the reason phrase of this status code.
	 */
	public String getValue() {
		return value;
	}
}
