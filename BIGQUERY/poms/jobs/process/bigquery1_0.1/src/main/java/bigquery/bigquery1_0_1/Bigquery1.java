
package bigquery.bigquery1_0_1;

import routines.DataOperation;
import routines.TalendDataGenerator;
import routines.DataQuality;
import routines.Relational;
import routines.Mathematical;
import routines.DataQualityDependencies;
import routines.SQLike;
import routines.Numeric;
import routines.TalendStringUtil;
import routines.TalendString;
import routines.MDM;
import routines.StringHandling;
import routines.DQTechnical;
import routines.TalendDate;
import routines.DataMasking;
import routines.DqStringHandling;
import routines.system.*;
import routines.system.api.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.math.BigDecimal;
import java.io.ByteArrayOutputStream;
import java.io.ByteArrayInputStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.ObjectOutputStream;
import java.io.ObjectInputStream;
import java.io.IOException;
import java.util.Comparator;

@SuppressWarnings("unused")

/**
 * Job: Bigquery1 Purpose: <br>
 * Description: <br>
 * 
 * @author admin@thinkartha.com
 * @version 8.0.1.20241016_1624-patch
 * @status
 */
public class Bigquery1 implements TalendJob {
	static {
		System.setProperty("TalendJob.log", "Bigquery1.log");
	}

	private static org.apache.logging.log4j.Logger log = org.apache.logging.log4j.LogManager.getLogger(Bigquery1.class);

	protected static void logIgnoredError(String message, Throwable cause) {
		log.error(message, cause);

	}

	public final Object obj = new Object();

	// for transmiting parameters purpose
	private Object valueObject = null;

	public Object getValueObject() {
		return this.valueObject;
	}

	public void setValueObject(Object valueObject) {
		this.valueObject = valueObject;
	}

	private final static String defaultCharset = java.nio.charset.Charset.defaultCharset().name();

	private final static String utf8Charset = "UTF-8";

	public static String taskExecutionId = null;

	public static String jobExecutionId = java.util.UUID.randomUUID().toString();;

	// contains type for every context property
	public class PropertiesWithType extends java.util.Properties {
		private static final long serialVersionUID = 1L;
		private java.util.Map<String, String> propertyTypes = new java.util.HashMap<>();

		public PropertiesWithType(java.util.Properties properties) {
			super(properties);
		}

		public PropertiesWithType() {
			super();
		}

		public void setContextType(String key, String type) {
			propertyTypes.put(key, type);
		}

		public String getContextType(String key) {
			return propertyTypes.get(key);
		}
	}

	// create and load default properties
	private java.util.Properties defaultProps = new java.util.Properties();

	// create application properties with default
	public class ContextProperties extends PropertiesWithType {

		private static final long serialVersionUID = 1L;

		public ContextProperties(java.util.Properties properties) {
			super(properties);
		}

		public ContextProperties() {
			super();
		}

		public void synchronizeContext() {

		}

		// if the stored or passed value is "<TALEND_NULL>" string, it mean null
		public String getStringValue(String key) {
			String origin_value = this.getProperty(key);
			if (NULL_VALUE_EXPRESSION_IN_COMMAND_STRING_FOR_CHILD_JOB_ONLY.equals(origin_value)) {
				return null;
			}
			return origin_value;
		}

	}

	protected ContextProperties context = new ContextProperties(); // will be instanciated by MS.

	public ContextProperties getContext() {
		return this.context;
	}

	protected java.util.Map<String, String> defaultProperties = new java.util.HashMap<String, String>();
	protected java.util.Map<String, String> additionalProperties = new java.util.HashMap<String, String>();

	public java.util.Map<String, String> getDefaultProperties() {
		return this.defaultProperties;
	}

	public java.util.Map<String, String> getAdditionalProperties() {
		return this.additionalProperties;
	}

	private final String jobVersion = "0.1";
	private final String jobName = "Bigquery1";
	private final String projectName = "BIGQUERY";
	public Integer errorCode = null;
	private String currentComponent = "";
	public static boolean isStandaloneMS = Boolean.valueOf("false");

	private void s(final String component) {
		try {
			org.talend.metrics.DataReadTracker.setCurrentComponent(jobName, component);
		} catch (Exception | NoClassDefFoundError e) {
			// ignore
		}
	}

	private void mdc(final String subJobName, final String subJobPidPrefix) {
		mdcInfo.forEach(org.slf4j.MDC::put);
		org.slf4j.MDC.put("_subJobName", subJobName);
		org.slf4j.MDC.put("_subJobPid", subJobPidPrefix + subJobPidCounter.getAndIncrement());
	}

	private void sh(final String componentId) {
		ok_Hash.put(componentId, false);
		start_Hash.put(componentId, System.currentTimeMillis());
	}

	{
		s("none");
	}

	private String cLabel = null;

	private final java.util.Map<String, Object> globalMap = new java.util.HashMap<String, Object>();
	private final static java.util.Map<String, Object> junitGlobalMap = new java.util.HashMap<String, Object>();

	private final java.util.Map<String, Long> start_Hash = new java.util.HashMap<String, Long>();
	private final java.util.Map<String, Long> end_Hash = new java.util.HashMap<String, Long>();
	private final java.util.Map<String, Boolean> ok_Hash = new java.util.HashMap<String, Boolean>();
	public final java.util.List<String[]> globalBuffer = new java.util.ArrayList<String[]>();

	private final JobStructureCatcherUtils talendJobLog = new JobStructureCatcherUtils(jobName,
			"_g5uT8JT-Ee-43stZsMkBDA", "0.1");
	private org.talend.job.audit.JobAuditLogger auditLogger_talendJobLog = null;

	private RunStat runStat = new RunStat(talendJobLog, System.getProperty("audit.interval"));

	// OSGi DataSource
	private final static String KEY_DB_DATASOURCES = "KEY_DB_DATASOURCES";

	private final static String KEY_DB_DATASOURCES_RAW = "KEY_DB_DATASOURCES_RAW";

	public void setDataSources(java.util.Map<String, javax.sql.DataSource> dataSources) {
		java.util.Map<String, routines.system.TalendDataSource> talendDataSources = new java.util.HashMap<String, routines.system.TalendDataSource>();
		for (java.util.Map.Entry<String, javax.sql.DataSource> dataSourceEntry : dataSources.entrySet()) {
			talendDataSources.put(dataSourceEntry.getKey(),
					new routines.system.TalendDataSource(dataSourceEntry.getValue()));
		}
		globalMap.put(KEY_DB_DATASOURCES, talendDataSources);
		globalMap.put(KEY_DB_DATASOURCES_RAW, new java.util.HashMap<String, javax.sql.DataSource>(dataSources));
	}

	public void setDataSourceReferences(List serviceReferences) throws Exception {

		java.util.Map<String, routines.system.TalendDataSource> talendDataSources = new java.util.HashMap<String, routines.system.TalendDataSource>();
		java.util.Map<String, javax.sql.DataSource> dataSources = new java.util.HashMap<String, javax.sql.DataSource>();

		for (java.util.Map.Entry<String, javax.sql.DataSource> entry : BundleUtils
				.getServices(serviceReferences, javax.sql.DataSource.class).entrySet()) {
			dataSources.put(entry.getKey(), entry.getValue());
			talendDataSources.put(entry.getKey(), new routines.system.TalendDataSource(entry.getValue()));
		}

		globalMap.put(KEY_DB_DATASOURCES, talendDataSources);
		globalMap.put(KEY_DB_DATASOURCES_RAW, new java.util.HashMap<String, javax.sql.DataSource>(dataSources));
	}

	private final java.io.ByteArrayOutputStream baos = new java.io.ByteArrayOutputStream();
	private final java.io.PrintStream errorMessagePS = new java.io.PrintStream(new java.io.BufferedOutputStream(baos));

	public String getExceptionStackTrace() {
		if ("failure".equals(this.getStatus())) {
			errorMessagePS.flush();
			return baos.toString();
		}
		return null;
	}

	private Exception exception;

	public Exception getException() {
		if ("failure".equals(this.getStatus())) {
			return this.exception;
		}
		return null;
	}

	private class TalendException extends Exception {

		private static final long serialVersionUID = 1L;

		private java.util.Map<String, Object> globalMap = null;
		private Exception e = null;

		private String currentComponent = null;
		private String cLabel = null;

		private String virtualComponentName = null;

		public void setVirtualComponentName(String virtualComponentName) {
			this.virtualComponentName = virtualComponentName;
		}

		private TalendException(Exception e, String errorComponent, final java.util.Map<String, Object> globalMap) {
			this.currentComponent = errorComponent;
			this.globalMap = globalMap;
			this.e = e;
		}

		private TalendException(Exception e, String errorComponent, String errorComponentLabel,
				final java.util.Map<String, Object> globalMap) {
			this(e, errorComponent, globalMap);
			this.cLabel = errorComponentLabel;
		}

		public Exception getException() {
			return this.e;
		}

		public String getCurrentComponent() {
			return this.currentComponent;
		}

		public String getExceptionCauseMessage(Exception e) {
			Throwable cause = e;
			String message = null;
			int i = 10;
			while (null != cause && 0 < i--) {
				message = cause.getMessage();
				if (null == message) {
					cause = cause.getCause();
				} else {
					break;
				}
			}
			if (null == message) {
				message = e.getClass().getName();
			}
			return message;
		}

