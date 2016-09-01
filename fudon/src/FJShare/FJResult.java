package FJShare;

public class FJResult {
	
	private String msg;
	private int    type;	// 1 success
	private Object data;
	
	public String getMsg() {
		return msg;
	}
	public void setMsg(String msg) {
		this.msg = msg;
	}
	public int getType() {
		return type;
	}
	public void setType(int type) {
		this.type = type;
	}
	public Object getData() {
		return data;
	}
	public void setData(Object data) {
		this.data = data;
	}
	
	public FJResult(String msg,int type){
		this.msg = msg;
		this.type = type;
	}
	
	public FJResult(String msg,int type,Object data){
		this.msg = msg;
		this.data = data;
		this.type = type;
	}
	
}
