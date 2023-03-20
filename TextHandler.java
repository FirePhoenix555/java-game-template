package game_template;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;

public class TextHandler extends GameObject {
	public String text;
	public int x, y;
	private Color c = Color.white;
	private Font f;
	final private static int maxWidth = 25; // in CHARACTERS not pixels
	
	public TextHandler(GameHandler gh_, String t_, int x_, int y_) {
		super(x_, y_, 0, 0);
		
		initialize(t_, x_, y_);
	}
	
	public void initialize(String t_, int x_, int y_) {
		text = t_;
		
		String temp = "";
		
		for (int i = 0; i < text.split(" ").length; i++) {
			String word = text.split(" ")[i];
			String[] lines = temp.split("\n");
			String attempt = lines[lines.length-1] + " " + word;
			
			if (attempt.length() > maxWidth) temp += "\n" + word;
			else temp += " " + word;
		}
		
		text = temp.substring(1);
		
		x = x_;
		y = y_;
	}
	
	public void setColor(Color c_) {
		c = c_;
	}
	
	public void setFont(Font f_) {
		f = f_;
	}
	
	@Override
	public void draw(Graphics2D g) {
		g.setColor(c);
		g.setFont(f);
		
		// https://stackoverflow.com/questions/4413132/problems-with-newline-in-graphics2d-drawstring
		int y_ = y;
		for (String line : text.split("\n")) {
			g.drawString(line, x, y_ += g.getFontMetrics().getHeight());
		}
	}
}
