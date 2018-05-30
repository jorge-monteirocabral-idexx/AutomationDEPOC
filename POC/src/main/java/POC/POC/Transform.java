package POC.POC;

import cucumber.api.Transformer;

public class Transform {

	public class StringTransformer extends Transformer<String>{

	    public String transform(String value) {     
	        return "transformed "+value;
	    }    
	}
	
}
