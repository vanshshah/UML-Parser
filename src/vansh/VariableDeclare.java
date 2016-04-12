package vansh;

public class VariableDeclare {
	
	// getter setter for the variable name
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	// getter setter for modifies (public)
	public int getMod() {
		return modifier;
	}
	public void setMod(int modifier) {
		this.modifier = modifier;
	}

	// getter setter for the type
	public String getVarType() {
		return type;
	}
	public void setVarType(String type) {
		this.type = type;
	}
	//constructor
	public VariableDeclare(String name, String type, int modifier) {
		super();
		//variable name, type and the modifier
		//all type can be detected
		this.name = name;
		this.type = type;
		this.modifier = modifier;
	}
	String name, type;
	int modifier;
}