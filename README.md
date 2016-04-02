## The Billcity RESTful Project
---
[Cyrus G. Gabilla](http://sh.st/EM4dU) `<cgabilla AT gmail DOT com>` | March 1, 2016

### Overview
----
The RESTful Billcity Project aka `billcity-akam` *Maven* artifact project is RESTful web services dealing with the existing zeus Accounting CRM. It is available for the developers and its third party users.

### Versions
---
* Akam 0.0.1 (master) - The initial release


### Billcity REST API Documentation
---
> **URI**: https://devel.3zeus.com/developers/billcity-backend/wikis/billcity-api-docs

### Billcity Project Files on GitLab aka `master` 
---
> **URI**: https://devel.3zeus.com/developers/billcity-backend/tree/master


### Features
---

+ `json` with **UTF-8** Character-set support
+ RESTful web services
+ Mavenized
    * Automatic Installation
    * Automatic Deployment
+ Integrated with Clover
    * Produces code coverage reports from the Maven build tools
    * It provides detailed information to highlight areas of low coverage

### Installation 
---

In order to run the RESTful Billcity, we have these few simple instructions:

1. Open your favorite command line (Bash, DOS,..)
2. Execute the commands in order:
    
    ```
    $ mvn clean install
    ...
    [INFO] ------------------------------------------------------------------------
    [INFO] BUILD SUCCESS
    [INFO] ------------------------------------------------------------------------
    [INFO] Total time: 11.072 s
    [INFO] Finished at: 2016-03-03T23:28:34+08:00
    [INFO] Final Memory: 17M/125M
    [INFO] ------------------------------------------------------------------------
    
    $ mvn tomcat7:deploy
    ...
    
    [INFO] Deploying war to http://localhost:8080/be-restful
    Uploading: http://localhost:8080/manager/text/deploy?path=%2Fbe-restful
    Uploaded: http://localhost:8080/manager/text/deploy?path=%2Fbe-restful (5832 KB at 14327.4 KB/sec)
    
    [INFO] tomcatManager status code:200, ReasonPhrase:
    [INFO] OK - Deployed application at context path /be-restful
    [INFO] ------------------------------------------------------------------------
    [INFO] BUILD SUCCESS
    [INFO] ------------------------------------------------------------------------
    [INFO] Total time: 19.638 s
    [INFO] Finished at: 2016-03-03T23:29:59+08:00
    [INFO] Final Memory: 23M/146M
    [INFO] ------------------------------------------------------------------------
    ```
3. Here's the RESTful Billcity homepage, [http://localhost:8080/be-restful](http://localhost/be-restful).

### Billcity Optimization on Tomcat Server

To generate unnecessary jars/artifacts to be scanned by the server, these should be added after the default jars in the Tomcat catalina.properties.

The Linux command below shows the extraction of the unneeded jars to be skipped on scanning process:
    ```
    Cyrus G. Gabilla@CSYROZ MINGW64 ~/Apps/apache-tomcat-9.0.0.M3
    $ egrep "No TLD files were found in \[file:[^\]+\]" ./logs/catalina.2016-03-23.log -o | egrep "[^]/]+.jar" -o | sort | uniq | sed -e 's/.jar/.jar,\\/g' > skips.txt
    

    org.apache.catalina.startup.TldConfig.jarsToSkip=aopalliance-repackaged-2.4.0-b34.jar,\
    backport-util-concurrent-3.1.jar,\
    classworlds-1.1.jar,\
    clover-4.1.1.jar,\
    doxia-logging-api-1.1.jar,\
    hk2-api-2.4.0-b34.jar,\
    hk2-locator-2.4.0-b34.jar,\
    hk2-utils-2.4.0-b34.jar,\
    jackrabbit-jcr-commons-1.5.0.jar,\
    jackrabbit-webdav-1.5.0.jar,\
    jackson-annotations-2.7.0.jar,\
    jackson-core-2.7.2.jar,\
    jackson-databind-2.7.2.jar,\
    jackson-jaxrs-base-2.7.2.jar,\
    jackson-jaxrs-json-provider-2.7.2.jar,\
    jackson-module-jaxb-annotations-2.7.2.jar,\
    javassist-3.18.1-GA.jar,\
    javax.annotation-api-1.2.jar,\
    javax.inject-2.4.0-b34.jar,\
    javax.servlet-api-4.0.0-b01.jar,\
    javax.ws.rs-api-2.0.1.jar,\
    jcl-over-slf4j-1.5.6.jar,\
    jersey-client-2.22.2.jar,\
    jersey-common-2.22.2.jar,\
    jersey-container-servlet-2.22.2.jar,\
    jersey-container-servlet-core-2.22.2.jar,\
    jersey-guava-2.22.2.jar,\
    jersey-media-jaxb-2.22.2.jar,\
    jersey-server-2.22.2.jar,\
    json-20140107.jar,\
    maven-artifact-2.2.1.jar,\
    maven-artifact-manager-2.2.1.jar,\
    maven-core-2.2.1.jar,\
    maven-error-diagnostics-2.2.1.jar,\
    maven-model-2.2.1.jar,\
    maven-monitor-2.2.1.jar,\
    maven-plugin-annotations-3.3.jar,\
    maven-plugin-api-2.2.1.jar,\
    maven-plugin-descriptor-2.2.1.jar,\
    maven-plugin-parameter-documenter-2.2.1.jar,\
    maven-plugin-registry-2.2.1.jar,\
    maven-profile-2.2.1.jar,\
    maven-project-2.2.1.jar,\
    maven-reporting-api-2.2.1.jar,\
    maven-repository-metadata-2.2.1.jar,\
    maven-settings-2.2.1.jar,\
    maven-surefire-common-2.19.1.jar,\
    maven-surefire-plugin-2.19.1.jar,\
    maven-toolchain-2.2.1.jar,\
    nekohtml-1.9.6.2.jar,\
    org.apache.oltu.oauth2.authzserver-1.0.1.jar,\
    org.apache.oltu.oauth2.common-1.0.1.jar,\
    org.apache.oltu.oauth2.resourceserver-1.0.1.jar,\
    osgi-resource-locator-1.0.1.jar,\
    plexus-cipher-1.4.jar,\
    plexus-container-default-1.0-alpha-9-stable-1.jar,\
    plexus-interpolation-1.11.jar,\
    plexus-sec-dispatcher-1.3.jar,\
    plexus-utils-1.5.15.jar,\
    postgresql-9.4.1208.jre7.jar,\
    surefire-api-2.19.1.jar,\
    surefire-booter-2.19.1.jar,\
    validation-api-1.1.0.Final.jar,\
    wagon-http-1.0-beta-6.jar,\
    wagon-http-shared-1.0-beta-6.jar,\
    wagon-provider-api-1.0-beta-6.jar,\
    wagon-webdav-jackrabbit-1.0-beta-6.jar,\
    xercesMinimal-1.9.6.2.jar,\
    ```
    
### RESTful Web Services API Documentation
---
[RESTful Billcity Project API Documentation](billcity-api-docs)

### Java Technologies & Development Environment
---

+ [Jersey 2.22.2](http://sh.st/E2yRW) - RESTful Web Services in Java.

+ [JDK 1.8](http://sh.st/E2ynU) - Java Development Kit

The JDK is a development environment for building applications, applets, and components using the Java programming language.

+ [Jackson JAXRS JSON 2.7.2](http://sh.st/E2ykA) - **`json`**

Functionality to handle JSON input/output for JAX-RS implementations (like Jersey and RESTeasy) using standard Jackson data binding.
 
+ [Tomcat 9.0](http://sh.st/E2yoD) - Tomcat Server

It implements several Java EE specifications including Java Servlet, JavaServer Pages (JSP), Java EL, and WebSocket, and provides a "pure Java" HTTP web server environment for Java code to run in.


### License & Copyright
---
(c) Copyright February 2016

*Taylorsoft Magyarország Informatikai Korlátolt Felelősségű Társaság*

### Developers
---

[Cyrus G. Gabilla](http://sh.st/EM4dU) `<cgabilla AT gmail DOT com>`

Java Backend Developer

Iligan City, PHILIPPINES

> Last Updated on March 23, 2016 by [Cyrus G. Gabilla](http://sh.st/EM4dU) `<cgabilla AT gmail DOT com>`