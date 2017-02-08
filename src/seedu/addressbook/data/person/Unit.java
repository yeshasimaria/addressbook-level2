package seedu.addressbook.data.person;

import seedu.addressbook.data.exception.IllegalValueException;

public class Unit {
	
	public static final String UNIT_VALIDATION_REGEX = "#\\d{2}-\\d{2,3}";
	public static final String MESSAGE_UNIT_CONSTRAINTS = "Unit should be in the format #[num][num]-[num][num][optional num]";

	private final String value;
	
	public Unit(String value) throws IllegalValueException {
		if (isValidUnit(value)) {
			this.value = value;
		} else {
			throw new IllegalValueException(MESSAGE_UNIT_CONSTRAINTS);
		}
	}

	public String getValue() {
		return value;
	}
	
	public static boolean isValidUnit(String test) {
		return test.matches(UNIT_VALIDATION_REGEX);
	}
}
