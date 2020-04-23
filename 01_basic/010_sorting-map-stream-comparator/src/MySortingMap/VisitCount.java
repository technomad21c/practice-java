package MySortingMap;

public class VisitCount {
	private int count;
	
	public int getCount() {
		return count;
	}
	
	public void setCount(int count) {
		this.count = count;
	}
	
	public static class Builder {
		private int count;
		
		public Builder(int count) {
			this.count = count;
		}
		
		public VisitCount build() {
			return new VisitCount(this);
		}
	}
	
	private VisitCount(Builder b) {
		this.count = b.count;
	}
}
