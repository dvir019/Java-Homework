package app;

public class SimpleTime {
	private int hour;
	private int minute;
	private int second;

	private static final int HOURS_IN_DAY = 24;
	private static final int MINUTES_IN_HOUR = 60;
	private static final int SECONDS_IN_MINUTE = 60;
	private static final int HOUR_MIN = 0;
	private static final int HOUR_MAX = 23;
	private static final int MINUTE_MIN = 0;
	private static final int MINUTE_MAX = 59;
	private static final int SECOND_MIN = 0;
	private static final int SECOND_MAX = 59;

	public SimpleTime(int hour, int minute, int second) {
		setTime(hour, minute, second);
	}

	public SimpleTime() {
		this(0, 0, 0);
	}

	public int getSecond() {
		return second;
	}

	public void setSecond(int second) {
		// TODO - what happens if not in range
		this.second = second;
	}

	public int getMinute() {
		return minute;
	}

	public void setMinute(int minute) {
		// TODO - what happens if not in range
		this.minute = minute;
	}

	public int getHour() {
		return hour;
	}

	public void setHour(int hour) {
		// TODO - what happens if not in range
		this.hour = hour;
	}

	public void setTime(int hour, int minute, int second) {
		this.setHour(hour);
		this.setMinute(minute);
		this.setSecond(second);
	}

	public void add(SimpleTime timeToAdd) {
		addHours(timeToAdd.hour);
		addMinutes(timeToAdd.minute);
		addSeconds(timeToAdd.second);
	}

	public void addHours(int hour) {
		this.hour = (this.hour + (hour % HOURS_IN_DAY)) % HOURS_IN_DAY;
	}

	public void addMinutes(int minute) {
		addHours((this.minute + minute) / MINUTES_IN_HOUR);
		this.minute = (this.minute + (minute % MINUTES_IN_HOUR)) % MINUTES_IN_HOUR;
	}

	public void addSeconds(int second) {
		addMinutes((this.second + second) / SECONDS_IN_MINUTE);
		this.second = (this.second + (second % SECONDS_IN_MINUTE)) % SECONDS_IN_MINUTE;
	}

	public void tick() {
		addSeconds(1);
	}

	@Override
	public boolean equals(Object obj) {
		if (!(obj instanceof SimpleTime))
			return false;
		SimpleTime otherTime = (SimpleTime) obj;
		return hour == otherTime.hour && minute == otherTime.minute && second == otherTime.second;
	}

	@Override
	public String toString() {
		return String.format("%02d:%02d:%02d", hour, minute, second);
	}

	public static void main(String[] args) {
		SimpleTime s = new SimpleTime(2, 0, 10);
		SimpleTime s2 = new SimpleTime(3, 10, 55);

		s.add(s2);
		
		System.out.println(s);
	}
}