		@Override
		public void printStackTrace() {
			if (!(e instanceof TalendException || e instanceof TDieException)) {
				if (virtualComponentName != null && currentComponent.indexOf(virtualComponentName + "_") == 0) {
					globalMap.put(virtualComponentName + "_ERROR_MESSAGE", getExceptionCauseMessage(e));
				}
				globalMap.put(currentComponent + "_ERROR_MESSAGE", getExceptionCauseMessage(e));
				System.err.println("Exception in component " + currentComponent + " (" + jobName + ")");
			}
			if (!(e instanceof TDieException)) {
				if (e instanceof TalendException) {
					e.printStackTrace();
				} else {
					e.printStackTrace();
					e.printStackTrace(errorMessagePS);
					Bigquery1.this.exception = e;
				}
			}
			if (!(e instanceof TalendException)) {
				try {
					for (java.lang.reflect.Method m : this.getClass().getEnclosingClass().getMethods()) {
						if (m.getName().compareTo(currentComponent + "_error") == 0) {
							m.invoke(Bigquery1.this, new Object[] { e, currentComponent, globalMap });
							break;
						}
					}

					if (!(e instanceof TDieException)) {
						if (enableLogStash) {
							talendJobLog.addJobExceptionMessage(currentComponent, cLabel, null, e);
							talendJobLogProcess(globalMap);
						}
					}
				} catch (Exception e) {
					this.e.printStackTrace();
				}
			}
		}
	}

	public void tDBConnection_1_error(Exception exception, String errorComponent,
			final java.util.Map<String, Object> globalMap) throws TalendException {

		end_Hash.put(errorComponent, System.currentTimeMillis());

		status = "failure";

		tDBConnection_1_onSubJobError(exception, errorComponent, globalMap);
	}

	public void talendJobLog_error(Exception exception, String errorComponent,
			final java.util.Map<String, Object> globalMap) throws TalendException {

		end_Hash.put(errorComponent, System.currentTimeMillis());

		status = "failure";

		talendJobLog_onSubJobError(exception, errorComponent, globalMap);
	}

	public void tDBConnection_1_onSubJobError(Exception exception, String errorComponent,
			final java.util.Map<String, Object> globalMap) throws TalendException {

		resumeUtil.addLog("SYSTEM_LOG", "NODE:" + errorComponent, "", Thread.currentThread().getId() + "", "FATAL", "",
				exception.getMessage(), ResumeUtil.getExceptionStackTrace(exception), "");

	}

	public void talendJobLog_onSubJobError(Exception exception, String errorComponent,
			final java.util.Map<String, Object> globalMap) throws TalendException {

		resumeUtil.addLog("SYSTEM_LOG", "NODE:" + errorComponent, "", Thread.currentThread().getId() + "", "FATAL", "",
				exception.getMessage(), ResumeUtil.getExceptionStackTrace(exception), "");

	}

