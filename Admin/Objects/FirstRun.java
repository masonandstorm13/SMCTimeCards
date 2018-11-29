package Objects;

public class FirstRun {
	
	public Boolean hintText;
	
	public FirstRun() {
		this.hintText = null;
	}
	
	public FirstRun(Boolean hintText) {
		this.hintText = hintText;
	}
	
	public void setHintText(Boolean hintText) {
		this.hintText = hintText;
	}
	
	public Boolean getHintText() {
		return this.hintText;
	}
}
