package cn.itcast.user.utils;


import java.util.List;

import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;

/**
 * 验证参数工具类
 *  
 * @since Mar 27, 2019
 * @author 陈锡伟
 *
 */
public class BindingResultUtils {

	/**
	 * 获取拼接验证参数的错误信息
	 *
	 * @param bindingResult
	 * @return
	 * @throws Exception
	 * 
	 * @变更记录: Mar 27, 2019 2:05:39 PM 陈锡伟 创建
	 * 
	 */
	public static String getErrorMessageByBindingResult(BindingResult bindingResult) throws Exception {
		List<ObjectError> errorList = bindingResult.getAllErrors();
		StringBuffer sb = new StringBuffer();
		errorList.forEach(error -> {
			sb.append(error.getDefaultMessage()).append("。");
		});
		return sb.toString();
	}
}
