package Utils;

import java.io.Serializable;
import java.util.HashMap;

public class Request implements Serializable {

	private String url;
	private String view;
	private String op;
	private HashMap<String, Object> params;

	public Request(String url) {
		this.url = url;
		String[] p = url.split("/");
		view = p[0];
		op = p[1];
		params = new HashMap<String, Object>();
	}

	public HashMap<String, Object> getParams(){
		return params;
	}
	public void addParam(String key, Object obj) {
		params.put(key, obj);
	}

	public Object getParam(String key) {
		return params.get(key);
	}

	public String getView() {
		return view;
	}

	public String getUrl() {
		return url;
	}

	public String getOp() {
		return op;
	}

}