	public void tDBConnection_1Process(final java.util.Map<String, Object> globalMap) throws TalendException {
		globalMap.put("tDBConnection_1_SUBPROCESS_STATE", 0);

		final boolean execStat = this.execStat;

		mdc("tDBConnection_1", "Yv00nN_");

		String iterateId = "";

		String currentComponent = "";
		s("none");
		String cLabel = null;
		java.util.Map<String, Object> resourceMap = new java.util.HashMap<String, Object>();

		try {
			// TDI-39566 avoid throwing an useless Exception
			boolean resumeIt = true;
			if (globalResumeTicket == false && resumeEntryMethodName != null) {
				String currentMethodName = new java.lang.Exception().getStackTrace()[0].getMethodName();
				resumeIt = resumeEntryMethodName.equals(currentMethodName);
			}
			if (resumeIt || globalResumeTicket) { // start the resume
				globalResumeTicket = true;

				/**
				 * [tDBConnection_1 begin ] start
				 */

				sh("tDBConnection_1");

				s(currentComponent = "tDBConnection_1");

				cLabel = "BQ";

				int tos_count_tDBConnection_1 = 0;

				if (log.isDebugEnabled())
					log.debug("tDBConnection_1 - " + ("Start to work."));
				if (log.isDebugEnabled()) {
					class BytesLimit65535_tDBConnection_1 {
						public void limitLog4jByte() throws Exception {
							StringBuilder log4jParamters_tDBConnection_1 = new StringBuilder();
							log4jParamters_tDBConnection_1.append("Parameters:");
							log4jParamters_tDBConnection_1.append("configuration.jdbcUrl" + " = "
									+ "\"jdbc:bigquery://https://www.googleapis.com/bigquery/v2:443;ProjectId=mdfltfs;OAuthType=0;OAuthServiceAcctEmail=mdf-ltfs@mdfltfs.iam.gserviceaccount.com;OAuthPvtKeyPath=C:/Users/20234/Downloads/mdfltfs-95c7663066cc.json;\"");
							log4jParamters_tDBConnection_1.append(" | ");
							log4jParamters_tDBConnection_1.append("configuration.jdbcDriver" + " = "
									+ "[{configuration.jdbcDriver[].path="
									+ ("mvn:org.codehaus.mojo/animal-sniffer-annotations/1.23/jar")
									+ "}, {configuration.jdbcDriver[].path="
									+ ("mvn:com.google.android/annotations/4.1.1.4/jar")
									+ "}, {configuration.jdbcDriver[].path="
									+ ("mvn:org.talend.libraries/api-common-2.26.0/6.0.0-SNAPSHOT/jar")
									+ "}, {configuration.jdbcDriver[].path="
									+ ("mvn:com.google.auto.value/auto-value/1.10.4/jar")
									+ "}, {configuration.jdbcDriver[].path="
									+ ("mvn:com.google.auto.value/auto-value-annotations/1.10.4/jar")
									+ "}, {configuration.jdbcDriver[].path=" + ("mvn:org.apache.avro/avro/1.11.3/jar")
									+ "}, {configuration.jdbcDriver[].path="
									+ ("mvn:commons-codec/commons-codec/1.16.1/jar")
									+ "}, {configuration.jdbcDriver[].path="
									+ ("mvn:org.apache.commons/commons-compress/1.26.0/jar")
									+ "}, {configuration.jdbcDriver[].path="
									+ ("mvn:org.conscrypt/conscrypt-openjdk-uber/2.5.2/jar")
									+ "}, {configuration.jdbcDriver[].path="
									+ ("mvn:com.google.errorprone/error_prone_annotations/2.24.1/jar")
									+ "}, {configuration.jdbcDriver[].path="
									+ ("mvn:com.google.guava/failureaccess/1.0.1/jar")
									+ "}, {configuration.jdbcDriver[].path=" + ("mvn:com.google.api/gax/2.43.0/jar")
									+ "}, {configuration.jdbcDriver[].path="
									+ ("mvn:com.google.api/gax-grpc/2.43.0/jar")
									+ "}, {configuration.jdbcDriver[].path="
									+ ("mvn:com.google.apis/google-api-services-bigquery/v2-rev20240211-2.0.0/jar")
									+ "}, {configuration.jdbcDriver[].path="
									+ ("mvn:com.google.api-client/google-api-client/2.3.0/jar")
									+ "}, {configuration.jdbcDriver[].path="
									+ ("mvn:com.google.auth/google-auth-library-credentials/1.23.0/jar")
									+ "}, {configuration.jdbcDriver[].path="
									+ ("mvn:com.google.auth/google-auth-library-oauth2-http/1.23.0/jar")
									+ "}, {configuration.jdbcDriver[].path="
									+ ("mvn:org.talend.libraries/GoogleBigQueryJDBC42/6.0.0-SNAPSHOT/jar")
									+ "}, {configuration.jdbcDriver[].path="
									+ ("mvn:com.google.cloud/google-cloud-bigquerystorage/3.2.0/jar")
									+ "}, {configuration.jdbcDriver[].path="
									+ ("mvn:com.google.cloud/google-cloud-core/2.33.0/jar")
									+ "}, {configuration.jdbcDriver[].path="
									+ ("mvn:com.google.http-client/google-http-client/1.44.1/jar")
									+ "}, {configuration.jdbcDriver[].path="
									+ ("mvn:com.google.http-client/google-http-client-apache-v2/1.44.1/jar")
									+ "}, {configuration.jdbcDriver[].path="
									+ ("mvn:com.google.http-client/google-http-client-gson/1.44.1/jar")
									+ "}, {configuration.jdbcDriver[].path="
									+ ("mvn:com.google.oauth-client/google-oauth-client/1.35.0/jar")
									+ "}, {configuration.jdbcDriver[].path="
									+ ("mvn:org.talend.libraries/grpc-alts-1.61.1/6.0.0-SNAPSHOT/jar")
									+ "}, {configuration.jdbcDriver[].path="
									+ ("mvn:org.talend.libraries/grpc-api-1.61.1/6.0.0-SNAPSHOT/jar")
									+ "}, {configuration.jdbcDriver[].path="
									+ ("mvn:org.talend.libraries/grpc-auth-1.61.1/6.0.0-SNAPSHOT/jar")
									+ "}, {configuration.jdbcDriver[].path="
									+ ("mvn:org.talend.libraries/grpc-context-1.61.1/6.0.0-SNAPSHOT/jar")
									+ "}, {configuration.jdbcDriver[].path="
									+ ("mvn:org.talend.libraries/grpc-core-1.61.1/6.0.0-SNAPSHOT/jar")
									+ "}, {configuration.jdbcDriver[].path="
									+ ("mvn:org.talend.libraries/grpc-googleapis-1.61.1/6.0.0-SNAPSHOT/jar")
									+ "}, {configuration.jdbcDriver[].path="
									+ ("mvn:com.google.api.grpc/grpc-google-cloud-bigquerystorage-v1/3.2.0/jar")
									+ "}, {configuration.jdbcDriver[].path="
									+ ("mvn:com.google.api.grpc/grpc-google-cloud-bigquerystorage-v1beta1/0.174.0/jar")
									+ "}, {configuration.jdbcDriver[].path="
									+ ("mvn:com.google.api.grpc/grpc-google-cloud-bigquerystorage-v1beta2/0.174.0/jar")
									+ "}, {configuration.jdbcDriver[].path="
									+ ("mvn:org.talend.libraries/grpc-grpclb-1.61.1/6.0.0-SNAPSHOT/jar")
									+ "}, {configuration.jdbcDriver[].path="
									+ ("mvn:org.talend.libraries/grpc-inprocess-1.61.1/6.0.0-SNAPSHOT/jar")
									+ "}, {configuration.jdbcDriver[].path="
									+ ("mvn:org.talend.libraries/grpc-netty-shaded-1.61.1/6.0.0-SNAPSHOT/jar")
									+ "}, {configuration.jdbcDriver[].path="
									+ ("mvn:org.talend.libraries/grpc-protobuf-1.61.1/6.0.0-SNAPSHOT/jar")
									+ "}, {configuration.jdbcDriver[].path="
									+ ("mvn:org.talend.libraries/grpc-protobuf-lite-1.61.1/6.0.0-SNAPSHOT/jar")
									+ "}, {configuration.jdbcDriver[].path="
									+ ("mvn:org.talend.libraries/grpc-stub-1.61.1/6.0.0-SNAPSHOT/jar")
									+ "}, {configuration.jdbcDriver[].path="
									+ ("mvn:org.talend.libraries/grpc-util-1.61.1/6.0.0-SNAPSHOT/jar")
									+ "}, {configuration.jdbcDriver[].path="
									+ ("mvn:com.google.code.gson/gson/2.10.1/jar")
									+ "}, {configuration.jdbcDriver[].path="
									+ ("mvn:com.google.guava/guava/32.1.3-jre/jar")
									+ "}, {configuration.jdbcDriver[].path="
									+ ("mvn:org.apache.httpcomponents/httpclient/4.5.14/jar")
									+ "}, {configuration.jdbcDriver[].path="
									+ ("mvn:org.apache.httpcomponents/httpcore/4.4.16/jar")
									+ "}, {configuration.jdbcDriver[].path="
									+ ("mvn:com.google.j2objc/j2objc-annotations/2.8/jar")
									+ "}, {configuration.jdbcDriver[].path="
									+ ("mvn:com.fasterxml.jackson.core/jackson-annotations/2.14.2/jar")
									+ "}, {configuration.jdbcDriver[].path="
									+ ("mvn:com.fasterxml.jackson.core/jackson-core/2.14.2/jar")
									+ "}, {configuration.jdbcDriver[].path="
									+ ("mvn:com.fasterxml.jackson.core/jackson-databind/2.14.2/jar")
									+ "}, {configuration.jdbcDriver[].path="
									+ ("mvn:javax.annotation/javax.annotation-api/1.3.2/jar")
									+ "}, {configuration.jdbcDriver[].path=" + ("mvn:joda-time/joda-time/2.10.10/jar")
									+ "}, {configuration.jdbcDriver[].path=" + ("mvn:org.json/json/20240205/jar")
									+ "}, {configuration.jdbcDriver[].path="
									+ ("mvn:com.google.code.findbugs/jsr305/3.0.2/jar")
									+ "}, {configuration.jdbcDriver[].path="
									+ ("mvn:com.google.guava/listenablefuture/9999.0-empty-to-avoid-conflict-with-guava/jar")
									+ "}, {configuration.jdbcDriver[].path="
									+ ("mvn:io.opencensus/opencensus-api/0.31.1/jar")
									+ "}, {configuration.jdbcDriver[].path="
									+ ("mvn:io.opencensus/opencensus-contrib-http-util/0.31.1/jar")
									+ "}, {configuration.jdbcDriver[].path="
									+ ("mvn:org.talend.libraries/perfmark-api-0.27.0/6.0.0-SNAPSHOT/jar")
									+ "}, {configuration.jdbcDriver[].path="
									+ ("mvn:org.talend.libraries/protobuf-java-3.25.2/6.0.0-SNAPSHOT/jar")
									+ "}, {configuration.jdbcDriver[].path="
									+ ("mvn:org.talend.libraries/protobuf-java-util-3.25.2/6.0.0-SNAPSHOT/jar")
									+ "}, {configuration.jdbcDriver[].path="
									+ ("mvn:com.google.api.grpc/proto-google-cloud-bigquerystorage-v1/3.2.0/jar")
									+ "}, {configuration.jdbcDriver[].path="
									+ ("mvn:com.google.api.grpc/proto-google-cloud-bigquerystorage-v1beta1/0.174.0/jar")
									+ "}, {configuration.jdbcDriver[].path="
									+ ("mvn:com.google.api.grpc/proto-google-cloud-bigquerystorage-v1beta2/0.174.0/jar")
									+ "}, {configuration.jdbcDriver[].path="
									+ ("mvn:com.google.api.grpc/proto-google-common-protos/2.34.0/jar")
									+ "}, {configuration.jdbcDriver[].path="
									+ ("mvn:com.google.api.grpc/proto-google-iam-v1/1.29.0/jar")
									+ "}, {configuration.jdbcDriver[].path=" + ("mvn:org.slf4j/slf4j-api/1.7.36/jar")
									+ "}, {configuration.jdbcDriver[].path=" + ("mvn:org.threeten/threetenbp/1.6.8/jar")
									+ "}]");
							log4jParamters_tDBConnection_1.append(" | ");
							log4jParamters_tDBConnection_1.append(
									"configuration.jdbcClass" + " = " + "\"com.simba.googlebigquery.jdbc.Driver\"");
							log4jParamters_tDBConnection_1.append(" | ");
							log4jParamters_tDBConnection_1.append("configuration.userId" + " = " + "");
							log4jParamters_tDBConnection_1.append(" | ");
							log4jParamters_tDBConnection_1.append("configuration.password" + " = " + String
									.valueOf(routines.system.PasswordEncryptUtil.encryptPassword("")).substring(0, 4)
									+ "...");
							log4jParamters_tDBConnection_1.append(" | ");
							log4jParamters_tDBConnection_1
									.append("configuration.useSharedDBConnection" + " = " + "false");
							log4jParamters_tDBConnection_1.append(" | ");
							log4jParamters_tDBConnection_1.append("configuration.useDataSource" + " = " + "false");
							log4jParamters_tDBConnection_1.append(" | ");
							log4jParamters_tDBConnection_1.append("configuration.useAutoCommit" + " = " + "false");
							log4jParamters_tDBConnection_1.append(" | ");
							log4jParamters_tDBConnection_1.append("UNIFIED_COMPONENTS" + " = " + "JDBCConnection");
							log4jParamters_tDBConnection_1.append(" | ");
							if (log.isDebugEnabled())
								log.debug("tDBConnection_1 - " + (log4jParamters_tDBConnection_1));
						}
					}
					new BytesLimit65535_tDBConnection_1().limitLog4jByte();
				}
				if (enableLogStash) {
					talendJobLog.addCM("tDBConnection_1", "BQ", "JDBCConnection");
					talendJobLogProcess(globalMap);
					s(currentComponent);
				}

				final org.talend.sdk.component.runtime.manager.ComponentManager mgr_tDBConnection_1 = org.talend.sdk.component.runtime.manager.ComponentManager
						.instance();
				if (mgr_tDBConnection_1.getContainer().findAll().isEmpty()) {
					mgr_tDBConnection_1.autoDiscoverPlugins(false, true);
				}

				final java.util.Map<String, String> configuration_tDBConnection_1 = new java.util.HashMap<>();
				final java.util.Map<String, String> registry_metadata_tDBConnection_1 = new java.util.HashMap<>();

				final class SettingHelper_tDBConnection_1 {
					final java.util.Map<String, String> configuration;

					SettingHelper_tDBConnection_1(final java.util.Map<String, String> configuration) {
						this.configuration = configuration;
					}

					void put(String key, String value) {
						if (value != null) {
							configuration.put(key, value);
						}
					}
				}

				final SettingHelper_tDBConnection_1 s_tDBConnection_1 = new SettingHelper_tDBConnection_1(
						configuration_tDBConnection_1);

				java.net.URL mappings_url_tDBConnection_1 = this.getClass().getResource("/xmlMappings");
				globalMap.put("tDBConnection_1_MAPPINGS_URL", mappings_url_tDBConnection_1);

				s_tDBConnection_1.put("configuration.jdbcUrl",
						"jdbc:bigquery://https://www.googleapis.com/bigquery/v2:443;ProjectId=mdfltfs;OAuthType=0;OAuthServiceAcctEmail=mdf-ltfs@mdfltfs.iam.gserviceaccount.com;OAuthPvtKeyPath=C:/Users/20234/Downloads/mdfltfs-95c7663066cc.json;");
				s_tDBConnection_1.put("configuration.jdbcDriver[0].path",
						"mvn:org.codehaus.mojo/animal-sniffer-annotations/1.23/jar");
				s_tDBConnection_1.put("configuration.jdbcDriver[1].path",
						"mvn:com.google.android/annotations/4.1.1.4/jar");
				s_tDBConnection_1.put("configuration.jdbcDriver[2].path",
						"mvn:org.talend.libraries/api-common-2.26.0/6.0.0-SNAPSHOT/jar");
				s_tDBConnection_1.put("configuration.jdbcDriver[3].path",
						"mvn:com.google.auto.value/auto-value/1.10.4/jar");
				s_tDBConnection_1.put("configuration.jdbcDriver[4].path",
						"mvn:com.google.auto.value/auto-value-annotations/1.10.4/jar");
				s_tDBConnection_1.put("configuration.jdbcDriver[5].path", "mvn:org.apache.avro/avro/1.11.3/jar");
				s_tDBConnection_1.put("configuration.jdbcDriver[6].path", "mvn:commons-codec/commons-codec/1.16.1/jar");
				s_tDBConnection_1.put("configuration.jdbcDriver[7].path",
						"mvn:org.apache.commons/commons-compress/1.26.0/jar");
				s_tDBConnection_1.put("configuration.jdbcDriver[8].path",
						"mvn:org.conscrypt/conscrypt-openjdk-uber/2.5.2/jar");
				s_tDBConnection_1.put("configuration.jdbcDriver[9].path",
						"mvn:com.google.errorprone/error_prone_annotations/2.24.1/jar");
				s_tDBConnection_1.put("configuration.jdbcDriver[10].path",
						"mvn:com.google.guava/failureaccess/1.0.1/jar");
				s_tDBConnection_1.put("configuration.jdbcDriver[11].path", "mvn:com.google.api/gax/2.43.0/jar");
				s_tDBConnection_1.put("configuration.jdbcDriver[12].path", "mvn:com.google.api/gax-grpc/2.43.0/jar");
				s_tDBConnection_1.put("configuration.jdbcDriver[13].path",
						"mvn:com.google.apis/google-api-services-bigquery/v2-rev20240211-2.0.0/jar");
				s_tDBConnection_1.put("configuration.jdbcDriver[14].path",
						"mvn:com.google.api-client/google-api-client/2.3.0/jar");
				s_tDBConnection_1.put("configuration.jdbcDriver[15].path",
						"mvn:com.google.auth/google-auth-library-credentials/1.23.0/jar");
				s_tDBConnection_1.put("configuration.jdbcDriver[16].path",
						"mvn:com.google.auth/google-auth-library-oauth2-http/1.23.0/jar");
				s_tDBConnection_1.put("configuration.jdbcDriver[17].path",
						"mvn:org.talend.libraries/GoogleBigQueryJDBC42/6.0.0-SNAPSHOT/jar");
				s_tDBConnection_1.put("configuration.jdbcDriver[18].path",
						"mvn:com.google.cloud/google-cloud-bigquerystorage/3.2.0/jar");
				s_tDBConnection_1.put("configuration.jdbcDriver[19].path",
						"mvn:com.google.cloud/google-cloud-core/2.33.0/jar");
				s_tDBConnection_1.put("configuration.jdbcDriver[20].path",
						"mvn:com.google.http-client/google-http-client/1.44.1/jar");
				s_tDBConnection_1.put("configuration.jdbcDriver[21].path",
						"mvn:com.google.http-client/google-http-client-apache-v2/1.44.1/jar");
				s_tDBConnection_1.put("configuration.jdbcDriver[22].path",
						"mvn:com.google.http-client/google-http-client-gson/1.44.1/jar");
				s_tDBConnection_1.put("configuration.jdbcDriver[23].path",
						"mvn:com.google.oauth-client/google-oauth-client/1.35.0/jar");
				s_tDBConnection_1.put("configuration.jdbcDriver[24].path",
						"mvn:org.talend.libraries/grpc-alts-1.61.1/6.0.0-SNAPSHOT/jar");
				s_tDBConnection_1.put("configuration.jdbcDriver[25].path",
						"mvn:org.talend.libraries/grpc-api-1.61.1/6.0.0-SNAPSHOT/jar");
				s_tDBConnection_1.put("configuration.jdbcDriver[26].path",
						"mvn:org.talend.libraries/grpc-auth-1.61.1/6.0.0-SNAPSHOT/jar");
				s_tDBConnection_1.put("configuration.jdbcDriver[27].path",
						"mvn:org.talend.libraries/grpc-context-1.61.1/6.0.0-SNAPSHOT/jar");
				s_tDBConnection_1.put("configuration.jdbcDriver[28].path",
						"mvn:org.talend.libraries/grpc-core-1.61.1/6.0.0-SNAPSHOT/jar");
				s_tDBConnection_1.put("configuration.jdbcDriver[29].path",
						"mvn:org.talend.libraries/grpc-googleapis-1.61.1/6.0.0-SNAPSHOT/jar");
				s_tDBConnection_1.put("configuration.jdbcDriver[30].path",
						"mvn:com.google.api.grpc/grpc-google-cloud-bigquerystorage-v1/3.2.0/jar");
				s_tDBConnection_1.put("configuration.jdbcDriver[31].path",
						"mvn:com.google.api.grpc/grpc-google-cloud-bigquerystorage-v1beta1/0.174.0/jar");
				s_tDBConnection_1.put("configuration.jdbcDriver[32].path",
						"mvn:com.google.api.grpc/grpc-google-cloud-bigquerystorage-v1beta2/0.174.0/jar");
				s_tDBConnection_1.put("configuration.jdbcDriver[33].path",
						"mvn:org.talend.libraries/grpc-grpclb-1.61.1/6.0.0-SNAPSHOT/jar");
				s_tDBConnection_1.put("configuration.jdbcDriver[34].path",
						"mvn:org.talend.libraries/grpc-inprocess-1.61.1/6.0.0-SNAPSHOT/jar");
				s_tDBConnection_1.put("configuration.jdbcDriver[35].path",
						"mvn:org.talend.libraries/grpc-netty-shaded-1.61.1/6.0.0-SNAPSHOT/jar");
				s_tDBConnection_1.put("configuration.jdbcDriver[36].path",
						"mvn:org.talend.libraries/grpc-protobuf-1.61.1/6.0.0-SNAPSHOT/jar");
				s_tDBConnection_1.put("configuration.jdbcDriver[37].path",
						"mvn:org.talend.libraries/grpc-protobuf-lite-1.61.1/6.0.0-SNAPSHOT/jar");
				s_tDBConnection_1.put("configuration.jdbcDriver[38].path",
						"mvn:org.talend.libraries/grpc-stub-1.61.1/6.0.0-SNAPSHOT/jar");
				s_tDBConnection_1.put("configuration.jdbcDriver[39].path",
						"mvn:org.talend.libraries/grpc-util-1.61.1/6.0.0-SNAPSHOT/jar");
				s_tDBConnection_1.put("configuration.jdbcDriver[40].path", "mvn:com.google.code.gson/gson/2.10.1/jar");
				s_tDBConnection_1.put("configuration.jdbcDriver[41].path", "mvn:com.google.guava/guava/32.1.3-jre/jar");
				s_tDBConnection_1.put("configuration.jdbcDriver[42].path",
						"mvn:org.apache.httpcomponents/httpclient/4.5.14/jar");
				s_tDBConnection_1.put("configuration.jdbcDriver[43].path",
						"mvn:org.apache.httpcomponents/httpcore/4.4.16/jar");
				s_tDBConnection_1.put("configuration.jdbcDriver[44].path",
						"mvn:com.google.j2objc/j2objc-annotations/2.8/jar");
				s_tDBConnection_1.put("configuration.jdbcDriver[45].path",
						"mvn:com.fasterxml.jackson.core/jackson-annotations/2.14.2/jar");
				s_tDBConnection_1.put("configuration.jdbcDriver[46].path",
						"mvn:com.fasterxml.jackson.core/jackson-core/2.14.2/jar");
				s_tDBConnection_1.put("configuration.jdbcDriver[47].path",
						"mvn:com.fasterxml.jackson.core/jackson-databind/2.14.2/jar");
				s_tDBConnection_1.put("configuration.jdbcDriver[48].path",
						"mvn:javax.annotation/javax.annotation-api/1.3.2/jar");
				s_tDBConnection_1.put("configuration.jdbcDriver[49].path", "mvn:joda-time/joda-time/2.10.10/jar");
				s_tDBConnection_1.put("configuration.jdbcDriver[50].path", "mvn:org.json/json/20240205/jar");
				s_tDBConnection_1.put("configuration.jdbcDriver[51].path",
						"mvn:com.google.code.findbugs/jsr305/3.0.2/jar");
				s_tDBConnection_1.put("configuration.jdbcDriver[52].path",
						"mvn:com.google.guava/listenablefuture/9999.0-empty-to-avoid-conflict-with-guava/jar");
				s_tDBConnection_1.put("configuration.jdbcDriver[53].path",
						"mvn:io.opencensus/opencensus-api/0.31.1/jar");
				s_tDBConnection_1.put("configuration.jdbcDriver[54].path",
						"mvn:io.opencensus/opencensus-contrib-http-util/0.31.1/jar");
				s_tDBConnection_1.put("configuration.jdbcDriver[55].path",
						"mvn:org.talend.libraries/perfmark-api-0.27.0/6.0.0-SNAPSHOT/jar");
				s_tDBConnection_1.put("configuration.jdbcDriver[56].path",
						"mvn:org.talend.libraries/protobuf-java-3.25.2/6.0.0-SNAPSHOT/jar");
				s_tDBConnection_1.put("configuration.jdbcDriver[57].path",
						"mvn:org.talend.libraries/protobuf-java-util-3.25.2/6.0.0-SNAPSHOT/jar");
				s_tDBConnection_1.put("configuration.jdbcDriver[58].path",
						"mvn:com.google.api.grpc/proto-google-cloud-bigquerystorage-v1/3.2.0/jar");
				s_tDBConnection_1.put("configuration.jdbcDriver[59].path",
						"mvn:com.google.api.grpc/proto-google-cloud-bigquerystorage-v1beta1/0.174.0/jar");
				s_tDBConnection_1.put("configuration.jdbcDriver[60].path",
						"mvn:com.google.api.grpc/proto-google-cloud-bigquerystorage-v1beta2/0.174.0/jar");
				s_tDBConnection_1.put("configuration.jdbcDriver[61].path",
						"mvn:com.google.api.grpc/proto-google-common-protos/2.34.0/jar");
				s_tDBConnection_1.put("configuration.jdbcDriver[62].path",
						"mvn:com.google.api.grpc/proto-google-iam-v1/1.29.0/jar");
				s_tDBConnection_1.put("configuration.jdbcDriver[63].path", "mvn:org.slf4j/slf4j-api/1.7.36/jar");
				s_tDBConnection_1.put("configuration.jdbcDriver[64].path", "mvn:org.threeten/threetenbp/1.6.8/jar");

				s_tDBConnection_1.put("configuration.jdbcClass", "com.simba.googlebigquery.jdbc.Driver");

				s_tDBConnection_1.put("configuration.userId", "");

				s_tDBConnection_1.put("configuration.useSharedDBConnection", "false");

				s_tDBConnection_1.put("configuration.useDataSource", "false");

				s_tDBConnection_1.put("configuration.useAutoCommit", "false");

				s_tDBConnection_1.put("configuration.__version", "-1");
				final class SchemaSettingHelper_tDBConnection_1_1 {

					public void set(final java.util.Map<String, String> configuration) throws java.lang.Exception {
					}
				}
				new SchemaSettingHelper_tDBConnection_1_1().set(configuration_tDBConnection_1);

				mgr_tDBConnection_1.findPlugin("newjdbc")
						.orElseThrow(() -> new IllegalStateException("Can't find the plugin : newjdbc"))
						.get(org.talend.sdk.component.runtime.manager.ContainerComponentRegistry.class).getServices()
						.stream().forEach(serviceMeta_tDBConnection_1 -> {
							serviceMeta_tDBConnection_1.getActions().stream()
									.filter(actionMeta_tDBConnection_1 -> "create_connection"
											.equals(actionMeta_tDBConnection_1.getType()))
									.forEach(actionMeta_tDBConnection_1 -> {
										synchronized (serviceMeta_tDBConnection_1.getInstance()) {
											org.talend.sdk.component.runtime.di.studio.RuntimeContextInjector
													.injectService(mgr_tDBConnection_1, "newjdbc",
															new org.talend.sdk.component.api.context.RuntimeContextHolder(
																	"tDBConnection_1", globalMap));

											Object connnection_tDBConnection_1 = actionMeta_tDBConnection_1.getInvoker()
													.apply(configuration_tDBConnection_1);

											globalMap.put("conn_tDBConnection_1", connnection_tDBConnection_1);

											globalMap.put("configuration_tDBConnection_1",
													configuration_tDBConnection_1);
										}
									});
						});

				/**
				 * [tDBConnection_1 begin ] stop
				 */

				/**
				 * [tDBConnection_1 main ] start
				 */

				s(currentComponent = "tDBConnection_1");

				cLabel = "BQ";

				tos_count_tDBConnection_1++;

				/**
				 * [tDBConnection_1 main ] stop
				 */

				/**
				 * [tDBConnection_1 process_data_begin ] start
				 */

				s(currentComponent = "tDBConnection_1");

				cLabel = "BQ";

				/**
				 * [tDBConnection_1 process_data_begin ] stop
				 */

				/**
				 * [tDBConnection_1 process_data_end ] start
				 */

				s(currentComponent = "tDBConnection_1");

				cLabel = "BQ";

				/**
				 * [tDBConnection_1 process_data_end ] stop
				 */

				/**
				 * [tDBConnection_1 end ] start
				 */

				s(currentComponent = "tDBConnection_1");

				cLabel = "BQ";

				if (log.isDebugEnabled())
					log.debug("tDBConnection_1 - " + ("Done."));

				ok_Hash.put("tDBConnection_1", true);
				end_Hash.put("tDBConnection_1", System.currentTimeMillis());

				/**
				 * [tDBConnection_1 end ] stop
				 */

			} // end the resume

		} catch (java.lang.Exception e) {

			if (!(e instanceof TalendException)) {
				log.fatal(currentComponent + " " + e.getMessage(), e);
			}

			TalendException te = new TalendException(e, currentComponent, cLabel, globalMap);

			throw te;
		} catch (java.lang.Error error) {

			runStat.stopThreadStat();

			throw error;
		} finally {

			try {

				/**
				 * [tDBConnection_1 finally ] start
				 */

				s(currentComponent = "tDBConnection_1");

				cLabel = "BQ";

				/**
				 * [tDBConnection_1 finally ] stop
				 */

			} catch (java.lang.Exception e) {
				// ignore
			} catch (java.lang.Error error) {
				// ignore
			}
			resourceMap = null;
		}

		globalMap.put("tDBConnection_1_SUBPROCESS_STATE", 1);
	}

