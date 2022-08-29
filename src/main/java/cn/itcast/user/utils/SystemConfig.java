package cn.itcast.user.utils;

import lombok.Data;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

/**
 * Author: kingcobra
 * create on 2020/12/9 17:17
 **/
@Configuration
// @PropertySource(value = " file:///opt/watermelon/systemconfig.properties")
@PropertySource(value = "classpath:systemconfig.properties")
@Data
public class SystemConfig {
    @Value("${threadpool.coreThreaCounts}")
    int coreThreaCounts;
    @Value("${threadpool.maximumPoolSize}")
    int maximumPoolSize;

    @Value("${taskScanCron}")
    String taskScanCron;

    @Value("${datax.home}")
    String dataxHome;

    @Value("${datax.jobFile.path}")
    String dataxJobFilePath;

    @Value("${download.json.url}")
    String downloadJsonUrl;

    // todo 请求头的参数配置
    // @Value("${request.token}")
    // String requestToken;


    @Value("${download.file.url}")
    String downloadFileUrl;

    @Value("${template.channel}")
    String templateChannel;

    @Value("${template.record}")
    String templateRecord;

    @Value("${template.percentage}")
    String templatePercentage;

    @Value("${spring.activemq.topic.name}")
    String topicName;

    @Value("${taskend.url}")
    String taskendUrl;


}
