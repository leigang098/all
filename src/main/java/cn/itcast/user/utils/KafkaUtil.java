package cn.itcast.user.utils;

import java.util.Arrays;
import java.util.Map;
import java.util.Properties;
import java.util.Set;
import java.util.concurrent.TimeoutException;

import org.apache.kafka.clients.admin.AdminClient;
import org.apache.kafka.clients.admin.AdminClientConfig;
import org.apache.kafka.clients.admin.CreateTopicsResult;
import org.apache.kafka.clients.admin.ListTopicsResult;
import org.apache.kafka.clients.admin.NewTopic;
import org.apache.kafka.common.KafkaFuture;
import org.apache.kafka.common.errors.TopicExistsException;
import org.apache.kafka.common.security.JaasUtils;
import org.elasticsearch.client.ClusterAdminClient;

import com.alibaba.fastjson.JSONObject;

import kafka.utils.ZkUtils;

public class KafkaUtil {

	public static CreateTopicsResult createKafaTopic(AdminClient admin,String topicName) throws Exception {

			
		NewTopic newTopic = new NewTopic(topicName, 2, (short) 2);
		CreateTopicsResult createTopics = admin.createTopics(Arrays.asList(newTopic));
 		return createTopics;
			
	
	}
	
	public static void checkIx() {
//		Properties kafkaconfig = new Properties();
//
//		kafkaconfig.put(AdminClientConfig.BOOTSTRAP_SERVERS_CONFIG, "192.168.31.77:9092");
//
//		AdminClient admin = AdminClient.create(kafkaconfig);

	}

	public static ListTopicsResult listKafkaTopic(AdminClient admin) throws Exception {

		ListTopicsResult listTopics = admin.listTopics();
		
		return listTopics;
			
	}

//    public static void deleteKafaTopic(String ZkStr,KafkaTopicBean topic) {
//        ZkUtils zkUtils = ZkUtils.
//                apply(ZkStr, 30000, 30000,JaasUtils.isZkSecurityEnabled()); 
//
//       AdminUtils.deleteTopic(zkUtils, topic.getTopicName());
//       zkUtils.close();
//   }

}