	public void talendJobLogProcess(final java.util.Map<String, Object> globalMap) throws TalendException {
		globalMap.put("talendJobLog_SUBPROCESS_STATE", 0);

		final boolean execStat = this.execStat;

		String iterateId = "";

		String currentComponent = "";
		s("none");
		String cLabel = null;
		java.util.Map<String, Object> resourceMap = new java.util.HashMap<String, Object>();

		try {
			// TDI-39566 avoid throwing an useless Exception
			boolean resumeIt = true;
			if (globalResumeTicket == false && resumeEntryMethodName != null) {
				String currentMethodName = new java.lang.Exception().getStackTrace()[0].getMethodName();
				resumeIt = resumeEntryMethodName.equals(currentMethodName);
			}
			if (resumeIt || globalResumeTicket) { // start the resume
				globalResumeTicket = true;

				/**
				 * [talendJobLog begin ] start
				 */

				sh("talendJobLog");

				s(currentComponent = "talendJobLog");

				int tos_count_talendJobLog = 0;

				for (JobStructureCatcherUtils.JobStructureCatcherMessage jcm : talendJobLog.getMessages()) {
					org.talend.job.audit.JobContextBuilder builder_talendJobLog = org.talend.job.audit.JobContextBuilder
							.create().jobName(jcm.job_name).jobId(jcm.job_id).jobVersion(jcm.job_version)
							.custom("process_id", jcm.pid).custom("thread_id", jcm.tid).custom("pid", pid)
							.custom("father_pid", fatherPid).custom("root_pid", rootPid);
					org.talend.logging.audit.Context log_context_talendJobLog = null;

					if (jcm.log_type == JobStructureCatcherUtils.LogType.PERFORMANCE) {
						long timeMS = jcm.end_time - jcm.start_time;
						String duration = String.valueOf(timeMS);

						log_context_talendJobLog = builder_talendJobLog.sourceId(jcm.sourceId)
								.sourceLabel(jcm.sourceLabel).sourceConnectorType(jcm.sourceComponentName)
								.targetId(jcm.targetId).targetLabel(jcm.targetLabel)
								.targetConnectorType(jcm.targetComponentName).connectionName(jcm.current_connector)
								.rows(jcm.row_count).duration(duration).build();
						auditLogger_talendJobLog.flowExecution(log_context_talendJobLog);
					} else if (jcm.log_type == JobStructureCatcherUtils.LogType.JOBSTART) {
						log_context_talendJobLog = builder_talendJobLog.timestamp(jcm.moment).build();
						auditLogger_talendJobLog.jobstart(log_context_talendJobLog);
					} else if (jcm.log_type == JobStructureCatcherUtils.LogType.JOBEND) {
						long timeMS = jcm.end_time - jcm.start_time;
						String duration = String.valueOf(timeMS);

						log_context_talendJobLog = builder_talendJobLog.timestamp(jcm.moment).duration(duration)
								.status(jcm.status).build();
						auditLogger_talendJobLog.jobstop(log_context_talendJobLog);
					} else if (jcm.log_type == JobStructureCatcherUtils.LogType.RUNCOMPONENT) {
						log_context_talendJobLog = builder_talendJobLog.timestamp(jcm.moment)
								.connectorType(jcm.component_name).connectorId(jcm.component_id)
								.connectorLabel(jcm.component_label).build();
						auditLogger_talendJobLog.runcomponent(log_context_talendJobLog);
					} else if (jcm.log_type == JobStructureCatcherUtils.LogType.FLOWINPUT) {// log current component
																							// input line
						long timeMS = jcm.end_time - jcm.start_time;
						String duration = String.valueOf(timeMS);

						log_context_talendJobLog = builder_talendJobLog.connectorType(jcm.component_name)
								.connectorId(jcm.component_id).connectorLabel(jcm.component_label)
								.connectionName(jcm.current_connector).connectionType(jcm.current_connector_type)
								.rows(jcm.total_row_number).duration(duration).build();
						auditLogger_talendJobLog.flowInput(log_context_talendJobLog);
					} else if (jcm.log_type == JobStructureCatcherUtils.LogType.FLOWOUTPUT) {// log current component
																								// output/reject line
						long timeMS = jcm.end_time - jcm.start_time;
						String duration = String.valueOf(timeMS);

						log_context_talendJobLog = builder_talendJobLog.connectorType(jcm.component_name)
								.connectorId(jcm.component_id).connectorLabel(jcm.component_label)
								.connectionName(jcm.current_connector).connectionType(jcm.current_connector_type)
								.rows(jcm.total_row_number).duration(duration).build();
						auditLogger_talendJobLog.flowOutput(log_context_talendJobLog);
					} else if (jcm.log_type == JobStructureCatcherUtils.LogType.JOBERROR) {
						java.lang.Exception e_talendJobLog = jcm.exception;
						if (e_talendJobLog != null) {
							try (java.io.StringWriter sw_talendJobLog = new java.io.StringWriter();
									java.io.PrintWriter pw_talendJobLog = new java.io.PrintWriter(sw_talendJobLog)) {
								e_talendJobLog.printStackTrace(pw_talendJobLog);
								builder_talendJobLog.custom("stacktrace", sw_talendJobLog.getBuffer().substring(0,
										java.lang.Math.min(sw_talendJobLog.getBuffer().length(), 512)));
							}
						}

						if (jcm.extra_info != null) {
							builder_talendJobLog.connectorId(jcm.component_id).custom("extra_info", jcm.extra_info);
						}

						log_context_talendJobLog = builder_talendJobLog
								.connectorType(jcm.component_id.substring(0, jcm.component_id.lastIndexOf('_')))
								.connectorId(jcm.component_id)
								.connectorLabel(jcm.component_label == null ? jcm.component_id : jcm.component_label)
								.build();

						auditLogger_talendJobLog.exception(log_context_talendJobLog);
					}

				}

				/**
				 * [talendJobLog begin ] stop
				 */

				/**
				 * [talendJobLog main ] start
				 */

				s(currentComponent = "talendJobLog");

				tos_count_talendJobLog++;

				/**
				 * [talendJobLog main ] stop
				 */

				/**
				 * [talendJobLog process_data_begin ] start
				 */

				s(currentComponent = "talendJobLog");

				/**
				 * [talendJobLog process_data_begin ] stop
				 */

				/**
				 * [talendJobLog process_data_end ] start
				 */

				s(currentComponent = "talendJobLog");

				/**
				 * [talendJobLog process_data_end ] stop
				 */

				/**
				 * [talendJobLog end ] start
				 */

				s(currentComponent = "talendJobLog");

				ok_Hash.put("talendJobLog", true);
				end_Hash.put("talendJobLog", System.currentTimeMillis());

				/**
				 * [talendJobLog end ] stop
				 */

			} // end the resume

		} catch (java.lang.Exception e) {

			if (!(e instanceof TalendException)) {
				log.fatal(currentComponent + " " + e.getMessage(), e);
			}

			TalendException te = new TalendException(e, currentComponent, cLabel, globalMap);

			throw te;
		} catch (java.lang.Error error) {

			runStat.stopThreadStat();

			throw error;
		} finally {

			try {

				/**
				 * [talendJobLog finally ] start
				 */

				s(currentComponent = "talendJobLog");

				/**
				 * [talendJobLog finally ] stop
				 */

			} catch (java.lang.Exception e) {
				// ignore
			} catch (java.lang.Error error) {
				// ignore
			}
			resourceMap = null;
		}

		globalMap.put("talendJobLog_SUBPROCESS_STATE", 1);
	}

