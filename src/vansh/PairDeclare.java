package vansh;
import java.util.List;


public class PairDeclare {
	public String user;
	public String action;
	public int tmp = 0;
	boolean multiplicity = false;
	
	public PairDeclare(String user, String action) {
		super();
		//user defines who will do and action defines what will be done
		
		this.user = user;
		this.action = action;
	}
	
	public	String toString(List<String> l) {
		if(l.contains(action))
			return user + (multiplicity?" \"0..*\"": "") + (tmp == 1? "...>" :" ---> ") + action + ": uses\n";
			//return user + " \"0...\" --> \"00\" " + action + ": uses\n";
		return "";
	}
	
	public PairDeclare(String className1, String tempVal1, boolean b) {
		this(className1, tempVal1);
		multiplicity = b;
		// TODO Auto-generated constructor stub
	}
	public PairDeclare(String className, String tempVal1, int tmp1) {
		this(className, tempVal1);
		tmp = tmp1;
		// TODO Auto-generated constructor stub
	}
	
	
}
