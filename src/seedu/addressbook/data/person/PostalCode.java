package seedu.addressbook.data.person;

import seedu.addressbook.data.exception.IllegalValueException;

public class PostalCode {
	
	public static final String POSTAL_CODE_VALIDATION_REGEX = "\\d{6}";
	public static final String MESSAGE_POSTAL_CODE_CONSTRAINTS = "Postal code should be a 6-digit number";

	private final String value;
	
	public PostalCode(String value) throws IllegalValueException {
		if (isValidPostalCode(value)) {
			this.value = value;
		} else {
			throw new IllegalValueException(MESSAGE_POSTAL_CODE_CONSTRAINTS);
		}
		
	}

	public String getValue() {
		return value;
	}
	
	public static boolean isValidPostalCode(String test) {
		return test.matches(POSTAL_CODE_VALIDATION_REGEX);
	}
}
