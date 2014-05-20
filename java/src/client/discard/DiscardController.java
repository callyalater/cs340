package client.discard;

import shared.definitions.*;
import client.base.*;
import client.misc.*;
import client.models.ICatanModelObserver;
import client.models.IProxy;


/**
 * Discard controller implementation
 */
public class DiscardController extends Controller implements IDiscardController,
															 ICatanModelObserver
{

	private IWaitView waitView;
	private IProxy proxy;

	/**
	 * DiscardController constructor
	 *
	 * @param view View displayed to let the user select cards to discard
	 * @param waitView View displayed to notify the user that they are waiting for other players to discard
	 */
	public DiscardController(IDiscardView view, IWaitView waitView)
	{
		super(view);

		this.waitView = waitView;
	}
	
	public void setProxy(IProxy proxy)
	{
		this.proxy = proxy;
		proxy.getFacade().registerAsObserver(this);
	}

	public IDiscardView getDiscardView()
	{
		return (IDiscardView)super.getView();
	}

	public IWaitView getWaitView()
	{
		return waitView;
	}

	/**
	 * This method is called when the user increases the amount of the specified
	 * resource.
	 *
	 * @param resource
	 *            The resource that was increased
	 */
	@Override
	public void increaseAmount(ResourceType resource)
	{
		proxy.getFacade();
	}

	/**
	 * This method is called when the user decreases the amount of the specified
	 * resource.
	 *
	 * @param resource
	 *            The resource that was decreased
	 */
	@Override
	public void decreaseAmount(ResourceType resource)
	{
		
	}

	/**
	 * This method is called when the user clicks the discard button.
	 */
	@Override
	public void discard()
	{
		getDiscardView().closeModal();
	}

	
	@Override
	public void update()
	{
		
	}
}

