package particlerender6_5;

public class Particle 
{
    public float xPos, yPos, xVel, yVel, life;
    private int lifespan=150;
    
    public void setParticle(float xPos, float yPos, float xVel, float yVel)
    {
    	this.xPos=xPos;
    	this.yPos=yPos;
    	this.xVel=xVel;
    	this.yVel=yVel;
    	
    }
    
    public void incrementLifespan()
    {
    	lifespan--;
    }
    
    public boolean isAlive()
    {
    	return lifespan>0;
    }
	
}