package sampleproj.utils;

import org.apache.logging.log4j.*;
import org.apache.logging.log4j.Logger;

public class LoggerClass {

	static Logger log;

	public static Logger getLog(Class claz) {
		if (log == null) {
			return log = LogManager.getLogger(claz.getClass());
		} else {
			return log;
		}
	}

}
