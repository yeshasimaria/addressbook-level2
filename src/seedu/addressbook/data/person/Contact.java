package seedu.addressbook.data.person;

import seedu.addressbook.data.exception.IllegalValueException;

public abstract class Contact {
	
	private final String value;
	private final boolean isPrivate;
	
    /**
     * Validates given contact using the given regular expression.
     *
     * @throws IllegalValueException if given email address string is invalid.
     */
	public Contact(String value, boolean isPrivate, String regex, String message_constraints) throws IllegalValueException {
        this.isPrivate = isPrivate;
        String trimmedValue = value.trim();
        if (!isValidContact(trimmedValue, regex)) {
            throw new IllegalValueException(message_constraints);
        }
        this.value = trimmedValue;
	}
	
    /**
     * Checks if a given string is a valid contact.
     */
	public boolean isValidContact(String test, String regex) {
		return test.matches(regex);
	}
	
	public String getValue() {
		return this.value;
	}
	
	public boolean isPrivate() {
		return this.isPrivate;
	}
	
	@Override
	public int hashCode() {
		return this.value.hashCode();
	}
	
	@Override
	public String toString() {
		return value;
	}
}
