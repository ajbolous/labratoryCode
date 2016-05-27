package ClientUI;

  public class UITests {
	  public static boolean notEmpty(String str) {
		  if (str.length()==0) return false;
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
	  public static boolean checkIsvalid(char [] array, int length,String type)
	  {
	if (type.compareTo("char")== 0)
	{
		for (int i=0 ; i<length;i++)
		{
			if (!(Character.isLetter(array[i]))){
				return false; 
			}
		}
		return true ;
	}else if  (type.compareTo("digit")== 0){
		for (int i=0 ; i<length;i++)
		{
			if (!(Character.isDigit(array[i]))){
				return false; 
			}
		}
		return true ;
		
	   }
	return false  ;
	  }
  }
	
	  
	  
	  
	  

