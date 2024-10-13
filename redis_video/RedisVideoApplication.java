package com.spring_video_stream.redis_video;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

@SpringBootApplication
@EnableCaching
public class RedisVideoApplication {

	public static void main(String[] args) {
		SpringApplication.run(RedisVideoApplication.class, args);
	}

}
