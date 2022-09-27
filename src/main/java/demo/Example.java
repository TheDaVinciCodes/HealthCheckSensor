package demo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Example {

	public static void main(String[] args) {

		Logger logger = LoggerFactory.getLogger(Example.class);
		
		logger.info("Example log from {}", Example.class.getSimpleName());

		ch.qos.logback.classic.Logger parentLogger = 
				(ch.qos.logback.classic.Logger) LoggerFactory.getLogger("com.baeldung.logback");


		Logger childlogger = 
				(ch.qos.logback.classic.Logger)LoggerFactory.getLogger("com.baeldung.logback.tests");

		parentLogger.warn("This message is logged because WARN > INFO.");
		parentLogger.debug("This message is not logged because DEBUG < INFO.");
		childlogger.info("INFO == INFO");
		childlogger.debug("DEBUG < INFO");
	}
}

