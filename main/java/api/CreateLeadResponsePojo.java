package api;

import java.util.ArrayList;

import lombok.Data;
@Data
public class CreateLeadResponsePojo {

	public String id;
    public boolean success;
    public ArrayList<Object> errors;
}
