package no.stelar7.api.l4j8.basic;


public class RateLimiter
{
    private final double permitsPerSec;
    
    public RateLimiter(final double permitsPerSecond)
    {
        this.permitsPerSec = permitsPerSecond;
    }
    
    public void acquire()
    {
        try
        {
            Thread.sleep((long) permitsPerSec);
        } catch (InterruptedException e)
        {
            e.printStackTrace();
        }
    }
}