	public String resuming_logs_dir_path = null;
	public String resuming_checkpoint_path = null;
	public String parent_part_launcher = null;
	private String resumeEntryMethodName = null;
	private boolean globalResumeTicket = false;

	public boolean watch = false;
	// portStats is null, it means don't execute the statistics
	public Integer portStats = null;
	public int portTraces = 4334;
	public String clientHost;
	public String defaultClientHost = "localhost";
	public String contextStr = "Default";
	public boolean isDefaultContext = true;
	public String pid = "0";
	public String rootPid = null;
	public String fatherPid = null;
	public String fatherNode = null;
	public long startTime = 0;
	public boolean isChildJob = false;
	public String log4jLevel = "";

	private boolean enableLogStash;

	private boolean execStat = true;

	private ThreadLocal<java.util.Map<String, String>> threadLocal = new ThreadLocal<java.util.Map<String, String>>() {
		protected java.util.Map<String, String> initialValue() {
			java.util.Map<String, String> threadRunResultMap = new java.util.HashMap<String, String>();
			threadRunResultMap.put("errorCode", null);
			threadRunResultMap.put("status", "");
			return threadRunResultMap;
		};
	};

	protected PropertiesWithType context_param = new PropertiesWithType();
	public java.util.Map<String, Object> parentContextMap = new java.util.HashMap<String, Object>();

