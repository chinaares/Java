package com.cutom.exception;

/**
 * @ author Ireslab
 */
public enum ErrorCode {

	NO_DATA_FOUND(101, "No data found"), DB_ERROR(102, "Database error occured"), DATE_PARSER_ERROR(
			103, "Error in date parsing"), RBUM_ERROR(104, "Rbum error"), RBUM_USER_ROLE_REL_EXIST(
			105, "Role is associated with existing user."), FIELDS_MISSING_ERROR(
			004, "Incorrect Request"), RBUM_AUTHENTICATION_ERROR(106,
			"Authentication error"), RBUM_AUTHENTICATION_BAD_CREDENTIAL_ERROR(
			107, "Bad credential"), RBUM_AUTHENTICATION_IN_ACTIVE_ERROR(108,
			"Inactive user"), DATA_PARSER_ERROR(109, "Error in data parsing"), HOURLY_LEAVE_NOT_SUPPORTED(
			110, "Hourly leave not supported yet"), TOKEN_EXPIRED(30,
			"Invalid token or token expired"), UPDATE_LEAVE_ERROR(112,
			"Approved , Rejected and Canceled leaves can't be updated"), ADMIN_UPDATE_LEAVE_ERROR(
			113, "Rejected leaves can't be updated. Apply again."), APPLY_LEAVE_ERROR(
			901, "Leave already applied"), QUOTA_NOT_FOUND_ERROR(114,
			"You do not have any available leave quota(s)."), DEVICE_TIME_ERROR(
			40, "Device time seems out of date.Please correct it"), CONCURRENCY_ERROR(
			115, "Information has been updated by other user"), UPDATE_LEAVE_VERSION_ERROR(
			116, "Leave version not found for update leave"), UPDATE_LEAVE_EMP_ID_ERROR(
			117, "Employee id not found for update leave"), USER_NOT_EXIST_RBUM_ERROR(
			118, "User does not exist in RBUM"), ACTIVE_USER_ASSOCIATED_WITH_DEPARTMENT(
			119, "Active user is associated with this department"), ENCODE_DECODE_NOT_SUPPORT(
			120, "Encode and Decode is not support"), RBUM_AUTHORIZATION_ERROR(
			121, "AuthorizationException error"), RBUM_DUPLICATE_USER(122,
			"Duplicate Rbum use."), INACTIVE_DEPARTMENT(123,
			"Department is inactive"), INACTIVE_GEOGRAPHY(124,
			"Geography is inactive"), OLD_ACTIVATION_LINK(125,"This is old link for user activation");

	private final int value;

	private final String reasonPhrase;

	private ErrorCode(int value, String reasonPhrase) {
		this.value = value;
		this.reasonPhrase = reasonPhrase;
	}

	public int value() {
		return this.value;
	}

	/**
	 * Return the reason phrase of this status code.
	 */
	public String getReasonPhrase() {
		return reasonPhrase;
	}
}