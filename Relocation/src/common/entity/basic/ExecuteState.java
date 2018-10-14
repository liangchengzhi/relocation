package common.entity.basic;

import java.io.Serializable;

/**
 * Execute State 所有操作返回值的执行状态 如：新增数据记录后的结果
 * 
 * @author liangcz
 * 
 */
public final class ExecuteState implements Serializable{

	/**
     * 
     */
    private static final long serialVersionUID = 1L;

    @Override
	public String toString() {
		return "ExecuteState [success=" + success + ", errorCode=" + errorCode
				+ ", message=" + message + ", externalReferenceNo="
				+ externalReferenceNo + ", UserReferenceNumber="
				+ UserReferenceNumber + "]";
	}

	private Boolean success = false;
	private String errorCode;
	private String message;
	private String externalReferenceNo;
	private String UserReferenceNumber;

	/**
	 * 是否成功
	 * 
	 * @return
	 */
	public Boolean isSuccess() {
		return success;
	}

	/**
	 * 是否成功
	 * 
	 * @param success
	 */
	public void setSuccess(Boolean success) {
		this.success = success;
	}

	/**
	 * 错误代码
	 * 
	 * @return
	 */
	public String getErrorCode() {
		return errorCode;
	}

	/**
	 * 错误代码
	 * 
	 * @param errorCode
	 */
	public void setErrorCode(String errorCode) {
		this.errorCode = errorCode;
	}

	/**
	 * 错误信息
	 * 
	 * @return
	 */
	public String getMessage() {
		return message;
	}

	/**
	 * 错误信息
	 * 
	 * @param message
	 */
	public void setMessage(String message) {
		this.message = message;
	}

	/**
	 * 外部流水号
	 * 
	 * @return
	 */
	public String getExternalReferenceNo() {
		return externalReferenceNo;
	}

	/**
	 * 外部流水号
	 * 
	 * @param externalReferenceNo
	 */
	public void setExternalReferenceNo(String externalReferenceNo) {
		this.externalReferenceNo = externalReferenceNo;
	}

	/**
	 * 用户流水号
	 * 
	 * @return
	 */
	public String getUserReferenceNumber() {
		return UserReferenceNumber;
	}

	/**
	 * 用户流水号
	 * 
	 * @param userReferenceNumber
	 */
	public void setUserReferenceNumber(String userReferenceNumber) {
		UserReferenceNumber = userReferenceNumber;
	}
}