	public String status = "";

	private final static java.util.Properties jobInfo = new java.util.Properties();
	private final static java.util.Map<String, String> mdcInfo = new java.util.HashMap<>();
	private final static java.util.concurrent.atomic.AtomicLong subJobPidCounter = new java.util.concurrent.atomic.AtomicLong();

	public static void main(String[] args) {
		final Bigquery1 Bigquery1Class = new Bigquery1();

		int exitCode = Bigquery1Class.runJobInTOS(args);
		if (exitCode == 0) {
			log.info("TalendJob: 'Bigquery1' - Done.");
		}

		System.exit(exitCode);
	}

	private void getjobInfo() {
		final String TEMPLATE_PATH = "src/main/templates/jobInfo_template.properties";
		final String BUILD_PATH = "../jobInfo.properties";
		final String path = this.getClass().getResource("").getPath();
		if (path.lastIndexOf("target") > 0) {
			final java.io.File templateFile = new java.io.File(
					path.substring(0, path.lastIndexOf("target")).concat(TEMPLATE_PATH));
			if (templateFile.exists()) {
				readJobInfo(templateFile);
				return;
			}
		}
		readJobInfo(new java.io.File(BUILD_PATH));
	}

	private void readJobInfo(java.io.File jobInfoFile) {

		if (jobInfoFile.exists()) {
			try (java.io.InputStream is = new java.io.FileInputStream(jobInfoFile)) {
				jobInfo.load(is);
			} catch (IOException e) {

				log.debug("Read jobInfo.properties file fail: " + e.getMessage());

			}
		}
		log.info(String.format("Project name: %s\tJob name: %s\tGIT Commit ID: %s\tTalend Version: %s", projectName,
				jobName, jobInfo.getProperty("gitCommitId"), "8.0.1.20241016_1624-patch"));

	}

	public String[][] runJob(String[] args) {

		int exitCode = runJobInTOS(args);
		String[][] bufferValue = new String[][] { { Integer.toString(exitCode) } };

		return bufferValue;
	}

	public boolean hastBufferOutputComponent() {
		boolean hastBufferOutput = false;

		return hastBufferOutput;
	}

