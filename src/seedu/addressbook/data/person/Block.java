package seedu.addressbook.data.person;

import seedu.addressbook.data.exception.IllegalValueException;

public class Block {
	
	public static final String BLOCK_VALIDATION_REGEX = "\\d{3}\\D?";
	public static final String MESSAGE_BLOCK_CONSTRAINTS = "Block is to have a 3-digit number followed by 0 or 1 alphabet";
				
	private final String value;
	
	public Block(String value) throws IllegalValueException {
		if (isValidBlock(value)) {
			this.value = value;
		} else {
			throw new IllegalValueException(MESSAGE_BLOCK_CONSTRAINTS);
		}
	}

	public String getValue() {
		return value;
	}
	
	public static boolean isValidBlock(String test) {
		return test.matches(BLOCK_VALIDATION_REGEX);
	}

}
