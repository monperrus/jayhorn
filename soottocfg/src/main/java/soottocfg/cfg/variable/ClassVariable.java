/**
 * 
 */
package soottocfg.cfg.variable;

import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

import soottocfg.cfg.type.ReferenceType;
import soottocfg.cfg.type.TypeType;

/**
 * @author schaef
 * Global variable to present a Java class (e.g, String). 
 */
public class ClassVariable extends Variable  {

	private static final long serialVersionUID = -1647842783828780974L;	
	private final Set<ClassVariable> parentConstants;
	private List<Variable> associatedFields, finalFields;

	public ClassVariable(String name, Collection<ClassVariable> parents) {
		super(name, new TypeType(), true, true); //TODO, its actually not reference type.	
		parentConstants = new HashSet<ClassVariable>();
		parentConstants.addAll(parents);
		associatedFields = new LinkedList<Variable>();
		finalFields = new LinkedList<Variable>(); 
		//add all fields from the super class
		for (ClassVariable parent : parents) {
			for (Variable pfield : parent.getAssociatedFields()) {
				if (!hasField(pfield.getName())) {
					Variable v = new Variable(pfield.getName(), pfield.getType());
					associatedFields.add(v);
					if (v.isConstant()) {
						finalFields.add(v);
					}
				}
			}
		}
	}

	public void setType(ReferenceType rt) {
		this.type = rt;
	}
	
	public String getName() {
		return this.variableName;
	}

	public Collection<ClassVariable> getParents() {
		return Collections.unmodifiableCollection(parentConstants);
	}

	public void addFields(List<Variable> fields) {
		for (Variable f : fields) {
			if (!hasField(f.getName())) {
				Variable v = new Variable(f.getName(), f.getType());
				associatedFields.add(v);
				if (v.isConstant()) {
					finalFields.add(v);
				}
			} else {
				//warn about that.
			}
		}
	}

	public Variable[] getAssociatedFields() {
		return associatedFields.toArray(new Variable[associatedFields.size()]);
	}
	
	/**
	 * Returns the subset of fields that are final. Note that these
	 * fields are also part of getAssociatedFields().
	 * @return
	 */
	public Variable[] getFinalFields() {
		return finalFields.toArray(new Variable[finalFields.size()]);
	}

	
	public boolean hasField(String fname) {
		for (Variable v : associatedFields) {			
			if (v.getName().equals(fname)) {
				return true;
			}
		}
		return false;
	}
	
	public int findField(String fname) {
		for (int i=0; i<this.associatedFields.size();i++) {
			if (associatedFields.get(i).getName().equals(fname)) {
				return i;
			}			
		}
		throw new RuntimeException("Field not found "+fname);
	}
	
	@Override
	public String toString() {
		return this.variableName;
	}
	
	public boolean subclassOf(ClassVariable cls) {
		List<ClassVariable> todo = new LinkedList<ClassVariable>();
		todo.add(this);
		while (!todo.isEmpty()) {
			ClassVariable cv = todo.remove(0);
			if (cv==cls) return true;
			if (cv.getParents()!=null) {
				todo.addAll(cv.getParents());
			}
		}
		return false;
	}
	
	public boolean superclassOf(ClassVariable cls) {
		return cls.subclassOf(this);
	}
	
	@Override
	public boolean equals(Object obj) {
		if (obj == null)
			return false;
		if (this.getClass() == obj.getClass()) {
			ClassVariable other = (ClassVariable) obj;
			return this.variableName.equals(other.variableName)
					&& this.type.equals(other.type)
					&& this.associatedFields.containsAll(other.associatedFields)
					&& this.finalFields.containsAll(other.finalFields)
					&& this.parentConstants.containsAll(other.parentConstants);
		}
		return false;
	}
	
	@Override
	public int hashCode() {
		int result = 42;
		result = 37 * result + this.variableName.hashCode();
		result = 37 * result + this.type.hashCode();
		result = 37 * result + this.associatedFields.hashCode();
		result = 37 * result + this.finalFields.hashCode();
		result = 37 * result + this.parentConstants.hashCode();
		return result;
	}
}
