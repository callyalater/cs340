package client.communication;

import java.util.List;
import java.util.*;
import java.awt.*;
import java.awt.font.*;
import java.awt.geom.*;
import javax.swing.*;

import shared.definitions.*;
import client.utils.*;

/**
 * Custom component that displays a log of messages. Used in both the chat and
 * game history views.
 */
@SuppressWarnings("serial")
public class LogComponent extends JComponent
{
	
	private int LEFT_MARGIN = 5;
	private int RIGHT_MARGIN = 5;
	private int TOP_MARGIN = 3;
	private int BOTTOM_MARGIN = 3;
	
	private Font font;
	
	private List<LogEntry> entries;
	
	public LogComponent()
	{
		this.setBackground(Color.white);
		this.setOpaque(true);
		
		Font tmpFont = new JLabel("").getFont();
		font = tmpFont.deriveFont(tmpFont.getStyle(), 24);
		
		setEntries(null);
	}
	
	public void setEntries(List<LogEntry> entries)
	{
		
		if(entries == null || entries.size() == 0)
		{
			this.entries = new ArrayList<LogEntry>();
			this.entries.add(new LogEntry(CatanColor.WHITE, "No messages"));
		}
		else
		{
			this.entries = entries;
		}
		
		Graphics2D g2 = ImageUtils.DEFAULT_IMAGE.createGraphics();
		
		int prefHeight = draw(g2);
		
		Dimension prefSize = this.getPreferredSize();
		Dimension newPrefSize = new Dimension((int)prefSize.getWidth(),
											  prefHeight);
		this.setPreferredSize(newPrefSize);
		
		this.repaint();
	}
	
	@Override
	protected void paintComponent(Graphics g)
	{
		
		super.paintComponent(g);
		
		Graphics2D g2 = (Graphics2D)g;
		
		draw(g2);
	}
	
	private int draw(Graphics2D g2)
	{
		int y = 0;
		
		FontMetrics fontMetrics = this.getFontMetrics(font);
		FontRenderContext fontContext = fontMetrics.getFontRenderContext();
		
		g2.setFont(font);
		
		//for (LogEntry entry : entries)
		for(int i = entries.size() - 1; i >= 0; i--)
		{
			
			List<String> lines = wrapText(fontContext, entries.get(i).getMessage());
			int rectHeight = TOP_MARGIN + BOTTOM_MARGIN + lines.size()
							 * fontMetrics.getHeight();
			
			g2.setColor(entries.get(i).getColor().getJavaColor());
			g2.fillRect(0, y, this.getWidth(), rectHeight);
			
			g2.setColor(Color.white);
			g2.drawRect(0, y, this.getWidth(), rectHeight);
			
			g2.setColor(Color.black);
			
			y += TOP_MARGIN + fontMetrics.getAscent();
			
			for (int j = 0; j < lines.size(); ++j)
			{
				
				if(j > 0)
				{
					y += fontMetrics.getHeight();
				}
				
				g2.drawString(lines.get(j), LEFT_MARGIN, y);
			}
			
			y += fontMetrics.getDescent() + BOTTOM_MARGIN;
		}
		
		return y;
	}
	
	private List<String> wrapText(FontRenderContext context, String text)
	{
		
		int MAX_WIDTH = this.getWidth() - LEFT_MARGIN - RIGHT_MARGIN;
		
		List<String> result = new ArrayList<String>();
		
		try(Scanner scanner = new Scanner(text))
		{
			
			scanner.useDelimiter("\\s+");
			
			String line = "";
			
			while(scanner.hasNext())
			{
				
				String word = scanner.next();
				
				if(line.length() == 0)
				{
					// Each line must have at least one word (even if
					// it doesn't fit)
					line = word;
				}
				else
				{
					// Check to see if the line can fit another word
					String newLine = line + " " + word;
					
					Rectangle2D bounds = font.getStringBounds(newLine, context);
					if(bounds.getWidth() <= MAX_WIDTH)
					{
						line = newLine;
					}
					else
					{
						result.add(line);
						line = word;
					}
				}
			}
			
			if(line.length() > 0)
			{
				result.add(line.toString());
			}
		}
		
		return result;
	}
	
}
