package client.models;

import shared.definitions.CatanColor;
import shared.definitions.PieceType;
import shared.locations.ILocation;

public abstract class Piece implements IPiece
{
	protected IPlayer player;
	protected CatanColor color;
	protected ILocation location;

	@Override
	public ILocation getLocation()
	{
		return location;
	}

	@Override
	public void setLocation(ILocation location)
	{
		this.location = location;
	}

	@Override
	public IPlayer getPlayer()
	{
		return player;
	}

	@Override
	public void setPlayer(IPlayer player)
	{
		this.player = player;
	}

	@Override
	public abstract PieceType getPieceType();

}