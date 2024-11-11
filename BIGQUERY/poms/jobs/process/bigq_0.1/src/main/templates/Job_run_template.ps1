$fileDir = Split-Path -Parent $MyInvocation.MyCommand.Path
cd $fileDir
java '-Dtalend.component.manager.m2.repository=%cd%/../lib' '-Xms256M' '-Xmx1024M' '-Dfile.encoding=UTF-8' '--add-opens=java.base/java.io=ALL-UNNAMED' '--add-opens=java.base/java.nio=ALL-UNNAMED' '--add-opens=java.base/java.lang=ALL-UNNAMED' '--add-opens=java.base/java.net=ALL-UNNAMED' '--add-opens=java.base/sun.net.www.protocol.https=ALL-UNNAMED' '--add-opens=java.base/java.lang.invoke=ALL-UNNAMED' '--add-opens=java.base/java.lang.reflect=ALL-UNNAMED' '--add-opens=java.base/java.util=ALL-UNNAMED' '--add-opens=java.base/sun.nio.ch=ALL-UNNAMED' -cp '.;../lib/routines.jar;../lib/grpc-protobuf-1.61.1.jar;../lib/proto-google-cloud-bigquerystorage-v1-3.2.0.jar;../lib/google-http-client-1.44.1.jar;../lib/opencensus-contrib-http-util-0.31.1.jar;../lib/perfmark-api-0.27.0.jar;../lib/annotations-4.1.1.4.jar;../lib/grpc-netty-shaded-1.61.1.jar;../lib/j2objc-annotations-2.8.jar;../lib/protobuf-java-3.25.2.jar;../lib/grpc-alts-1.61.1.jar;../lib/google-http-client-gson-1.44.1.jar;../lib/conscrypt-openjdk-uber-2.5.2.jar;../lib/avro-1.11.3.jar;../lib/google-api-services-bigquery-v2-rev20240211-2.0.0.jar;../lib/joda-time-2.10.10.jar;../lib/protobuf-java-util-3.25.2.jar;../lib/api-common-2.26.0.jar;../lib/grpc-googleapis-1.61.1.jar;../lib/auto-value-annotations-1.10.4.jar;../lib/grpc-api-1.61.1.jar;../lib/grpc-context-1.61.1.jar;../lib/grpc-google-cloud-bigquerystorage-v1-3.2.0.jar;../lib/failureaccess-1.0.1.jar;../lib/grpc-inprocess-1.61.1.jar;../lib/auto-value-1.10.4.jar;../lib/google-cloud-core-2.33.0.jar;../lib/httpcore-4.4.16.jar;../lib/google-api-client-2.3.0.jar;../lib/jackson-annotations-2.14.2.jar;../lib/google-auth-library-credentials-1.23.0.jar;../lib/jackson-core-2.14.2.jar;../lib/google-cloud-bigquerystorage-3.2.0.jar;../lib/google-auth-library-oauth2-http-1.23.0.jar;../lib/grpc-core-1.61.1.jar;../lib/slf4j-api-1.7.36.jar;../lib/grpc-grpclb-1.61.1.jar;../lib/animal-sniffer-annotations-1.23.jar;../lib/google-oauth-client-1.35.0.jar;../lib/commons-codec-1.16.1.jar;../lib/grpc-stub-1.61.1.jar;../lib/threetenbp-1.6.8.jar;../lib/grpc-auth-1.61.1.jar;../lib/listenablefuture-9999.0-empty-to-avoid-conflict-with-guava.jar;../lib/proto-google-cloud-bigquerystorage-v1beta1-0.174.0.jar;../lib/proto-google-cloud-bigquerystorage-v1beta2-0.174.0.jar;../lib/proto-google-iam-v1-1.29.0.jar;../lib/javax.annotation-api-1.3.2.jar;../lib/gax-2.43.0.jar;../lib/opencensus-api-0.31.1.jar;../lib/google-http-client-apache-v2-1.44.1.jar;../lib/grpc-google-cloud-bigquerystorage-v1beta1-0.174.0.jar;../lib/jsr305-3.0.2.jar;../lib/jackson-databind-2.14.2.jar;../lib/gax-grpc-2.43.0.jar;../lib/grpc-protobuf-lite-1.61.1.jar;../lib/grpc-util-1.61.1.jar;../lib/error_prone_annotations-2.24.1.jar;../lib/commons-compress-1.26.0.jar;../lib/grpc-google-cloud-bigquerystorage-v1beta2-0.174.0.jar;../lib/gson-2.10.1.jar;../lib/guava-32.1.3-jre.jar;../lib/httpclient-4.5.14.jar;../lib/proto-google-common-protos-2.34.0.jar;../lib/json-20240205.jar;../lib/GoogleBigQueryJDBC42.jar;../lib/log4j-slf4j-impl-2.17.1.jar;../lib/log4j-api-2.17.1.jar;../lib/log4j-core-2.17.1.jar;../lib/component-runtime-di-1.64.8.jar;../lib/json-smart-2.4.11.jar;../lib/job-audit-1.5.jar;../lib/HikariCP-3.4.2-talend20200325.jar;../lib/component-spi-1.64.8.jar;../lib/system-routines-dq.jar;../lib/talendboot-1.0.8.jar;../lib/component-runtime-impl-1.64.8.jar;../lib/crypto-utils-7.1.20.jar;../lib/newjdbc-1.62.0.jar;../lib/audit-common-1.16.1.jar;../lib/component-runtime-manager-1.64.8.jar;../lib/javassist-3.30.2-GA.jar;../lib/dom4j-2.1.3.jar;../lib/johnzon-jsonb-1.2.21.jar;../lib/bcmail-jdk18on-1.78.1.jar;../lib/xbean-asm9-shaded-4.20.jar;../lib/accessors-smart-2.4.11.jar;../lib/antlr-runtime-3.5.2.jar;../lib/bcutil-jdk18on-1.78.1.jar;../lib/talendagent-1.0.2.jar;../lib/logging-event-layout-1.16.1.jar;../lib/talendcsv-1.1.0.jar;../lib/component-runtime-design-extension-1.64.8.jar;../lib/talend_file_enhanced-1.3.1.jar;../lib/geronimo-jsonb_1.0_spec-1.2.jar;../lib/talendCBP-1.1.4.jar;../lib/rhino-1.7.14.jar;../lib/geronimo-json_1.1_spec-1.3.jar;../lib/org.talend.dataquality.parser.jar;../lib/geronimo-annotation_1.3_spec-1.2.jar;../lib/commons-lang3-3.10.jar;../lib/bcpkix-jdk18on-1.78.1.jar;../lib/component-api-1.64.8.jar;../lib/johnzon-mapper-1.2.21.jar;../lib/container-core-1.64.8.jar;../lib/bcprov-jdk18on-1.78.1.jar;../lib/jboss-marshalling-2.0.12.Final.jar;../lib/xbean-reflect-4.20.jar;../lib/xbean-finder-shaded-4.20.jar;../lib/audit-log4j2-1.16.1.jar;../lib/asm-9.5.jar;../lib/johnzon-core-1.2.21.jar;../lib/system-routines.jar;bigq_0_1.jar;' bigquery.bigq_0_1.BIgQ --context=Default $args
