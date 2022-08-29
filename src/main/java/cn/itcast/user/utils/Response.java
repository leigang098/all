package cn.itcast.user.utils;


/**
 * 响应体,所有接口返回数据的基类
 */
public class Response {

	/**
	 * 是否操作成功状态  true : 成功 ,false 失败     此标识不做为响应是否成功的依据
	 */
	private Boolean operationSta = false;
	/**
	 * 操作信息,操作成功或失败时的描述
	 */
	private String operationMsg;	
	/**
	 * 响应码,不做为操作是否成功的依据
	 */
	private String responseCode = ConstUtil.RESPONSE._SUCSSESS.ID;
	/**
	 * 响应信息描述,一般在响应错误时使用
	 */
	private String responseMsg;
	/**
	 * 服务器响应错误信息
	 */
	private String errorMsg;
	/**
	 * 响应数据
	 */
	private Object data;
	
	public Boolean getOperationSta() {
		return operationSta;
	}
	public void setOperationSta(Boolean operationSta) {
		this.operationSta = operationSta;
	}
	public String getOperationMsg() {
		return operationMsg;
	}
	public void setOperationMsg(String operationMsg) {
		this.operationMsg = operationMsg;
	}
	public String getResponseCode() {
		return responseCode;
	}
	public void setResponseCode(String responseCode) {
		this.responseCode = responseCode;
	}
	public String getResponseMsg() {
		return responseMsg;
	}
	public void setResponseMsg(String responseMsg) {
		this.responseMsg = responseMsg;
	}
	public Object getData() {
		return data;
	}
	public void setData(Object data) {
		this.data = data;
	}
	
	public String getErrorMsg() {
		return errorMsg;
	}
	public void setErrorMsg(String errorMsg) {
		this.errorMsg = errorMsg;
	}
	public Response(Boolean operationSta, String operationMsg, String responseCode, String responseMsg,String errorMsg, Object data) {
		super();
		this.operationSta = operationSta;
		this.operationMsg = operationMsg;
		this.responseCode = responseCode;
		this.responseMsg = responseMsg;
		this.errorMsg = errorMsg;
		this.data = data;
	}
	public Response() {
		super();
	}

}
