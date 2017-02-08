package seedu.addressbook.data.person;

import seedu.addressbook.data.exception.IllegalValueException;

/**
 * Represents a Person's address in the address book.
 * Guarantees: immutable; is valid as declared in {@link #isValidAddress(String)}
 */
public class Address {

    public static final String EXAMPLE = "123, some street, #12-34, 231534";

    private boolean isPrivate;
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
    	String[] addressComponents;
    	String trimmedAddress = address.trim();
    	addressComponents = trimmedAddress.split(", ");
        this.isPrivate = isPrivate;
        try {
        	formatAddress(addressComponents);
        } catch (IllegalValueException illegalValueException) {

        	throw new IllegalValueException(illegalValueException.getMessage());
        }
    }


	private void formatAddress(String[] addressComponents) throws IllegalValueException{
		try {
			this.block = new Block(addressComponents[0]);
			this.street = new Street(addressComponents[1]);
			this.unit = new Unit(addressComponents[2]);
			//this.postalCode = new PostalCode(addressComponents[3]);
		} catch (IllegalValueException illegalValueException){
			throw new IllegalValueException(illegalValueException.getMessage());
		}
		
	}


    @Override
    public String toString() {
        return this.block.getValue() + ", " + this.street.getValue() 
        		+ ", " + this.unit.getValue() + ", " + this.postalCode.getValue();
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
