package br.com.opah.vo;

public class NotificationVo {
	private int count;

    public NotificationVo(int count) {
        this.count = count;
    }
    public int getCount() {
        return count;
    }
    public void setCount(int count) {
        this.count = count;
    }
    public void increment() {
        this.count++;
    }
}
