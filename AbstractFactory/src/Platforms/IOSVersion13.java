package Platforms;

import Actions.IOSVersion13Action;
import Interfaces.IAction;
import Interfaces.IOptions;
import Interfaces.IPlatform;
import Interfaces.ISuperAction;
import Options.IOSVersion13Options;
import SuperActions.IOSVersion13SuperAction;

public class IOSVersion13 implements IPlatform {
    @Override
    public IAction Action() {
        return new IOSVersion13Action();
    }

    @Override
    public IOptions Options() {
        return new IOSVersion13Options();
    }

    @Override
    public ISuperAction SuperAction() {
        return new IOSVersion13SuperAction();
    }
}
