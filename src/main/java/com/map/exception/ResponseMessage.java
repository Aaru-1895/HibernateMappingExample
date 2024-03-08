package com.map.exception;

public class ResponseMessage {
	
	 private  String code;

	    private  String message;

	    private  String status;

		public String getCode() {
			return code;
		}

		public String getMessage() {
			return message;
		}

		public String getStatus() {
			return status;
		}

		public ResponseMessage() {
			
		}

		public ResponseMessage(String code, String message, String status) {
			super();
			this.code = code;
			this.message = message;
			this.status = status;
		}
	    
	    

}
