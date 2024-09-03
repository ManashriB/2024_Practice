package com.saudia.qa.util;

import org.apache.log4j.Logger;

public class Log {
	/* Intialize log4j logs */
	private static Logger log = Logger.getLogger(Log.class.getName());

	public static void startTestCAse(String startTestCAse) {
		log.info(
				"*************************************************************************************************************************");
		log.info(
				"*************************************************************************************************************************");
		log.info("$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$" + startTestCAse
				+ "$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$");
		log.info(
				"*************************************************************************************************************************");
		log.info(
				"*************************************************************************************************************************");

	}

	public static void endTestCAse(String endTestCAse) {
		log.info(
				"**************************END-----Test---Case***************************************************************************");
		log.info(
				"*************************************************************************************************************************");
		log.info(
				"*************************************************************************************************************************");
		log.info("$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$" + endTestCAse
				+ "$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$");
		log.info(
				"*************************************************************************************************************************");
		log.info(
				"*************************************************************************************************************************");

	}

	public static void info(String message) {
		try {
			log.info(message);
		} catch (Exception e) {
			e.getMessage();
		}
	}

	public static void warn(String message) {
		try {
			log.info(message);
		} catch (Exception e) {
			e.getMessage();
		}
	}

	public static void error(String message) {
		try {
			log.error(message);
		} catch (Exception e) {
			e.getMessage();
		}
	}

	public static void error(String message, Throwable t) {
		try {
			log.error(message, t);
		} catch (Exception e) {
			e.getMessage();
		}
	}

	public static void fatal(String message) {
		try {
			log.fatal(message);
		} catch (Exception e) {
			e.getMessage();
		}
	}

	public static void debug(String message) {
		try {
			log.debug(message);
		} catch (Exception e) {
			e.getMessage();
		}
	}

}
