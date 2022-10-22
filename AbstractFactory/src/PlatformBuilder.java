import Interfaces.IPlatform;
import Platforms.AndroidVersion12;
import Platforms.IOSVersion13;

public class PlatformBuilder {
    public static IPlatform CreatePlatform(Version version) {
        if (version == Version.AndroidVersion12) {
            return new AndroidVersion12();
        }
        else {
            return new IOSVersion13();
        }
    }
}
