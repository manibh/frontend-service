package fe.kong.frontendservice;

import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonPropertyOrder({ "id", "result", "content" })
public class SecondService {

	private final long id;
	private final String content;
	private final String result;
	
	public SecondService(long id, String content) {
		this.id = id;
		this.content = content;		
		this.result = getResult();		
	}

	public long getId() {
		return id;
	}

	public String getContent() {
		return content;
	}
	
	public String getResult()
	{			
	    String temp =  "id: " + this.id + " message: " + this.content;
	    return temp;
	}
}