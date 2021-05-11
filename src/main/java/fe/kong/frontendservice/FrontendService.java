package fe.kong.frontendservice;

import org.springframework.web.client.RestTemplate;

public class FrontendService {

	private final long id;
	private final String content;
	private final String serviceUrl;
	private final String result;
	
	public FrontendService(long id, String content, String serviceUrl) {
		this.id = id;
		this.content = content;
		this.serviceUrl=serviceUrl;
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
//	    final String uri = "http://localhost:8070/get";
		final String uri = this.serviceUrl + "/get";

	    RestTemplate restTemplate = new RestTemplate();
	    String result = restTemplate.getForObject(uri, String.class);

	    System.out.println(result);
	    return result;
	}
}