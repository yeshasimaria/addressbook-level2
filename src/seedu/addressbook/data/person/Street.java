package seedu.addressbook.data.person;

import seedu.addressbook.data.exception.IllegalValueException;

public class Street {
	
	public static final String STREET_VALIDATION_REGEX = ".+";
	public static final String MESSAGE_STREET_CONSTRAINTS = "Street can be in any format";
	
	private final String value;
	
	public Street(String value) throws IllegalValueException {
		if (isValidStreet(value)){
			this.value = value;
		} else {
			throw new IllegalValueException(MESSAGE_STREET_CONSTRAINTS);
		}
		
	}

	public String getValue() {
		return value;
	}
	
	public static boolean isValidStreet(String test) {
		return test.matches(STREET_VALIDATION_REGEX);
	}
}
