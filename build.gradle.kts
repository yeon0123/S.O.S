/*
 * This file was generated by the Gradle 'init' task.
 *
 * This project uses @Incubating APIs which are subject to change.
 */

plugins {
    `java-library`
    `maven-publish`
}

repositories {
    mavenLocal()
    maven {
        url = uri("https://repo.maven.apache.org/maven2/")
    }
}



dependencies {
    api("org.springframework.boot:spring-boot-starter-oauth2-client:2.7.12")
    api("org.springframework.boot:spring-boot-starter-thymeleaf:2.7.12")
    api("org.springframework.boot:spring-boot-starter-web:2.7.12")
    api("org.springframework.boot:spring-boot-starter-websocket:2.7.12")
    api("org.apache.commons:commons-lang3:3.12.0")
    api("nz.net.ultraq.thymeleaf:thymeleaf-layout-dialect:3.0.0")
    api("org.springframework.boot:spring-boot-starter-data-jpa:2.7.12")
    api("org.mariadb.jdbc:mariadb-java-client:3.0.10")
    api("org.springframework.boot:spring-boot-starter-security:2.7.12")
    api("com.google.code.gson:gson:2.8.7")
    api("net.hlinfo:hlinfo-mybatis-dao:1.1.4")
    api("org.mybatis.spring.boot:mybatis-spring-boot-starter:2.3.0")
    api("org.springframework.boot:spring-boot-starter-jdbc:2.7.12")
    api("org.mybatis:mybatis-typehandlers-jsr310:1.0.2")
    api("org.mybatis:mybatis-spring:2.0.6")
    api("com.googlecode.json-simple:json-simple:1.1.1")
    api("javax.servlet:jstl:1.2")
    api("com.fasterxml.jackson.datatype:jackson-datatype-jsr310:2.15.0")
    api("com.fasterxml.jackson.core:jackson-databind:2.13.5")
    api("org.springframework.boot:spring-boot-starter-mustache:2.5.1")
    api("mysql:mysql-connector-java:8.0.33")
    runtimeOnly("com.h2database:h2:2.1.214")
    compileOnly("org.projectlombok:lombok:1.18.26")
    compileOnly("org.apache.tomcat.embed:tomcat-embed-jasper:9.0.75")
    annotationProcessor("org.projectlombok:lombok:1.18.26")
    implementation("org.apache.httpcomponents.client5:httpclient5:5.2.1")
    implementation("org.slf4j:slf4j-api:1.7.32")
    implementation("ch.qos.logback:logback-classic:1.2.6")
    implementation("com.squareup.okhttp3:okhttp:4.9.1")
    implementation("javax.xml.bind:jaxb-api:2.3.1")
    implementation("org.glassfish.jaxb:jaxb-runtime:2.3.3")
}

group = "com.sos"
version = "0.0.1-SNAPSHOT"
description = "signal"
java.sourceCompatibility = JavaVersion.VERSION_20

publishing {
    publications.create<MavenPublication>("maven") {
        from(components["java"])
    }
}

tasks.withType<JavaCompile>() {
    options.encoding = "UTF-8"
}

tasks.withType<Javadoc>() {
    options.encoding = "UTF-8"
}