package Views;

import Utils.Request;

public interface Viewable {
	public Object all(Request request);
	public Object add(Request request);
	public Object remove(Request request);
	public Object update(Request request);
}
