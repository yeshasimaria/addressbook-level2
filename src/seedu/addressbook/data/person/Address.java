package seedu.addressbook.data.person;

import seedu.addressbook.data.exception.IllegalValueException;

/**
 * Represents a Person's address in the address book.
 * Guarantees: immutable; is valid as declared in {@link #isValidAddress(String)}
 */
public class Address {

    public static final String EXAMPLE = "123, some street, #12-34, 231534";
    public static final String MESSAGE_ADDRESS_CONSTRAINTS = "Person addresses can be in any format";
    public static final String ADDRESS_VALIDATION_REGEX = ".+";

    private boolean isPrivate;
    private int numAddressComponents;
    private Block block;
    private Street street;
    private Unit unit;
    private PostalCode postalCode;

    /**
     * Validates given address.
     *
     * @throws IllegalValueException if given address string is invalid.
     */
    public Address(String address, boolean isPrivate) throws IllegalValueException {
        String trimmedAddress = address.trim();
        this.isPrivate = isPrivate;
        String[] addressComponents;
        
        if (!isValidAddress(trimmedAddress)) {
            throw new IllegalValueException(MESSAGE_ADDRESS_CONSTRAINTS);
        } else {
        	addressComponents = trimmedAddress.split(", ");
        	numAddressComponents = addressComponents.length;
        	formatAddress(addressComponents);
        }
    }


	private void formatAddress(String[] addressComponents) {
		this.block = new Block(addressComponents[0]);
		this.street = new Street(addressComponents[1]);
		if (numAddressComponents >= 3) {
			this.unit = new Unit(addressComponents[2]);
		}
		if (numAddressComponents == 4) {
			this.postalCode = new PostalCode(addressComponents[3]);
		}
		
	}

    /**
     * Returns true if a given string is a valid person email.
     */
    public static boolean isValidAddress(String test) {
        return test.matches(ADDRESS_VALIDATION_REGEX);
    }

    @Override
    public String toString() {
    	
        String result = this.block.getValue() + ", " + this.street.getValue();
		if (numAddressComponents >= 3) {
			result += ", " + this.unit.getValue();
		}
		if (numAddressComponents == 4) {
			result += ", " + this.postalCode.getValue();
		}
        return result;
    }

    @Override
    public boolean equals(Object other) {
        return other == this // short circuit if same object
                || (other instanceof Address // instanceof handles nulls
                && this.block.equals(((Address) other).getBlock())
                && this.street.equals(((Address) other).getStreet())
                && this.unit.equals(((Address) other).getUnit())
				&& this.postalCode.equals(((Address) other).getPostalCode())); // state check
    }

    public PostalCode getPostalCode() {
		return this.postalCode;
	}

	public Unit getUnit() {
		return this.unit;
	}

	public Street getStreet() {
		return this.street;
	}

	public Block getBlock() {
		return this.block;
	}

    public boolean isPrivate() {
        return isPrivate;
    }
}
