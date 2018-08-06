package methods;

public class JiraPayload {
	public static String Login()
	{
		String b= "{\n" + 
	    		"    \"username\": \"manishgk30\",\n" + 
	    		"    \"password\": \"@tt1tnd3\"\n" + 
	    		"}";
		return b;
	}
	public static String Create()
	{
		String c= "{\n" +
			   " \"fields\": {\n" +
		       " \"project\": \n" +
		       "{\n" +
		       " \"key\": \"RA\"\n" +
		       " },\n" +
		       " \"summary\": \"Credit card defect\",\n" +
		       " \"description\": \"Creating my first bug\",\n" +
		       " \"issuetype\": {\n" +
		       " \"name\": \"Bug\"\n" +
		       " } \n" +
		       " } \n" +
		"}";
		return c;
	}
		public static String Comment() 
		{
			String d= "{\n" +
				    " \"body\": \"This is my first test\",\n" +
				    " \"visibility\": {\n" +
				    " \"type\": \"role\",\n" +
				    " \"value\": \"Administrators\" \n" +
				    " } \n" +
			"}";    
			return d;
	}
		public static String Comment1() 
		{
			String e= "{\n" +
				    " \"body\": \"This is my update first test\",\n" +
				    " \"visibility\": {\n" +
				    " \"type\": \"role\",\n" +
				    " \"value\": \"Administrators\" \n" +
				    " } \n" +
			"}";    
			return e;
	}	
}
