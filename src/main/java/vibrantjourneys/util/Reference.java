package vibrantjourneys.util;

public class Reference
{
    public static final String MOD_ID = "pvj";
    public static final String NAME = "Project: Vibrant Journeys";
    public static final String CLIENT = "vibrantjourneys.ClientProxy";
    public static final String SERVER = "vibrantjourneys.ServerProxy";
    
    public static boolean isBOPLoaded = false;
    public static boolean isTraverseLoaded = false;
    public static boolean isSereneSeasonsLoaded = false;
    
    //this is used in case I need a value for some constructor that won't actually be used for that specific object
    public static final int FILLER = Integer.MAX_VALUE;
}
