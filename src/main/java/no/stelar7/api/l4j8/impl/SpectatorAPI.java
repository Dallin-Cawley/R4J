package no.stelar7.api.l4j8.impl;

import no.stelar7.api.l4j8.basic.DataCall.DataCallBuilder;
import no.stelar7.api.l4j8.basic.constants.api.*;
import no.stelar7.api.l4j8.pojo.spectator.*;

import java.util.List;

public final class SpectatorAPI
{
    
    private static final SpectatorAPI INSTANCE = new SpectatorAPI();
    
    public static SpectatorAPI getInstance()
    {
        return SpectatorAPI.INSTANCE;
    }
    
    private SpectatorAPI()
    {
        // Hide public constructor
    }
    
    
    /**
     * The response object contains the FeaturedGames on the platform.
     *
     * @param server the region to execute against
     * @return Optional FeaturedGames
     */
    public List<SpectatorGameInfo> getFeaturedGames(Platform server)
    {
        DataCallBuilder builder = new DataCallBuilder().withEndpoint(URLEndpoint.V3_SPECTATOR_FEATURED)
                                                       .withPlatform(server);
        
        FeaturedGames fg = (FeaturedGames) builder.build();
        return fg.getGameList();
        
    }
    
    /**
     * The response object contains the CurrentGame of the summoner.
     *
     * @param server     the region to execute against
     * @param summonerId the summonerId
     * @return Optional FeaturedGames
     */
    public SpectatorGameInfo getCurrentGame(Platform server, long summonerId)
    {
        DataCallBuilder builder = new DataCallBuilder().withURLParameter(Constants.SUMMONER_ID_PLACEHOLDER, String.valueOf(summonerId))
                                                       .withEndpoint(URLEndpoint.V3_SPECTATOR_CURRENT)
                                                       .withPlatform(server);
        
        return (SpectatorGameInfo) builder.build();
    }
}
