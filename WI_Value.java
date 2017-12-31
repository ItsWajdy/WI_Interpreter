
// TODO refactor after naming language
public class WI_Value {
	public static final int WI_NAME = 0;
	public static final int WI_NUMBER = 1;
	public static final int WI_BOOL = 2;
	public static final int WI_STRING = 3;
	
	private String value;
	private int wi_type;
	
	public WI_Value(String value, int wi_type) {
		this.value = value;
		this.wi_type = wi_type;
	}
	
	public String getValue() { return this.value; }
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