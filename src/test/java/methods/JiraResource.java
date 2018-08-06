package methods;

public class JiraResource {
	public static String REST1()
	{
	
	String res1="/rest/auth/1/session";
	return res1;

	}
	
	public static String REST2()
	{
	
		String res2="/rest/api/2/issue";
		return res2;

	}
	public static String REST3()
	{
	    String a= JiraReusable.Getid();
		String res3="/rest/api/2/issue/"+a+"/comment";
		return res3;

	}
	public static String REST4()
	{
		  String a= JiraReusable.Getid();
		  String b= JiraReusable.GetCommentid();
		String res4="/rest/api/2/issue/"+a+"/comment/"+b+"";
		return res4;

	}
}
