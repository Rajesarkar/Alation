#!/bin/sh
cd `dirname $0`
ROOT_PATH=`pwd`
java -Dtalend.component.manager.m2.repository=$ROOT_PATH/../lib -Xms256M -Xmx1024M -Dfile.encoding=UTF-8 --add-opens=java.base/java.io=ALL-UNNAMED --add-opens=java.base/java.nio=ALL-UNNAMED --add-opens=java.base/java.lang=ALL-UNNAMED --add-opens=java.base/java.net=ALL-UNNAMED --add-opens=java.base/sun.net.www.protocol.https=ALL-UNNAMED --add-opens=java.base/java.lang.invoke=ALL-UNNAMED --add-opens=java.base/java.lang.reflect=ALL-UNNAMED --add-opens=java.base/java.util=ALL-UNNAMED --add-opens=java.base/sun.nio.ch=ALL-UNNAMED -cp .:$ROOT_PATH:$ROOT_PATH/../lib/routines.jar:$ROOT_PATH/../lib/grpc-protobuf-1.61.1.jar:$ROOT_PATH/../lib/proto-google-cloud-bigquerystorage-v1-3.2.0.jar:$ROOT_PATH/../lib/google-http-client-1.44.1.jar:$ROOT_PATH/../lib/opencensus-contrib-http-util-0.31.1.jar:$ROOT_PATH/../lib/perfmark-api-0.27.0.jar:$ROOT_PATH/../lib/annotations-4.1.1.4.jar:$ROOT_PATH/../lib/grpc-netty-shaded-1.61.1.jar:$ROOT_PATH/../lib/j2objc-annotations-2.8.jar:$ROOT_PATH/../lib/protobuf-java-3.25.2.jar:$ROOT_PATH/../lib/grpc-alts-1.61.1.jar:$ROOT_PATH/../lib/google-http-client-gson-1.44.1.jar:$ROOT_PATH/../lib/conscrypt-openjdk-uber-2.5.2.jar:$ROOT_PATH/../lib/avro-1.11.3.jar:$ROOT_PATH/../lib/google-api-services-bigquery-v2-rev20240211-2.0.0.jar:$ROOT_PATH/../lib/joda-time-2.10.10.jar:$ROOT_PATH/../lib/protobuf-java-util-3.25.2.jar:$ROOT_PATH/../lib/api-common-2.26.0.jar:$ROOT_PATH/../lib/grpc-googleapis-1.61.1.jar:$ROOT_PATH/../lib/auto-value-annotations-1.10.4.jar:$ROOT_PATH/../lib/grpc-api-1.61.1.jar:$ROOT_PATH/../lib/grpc-context-1.61.1.jar:$ROOT_PATH/../lib/grpc-google-cloud-bigquerystorage-v1-3.2.0.jar:$ROOT_PATH/../lib/failureaccess-1.0.1.jar:$ROOT_PATH/../lib/grpc-inprocess-1.61.1.jar:$ROOT_PATH/../lib/auto-value-1.10.4.jar:$ROOT_PATH/../lib/google-cloud-core-2.33.0.jar:$ROOT_PATH/../lib/httpcore-4.4.16.jar:$ROOT_PATH/../lib/google-api-client-2.3.0.jar:$ROOT_PATH/../lib/jackson-annotations-2.14.2.jar:$ROOT_PATH/../lib/google-auth-library-credentials-1.23.0.jar:$ROOT_PATH/../lib/jackson-core-2.14.2.jar:$ROOT_PATH/../lib/google-cloud-bigquerystorage-3.2.0.jar:$ROOT_PATH/../lib/google-auth-library-oauth2-http-1.23.0.jar:$ROOT_PATH/../lib/grpc-core-1.61.1.jar:$ROOT_PATH/../lib/slf4j-api-1.7.36.jar:$ROOT_PATH/../lib/grpc-grpclb-1.61.1.jar:$ROOT_PATH/../lib/animal-sniffer-annotations-1.23.jar:$ROOT_PATH/../lib/google-oauth-client-1.35.0.jar:$ROOT_PATH/../lib/commons-codec-1.16.1.jar:$ROOT_PATH/../lib/grpc-stub-1.61.1.jar:$ROOT_PATH/../lib/threetenbp-1.6.8.jar:$ROOT_PATH/../lib/grpc-auth-1.61.1.jar:$ROOT_PATH/../lib/listenablefuture-9999.0-empty-to-avoid-conflict-with-guava.jar:$ROOT_PATH/../lib/proto-google-cloud-bigquerystorage-v1beta1-0.174.0.jar:$ROOT_PATH/../lib/proto-google-cloud-bigquerystorage-v1beta2-0.174.0.jar:$ROOT_PATH/../lib/proto-google-iam-v1-1.29.0.jar:$ROOT_PATH/../lib/javax.annotation-api-1.3.2.jar:$ROOT_PATH/../lib/gax-2.43.0.jar:$ROOT_PATH/../lib/opencensus-api-0.31.1.jar:$ROOT_PATH/../lib/google-http-client-apache-v2-1.44.1.jar:$ROOT_PATH/../lib/grpc-google-cloud-bigquerystorage-v1beta1-0.174.0.jar:$ROOT_PATH/../lib/jsr305-3.0.2.jar:$ROOT_PATH/../lib/jackson-databind-2.14.2.jar:$ROOT_PATH/../lib/gax-grpc-2.43.0.jar:$ROOT_PATH/../lib/grpc-protobuf-lite-1.61.1.jar:$ROOT_PATH/../lib/grpc-util-1.61.1.jar:$ROOT_PATH/../lib/error_prone_annotations-2.24.1.jar:$ROOT_PATH/../lib/commons-compress-1.26.0.jar:$ROOT_PATH/../lib/grpc-google-cloud-bigquerystorage-v1beta2-0.174.0.jar:$ROOT_PATH/../lib/gson-2.10.1.jar:$ROOT_PATH/../lib/guava-32.1.3-jre.jar:$ROOT_PATH/../lib/httpclient-4.5.14.jar:$ROOT_PATH/../lib/proto-google-common-protos-2.34.0.jar:$ROOT_PATH/../lib/json-20240205.jar:$ROOT_PATH/../lib/GoogleBigQueryJDBC42.jar:$ROOT_PATH/../lib/log4j-slf4j-impl-2.17.1.jar:$ROOT_PATH/../lib/log4j-api-2.17.1.jar:$ROOT_PATH/../lib/log4j-core-2.17.1.jar:$ROOT_PATH/../lib/component-runtime-di-1.64.8.jar:$ROOT_PATH/../lib/json-smart-2.4.11.jar:$ROOT_PATH/../lib/job-audit-1.5.jar:$ROOT_PATH/../lib/HikariCP-3.4.2-talend20200325.jar:$ROOT_PATH/../lib/component-spi-1.64.8.jar:$ROOT_PATH/../lib/system-routines-dq.jar:$ROOT_PATH/../lib/talendboot-1.0.8.jar:$ROOT_PATH/../lib/component-runtime-impl-1.64.8.jar:$ROOT_PATH/../lib/crypto-utils-7.1.20.jar:$ROOT_PATH/../lib/newjdbc-1.62.0.jar:$ROOT_PATH/../lib/audit-common-1.16.1.jar:$ROOT_PATH/../lib/component-runtime-manager-1.64.8.jar:$ROOT_PATH/../lib/javassist-3.30.2-GA.jar:$ROOT_PATH/../lib/dom4j-2.1.3.jar:$ROOT_PATH/../lib/johnzon-jsonb-1.2.21.jar:$ROOT_PATH/../lib/bcmail-jdk18on-1.78.1.jar:$ROOT_PATH/../lib/xbean-asm9-shaded-4.20.jar:$ROOT_PATH/../lib/accessors-smart-2.4.11.jar:$ROOT_PATH/../lib/antlr-runtime-3.5.2.jar:$ROOT_PATH/../lib/bcutil-jdk18on-1.78.1.jar:$ROOT_PATH/../lib/talendagent-1.0.2.jar:$ROOT_PATH/../lib/logging-event-layout-1.16.1.jar:$ROOT_PATH/../lib/talendcsv-1.1.0.jar:$ROOT_PATH/../lib/component-runtime-design-extension-1.64.8.jar:$ROOT_PATH/../lib/talend_file_enhanced-1.3.1.jar:$ROOT_PATH/../lib/geronimo-jsonb_1.0_spec-1.2.jar:$ROOT_PATH/../lib/talendCBP-1.1.4.jar:$ROOT_PATH/../lib/rhino-1.7.14.jar:$ROOT_PATH/../lib/geronimo-json_1.1_spec-1.3.jar:$ROOT_PATH/../lib/org.talend.dataquality.parser.jar:$ROOT_PATH/../lib/geronimo-annotation_1.3_spec-1.2.jar:$ROOT_PATH/../lib/commons-lang3-3.10.jar:$ROOT_PATH/../lib/bcpkix-jdk18on-1.78.1.jar:$ROOT_PATH/../lib/component-api-1.64.8.jar:$ROOT_PATH/../lib/johnzon-mapper-1.2.21.jar:$ROOT_PATH/../lib/container-core-1.64.8.jar:$ROOT_PATH/../lib/bcprov-jdk18on-1.78.1.jar:$ROOT_PATH/../lib/jboss-marshalling-2.0.12.Final.jar:$ROOT_PATH/../lib/xbean-reflect-4.20.jar:$ROOT_PATH/../lib/xbean-finder-shaded-4.20.jar:$ROOT_PATH/../lib/audit-log4j2-1.16.1.jar:$ROOT_PATH/../lib/asm-9.5.jar:$ROOT_PATH/../lib/johnzon-core-1.2.21.jar:$ROOT_PATH/../lib/system-routines.jar:$ROOT_PATH/bigquery1_0_1.jar: bigquery.bigquery1_0_1.Bigquery1 "$@"
