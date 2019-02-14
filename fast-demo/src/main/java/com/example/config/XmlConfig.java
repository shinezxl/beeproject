package com.example.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.ImportResource;

/**
 * 加载xml文件
 */
@Configuration
@ImportResource(locations={"classpath:job.xml","classpath:beans.xml","classpath:dataBase.xml"})
public class XmlConfig {


}
