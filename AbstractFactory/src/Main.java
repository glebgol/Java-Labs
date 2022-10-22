import Interfaces.IAction;
import Interfaces.IOptions;
import Interfaces.IPlatform;
import Interfaces.ISuperAction;
import Platforms.AndroidVersion12;
import Platforms.IOSVersion13;

public class Main {
    private static IPlatform platform;
    private static Version version = Version.AndroidVersion12;

    public static void main(String[] args) {

        platform = PlatformBuilder.CreatePlatform(version);

        IAction action = platform.Action();
        action.GetAction();

        IOptions option = platform.Options();
        option.GetOptions();

        ISuperAction superAction = platform.SuperAction();
        superAction.GetSuperAction();
    }
}