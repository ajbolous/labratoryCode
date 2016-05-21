package ClientUI;

  public class UITests {

	  
	  public static boolean notEmptyID(String id) {
		  if (id.length()==0) return false;
		  return true;
		
	}
	  
	  public static boolean correctID(String id){
		  if (id.length()!=9) return false;
		  return true;
	  }
	  
	  
	  
}
