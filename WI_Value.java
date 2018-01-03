
import java.util.*;

// TODO refactor after naming language
public class WI_Value {
	public static final int WI_NAME = 0;
	public static final int WI_NUMBER = 1;
	public static final int WI_BOOL = 2;
	public static final int WI_STRING = 3;
	public static final int WI_LIST = 4;
	public static final int WI_FUNC = 5;
	public static final int WI_UNDEFINED = -1;
	
	private String value;
	private ArrayList<WI_Value> list = new ArrayList<WI_Value>();
	private Node funcRef;
	private ArrayList<String> parameters;
	private int wi_type;
	public boolean fromReturnStmt;
	
	public WI_Value(String value, int wi_type, boolean isReturn) {
		this.value = value;
		this.wi_type = wi_type;
		this.fromReturnStmt = isReturn;
	}
	
	public WI_Value(ArrayList<WI_Value> list, boolean isReturn) {
		this.list = new ArrayList<WI_Value>();
		for (int i = 0; i < list.size(); i++) {
			this.list.add(list.get(i));
		}
		//this.list = list;
		this.wi_type = WI_Value.WI_LIST;
		this.fromReturnStmt = isReturn;
	}
	
	public WI_Value(String value, Node funcRef, ArrayList<String> parameters, boolean isReturn) {
		this.value = value;
		this.wi_type = WI_Value.WI_FUNC;
		this.funcRef = funcRef;
		this.parameters = parameters;
		this.fromReturnStmt = isReturn;
	}
	
	public String getValue() { return this.value; }
	public ArrayList<WI_Value> getList() { return this.list; }
	public Node getFuncRef() { return this.funcRef; }
	public ArrayList<String> getParameters() { return this.parameters; }
	public boolean isFromReturnStmt() { return this.fromReturnStmt; }
	public int getWiType() { return this.wi_type; }
	
	public boolean EvalBool() {
		if (this.wi_type == WI_Value.WI_BOOL) {
			if (this.value.equals("true")) return true;
			return false;
		}
		else if (this.wi_type == WI_Value.WI_NUMBER) {
			if (Double.parseDouble(this.value) != 0) return true;
			return false;
		}
		else if (this.wi_type == WI_Value.WI_STRING) {
			if (this.value.equals("\0")) return false;
			return true;
		}
		else if (this.wi_type == WI_Value.WI_NAME) {
			// TODO implement with symbol table
		}
		return false;
	}
	
	public double EvalDouble() throws ParseException {
		if (this.wi_type == WI_Value.WI_NUMBER) {
			return Double.parseDouble(this.value);
		}
		else if (this.wi_type == WI_Value.WI_BOOL) {
			if (this.EvalBool()) return 1;
			else return 0;
		}
		else if (this.wi_type == WI_Value.WI_NAME) {
			// TODO implement with symbol table
		}
		else if (this.wi_type == WI_Value.WI_STRING) {
			// TODO maybe change this
			throw new ParseException();
		}
		return 0;
	}
	
	
	
}
