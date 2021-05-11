package fe.kong.frontendservice;

import java.util.concurrent.atomic.AtomicLong;

import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FrontendServiceController {

	private static final String template = "Hello, %s!";
	private final AtomicLong counter = new AtomicLong();

//	@GetMapping("/greeting")
	@RequestMapping(method=RequestMethod.GET, path="/frontend")
	public FrontendService greeting(@RequestParam(value = "name", defaultValue = "World") String name) {
		return new FrontendService(counter.incrementAndGet(), String.format(template, name), "http://localhost:8000/httpbin");
	}
	
//	@RequestMapping(method=RequestMethod.GET, path="/second")
//	public SecondService secondService(@RequestParam(value = "name", defaultValue = "World") String name) {
//		return new SecondService(counter.incrementAndGet(), String.format(template, name));
//	}
	
	@RequestMapping(method=RequestMethod.GET, path="/second")
	public ResponseEntity<SecondService>  secondService(@RequestParam(value = "name", defaultValue = "World") String name) {
		HttpHeaders responseHeaders = new HttpHeaders();
		responseHeaders.add("User_Name", "MANI_HOSSEINI");
		SecondService body = new SecondService(counter.incrementAndGet(), String.format(template, name));
		return ResponseEntity.ok().headers(responseHeaders).body(body);
	}
}