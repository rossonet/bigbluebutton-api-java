[![Gitpod ready-to-code](https://img.shields.io/badge/Gitpod-ready--to--code-blue?logo=gitpod)](https://gitpod.io/#https://github.com/rossonet/bigbluebutton-api-java)
[![Test on master branch with Gradle](https://github.com/rossonet/bigbluebutton-api-java/actions/workflows/test-on-master-with-gradle.yml/badge.svg)](https://github.com/rossonet/bigbluebutton-api-java/actions/workflows/test-on-master-with-gradle.yml)
[![Publish on Maven Central](https://github.com/rossonet/bigbluebutton-api-java/actions/workflows/publish-on-maven.yml/badge.svg)](https://github.com/rossonet/bigbluebutton-api-java/actions/workflows/publish-on-maven.yml)
[![Codacy Badge](https://app.codacy.com/project/badge/Grade/cb8ed4b533ca464cb5ef6bf8caaf37e8)](https://www.codacy.com/gh/rossonet/bigbluebutton-api-java/dashboard?utm_source=github.com&amp;utm_medium=referral&amp;utm_content=rossonet/bigbluebutton-api-java&amp;utm_campaign=Badge_Grade)

# Big Blue Button API Java

[forked from https://github.com/bigbluebutton/bigbluebutton-api-java](https://github.com/bigbluebutton/bigbluebutton-api-java)

## documentation

[Big Blue Button API documentation](https://docs.bigbluebutton.org/dev/api.html)

### how to get API salt and URL

```
$ bbb-conf --secret


    URL: https://yyy.xxxxxx.com/bigbluebutton/
    Secret: xxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx

    Link to the API-Mate:
    https://mconf.github.io/api-mate/#server=https://yyy.xxxxxx.com/bigbluebutton/&sharedSecret=xxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx
```

### Maven repository

[https://mvnrepository.com/artifact/net.rossonet/](https://mvnrepository.com/artifact/net.rossonet/)

#### use this library with Maven

```
<dependency>
  <groupId>net.rossonet.bbb</groupId>
  <artifactId>bigbluebutton-api-java</artifactId>
  <version>0.1.2</version>
</dependency>
```

#### use this library with Gradle

```
implementation 'net.rossonet.bbb:bigbluebutton-api-java:0.1.2'
```

### code examples

```
final BBBAPI client = new BaseBBBAPI(<String url of bbb server>, <String Secret Key>);
final String version = client.getAPIVersion();
System.out.println("Server version: " + version);
```

[test class with all examples](https://github.com/rossonet/bigbluebutton-api-java/blob/master/src/test/java/net/rossonet/bbb/examples/BBBApiTests.java)

## credit

![alt text](https://app.rossonet.net/wp-content/uploads/2021/10/rossonet-logo_280_115.png "Rossonet")

[https://www.rossonet.net](https://www.rossonet.net)

