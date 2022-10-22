import Interfaces.IPlatform;
import Platforms.AndroidVersion12;
import Platforms.IOSVersion13;

public class Main {
    private static IPlatform platform;
    private static Version version = Version.AndroidVersion12;

    public static void main(String[] args) {
        if (version == Version.AndroidVersion12) {
            platform = new AndroidVersion12();
        }
        else if (version == Version.IOSVersion13) {
            platform = new IOSVersion13();
        }
        platform.Action().GetAction();
        platform.Options().GetOptions();
        platform.SuperAction().GetSuperAction();
    }
}