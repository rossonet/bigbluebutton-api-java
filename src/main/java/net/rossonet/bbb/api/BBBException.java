package net.rossonet.bbb.api;

/**
 * Exception generated while communicating with BBB server
 *
 * see
 * https://github.com/sakaicontrib/bbb-tool/blob/master/api/src/java/org/sakaiproject/bbb/api/BBBException.java
 */
public class BBBException extends Exception {

	public static final String MESSAGEKEY_ALREADYENDED = "alreadyEnded";

	public static final String MESSAGEKEY_GENERALERROR = "generalError";
	public static final String MESSAGEKEY_HTTPERROR = "httpError";
	public static final String MESSAGEKEY_IDNOTUNIQUE = "idNotUnique";
	public static final String MESSAGEKEY_INTERNALERROR = "internalError";
	public static final String MESSAGEKEY_INVALIDRESPONSE = "invalidResponseError";
	public static final String MESSAGEKEY_NOACTION = "noActionSpecified";
	public static final String MESSAGEKEY_NOTFOUND = "notFound";
	public static final String MESSAGEKEY_NOTSTARTED = "notStarted";
	public static final String MESSAGEKEY_UNREACHABLE = "unreachableServerError";
	private static final long serialVersionUID = 2421100107566638321L;

	private String messageKey;

	public BBBException(final String messageKey, final String message) {
		super(message);
		this.messageKey = messageKey;
	}

	public BBBException(final String messageKey, final String message, final Throwable cause) {
		super(message, cause);
		this.messageKey = messageKey;
	}

	public String getMessageKey() {
		return messageKey;
	}

	public String getPrettyMessage() {
		final String _message = getMessage();
		final String _messageKey = getMessageKey();

		final StringBuilder pretty = new StringBuilder();
		if (_message != null) {
			pretty.append(_message);
		}
		if (_messageKey != null && !"".equals(_messageKey.trim())) {
			pretty.append(" (");
			pretty.append(_messageKey);
			pretty.append(")");
		}
		return pretty.toString();
	}

	public void setMessageKey(final String messageKey) {
		this.messageKey = messageKey;
	}

}