	public int runJobInTOS(String[] args) {
		// reset status
		status = "";

		String lastStr = "";
		for (String arg : args) {
			if (arg.equalsIgnoreCase("--context_param")) {
				lastStr = arg;
			} else if (lastStr.equals("")) {
				evalParam(arg);
			} else {
				evalParam(lastStr + " " + arg);
				lastStr = "";
			}
		}

		final boolean enableCBP = false;
		boolean inOSGi = routines.system.BundleUtils.inOSGi();

		if (!inOSGi) {
			if (org.talend.metrics.CBPClient.getInstanceForCurrentVM() == null) {
				try {
					org.talend.metrics.CBPClient.startListenIfNotStarted(enableCBP, true);
				} catch (java.lang.Exception e) {
					errorCode = 1;
					status = "failure";
					e.printStackTrace();
					return 1;
				}
			}
		}

		enableLogStash = "true".equalsIgnoreCase(System.getProperty("audit.enabled"));

		if (!"".equals(log4jLevel)) {

			if ("trace".equalsIgnoreCase(log4jLevel)) {
				org.apache.logging.log4j.core.config.Configurator.setLevel(log.getName(),
						org.apache.logging.log4j.Level.TRACE);
			} else if ("debug".equalsIgnoreCase(log4jLevel)) {
				org.apache.logging.log4j.core.config.Configurator.setLevel(log.getName(),
						org.apache.logging.log4j.Level.DEBUG);
			} else if ("info".equalsIgnoreCase(log4jLevel)) {
				org.apache.logging.log4j.core.config.Configurator.setLevel(log.getName(),
						org.apache.logging.log4j.Level.INFO);
			} else if ("warn".equalsIgnoreCase(log4jLevel)) {
				org.apache.logging.log4j.core.config.Configurator.setLevel(log.getName(),
						org.apache.logging.log4j.Level.WARN);
			} else if ("error".equalsIgnoreCase(log4jLevel)) {
				org.apache.logging.log4j.core.config.Configurator.setLevel(log.getName(),
						org.apache.logging.log4j.Level.ERROR);
			} else if ("fatal".equalsIgnoreCase(log4jLevel)) {
				org.apache.logging.log4j.core.config.Configurator.setLevel(log.getName(),
						org.apache.logging.log4j.Level.FATAL);
			} else if ("off".equalsIgnoreCase(log4jLevel)) {
				org.apache.logging.log4j.core.config.Configurator.setLevel(log.getName(),
						org.apache.logging.log4j.Level.OFF);
			}
			org.apache.logging.log4j.core.config.Configurator
					.setLevel(org.apache.logging.log4j.LogManager.getRootLogger().getName(), log.getLevel());

		}

		getjobInfo();
		log.info("TalendJob: 'Bigquery1' - Start.");

		java.util.Set<Object> jobInfoKeys = jobInfo.keySet();
		for (Object jobInfoKey : jobInfoKeys) {
			org.slf4j.MDC.put("_" + jobInfoKey.toString(), jobInfo.get(jobInfoKey).toString());
		}
		org.slf4j.MDC.put("_pid", pid);
		org.slf4j.MDC.put("_rootPid", rootPid);
		org.slf4j.MDC.put("_fatherPid", fatherPid);
		org.slf4j.MDC.put("_projectName", projectName);
		org.slf4j.MDC.put("_startTimestamp", java.time.ZonedDateTime.now(java.time.ZoneOffset.UTC)
				.format(java.time.format.DateTimeFormatter.ISO_INSTANT));
		org.slf4j.MDC.put("_jobRepositoryId", "_g5uT8JT-Ee-43stZsMkBDA");
		org.slf4j.MDC.put("_compiledAtTimestamp", "2024-10-28T07:31:34.049020300Z");

		java.lang.management.RuntimeMXBean mx = java.lang.management.ManagementFactory.getRuntimeMXBean();
		String[] mxNameTable = mx.getName().split("@"); //$NON-NLS-1$
		if (mxNameTable.length == 2) {
			org.slf4j.MDC.put("_systemPid", mxNameTable[0]);
		} else {
			org.slf4j.MDC.put("_systemPid", String.valueOf(java.lang.Thread.currentThread().getId()));
		}

		if (enableLogStash) {
			java.util.Properties properties_talendJobLog = new java.util.Properties();
			properties_talendJobLog.setProperty("root.logger", "audit");
			properties_talendJobLog.setProperty("encoding", "UTF-8");
			properties_talendJobLog.setProperty("application.name", "Talend Studio");
			properties_talendJobLog.setProperty("service.name", "Talend Studio Job");
			properties_talendJobLog.setProperty("instance.name", "Talend Studio Job Instance");
			properties_talendJobLog.setProperty("propagate.appender.exceptions", "none");
			properties_talendJobLog.setProperty("log.appender", "file");
			properties_talendJobLog.setProperty("appender.file.path", "audit.json");
			properties_talendJobLog.setProperty("appender.file.maxsize", "52428800");
			properties_talendJobLog.setProperty("appender.file.maxbackup", "20");
			properties_talendJobLog.setProperty("host", "false");

			System.getProperties().stringPropertyNames().stream().filter(it -> it.startsWith("audit.logger."))
					.forEach(key -> properties_talendJobLog.setProperty(key.substring("audit.logger.".length()),
							System.getProperty(key)));

			org.apache.logging.log4j.core.config.Configurator
					.setLevel(properties_talendJobLog.getProperty("root.logger"), org.apache.logging.log4j.Level.DEBUG);

			auditLogger_talendJobLog = org.talend.job.audit.JobEventAuditLoggerFactory
					.createJobAuditLogger(properties_talendJobLog);
		}

		if (clientHost == null) {
			clientHost = defaultClientHost;
		}

		if (pid == null || "0".equals(pid)) {
			pid = TalendString.getAsciiRandomString(6);
		}

		org.slf4j.MDC.put("_pid", pid);

		if (rootPid == null) {
			rootPid = pid;
		}

		org.slf4j.MDC.put("_rootPid", rootPid);

		if (fatherPid == null) {
			fatherPid = pid;
		} else {
			isChildJob = true;
		}
		org.slf4j.MDC.put("_fatherPid", fatherPid);

		if (portStats != null) {
			// portStats = -1; //for testing
			if (portStats < 0 || portStats > 65535) {
				// issue:10869, the portStats is invalid, so this client socket can't open
				System.err.println("The statistics socket port " + portStats + " is invalid.");
				execStat = false;
			}
		} else {
			execStat = false;
		}

		try {
			java.util.Dictionary<String, Object> jobProperties = null;
			if (inOSGi) {
				jobProperties = routines.system.BundleUtils.getJobProperties(jobName);

				if (jobProperties != null && jobProperties.get("context") != null) {
					contextStr = (String) jobProperties.get("context");
				}

				if (jobProperties != null && jobProperties.get("taskExecutionId") != null) {
					taskExecutionId = (String) jobProperties.get("taskExecutionId");
				}

				// extract ids from parent route
				if (null == taskExecutionId || taskExecutionId.isEmpty()) {
					for (String arg : args) {
						if (arg.startsWith("--context_param")
								&& (arg.contains("taskExecutionId") || arg.contains("jobExecutionId"))) {

							String keyValue = arg.replace("--context_param", "");
							String[] parts = keyValue.split("=");
							String[] cleanParts = java.util.Arrays.stream(parts).filter(s -> !s.isEmpty())
									.toArray(String[]::new);
							if (cleanParts.length == 2) {
								String key = cleanParts[0];
								String value = cleanParts[1];
								if ("taskExecutionId".equals(key.trim()) && null != value) {
									taskExecutionId = value.trim();
								} else if ("jobExecutionId".equals(key.trim()) && null != value) {
									jobExecutionId = value.trim();
								}
							}
						}
					}
				}
			}

			// first load default key-value pairs from application.properties
			if (isStandaloneMS) {
				context.putAll(this.getDefaultProperties());
			}
			// call job/subjob with an existing context, like: --context=production. if
			// without this parameter, there will use the default context instead.
			java.io.InputStream inContext = Bigquery1.class.getClassLoader()
					.getResourceAsStream("bigquery/bigquery1_0_1/contexts/" + contextStr + ".properties");
			if (inContext == null) {
				inContext = Bigquery1.class.getClassLoader()
						.getResourceAsStream("config/contexts/" + contextStr + ".properties");
			}
			if (inContext != null) {
				try {
					// defaultProps is in order to keep the original context value
					if (context != null && context.isEmpty()) {
						defaultProps.load(inContext);
						if (inOSGi && jobProperties != null) {
							java.util.Enumeration<String> keys = jobProperties.keys();
							while (keys.hasMoreElements()) {
								String propKey = keys.nextElement();
								if (defaultProps.containsKey(propKey)) {
									defaultProps.put(propKey, (String) jobProperties.get(propKey));
								}
							}
						}
						context = new ContextProperties(defaultProps);
					}
					if (isStandaloneMS) {
						// override context key-value pairs if provided using --context=contextName
						defaultProps.load(inContext);
						context.putAll(defaultProps);
					}
				} finally {
					inContext.close();
				}
			} else if (!isDefaultContext) {
				// print info and job continue to run, for case: context_param is not empty.
				System.err.println("Could not find the context " + contextStr);
			}
			// override key-value pairs if provided via --config.location=file1.file2 OR
			// --config.additional-location=file1,file2
			if (isStandaloneMS) {
				context.putAll(this.getAdditionalProperties());
			}

			// override key-value pairs if provide via command line like
			// --key1=value1,--key2=value2
			if (!context_param.isEmpty()) {
				context.putAll(context_param);
				// set types for params from parentJobs
				for (Object key : context_param.keySet()) {
					String context_key = key.toString();
					String context_type = context_param.getContextType(context_key);
					context.setContextType(context_key, context_type);

				}
			}
			class ContextProcessing {
				private void processContext_0() {
				}

				public void processAllContext() {
					processContext_0();
				}
			}

			new ContextProcessing().processAllContext();
		} catch (java.io.IOException ie) {
			System.err.println("Could not load context " + contextStr);
			ie.printStackTrace();
		}

		// get context value from parent directly
		if (parentContextMap != null && !parentContextMap.isEmpty()) {
		}

		// Resume: init the resumeUtil
		resumeEntryMethodName = ResumeUtil.getResumeEntryMethodName(resuming_checkpoint_path);
		resumeUtil = new ResumeUtil(resuming_logs_dir_path, isChildJob, rootPid);
		resumeUtil.initCommonInfo(pid, rootPid, fatherPid, projectName, jobName, contextStr, jobVersion);

		List<String> parametersToEncrypt = new java.util.ArrayList<String>();
		// Resume: jobStart
		resumeUtil.addLog("JOB_STARTED", "JOB:" + jobName, parent_part_launcher, Thread.currentThread().getId() + "",
				"", "", "", "", resumeUtil.convertToJsonText(context, ContextProperties.class, parametersToEncrypt));

		org.slf4j.MDC.put("_context", contextStr);
		log.info("TalendJob: 'Bigquery1' - Started.");
		java.util.Optional.ofNullable(org.slf4j.MDC.getCopyOfContextMap()).ifPresent(mdcInfo::putAll);

		if (execStat) {
			try {
				runStat.openSocket(!isChildJob);
				runStat.setAllPID(rootPid, fatherPid, pid, jobName);
				runStat.startThreadStat(clientHost, portStats);
				runStat.updateStatOnJob(RunStat.JOBSTART, fatherNode);
			} catch (java.io.IOException ioException) {
				ioException.printStackTrace();
			}
		}

		java.util.concurrent.ConcurrentHashMap<Object, Object> concurrentHashMap = new java.util.concurrent.ConcurrentHashMap<Object, Object>();
		globalMap.put("concurrentHashMap", concurrentHashMap);

		long startUsedMemory = Runtime.getRuntime().totalMemory() - Runtime.getRuntime().freeMemory();
		long endUsedMemory = 0;
		long end = 0;

		startTime = System.currentTimeMillis();

		this.globalResumeTicket = true;// to run tPreJob

		if (enableLogStash) {
			talendJobLog.addJobStartMessage();
			try {
				talendJobLogProcess(globalMap);
			} catch (java.lang.Exception e) {
				e.printStackTrace();
			}
		}

		this.globalResumeTicket = false;// to run others jobs

		try {
			errorCode = null;
			tDBConnection_1Process(globalMap);
			if (!"failure".equals(status)) {
				status = "end";
			}
		} catch (TalendException e_tDBConnection_1) {
			globalMap.put("tDBConnection_1_SUBPROCESS_STATE", -1);

			e_tDBConnection_1.printStackTrace();

		}

		this.globalResumeTicket = true;// to run tPostJob

		end = System.currentTimeMillis();

		if (watch) {
			System.out.println((end - startTime) + " milliseconds");
		}

		endUsedMemory = Runtime.getRuntime().totalMemory() - Runtime.getRuntime().freeMemory();
		if (false) {
			System.out.println((endUsedMemory - startUsedMemory) + " bytes memory increase when running : Bigquery1");
		}
		if (enableLogStash) {
			talendJobLog.addJobEndMessage(startTime, end, status);
			try {
				talendJobLogProcess(globalMap);
			} catch (java.lang.Exception e) {
				e.printStackTrace();
			}
		}

		if (execStat) {
			runStat.updateStatOnJob(RunStat.JOBEND, fatherNode);
			runStat.stopThreadStat();
		}
		if (!inOSGi) {
			if (org.talend.metrics.CBPClient.getInstanceForCurrentVM() != null) {
				s("none");
				org.talend.metrics.CBPClient.getInstanceForCurrentVM().sendData();
			}
		}

		int returnCode = 0;

		if (errorCode == null) {
			returnCode = status != null && status.equals("failure") ? 1 : 0;
		} else {
			returnCode = errorCode.intValue();
		}
		resumeUtil.addLog("JOB_ENDED", "JOB:" + jobName, parent_part_launcher, Thread.currentThread().getId() + "", "",
				"" + returnCode, "", "", "");
		resumeUtil.flush();

		org.slf4j.MDC.remove("_subJobName");
		org.slf4j.MDC.remove("_subJobPid");
		org.slf4j.MDC.remove("_systemPid");
		log.info("TalendJob: 'Bigquery1' - Finished - status: " + status + " returnCode: " + returnCode);

		return returnCode;

	}

