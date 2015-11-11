package com.walter.lesson22;

public class Item {
	private String id, quote, speaker;

	public Item(String id, String quote, String speaker) {
		super();
		this.id = id;
		this.quote = quote;
		this.speaker = speaker;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getQuote() {
		return quote;
	}

	public void setQuote(String quote) {
		this.quote = quote;
	}

	public String getSpeaker() {
		return speaker;
	}

	public void setSpeaker(String speaker) {
		this.speaker = speaker;
	}

}
