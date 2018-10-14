package common.util;

/**
 * 返回客户端的通用json对象
 * @author HanqingLiu
 *
 */
public class JsonObj {
	/*其中status
	-1：请求无效
	0： 正常
	1: 手机号已存在
	2: 手机号不存在
	3: 邮箱已存在
	4： 邮箱不存在
	5： 用户名已存在
	6： 用户名不存在
	7： 手机验证码错误
	8: 未发送手机验证码
	9: 已添加过“收藏、点赞、或想去”
	10：表单信息不完整
	11: 评论太频繁
	110：用户名或密码错误
	119: 用户名注册未激活
	120: 用户名被限制登录
	400: 访问信息已存在
	401: 未登录
	402: 访问对象无效
	403: 拒绝访问
	404: 对象不存在
	405: 修改时未改变
	500: 活动已截止报名
	501: 已报名过此活动
	800: 商品库存不足
	801: 购物车为空
	901: 导入拆迁数据错误
*/
	private Integer status = 0;	// 请求状态码
	private String message;		// 提示消息
	private Object data;		// 数据
	
	public Integer getStatus() {
		return status;
	}
	public void setStatus(Integer status) {
		this.status = status;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public Object getData() {
		return data;
	}
	public void setData(Object data) {
		this.data = data;
	}
	
}
