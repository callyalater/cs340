package client.catan;

import java.awt.*;

import javax.swing.*;

import client.domestic.AcceptTradeOverlay;
import client.domestic.DomesticTradeController;
import client.domestic.DomesticTradeOverlay;
import client.domestic.DomesticTradeView;
import client.maritime.MaritimeTradeController;
import client.maritime.MaritimeTradeOverlay;
import client.maritime.MaritimeTradeView;
import client.misc.WaitView;
import client.models.interfaces.IProxy;

@SuppressWarnings("serial")
public class TradePanel extends JPanel
{
	
	private DomesticTradeView domesticView;
	private DomesticTradeOverlay domesticOverlay;
	private WaitView domesticWaitView;
	private AcceptTradeOverlay domesticAcceptOverlay;
	private DomesticTradeController domesticController;
	
	private MaritimeTradeView maritimeView;
	private MaritimeTradeOverlay maritimeOverlay;
	private MaritimeTradeController maritimeController;
	
	private IProxy proxy;
	
	public TradePanel(IProxy proxy)
	{
		this.proxy = proxy;
		this.setLayout(new BoxLayout(this, BoxLayout.X_AXIS));
		
		domesticView = new DomesticTradeView();
		domesticOverlay = new DomesticTradeOverlay();
		domesticWaitView = new WaitView();
		domesticWaitView.setMessage("Waiting for Trade to Go Through");
		domesticAcceptOverlay = new AcceptTradeOverlay();
		domesticController = new DomesticTradeController(domesticView,
														 domesticOverlay,
														 domesticWaitView,
														 domesticAcceptOverlay,
														 this.proxy);
		domesticView.setController(domesticController);
		domesticOverlay.setController(domesticController);
		domesticWaitView.setController(domesticController);
		domesticAcceptOverlay.setController(domesticController);
		
		maritimeView = new MaritimeTradeView();
		maritimeOverlay = new MaritimeTradeOverlay();
		maritimeController = new MaritimeTradeController(maritimeView,
														 maritimeOverlay,
														 proxy);
		maritimeView.setController(maritimeController);
		maritimeOverlay.setController(maritimeController);
		
		this.setOpaque(true);
		this.setBackground(Color.white);
		
		this.add(Box.createHorizontalGlue());
		this.add(domesticView);
		this.add(Box.createRigidArea(new Dimension(3, 0)));
		this.add(maritimeView);
		this.add(Box.createRigidArea(new Dimension(3, 0)));
	}
	
}
