package app;

class ExtendedTime extends SimpleTime {
	private boolean is24Hours;

	private static final int TWELVE_HOURS = 12;

	public ExtendedTime(int hour, int minute, int second, boolean is24Hours) {
		super(hour, minute, second);
		this.setIs24Hours(is24Hours);
	}

	public ExtendedTime() {
		this(0, 0, 0, true);
	}

	public boolean isIs24Hours() {
		return is24Hours;
	}

	public void setIs24Hours(boolean is24Hours) {
		this.is24Hours = is24Hours;
	}

	@Override
	public String toString() {
		if (is24Hours || getHour() <= TWELVE_HOURS) {
			return super.toString();
		} else {
			return String.format("%02d:%02d:%02d", getHour() - TWELVE_HOURS, getMinute(), getSecond());
		}
	}

	public static void main(String[] args) {
		SimpleTime s = new ExtendedTime(15, 20, 30, false);
		System.out.println(s);
	}
}