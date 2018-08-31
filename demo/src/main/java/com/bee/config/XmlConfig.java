package com.bee.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.ImportResource;

@Configuration
@ImportResource(locations={"classpath:job.xml","classpath:beans.xml"})
public class XmlConfig {


}
