package net.rossonet.bbb.examples;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

import org.junit.jupiter.api.MethodOrderer.OrderAnnotation;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;

import net.rossonet.bbb.api.BBBException;
import net.rossonet.bbb.api.BBBMeeting;
import net.rossonet.bbb.impl.BBBAPI;
import net.rossonet.bbb.impl.BaseBBBAPI;

@TestMethodOrder(OrderAnnotation.class)
public class BBBApiTests {

	private static final String DIAL_NUMBER = "1111";
	private static final String MEETING_NAME = "test meeting";
	private static final String MEETING_PASSWORD = "password123";
	private static final String TEST_MEETING_ID = "test-123";
	private final String key = System.getenv("BBB_KEY");
	private final String url = System.getenv("BBB_URL");

	@Test
	@Order(1)
	public void createMeeting() throws BBBException {
		final BBBAPI client = new BaseBBBAPI(url, key);
		final BBBMeeting meeting = new BBBMeeting(TEST_MEETING_ID);
		meeting.setDialNumber(DIAL_NUMBER);
		meeting.setName(MEETING_NAME);
		meeting.setModeratorPW(MEETING_PASSWORD);
		final BBBMeeting result = client.createMeeting(meeting);
		System.out.println("meeting -> " + result);
		assertEquals(MEETING_NAME, result.getName());
		assertEquals(DIAL_NUMBER, result.getDialNumber());
		assertEquals(TEST_MEETING_ID, result.getMeetingID());
	}

	@Test
	@Order(3)
	public void deleteMeeting() throws BBBException {
		final BBBAPI client = new BaseBBBAPI(url, key);
		final boolean result = client.endMeeting(TEST_MEETING_ID, MEETING_PASSWORD);
		assertTrue(result);
	}

	@Test
	@Order(2)
	public void listMeetings() throws BBBException {
		final BBBAPI client = new BaseBBBAPI(url, key);
		final Map<String, Object> meetings = client.getMeetings();
		boolean foundTestMeeting = false;
		for (final Entry<String, Object> m : meetings.entrySet()) {
			System.out.println(m.getKey() + " -> " + m.getValue() + " [" + m.getValue().getClass() + "]");
			if (m.getValue() instanceof ArrayList) {
				@SuppressWarnings("unchecked")
				final HashMap<String, String> reply = ((ArrayList<HashMap>) m.getValue()).get(0);
				if (reply.containsKey("meetingID") && reply.get("meetingID").equals(TEST_MEETING_ID)) {
					foundTestMeeting = true;
				}
			}
		}
		assertTrue(foundTestMeeting);
	}

}
