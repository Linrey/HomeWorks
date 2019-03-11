package utilities;

public class MessageBuilder {
	private String theme;
	private String to;
	private String content;
	private int counter;
	public void setTheme(String theme) {
		this.theme = theme;
	}
	public void setTo(String to) {
		this.to = to;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public void setCounter(int counter) {
		this.counter = counter;
	}
	public Message Build() {
		return new Message(theme,to,content,counter);
	}
}
