package api;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class CreateLead {

	public static String createLeadDetails() throws JsonProcessingException {
		
		LeadDetails ld=new LeadDetails();
		ld.setFirstName("Bharathi");
		ld.setLastName("Manohar");
		ld.setCompany("TestLeaf");
		System.out.println("------create lead is executing------");
		ObjectMapper obj=new ObjectMapper();
		String writeValueAsString = obj.writerWithDefaultPrettyPrinter().writeValueAsString(ld);
		System.out.println(writeValueAsString);
		return writeValueAsString;
	}

}
