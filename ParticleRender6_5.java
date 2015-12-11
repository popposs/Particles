package particlerender6_5;
import java.awt.Toolkit;
import javax.swing.JFrame;


public class ParticleRender6_5
extends JFrame
{
	public static final int WIDTH=(int)(Toolkit.getDefaultToolkit().getScreenSize().getWidth());
	public static final int HEIGHT=(int)(Toolkit.getDefaultToolkit().getScreenSize().getHeight());
	public static final int SCALE=2; 
	public static final int PARTICLECOUNT=10000;
	public static final int TICK=33;
	
	public static void main(String[] args)
	{	    
		
		JFrame frame=new JFrame("Particles");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(WIDTH, HEIGHT);
		frame.setUndecorated(true);
		frame.setResizable(false);
		frame.setFocusable(true);
		
		final RenderClass6_5 ren=new RenderClass6_5(WIDTH, HEIGHT);
		ren.spawnParticles(PARTICLECOUNT);
		frame.add(ren);
		
		frame.setVisible(true);
		
		final boolean stop=false;
		
		Thread runThread=new Thread(new Runnable()
		{
			public void run()
			{
				if(stop!=true)
				{
					for(int i=0; i<0x7fffffff ; i++) //0x7fffffff
					{
						ren.repaint();
						ren.incrementC();
						if(spawn.gate){ren.spawnLessParticles(1000); spawn.gate=!spawn.gate;}
						if(spawn.bigGate){ren.spawnLessParticles(PARTICLECOUNT); spawn.bigGate=!spawn.bigGate;}
						try{Thread.sleep(TICK);} 
						catch(Exception e)
						{
							System.out.println("Exception e at Thread.sleep");
						}
					}
				}
			}
		});
		
		runThread.start();
		
	}
	
	public void init(){}
		
		
}