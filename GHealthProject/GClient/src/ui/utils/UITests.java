package ui.utils;

  public class UITests {
	  public static boolean notEmpty(String str) {
		  if (str.length()==0) return false;
		  return true;
		   
	}  
	  public static boolean notEmptybirth(Object str) {
		  if (((String)str).compareTo("Year")==0 || ((String)str).compareTo("Month")==0 ||((String)str).compareTo("Day")==0)
			  return false;
		  return true;
		
	}
	  
	  public static boolean correctId(String id){
		  if (id.length()!=9) return false;
		  //if (id.)
		  return true;
	  }
	  public static boolean correctName(String name){
		  if (name.length()!=9) return false;
		  return true;
	  }
	  public static boolean checkIsCh(String field) {
		  char [] array= field.toCharArray();
	
		for (int i=0 ; i<field.length();i++)
		{
			if (!(Character.isLetter(array[i]))){
				return false; 
			}
		}
		return true ;
		
	}
  
  public static boolean checkIsDigit(String field ){
	  char [] array= field.toCharArray();
	  
			for (int i=0 ; i<field.length();i++){
				if (!(Character.isDigit(array[i]))){
					return false; 
				}
			}
			return true ;

	  }
		  
 }
  
	
	  
	  
	  
	  