	// only for OSGi env
	public void destroy() {
		// add CBP code for OSGI Executions
		if (null != taskExecutionId && !taskExecutionId.isEmpty()) {
			try {
				org.talend.metrics.DataReadTracker.setExecutionId(taskExecutionId, jobExecutionId, false);
				org.talend.metrics.DataReadTracker.sealCounter();
				org.talend.metrics.DataReadTracker.reset();
			} catch (Exception | NoClassDefFoundError e) {
				// ignore
			}
		}

		closeSqlDbConnections();

	}

	private void closeSqlDbConnections() {
		try {
			Object obj_conn;
			obj_conn = globalMap.remove("conn_tDBConnection_1");
			if (null != obj_conn) {
				((java.sql.Connection) obj_conn).close();
			}
		} catch (java.lang.Exception e) {
		}
	}

	private java.util.Map<String, Object> getSharedConnections4REST() {
		java.util.Map<String, Object> connections = new java.util.HashMap<String, Object>();
		connections.put("conn_tDBConnection_1", globalMap.get("conn_tDBConnection_1"));

		return connections;
	}

	private void evalParam(String arg) {
		if (arg.startsWith("--resuming_logs_dir_path")) {
			resuming_logs_dir_path = arg.substring(25);
		} else if (arg.startsWith("--resuming_checkpoint_path")) {
			resuming_checkpoint_path = arg.substring(27);
		} else if (arg.startsWith("--parent_part_launcher")) {
			parent_part_launcher = arg.substring(23);
		} else if (arg.startsWith("--watch")) {
			watch = true;
		} else if (arg.startsWith("--stat_port=")) {
			String portStatsStr = arg.substring(12);
			if (portStatsStr != null && !portStatsStr.equals("null")) {
				portStats = Integer.parseInt(portStatsStr);
			}
		} else if (arg.startsWith("--trace_port=")) {
			portTraces = Integer.parseInt(arg.substring(13));
		} else if (arg.startsWith("--client_host=")) {
			clientHost = arg.substring(14);
		} else if (arg.startsWith("--context=")) {
			contextStr = arg.substring(10);
			isDefaultContext = false;
		} else if (arg.startsWith("--father_pid=")) {
			fatherPid = arg.substring(13);
		} else if (arg.startsWith("--root_pid=")) {
			rootPid = arg.substring(11);
		} else if (arg.startsWith("--father_node=")) {
			fatherNode = arg.substring(14);
		} else if (arg.startsWith("--pid=")) {
			pid = arg.substring(6);
		} else if (arg.startsWith("--context_type")) {
			String keyValue = arg.substring(15);
			int index = -1;
			if (keyValue != null && (index = keyValue.indexOf('=')) > -1) {
				if (fatherPid == null) {
					context_param.setContextType(keyValue.substring(0, index),
							replaceEscapeChars(keyValue.substring(index + 1)));
				} else { // the subjob won't escape the especial chars
					context_param.setContextType(keyValue.substring(0, index), keyValue.substring(index + 1));
				}

			}

		} else if (arg.startsWith("--context_param")) {
			String keyValue = arg.substring(16);
			int index = -1;
			if (keyValue != null && (index = keyValue.indexOf('=')) > -1) {
				if (fatherPid == null) {
					context_param.put(keyValue.substring(0, index), replaceEscapeChars(keyValue.substring(index + 1)));
				} else { // the subjob won't escape the especial chars
					context_param.put(keyValue.substring(0, index), keyValue.substring(index + 1));
				}
			}
		} else if (arg.startsWith("--context_file")) {
			String keyValue = arg.substring(15);
			String filePath = new String(java.util.Base64.getDecoder().decode(keyValue));
			java.nio.file.Path contextFile = java.nio.file.Paths.get(filePath);
			try (java.io.BufferedReader reader = java.nio.file.Files.newBufferedReader(contextFile)) {
				String line;
				while ((line = reader.readLine()) != null) {
					int index = -1;
					if ((index = line.indexOf('=')) > -1) {
						if (line.startsWith("--context_param")) {
							if ("id_Password".equals(context_param.getContextType(line.substring(16, index)))) {
								context_param.put(line.substring(16, index),
										routines.system.PasswordEncryptUtil.decryptPassword(line.substring(index + 1)));
							} else {
								context_param.put(line.substring(16, index), line.substring(index + 1));
							}
						} else {// --context_type
							context_param.setContextType(line.substring(15, index), line.substring(index + 1));
						}
					}
				}
			} catch (java.io.IOException e) {
				System.err.println("Could not load the context file: " + filePath);
				e.printStackTrace();
			}
		} else if (arg.startsWith("--log4jLevel=")) {
			log4jLevel = arg.substring(13);
		} else if (arg.startsWith("--audit.enabled") && arg.contains("=")) {// for trunjob call
			final int equal = arg.indexOf('=');
			final String key = arg.substring("--".length(), equal);
			System.setProperty(key, arg.substring(equal + 1));
		}
	}

	private static final String NULL_VALUE_EXPRESSION_IN_COMMAND_STRING_FOR_CHILD_JOB_ONLY = "<TALEND_NULL>";

	private final String[][] escapeChars = { { "\\\\", "\\" }, { "\\n", "\n" }, { "\\'", "\'" }, { "\\r", "\r" },
			{ "\\f", "\f" }, { "\\b", "\b" }, { "\\t", "\t" } };

	private String replaceEscapeChars(String keyValue) {

		if (keyValue == null || ("").equals(keyValue.trim())) {
			return keyValue;
		}

		StringBuilder result = new StringBuilder();
		int currIndex = 0;
		while (currIndex < keyValue.length()) {
			int index = -1;
			// judege if the left string includes escape chars
			for (String[] strArray : escapeChars) {
				index = keyValue.indexOf(strArray[0], currIndex);
				if (index >= 0) {

					result.append(keyValue.substring(currIndex, index + strArray[0].length()).replace(strArray[0],
							strArray[1]));
					currIndex = index + strArray[0].length();
					break;
				}
			}
			// if the left string doesn't include escape chars, append the left into the
			// result
			if (index < 0) {
				result.append(keyValue.substring(currIndex));
				currIndex = currIndex + keyValue.length();
			}
		}

		return result.toString();
	}

	public Integer getErrorCode() {
		return errorCode;
	}

	public String getStatus() {
		return status;
	}

	ResumeUtil resumeUtil = null;
}
/************************************************************************************************
 * 71332 characters generated by Talend Real-time Big Data Platform on the 28
 * October 2024 at 1:01:34 pm IST
 ************************************************************************************************/