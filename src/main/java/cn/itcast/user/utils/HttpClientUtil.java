package cn.itcast.user.utils;

import java.io.IOException;
import java.util.*;

import com.alibaba.fastjson.JSONObject;
import org.apache.http.HttpEntity;
import org.apache.http.HttpStatus;
import org.apache.http.NameValuePair;
import org.apache.http.ParseException;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;

public class HttpClientUtil {

	public Map<String,String> doPost(String url,StringEntity entity,Map<String,String> headers) {
		CloseableHttpClient httpClient = HttpClientBuilder.create().build();
		HttpPost httpPost = new HttpPost(url);
		CloseableHttpResponse response = null;
		Map<String,String> map = new HashMap<String, String>();
		try {
			RequestConfig requestConfig = RequestConfig.custom()
					.setConnectTimeout(5000)
					.setConnectionRequestTimeout(5000)
					.setSocketTimeout(5000)
					.setRedirectsEnabled(true).build();
			httpPost.setConfig(requestConfig);

			if(null!=headers&&headers.size()>0){//判断header是否需要设置
				//循环传入Map header，设置Post请求Header
				for(Iterator<String> keys=headers.keySet().iterator();keys.hasNext();){
					String key=keys.next();
					httpPost.addHeader(key,headers.get(key));
				}
			}

			//装配post请求参数
			//将参数进行编码为合适的格式,如将键值对编码为param1=value1&param2=value2
			httpPost.setEntity(entity);

			//执行http post 请求
			response = httpClient.execute(httpPost);
			System.out.println("POST请求响应状态为:" + response.getStatusLine());
			map.put("httpStatus", ""+HttpStatus.SC_OK);
			if(response.getStatusLine().getStatusCode() == HttpStatus.SC_OK){//判断请求返回状态是否正常
				HttpEntity responseEntity = response.getEntity();
				int statusCode = response.getStatusLine().getStatusCode();
				map.put("statusCode", statusCode+"");
				if (responseEntity != null) {
					long contentLength = responseEntity.getContentLength();
					System.out.println("响应内容长度为:" + contentLength);
					map.put("clength", contentLength+"");
					map.put("content", EntityUtils.toString(responseEntity));
				}
			}
		} catch (ClientProtocolException e) {
			e.printStackTrace();
		} catch (ParseException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				// 释放资源
				if (httpClient != null) {
					httpClient.close();
				}
				if (response != null) {
					response.close();
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		return map;

	}

	public Map<String,String> doPost(String url,Map<String,Object> paramsMap,Map<String,String> headers) {
		CloseableHttpClient httpClient = HttpClientBuilder.create().build();
		HttpPost httpPost = new HttpPost(url);
		CloseableHttpResponse response = null;
		Map<String,String> map = new HashMap<String, String>();
		try {
			RequestConfig requestConfig = RequestConfig.custom()
					.setConnectTimeout(5000)
					.setConnectionRequestTimeout(5000)
					.setSocketTimeout(5000)
					.setRedirectsEnabled(true).build();
			httpPost.setConfig(requestConfig);

			if(null!=headers&&headers.size()>0){//判断header是否需要设置
				//循环传入Map header，设置Post请求Header
				for(Iterator<String> keys=headers.keySet().iterator();keys.hasNext();){
					String key=keys.next();
					httpPost.addHeader(key,headers.get(key));
				}
			}

			//装配post请求参数
			List<NameValuePair> list = new ArrayList<NameValuePair>();
			for (String key : paramsMap.keySet()) {
				list.add(new BasicNameValuePair(key, String.valueOf(paramsMap.get(key))));
			}
			//将参数进行编码为合适的格式,如将键值对编码为param1=value1&param2=value2
			httpPost.setEntity(new UrlEncodedFormEntity(list, "utf-8"));

			//执行http post 请求
			response = httpClient.execute(httpPost);
			System.out.println("POST请求响应状态为:" + response.getStatusLine());
			map.put("httpStatus", ""+HttpStatus.SC_OK);
			if(response.getStatusLine().getStatusCode() == HttpStatus.SC_OK){//判断请求返回状态是否正常
				HttpEntity responseEntity = response.getEntity();
				int statusCode = response.getStatusLine().getStatusCode();
				map.put("statusCode", statusCode+"");
				if (responseEntity != null) {
					long contentLength = responseEntity.getContentLength();
					System.out.println("响应内容长度为:" + contentLength);
					map.put("clength", contentLength+"");
					map.put("content", EntityUtils.toString(responseEntity));
				}
			}
		} catch (ClientProtocolException e) {
			e.printStackTrace();
		} catch (ParseException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				// 释放资源
				if (httpClient != null) {
					httpClient.close();
				}
				if (response != null) {
					response.close();
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		return map;

	}

//	public static void main(String[] args){
//		HttpClientUtil clientUtil=new HttpClientUtil();
//		Map<String,Object> param=new HashMap<>();
//		param.put("id","2682dd6870dd4b208a2ef144c684ccfc");
//		String url="http://localhost:8808/workflow/pulic/subscribe/audit/sendAuditResult";
//		Map<String,String> result=clientUtil.doPost(url,param,null);
//		System.out.println(result);
//		if (result.containsKey("statusCode")&&result.get("statusCode").equals("200")) {
//			String content=result.containsKey("content")?result.get("content"):null;
//			if(null!=content){
//				//data数据
//				JSONObject map =  JSONObject.parseObject(content);
//				if(null!=map.get("resultCode")&&map.getString("resultCode").equals("1000")){
//					System.out.println("=======请求成功======");
//					System.out.println("=======message======");
//					System.out.println(map.get("message"));
//				}
//			}
//		}
//
//
//	}

}
