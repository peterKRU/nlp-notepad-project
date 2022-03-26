package request.library;

public class RequestReader {
	
	public RequestReader() {}
	
	public String getRequestTranscript(Request request) {
		
		String requestTranscript = "{" + "requestType:" + request.getRequestType() + ";" + "requestID:" + request.getRequestID() + ";" + "targetModel:" + request.getTargetModel() + ";"  + "inputString:" + "[start]" + request.getInputString() +"[end]" + "}";
		
		return requestTranscript;
		
	}
	
}
