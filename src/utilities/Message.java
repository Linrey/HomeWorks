package utilities;

public class Message {
	private String theme;
	private String to;
	private String content;
	private int counter;
	public Message(String theme,String to,String content,int counter) {
		this.theme = theme;
		this.to = to;
		this.content = content;
		this.counter = counter;
	}
	public String getTheme() {
		return theme;
	}
	public String getTo() {
		return to;
	}
	public String getContent() {
		return content;
	}
	public int getCounter() {
		return counter;
	}
}
