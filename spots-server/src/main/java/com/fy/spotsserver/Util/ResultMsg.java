package com.fy.spotsserver.Util;

public class ResultMsg {
	
	private Boolean success = true;
	
	private String msg;
	
	private Object data;

	private String url;

	public void setSuccessFalse() {
		success = false; 
	}
	
	public Boolean getSuccess() {
		return success;
	}

	public void setSuccess(Boolean success) {
		this.success = success;
	}

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}

	public Object getData() {
		return data;
	}

	public void setData(Object data) {
		this.data = data;
	}

	
	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	@Override
	public String toString() {
		return "ResultMsg [success=" + success + ", msg=" + msg + ", data=" + data + ", url=" + url + "]";
	}

	
	
	

}
