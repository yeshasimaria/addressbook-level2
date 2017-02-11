package seedu.addressbook.data.tag;

import seedu.addressbook.data.person.Person;

/**
 * Represents addition or removal of association between a Tag and Person
 */
public class Tagging {
	private static final String SEPARATOR = " ";
	
	private Tag tag;
	private Person person;
	private Operation operation;
	
	
	private enum Operation {
		ADD("+"), REMOVE("-");
		
		private String symbol;
		
		private Operation(String symbol) {
			this.symbol = symbol; 
		}
		
		public String getSymbol() {
			return symbol;
		}
	}
	
	
	public Tagging(Tag tag, Person person, Operation operation) {
		this.tag = tag;
		this.person = person;
		this.operation = operation;
	}
	
	@Override
	public String toString() {
		return this.operation.getSymbol() + SEPARATOR + this.person.toString() + SEPARATOR + this.tag.toString();
	}
}
